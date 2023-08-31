package n2;

public class ProveBagOfInt {
	
	public static void main(String[] args) {
		BagOfInt b = new BagOfInt(new int[] {5,4,8,5,3,8,7,5});
		
		b.occurences(5);
		b.extractMin();
		
		/*
		// violazione contratti
		b.occurences(1);
		BagOfInt b2 = new BagOfInt(new int[] {});
		b2.occurences(5);
		b2.extractMin();
		*/
	}
}
