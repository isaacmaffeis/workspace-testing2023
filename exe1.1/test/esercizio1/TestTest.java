package esercizio1;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestTest {

	@Test
	public void test() {
		
		int base=3;
		int altezza=4;
		
		
		// senza assert
		Rettangolo rTest= new Rettangolo(base, altezza);
		
		rTest.getAltezza();
		rTest.getBase();
	
		//esempio di assert
		assertEquals(3, rTest.getBase());
		assertEquals(4, rTest.getAltezza());	
		assertTrue(rTest.getAltezza()>0);
	    assertSame(base, rTest.getBase());
	}

}