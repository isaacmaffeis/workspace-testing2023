package esercizio9;

/* Implementa il tutto in una classe LightArray.
 * LightArray ha un array di 10 luci ognuna della quale può essere in stato accesa o spenta.
 * Inizialmente sono tutte accese. Posso cambiare lo stato di una lampadina singola (toggle).
 * Posso decidere si spegnerle tutte (allOff) e questa operazione ha priorità rispetto al 
 * cambio di stato di una lampadina.
 * Scrivi il codice in Java con in contratti opportuni (la classe LightArray ha uno costruttore, 
 * il metodo alloff che spenge tutte le lampadine e toggle(i) che cambia lo stato alla lampadina i-esima).
 * Cerca di scrivere sia le precondizioni, che le postcondizioni dei metodi.
 */

public class LightArray {
	
	private /*@ spec_public @*/ boolean lightarray[];
	
	//@ public invariant lightarray != null && lightarray.length == 10;
	
	//@ ensures (\forall int i; 0<=i && i<lightarray.length;lightarray[i]==true);
	LightArray(){
		this.lightarray = new boolean[10];
		//@ loop_invariant 0<=i && i<=10 && (\forall int j; 0<=j && j<i; lightarray[j]);
		for(int i = 0; i < lightarray.length; i++) {
			lightarray[i] = true;
		}
	}
	
	//@ requires 0<=i && i<10;
	//@ ensures \old(lightarray[i]) != lightarray[i]; &&  (\forall int j; 0 <= j && j < 10 &&  j!=i; lightarray[j] == \old(lightarray[j])); 
	public void toggle(int i) {
		lightarray[i] = ! lightarray[i];
	}
	
	//@ ensures (\forall int i; 0 <= i && i < 10; !lightarray[i]);
	public void allOff() {
		//@ loop_invariant 0 <= i && i <= 10 && (\forall int j; 0 <= j && j < i; !lightarray[j]);
		for(int i = 0; i<lightarray.length;i++) {
			lightarray[i] = false;
		}
	}
}
