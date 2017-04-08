package transformationsDecorator;
/**
 * StauchungInX ist Unterklasse der Klasse StreckungInX und wandelt
 * den Faktor passend um.
 * 
 * @author Gruppe 4
 *
 */
public class StauchungInX extends StreckungInX {
	
	/**
	 * In diesem Konstruktor wird der Konstruktor der Oberklasse 
	 * StreckungInX aufgerufen. Diesem Oberklassenkonstruktor 
	 * werden die beiden Parameter zugewiesen. 
	 * Der Stauchungsfaktor wird an die Oberklasse uebergeben.
	 * 
	 * @param aFunktion ist die zu verarbeitende Funktion.
	 * @param b ist der umzuwandelnde Stauchungsfaktor in x-Richtung.
	 */
	public StauchungInX(Funktion aFunktion, double b) {
		super(aFunktion, 1. / b);
	}
	/**
	 * Standardkonstruktor. Hier wird der Stauchungsfaktor als 
	 * Default-Wert auf 1 gesetzt. 
	 * 
	 * @param aFunktion ist der Stauchungsfaktor in x-Richtung.
	 */
    public StauchungInX(Funktion aFunktion) { 
        super(aFunktion);
    }

}
