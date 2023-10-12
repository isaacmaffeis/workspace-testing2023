asm Dadi

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	domain Dado subsetof Integer
	domain Soldi subsetof Integer
	enum domain Vincitore = {WINUSER | WINPC}

	// FUNCTIONS
	controlled soldiPc : Soldi
	controlled soldiGiocatore : Soldi
	controlled vincitore: Vincitore
	
	monitored mossaGiocatore: Dado
	
	derived isGameOver: Boolean
	

definitions:
	// DOMAIN DEFINITIONS
	domain Dado = {1:6}
	domain Soldi = {0:10}
	
	// FUNCTION DEFINITIONS
	function isGameOver = (soldiPc = 0 or soldiGiocatore = 0)

	// RULE DEFINITIONS
	rule r_giocoDadi =
		choose $d in Dado with true do 
			if $d = mossaGiocatore then skip
			else if $d > mossaGiocatore then
				par
					soldiPc:= soldiPc + 1
					soldiGiocatore := soldiGiocatore - 1
				endpar
			else
				par
					soldiPc:= soldiPc - 1
					soldiGiocatore := soldiGiocatore + 1
				endpar
			endif
			endif
	
	rule r_vincitore =
		if soldiPc = 0 then vincitore := WINUSER else vincitore := WINPC endif

	// INVARIANTS

	// MAIN RULE
	main rule r_Main =
		if not isGameOver then
			r_giocoDadi[]
		else
			r_vincitore[]
		endif

// INITIAL STATE
default init s0:
	function soldiPc = 5
	function soldiGiocatore = 5
