package esercizio8;

/* Dato il seguente programma in Java, che controlla se un array contiene un numero pari maggiore di b;
 * Scrivi i contratti e prova la correttezza. 
 * Puoi semplificare il codice se i contratti che metti rendono superflui alcuni controlli.
 * Puoi riscrivere il codice a tuo piacimento per portare a termine la dimostrazione.
 * Ricordati la sintassi dei quantificatori:
 * * (\forall <dominio>;<range_valori>;<condizione> )
 * * (\exists <dominio>;<range_valori>;<condizione> )
 */

public class Te_giugno_21 {
	
	public Te_giugno_21(){};
	
	//@ requires a != null && a.length > 0;
	//@ ensures ((\exists int i;0<=i && i<a.length;(a[i] > b && a[i]%2 == 0) ==> \result == true));
	//@ ensures (!(\exists int i;0<=i && i<a.length;(a[i] > b && a[i]%2 == 0)) ==> \result == false);
	// vale a dire che il risultato è vero se e solo se la condizione di esistenza è vera, cioè:
	//@ ensures ((\exists int i;0<=i && i<a.length;(a[i] > b && a[i]%2 == 0)) <==> \result == true);
	//@ code_bigint_math
	public /*@ pure @*/ boolean check(int[] a, int b){ 
		// if semplificato dalla precondizione del contratto 
		//if (a != null && a.length > 0) { 
			//@ loop_invariant i>=0 && i<=a.length;
		// mettere ancora la condizione se e solo se di result !
			for (int i=0;i < a.length ; i++) {
				if (a[i] > b && (a[i] % 2 == 0)) 
					return true;
				}
			// verifico la violazione di contratto restituendo true in ogni caso
			// return true;
			//}
		return false; 
	}
 }
