asm TalkShow2

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	enum domain Stato= {ASCOLTO | IN_ATTESA | PARLARE}
	enum domain Moderatrice = {PARLA | DA_PAROLA | ASCOLTA}
	enum domain Microfono = {ON | OFF}
	
	domain Persone subsetof Integer
	domain Tempo subsetof Integer
	
	// FUNCTIONS
	controlled stato: Persone -> Stato
	controlled microfono: Persone -> Microfono
	controlled moderatrice: Moderatrice
	controlled microfonoModeratrice: Microfono
	controlled tempoParlare: Tempo
	controlled tempoAttesa: Persone -> Tempo
	
	static maxTempoParlare: Tempo
	static maxTempoAttesa: Tempo
	
	derived richiesta: Boolean
	derived nessunoParla: Boolean
	
definitions:
	// DOMAIN DEFINITIONS
	domain Persone = {1:6}
	//domain Persone = {1:3}
	domain Tempo = {0:7}
	// FUNCTION DEFINITIONS
	function maxTempoParlare = 5
	function maxTempoAttesa = 7
	
	function richiesta = (exist $p in Persone with stato($p) = IN_ATTESA)
	function nessunoParla = (forall $p in Persone with stato($p) != PARLARE)

	// RULE DEFINITIONS
	
	rule r_richiesta =
		forall $p in Persone with stato($p) = ASCOLTO do
			choose $n in {0:10} with true do 
				if $n > 7 then 
					par
						stato($p) := IN_ATTESA
						tempoAttesa($p) := maxTempoAttesa
					endpar
				endif
			
	rule r_personaParla = 
		forall $p in Persone with stato($p) = PARLARE do
			if(tempoParlare <= 1) then 
				par
					stato($p) := ASCOLTO 
					tempoParlare := 0
					microfono($p) := OFF
				endpar
			else
				tempoParlare := tempoParlare - 1
			endif
			
	rule r_personaAttesa =
		forall $p in Persone with stato($p) = IN_ATTESA do
			if(tempoAttesa($p) <= 1) then
				par
					stato($p) := ASCOLTO
					tempoAttesa($p) := 0
				endpar
			else
				tempoAttesa($p) := tempoAttesa($p) - 1
			endif
	
	rule r_moderatrice = 
		switch moderatrice
		case PARLA:
			if richiesta then
				moderatrice := DA_PAROLA
			endif
		case DA_PAROLA:
			choose $p in Persone with stato($p) = IN_ATTESA and tempoAttesa($p) > 1 do
				par
					stato($p) := PARLARE
					microfono($p) := ON
					microfonoModeratrice := OFF
					tempoParlare := maxTempoParlare
					moderatrice := ASCOLTA
				endpar
		case ASCOLTA:
			if nessunoParla then 
				par
					moderatrice := PARLA
					microfonoModeratrice := ON
				endpar
			else
				r_personaParla[]
			endif
		endswitch
	
	// INVARIANTS
	
	// CTL
	// Proprieta P1: ogni persona prima o poi può parlare
	CTLSPEC ef((forall $p in Persone with stato($p) = PARLARE))
	
	// Proprieta P2: solo una persona alla volta parla
	//CTLSPEC (forall $p in Persone with ag(stato($p) = PARLA) implies forall ...)
	CTLSPEC ag(stato(1) = PARLARE implies stato(2) != PARLARE and stato(3) != PARLARE) 
	CTLSPEC ag((forall $p in Persone with stato($p) = PARLARE implies (forall $t in Persone with ($t != $p and stato($t) != PARLARE))))
	
	// Proprieta P3: solo la persona che parla ha il microfono attivato
	CTLSPEC ag((forall $p in Persone with stato($p) != PARLARE implies microfono($p) = OFF))
	
	// MAIN RULE
	main rule r_Main =
	par
		r_richiesta[]
		r_moderatrice[]
		r_personaAttesa[]
	endpar

// INITIAL STATE
default init s0:
	function stato($p in Persone) = ASCOLTO
	function microfono($m in Persone) = OFF
	function moderatrice = PARLA
	function microfonoModeratrice = ON
	function tempoParlare = 0
	function tempoAttesa($p in Persone) = 0