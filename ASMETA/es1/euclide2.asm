// a simple example with a tic tac toe game

asm euclide2

import ../StandardLibrary

signature:
	
	controlled numA : Integer
	controlled numB : Integer
	monitored numA_init : Integer
	monitored numB_init : Integer
	derived isEquals: Prod(Integer,Integer) -> Boolean
	
definitions:

	function isEquals($a in Integer, $b in Integer) = $a = $b

	rule r_while =
		if numA > numB then
			numA := numA - numB
		else
			numB := numB - numA
		endif

	main rule r_mcdc = 
		if not isEquals(numA,numB) then
			r_while[]
		endif

default init s0:
	function numA = numA_init
	function numB = numB_init