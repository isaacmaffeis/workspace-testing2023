package esercizio6;

// versione 3: e che gli elementi del vettore sono tutti 0
public class ArrayInClass3 {

	/*@ spec_public@*/ int array[];

	//@ ensures array != null  && array.length == 5 && (\forall int i; i >= 0 && i < array.length; array[i]==0);
	// @ diverges true;
	ArrayInClass3() {
		array = new int[5];
		int i = 0;
		//@ loop_invariant array!=null  && array.length == 5 && (\forall int x; 0<=x && x<i; array[x] ==0);
		// errore invariant array.length == 5, bisogna controllare l'indice i iterativamente
		while (i < array.length) {
			array[i] = 0;
			i++;
		}
	}
	
	// INVALID
}
