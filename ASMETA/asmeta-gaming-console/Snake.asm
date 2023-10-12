/* SNAKE GAME
 * 
 * the goal of the game is to eat the apples and
 * avoid the walls or the body
 * 
 * Starting Board:
 * (W = WALL, B = BODY, H, HEAD, A = APPLE)
 * W W W W W W    (1,1) (1,2) (1,3) (1,4) (1,5) (1,6)
 * W B H     W    (2,1)   B     H               (2,6)
 * W     A   W    (3,1)               A         (3,6)
 * W         W    (4,1)                         (4,6)
 * W         W    (5,1)                         (5,6)
 * W W W W W W    (6,1) (6,2) (6,3) (6,4) (6,5) (6,6)
 * 
 * Commands: UP, DOWN, RIGHT, LEFT
 * for example, to reach the first apple, select RIGHT 
 * as the first direction and DOWN as the second
 * 
 * the score increases every time the HEAD eats an apple
 * 
 * the body follows the entire path of the head
 * in a future version could be implemented the rule
 * of limiting the body to eaten apples
 * 
 */

asm Snake

import StandardLibrary
import CTLlibrary

signature:
	// DOMAINS
	domain Coord subsetof Integer
	domain Score subsetof Integer // for CTL
	enum domain Sign = {WALL |HEAD| BODY | APPLE }
	enum domain Status = {SETUP | IN_GAME | GAME_OVER}
	enum domain Direction = {UP | DOWN | RIGHT | LEFT}
	// FUNCTIONS
	controlled board: Prod(Coord, Coord) -> Sign
	controlled status: Status
	//controlled score: Integer
	controlled score: Score // for CTL
	controlled headx: Coord
	controlled heady: Coord
	controlled applex: Coord
	controlled appley: Coord
	//controlled message: String
	monitored userChoice: Direction

