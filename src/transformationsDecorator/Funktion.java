package transformationsDecorator;

/**
 * Die Abstrakte Klasse Funktion ist die Oberklasse im Package 
 * transformationsDecorator.
 * 
 * @author Gruppe 4
 */
public abstract class Funktion {

	/**
	 * Funktion() ist der Standardkonstruktor.
	 */
	protected Funktion() { }
	
	/**
	 *Die abstrakte Methode getValue() liefert den Funktionswert y, 
	 * zum Argument x. Die Methode wird in den Unterklassen implementiert.
	 * Die Methode ist fuer die Berechnung der einzelnen Transformationen 
	 * zustaendig.
	 * 
	 * @param x ist das Argument.
	 * @return gibt den Funktionswert zum uebergebenen x-Wert zurück
	 */
	public abstract double getValue(double x);
		
}
