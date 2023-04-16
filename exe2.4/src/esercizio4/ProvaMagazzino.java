package esercizio4;

public class ProvaMagazzino {
	
	public static void main(String[] args) {
		Magazzino mag = new Magazzino();
		mag.insert(-5, 5);
		mag.insert(1, 10);
		mag.insert(0, 1);
		mag.insert(1, 9);
		mag.isFull();
		mag.isFull(1);
	}

}
