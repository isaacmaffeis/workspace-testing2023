package n5;

/* LightArray ha un array di 10 luci ognuna della quale può essere in stato accesa o spenta. 
 * Inizialmente sono tutte accese. 
 * Posso cambiare lo stato di una lampadina singola (toggle).
 * Posso decidere si spegnerle tutte (allOff) e questa operazione ha priorità rispetto al cambio di stato di una lampadina.
 * Scrivi il codice in Java con in contratti opportuni 
 * (la classe LightArray ha uno costruttore, il metodo alloff che spenge tutte le lampadine e toggle(i) che cambia lo stato alla lampadina i-esima).
 * Cerca di scrivere sia le precondizioni, che le postcondizioni dei metodi.
 * Cerca di scrivere anche invarianti. Testa i contratti JML con una classe main in cui chiami i diversi metodi.
 * Prova anche a modificare il codice e controlla che i contratti siano violati. 
 * Documenta bene le violazioni e le loro cause in commenti e nel file di documento.
 * Verifica (esercitazione successiva).
 * Copia il progetto precedente, togli tutte le cose statiche (anche il main) non usare gli enumerativi. 
 * Dimostra con key che i contratti siano rispettati.
 */

public class LightArray {
	
	private /*@ spec_public@*/ boolean [] lightArray;
	// true = accesa | false= spenta
	
	//@ public invariant lightArray != null;
	//@ public invariant lightArray.length == 10;
	
	//@ ensures (\forall int x; x>=0 && x<10; lightArray[x]==true);
	public LightArray() {
		lightArray = new boolean[10];
		//@ loop_invariant i >= 0 && i <= 10 && (\forall int y; y >= 0 && y < i; lightArray[y] == true);
		for (int i = 0; i < lightArray.length; i++) {
			lightArray[i] = true;
		}
	}
	
	//@ requires idx >= 0 && idx < 10;
	//@ ensures (\old(lightArray[idx]) == true) ==> (lightArray[idx]==false);
	//@ ensures (\old(lightArray[idx]) == false) ==> (lightArray[idx]==true);
	//@ ensures (\forall int j; 0 <= j && j < 10 &&  j!=idx; lightArray[j] == \old(lightArray[j]));
	public void toggle(int idx) {
		if(lightArray[idx])
			lightArray[idx] = false;
		else
			lightArray[idx] = true;
	} 
	
	//@ ensures (\forall int j; 0 <= j && j < 10; !lightArray[j]);
	public void alloff() {
		//@ loop_invariant i>=0 && i <= 10 && (\forall int y; y >= 0 && y < i; lightArray[y]==false);
		for (int i = 0; i < lightArray.length; i++) {
			lightArray[i] = false;
		}
	}
	
	// ESC 100% VALID
	
}
