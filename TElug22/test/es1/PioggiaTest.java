package es1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PioggiaTest {
	
	@Test
	public void StatementTest() {
		Pioggia p = new Pioggia();
		p.pioggia[6] = 500;
		assertTrue(p.hasRainedGT_EM(300));
		assertFalse(p.hasRainedGT_EM(700));
	}
	
	// Statement 100%
	// Branch 100%
	
	/*#	(valore < 0 || valore > 1000 || (mese % 2 == 0 && pioggia[mese] > valore))	|	D
	 *1 		F			F					F				/					|	F	Covered in StatementTest
	 *2			T			/					/				/					|	T
	 *3			F			T					/				/					|	T
	 *4			F			F					T				T					|	T	Covered in StatementTest
	 *5			F			F					T				F					|	F	Covered in StatementTest
	 */
	
	@Test
	public void mcdcTest2(){
		Pioggia p = new Pioggia();
		assertTrue(p.hasRainedGT_EM(-100));
	}
	
	@Test
	public void mcdcTest3(){
		Pioggia p = new Pioggia();
		assertTrue(p.hasRainedGT_EM(1500));
	}

}
