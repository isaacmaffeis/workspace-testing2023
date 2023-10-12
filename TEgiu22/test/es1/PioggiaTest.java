package es1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PioggiaTest {

	@Test
	public void statementTest1() {
		Pioggia p = new Pioggia();
		assertTrue(p.set(5, 25));
	}

	@Test
	public void statementTest2() {
		Pioggia p = new Pioggia();
		assertFalse(p.set(20, 25));
	}
	
	// Statement 100%
	
	// Branch 100%
	
	// Condition 100%
	
	@Test
	public void mcdcTest2() {
		Pioggia p = new Pioggia();
		assertFalse(p.set(-5, 25));
	}
	
	@Test
	public void mcdcTest4() {
		Pioggia p = new Pioggia();
		assertFalse(p.set(5, -25));
	}
	
	@Test
	public void mcdcTest5() {
		Pioggia p = new Pioggia();
		p.set(2, 70);
		assertFalse(p.set(2, 120));
	}
	
	@Test
	public void mcdcTest6() {
		Pioggia p = new Pioggia();
		assertTrue(p.set(2, 120));
	}
	
	// Term 100%

}
