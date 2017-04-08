package transformationsDecorator;

/**
 * StreckungInX ist eine Unterklasse der abstrakten Klasse 
 * TransformierteFunktion. Sie berechnet mit Hilfe der getValue()-Methode und 
 * des Streckungsfaktors, die Streckung in x-Richtung.
 * 
 * @author Gruppe 4
 *
 */
public class StreckungInX extends TransformierteFunktion {
	
//	 Member-Variablen
	 
	private Funktion mFunktion;
	private double mStreckungsfaktorInX;
	
	/**
	 * Der Konstuktor weist der Variablen mFunktion die aktuelle Funktion zu. 
	 * Der Variablen mStreckungsfaktorInX wird eine Zahl zugewiesen, um 
	 * die in x-Richtung gestreckt werden soll. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 * @param b ist der Streckungsfaktor in x-Richtung.
	 * 
	 */
	public StreckungInX(Funktion aFunktion, double b) {
		mFunktion = aFunktion;
		mStreckungsfaktorInX = b;
	}
	/**
	 * Standardkonstruktor. Hier wird der Streckungsfaktor als 
	 * Default-Wert auf 1 gesetzt. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 */
	public StreckungInX(Funktion aFunktion) {
		mFunktion = aFunktion;
		mStreckungsfaktorInX = 1.;
	}
	/**
	 * Defaultkonstruktor. Dieser dient der Obejtkerzeugung ohne 
	 * vorgegebene Parameter. 
	 */
	protected StreckungInX() { }


	@Override
	public double getValue(double x) {
		double t = x;
		return mFunktion.getValue((1. / mStreckungsfaktorInX) * t);
	}
	
}
