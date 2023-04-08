package exe5;

import static org.junit.Assert.*;

import org.junit.Test;

import exe5.Magazzino;

public class BranchTestMagazzino {

	// BRANCH TEST
	
	@Test
	public void testInsert() {
		Magazzino m1 = new Magazzino();
		assertFalse(m1.insert(10, 100));
		Magazzino m2 = new Magazzino();
		assertTrue(m2.insert(0, 5));
	}
	
	@Test
	public void testIsFull() {
		Magazzino m1 = new Magazzino();
		assertFalse(m1.isFull(5));
		assertFalse(m1.isFull(0));
		assertFalse(m1.isFull());
		for(int i=0; i < 5; i++) {
			for(int j=0; j < 10; j++)
				m1.insert(i, 10);
			assertTrue(m1.isFull(i));
		}
		assertTrue(m1.isFull());
	}

}
