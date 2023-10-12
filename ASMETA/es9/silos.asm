asm silos

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	enum domain Status = {GRU | NASTRO}
	
	domain Cilindro subsetof Integer
	domain Capacita subsetof Integer
	domain Gru subsetof Integer
	
	// FUNCTIONS
	controlled capacita : Cilindro -> Capacita
	controlled status: Status
	controlled gru: Gru
	
	monitored cilindro: Cilindro
	
	static nastro: Gru
	
	derived minore10: Boolean
	
definitions:
	// DOMAIN DEFINITIONS
	domain Cilindro = {1:3}
	domain Capacita = {0:12}
	domain Gru = {1:5}

	// FUNCTION DEFINITIONS
	function nastro = 2
	
	function minore10 = (forall $c in Cilindro with capacita($c)<=10)
	
	// RULE DEFINITIONS
	rule r_gru =
		choose $s in Gru with capacita(cilindro) + $s < 10 do 
			par
				capacita(cilindro) := capacita(cilindro) + $s
				status := NASTRO
			endpar
	
	rule r_nastro =
		par
			forall $c in Cilindro with capacita($c) > 0 do
				if capacita($c) = 1 then capacita($c):= 0
				else capacita($c) := capacita($c) - nastro
				endif
			status := GRU
		endpar
		
	// INVARIANTS
	invariant inv_maxcapacity over capacita : (forall $s in Cilindro with capacita($s) < 11)
	
	// CTL
	// Proprietà P1: Tutti i cilindri non hanno mai più di 10 quintali di grano Proprietà 
	CTLSPEC ag(minore10)
	
	// P2: Se attivo il nastro, nello stato successivo tutti i cilindri avranno al massimo 8 quintali 
	//CTLSPEC ag(status=NASTRO implies (forall $c in Cilindro with ax(capacita($c)<=8)))
		
	// Proprietà P3: Se il primo cilindro è vuoto, finché non si attiva la gru, esso rimane vuoto
	//CTLSPEC ag(capacita(1)=0 and not(status=GRU) implies ag(capacita(1)=0))
	CTLSPEC ag(capacita(1)=0 implies aw(capacita(1)=0,status=GRU and ax(capacita(1)>0)))
	
	//Scrivi almeno un’altra proprietà di safety e una liveness che siano vere.
	CTLSPEC ag(not(status=NASTRO and status=GRU))

	CTLSPEC ag(status=GRU implies(forall $s in Cilindro with cilindro=$s and capacita($s)=0 implies ef(capacita($s)>0)))
	
	
	// MAIN RULE
	main rule r_silos =
	switch status
	case GRU:
		r_gru[]
	case NASTRO:
		r_nastro[]
	endswitch
	
// INITIAL STATE
default init s0:
	function status = GRU
	function capacita($c in Cilindro)=1