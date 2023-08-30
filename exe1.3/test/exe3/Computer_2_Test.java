package exe3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Computer_2_Test {
	
	// MCDC per testare le condizioni

	/*((x && (y || z)) && no_alarm) |	D
	 1 	F		-			-		|	F
	 2 	T	  T    -		T		|	T
	 3 	T	  F    T 		T		|	T	
	 4 	T	  F	   F		-		|	F
	 5 	T		T			F		|	F
	 */
	
	@Test
	public void test1() {
		Computer c1 = new Computer();
		assertFalse(c1.Compute(false, false, false, 0, 0));
	}
	
	@Test
	public void test2() {
		Computer c1 = new Computer();
		assertTrue(c1.Compute(true, true, false, 0, 5));
	}
	
	@Test
	public void test3() {
		Computer c1 = new Computer();
		assertTrue(c1.Compute(true, false, true, 0, 5));
	}
	
	@Test
	public void test4() {
		Computer c1 = new Computer();
		assertFalse(c1.Compute(true, false, false, 0, 0));
	}
	
	@Test
	public void test5() {
		Computer c1 = new Computer();
		assertFalse(c1.Compute(true, true, false, 5, 0));
	}
	
	// 100%

}
