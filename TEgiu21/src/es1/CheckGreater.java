package es1;

public class CheckGreater {
	
	boolean check(int[] a, int b) {
		if (a != null && a.length > 0) {
			for (int x : a) {
				if (x > b && x % 2 == 0) 
					return true;
			}
		}
		return false;
	}

	
}
