import static org.junit.Assert.*;

import org.junit.Test;

public class TestLampadina {

	@Test
	public void testSstatementCoverage() {
		// Test prima condizione AND
		// accesa True
		Lampadina l1 = new Lampadina();
		l1.accesa = true;
		assertTrue(l1.setVoltes(2));
		// accesa False
		Lampadina l2 = new Lampadina();
		assertTrue(l2.setVoltes(2));
		
		// Test seconda condizione AND
		// Prima condizione OR True: uguale al caso precedente con l2
		// Prima Condizione OR False: Impossibile 
		// Seconda Condizione OR True
		Lampadina l3 = new Lampadina();
		assertTrue(l3.setVoltes(14));
		// Seconda Condizione OR False: Impossibile 
	}
	/*
	(!accesa && (volt <= 13 || volt >= 11)
	 F   T                   T (Volt = 2) accesa = True
	 T   F                   T (Volt = 2)
	 -------------------------------------
	 T   F           T            F (Volt = 2) // True
	 T   F           F            F Impossibile non può essere > 13 e < 11
	 -------------------------------------
	 T   F           F            T  (Volt = 14)
	 T   F           F            F  Impossibile
	 */
	
	/*
	if(accesa && volt <= 2)
	      T        T  (Volt = 2)   Già presente (e accesa = True)
	      F	       T  (Volt = 2)   Già presente
	---------------------------
	      T        T  (Volt = 2)   Già presente
	      F        F  (Volt = 14)  Già presente  
	*/
}