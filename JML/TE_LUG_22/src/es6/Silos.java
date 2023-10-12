package es6;

enum State{
	NASTRO, GRU;
}

class Cilindro{
	
	/*@ spec_public@*/ int capacity;
	
	//@ public invariant capacity >=0 && capacity <=12;
	
	//@ensures capacity==1;
	Cilindro(){
		this.capacity = 1;
	}

	@Override
	public String toString() {
		return capacity + "";
	}
	
	
}

public class Silos {
	
	/*@ spec_public@*/ Cilindro [] silos;
	/*@ spec_public@*/ State state;
	
	//@ public invariant silos != null && silos.length == 3 && (\forall int i;i>=0&&i<silos.length;silos[i]!=null);
	//@ public invariant (\forall int i; i>=0 && i<silos.length;silos[i].capacity<=10);
	
	//@ensures (\forall int i; i>=0 && i<silos.length;silos[i].capacity == 1);
	public Silos() {
		this.silos = new Cilindro [3];
		//@ loop_invariant i>=0 && i<=3 && (\forall int j; j>=0 && j<i;silos[j].capacity == 1);
		for (int i = 0; i < silos.length; i++) {
			silos[i] = new Cilindro();
		}
		this.state = State.GRU;
	}
	
	//@ requires idx>=0 && idx <=2;
	//@ requires quantita > 0 && quantita <=5;
	//@ requires silos[idx].capacity + quantita <= 10;
	//@ requires state == State.GRU;
	//@ ensures (silos[idx].capacity == (\old(silos[idx].capacity) + quantita));
	public void gru(int idx, int quantita) {
		switch (state) {
		case GRU:
			if(idx >= 0 && idx < 3 && quantita > 0 && quantita <= 5 && (silos[idx].capacity + quantita <= 10)) {
				silos[idx].capacity += quantita;
			}
			state = State.NASTRO;
			break;
		}
	}
	
	//@ requires state == State.NASTRO;
	//@ ensures (\forall int i; i>=0 && i<silos.length;(\old(silos[i].capacity<=2)) ==> silos[i].capacity == 0);
	//@ ensures (\forall int i; i>=0 && i<silos.length;(\old(silos[i].capacity>2)) ==> (silos[i].capacity == (\old(silos[i].capacity) - 2)));
	public void nastro() {
		switch (state) {
		case NASTRO:
			for (int i = 0; i < silos.length; i++) {
				if (silos[i].capacity <= 2)
					silos[i].capacity = 0;
				else
					silos[i].capacity -= 2;
			state = State.GRU;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < silos.length; i++) {
			sb.append("Cilindro " + i + ": " + silos[i].toString() + "\t");
		}
		sb.append("\n");
		return sb.toString();
	}
	
}
