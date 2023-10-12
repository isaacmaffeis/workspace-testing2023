package es6;

enum Status{
	ON,OFF
}

class Light{
	
	/*@ spec_public@*/ Status status;
	
	Light(){
		this.status = Status.ON;
	}

	@Override
	public String toString() {
		return "" + status;
	}
	
}

public class LightArray {
	
	/*@ spec_public @*/ Light [] lightArray;
	
	//@ public invariant lightArray!= null && lightArray.length == 10;
	//@ public invariant (\forall int i;i>=0 && i<lightArray.length; lightArray[i] != null);
	
	//@ensures (\forall int i; i>=0 && i<lightArray.length; lightArray[i].status == Status.ON);
	public LightArray(){
		this.lightArray = new Light [10];
		//@ loop_invariant i>=0 && i<= 10 && (\forall int j;j>=0 && j<i; lightArray[j].status == Status.ON);
		for (int i = 0; i < lightArray.length; i++) {
			this.lightArray[i] = new Light();
		}
	}
	
	//@ requires idx>=0 && idx <10;
	//@ensures (\old(lightArray[idx].status==Status.ON)) ==> lightArray[idx].status==Status.OFF;
	//@ensures (\old(lightArray[idx].status==Status.OFF)) ==> lightArray[idx].status==Status.ON;
	public void toggle(int idx) {
		if(idx >=0 && idx < lightArray.length) {
			if (lightArray[idx].status == Status.ON)
				lightArray[idx].status = Status.OFF;
			else
				lightArray[idx].status = Status.ON;
		}
	}
	
	//@ensures (\forall int i; i>=0 && i<lightArray.length; lightArray[i].status == Status.OFF);
	public void allOff() {
		for (int i = 0; i < lightArray.length; i++) {
			lightArray[i].status = Status.OFF;
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0;i<lightArray.length;i++) {
			stringBuilder.append(i + ":" + lightArray[i].toString() + "\t");
		}
		stringBuilder.append("\n");
		return stringBuilder.toString();
	}

}
