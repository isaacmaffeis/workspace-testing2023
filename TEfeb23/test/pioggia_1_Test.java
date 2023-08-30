import static org.junit.Assert.*;

import org.junit.Test;

public class pioggia_1_Test {
	
	/*	# (m < 1 || m > 12 || v <0 || (v > 100 && p[m - 1 ] > 50))	|	D
	 * 	1	T			-		-			-			-			|	T
	 * 	2	F			F		F			F			-			|	F
	 * 	3	F			T		-			-			-			|	T
	 * 	4	F			F		T			-			-			|	T
	 * 	5	F			F		F			T			T			|	T
	 * 	6	F			F		F			T			F			|	F
	 */

	@Test
	public final void mcdcTest1() {
		Pioggia p1 = new Pioggia();
		assertFalse(p1.set(0, 0));
	}
	
	@Test
	public final void mcdcTest2() {
		Pioggia p2 = new Pioggia();
		assertTrue(p2.set(5, 10));
	}
	
	@Test
	public final void mcdcTest3() {
		Pioggia p3 = new Pioggia();
		assertFalse(p3.set(13, 10));
	}
	
	@Test
	public final void mcdcTest4() {
		Pioggia p4 = new Pioggia();
		assertFalse(p4.set(1, -10));
	}
	
	@Test
	public final void mcdcTest5() {
		Pioggia p5 = new Pioggia();
		p5.set(11, 70);
		assertFalse(p5.set(11, 110));
	}
	
	@Test
	public final void mcdcTest6() {
		Pioggia p6 = new Pioggia();
		p6.set(5, 20);
		assertTrue(p6.set(6, 110));
	}
	
	// 100%

}
