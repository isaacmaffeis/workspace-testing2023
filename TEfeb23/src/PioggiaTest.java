import static org.junit.Assert.*;

import org.junit.Test;

public class PioggiaTest {

	@Test
	public void testSet() {
		Pioggia p = new Pioggia();
		// Caso 1 
		// T  F  F  F  -
		assertFalse(p.set(0, 0));
		
		// Caso 2
		// F  F  F  F  -
		assertTrue(p.set(5, 0));
		
		// Caso 3
		// F  T  F  F  -
		assertFalse(p.set(14, 0));
		
		// Caso 4
		// F  F  T  F  -
		assertFalse(p.set(5, -4));
		
		// Caso 5
		//F  F  F  T  T
		// porto lo stato a pioggia > 50
		p.set(5, 51);
		assertFalse(p.set(5, 150));
		
		// Caso 6
		// F  F  F  T  F
		p.set(5, 49);
		assertTrue(p.set(5, 150));
		
		/* MCDC |(mese < 1 || mese > 12 || valore <0 || (valore > 100 && pioggia[mese - 1 ] > 50))  | Decisione
		 *  1		|T|			-				-			-				-						|	T
		 *  2		|F|			|F|				|F|			|F|				-						|	F
		 *  3		F			|T|				F			F				-						|	T
		 *  4		F			F				|T|			F				-						|	T
		 *  5		F			F				F			|T|				|T|						|	T
		 *  6		F			F				F			T				|F|						|	F
		 */
	}

}
