package esercizio1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RetangoloTestParametrici {
	
	Rettangolo r;
	int base;
	int altezza;
	int perimetroAtteso;
	
	@Parameters
	public static Collection <Integer[]> setParameters(){
		List<Integer[]> params = new ArrayList<>();
		params.add(new Integer[] {0,0,0});
		params.add(new Integer[] {5,7,24});
		params.add(new Integer[] {4,4,16});

		return params;
	}
	
	public RetangoloTestParametrici(int b, int a, int pA) {
		base = b;
		altezza = a;
		r = new Rettangolo(a,b);
		perimetroAtteso = pA;
	}
	
	@Test
	public void testCalcolaPerimetro() {
		int p = r.getPerimetro();
		assertEquals(perimetroAtteso,p);
	}

}
