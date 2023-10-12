package es6;

public class ProvaTelecamere {

	public static void main(String[] args) {
		Telecamere t1 = new Telecamere();
		
		for (int i = 0; i < t1.telecamere.length; i++) {
			System.out.println("Stato telecamera " + i +": " + t1.telecamere[i]);
		}
		t1.spegni(0);
		t1.spegni(1);
		// t1.spegni(2); // VIOLAZIONE CONTRATTO
		for (int i = 0; i < t1.telecamere.length; i++) {
			System.out.println("Stato telecamera " + i +": " + t1.telecamere[i]);
		}
		t1.accendi(0);
		t1.spegni(2);
		for (int i = 0; i < t1.telecamere.length; i++) {
			System.out.println("Stato telecamera " + i +": " + t1.telecamere[i]);
		}
		
		System.out.println("Violazioni contratti");
		
		// VIOLAZIONI CONTRATTI
		///*
		Telecamere t2 = new Telecamere();
		t2.accendi(0);
		t2.spegni(3);
		t2.spegni(0);
		t2.spegni(1);
		t2.spegni(2);
		t2.spegni(0);
		//*/

	}

}
