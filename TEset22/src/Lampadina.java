
public class Lampadina {
	
	boolean accesa = false;
	
	// setta il voltaggio, accende o spegne la lampadina
	// restituisce true se lo stato cambia
	boolean setVoltes(float volt) {
		if(!accesa && (volt <= 13 || volt >= 11)) {
			accesa = true;
			return true;
		}
		if(accesa && volt <= 2) {
			accesa = false;
			return true;
		}
		return false;
	}

}
