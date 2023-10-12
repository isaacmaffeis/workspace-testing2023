package es1;

public class Pioggia { 
	
	float[] pioggia = new float[12];
	//cambia il valore della pioggia del mese 
	
	Pioggia() {
		
	}
	
	boolean set(int mese, int valore) { 
		if (mese <0 || mese > 11 || valore < 0 || (valore > 100 && pioggia[mese] > 50))
			return false;
		pioggia[mese] = valore; 
		return true;
	} 
}