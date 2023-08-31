package n2;

public class BagOfInt { 
	
	private/*@ spec_public @*/int[] a;
	private/*@ spec_public @*/int n; //la lunghezza del vettore
	
	//@ requires input != null;
	//@ ensures a != null;
	//@ ensures n > 0;
	public BagOfInt(int[] input) {
		a = input;
		n = input.length;
	}
	
	//@requires (\exists int x; x>=0 && x<n; a[x]==i); // pre: esiste almeno una occorrenza
	//@ensures \result == (\num_of int y; y >= 0 && y < n; a[y]==i );
	public int occurences(int i) {
		int output=0;
		for(int j=0; j<n; j++) {
			if (a[j] == i) {
				output++;
			}
		}
		return output;
	}
	
	//@ ensures \result == (\min int x; x>=0 && x < n; a[x]);
	public int extractMin() {
		int min = a[0];
		for(int j=0; j<n; j++) {
			if (a[j] < min) {
				min = a[j];
			}
		}
		return min;
	} 
}