package es2;

enum Segno{
	PARI,DISPARI;
}

class Player{
	
	/*@ spec_public @*/ int soldi;
	/*@ spec_public @*/ Segno segno;
	
	//@ public invariant soldi >= 0;
	
	//@ ensures soldi == 5;
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
	
	/*@ spec_public @*/ Player user;
	/*@ spec_public @*/ Player pc;
	
	//@ public invariant user != null;
	//@ public invariant pc != null;
	
	//@ ensures user.segno == Segno.DISPARI;
	//@ ensures pc.segno == Segno.PARI;
	public PariDispari(){
		this.user = new Player(Segno.DISPARI);
		this.pc = new Player(Segno.PARI);
	}
	
	//@ requires a > 0 && a < 6;
	//@ requires b > 0 && b < 6;
	//@ requires !this.finito();
	//@ code_bigint_math
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
	
	//@ ensures (user.soldi == 0 || pc.soldi == 0) <==> \result;
	//@ code_bigint_math
	public /*@ pure @*/ boolean finito() {
		if(user.soldi == 0 || pc.soldi == 0) return true;
		return false;
	}

	@Override
	public String toString() {
		return "user: " + user.toString() + "\t| pc: " + pc.toString();
	}
	
	

}
