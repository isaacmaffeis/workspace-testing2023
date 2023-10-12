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
	// Già Coperto con testX1
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
	// Già coperto con testX1
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
	// Già coperto con testY6
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
	
	/* MCDC Table:
	((x && (y || z)) && no_alarm)  R:
	  T     t  T x=F     T         T   testx1
	  F     t  T x       T         F   testX2
	  -------------------------------
	  T     T    F       T         T   testY5 (già presente -> testx1)
	  T     F    F       T         F   testY6
	  -------------------------------
	  T		F	 T		 T         T   testZ7
	  T		F    F       T		   F   testZ8 (già presente -> testY6)
	  -------------------------------
	  T		t  T x=F	 T		   T   testNoAlarm3 (già presente -> test x1)
	  T		t  T x		 F		   F   testNoAlarm4 
	*/
	
}