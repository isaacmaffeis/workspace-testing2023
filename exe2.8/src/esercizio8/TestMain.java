package esercizio8;

public class TestMain {
	
	public static void main(String[] args) {
		
		Te_giugno_21 t = new Te_giugno_21();
		
		int a[] = {1,2,3,4,5,6};
		int b=5;
		System.out.println(t.check(a, b));
		System.out.println(t.check(a, 10));
		int c[] = {2};
		System.out.println(t.check(c, 0));
		System.out.println(t.check(c, 3));
		// Contratto violato per precondizioni
		int d[] = {};
		System.out.println(t.check(d, 0));
	}
}
