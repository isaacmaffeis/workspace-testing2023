package exe3;

public class Computer {

	boolean Compute(boolean x, boolean y, boolean z, int temp, int thresh) {
		boolean no_alarm;
		if (temp <= thresh) {
			no_alarm = true;
		} else {
			no_alarm = false;
		}
		if ((x && (y || z)) && no_alarm)
			return true;
		else
			return false;
	}
	
}