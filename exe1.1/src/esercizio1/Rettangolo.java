package esercizio1;

import java.security.InvalidParameterException;

public class Rettangolo {

	
	private int base;
	private int altezza;
	
	public Rettangolo(int b, int a){
		if(b < 0) 
			throw new InvalidParameterException("Base non può essere negativa");
		base=b;
		altezza=a;
	}
	
	public int getPerimetro() {
		return base*2 + altezza *2;
	}
	
	public int getBase(){
		// self check
		assert base > 0 : "La base non può essere < 0";
		return base;
	}
	
	public int getAltezza(){
		return altezza;
	}
}