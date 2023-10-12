package es1;

import static org.junit.Assert.*;

import org.junit.Test;

public class OstelloTest {

	@Test
	public void StatementTest() {
		Ostello o = new Ostello();
		
		assertTrue(o.checkin(0, 0));
		assertFalse(o.checkin(0, 0));
		assertTrue(o.checkin(0));
		assertFalse(o.checkin(10));
		assertTrue(o.checkin(0));
		assertTrue(o.checkin(0));
		assertTrue(o.libera(0));
		assertFalse(o.libera(10));
		assertTrue(o.checkin(0));
		assertFalse(o.checkin(0));
		assertFalse(o.libera(0));
		System.out.println(o.toString());
	}
	
	// 100% Statement
	
	// 100% Branch
	
	// MCDC
	
	/* TODO - MCDC Table and Tests
	 * ...
	 */
	
	// 100% Term
	

}
