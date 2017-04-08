package transformationsDecorator;

/**
 * VerschiebungNachRechts ist eine Unterklasse der abstrakten Klasse
 * TransformierteFunktion. Sie berechnet mit Hilfe des Verschiebungsfaktors, 
 * die Verschiebung der Funktion nach rechts.
 * 
 * @author Gruppe 4
 *
 */
public class VerschiebungNachRechts extends TransformierteFunktion {
	
//	Member-Variablen
	
	private Funktion mFunktion;
	private double mVerschiebungsfaktorInX;
	
	/**
	 * Der Konstuktor weist der Variablen mFunktion die aktuelle Funktion zu. 
	 * Der Variablen mVerschiebungsfaktorInX wird eine Zahl zugewiesen, um 
	 * die verschoben werden soll. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 * @param d ist der Verschiebungsfaktor in die positive x-Richtung.
	 */
	public VerschiebungNachRechts(Funktion aFunktion, double d) {
		mFunktion = aFunktion;
		mVerschiebungsfaktorInX = d;
	}
	/**
	 * Standardkonstruktor. Hier wird der Verschiebungsfaktor als
	 * Default-Wert auf 0 gesetzt. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 */
	public VerschiebungNachRechts(Funktion aFunktion) {
		mFunktion = aFunktion;
		mVerschiebungsfaktorInX = 0.;
	}
	/**
	 * Defaultkonstruktor. Dieser dient der Obejtkerzeugung ohne 
	 * vorgegebene Parameter. 
	 */
	protected VerschiebungNachRechts() { }


	@Override
	public double getValue(double x) {
		return mFunktion.getValue(x - mVerschiebungsfaktorInX);
	}

}
