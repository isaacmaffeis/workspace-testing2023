
asm Magazzino

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	domain Prodotti subsetof Integer
	domain Quantita subsetof Integer
	domain singolaQuantita subsetof Integer
	
	// FUNCTIONS
	controlled quantita: Prodotti -> Quantita
	
	monitored prodotto: Prodotti
	monitored addQuantita: Quantita
	
	derived isFull: Boolean
			
definitions:
	// DOMAIN DEFINITIONS
	domain Prodotti = {1:5}
	domain Quantita = {0:100}
	domain singolaQuantita = {0:10}
	
	// FUNCTION DEFINITIONS
	function isFull = (forall $p in Prodotti with quantita($p) = 100)

	// RULE DEFINITIONS
	rule r_aggiungiQuantita = 
		if quantita(prodotto) + addQuantita > 100 then
			quantita(prodotto):= 100
		else
			quantita(prodotto) := quantita(prodotto) + addQuantita
		endif
	
	// INVARIANTS

	// MAIN RULE
	main rule r_Main =
		if isFull or quantita = 0 then
			skip
		else
			r_aggiungiQuantita[]
		endif

// INITIAL STATE
default init s0:
	function quantita($p in Prodotti) = 0
