package n4;

/* Riprendi l’esercizio 4 dell’esercitazione 1 e scrivi i contratti JML.
 * Cerca di scrivere sia le precondizioni, che le postcondizioni dei metodi.
 * Cerca di scrivere anche invarianti.
 * Cerca di spostare nelle precondizioni alcuni controlli che facevi all'inizio dei metodi (ad esempio relativi agli indici).
 * Aggiungi anche questi contatti:
 *  • precondizione al metodo insert: esiste un prodotto con meno di 100 unita 
 *  • postcondizioni al metodo insert: 
 *    - la media dei prodotti a magazzino e minore o uguale a 100; 
 *    - la quantità dei prodotti diversi da productIndex è rimasta invariata.
 *  Prova i contratti JML con una classe main in cui chiami i diversi metodi. 
 *  Prova anche a modificare il codice e controlla che i contratti siano violati.
 */

public class Magazzino {

	private /*@ spec_public@*/ int[] product = new int[5]; // rappresenta i 5 prodotti, da 0 a 4

	//@ public invariant product != null && product.length==5;
	
	//@ ensures (\forall int x; x >= 0 && x < 5; product[x]==0);
	public Magazzino() {
		//@ loop_invariant i>=0 && i<=5 && (\forall int x; x>=0 && x<i; product[x]==0);
		for (int i = 0; i < 5; i++) {
			product[i] = 0;
		}
	}

	//@ requires productIndex >= 0 && productIndex <= 4;
	//@ requires addQuantity >= 0 && addQuantity <= 10;
	//@ ensures ((product[productIndex] + addQuantity) > 100) ==> (\result == false);
	//@ ensures (!((product[productIndex] + addQuantity) > 100)) ==> (\result == true);
	public boolean insert(int productIndex, int addQuantity) {
		if (/*(productIndex < 0 || productIndex > 4)
				|| (addQuantity < 0 || addQuantity > 10)
				|| */ (product[productIndex] + addQuantity) > 100) {
			return false;
		} else {
			product[productIndex] += addQuantity;
			return true;
		}
	}

	//@ requires productIndex >= 0 && productIndex < 5;
	//@ensures (product[productIndex] == 100) <==> (\result==true);
	public boolean isFull(int productIndex) {
		/*if (productIndex < 0 || productIndex > 4)
			return false;
		else*/
			return product[productIndex] == 100 ? true : false;
	}

	//@ensures (\exists int y; y>=0 && y<product.length;product[y]<100) ==> (\result == false);
	public boolean isFull(){
		int total = 0;
		//@ loop_invariant i >= 0 && i <= 5 && (\sum int x;x >= 0 && x < i; product[x]) == total;
		for (int i = 0; i < 5; i++)
			total += product[i];
		return total == 500 ? true : false;
	}

}