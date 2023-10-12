package exe6;

import static org.junit.Assert.*;

import org.junit.Test;


public class RushHourIstruzioniTest {

	@Test
	public void test() {
		// eseguo qui l'inizializzazione per coprire anche il costruttore
		RushHour puzzle = new RushHour();
		assertFalse(puzzle.redCarAtExit());

		// riutilizzo il codice del test obbligatorio
		// sposto la macchina 4 verso sinistra
		assertTrue(puzzle.moveCar(3, 5, 4));
		// sposto la macchina 3 verso il basso
		assertTrue(puzzle.moveCar(2, 5, 3));
		// sposto la macchina rossa (1) verso destra per tre volte
		assertTrue(puzzle.moveCar(2, 2, 2));
		assertTrue(puzzle.moveCar(2, 3, 2));
		assertTrue(puzzle.moveCar(2, 4, 2));
		// controllo se la macchina rossa è all'uscita
		assertTrue(puzzle.redCarAtExit());

		// provo a spostare una macchina da casella vuota
		assertFalse(puzzle.moveCar(5, 5, 4));

		// provo a spostare verso l'alto una macchina al bordo
		assertFalse(puzzle.moveCar(0, 3, 1));
		// provo a spostare verso destra una macchina al bordo
		assertFalse(puzzle.moveCar(1, 5, 2));
		// provo a spostare verso il basso una macchina al bordo
		assertTrue(puzzle.moveCar(4, 1, 3));
		assertFalse(puzzle.moveCar(5, 1, 3));
		// provo a spostare verso sinistra una macchina al bordo
		assertTrue(puzzle.moveCar(5, 1, 4));
		assertFalse(puzzle.moveCar(5, 0, 4));
		// provo a spostare una macchina su una cella occupata
		assertFalse(puzzle.moveCar(3, 5, 4));
		// provo un indice errato
		assertFalse(puzzle.moveCar(-1, 5, 4));
		// sposto verso l'alto una macchina
		assertTrue(puzzle.moveCar(5, 0, 1));
	}

}