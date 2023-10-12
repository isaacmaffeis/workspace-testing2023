package es5;

public class ProveCheckGreater {
	
	public static void main(String[] args) {
		
		CheckGreater c = new CheckGreater();
		c.check(new int [] {2,6,5,10}, 5);
		c.check(new int [] {2,6,5,9}, 7);
		System.out.println("Violazione contratti");
		// VIOLAZIONE CONTRATTI
		c.check(new int [] {}, 5);
		c.check(null, 0);
	}

}
