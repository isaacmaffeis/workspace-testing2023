package es5;

public class CheckGreater {
	
	//@ requires a!= null && a.length > 0;
	//@ ensures (\exists int i; i>=0 && i< a.length; a[i] > b && a[i] %2 == 0) <==> \result; 
	//@ code_bigint_math
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
