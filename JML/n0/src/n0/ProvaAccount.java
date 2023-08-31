package n0;

public class ProvaAccount {
	
	public static void main(String[] args) {
		Account a1 = new Account();
		
		a1.deposita(50);
		a1.preleva(60);
		
		// violazione contratti
		a1.preleva(110);
		a1.deposita(-50);
	}

}
