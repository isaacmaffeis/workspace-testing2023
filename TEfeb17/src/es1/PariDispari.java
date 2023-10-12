package es1;

enum Segno{
	PARI,DISPARI;
}

class Player{
	
	int soldi;
	Segno segno;
	
	Player(Segno segno){
		this.soldi = 5;
		this.segno = segno;
	}

	@Override
	public String toString() {
		return "soldi = " + soldi + ", segno = " + segno;
	}

}

public class PariDispari {
	
	Player user;
	Player pc;
	
	PariDispari(){
		this.user = new Player(Segno.DISPARI);
		this.pc = new Player(Segno.PARI);
	}
	
	public boolean tira(int a, int b) {
		if(finito() || a<1 || a>5 || b<1 || b> 5) return false;
		if( (a+b)%2==0) {
			user.soldi++;
			pc.soldi--;
		}
		else {
			user.soldi--;
			pc.soldi++;
		}
		return true;
	}
	
	public boolean finito() {
		if(user.soldi == 0 || pc.soldi == 0) return true;
		return false;
	}

	@Override
	public String toString() {
		return "user: " + user.toString() + "\t| pc: " + pc.toString();
	}
	
	

}
