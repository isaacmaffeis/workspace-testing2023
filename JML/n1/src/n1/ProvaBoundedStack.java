package n1;

public class ProvaBoundedStack {
	
	public static void main(String[] args) {
		BoundedStack b1 = new BoundedStack(5);
		
		b1.push(10);
		b1.push(20);
		b1.push(30);
		b1.pop();
		b1.push(40);
		b1.push(50);
		b1.top();
		
		///*
		//violazioni
		b1.push(70);
		BoundedStack b2 = new BoundedStack(5);
		b2.pop();
		b2.top();
		// */

		
	}

}
