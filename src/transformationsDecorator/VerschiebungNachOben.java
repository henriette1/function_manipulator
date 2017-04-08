package transformationsDecorator;

/**
 * VerschiebungNachOben ist eine Unterklasse der abstrakten Klasse
 * TransformierteFunktion. Sie berechnet mit Hilfe des Verschiebungsfaktors, 
 * die Verschiebung der Funktion nach oben. 
 * 
 * @author Gruppe 4
 *
 */
public class VerschiebungNachOben extends TransformierteFunktion {

// 	Member-Variablen.

	private Funktion mFunktion;
	private double mVerschiebungsfaktorInY;
	
	/**
	 * Der Konstuktor weist der Variablen mFunktion die aktuelle Funktion zu. 
	 * Der Variablen mVerschiebungsfaktorInX wird eine Zahl zugewiesen, um 
	 * die verschoben werden soll. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 * @param c ist der Verschiebungsfaktor in die positive y-Richtung.
	 */
	public VerschiebungNachOben(Funktion aFunktion, double c) {
		mFunktion = aFunktion;
		mVerschiebungsfaktorInY = c;
	}
	/**
	 * Standardkonstruktor. Hier wird der Verschiebungsfaktor als 
	 * Default-Wert auf 0 gesetzt. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 */
	public VerschiebungNachOben(Funktion aFunktion) {
		mFunktion = aFunktion;
		mVerschiebungsfaktorInY = 0.;
	}
	/**
	 * Defaultkonstruktor. Dieser dient der Obejtkerzeugung ohne 
	 * vorgegebene Parameter. 
	 */
	protected VerschiebungNachOben() { }

	
	@Override
	public double getValue(double x) {
		return mFunktion.getValue(x) + mVerschiebungsfaktorInY;
	}

}
