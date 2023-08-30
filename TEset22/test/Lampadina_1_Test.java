import static org.junit.Assert.*;

import org.junit.Test;

public class Lampadina_1_Test {
	
	// MCDC Test
	/*	#(!accesa && (volt <= 13 || volt >= 11))|	D
	 * 	1	F	T			-			-		|	F
	 * 	2	T	F			T			-		|	T
	 * 	-	T	F			F			F		|	F // IMPOSSIBILE !
	 * 	3	T	F			F			T		|	T
	 */
	
	/*	#(accesa && volt <= 2)	|	D
	 * 	1	T			T		|	T
	 * 	4	T			F		|	F
	 * 	-	F			F		|	F // IMPOSSIBILE !
	 */
	
	@Test
	public final void mcdcTest1() {
		Lampadina l1 = new Lampadina();
		l1.setVoltes(12); // accesa = true;
		assertTrue(l1.setVoltes(0));
	}
	
	@Test
	public final void mcdcTest2() {
		Lampadina l2 = new Lampadina();
		assertTrue(l2.setVoltes(5));
	}
	
	@Test
	public final void mcdcTest3() {
		Lampadina l3 = new Lampadina();
		assertTrue(l3.setVoltes(15));
	}
	
	@Test
	public final void mcdcTest4() {
		Lampadina l1 = new Lampadina();
		l1.setVoltes(12); // accesa = true;
		assertFalse(l1.setVoltes(10));
	}
	
	// Non posso coprire tutte le condizioni
	// Perchè nel primo if non ho una situazione in cui
	// (volt <= 13 || volt >= 11)) siano entrambe False
	// mentre nel secondo if non ho mai una situazione con accesa = False
	
	// 66.7% first if
	// 75% second if

}
