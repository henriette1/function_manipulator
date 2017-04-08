package transformationsDecorator;

/**
 * StreckungInY ist eine Unterklasse der abstrakten Klasse 
 * TransformierteFunktion. Sie berechnet mit Hilfe der getValue()-Methode und 
 * des Streckungsfaktors, die Streckung in y-Richtung.
 * 
 * @author Gruppe 4
 *
 */
public class StreckungInY extends TransformierteFunktion {
	
//	 Member-Variablen
	 
	private Funktion mFunktion;
	private double mStreckungsfaktorInY;
	
	/**
	 * Der Konstuktor weist der Variablen mFunktion die aktuelle Funktion zu. 
	 * Der Variablen mStreckungsfaktorInX wird eine Zahl zugewiesen, um 
	 * die in y-Richtung gestreckt werden soll. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 * @param a ist der Streckungsfaktor in y-Richtung.
	 */
	public StreckungInY(Funktion aFunktion, double a) {
		mFunktion = aFunktion;
		mStreckungsfaktorInY = a;
	}
	/**
	 * Standardkonstruktor. Hier wird der Streckungsfaktor als 
	 * Default-Wert auf 1 gesetzt. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 */
	public StreckungInY(Funktion aFunktion) {
		mFunktion = aFunktion;
		mStreckungsfaktorInY = 1.;
	}
	/**
	 * Defaultkonstruktor. Dieser dient der Obejtkerzeugung ohne 
	 * vorgegebene Parameter. 
	 */
	protected StreckungInY() { }


	@Override
	public double getValue(double x) {
		return mStreckungsfaktorInY * mFunktion.getValue(x);
	}

}
