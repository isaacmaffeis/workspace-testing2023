package exe6;

import static org.junit.Assert.*;

import org.junit.Test;

public class MCDCtestRushHour {

	@Test
	public void test() {
		RushHour r1 = new RushHour();
		assertFalse(r1.moveCar(-1, 0, 0));	// T x x x x x
		assertFalse(r1.moveCar(6, 0, 0));	// F x x x x x  
		assertFalse(r1.moveCar(0, -1, 0));	// F F T x x x
		assertFalse(r1.moveCar(0, 6, 0));	// F F F T x x
		assertFalse(r1.moveCar(0, 0, 0));	// F F F F T x
		assertFalse(r1.moveCar(0, 0, 5));	// F F F F F T
		assertTrue(r1.moveCar(2, 2, 1));	// F F F F F F
	}
	
	/*
	 * 	if (row < 0 || row > 5 || col < 0 || col > 5 || dir < 1 || dir > 4) 	R:
	 *  		T			x		x			x			x			x		T	Case1
	 *  		F			T		F			F			F			F		F	Case2
	 *  
	 *  		F			T		x			x			x			x		T	Case3
	 *  		F			F		F			F			F			F		F 	=Case2
	 * 
	 * 			F			F		F			T			x			x		T	Case4
	 * 			F			F		F			F			F			F		F	=Case2
	 * 
	 * 			F			F		F			F			T			x		T	Case5
	 * 			F			F		F			F			F			F		F	=Case2
	 * 
	 * 			F			F		F			F			F			T		T	Case6
	 * 			F			F		F			F			F			F		F	=Case2
	 */

}
