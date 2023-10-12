asm ferryman
import StandardLibrary
signature:
	enum domain Side = {LEFT, RIGHT}
	enum domain Actor = {FERRYMAN, GOAT, CABBAGE, WOLF}


	controlled pos: Actor ->Side
    // NO, megliouna funzione
    // controlled posGoat : Side
    // controlled posCabbage : Side
    // controlled posWolf : Side
    
    // quello che lui porta (decisa dall'ambiente)
    monitored m_carry: Actor
    
    // non fa parte dello stato ma è utile 
	derived allRight : Boolean
	derived pericolo : Boolean
    
definitions:

	function allRight = (forall $a in Actor with pos($a) = RIGHT)
	function pericolo =
		(pos(GOAT) = pos(WOLF) and pos(WOLF) != pos(FERRYMAN)) or
	    (pos(GOAT) = pos(CABBAGE) and pos(GOAT) != pos(FERRYMAN))
	
	invariant inv_pericolo over pos: not pericolo

    main rule r_main =
    	par
    	// sposta il farryman
    		if pos(FERRYMAN) = LEFT then pos(FERRYMAN) := RIGHT
    		else pos(FERRYMAN) := LEFT
    		endif
		// sposta il carry
			if pos(m_carry) = pos(FERRYMAN) then
    			if pos(m_carry) = LEFT then pos(m_carry) := RIGHT
    			else pos(m_carry) := LEFT
    			endif
    		else skip endif
    	endpar
		

default init s0:
// inzialmente tutti a sinistra
	function pos($a in Actor) = // LEFT oppure 
								if $a = FERRYMAN then LEFT 
								else LEFT endif
