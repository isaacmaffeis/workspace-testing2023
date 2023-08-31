package n4;

public class ProvaMagazzino {

	public static void main(String[] args) {
		
		Magazzino m1 = new Magazzino();
		
		System.out.println("index: 0 is full? " + m1.isFull(0));
		m1.insert(0, 10);
		System.out.println("index: 0 is full? " + m1.isFull(0));
		for (int i = 1; i < 9; i++) {
			m1.insert(0, 10);
		}
		System.out.println("index: 0 is full? " + m1.isFull(0));
		System.out.println("all indexes are full? " + m1.isFull());
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 10; j++) {
				m1.insert(i, 10);
			}
		}
		System.out.println("all indexes are full? " + m1.isFull());
		
		// VIOLAZIONE CONTRATTI
		
		Magazzino m2 = new Magazzino();
		m2.insert(10, 10);
		m2.insert(0, 15);
		m2.isFull(5);
		
	}

}
