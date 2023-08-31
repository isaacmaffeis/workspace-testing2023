package n0;

public class Account{
	
	private /*@ spec_public @*/ int balance;
	
	//post: l�account � creato con valore di balance 100
	//@ ensures balance == 100;
	public Account(){
		balance=100;
	}
	
	//pre: qta maggiore di 0;
	//@ requires qta > 0;
	//pre: balance maggiore-uguale di qta;
	//@ requires balance >= qta;
	//post: il valore di balance � stato modificato correttamente
	//@ ensures balance == \old(balance) - qta;
	//post: balance non pu� diventare negativo 
	//@ ensures balance >= 0;
	//@ code_bigint_math
	public void preleva(int qta){ 
		balance-=qta;
	}
	
	//pre: qta maggiore di 0; 
	//@ requires qta >= 0;
	//post: balance � stato modificato correttamente
	//@ ensures balance == \old(balance) + qta;
	//@ code_bigint_math
	public void deposita(int qta){ 
		balance+=qta;
	} 
	
}
