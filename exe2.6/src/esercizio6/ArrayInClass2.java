package esercizio6;

// versione 2: voglio dimostare che la length del vettore è 5
public class ArrayInClass2 {

	/*@ spec_public@*/ int array[];

	//@ ensures array != null && array.length == 5;
	//@ diverges true;
	ArrayInClass2() {
		array = new int[5];
		int i = 0;
		/*@ loop_invariant array!=null && array.length == 5;
		  @*/
		while (i < array.length) {
			array[i] = 0;
			i++;
		}
	}
	
	// INVALID
}
