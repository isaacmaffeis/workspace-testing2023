package exe6;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class RedCarExitTest. Scenario in cui la macchina esce
 */
public class RedCarExitTest {
	
	@Test
	public void test() {
		RushHour puzzle = new RushHour();
		//sposto la macchina 4 verso sinistra
		assertTrue(puzzle.moveCar(3,5,4));
		//sposto la macchina 3 verso il basso
		assertTrue(puzzle.moveCar(2,5,3));
		//sposto la macchina rossa (1) verso destra per tre volte
		assertTrue(puzzle.moveCar(2,2,2));
		assertTrue(puzzle.moveCar(2,3,2));
		assertTrue(puzzle.moveCar(2,4,2));
		//controllo se la macchina rossa è all'uscita
		assertTrue(puzzle.redCarAtExit());
	}

}