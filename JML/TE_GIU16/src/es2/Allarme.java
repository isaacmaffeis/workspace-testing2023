package es2;

public class Allarme {
	
	private /*@ spec_public @*/ boolean [] sensori;
	
	//@ public invariant sensori != null && sensori.length == 4;
	
	//@ensures (\forall int j; j>=0 && j < sensori.length; sensori[j] == false);
	public Allarme(){
		this.sensori = new boolean[4];
		//@ loop_invariant i>=0 && i<=sensori.length && (\forall int x; x>=0 && x<i; sensori[i] == false);
		for (int i = 0; i < sensori.length; i++) {
			sensori[i] = false;
		}
	}
	
	//@ requires sensore >= 0 && sensore < 4;
	//@ ensures (\old(sensori[sensore]) != sensori[sensore]) <==> \result;
	//@ ensures acceso && (!\old(sensori[sensore])) ==> sensori[sensore];
	public boolean setSensore(int sensore, boolean acceso) {
		if(acceso) {
			sensori[sensore] = true;
			return true;
		}
		else {
			int dx = (sensore - 1 + sensori.length) % sensori.length;
			int sx = (sensore + 1) % sensori.length;			
			if (sensori[dx] && sensori[sx]) {
				sensori[sensore] = false;
				return true;
			}
		}
		return false;
	}
	
	//@ requires sensore >= 0 && sensore < 4;
	//@ ensures \result == sensori[sensore];
	public boolean acceso(int sensore) {
		return sensori[sensore];
	}
	
	//@ ensures \result == false;
	public /*@ pure @*/ boolean pericolo() {
		return (!sensori[0] && !sensori[1]) || (!sensori[1] && !sensori[2])
				|| (!sensori[2] && !sensori[3]) || (!sensori[3] && !sensori[0]);
	}
	

}
