package esercizio5;

public class Esempi {

	// ASSEGNAMENTI
	
	// restituisce x+1
	//@ ensures \result == x + 1;
	//@ code_bigint_math
	static int somma1(int x) {
		return x+1;
	}
		
	// restituisce il resto della divisione (senza usare %)  
	//@ requires x> 0 && y > 0;
	//@ ensures \result >= 0 && \result < y && (((x/y)*y + \result) == x);   
	static int resto(int x, int y) {
		return x%y;
	}
	
	// condizionali	
	//@ ensures \result >= x && \result >= y;
	//@ ensures \result == x || \result == y;	
	static int max(int x, int y) {
		return x > y ? x : y;
	}
	
	//@ ensures \result <==> (x==y);
	static boolean equals(int x, int y) {
		return x==y;
	}

	//@ ensures \result <= x && \result <= y;
	//@ensures \result == x || \result == y;
	static int min(int x, int y) {
		return x > y ? y : x;
	}
	
	// ESC OK

}
