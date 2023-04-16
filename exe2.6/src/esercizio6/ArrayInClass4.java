package esercizio6;

// versione 4: inoltre non ho alcuna eccezione (index our of bound exception non accade mai)
// esplicto normal_behavior e in più devo aggiungere i limiti sull'accesso al'array
// devo anche dire cosa cambia (così garantisco che non cambio a)
public class ArrayInClass4 {

	/*@ spec_public @*/ int array[];

	//@ normal_behavior
	//@ ensures array != null  && array.length == 5 && (\forall int i; i >= 0 && i < array.length; array[i]==0);
	// @ diverges true;
	ArrayInClass4() {
		array = new int[5];
		int i = 0;
		//@ loop_invariant array!=null && 0<= i && i <= array.length && (\forall int x; 0<=x && x<i; array[x] ==0);
		// @ assignable array[*],i;
		while (i < array.length) {
			array[i] = 0;
			i++;
		}
	}
	
	// VALID
}
