package esercizio3;

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
	Somma(){}
	
	//@ requires a != null;
	//@ ensures \result == (\sum int x; x>=0 && x<a.length; a[x]);
	public /*@pure@*/ static int sum(int a[]){
		int sum=0;int i=0;
		//@loop_invariant sum==(\sum int j;j>=0 && j< i;a[j]);
		while(i<a.length){
			sum+=a[i];
			i++;
		}
		//@ assert i==a.length;
		return sum;
	}
}
