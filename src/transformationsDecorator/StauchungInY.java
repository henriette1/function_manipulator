package transformationsDecorator;
/**
 * StauchungInY ist Unterklasse der Klasse StreckungInY und wandelt
 * den Faktor passend um.
 * 
 * @author Gruppe 4
 *
 */
public class StauchungInY extends StreckungInY {
	
	/**
	 * In diesem Konstruktor wird der Konstruktor der Oberklasse 
	 * StreckungInY aufgerufen. Diesem Oberklassenkonstruktor 
	 * werden die beiden Parameter zugewiesen. 
	 * Der Stauchungsfaktor wird an die Oberklasse uebergeben.
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 * @param a ist der umzuwandelnde Stauchungsfaktor in y-Richtung.
	 */
	public StauchungInY(Funktion aFunktion, double a) {
		super(aFunktion, 1. / a);
	}
	/**
	 * Standardkonstruktor. Hier wird der Stauchungsfaktor als 
	 * Default-Wert auf 1 gesetzt. 
	 * 
	 * @param aFunktion ist der Stauchungsfaktor in y-Richtung.
	 */
	public StauchungInY(Funktion aFunktion) {
		super(aFunktion);
	}

}
