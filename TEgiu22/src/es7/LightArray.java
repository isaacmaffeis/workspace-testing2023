package es7;

enum Status{
	ON,OFF
}

class Light{
	
	Status status;
	
	Light(){
		this.status = Status.ON;
	}

	@Override
	public String toString() {
		return "" + status;
	}
	
}

public class LightArray {
	
	Light [] lightArray;
	
	public LightArray(){
		this.lightArray = new Light [10];
		for (int i = 0; i < lightArray.length; i++) {
			this.lightArray[i] = new Light();
		}
	}
	
	public void toggle(int idx) {
		if(idx >=0 && idx < lightArray.length) {
			if (lightArray[idx].status == Status.ON)
				lightArray[idx].status = Status.OFF;
			else
				lightArray[idx].status = Status.ON;
		}
	}
	
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
