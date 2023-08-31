package n3;

/* Implementare la classe Somma, la quale nel metodo public /*@pure@*_/ 
 * static int sum(int a[]) , va a sommare i valori contenuti nel vettore a[] mediante un ciclo. 
 * Definire i seguenti contratti:
 * • Pre-condizione: a[] non nullo; 
 * • Post-condizione: il risultato deve avere lo stesso valore della somma dei valori in a[];
 * Utilizzare inoltre nel metodo la clausola @loop_invariant. 
 * Gli invarianti devono essere quindi veri prima e dopo il ciclo. 
 * Testare infine con una classe Main.class
 */

public class Somma {
	
	//@ requires a!=null && a.length >= 0;
	//@ensures \result == (\sum int x; x >= 0 && x < a.length; a[x]);
	public /*@pure@*/ static int sum(int a[]){
		int somma = 0;
		//@ loop_invariant a!=null && i>=0 && i <= a.length && somma==(\sum int y; y >= 0 && y < i; a[y]);
		for(int i=0; i < a.length; i++) {
			somma += a[i];
		}
		
		return somma;
	}


}
