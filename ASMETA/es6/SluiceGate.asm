// a simple example with a tic tac toe game

asm SluiceGate

import ../StandardLibrary

signature:

	enum domain Positions = {FULLYCLOSED | OPENING | FULLYOPENED | CLOSING}
	enum domain Controls = {ON | OFF | CLOCKWISE | ANTICLOCKWISE}
	domain Time subsetof Integer
	
	controlled gate: Positions
	controlled engine: Controls
	controlled time: Time
	
	static fullyOpenedTime: Time
	static fullyClosedTime: Time
	
definitions:
	
	domain Time = {0:180} // 1 step = 1 minute

	function fullyOpenedTime = 10
	function fullyClosedTime = 170
	
	rule r_fullyopened = 
		if time > 0 then
			time := time - 1
		else
			gate := CLOSING
		endif
		
	rule r_closing = 
		if engine = OFF then engine := ON
		else if engine = ON then engine := ANTICLOCKWISE
		else if engine = ANTICLOCKWISE then 
			par
				engine := OFF
				time := fullyClosedTime
				gate := FULLYCLOSED
			endpar
		endif endif endif
		
	rule r_fullyclosed = 
		if time > 0 then
			time := time - 1
		else
			gate := OPENING
		endif
		
	rule r_opening = 
		if engine = OFF then engine := ON
		else if engine = ON then engine := CLOCKWISE
		else if engine = CLOCKWISE then 
			par
				engine := OFF
				time := fullyOpenedTime
				gate := FULLYCLOSED
			endpar
		endif endif endif
				
	main rule r_sluiceGate = 
		switch gate
			case FULLYOPENED:
				r_fullyopened[]
			case CLOSING:
				r_closing[]	
			case FULLYCLOSED:
				r_fullyclosed[]
			case OPENING:
				r_opening[]
		endswitch

default init s0:
	function gate = FULLYOPENED
	function engine = OFF
	function time = fullyOpenedTime