package esercizio6;

// versione 0: voglio provare cha almeno l'array non è null
// non riesco a provare nulla senza invariante
//
public class ArrayInClass0 {	
	
	/*@ spec_public@*/ int array[];
	
	//@ ensures array != null;
	//@ diverges true;
	ArrayInClass0() {
		array = new int[5];
		int i = 0;
		while (i < array.length) {
			array[i] = 0;
			i++;
		}
	}

	// INVALID
	
}