definitions:
	// DOMAIN DEFINITIONS
	domain Coord = {1 : 6}
	domain Score = {0 : 5} // for CTL

	// FUNCTION DEFINITIONS
		
	// RULE DEFINITIONS
	rule r_setWalls =
		par
			forall $x1 in {1 : 5} do board($x1,6) := WALL
			forall $x2 in {2 : 6} do board($x2,1) := WALL
			forall $y1 in {1 : 5} do board(1,$y1) := WALL
			forall $y2 in {2 : 6} do board(6,$y2) := WALL
		endpar
	
	rule r_setHead =
		par
			headx := 2
			heady := 3
			board(2,3) := HEAD
		endpar
	
	rule r_setBody =
		board(2,2) := BODY
		
	rule r_setFirstApple =
		par
			board(3,4) := APPLE
			applex := 3
			appley := 4
		endpar
	
	rule r_newApple =
		// choose an empty place
		choose $x in Coord, $y in Coord with isUndef(board($x, $y)) do
			par
				board($x,$y) := APPLE
				applex := $x
				appley := $y
				board(applex,appley):=APPLE
			endpar
		
	rule r_checkApple($xHead in Coord, $yHead in Coord) = 
		// if the head eats the apple
		if board($xHead,$yHead) = APPLE then 
			par
				// increases the score
				score := score + 1
				// places a new apple
				r_newApple[]
			endpar
		endif
	
	rule r_moveHead =
		let ($d = userChoice) in 
			switch($d) // user direction choice
				case UP:
					// check if it hits the top wall or eats the body
					if (headx = 2 or board(headx-1,heady) = BODY) then status := GAME_OVER
					else
						par
							// update the head position
							board(headx,heady) := BODY
							board(headx-1,heady) := HEAD
							headx := headx - 1
							// check if it eats the apple
							r_checkApple[headx-1,heady]
						endpar
					endif
				case DOWN:
					// check if it hits the bottom wall or eats the body
					if (headx = 5 or board(headx+1,heady) = BODY) then status := GAME_OVER
					else
						par
							// update the head position
							board(headx,heady) := BODY
							board(headx+1,heady) := HEAD
							headx := headx + 1
							// check if it eats the apple
							r_checkApple[headx+1,heady]
						endpar
					endif
				case LEFT: 
					// check if it hits the left wall or eats the body
					if (heady = 2 or board(headx,heady-1) = BODY) then status := GAME_OVER
					else
						par
							// update the head position
							board(headx,heady) := BODY
							board(headx,heady-1) := HEAD
							heady := heady - 1
							// check if it eats the apple
							r_checkApple[headx,heady-1]
						endpar
					endif
				case RIGHT:
					// check if it hits the right wall or eats the body
					if (heady = 5 or board(headx,heady+1) = BODY) then status := GAME_OVER
					else
						par
							// update the head position
							board(headx,heady) := BODY
							board(headx,heady+1) := HEAD
							heady := heady + 1
							// check if it eats the apple
							r_checkApple[headx,heady+1]
						endpar
					endif
			endswitch
		endlet

	// INVARIANTS
	// the score must be always >= 0 (or undefined in s0)
	invariant inv_score_positive over score:  score = undef or score >= 0
	// the coordinates of the apple must always be different from those of the head
	invariant inv_apple_head over board: 
		(applex = undef and appley=undef) or not
		(board(applex,appley) = board(headx,heady))
	// the coordinates of the apple must always be different from those of the walls
	invariant inv_apple_wall over board:
		(applex = undef and appley=undef) or (
		not(exist $x1 in Coord with applex = $x1 and appley = 1) or 
		not(exist $x2 in Coord with applex = $x2 and appley = 6) or 
		not(exist $y1 in Coord with applex = 1 and appley = $y1) or 
		not(exist $y2 in Coord with applex = 6 and appley = $y2))
		
	// CTL properties
	// Reachability Property
	// exists a future state satisfying a property φ
	CTLSPEC ef(status=SETUP)
	CTLSPEC ef(status=IN_GAME)
	CTLSPEC ef(status=GAME_OVER)
	CTLSPEC ef(board(3,4)=APPLE)
	CTLSPEC ef(score > 0)
	
	// Safety property
	// “Nothing bad will happen”
	CTLSPEC ag(not(status=SETUP and status=IN_GAME))
	CTLSPEC ag(not(status=IN_GAME and status=GAME_OVER))
	CTLSPEC ag(not(applex=undef and appley=undef) implies not(applex=headx and appley=heady))   // apple coords must always be different from those of the head
	CTLSPEC ag(not (status=IN_GAME) or (board(1,1)=WALL and (board(1,2)=WALL) and (board(1,3)=WALL) 
		and (board(1,4)=WALL) and (board(1,5)=WALL))) // top borders must always be walls in status=IN_GAME
	CTLSPEC ag(not (status=IN_GAME) or (board(2,1)=WALL and (board(3,1)=WALL) and (board(4,1)=WALL) 
		and (board(5,1)=WALL) and (board(6,1)=WALL))) // left borders must always be walls in status=IN_GAME
	CTLSPEC ag(not (status=IN_GAME) or (board(6,2)=WALL and (board(6,3)=WALL) and (board(6,4)=WALL) 
		and (board(6,5)=WALL) and (board(6,6)=WALL))) // bottom borders must always be walls in status=IN_GAME
	CTLSPEC ag(not (status=IN_GAME) or (board(1,6)=WALL and (board(2,6)=WALL) and (board(3,6)=WALL) 
		and (board(4,6)=WALL) and (board(5,6)=WALL))) // right borders must always be walls in status=IN_GAME
	
	// Liveness property
	// “Something good will eventually happen”
	CTLSPEC ag((not(board(3,4)=HEAD) and not isUndef(board(3,4))) implies score > 0) // snake ate the first apple
	
	// MAIN RULE
	main rule r_Main =
		switch status
			case SETUP:
				par
					r_setWalls[]
					r_setHead[]
					r_setBody[]
					r_setFirstApple[]
					score:= 0
					status := IN_GAME
				endpar
			case IN_GAME:
				r_moveHead[]
			//case GAME_OVER:
				//message := concat("Game Over, your score: ",toString(score))
		endswitch

// INITIAL STATE
default init s0:
	function status = SETUP
