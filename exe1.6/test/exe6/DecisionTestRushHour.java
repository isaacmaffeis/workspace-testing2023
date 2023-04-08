package exe6;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecisionTestRushHour {

	@Test
	public void testMoveCar() {
		RushHour r1 = new RushHour();
		// if indici
		assertFalse(r1.moveCar(-1, 0, 0));
		assertFalse(r1.moveCar(6, 0, 0));
		assertFalse(r1.moveCar(0, -1, 0));
		assertFalse(r1.moveCar(0, 6, 0));
		assertFalse(r1.moveCar(0, 0, 0));
		assertFalse(r1.moveCar(0, 0, 5));
		assertFalse(r1.moveCar(0, 0, 1)); // cella vuota
		assertFalse(r1.moveCar(0, 3, 1)); // bordo sopra
		assertFalse(r1.moveCar(1, 5, 2)); // bordo destra
		assertTrue(r1.moveCar(4, 1, 4));  // sposto sinistra
		assertFalse(r1.moveCar(4, 0, 4)); // bordo sinistra
		assertTrue(r1.moveCar(4, 0, 3));  // sposto basso
		assertFalse(r1.moveCar(5, 0, 3)); // bordo basso
		assertFalse(r1.moveCar(1, 5, 3)); // sposto occupata
		assertTrue(r1.moveCar(2, 2, 1));  // sposto alto
		assertTrue(r1.moveCar(1, 2, 2));  // sposto destra
	}
	
	@Test
	public void testRedCarAtExit(){
		RushHour r1 = new RushHour();
		assertFalse(r1.redCarAtExit());
		r1.moveCar(2, 2, 2);
		r1.moveCar(2, 3, 2);
		r1.moveCar(3, 5, 4);
		r1.moveCar(2, 5, 3);
		r1.moveCar(2, 4, 2);
		assertTrue(r1.redCarAtExit());
	}

}
