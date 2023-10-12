
asm AdvancedClock

import ../StandardLibrary

signature:
	
	domain TwentyFour subsetof Integer
	domain Sixty subsetof Integer
	
	controlled hours: TwentyFour
	controlled minutes : Sixty
	controlled seconds: Sixty
	
	derived isMaxHours: Boolean
	derived isMaxMinutes: Boolean
	derived isMaxSeconds: Boolean
	
definitions:
	domain TwentyFour = {0:23}
	domain Sixty = {0:59}
	
	function isMaxHours = hours = 23
	function isMaxMinutes = minutes = 59
	function isMaxSeconds = seconds = 59
	
	main rule r_advancedClock = 
		if not isMaxSeconds then
			seconds := seconds + 1
		else if not isMaxMinutes then
			par
				minutes := minutes + 1
				seconds := 0
			endpar
		else if not isMaxHours then
			par
				hours := hours + 1
				minutes := 0
				seconds := 0
			endpar
		else
			par
				hours := 0
				minutes := 0
				seconds := 0
			endpar
		endif
		endif
		endif
		
default init s0:
	function hours = 0
	function minutes = 0
	function seconds = 0