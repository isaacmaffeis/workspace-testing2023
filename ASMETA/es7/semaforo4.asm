// a simple example with a tic tac toe game

asm semaforo4

import ../StandardLibrary
import ../CTLlibrary

signature:
	// DOMAINS
	enum domain Semaforo = {ROSSO, GIALLO , VERDE}
	
	domain NumSemaforo subsetof Integer
	
	// FUNCTIONS
	controlled statoSemaforo : NumSemaforo -> Semaforo
	
	monitored richiesta: Boolean
	monitored richiestaSemaforo: NumSemaforo
	
	derived statoSemaforoRichiesto: Semaforo
	derived statoAltroSemaforo: Semaforo
	
definitions:
	// DOMAIN DEFINITIONS
	domain NumSemaforo = {1,2}
	
	function statoSemaforoRichiesto = statoSemaforo(richiestaSemaforo)
	function statoAltroSemaforo = if richiestaSemaforo = 1 then statoSemaforo(2) else statoSemaforo(1) endif

	// FUNCTION DEFINITIONS


	// RULE DEFINITIONS

	// INVARIANTS
	
	// 1) non accade mai che i semafori siano entrambi verdi
	CTLSPEC ag(not(forall $s in NumSemaforo with statoSemaforo($s) = VERDE))
	
	// 2) il semaforo 2 può diventare sempre verde (non solo allo stato iniziale)
	//CTLSPEC ag(ef(statoSemaforo(2) = VERDE))
	
	// 3) se un semaforo è verde allora l’altro è rosso
	// CTLSPEC ag(((forall $s in NumSemaforo with statoSemaforo($s) = VERDE implies ((forall $t in NumSemaforo with $t != $s and statoSemaforo($t) != VERDE)))))

	// 4) se entrambi i semafori sono rossi e viene scelto il semaforo 1,nello stato successivo il semaforo 1 è verde
	CTLSPEC ag(((forall $s in NumSemaforo with (statoSemaforo($s) = ROSSO )) and richiesta and richiestaSemaforo = 1 implies ax(statoSemaforo(1) = VERDE)))

	// MAIN RULE
	main rule r_Main =
		if richiesta and statoAltroSemaforo = ROSSO then
			statoSemaforo(richiestaSemaforo) := VERDE
		else 
			par
				forall $s in NumSemaforo with statoSemaforo($s) = GIALLO do statoSemaforo($s) := ROSSO
				forall $t in NumSemaforo with statoSemaforo($t) = VERDE do statoSemaforo($t) := GIALLO
			endpar
		endif
			

// INITIAL STATE
default init s0:
	function statoSemaforo($n in NumSemaforo) = ROSSO
