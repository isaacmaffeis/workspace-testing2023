package es6;

/* Ho 3 telecamere agli estremi di un terreno triangolare, ognuna delle quali può essere accesa o spenta. 
 * Inizialmente sono tutte accese.
 * Posso cambiare lo stato di una telecamera singola con un comando di accendi o spegni. 
 * Però non possono essere tutte spente 
 * (cioè se spengo una telecamera posso farlo solo se ce n’è almeno un’altra accesa, altrimenti non faccio nulla).
 * 
 * Scrivi il codice in Java con in contratti opportuni 
 * (la classe Telecamere ha uno costruttore, il metodo spegni(i) e accendi(i) che cambia lo stato della i-esima telecamera).
 * Cerca di scrivere sia le precondizioni, che le postcondizioni dei metodi.
 * Cerca di scrivere anche invarianti. Testa i contratti JML con una classe main in cui chiami i diversi metodi.
 * Prova anche a modificare il codice e controlla che i contratti siano violati. 
 * Documenta bene le violazioni e le loro cause nei commenti del codice.
 */

public class Telecamere {
	
	/*@ spec_public@*/ boolean [] telecamere;
	// true = accesa | false = spenta
	
	//@ public invariant telecamere != null;
	//@ public invariant telecamere.length == 3;
	//@ public invariant (\exists int x; x>=0 && x<3; telecamere[x]);
	
	//@ ensures (\forall int y; y>=0 && y<3; telecamere[y]);
	//@ diverges true;
	public Telecamere(){
		telecamere = new boolean[3];
		//@ loop_invariant i>=0 && i<=3 && (\forall int j;j>=0 && j<i;telecamere[j]);
		for (int i = 0; i < telecamere.length; i++) {
			telecamere[i]=true;
		}
	}
	
	//@ requires idx >= 0 && idx < 3;
	//@ requires telecamere[idx] == false;
	//@ ensures (\old(telecamere[idx]) == false) ==> (telecamere[idx] == true);
	//@ diverges true;
	public void accendi(int idx) {
		telecamere[idx] = true;
	}
	
	//@ requires idx >= 0 && idx < 3;
	//@ requires telecamere[idx] == true;
	//@ requires (\exists int t; t >=0 && t < 3 && t != idx; telecamere[t]);
	//@ ensures telecamere[idx] == false;
	//@ diverges true;
	public void spegni(int idx) {
		/*boolean altra_accesa=false;
		//@loop_invariant i>=0 && i<=3;
		for (int i = 0; i < telecamere.length; i++) {
			if(i!=idx && telecamere[i]) {
				altra_accesa=true;
			}
		}
		if(altra_accesa) {*/
			telecamere[idx] = false;
		//}
	}

}
