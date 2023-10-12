asm Semaforo

import ../StandardLibrary
import ../CTLlibrary
import ../LTLlibrary

signature:
	// DOMAINS
	enum domain Colors = {RED | YELLOW | GREEN}
	enum domain Status = {OFF | REQUEST | ON}
	
	controlled semaforo : Colors
	controlled status : Status
	
	monitored request: Boolean
	
	derived isRed: Boolean
	
definitions:
	// DOMAIN DEFINITIONS
	

	// FUNCTION DEFINITIONS
	function isRed = (semaforo = RED)

	// RULE DEFINITIONS
	rule r_TurnGreen = 
		switch semaforo
			case RED:
				semaforo := YELLOW
			case YELLOW:
				semaforo := GREEN
			case GREEN:
				par
					semaforo := RED
					status := OFF
				endpar
		endswitch
			
	rule r_requestIncoming = 
		if request then status := REQUEST endif
				
	// INVARIANTS
	
	// CTL and LTL SPEC
	/* 1. Non può mai passare a VERDE direttamente da ROSSO
	 * 2. Quando è ROSSO rimarrà sempre ROSSO a meno che ci sia una richiesta
	 * 3. Se c’è una richiesta allora prima o poi diventa VERDE.
	 * 4. In qualsiasi istante, prima o poi potrebbe diventare VERDE
	 */
	 
	CTLSPEC ag(semaforo=RED implies not ax(semaforo=GREEN))
	LTLSPEC g(semaforo=RED implies not x(semaforo=GREEN))
	
	CTLSPEC ag(semaforo=RED implies semaforo=RED or request)
	LTLSPEC g(semaforo=RED implies semaforo=RED or request)
	
	CTLSPEC ag(request implies af(semaforo=GREEN))
	LTLSPEC g(request implies f(semaforo=GREEN))
	
	CTLSPEC ef(semaforo=GREEN)
	LTLSPEC f(semaforo=GREEN) // non possibile in LTL
	/* -- specification  F semaforo = GREEN  is false
	 * -- as demonstrated by the following execution sequence
	 * Trace Description: LTL Counterexample 
	 * Trace Type: Counterexample 
	 * -- Loop starts here
	 * -> State: 1.1 <-
	 * semaforo = RED
	 * status = OFF
	 * request = false
	 * -> State: 1.2 <-
	 */
	
	// MAIN RULE
	main rule r_Main =
		switch status
			case OFF:
				r_requestIncoming[]
			case REQUEST:
				if isRed then
					status := ON
				endif
			case ON:
				r_TurnGreen[]
		endswitch
		

// INITIAL STATE
default init s0:
	function status = OFF
	function semaforo = RED
