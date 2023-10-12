package es8;

enum State{
	NASTRO, GRU;
}

class Cilindro{
	
	int capacity;
	
	Cilindro(){
		this.capacity = 1;
	}

	@Override
	public String toString() {
		return capacity + "";
	}
}

public class Silos {
	
	Cilindro [] silos;
	State state;

	public Silos() {
		this.silos = new Cilindro [3];
		for (int i = 0; i < silos.length; i++) {
			silos[i] = new Cilindro();
		}
		this.state = State.GRU;
	}
	
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
