package es5;

public class Maximum {
		
	Maximum(){
		
	}
	
	//@ requires a!=null && a.length > 0;
	//@ ensures (\exists int i; i>=0 && i<a.length; a[i]>0 && a[i] %2 == 0) ==> \result != -1;
	//@ ensures (\forall int j; j>=0 && j<a.length; \old(a[j]) == a[j]);
	//@ code_bigint_math
	int maxp(int[] a) {
		int maximum = -1;
			//if (! (a == null || a.length == 0)) {
				//@ loop_invariant i>=0 && i<= a.length;
				for (int i=0; i<a.length; i++) {
					if (a[i] > 0 && a[i] % 2 == 0 && a[i] > maximum)
						maximum = a[i];
				}
			//}
		return maximum;
	}

}
