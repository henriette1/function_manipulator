package transformationsDecorator;

/**
 * SpiegelungAnY ist eine Unterklasse der abstrakten Klasse 
 * TransformierteFunktion und berechnet die Spiegelung an der y-Achse.
 * 
 * @author Gruppe 4
 *
 */
public class SpiegelungAnY extends TransformierteFunktion {
	
	private Funktion mFunktion;
	/**	 
	 * Der Konstruktor speichert die zu spiegelnde Funktion.
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 */
    public SpiegelungAnY(Funktion aFunktion) { 
        mFunktion = aFunktion; 
    }
    
	@Override
	public double getValue(double x) {
		return mFunktion.getValue(-x);
	}

}
