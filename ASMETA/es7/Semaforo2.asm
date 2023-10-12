asm Semaforo2

import ../StandardLibrary
import ../CTLlibrary
import ../LTLlibrary

signature:
	// DOMAINS
	
	enum domain Semafori = {SEMAFORO_A | SEMAFORO_B}
	enum domain Colori = {ROSSO | GIALLO | VERDE}
	
	controlled colore_semaforo: Semafori -> Colori
	
	monitored segnale: Semafori
	
	derived allVerdi: Boolean
	
	static colore_altro_semaforo: Semafori -> Colori

definitions:
	// DOMAIN DEFINITIONS

	// FUNCTION DEFINITIONS
	function colore_altro_semaforo($s in Semafori) =
		if $s = SEMAFORO_A then colore_semaforo(SEMAFORO_B)
		else colore_semaforo(SEMAFORO_A)
		endif
		
	function allVerdi = (forall $s in Semafori with colore_semaforo($s) = VERDE)
	
	// RULE DEFINITIONS
	rule r_verde($s in Semafori) = 
		colore_semaforo($s) := VERDE
		
	rule r_giallo ($s in Semafori) =
		colore_semaforo($s) := GIALLO
		
	rule r_rosso ($s in Semafori) =
		colore_semaforo($s) := ROSSO
		 
	rule r_switchColore($s in Semafori) =
		switch(colore_semaforo($s))
			case VERDE:
				r_giallo[$s]
			case GIALLO:
				r_rosso[$s]
		endswitch

	// INVARIANTS
	
	//---------------------------------------------------------
	// PROPRIETA' LTL/CTL:
	
	// 1) non accade mai che i semafori siano entrambi verdi
	// utilizziamo una "derived" per la definizione della regola 
	CTLSPEC ag(not allVerdi)
	LTLSPEC g(not allVerdi)
	
	// 2) il semaforo 2 può diventare sempre verde (non solo allo stato iniziale)
	CTLSPEC ag(ef(colore_semaforo(SEMAFORO_B)=VERDE))

	// 3) se un semaforo è verde allora l’altro è rosso
	LTLSPEC g((forall $s in Semafori with colore_semaforo($s)=VERDE implies colore_altro_semaforo($s) = ROSSO))
	CTLSPEC ag((forall $s in Semafori with colore_semaforo($s)=VERDE implies colore_altro_semaforo($s) = ROSSO))
	
	// 4) se entrambi i semafori sono rossi e viene scelto il semaforo 1,
	//    nello stato successivo il semaforo 1 è verde
	CTLSPEC ag((forall $s in Semafori with colore_semaforo($s) = ROSSO) and segnale = SEMAFORO_A implies ax(colore_semaforo(SEMAFORO_A)=VERDE))
	LTLSPEC g((forall $s in Semafori with colore_semaforo($s) = ROSSO) and segnale = SEMAFORO_A implies x(colore_semaforo(SEMAFORO_A)=VERDE))

	// 5) il semaforo 1 non può mai essere verde
	// mi aspetto che sia FALSA perché sicuramente esiste un percorso
	// in cui il semaforo 1 può diventare verde
	CTLSPEC ag(colore_semaforo(SEMAFORO_A)!=VERDE)
	/*-- specification AG colore_semaforo(SEMAFORO_A) != VERDE  is false
	-- as demonstrated by the following execution sequence
	Trace Description: CTL Counterexample 
	Trace Type: Counterexample 
	  -> State: 1.1 <-
	    colore_semaforo(SEMAFORO_A) = ROSSO
	    colore_semaforo(SEMAFORO_B) = ROSSO
	    segnale = undef
	    colore_altro_semaforo(SEMAFORO_B) = ROSSO
	    colore_altro_semaforo(SEMAFORO_A) = ROSSO
	  -> State: 1.2 <-
	    segnale = SEMAFORO_A
	  -> State: 1.3 <-
	    colore_semaforo(SEMAFORO_A) = VERDE
	    segnale = undef
	    colore_altro_semaforo(SEMAFORO_B) = VERDE
	 */
	 
	// MAIN RULE
	main rule r_Main =
		if(colore_semaforo(segnale)=ROSSO and colore_altro_semaforo(segnale)=ROSSO) then
				r_verde[segnale]
		else if (colore_semaforo(segnale) != ROSSO) then
			r_switchColore[segnale]
		endif endif

// INITIAL STATE
default init s0:
	function colore_semaforo($s in Semafori) = switch($s)
												case SEMAFORO_A: ROSSO
												case SEMAFORO_B: ROSSO
												endswitch