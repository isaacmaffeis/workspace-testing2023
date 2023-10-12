/** at every step increments the seconds 
*/
asm AdvancedClock

import ../StandardLibrary
signature:
	domain Second subsetof Integer
	domain Minute subsetof Integer
	domain Hour subsetof Integer
	controlled seconds: Second
	controlled minutes: Minute    
	controlled hours: Hour
	monitored signal : Boolean

definitions:
	domain Second = {0 : 9}
	domain Minute= {0 : 9}
	domain Hour = {0 : 9}


	main rule r_Main = 
		par
			if signal and seconds = 9 and minutes = 9 then
				hours := (hours + 1) mod 10
			endif
			if signal and seconds = 9 then
				minutes := (minutes + 1) mod 10			
			endif
			if signal then seconds := (seconds + 1) mod 10
			endif
		endpar
		
default init s0:
	function seconds = 0
	function minutes = 0
	function hours = 0
