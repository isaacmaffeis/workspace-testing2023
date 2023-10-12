package es6;

import java.util.Random;

/* Nella stanza ci sono 6 persone ed una moderatrice, 
 * inizialmente le persone sono nello stato di ascolto e la moderatrice ha la parola. 
 * Ogni persona può essere in ascolto, in attesa di parlare o parlare.
 * Ad ogni passo di simulazione:
 * 	• vengono considerate tutte le persone:
 * 		o se la persona sta parlando e non ha esaurito il tempo a disposizione per parlare continua a parlare e viene diminuito il tempo a disposizione.
 * 		 	Quando il tempo termina torna nello stato di ascolto. 
 * 			Il tempo a disposizione è di 5 minuti.
		o se sono in attesa di parlare viene diminuito il tempo per cui sono disposte ad attendere prima di parlare,
			nel caso il tempo si esaurisca decidono di non restare più in attesa e tornano in semplice ascolto.
			Il tempo massimo di attesa di parlare è di 7 minuti.
		o se sono in ascolto, continuano ad ascoltare o se non c’è nessuna persona che vuole parlare e nessuna parla, 
		la moderatrice continua a parlare lei.
 *  • una nuova persona decide di mettersi in attesa per parlare con una probabilità del 30% 
 *  (simula la probabilità con un intero da 1 a 10 ad esempio) soltanto se si trova nello stato di ascolto. 
 *  La persona può decidere in qualsiasi istante (anche mentre la moderatrice sta parlando) di voler parlare. 
 *  Per gli scenari usa step until oppure introduci delle variabili monitorate (puoi fare diverse versioni)
 *  • la moderatrice gestisce le persone: se una persona ha finito il tempo, 
 *  la moderatrice sceglie la prossima persona che parli tra quelle che sono in attesa di parlare
 * 
 */

enum Stato{
	ASCOLTO,IN_ATTESA,PARLARE;
}

enum Moderatrice{
	PARLA, DA_PAROLA,ASCOLTA;
}

enum Microfono{
	ON, OFF;
}

class Persona {
	Stato stato;
	Microfono microfono;
	int tempoAttesa;
	
	Persona(){
		this.stato = Stato.ASCOLTO;
		this.microfono = Microfono.OFF;
		this.tempoAttesa = 0;
	}
	
	void mettiInAttesa() {
		if (this.stato == Stato.IN_ATTESA) return;
		this.stato = Stato.IN_ATTESA;
		this.tempoAttesa = 0;
	}
	
	void faiParlare() {
		this.stato = Stato.PARLARE;
		this.microfono = Microfono.ON;
	}

	@Override
	public String toString() {
		//return "[stato=" + stato + ", microfono=" + microfono + ", tempoAttesa=" + tempoAttesa + "]";
		return stato + ", " + microfono + ", " + tempoAttesa;
	}	
}

public class TalkShow {
	
	Persona [] persone;
	Moderatrice moderatrice;
	Microfono microfonoModeratrice;
	int tempoParlare;
	Random random = new Random();
	
	TalkShow(){
		persone = new Persona[6];
		for (int i = 0; i < persone.length; i++) {
			persone[i] = new Persona();
		}
		moderatrice = Moderatrice.PARLA;
		microfonoModeratrice = Microfono.ON;
		tempoParlare = 0;
	}
	
	private boolean isRichiesta() {
		for (int i = 0; i < persone.length; i++) {
			if(persone[i].stato == Stato.IN_ATTESA)
				return true;
		}
		return false;
	}
	
	private boolean isNessunoParla() {
		for (int i = 0; i < persone.length; i++) {
			if(persone[i].stato == Stato.PARLARE)
				return false;
		}
		return true;
	}
	
	private void personaParla() {
		for(int i = 0; i < persone.length; i++) {
			if(persone[i].stato == Stato.PARLARE) {
				if(tempoParlare > 1)
					tempoParlare -= 1;
				else {
					tempoParlare = 0;
					persone[i].stato = Stato.ASCOLTO;
				}
			}	
		}
	}
	
	private void personaAttesa() {
		for(int i = 0; i < persone.length; i++) {
			if(persone[i].stato == Stato.IN_ATTESA) {
				if(persone[i].tempoAttesa > 1)
					persone[i].tempoAttesa -= 1;
				else {
					persone[i].tempoAttesa = 0;
					persone[i].stato = Stato.ASCOLTO;
				}
			}	
		}
	}
	
	public void richiesta() {
		for(int i = 0; i < persone.length; i++) {
			if(random.nextInt(11) > 7)
				persone[i].mettiInAttesa();
		}
	}
	
	public void r_moderatrice() {
		switch (moderatrice) {
		case PARLA:
			if (isRichiesta()) 
				moderatrice = Moderatrice.DA_PAROLA;
			break;
		case DA_PAROLA:
			for (int i = 0; i < persone.length; i++) {
				if(persone[i].stato == Stato.IN_ATTESA) {
					persone[i].faiParlare();
					this.tempoParlare = 5;
					this.microfonoModeratrice = Microfono.OFF;
					this.moderatrice = Moderatrice.ASCOLTA;
					return;
				}
			}
			break;
		case ASCOLTA:
			if (isNessunoParla()) {
				moderatrice = Moderatrice.PARLA;
				microfonoModeratrice = Microfono.ON;
			}
			else {
				personaParla();
			}
			break;
		}
		personaAttesa();
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < persone.length; i++) {
			s.append(i + ": " + persone[i].toString() + "\t");
		}
		
		s.append("M:" + moderatrice + ", " + microfonoModeratrice + ", " + tempoParlare);
		
		s.append("\n");
		
		return s.toString();
	}

}
