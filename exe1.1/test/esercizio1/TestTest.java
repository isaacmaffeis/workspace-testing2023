package esercizio1;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestTest {
	
	
	@BeforeClass
	public static void eseguiprima(){
		System.out.println("Apro connessione");
	}
	
	@AfterClass
	public static void eseguiallafine() {
		System.out.println("Chiudo connessione");
	}
	
	Rettangolo r;
	
	@Before
	public void init() {
		r = new Rettangolo(0,0);
	}
	
	// Se la base è negativa mi aspetto un'eccezione
	// Se una eccezione non è attesa il test fallisce --> bisogna specificare che ce la attendiamo
	@Test(expected = InvalidParameterException.class)
	public void testBaseNegativa() {
		new Rettangolo(-5,10);
	}
	
	public void testEccezione() {
		try {
			Rettangolo r = new Rettangolo(-5,10);
			fail("Mi aspetto l'eccezione");
		}
		catch(Exception e){
		}
	}
	
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