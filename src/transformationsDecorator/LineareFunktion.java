package transformationsDecorator;
/**
 * 
 * LineareFunktion ist eine Unterklasse der Klasse Polynomfunktion und
 * beschreibt die Funktionvon Grad 1.
 * 
 * @author Gruppe 4
 *
 */
public class LineareFunktion extends Polynomfunktion {

	/**
	 * Konstruktion ueber die Angabe der beiden Koeffizienten a_1 und a_0.
	 * 
	 * @param koeff1 beschreibt den Koeffizient der Variablen vom Grad 1.
	 * @param koeff0 beschreibt den y-Achsenabschnitt.
	 */
	public LineareFunktion(double koeff1, double koeff0) {
		super(koeff1, koeff0);
	}
	/**
	 * Konstruktion ueber die Angabe des Hauptkoeffizienten a_1.
	 * 
	 * @param koeff1 beschreibt den Koeffizient der Variablen von Grad 1.
	 */
	public LineareFunktion(double koeff1) {
		super(koeff1, 0.);
	}
	/**
	 * Standardkonstruktor fuer f(x) = x.
	 */
	public LineareFunktion() {
		super(1., 0.);
	}	

}
