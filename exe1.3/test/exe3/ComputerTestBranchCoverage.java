package exe3;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputerTestBranchCoverage {
	
	@Test
	public void testBranchCoverage1() {
		int tempTest=10;
		int threshTest=20;
		boolean x=true;
		boolean y=true;
		boolean z=false;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);	
	}
	
	@Test
	public void testBrachCoverage2(){
		int tempTest=20;
		int threshTest=10;
		boolean x=false;
		boolean y=false;
		boolean z=true;
		Computer c1= new Computer();
		c1.Compute(x, y, z, tempTest, threshTest);
	}
	


}