package es1;

public class Max {
	
	public Max() {
		
	}
	
	public int maxp(int[] a) {
		int max = -1;
		if (! (a == null || a.length == 0)){
			for (int x : a) { 
				if (x > 0 && x % 2 == 0 && x > max) max = x;
				}
		}
		return max;
	}

}
