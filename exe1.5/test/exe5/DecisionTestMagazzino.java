package exe5;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecisionTestMagazzino {

	// BRANCH
	@Test
	public void testInsert() {
		Magazzino m1 = new Magazzino();
		assertFalse(m1.insert(-5, 10)); // T x x x x
		Magazzino m2 = new Magazzino();
		assertFalse(m2.insert(10, 10)); // F T x x x
		Magazzino m3 = new Magazzino();
		assertFalse(m3.insert(2, -2)); // F F T x x
		Magazzino m4 = new Magazzino();
		assertFalse(m4.insert(2, 100)); // F F F T x
		Magazzino m5 = new Magazzino();
		for(int j=0; j < 10; j++)
			m5.insert(0, 10);
		assertFalse(m5.insert(0, 10)); // F F F F T
		Magazzino m6 = new Magazzino();
		assertTrue(m6.insert(0, 5));   // F F F F F
	}
	
	@Test
	public void testIsFull() {
		Magazzino m1 = new Magazzino();
		assertFalse(m1.isFull(-5));	// F x
		assertFalse(m1.isFull(5));	// T F
		assertFalse(m1.isFull(0));	// F F (F)
		assertFalse(m1.isFull());	// F
		for(int i=0; i < 5; i++) {
			for(int j=0; j < 10; j++)
				m1.insert(i, 10);
			assertTrue(m1.isFull(i)); // F F (T)
		}
		assertTrue(m1.isFull()); // T
	}

}
