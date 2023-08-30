package exe3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Computer_1_Test {

	@Test
	public void test1() {
		Computer c1 = new Computer();
		
		assertTrue(c1.Compute(true, true, false, 5, 10));
		
	}
	
	@Test
	public void test2() {
		Computer c2 = new Computer();
		
		assertFalse(c2.Compute(false, false, false, 10, 5));
	}

}
