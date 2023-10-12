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
public class ParametricTest {
	
	private int base;
	private int altezza;
	private int perimetroAtteso;
	
	@Parameters public static Collection<Integer[]> setParameters() {
		List<Integer[]> params = new ArrayList<>();
		params.add(new Integer[] {5,4,18});
		params.add(new Integer [] {4,4,16});
		params.add(new Integer [] {1,1,4});
		return params;
		
	}
	
	public ParametricTest(int a, int b, int peA) {
		base = b;
		altezza = a;
		perimetroAtteso = peA;
	}

	@Test
	public void test() {
		Rettangolo r = new Rettangolo(base, altezza);
		assertEquals(r.getPerimetro(), perimetroAtteso);
	}

}
