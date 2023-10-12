package es1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CheckGreaterParameterTest {

	int [] array;
	int value;
	
	@Parameters
	public static Collection<Object[]> setParams(){
		List<Object[]> params = new ArrayList<>();
		params.add(new Object[] {new int[] {1,5,7,10,5},5});
		params.add(new Object[] {new int[] {6,2,4,9},2});
		return params;
	}
	
	public CheckGreaterParameterTest(int[] a , int b) {
		this.array = a;
		this.value = b;
	}
	
	@Test
	public void test() {
		CheckGreater cg = new CheckGreater();
		assertTrue(cg.check(array,value));
	}

}
