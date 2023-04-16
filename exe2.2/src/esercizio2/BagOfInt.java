package esercizio2;

public class BagOfInt { 
	private/*@ spec_public @*/int[] a;
	private/*@ spec_public @*/int n; //la lunghezza del vettore
	
	/*inizializza il vettore a e la lunghezza n*/
	//@requires input != null;
	//@ensures a != null;
	public BagOfInt(int[] input) {
		a = input;
		n = input.length;
}
	
	/*ritorna le occorrenze del numero i nel vettore a[]*/
	//@ ensures \result == (\num_of int y; y>= 0 && y <n; a[y] == i);
	public int occurences(int i) {
		int cont = 0;
		for (int j = 0; j < a.length; j++)
			if (a[j] == i)
				cont++;
		return cont;		
}
	
	/* ritorna il valore minimo contenuto in a[]*/
	//@ensures \result==(\min int x;x>=0 && x<n;a[x]);
	public int extractMin() {
		int min = a[0];
	
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		return min;
	}
}
