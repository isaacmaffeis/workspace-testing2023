package exe5;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagazzinoBranchCoverage {

	
	@Test
	public void testInsertBranch() {
		Magazzino m= new Magazzino();
		m.insert(7, 20);
		m.insert(3, 5);
	}
	
	@Test
	public void testIsFullBranch() {
		Magazzino m= new Magazzino();
		
		m.isFull(10);
	    
	    m.isFull();
	    m.isFull(0);
	    assertTrue(m.isFull());// il mazzino è vuoto
		m.insert(0, 10);
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));  // prodotto 0
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		m.isFull(0);
		
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));  // prodotto 1
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));  // prodotto 2
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));  // prodotto 3
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));  
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));  // prodotto 4
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));  
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		
		m.isFull();
		
		
	}

}