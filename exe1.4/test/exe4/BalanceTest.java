package exe4;

import static org.junit.Assert.*;

import org.junit.Test;

//TROVARE 2 INTERI PER LA COPERTURA DEI CASI DI TEST

public class BalanceTest {

	@Test
	public void testBalance() {
		Balance b=new Balance();
		assertNotNull("Oggetto Balance non nullo",b);
	}
	
	/*Costruisci oggetti Balance che abbiano valori di
	  p e w in grado di garantire la copertura delle istruzioni*/
	
	@Test
	public void testStatementCoverageBalance(){ //Incluso nel Branch, ogni riga deve essere eseguita
		Balance b1 = new Balance();
		assertTrue(b1.setBalanceValue(2, 200));
		Balance b2 = new Balance();
		assertFalse(b2.setBalanceValue(10, 50));
		assertEquals(b2.getP(), 10);
		assertEquals(b2.getW(), 50);	
	}
	
	/*Costruisci oggetti Balance che abbiano valori di
	  p e w in grado di garantire la copertura di tutti i rami (Branch).
	  DecisionCoverage è incluso nel Branch.
	  */
	
	@Test
	public void testBranchCoverageBalance(){
		Balance b1=new Balance();
		b1.setBalanceValue(3, 300);
		Balance b2=new Balance();
		b2.setBalanceValue(4, 300);	
	}
	
	/*Costruisci oggetti Balance che abbiano valori di
	  p e w in grado di garantire la copertura di tutte le singole condizioni all'interno
	  della decisione.
	  */
	
	@Test
	public void testConditionCoverageBalance(){
		Balance b1=new Balance(); 
		b1.setBalanceValue(3, 300); //T,T,NV,NV
		Balance b2=new Balance(); 
		b2.setBalanceValue(4, 300);	//F,NV,F,NV
		Balance b3=new Balance();
		b3.setBalanceValue(3, 500); //T,F,F,NV
		Balance b4=new Balance();
		b4.setBalanceValue(0, 500); //T,F,T,T
		Balance b5=new Balance();
		b5.setBalanceValue(0, 1200); //T,F,T,F
	}
	
	
	/*Costruisci oggetti Balance che abbiano valori di
	  p e w in grado di garantire copertura MCDC*/
	
	@Test
	public void testMCDCBalance(){
		Balance b1=new Balance(); 
		b1.setBalanceValue(3, 300); //T,T, {false}
		Balance b2=new Balance(); 
		b2.setBalanceValue(4, 300);	//F,T, {false}
		Balance b3=new Balance();
		b3.setBalanceValue(5, 300); //T,T, {false}
		Balance b4=new Balance();
		b4.setBalanceValue(3, 500); //T,F, {false}
		Balance b5=new Balance();
		b5.setBalanceValue(0, 500); //{false},T,T
		Balance b6=new Balance();
		b6.setBalanceValue(3, 500); //{false},F,T
		Balance b7=new Balance();
		b7.setBalanceValue(0, 500); //{false},T,T
		Balance b8=new Balance();
		b8.setBalanceValue(0, 1200); //{false},T,F	
	}
	
	
//	// MCDC
//	@Test
//	public void test3() {
//		Balance b3 = new Balance();
//		assertTrue(b3.setBalanceValue(2, 200)); // T T F x
//		Balance b4 = new Balance();
//		assertFalse(b4.setBalanceValue(10, 500)); // F F F x
//		Balance b5 = new Balance();
//		assertTrue(b5.setBalanceValue(0, 500)); // T F T T
//		Balance b6 = new Balance();
//		assertFalse(b6.setBalanceValue(0, 2000)); // T F T F
//		
//		
//	}
//	
//	/*
//	 * if((p<4 && w<=400) || (p==0 && w<=1000))
//	 * 		T		T			F		x			T   case1
//	 * 		F		x=F			F		x			F	case2
//	 * 
//	 * 		T		T			F		x			T  =case1
//	 * 		T		F			F		x			F  =case2
//	 * 
//	 * 		x=T		F			T		T			T  case3
//	 * 		x=T		F			T		F			F  case4
//	 * 
//	 * 		x=T		F			T		T			T  =case3
//	 * 		x=T		F			T		F			F  =case4
//	 * 
//	 */
	
	@Test
	public void assertTest(){
		Balance b1=new Balance();
		b1.setBalanceValue(3, 400);
		assertNotNull("Oggetto Balance non nullo",b1);
		assertEquals(3,b1.getP());
		assertEquals("Valore di P corretto",3,b1.getP());//+ costruttori per asserEquals
	    assertTrue(b1.getP()==3); //Condizione booleana vera
	    assertFalse(b1.getP()==4);//Condizione booleana falsa
	    assertEquals(400,b1.getW());
	}

}
