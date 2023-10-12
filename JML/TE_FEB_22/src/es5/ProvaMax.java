package es5;

public class ProvaMax {

	public static void main(String[] args) {

		Maximum m = new Maximum();
		int [] a = new int[] {-5,0,4,8,2,5,11};
		System.out.println("Massimo pari di: " + "{-5,0,4,8,2,5,11} = "+ m.maxp(a));
		
		// Violazione Contratti
		m.maxp(null);		
		int [] c = new int[] {};
		m.maxp(c);
		
	}

}
