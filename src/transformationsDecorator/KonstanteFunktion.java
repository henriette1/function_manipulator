package transformationsDecorator;

/**
 * KonstanteFunktion ist eine Unterklasse der Klasse Polynomfunktion und
 * beschreibt die einfache konstante Funktion f(x) = 1.
 * 
 * @author Gruppe 4
 *
 */
public class KonstanteFunktion extends Polynomfunktion {
	
	/**
	 * Konstruktion ueber die Angabe des y-Achsenabschnitts.
	 * 
	 * @param koeff0 beschreibt den Abschnitt auf der y-Achse
	 * fuer die konstante Funktion y = const.
	 */
	public KonstanteFunktion(double koeff0) {
		super(koeff0);
	}
	/**
	 * Standardkonstruktor f(x) = 1.
	 */
	public KonstanteFunktion() {
		super(1.);
	}

}
