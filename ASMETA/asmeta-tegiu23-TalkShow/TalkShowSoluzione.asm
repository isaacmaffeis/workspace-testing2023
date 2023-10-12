// versione corretta da me

asm TalkShowSoluzione

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	enum domain Stato = {ASCOLTO | ATTESA | PARLA}
	domain TempoParla subsetof Integer
	domain TempoAttesa subsetof Integer
	domain Persone subsetof Integer
	
	// faccio fuori la moderatirce controlled moderatrice: Stato
	controlled stato: Persone -> Stato
	controlled inAttesa : Persone -> TempoAttesa
	controlled parla : TempoParla // tempo in cui chi sta parlando parla
//	controlled microfono: Persone -> Boolean// chi parla 
	controlled microfono: Persone 
	monitored vuoleParlare: Persone // chi vuole intervanire
	
	derived nessunoParla : Boolean
	
	static maxTempoParla : TempoParla
	
definitions:
	// DOMAIN DEFINITIONS
	domain Persone = {1:3} // {1:6} 
	domain TempoParla = {0:5}
	domain TempoAttesa = {0:7}
	
	function maxTempoParla = 5
	function nessunoParla = (forall $p in Persone with stato($p) != PARLA)	

	rule r_scegliNextParla =	
	    if nessunoParla then 
	    	choose $p in Persone with stato($p) = ATTESA and inAttesa($p) != 0 do
	    	par
	    		stato($p) := PARLA
				//microfono($p) := true
				microfono := $p
				parla := maxTempoParla //max parla 
	    	endpar
	    endif
	
	rule r_gestisciPersona($p in Persone) =	
		par			
			if stato($p) = PARLA then
				if parla = 0 then par
					stato($p) := ASCOLTO
					//microfono($p) := false
					microfono := undef
				endpar
				else
				   parla := parla -1
				endif				  
			endif
			if stato($p) = ATTESA then
				if inAttesa($p) = 0 then 
					stato($p) := ASCOLTO
				else
				   inAttesa($p) := inAttesa($p) -1
				endif
			endif				  			
			if stato($p) = ASCOLTO and vuoleParlare = $p then // probability
			  par
			   stato($p) := ATTESA
			   inAttesa($p) := 7
			  endpar 
			endif
		endpar


	// P1 una persona prima o poi pu  parlare
	//CTLSPEC ef(stato(1) = PARLA)
	CTLSPEC (forall $p in Persone with ef(stato($p) = PARLA))
	// P2 solo una persona alla volta parla
	//CTLSPEC (forall $p in Persone with ag(stato($p) = PARLA) implies forall ...)
	CTLSPEC ag(stato(1) = PARLA implies  stato(2) != PARLA and stato(3) != PARLA) 
	
	// stato(microfono) non posso usarlo
	// 
	CTLSPEC (forall $p in Persone with ag(isDef(microfono) and microfono = $p implies stato($p) = PARLA))
	
	invariant inv_mic over microfono: (forall $p in Persone with microfono = $p implies stato($p) = PARLA)
	
	main rule r_Moderatore=
	par
		r_gestisciPersona[1]
		r_gestisciPersona[2]
		r_gestisciPersona[3]
//		r_gestisciPersona[4]
//		r_gestisciPersona[5]
//		r_gestisciPersona[6]
		r_scegliNextParla[]
	endpar
		
		
	
// INITIAL STATE
default init s0:
	function stato($a in Persone) = ASCOLTO
	//function microfono($a in Persone) = false
	function microfono = undef
