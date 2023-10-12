package es1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxTest {

	@Test
	public final void statementTest() {
		Max m = new Max();
		int [] a = new int[] {2,3,6,8,9};
		assertEquals(m.maxp(a), 8);
	}
	
	//100% Statement
	
	@Test
	public final void bracnhTest1() {
		Max m = new Max();
		int [] a = new int[] {-5,3,7,9};
		assertEquals(m.maxp(a), -1);
	}
	
	@Test
	public void bracnhTest2() {
		Max m = new Max();
		assertEquals(m.maxp(null), -1);
	}
	
	// 100% Branch
	
	// Condition covered with branch coverage
	
	// MCDC
	
	@Test
	public void mcdcTest1(){
		Max m = new Max();
		int [] a = new int[0];
		assertEquals(m.maxp(a), -1);
	}
	
	@Test
	public void mcdcTest2(){
		Max m = new Max();
		int [] a = new int[] {-5,2,3,8,4};
		assertEquals(m.maxp(a), 8);
	}
	
	// %100 Term
	

}
