package esercizio2;

import static org.junit.Assert.*;

import org.junit.Test;

public class testLight {

	@Test
	public void testLight() {
		Light l1 = new Light();
		assertNotNull("Oggetto Light non nullo", l1);
	}

	@Test
	public void testStatementCoverageLight() { 
												
		Light l1 = new Light();
		assertTrue(l1.onOff(false, false, true));
		Light l2 = new Light();
		assertFalse(l2.onOff(false, false, false));
		// coperto la decisione if sia vera che falsa
	}
	
	@Test
	public void testConditionCoverageLight() {
		// coprire le condizioni
		Light l3 = new Light();
		assertFalse(l3.onOff(true, true, true));
		Light l4 = new Light();
		assertTrue(l4.onOff(false, true, true));
	}
	
}