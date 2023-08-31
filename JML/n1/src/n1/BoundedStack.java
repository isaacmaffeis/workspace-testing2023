package n1;

public class BoundedStack{
	
	private /*@ spec_public*/Object[] elems;
	private /*@ spec_public*/int size=0;
	
	// invarianti:
	// size >= 0 e limitato dalla size di elems
	//@ public invariant size >= 0 && size < elems.length; 
	// elems non è nullo 
	//@ public invariant elems != null;
	// tutti gli elementi da 0 a size (escluso) sono non nulli ma 
	// quelli da size a length (escluso) sono NULLI (non ancora inseriti)
	//@ public invariant (\forall int i;i >= 0 && i < size; elems[i] != null);
	//@ public invariant (\forall int i; i>=size && i < elems.length; elems[i]==null);
	
	// pre: n > 0 
	//@ requires n>0;
	// post: elems ha n elementi
	//@ ensures elems.length == n;
	public BoundedStack(int n){
		elems= new Object[n];
	}
	
	// pre: non è pieno
	//@ requires size < elems.length;
	// post: size viene incrementato e l'oggetto viene inserito correttamente
	//@ ensures size==\old(size)+1;
	//@ ensures elems[\old(size)] == x;
	public void push(Object x){
		elems[size]=x; size++;
	}
	
	// pre: non è vuoto
	//@ requires size > 0;
	// post size decrementato, oggetto tolto (ma gli altri rimangono uguali)
	//@ ensures size==\old(size)-1;
	//@ ensures (\forall int i; i >= 0 && i < elems.length && i != size; elems[i]==\old(elems[i]));
	//@ ensures elems[size]==null;
	public void pop(){
		size--;
		elems[size]=null;
	}
	
	// pre: non è vuoto
	//@ requires size > 0;
	// post: restituisce l'ultimo oggetto
	//@ ensures \result==elems[size-1];
	public Object top(){
		return elems[size-1];
	}
	
}