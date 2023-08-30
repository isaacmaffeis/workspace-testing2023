package exe4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Balance_1_Test {

	
	// copertura di istruzioni
	@Test
	public void StatementTest() {
		Balance b1 = new Balance();
		assertTrue(b1.setBalanceValue(2, 100));
		assertEquals(b1.getP(), 2);
		
		Balance b2 = new Balance();
		assertFalse(b2.setBalanceValue(10, 100));
		assertEquals(b2.getW(), 100);
		
	}
	
	// copertura di rami (branch)
	// In questo caso la copertura delle istruzioni implica la copertura dei rami
	// ma in generale non è sempre così, infatti branch coverage implies statement coverage,
	// ma il viceversa generalmente no
	
	// Per le condizioni applico il criterio MCDC
	
	/*	#	( (p<4 && w<=400) || (p==0 && w<=1000)) |	D
	 * 	1		F		-			F		-		|	F
	 * 	2		T		T			-		-		|	T
	 * 	3		T		F			F		-		|	F		
	 * 	4		-		F			T		T		|	T
	 * 	5		-		F			T		F		|	F
	 */
	
	@Test
	public void mcdcTest1() {
		Balance b1 = new Balance();
		assertFalse(b1.setBalanceValue(10, 0));
	}
	
	@Test
	public void mcdcTest2() {
		Balance b2 = new Balance();
		assertTrue(b2.setBalanceValue(2, 100));
	}
	
	@Test
	public void mcdcTest3() {
		Balance b3 = new Balance();
		assertFalse(b3.setBalanceValue(2, 500));
	}
	
	@Test
	public void mcdcTest4() {
		Balance b4 = new Balance();
		assertTrue(b4.setBalanceValue(0, 500));
	}
	
	@Test
	public void mcdcTest5() {
		Balance b5 = new Balance();
		assertFalse(b5.setBalanceValue(0, 5000));
	}
	
	// 100%

}
