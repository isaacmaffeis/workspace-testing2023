package esercizio1;

public class ProveBoundedStack {
	
	
	public static void main(String[] args) {
		
		BoundedStack st = new BoundedStack(100);
		st.push(20);
		st.push("prova");
		st.pop();
		st.top();
		st.pop();
		st.pop();
		st.pop();
		
		BoundedStack st2 = new BoundedStack(-5);
		
	}
	


}
