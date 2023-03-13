package exe3;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputerTestMCDC {

	@Test
	public void testX1() {
		int tempTest=10;
		int threshTest=20;
		boolean x=true;
		boolean y=true;
		boolean z=false;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);	
	}
	
	@Test
	public void testX2(){
		int tempTest=10;
		int threshTest=20;
		boolean x=false;
		boolean y=true;
		boolean z=false;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);
	}
	
	@Test
	public void testNoAlarm3(){
		int tempTest=10;
		int threshTest=20;
		boolean x=true;
		boolean y=true;
		boolean z=false;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);
	}
	
	@Test
	public void testNoAlarm4(){
		int tempTest=20;
		int threshTest=10;
		boolean x=true;
		boolean y=true;
		boolean z=false;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);
	}

	@Test
	public void testY5(){
		int tempTest=10;
		int threshTest=20;
		boolean x=true;
		boolean y=true;
		boolean z=false;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);
	}
	@Test
	public void testY6(){
		int tempTest=10;
		int threshTest=20;
		boolean x=true;
		boolean y=false;
		boolean z=false;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);
	}

	@Test
	public void testZ7(){
		int tempTest=10;
		int threshTest=20;
		boolean x=true;
		boolean y=false;
		boolean z=true;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);
	}
	@Test
	public void testZ8(){
		int tempTest=10;
		int threshTest=20;
		boolean x=true;
		boolean y=false;
		boolean z=false;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);
	}
}