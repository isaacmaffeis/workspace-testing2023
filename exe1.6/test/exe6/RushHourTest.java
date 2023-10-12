package exe6;

import static org.junit.Assert.*;

import org.junit.Test;

public class RushHourTest {

	@Test
	public void test() {
		RushHour rh = new RushHour();
		rh.moveCar(-1, -1, 0);
		rh.moveCar(-1, -1, 1);
		rh.moveCar(-1, -1, 5);
		rh.moveCar(-1, 1, 0);
		rh.moveCar(-1, 1, 1);
		rh.moveCar(-1, 1, 5);
		rh.moveCar(-1, 6, 0);
		rh.moveCar(-1, 6, 1);
		rh.moveCar(-1, 6, 5);
		//
		rh.moveCar(1, -1, 0);
		rh.moveCar(1, -1, 1);
		rh.moveCar(1, -1, 5);
		rh.moveCar(1, 1, 0);
		rh.moveCar(1, 1, 1);
		rh.moveCar(1, 1, 5);
		rh.moveCar(1, 6, 0);
		rh.moveCar(1, 6, 1);
		rh.moveCar(1, 6, 5);
		//
		rh.moveCar(6, -1, 0);
		rh.moveCar(6, -1, 1);
		rh.moveCar(6, -1, 5);
		rh.moveCar(6, 1, 0);
		rh.moveCar(6, 1, 1);
		rh.moveCar(6, 1, 5);
		rh.moveCar(6, 6, 0);
		rh.moveCar(6, 6, 1);
		rh.moveCar(6, 6, 5);
	}
}