package exe5;

import static org.junit.Assert.*;

import org.junit.Test;

public class Magazzino_1_Test {

	@Test
	public void statementTest1() {
		Magazzino m1 = new Magazzino();
		assertFalse(m1.insert(5, 0));
		assertFalse(m1.isFull(5));
	}
	
	@Test
	public void statementTest2() {
		Magazzino m2 = new Magazzino();
		assertTrue(m2.insert(0, 10));
		assertFalse(m2.isFull(0));
		for (int i = 0; i < 9; i++) {
			m2.insert(0, 10);
		}
		assertTrue(m2.isFull(0));
	}
		
	@Test
	public void statementTest3() {
		Magazzino m3 = new Magazzino();
		assertFalse(m3.isFull());
		for (int i=0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				m3.insert(i, 10);
			}
		}
		assertTrue(m3.isFull());
	}

	// Statement and branch 100%
	// In questo caso lo statement test coincide con il branch test
	// In generale branch test implica statement test
	// ma in questo caso è vero anche il viceversa poichè abbiamo istruzioni in ogni ramo
	
	// Decision test equivale al branch test
	
	// Per le Condizioni uso il criterio MCDC
	// insert(int productIndex, int addQuantity)
	/*	# ((pI < 0 || pI > 4)||(aQ < 0 || aQ > 10)||(p[pI] + aQ) > 100))	|	D
	 * 	1		T		-			-		-				-				|	T
	 * 	2		F		F			F		F				F				|	F
	 * 	3		F		T			-		-				-				|	T
	 * 	4		F		F			T		-				-				|	T
	 * 	5		F		F			F		T				-				|	T
	 * 	6		F		F			F		F				T				|	T
	 */
	
	@Test
	public void insert_mcdc_Test1() {
		Magazzino m1 = new Magazzino();
		assertFalse(m1.insert(-5, 0));
	}
	
	@Test
	public void insert_mcdc_Test2() {
		Magazzino m2 = new Magazzino();
		assertTrue(m2.insert(0, 5));
	}
	@Test
	public void insert_mcdc_Test3() {
		Magazzino m3 = new Magazzino();
		assertFalse(m3.insert(5, 5));
	}
	
	@Test
	public void insert_mcdc_Test4() {
		Magazzino m4 = new Magazzino();
		assertFalse(m4.insert(3, -5));
	}
	
	@Test
	public void insert_mcdc_Test5() {
		Magazzino m5 = new Magazzino();
		assertFalse(m5.insert(3, 20));
	}
	
	@Test
	public void insert_mcdc_Test6() {
		Magazzino m6 = new Magazzino();
		for (int i = 0; i < 10; i++) {
			m6.insert(3, 10);
		}
		assertFalse(m6.insert(3, 10));
	}
	
	// conditions insert 100%
	
	// isFull(int productIndex)
	/*	#(productIndex < 0 || productIndex > 4)	|	D
	 * 	1		T					-			|	T
	 * 	2		F					F			|	F
	 * 	3		F					T			|	T
	 */
	
	@Test
	public void isFull_pi_mcdc_Test1() {
		Magazzino m1 = new Magazzino();
		assertFalse(m1.isFull(-5));
	}
	
	@Test
	public void isFull_pi_mcdc_Test2() {
		Magazzino m2 = new Magazzino();
		for (int i = 0; i < 10; i++) {
			m2.insert(3, 10);
		}
		assertTrue(m2.isFull(3));
	}
	
	@Test
	public void isFull_pi_mcdc_Test3() {
		Magazzino m1 = new Magazzino();
		assertFalse(m1.isFull(5));
	}
	
	// condition isFull(int productIndex) 100%

	// Per chiarezza dell'esercizio lascio tutti i casi di test
	// ma si potrebbero effettuare semplificazioni per ridurne il numero
	// in quanto alcuni test sono ripetuti
	
}
