package es6;

public class ProvaLightArray {

	public static void main(String[] args) {

		LightArray la = new LightArray();
		
		System.out.print(la.toString());
		
		for (int i = 0; i < 10; i+=2) {
			la.toggle(i);
		}
		
		System.out.print(la.toString());

		la.allOff();
		
		System.out.print(la.toString());
		
		// VIOLAZIONE CONTRATTO
		
		la.toggle(15);

	}

}
