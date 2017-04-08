package transformationsDecorator;

/**
 * VerschiebungNachUnten ist Unterklasse der Klasse 
 * VerschiebungNachOben. Die Berechnung der Verschiebung nach unten
 * wird in der Oberklasse VerschiebungNachOben über die getValue()-Methode 
 * ausgefuehrt. In dieser Klasse werden lediglich die Parameter zugewiesen.
 * 
 * @author Gruppe 4
 *
 */
public class VerschiebungNachUnten extends VerschiebungNachOben {

	/**
	 * In diesem Konstruktor wird der Konstruktor der Oberklasse 
	 * VerschiebugNachOben aufgerufen. Diesem Oberklassenkonstruktor 
	 * werden die beiden Parameter zugewiesen. 
	 * Der Verschiebungsfaktor wird als negativer Wert an die Oberklasse 
	 * uebergeben.  
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 * @param c ist der Verschiebungsfaktor in die negative y-Richtung.
	 */
	public VerschiebungNachUnten(Funktion aFunktion, double c) {
		super(aFunktion, -c); 
	}
	/**
	 * In diesem Konstruktor wird wieder der Oberklassenkonstruktor 
	 * aufgerufen. Ihm wird der Parameter aFunktionn uebergeben.
	 * Hier wird der Verschiebungsfaktor als Default-Wert auf 0 gesetzt.
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 */
	public VerschiebungNachUnten(Funktion aFunktion) {
		super(aFunktion);
	}

}
