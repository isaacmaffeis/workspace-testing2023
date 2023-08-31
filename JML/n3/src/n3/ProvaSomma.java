package n3;

public class ProvaSomma {

	public static void main(String[] args) {
		
		Somma.sum(new int[] {4,5,1});
		
		// violazioni
		Somma.sum(new int[] {});
		Somma.sum(null);

	}

}
