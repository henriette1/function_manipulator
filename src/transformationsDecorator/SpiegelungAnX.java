package transformationsDecorator;

/**
 * SpiegelungAnX ist eine Unterklasse der abstrakten Klasse 
 * TransformierteFunktion und berechnet die Spiegelung einer Funktion
 * an der x-Achse.
 * 
 * @author Gruppe 4
 *
 */
public class SpiegelungAnX extends TransformierteFunktion {

	private Funktion mFunktion;
	/**
	 * Der Konstruktor speichert die zu spiegelende Funktion.
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 */
	public SpiegelungAnX(Funktion aFunktion) { 
		mFunktion = aFunktion; 
	}
	
	@Override
	public double getValue(double x) {
		return -1 * mFunktion.getValue(x);
	}

}

