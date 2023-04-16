package esercizio2;

public class ProveBagOfInt {

	public static void main(String[] args) {
		
		int a[] = {1,2,3,1,3,8,9,7,8,5,1,5};
		
		BagOfInt bag = new BagOfInt(a);
		
		bag.occurences(1);
		bag.extractMin();
		bag.occurences(0);

	}

}
