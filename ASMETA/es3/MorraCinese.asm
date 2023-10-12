// a simple example with a tic tac toe game

asm MorraCinese

import ../StandardLibrary
import ../CTLlibrary

signature:
	enum domain Sign = {ROCK | CISSOR | PAPER}
	enum domain Status = {WORKING | GAME_OVER}
	enum domain Result = {TIE | USER_WIN | PC_WIN}
	enum domain Winner = {USER | PC}
	
	domain Matches subsetof Integer
	
	controlled pc_choice: Sign
	controlled status: Status
//	controlled result: Result
	controlled winner: Winner
	controlled user_stats: Matches
	controlled pc_stats: Matches
	controlled match_number: Matches
	
	monitored user_choice: Sign
	
	static max_match: Matches
	
	derived tie: Boolean
	derived userWin: Boolean
	derived userWinner: Boolean
	
definitions:

	domain Matches = {0: 5}

	function max_match = 4
	function tie = user_choice = pc_choice
	function userWin = 
			(user_choice = ROCK and pc_choice = CISSOR) or 
			(user_choice = CISSOR and pc_choice = PAPER) or 
			(user_choice = PAPER and pc_choice = ROCK)  
	function userWinner = user_stats > pc_stats
			
	rule r_game =
		if(tie) then result := TIE
		else if(userWin) then 
			par
				result := USER_WIN
				user_stats:= user_stats + 1
			endpar
		else
			par
				result := PC_WIN
				pc_stats := pc_stats + 1
			endpar
		endif
		endif
		
	invariant inv_match over match_number: match_number >= (user_stats + pc_stats)
	
	CTLSPEC ef(status = GAME_OVER)
	CTLSPEC ef(winner = USER)
	CTLSPEC ef(winner = PC)
	
	CTLSPEC ag(status = GAME_OVER implies match_number >= max_match)
	CTLSPEC ag(winner = USER implies (user_stats > pc_stats))
	CTLSPEC ag(winner = PC implies (user_stats < pc_stats))

	main rule r_morraCinese =
		switch status
			case WORKING:
				if(match_number < max_match or user_stats = pc_stats) then 
					choose $s in Sign with true do
						par
							pc_choice := $s
							r_game[]
							match_number := match_number + 1
						endpar	
				else
					status := GAME_OVER
				endif
			case GAME_OVER:
				if userWinner then winner := USER
				else winner := PC
				endif
		endswitch
			
	
default init s0:
	function status = WORKING
	function pc_choice = CISSOR
	function user_stats = 0
	function pc_stats = 0
	function match_number = 0
	