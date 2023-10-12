package es1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiriDispariTest {

	@Test
	public void test1() {
		PariDispari p = new PariDispari();
		assertTrue(p.tira(3, 1));
		System.out.println(p.toString());
		assertTrue(p.tira(4, 2));
		System.out.println(p.toString());
		assertTrue(p.tira(2, 2));		
		System.out.println(p.toString());
		assertTrue(p.tira(2, 4));
		System.out.println(p.toString());
		assertTrue(p.tira(2, 4));
		System.out.println(p.toString());
		assertTrue(p.finito());
	}
	
	// Statement 100%
	
	@Test
	public void test2() {
		PariDispari p = new PariDispari();
		assertFalse(p.tira(0, 1));
		System.out.println(p.toString());
		assertTrue(p.tira(1, 2));
		System.out.println(p.toString());
	}
	
	// Branch 100% e di conseguenza anche le decisioni
	
	/*# (finito() || a<1 || a>5 || b<1 || b> 5)	|	D
	 * 		F		F		F		F		F	|	F	test1
	 *3 	T		/		/		/		/	|	T	
	 * 		F		T		-		-		-	|	T	test2
	 *3 	F		F		T		-		-	|	T
	 *3		F		F		F		T		-	|	T
	 *3		F		F		F		F		T	|	T
	 */
	
	@Test
	public void test3() {
		PariDispari p = new PariDispari();
		assertFalse(p.tira(6, 1));
		System.out.println(p.toString());
		assertFalse(p.tira(2, 0));
		System.out.println(p.toString());
		assertFalse(p.tira(2, 7));
		System.out.println(p.toString());
		assertTrue(p.tira(1, 2));
		System.out.println(p.toString());
		assertTrue(p.tira(1, 2));
		System.out.println(p.toString());
		assertTrue(p.tira(1, 2));
		System.out.println(p.toString());
		assertTrue(p.tira(1, 2));
		System.out.println(p.toString());
		assertTrue(p.tira(1, 2));
		System.out.println(p.toString());
		assertFalse(p.tira(1, 2));
		System.out.println(p.toString());
	}
	
	// 100% Term

}
