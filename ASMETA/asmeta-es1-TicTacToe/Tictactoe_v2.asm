asm Tictactoe_v2

import StandardLibrary
import CTLlibrary

//board is Prod(Coord, Coord)

signature:
	domain Coord subsetof Integer
	enum domain Sign = {CROSS | NOUGHT | EMPTY}
	enum domain ResultDomain = {PLAYER | PC | TIE | RUN}
	enum domain Status = {TURN_USER | CHECK_USER | TURN_PC | CHECK_PC | GAMEOVER}
	controlled board: Prod(Coord, Coord) -> Sign 
	controlled status: Status 

	monitored userChoiceX: Coord 
	monitored userChoiceY: Coord 
	controlled winner: ResultDomain 
	derived noSquareLeft: Boolean

definitions:
	domain Coord = {1:3}
 
	function noSquareLeft =
//				board(1, 1) != EMPTY and board(1, 2) != EMPTY and board(1, 3) != EMPTY and
//				board(2, 1) != EMPTY and board(2, 2) != EMPTY and board(2, 3) != EMPTY and
//				board(3, 1) != EMPTY and board(3, 2) != EMPTY and board(3, 3) != EMPTY
		(forall $x in Coord, $y in Coord with board($x, $y) != EMPTY)
		

	rule r_moveUser =
       if   board(userChoiceX,userChoiceY) = EMPTY then
				par
					board(userChoiceX,userChoiceY) := CROSS
					status := CHECK_USER
				endpar
		endif
			
	rule r_movePC =
		choose $x in Coord, $y in Coord with board($x, $y)=EMPTY do
			par
				board($x, $y):=  NOUGHT
				status := CHECK_PC
			endpar

	//check a winning combination
	rule r_checkBoard($sign in Sign) =
		if(		(board(1, 1) = $sign and board(1, 2) = $sign and board(1, 3) = $sign) or
				(board(2, 1) = $sign and board(2, 2) = $sign and board(2, 3) = $sign) or
				(board(3, 1) = $sign and board(3, 2) = $sign and board(3, 3) = $sign) or
				(board(1, 1) = $sign and board(2, 1) = $sign and board(3, 1) = $sign) or
				(board(1, 2) = $sign and board(2, 2) = $sign and board(3, 2) = $sign) or
				(board(1, 3) = $sign and board(2, 3) = $sign and board(3, 3) = $sign) or
				(board(1, 1) = $sign and board(2, 2) = $sign and board(3, 3) = $sign) or
				(board(1, 3) = $sign and board(2, 2) = $sign and board(3, 1) = $sign) ) then
			par
				status := GAMEOVER
				if($sign = CROSS) then
					winner := PLAYER
				else
					winner := PC
				endif
			endpar
		else
			if(noSquareLeft) then
				par
					winner := TIE
					status := GAMEOVER
				endpar
			else
				if($sign = CROSS) then
					status := TURN_PC
				else
					status := TURN_USER
				endif
			endif
		endif

	//AsmetaL invariant
	invariant over winner: winner=TIE implies noSquareLeft

	//CTL properties
 	CTLSPEC ef(noSquareLeft) // exists a state in which all squares are occupied
 	CTLSPEC ef(winner=PLAYER)
 	CTLSPEC ef(winner=PC) 
 	CTLSPEC ag(not(winner=PC)) // to get a path bringing to the win of the PC
 	// EF(phi) is true iff AG(not(phi)) is false
 	
 	CTLSPEC ag(noSquareLeft implies ag(noSquareLeft))
	CTLSPEC ef(winner=TIE) //a play can be tie
 	CTLSPEC ef(winner=PC)  // PC can win
 	CTLSPEC ef(winner=PLAYER) //user can win
 	
 	CTLSPEC ag(winner=TIE implies noSquareLeft)
 	//CTLSPEC ag(noSquareLeft implies winner=TIE) //false. one can win at the last move
  	CTLSPEC ag( (
						(board(1, 1)!=EMPTY and board(1, 1)=board(1, 2) and board(1, 2)=board(1, 3)) or
						(board(2, 1)!=EMPTY and board(2, 1)=board(2, 2) and board(2, 2)=board(2, 3)) or
						(board(3, 1)!=EMPTY and board(3, 1)=board(3, 2) and board(3, 2)=board(3, 3)) or
						(board(1, 1)!=EMPTY and board(1, 1)=board(1, 2) and board(1, 2)=board(1, 3)) or
						(board(2, 1)!=EMPTY and board(2, 1)=board(2, 2) and board(2, 2)=board(2, 3)) or
						(board(3, 1)!=EMPTY and board(3, 1)=board(3, 2) and board(3, 2)=board(3, 3)) or
						(board(1, 1)!=EMPTY and board(1, 1)=board(2, 2) and board(2, 2)=board(3, 3)) or
						(board(1, 3)!=EMPTY and board(1, 3)=board(2, 2) and board(2, 2)=board(3, 1))
						)
						implies ax(ag(status = GAMEOVER))
						)
 
	main rule r_Main =
		switch(status)
			case TURN_USER: r_moveUser[]
			case CHECK_USER: r_checkBoard[CROSS]
			case TURN_PC: r_movePC[]
			case CHECK_PC: r_checkBoard[NOUGHT]
		endswitch

default init s0:
	function board($x in Coord, $y in Coord) = EMPTY
	function winner = RUN
	function status = TURN_USER