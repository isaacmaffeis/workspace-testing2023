// a simple example with a tic tac toe game

asm Allarme

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	domain Sensori subsetof Integer
	
	// FUNCTIONS
	controlled stato: Sensori -> Boolean
	
	monitored sensore: Sensori
	
	derived pericolo: Boolean

definitions:
	// DOMAIN DEFINITIONS
	domain Sensori = {0:3}

	// FUNCTION DEFINITIONS
	function pericolo = (stato(0)=false and stato(1)=false) 
		or (stato(0)=false and stato(3)=false) 
		or (stato(1)=false and stato(2)=false) 
		or (stato(2)=false and stato(3)=false)

	// RULE DEFINITIONS
	rule r_toggleSensore =
		if stato(sensore) = false then 
			stato(sensore) := true 
		else
			if sensore = 0 and stato(1) = true and stato(3) = true then stato(sensore) := false
			else if sensore = 1 and stato(0) = true and stato(2) = true then stato(sensore) := false
			else if sensore = 2 and stato(1) = true and stato(3) = true then stato(sensore) := false
			else if sensore = 3 and stato(0) = true and stato(2) = true then stato(sensore) := false
			endif endif endif endif
		endif

	// INVARIANTS
	invariant inv_adiacenti over stato : not (stato(0)=false and stato(1)=false) and
		not (stato(0)=false and stato(3)=false) and
		not (stato(1)=false and stato(2)=false) and
		not (stato(2)=false and stato(3)=false)
	 
	 // CTL
	 // P1: non posso mai avere una situazione di pericolo
	 CTLSPEC ag(not pericolo)
	 
	 // P2: non posso mai avere i sensori 0 e 2 contemporaneamente spenti.
	 CTLSPEC ag(not af(stato(0) = false and stato(1) = false))
	 
	 // P3: una volta spento un sensore può essere sempre riacceso.
	 CTLSPEC ag((forall $s in Sensori with stato($s) = false implies ef (stato($s) = true)))
	 
	 // P4: un sensore acceso può essere sempre spento
	 //CTLSPEC ag((forall $s in Sensori with stato($s) = true implies af(stato($s) = false)))
	 /* false
	  * Trace Type: Counterexample 
	  -> State: 1.1 <-
	    stato(2) = true
	    stato(0) = true
	    stato(1) = true
	    stato(3) = true
	    sensore = undef
	  */
	  
	  // P5: se il sensore 0 è acceso e quello 1 è spento, allora 0 rimarrà acceso almeno fino a quando 1 non si accenderà (se si accenderà).
	  CTLSPEC ((stato(0)=true and stato(1)=false) implies aw(stato(0)=true,stato(1)=true))
	 
	// MAIN RULE
	main rule r_Main =
		r_toggleSensore[]

// INITIAL STATE
default init s0:
	function stato($s in Sensori) = true
