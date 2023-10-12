package es2;

public class Ostello {

	/*@ spec_public @*/ Boolean [][] camere;
	
	//@ public invariant camere!= null;
	
	//@ ensures (\forall int i; i>= 0 && i < 10; (\forall int j; j>=0 && j < 5; camere[i][j] == true));
	Ostello() {
		this.camere = new Boolean[10][5];
		//@ loop_invariant i >= 0 && i <= 10;
		for (int i = 0; i < 10; i++) {
			//@ loop_invariant j >= 0 && j <= 5;
			for (int j = 0; j < 5; j++) {
				camere[i][j] = true;
			}
		}
	}
	
	//@ requires stanza >= 0 && stanza < 10;
	//@ requires letto >= 0 && letto < 5;
	//@ ensures !this.camere[stanza][letto];
	public boolean checkin(int stanza, int letto) {
		if(!this.camere[stanza][letto] /*|| stanza < 0 || stanza > 9 || letto < 0 || letto > 4 */)
			return false;
		this.camere[stanza][letto] = false;
		return true;
	}
	
	//@ requires stanza >= 0 && stanza < 10;
	//@ ensures (\exists int j; j >= 0 && j < 5; this.camere[stanza][j]) ==> \result;
	public boolean checkin(int stanza) {
		/*if(stanza < 0 || stanza > 9)
			return false;*/
		//@ loop_invariant i >= 0 && i <= 5;
		for (int i = 0; i < 5; i++) {
			if(this.camere[stanza][i]) {
				this.camere[stanza][i] = false;
				return true;
			}
		}
		return false;
	}
	
	//@ requires stanza >= 0 && stanza < 10;
	//@ ensures (\exists int j; j >= 0 && j < 5; this.camere[stanza][j]) <==> \result;
	public boolean libera(int stanza) {
		if(stanza < 0 || stanza > 4)
			return false;
		//@ loop_invariant i >= 0 && i <= 5;
		for (int i = 0; i < 5; i++) {
			if(this.camere[stanza][i]) {
				//@ assert this.camere[stanza][i];
				return true;
			}
		}
		return false;
	}
	/*
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\t");
		for (int i = 0; i < 5; i++) {
			s.append(i + "\t");
		}
		s.append("\n");
		for (int i = 0; i < 10; i++) {
			s.append(i + "\t");
			for (int j = 0; j < 5; j++) {
				s.append(camere[i][j] + "\t");
			}
			s.append("\n");
		}
		return s.toString();
	}
	*/
}
