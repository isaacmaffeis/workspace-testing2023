
public class Pioggia {
	
	private float [] pioggia = new float [12];
	
	boolean set(int mese, int valore) {
		if (mese < 1 || mese > 12 || valore <0 || (valore > 100 && pioggia[mese - 1 ] > 50))
			return false;
		pioggia[mese - 1] = valore;
		return true;
	}

}
