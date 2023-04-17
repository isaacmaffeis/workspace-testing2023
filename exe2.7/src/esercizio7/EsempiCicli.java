package esercizio7;

public class EsempiCicli {

	//@ requires timer >= 0 && timer <= 10;
	//@ ensures \result==0;
	public static int countdown(int timer) {
		/*@ loop_invariant timer>=0;@*/
		while(timer>0){
			timer --;
		}
		return timer;
	}

	
	
	//@ requires n >= 0;
	//@ ensures \result == n * n;		
	//@ code_bigint_math
	public static int quadrato(int n){
		int i = 0;
		int result = 0;
		//@ loop_invariant result == i*n;
		while (i != n){
			result += n;
			i++;
		}
		return result;
	}
	
	

}
