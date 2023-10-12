// a simple example with a tic tac toe game

asm semaforo3
import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	enum domain Semaforo = {VERDE | GIALLO | ROSSO}
	// FUNCTIONS
	controlled semaforo : Semaforo
	
	monitored richiesta: Boolean

definitions:
	// DOMAIN DEFINITIONS

	// FUNCTION DEFINITIONS
	

	// RULE DEFINITIONS
	rule r_attivaSemaforo = 
		switch semaforo
		case ROSSO:
			if richiesta then semaforo := VERDE endif
		case GIALLO:
			semaforo := ROSSO
		case VERDE:
			semaforo := GIALLO
		endswitch

	
	// INVARIANTS
	
	// CTL
	
	// 1. Non può mai passare a ROSSO direttamente da VERDE
	CTLSPEC ag(semaforo=VERDE implies not ax(semaforo=ROSSO))
	
	// 2. Quando è ROSSO rimarrà sempre ROSSO a meno che ci sia una richiesta
	CTLSPEC aw(semaforo = ROSSO, richiesta and ax(semaforo = VERDE))
	
	// 3. Se c’è una richiesta allora prima o poi diventa VERDE.
	CTLSPEC ag(semaforo = ROSSO and richiesta implies af(semaforo=VERDE))
	
	// 4. In qualsiasi istante, prima o poi potrebbe diventare VERDE
	CTLSPEC ef(semaforo=VERDE)
	
	// vera
	CTLSPEC ag(semaforo = VERDE implies ax(semaforo = GIALLO))
	CTLSPEC ag(semaforo=VERDE implies a(semaforo = VERDE,semaforo=GIALLO))
	
	// falsa
	CTLSPEC ag(richiesta implies ax(semaforo = VERDE))
	/* Trace Type: Counterexample 
  -> State: 1.1 <-
    richiesta = false
    semaforo = ROSSO
  -> State: 1.2 <-
    richiesta = true
  -> State: 1.3 <-
    semaforo = VERDE
  -> State: 1.4 <-
    richiesta = false
    semaforo = GIALLO
	 */

	// MAIN RULE
	main rule r_semaforo = 
		r_attivaSemaforo[]

// INITIAL STATE
default init s0:
	function semaforo = ROSSO
