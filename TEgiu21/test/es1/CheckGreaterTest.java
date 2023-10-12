package es1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckGreaterTest {

	@Test
	public void StatementTest1() {
		 CheckGreater c = new CheckGreater();
		 assertTrue(c.check(new int [] {2,6,5,10}, 5));
	}
	
	@Test
	public void StatementTest2() {
		 CheckGreater c = new CheckGreater();
		 assertFalse(c.check(null, 0));
	}
	
	// 100% Statement
	
	// 100% Branch
	
	// MCDC
	
	/*#	(a != null && a.length > 0)	|	D
	 *-		T				T		|	T covered by StatementTest1
	 *-		F				/		|	F covered by StatementTest2
	 *1		T				F		|	F
	 */
	
	@Test
	public void mcdcTest1() {
		 CheckGreater c = new CheckGreater();
		 assertFalse(c.check(new int[0], 0));
	}
	
	/*# (x > b && x % 2 == 0)	|	D
	 *-		T		T			|	T covered by StatementTest1
	 *-		F		-			|	F covered by StatementTest1
	 *2		T		F			|	F 
	 */

	@Test
	public void mcdcTest2() {
		 CheckGreater c = new CheckGreater();
		 assertFalse(c.check(new int [] {2,4,5,7}, 5));
	}
	
	// Term 100 %
}
