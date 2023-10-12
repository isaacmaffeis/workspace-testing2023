package es1;


public class Ostello {

	Boolean [][] camere;
	
	Ostello() {
		this.camere = new Boolean[10][5];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				camere[i][j] = true;
			}
		}
	}
	
	public boolean checkin(int stanza, int letto) {
		if(!this.camere[stanza][letto] || stanza < 0 || stanza > 9 || letto < 0 || letto > 4 )
			return false;
		this.camere[stanza][letto] = false;
		return true;
	}
	
	public boolean checkin(int stanza) {
		if(stanza < 0 || stanza > 9)
			return false;
		for (int i = 0; i < 5; i++) {
			if(this.camere[stanza][i]) {
				this.camere[stanza][i] = false;
				return true;
			}
		}
		return false;
	}
	
	public boolean libera(int stanza) {
		if(stanza < 0 || stanza > 4)
			return false;
		for (int i = 0; i < 5; i++) {
			if(this.camere[stanza][i]) {
				return true;
			}
		}
		return false;
	}
	
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
	
}
