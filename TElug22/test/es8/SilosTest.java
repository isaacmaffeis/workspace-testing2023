package es8;

import static org.junit.Assert.*;

import org.junit.Test;

public class SilosTest {

	@Test
	public void test() {
		Silos s = new Silos();
		
		System.out.print(s.toString());
		assertEquals(s.silos[0].capacity,1);
		assertEquals(s.silos[1].capacity,1);
		assertEquals(s.silos[2].capacity,1);
		
		
		s.gru(0, 4);
		assertEquals(s.silos[0].capacity,5);
		assertEquals(s.silos[1].capacity,1);
		assertEquals(s.silos[2].capacity,1);
		
		System.out.print(s.toString());
		
		s.nastro();
		assertEquals(s.silos[0].capacity,3);
		assertEquals(s.silos[1].capacity,0);
		assertEquals(s.silos[2].capacity,0);

		System.out.print(s.toString());
		
		s.gru(1, 5);
		assertEquals(s.silos[0].capacity,3);
		assertEquals(s.silos[1].capacity,5);
		assertEquals(s.silos[2].capacity,0);
		System.out.print(s.toString());

		s.nastro();
		assertEquals(s.silos[0].capacity,1);
		assertEquals(s.silos[1].capacity,3);
		assertEquals(s.silos[2].capacity,0);
		
		System.out.print(s.toString());
		
	}

}
