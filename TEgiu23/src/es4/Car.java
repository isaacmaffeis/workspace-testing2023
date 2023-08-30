package es4;

public class Car { 
	
	private int speed = 0;
	
	//ferma la macchina (decrementa speed di x tra 1 e 10) restituisce true // solo se la macchina è ferma 
	boolean stop(int decel) {
		if (decel >= 1 && decel <= 10 && speed > 0 && speed - decel <= 0){
			speed -= decel; 
			if (speed < 0) 
				speed = 0; 
			return true;
		}
		if (decel >= 1 && decel <= 10 && speed >= decel)
			speed -= decel;
		return false;
	}
	
	void acc(int step) {
		if (step >= 1 && step <= 4) 
			speed += step;
	}
}

/*
Scrivere i casi di test JUNIT per ottenere la copertura:
	- Delle istruzioni
	- Dei branch (solo quelli in più rispetto alle istruzion)
	 - MCDC
*/
