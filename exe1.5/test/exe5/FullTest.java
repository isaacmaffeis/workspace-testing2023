package exe5;

import static org.junit.Assert.*;

import org.junit.Test;

public class FullTest {

	@Test
	public void test() {
		
		Magazzino mag = new Magazzino();
		
		assertTrue(mag.isFull());// il magazzino è vuoto
		assertTrue(mag.insert(0, 10));
		assertTrue(mag.insert(0, 10));
		assertTrue(mag.insert(0, 10));  // prodotto 0
		assertTrue(mag.insert(0, 10));
		assertTrue(mag.insert(0, 10));
		assertTrue(mag.insert(0, 10));
		assertTrue(mag.insert(0, 10));
		assertTrue(mag.insert(0, 10));
		assertTrue(mag.insert(0, 10));
		assertTrue(mag.insert(0, 10));
		
		
		assertTrue(mag.insert(1, 10));
		assertTrue(mag.insert(1, 10));
		assertTrue(mag.insert(1, 10));  // prodotto 1
		assertTrue(mag.insert(1, 10));
		assertTrue(mag.insert(1, 10));
		assertTrue(mag.insert(1, 10));
		assertTrue(mag.insert(1, 10));
		assertTrue(mag.insert(1, 10));
		assertTrue(mag.insert(1, 10));
		assertTrue(mag.insert(1, 10));
		
		assertTrue(mag.insert(2, 10));
		assertTrue(mag.insert(2, 10));
		assertTrue(mag.insert(2, 10));  // prodotto 2
		assertTrue(mag.insert(2, 10));
		assertTrue(mag.insert(2, 10));
		assertTrue(mag.insert(2, 10));
		assertTrue(mag.insert(2, 10));
		assertTrue(mag.insert(2, 10));
		assertTrue(mag.insert(2, 10));
		assertTrue(mag.insert(2, 10));
		
		assertTrue(mag.insert(3, 10));
		assertTrue(mag.insert(3, 10));
		assertTrue(mag.insert(3, 10));  // prodotto 3
		assertTrue(mag.insert(3, 10));
		assertTrue(mag.insert(3, 10));
		assertTrue(mag.insert(3, 10));
		assertTrue(mag.insert(3, 10));
		assertTrue(mag.insert(3, 10));  
		assertTrue(mag.insert(3, 10));
		assertTrue(mag.insert(3, 10));
		
		assertTrue(mag.insert(4, 10));
		assertTrue(mag.insert(4, 10));
		assertTrue(mag.insert(4, 10));  // prodotto 4
		assertTrue(mag.insert(4, 10));
		assertTrue(mag.insert(4, 10));
		assertTrue(mag.insert(4, 10));
		assertTrue(mag.insert(4, 10));
		assertTrue(mag.insert(4, 10));  
		assertTrue(mag.insert(4, 10));
		assertTrue(mag.insert(4, 10));
		
		assertTrue(mag.isFull()); //magazzino pieno
	}

}