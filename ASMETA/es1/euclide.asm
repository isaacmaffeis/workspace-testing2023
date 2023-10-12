// a simple example with a tic tac toe game

asm euclide

import ../StandardLibrary

signature:
	
	controlled numA: Integer
	controlled numB: Integer
	
	derived isEquals: Prod(Integer,Integer) -> Boolean
	
definitions:
	
	function isEquals($a in Integer , $b in Integer) = $a = $b
	
	rule r_while = 
		if numA > numB then numA := numA - numB
			else numB := numB - numA
		endif
	
	main rule r_mcdc =
		if not isEquals(numA,numB) then r_while[]
		endif
		/* // Soluzione immediata
		 * while not isEquals(numA,numB) do 
			if numA > numB then numA := numA - numB
			else numB := numB - numA
			endif*/

default init s0:
	function numA = 6409 //121
	function numB = 3289 //22
