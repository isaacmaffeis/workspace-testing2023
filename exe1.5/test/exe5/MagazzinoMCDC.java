package exe5;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagazzinoMCDC {

	@Test
	public void testConditionalAndMCDCCoverageInsert(){
		//testo il metodo insert
		Magazzino m1 = new Magazzino();
		assertFalse(m1.insert(-1,0));	//T,x,x,x,x
		assertFalse(m1.insert(5,0));	//F,T,x,x,x
		assertFalse(m1.insert(0,-1));	//F,F,T,x,x
		assertFalse(m1.insert(0,11));	//F,F,F,T,x
		assertTrue(m1.insert(0,0));	//F,F,F,F,F
		for(int i = 0; i < 10; i++){ //riempio 0 per testare l'ultima riga
			assertTrue(m1.insert(0, 10));
		}
		assertFalse(m1.insert(0,5));	//F,F,F,F,T
	}
	@Test
	public void testConditionalAndMCDCCoverageiFull(){
		//testo il metodo isFull(int n)
		Magazzino m2 = new Magazzino();
		m2.isFull(-1);
		m2.isFull(5);
		m2.isFull(0);
		
		//testo il metodo isFull()
		Magazzino m3 = new Magazzino();
		m3.isFull();
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 10 ; j++){
				m3.insert(i, 10);
			}
		}
		m3.isFull();		
	}
	
}