package es6;

public class ProvaSilos {

	public static void main(String[] args) {

		Silos s = new Silos();
		
		System.out.print(s.toString());
		
		s.gru(0, 4);
		
		System.out.print(s.toString());
		
		s.nastro();
		
		System.out.print(s.toString());
		
		s.gru(1, 5);

		System.out.print(s.toString());

		s.nastro();
		
		System.out.print(s.toString());
		
		// VIOLAZIONE CONTRATTI
		
		System.out.println("VIOLAZIONE CONTRATTI");

		s.gru(1, 10);
		s.gru(1, 5);
		s.nastro();
		s.gru(1, 5);
		s.nastro();
		s.gru(1, 5);
		s.nastro();
		System.out.print(s.toString());
		s.gru(1, 5);
		s.nastro();
		System.out.print(s.toString());
		s.gru(1, 5);
		s.nastro();
		s.nastro();
		System.out.print(s.toString());

	}

}
