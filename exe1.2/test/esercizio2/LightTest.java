package esercizio2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightTest {
	
	@Test
	public void StatementTest1() {
		Light l1 = new Light();
		assertEquals(l1.onOff(false, true, false),true);
	}
	
	@Test
	public void StatementTest2() {
		Light l2 = new Light();
		assertEquals(l2.onOff(true, true, false),false);
	}

	// Branching Test in questo caso è equivalente allo Statement Test
	// perchè copre ogni percorso della decisione if
	// In genere Branching Test implica lo statement test ma non viceversa
	// quindi non aggiungo casi di test
	
	// copertura decisioni è equivalente al branching test
	// già coperto in questo caso con lo statement test
	
	// condition test utilizzo MCDC
	/* ((bottomIn || bottomOut) && !light)| D
	 *      F			F			-  	- |	F
	 * 		T			-			T	F | T
	 * 		F			T			T	F | T
	 * 		T			-			F   T | F
	 */
	
	@Test
	public void test1(){
		Light l1 = new Light();
		assertFalse(l1.onOff(false, false, false));
	}
	
	/* Già coperto con StatementTest1
	@Test
	public void test2(){
		Light l2 = new Light();
		assertTrue(l2.onOff(false, true, false));
	}*/
	
	@Test
	public void test3(){
		Light l3 = new Light();
		assertTrue(l3.onOff(false, false, true));
	}
	
	/* Già coperto con StatementTest2
	@Test
	public void test4(){
		Light l4 = new Light();
		assertFalse(l4.onOff(true, true, false));
	}*/
	
}
