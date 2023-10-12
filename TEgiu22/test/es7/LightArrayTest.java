package es7;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightArrayTest {

	@Test
	public void scenario1test() {
		LightArray la = new LightArray();
		
		for (Light light : la.lightArray) {
			assertTrue(light.status==Status.ON);
		}
		
		assertTrue(la.lightArray[5].status==Status.ON);
		la.toggle(5);
		assertTrue(la.lightArray[5].status==Status.OFF);
		
		assertTrue(la.lightArray[3].status==Status.ON);
		la.toggle(3);
		assertTrue(la.lightArray[3].status==Status.OFF);
		
		la.allOff();
		for (Light light : la.lightArray) {
			assertTrue(light.status==Status.OFF);
		}

	}
	
	

}
