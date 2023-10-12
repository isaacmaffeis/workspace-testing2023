// a simple example with a tic tac toe game

asm PariDispari

import ../StandardLibrary

signature:
	// DOMAINS
	enum domain Segno = {PARI | DISPARI}
	enum domain Status = {SETUP | IN_GAME | GAME_OVER}
	domain Numero subsetof Integer
	domain Soldi subsetof Integer
	
	// FUNCTIONS
	controlled segnoPc : Segno
	controlled numeroPc : Numero
	controlled status : Status
	controlled soldiPc: Soldi
	controlled soldiUtente: Soldi
	
	monitored segnoUtente: Segno
	monitored numeroUtente: Numero

	static gameOver : Boolean
	static vinceUtente : Prod(Numero,Numero) -> Boolean	
	
definitions:
	// DOMAIN DEFINITIONS
	domain Numero = {1:5}
	domain Soldi = {0:10}
	
	// FUNCTION DEFINITIONS
	function gameOver = (soldiUtente = 0) or (soldiPc = 0)
	function vinceUtente($u in Numero,$p in Numero) = ((idiv($u + $p,2) = 0) and segnoPc = DISPARI) 
		or ((idiv($u + $p,2) != 0) and segnoPc = PARI)

	// RULE DEFINITIONS
	rule r_game =
		if gameOver 
			then status := GAME_OVER 
		else
			choose $p in Numero with true do 
			par
				numeroPc := $p
				result := $p + numeroUtente
				if vinceUtente(numeroUtente,$p) then
					par
						soldiUtente := soldiUtente + 1
						soldiPc := soldiPc - 1
					endpar
				else
					par
						soldiUtente := soldiUtente - 1
						soldiPc := soldiPc + 1
					endpar 
				endif
			endpar
		endif

	// INVARIANTS

	// MAIN RULE
	main rule r_Main =
		switch status
		case SETUP:
			par
				if segnoUtente = PARI then
					segnoPc := DISPARI 
				else 
					segnoPc := PARI 
				endif
				status := IN_GAME
			endpar
		case IN_GAME:
			r_game[]
		case GAME_OVER:
			skip
		endswitch

// INITIAL STATE
default init s0:
	function status = SETUP
	function soldiPc = 5
	function soldiUtente = 5
	function numeroPc = 2
	function result = 0