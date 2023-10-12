package es1;

public class Pioggia {

	float[] pioggia = new float[12];

	// restituisce true se in un mese pari ha piovuto
	// più di valore (oppure …)
	boolean hasRainedGT_EM(float valore) {
		for (int mese = 0; mese < 12; mese++) {
			if (valore < 0 || valore > 1000 || (mese % 2 == 0 && pioggia[mese] > valore))
				return true;
		}
		return false;
	}
}