package es4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	// Copertura Istruzioni
	
	@Test
	public final void StatementTest1() {
		Car cs1 = new Car();
		cs1.acc(3);
		assertTrue(cs1.stop(4));
	}
	
	@Test
	public final void StatementTest2() {
		Car cs2 = new Car();
		cs2.acc(3);
		assertFalse(cs2.stop(2));
	}
	
	// Statement 100%
	
	// Copertura Branch
	
	@Test
	public final void BranchTest1() {
		Car cb1 = new Car();
		cb1.acc(3);
		assertTrue(cb1.stop(3));
	}
	
	@Test
	public final void BranchTest2() {
		Car cb2 = new Car();
		cb2.acc(5);
		assertFalse(cb2.stop(3));
	}
	
	// Branch 100%
	
	// Copertura Condizioni tramite MCDC
	
	/*	#(d >= 1 && d <= 10 && s > 0 && s - d <= 0)	|	D
	 * 	1	F			-		-			-		|	F
	 * 	2	T			T		T			T		|	T
	 * 	3	T			F		-			-		|	F
	 * 	4	T			T		F			-		|	F
	 * 	5	T			T		T			F		|	F
	 */
	
	/*	#(d >= 1 && d <= 10 && s >= d)	|	D
	 * 	1	F			-		-		|	F
	 * 	5	T			T		T		|	T NEW
	 * 	3	T			F		-		|	F
	 * 	4	T			T		F		|	F
	 */
	
	/*	#(step >= 1 && step <= 4)	|	D
	 * 	4	T			F			|	F
	 * 	2	T			T			|	T
	 * 	3	F			-			|	F
	 */
	
	@Test
	public final void mcdcTest1() {
		Car c1 = new Car();
		assertFalse(c1.stop(0));
	}
	
	@Test
	public final void mcdcTest2() {
		Car c2 = new Car();
		c2.acc(3);
		assertTrue(c2.stop(4));
	}
	
	@Test
	public final void mcdcTest3() {
		Car c3 = new Car();
		c3.acc(0);
		assertFalse(c3.stop(15));
	}
	
	@Test
	public final void mcdcTest4() {
		Car c4 = new Car();
		c4.acc(5);
		assertFalse(c4.stop(7));
	}
	
	@Test
	public final void mcdcTest5() {
		Car c5 = new Car();
		c5.acc(4);
		assertFalse(c5.stop(2));
	}
	
	// 100 % Statement
	// 100% Branch
	// 100% Term

	// Si potrebbe ridurre il numero di test andando a combinare 
	// i test mcdc con alcuni test già fatti in precedenza 
	// così da ridurne il volume
	// esempio tengo solo tutti i mcdc test e il branch test1
	// e ottengo lo stesso il 100% con 3 test in meno
	
}
