asm Ostello

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	enum domain Stato = {LIBERO | OCCUPATO}
	
	domain Letti subsetof Integer
	domain Camere subsetof Integer
	// FUNCTIONS
	
	controlled stato : Prod(Camere,Letti) -> Stato // Matrice
	
	monitored letto : Letti
	monitored camera : Camere

	derived isLibero: Prod(Camere,Letti) -> Boolean
	derived isStanzaOccupata: Camere -> Boolean

definitions:
	// DOMAIN DEFINITIONS
	domain Letti = {1:2}  //{1:5}
	domain Camere = {1:2} //{1:10}

	// FUNCTION DEFINITIONS
	function isLibero($c in Camere, $l in Letti) = (stato($c, $l) = LIBERO)
	function isStanzaOccupata($s in Camere) = (forall $l in Letti with stato($s,$l) = OCCUPATO)

	// RULE DEFINITIONS
	rule r_prenotazione = 
		if isLibero(camera,letto) then
			stato(camera,letto) := OCCUPATO
		else
			stato(camera,letto) := LIBERO
		endif
	// INVARIANTS
	
	// CTL
	// P1: una stanza non può mai essere occupata
	CTLSPEC ag(not(forall $c in Camere with isStanzaOccupata($c)))
	/* Trace Type: Counterexample 
  -> State: 1.1 <-
    stato(1,2) = LIBERO
    stato(1,1) = LIBERO
    stato(2,2) = LIBERO
    stato(2,1) = LIBERO
    camera = undef
    letto = undef
  -> State: 1.2 <-
    camera = 2
    letto = 2
  -> State: 1.3 <-
    stato(2,2) = OCCUPATO
    letto = 1
  -> State: 1.4 <-
    stato(2,1) = OCCUPATO
    camera = 1
    letto = 2
  -> State: 1.5 <-
    stato(1,2) = OCCUPATO
    letto = 1
  -> State: 1.6 <-
    stato(1,1) = OCCUPATO
    camera = undef
    letto = undef
	 */
	 
	 // P2: un letto non può mai venire occupato se è già occupato
	 CTLSPEC ag((forall $c in Camere, $l in Letti with ($c = camera and $l= letto and not isLibero($c,$l)) implies not ax(not isLibero($c,$l))))
	//true 
	
	// P3: un letto una volta occupato non può diventare più libero
	CTLSPEC ag((forall $c in Camere, $l in Letti with not isLibero($c,$l)) implies af(isLibero($c,$l)) )
	/* Trace Type: Counterexample 
  -> State: 1.1 <-
    stato(1,1) = LIBERO
    stato(2,1) = LIBERO
    stato(1,2) = LIBERO
    stato(2,2) = LIBERO
    camera = undef
    letto = undef
  -> State: 1.2 <-
    camera = 2
    letto = 2
  -> State: 1.3 <-
    stato(2,2) = OCCUPATO
    letto = 1
  -> State: 1.4 <-
    stato(2,1) = OCCUPATO
    camera = 1
    letto = 2
  -> State: 1.5 <-
    stato(1,2) = OCCUPATO
    letto = 1
  -- Loop starts here
  -> State: 1.6 <-
    stato(1,1) = OCCUPATO
    letto = undef
  -> State: 1.7 <-
	 */
	// MAIN RULE
	main rule r_Main =
		r_prenotazione[]

// INITIAL STATE
default init s0:
	function stato($c in Camere,$l in Letti) = LIBERO
