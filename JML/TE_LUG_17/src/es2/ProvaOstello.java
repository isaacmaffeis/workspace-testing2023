package es2;

public class ProvaOstello {
	
	public static void main(String[] args) {
		
		Ostello o = new Ostello();
		
		o.checkin(0, 0);
		o.checkin(0, 0);
		o.checkin(0);
		o.checkin(0);
		o.libera(0);
		o.checkin(0);
		System.out.println(o.toString());
		o.checkin(0);
		System.out.println(o.toString());
		
		System.out.println("\nViolazione Contratti\n");
		
		o.libera(10);
		o.checkin(0, 0);
		o.checkin(0);
		
	}

}
