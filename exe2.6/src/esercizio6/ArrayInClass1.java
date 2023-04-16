package esercizio6;

// versione 1: posso almeno provare 
public class ArrayInClass1 {

	/*@ spec_public@*/ int array[];

	//@ ensures array != null;
	//@ diverges true;
	ArrayInClass1() {
		array = new int[5];
		int i = 0;
		//@ loop_invariant array!=null;
		while (i < 5) {
		//while (i < array.length) {
			array[i] = 0;
			i++;
		}
	}
	
	// INVALID
}
