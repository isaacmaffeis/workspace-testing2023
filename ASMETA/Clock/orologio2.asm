// versione di orogoio semplice
// con monitorata
asm orologio2
import StandardLibrary
signature:
	domain Secondi subsetof Integer
	domain Minuti subsetof Integer
	domain Ore subsetof Integer
	abstract domain Student
	
	static maxMinuti: Minuti // costante 
	dynamic controlled ore: Ore
	dynamic controlled minuti: Minuti
	dynamic controlled secondi: Secondi
	
	// se è vero incremento i secondi altrimenti no
	monitored signal: Boolean
	
	derived sommaMinSec: Integer
	
	// funziona statica con 1 argomento
	static doppio: Integer -> Integer
	// funziona statica per valore assoluto
	static val_asso: Integer -> Integer
	// funziona statica con 2 argomenti
	static somma: Prod(Integer,Integer) -> Integer
	
	// ad ogni ora associo una azione come string
	controlled azione: Ore -> String
	
	static angelo: Student	

definitions:
	domain Secondi = {0:59} // intervallo da 0 a 59 con 0 e 59 inclusi
	domain Minuti = {0:59}
	domain Ore = {0:24}
	
	// derived
	function  sommaMinSec =  minuti + secondi
	
	function doppio($x in Integer) = 2 * $x 
	
	function val_asso($x in Integer) = 
	      //if $x >= 0 then $x else -$x endif
		  let ($y = if $x >= 0 then $x else -$x endif ) in $y + 0 endlet

	rule r_inc_min = 
		let ($minP = minuti + 1) in 
			if minuti < 3 then 
						minuti:= $minP 
					 else par
						minuti:= 0
						//ore:= ore +1
						// incrementa da 0 a 3 ore a caso con choose rule
						choose $inc in Ore 
							with 0 < $inc and $inc < 3 do
							ore := ore + $inc   
				 		endpar
					 endif
		endlet

    //invariant inv_sec over secondi: secondi < 1

	main rule r_orologio = 
		if signal then 
			if secondi < 9 then 
				secondi:= secondi + 1 
			else par
					secondi:= 0
					r_inc_min[]
				 endpar
			endif
		else 
			skip
		endif
				
default init s0:
	function secondi = 0
	function minuti = 0
	function ore = 0

