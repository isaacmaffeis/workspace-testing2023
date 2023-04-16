package esercizio0;

public class Account {

	private /*@ spec_public*/ int balance;

	//@ ensures balance>=0;
	public Account(){
		balance=100;
	}
	
	//pre: qta maggiore di 0
	//@ requires qta > 0;
	
	//pre: balance maggiore-uguale di qta
	//@ requires balance >= qta;
	
	//post: il valore di balance è stato modificato correttamente
	//@ ensures balance == \old(balance) - qta;
	
	//post: balance non può diventare negativo
	//@ ensures balance >= 0;
	public void preleva(int qta){
		balance-=qta;
	}
	
	//pre: qta maggiore di 0
	//@ requires qta > 0;
	
	//post: balance è stato modificato corretamente
	//@ ensures balance == \old(balance) + qta;
	//@ code_bigint_math
	public void deposita(int qta){
		balance+=qta;
	}

}