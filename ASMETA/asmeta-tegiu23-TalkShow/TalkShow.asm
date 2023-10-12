
asm TalkShow

import ../StandardLibrary

signature:
	
	domain Persone subsetof Integer
	enum domain Stato = {ASCOLTO | IN_ATTESA | PARLA}
	domain Tempo_Parla subsetof Integer
	domain Tempo_Attesa subsetof Integer
	
	controlled stato: Persone -> Stato
	controlled tempo_per_parlare: Tempo_Parla
	controlled tempo_in_attesa: Persone -> Tempo_Attesa
	monitored volerParlare: Persone

	static maxTempoParlare: Tempo_Parla
	derived nessuno_parla: Boolean
	
definitions:
	
	domain Persone = {1:3}
	domain Tempo_Parla = {0:5}
	domain Tempo_Attesa = {0:7}
	
	function nessuno_parla = (forall $p in Persone with stato($p) != PARLA)
	function maxTempoParlare = 5
	
	rule r_scegli_prossimo_parla = 
		if nessuno_parla then 
			choose $p in Persone with stato($p) = IN_ATTESA and tempo_in_attesa($p) != 0 do
			par
				stato($p) := PARLA
				//microfono($p) := ACCESO
				tempo_per_parlare := maxTempoParlare
			endpar
		endif
		
	
	rule r_gestisciPersona($p in Persone)=
		par
			if stato($p) = PARLA then 
				if tempo_per_parlare = 0 then 
						stato($p) := ASCOLTO
				else
					tempo_per_parlare := tempo_per_parlare - 1
				endif
			endif
			if stato($p) = IN_ATTESA then
				if tempo_in_attesa($p) = 0 then
					stato($p) := ASCOLTO
				else
					tempo_in_attesa($p) := tempo_in_attesa($p) - 1
				endif
			endif
			if stato($p) = ASCOLTO and volerParlare = $p then 
				par
					stato($p) := IN_ATTESA
					tempo_in_attesa($p) := 7
				endpar
			endif
		endpar
				
	
	main rule r_moderatore =
		par
			r_gestisciPersona[1]
			r_gestisciPersona[2]
			r_gestisciPersona[3]
			r_scegli_prossimo_parla[]
		endpar
		
// INITIAL STATE	
default init s0:
	function stato($a in Persone) = ASCOLTO
