package exe6;

import static org.junit.Assert.*;

import org.junit.Test;

public class RushHourMCDCTest {

	@Test
	public void test() {

		// TEST
		// PRECEDENTE----------------------------------------------------------------------
		// eseguo qui l'inizializzazione per coprire anche il costruttore
		RushHour puzzle = new RushHour();
		// sposto la macchina 4 verso sinistra. OK 
		assertTrue(puzzle.moveCar(3, 5, 4));
		// provo un indice errato
		assertFalse(puzzle.moveCar(-1, 5, 4));
		// casi mancanti row<0 ||row>5 ||col<0 ||col>5||dir<1||dir>4
		assertFalse(puzzle.moveCar(10, 5, 4));
		assertFalse(puzzle.moveCar(3, -2, 4));
		assertFalse(puzzle.moveCar(3, 20, 4));
		assertFalse(puzzle.moveCar(3, 5, 0));
		assertFalse(puzzle.moveCar(3, 5, 5));

	}

}