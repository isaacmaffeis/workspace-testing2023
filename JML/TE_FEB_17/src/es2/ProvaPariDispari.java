package es2;

public class ProvaPariDispari {

	public static void main(String[] args) {
		
		// Comportamento Corretto
		
		PariDispari p = new PariDispari();
		p.tira(3, 1);
		System.out.println(p.toString());
		p.tira(4, 2);
		System.out.println(p.toString());
		p.tira(2, 2);		
		System.out.println(p.toString());
		p.tira(2, 4);
		System.out.println(p.toString());
		p.tira(2, 4);
		System.out.println(p.toString());
		p.finito();
		
		// Violazioni Contratto
		
		System.out.println("\nVIOLAZIONI CONTRATTI\n");

		
		PariDispari p2 = new PariDispari();
		p2.tira(6, 1);
		System.out.println(p2.toString());
		p2.tira(2, 0);
		System.out.println(p2.toString());
		p2.tira(2, 7);
		System.out.println(p2.toString());
		p2.tira(1, 2);
		System.out.println(p2.toString());
		p2.tira(1, 2);
		System.out.println(p2.toString());
		p2.tira(1, 2);
		System.out.println(p2.toString());
		p2.tira(1, 2);
		System.out.println(p2.toString());
		p2.tira(1, 2);
		System.out.println(p2.toString());
		p2.tira(1, 2);
		System.out.println(p2.toString());

	}

}
