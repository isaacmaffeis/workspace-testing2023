asm darts

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	enum domain Bersaglio = {RED | GREEN | OUT}
	enum domain Giocatori = {GIO1 | GIO2 | GIO3}
	enum domain Status = {IN_GAME | GAME_OVER}
	enum domain Direzione = {UP|DOWN}
	enum domain Velocita = {FAST | SLOW}
	
	domain Soldi subsetof Integer
	domain Players subsetof Integer

	// FUNCTIONS
	controlled turno : Giocatori -> Boolean
	controlled freccetta: Giocatori -> Bersaglio
	controlled soldi: Giocatori -> Soldi
	controlled status : Giocatori -> Status
	controlled players : Players

	monitored direzione : Giocatori -> Direzione
	monitored velocita: Giocatori -> Velocita
	
	derived gameOver: Boolean
	

definitions:
	// DOMAIN DEFINITIONS
	domain Soldi = {0:30}
	domain Players = {0:3}

	// FUNCTION DEFINITIONS
	//function gameOver = (exist $g in Giocatori with soldi($g) = 30)
	function gameOver = (players = 1)

	// RULE DEFINITIONS
	rule r_red($g in Giocatori) =
		par
			freccetta($g) := RED
			if players = 3 then
				if $g = GIO1 then
					if soldi(GIO2) > 1 and soldi(GIO3) > 1 then soldi($g) := soldi($g) + 4
					else if soldi(GIO2) = 1 and soldi(GIO3) > 1 then soldi($g) := soldi($g) + 3
					else if soldi(GIO2) > 1 and soldi(GIO3) = 1 then soldi($g) := soldi($g) + 3
					else  soldi($g) := soldi($g) + 2 endif endif endif
				else if $g = GIO2 then
					if soldi(GIO1) > 1 and soldi(GIO3) > 1 then soldi($g) := soldi($g) + 4
					else if soldi(GIO1) = 1 and soldi(GIO3) > 1 then soldi($g) := soldi($g) + 3
					else if soldi(GIO1) > 1 and soldi(GIO3) = 1 then soldi($g) := soldi($g) + 3
					else  soldi($g) := soldi($g) + 2 endif endif endif
				else 
					if soldi(GIO1) > 1 and soldi(GIO2) > 1 then soldi($g) := soldi($g) + 4
					else if soldi(GIO1) = 1 and soldi(GIO2) > 1 then soldi($g) := soldi($g) + 3
					else if soldi(GIO1) > 1 and soldi(GIO2) = 1 then soldi($g) := soldi($g) + 3
					else  soldi($g) := soldi($g) + 2 endif endif endif
				endif endif
			else
				choose $r in Giocatori with $r != $g and status($r) = IN_GAME do 
						if soldi($r) > 1 then 
							soldi($g) := soldi($g) + 2
						else 
							soldi($g) := soldi($g) + 1
						endif
			endif
			forall $h in Giocatori with $h != $g and status($h) = IN_GAME do
				if soldi($h) <= 2 then 
					par
						soldi($h) := 0
						status($h) := GAME_OVER
						players := players - 1
					endpar
				else
					soldi($h) := soldi($h) - 2
				endif
		endpar
	
	rule r_green($g in Giocatori) =
		par
			freccetta($g) := GREEN
			soldi($g) := soldi($g) + (players - 1)
			forall $h in Giocatori with $h != $g and status($h) = IN_GAME do
				par
					if soldi($h) = 1 then 
						par
							status($h) := GAME_OVER
							players := players - 1
						endpar
					endif
					soldi($h) := soldi($h) - 1
				endpar
		endpar
	
	rule r_out($g in Giocatori) =
		par
			freccetta($g) := OUT
			if soldi($g) - (players - 1) >= 0 then
				par
					if soldi($g) - (players - 1) = 0 then 
						par
							status($g) := GAME_OVER 
							players := players - 1
						endpar 
					endif
					soldi($g) := soldi($g) - (players - 1)
					forall $h in Giocatori with $h != $g and status($h) = IN_GAME do
						soldi($h) := soldi($h) + 1
				endpar
			else
				par
					soldi($g) := 0
					status($g) := GAME_OVER
					players := players - 1
					choose $j in Giocatori with $j != $g and status($j) = IN_GAME do
						soldi($j) := soldi($j) + 1
				endpar	
			endif
		endpar
	
	rule r_lancio($g in Giocatori) = 
		if velocita($g) = SLOW then 
			r_out[$g] 
		else
			if direzione($g) = DOWN then 
				r_green[$g]
			else 
				r_red[$g]
			endif
		endif
		
	rule r_turno($g in Giocatori) =
		switch $g
			case GIO1:
				par
					turno($g) := false
					if soldi(GIO2)>0 then
						turno(GIO2) := true
					else
						turno(GIO3) := true
					endif
				endpar
			case GIO2:
				par
					turno($g) := false
					if soldi(GIO3)>0 then
						turno(GIO3) := true
					else
						turno(GIO1) := true
					endif
				endpar
			case GIO3:
				par
					turno($g) := false
					if soldi(GIO1)>0 then
						turno(GIO1) := true
					else
						turno(GIO2) := true
					endif
				endpar
			endswitch
		
	// INVARIANTS
	invariant inv_soldi over soldi: (forall $g in Giocatori with soldi($g) >= 0)
	
	// 1
	CTLSPEC ef((exist $g in Giocatori with soldi($g) = 0))
	
	//2
	CTLSPEC ef((forall $g in Giocatori with soldi($g) = 9 implies ex(soldi($g) = 11)))
	
	//3
	CTLSPEC ag((forall $g in Giocatori with soldi($g) = 0 implies ax(soldi($g) = 0)))
	
	//4
	CTLSPEC ag((forall $g in Giocatori with soldi($g) <= 30))
	
	//5
	CTLSPEC ef(gameOver)

	// MAIN RULE
	main rule r_Main =
		if gameOver then 
			skip 
		else
			choose $g in Giocatori with turno($g) = true do
				par
					r_lancio[$g]
					r_turno[$g]
				endpar
		endif


// INITIAL STATE
default init s0:
	function soldi($g in Giocatori) = 10
	function turno($g in Giocatori) = if $g = GIO1 then true else false endif 
	function status($g in Giocatori) = IN_GAME
	function players = 3
