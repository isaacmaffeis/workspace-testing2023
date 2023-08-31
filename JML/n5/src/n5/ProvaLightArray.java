package n5;

public class ProvaLightArray {

	public static void main(String[] args) {
		
		LightArray la = new LightArray();
		
		la.toggle(0);
		la.toggle(5);
		la.toggle(9);
		la.alloff();
		
		// VIOLAZIONE CONTRATTI
		la.toggle(10);
		la.toggle(-5);

	}

}
