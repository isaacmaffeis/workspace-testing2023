asm LightArray

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	enum domain Status = {ON, OFF}
	enum domain Commands = {NONE, TOGGLE, ALLOFF}
	
	domain Lamps subsetof Integer
	
	// FUNCTIONS
	controlled status : Lamps -> Status
	
	monitored toggle: Lamps
	monitored command: Commands
	
	derived areAllOff: Boolean	
	
definitions:
	// DOMAIN DEFINITIONS
	domain Lamps = {1:10}
	
	// FUNCTION DEFINITIONS
	function areAllOff = (forall $l in Lamps with status($l) = OFF)

	// RULE DEFINITIONS
	rule r_allOff =
		forall $l in Lamps with true do status($l) := OFF
		
	rule r_toggle($l in Lamps) =
		switch status($l)
		case ON:
			status($l) := OFF
		case OFF:
			status($l) := ON
		endswitch
	
	// INVARIANTS
	
	// CTL
	//#1 è sempre possibile avere tutte le lampadine spente
	CTLSPEC ag(ef(areAllOff))
	
	//#2 Se sono tutte spente, fino a quando non do il comando di toggle su una lampada, rimangono tutte spente
	CTLSPEC ag(areAllOff and command!=TOGGLE implies ax(areAllOff))
	
	//#3 Se do il comando ad una lampadina, nello stato successivo essa cambia stato
	CTLSPEC ag(command=TOGGLE implies (forall $t in Lamps with toggle = $t implies (status($t)=ON implies ax( status($t)=OFF ))))
	CTLSPEC ag(command=TOGGLE implies (forall $t in Lamps with toggle = $t implies (status($t)=OFF implies ax( status($t)=ON ))))
	
	//#4 Scrivi almeno un’altra proprietà di safety che sia vera.
	CTLSPEC ag( not(command=TOGGLE and command=NONE))
	
	//#5 Scrivi almeno un’altra proprietà di liveness che sia vera.
	CTLSPEC ag((forall $l in Lamps with command=NONE and status($l) = ON implies ax(status($l) = ON)))
	
	// MAIN RULE
	main rule r_Main =
		switch command
			case NONE:
				skip
			case TOGGLE:
				r_toggle[toggle]
			case ALLOFF:
				r_allOff[]
		endswitch

// INITIAL STATE
default init s0:
	function status($l in Lamps) = ON
