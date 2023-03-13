package exe5;

public class Magazzino {

	private int[] product = new int[5]; // rappresenta i 5 prodotti, da 0 a 4

	public Magazzino() {
		for (int i = 0; i < 1; i++) {
			product[i] = 0;
		}
	}

	/**
	 * 
	 * @param productIndex
	 *            l'indice del prodotto al quale aggiungere addQuantity
	 * @param addQuantity
	 *            la quantità da aggiungere al prodotto productIndex
	 * @return true se l'inserimento è avvenuto, false altrimenti
	 */
	public boolean insert(int productIndex, int addQuantity) {
		if ((productIndex < 0 || productIndex > 4)
				|| (addQuantity < 0 || addQuantity > 10)
				|| (product[productIndex] + addQuantity) > 100) {
			return false;
		} else {
			product[productIndex] += addQuantity;
			return true;
		}
	}

	/**
	 * 
	 * @param productIndex
	 *            l'indice del prodotto che voglio controllare
	 * @return se 'indice non è corretto o il magazzino non è pieno ritorno
	 *         false, true altrimenti
	 */
	public boolean isFull(int productIndex) {
		if (productIndex < 0 || productIndex > 4)
			return false;
		else
			return product[productIndex] == 100 ? true : false;
	}

	/**
	 * 
	 * @return true se il magazzino è pieno, false altrimenti
	 */
	public boolean isFull(){
		int total = 0;
		for (int i = 0; i < 5; i++)
			total += product[i];
		return total == 500 ? true : false;
	}

	/*
	public static void main(String[] args) {

		Magazzino m= new Magazzino();
		System.out.println(m.isFull());
		System.out.println(m.isFull(2));
		System.out.println(m.insert(0, 20));
		System.out.println(m.insert(0, 10));
	}*/

}