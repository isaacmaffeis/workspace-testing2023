package eserciziosemaforo;

/* Verificare le seguenti proprietà:
 * 1. non accade mai che i semafori siano entrambi verdi
 * 2. il semaforo 2 può diventare sempre verde (non solo allo stato iniziale)
 * 3. se un semaforo è verde allora l’altro è rosso
 * 4. se entrambi i semafori sono rossi e viene scelto il semaforo 1, nello stato successivo il semaforo 1 è verde
 * 5. il semaforo 1 non può mai essere verde
 */

public class Semaforo {
	
	// ColoreSemaforo è un array di 2 posizioni che contiene il colore
	// del semaforo relativo alla sua posizione (0=SEM1, 1=SEM2)
	/*@ spec_public @*/ int[] semaforo; 
	
	// INVARIANTI:
	// 1) mi assicuro che i semafori siano sempre 2
	//@ public invariant semaforo.length == 2;
	// 2) mi assicuro che semaforo possa assumere solo i valori definiti nell'invariante ColoreSemaforo
	//@ public invariant (\forall int i; 0<=i && i<2;semaforo[i]==0 || semaforo[i]==1 || semaforo[i]==2);
	
	// POSTCONDIZIONI: mi assicuro che tutti i semafori all'inizio siano ROSSI
	//@ ensures semaforo[0]==0 && semaforo[1]==0;
	public Semaforo() {
		this.semaforo = new int[] {0, 0};
	}
	
	// PRECONDIZIONE: numSemaforo può essere solo 0 o 1
	//@ requires (numSemaforo == 0 || numSemaforo == 1);
	
	// POSTCONDIZIONI:
	// 1) Se sono entrambi rossi, numSemaforo è diventato verde
	//@ ensures ((\old(semaforo[0]==0) && \old(semaforo[1]==0)) ==> semaforo[numSemaforo] == 1);
	
	// 2a) Se numSemaforo era verde, allora numSemaforo è diventato giallo
	//@ ensures ( \old(semaforo[numSemaforo]==1) ==> semaforo[numSemaforo]==2);
	
	// 2b) Se numSemaforo era giallo, allora numSemaforo è diventato rosso
	//@ ensures (\old(semaforo[numSemaforo]==2) ==> semaforo[numSemaforo]==0);
	
	// 3) Quando numSemaforo è rosso e l'altro semaforo non è rosso, se chiedo di cambiare il
	// colore di numSemaforo allora il colore di numSemaforo NON cambia colore
	// NB: 1-numSemaforo = mi da il numero dell'altro semaforo
	//@ ensures ( (\old(semaforo[numSemaforo]==0)) && (\old(semaforo[1-numSemaforo]!=0)) ==> (semaforo[numSemaforo]== 0) );
	public void cambiaColore(int numSemaforo) {
		// se sono entrambi rossi, metto a verde numSemaforo
		if(semaforo[0]==0 && semaforo[1]==0) {
			semaforo[numSemaforo]=1;
		}
		// se chiedo di cambiare un semaforo che non è rosso, lo cambio
		else if(semaforo[numSemaforo]!=0) {
			// verde -> giallo
			if(semaforo[numSemaforo]==1) {
				semaforo[numSemaforo]=2;
			}
			// giallo -> rosso
			else if(semaforo[numSemaforo]==2) {
				semaforo[numSemaforo]=0;
			}
		}

	}
	
	//@ ensures semaforo != null;
	public int[] getSemaforo() {
		return semaforo;
		}
}
