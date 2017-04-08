package transformationsDecorator;

/**
 * VerschiebungNachLinks ist Unterklasse der Klasse 
 * VerschiebungNachRechts. Die Berechnung der Verschiebung nach links
 * wird in der Oberklasse VerschiebungNachRechts ueber die getValue()-Methode 
 * ausgefuehrt. In dieser Klasse werden lediglich die Parameter zugewiesen.
 * 
 * @author Gruppe 4
 *
 */
public class VerschiebungNachLinks extends VerschiebungNachRechts {
	/**
	 * In diesem Konstruktor wird der Konstruktor der Oberklasse 
	 * VerschiebugNachRechts aufgerufen. Diesem Oberklassenkonstruktor 
	 * werden die beiden Parameter zugewiesen. 
	 * Der Verschiebungsfaktor wird als negativer Wert an die Oberklasse 
	 * uebergeben. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 * @param d ist der Verschiebungsfaktor in die negative x-Richtung.
	 */
	public VerschiebungNachLinks(Funktion aFunktion, double d) {
		super(aFunktion, -d);
	}
	/**
	 * In diesem Konstruktor wird wieder der Oberklassenkonstruktor 
	 * aufgerufen. Ihm wird der Parameter aFunktionn uebergeben. Hier wird der
	 * Verschiebungsfaktor als Default-Wert auf 0 gesetzt. 
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 */
	public VerschiebungNachLinks(Funktion aFunktion) {
		super(aFunktion);
	}

}
