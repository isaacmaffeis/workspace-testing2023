package esercizio2;

public class Light {

	boolean lightOn = false;
	boolean bottomIn = false;
	boolean bottomOut = false;

	Light() {
	}

	public boolean onOff(boolean light, boolean in, boolean out) {

		this.bottomIn = in;
		this.bottomOut = out;

		if ((bottomIn || bottomOut) && !light) {
			lightOn = true;
			return true; // luce accesa
		} else {
			lightOn = false;
			return false; // luce spenta
		}
	}
}