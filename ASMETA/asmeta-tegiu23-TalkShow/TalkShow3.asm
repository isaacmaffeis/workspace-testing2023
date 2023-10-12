asm TalkShow3

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	enum domain Stato = {ASCOLTARE | IN_ATTESA | PARLARE}
	enum domain Moderatrice = {PARLA | DA_PAROLA | ASCOLTA}
	enum domain Microfono = {ON | OFF}
	
	domain Persone subsetof Integer
	domain Tempo subsetof Integer
	// FUNCTIONS
	controlled stato : Persone -> Stato
	controlled moderatrice : Moderatrice
	controlled microfono: Persone -> Microfono
	controlled microfonoModeratrice: Microfono
	controlled tempoParlare: Persone -> Tempo
	controlled tempoAttesa: Persone -> Tempo
	
	static maxTempoAttesa: Tempo
	static maxTempoParlare: Tempo
	
	derived richiesta: Boolean
	derived finitoParlare: Boolean

definitions:
	// DOMAIN DEFINITIONS
	domain Persone = {1:6}
	domain Tempo = {0:7}
	
	// FUNCTION DEFINITIONS
	function maxTempoAttesa = 7
	function maxTempoParlare = 5
	
	function richiesta = (exist $p in Persone with stato($p) = IN_ATTESA)
	function finitoParlare = (exist $p in Persone with (stato($p) = PARLARE and tempoParlare($p) <= 1))

	// RULE DEFINITIONS
	rule r_dareParola =
		choose $p in Persone with stato($p) = IN_ATTESA and tempoAttesa($p) > 1 do
			par
				stato($p) := PARLARE
				microfono($p) := ON
				tempoParlare($p) := maxTempoParlare
			endpar
			
	rule r_chiedere =
		forall $p in Persone with stato($p) = ASCOLTARE do
			choose $n in {1:10} with true do
				if $n > 7 then 
					par
						stato($p) := IN_ATTESA
						tempoAttesa($p) := maxTempoAttesa
					endpar
				else
					skip
				endif
	
	rule r_attesa =
		forall $p in Persone with stato($p) = IN_ATTESA do
			if tempoAttesa($p) = 1 then 
				stato($p) := ASCOLTARE
			else
				tempoAttesa($p) := tempoAttesa($p) - 1
			endif
	
	rule r_parlare =
		forall $p in Persone with stato($p) = PARLARE do
			if tempoParlare($p) = 1 then
				par
					tempoParlare($p) := 0
					microfono($p) := OFF
					stato($p) := ASCOLTARE
				endpar
			else
				tempoParlare($p) := tempoParlare($p) - 1
			endif

	// INVARIANTS
	invariant inv_parlare over stato : (forall $p in Persone, $c in Persone with (($p != $c and stato($p) = PARLARE) implies (stato($c)!= PARLARE)))
	invariant inv_micro over microfono: ((forall $p in Persone, $c in Persone with ((microfono($p) = ON and $c != $p) implies (microfono($c) = OFF))))
	
	// Proprietà P1: ogni persona prima o poi può parlare
	CTLSPEC ag((forall $p in Persone with true implies ef(stato($p)=PARLARE)))
	CTLSPEC ef((forall $p in Persone with stato($p) = PARLARE))
	
	// Proprietà P2: solo una persona alla volta parla
	CTLSPEC ag((forall $p in Persone, $c in Persone with (($p != $c and stato($p) = PARLARE) implies stato($c)!= PARLARE)))
	CTLSPEC ag((forall $p in Persone with stato($p) = PARLARE implies (forall $t in Persone with ($t != $p and stato($t) != PARLARE))))
	
	
	// Proprietà P3: solo la persona che parla ha il microfono attivato
	CTLSPEC ag((forall $p in Persone with stato($p) != PARLARE implies microfono($p) = OFF))

	// MAIN RULE
	main rule r_Main =
		par
			r_attesa[]
			r_chiedere[]
			switch moderatrice
				case PARLA:
					if richiesta then
						moderatrice := DA_PAROLA
					endif
				case DA_PAROLA:
					par
						r_dareParola[]
						moderatrice := ASCOLTA
						microfonoModeratrice := OFF
					endpar
				case ASCOLTA:
					par
						r_parlare[]
						if finitoParlare then 
							par
								moderatrice := PARLA
								microfonoModeratrice := ON
							endpar
						endif
					endpar
				endswitch
		endpar
				
			
// INITIAL STATE
default init s0:
	function stato($p in Persone) = ASCOLTARE
	function moderatrice = PARLA
	function microfono($p in Persone) = OFF
	function microfonoModeratrice = ON
	function tempoAttesa($p in Persone) = 0
	function tempoParlare($p in Persone) = 0
