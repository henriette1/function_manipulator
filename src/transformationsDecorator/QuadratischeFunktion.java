package transformationsDecorator;

/**
 * QuadratischeFunktion ist eine Unterklasse der Klasse Polynomfunktion und
 * beschreibt eine Funktion zweiten Grades.
 * 
 * @author Gruppe 4
 *
 */
public class QuadratischeFunktion extends Polynomfunktion {
	/**
	 * Konstruktion ueber die Angabe der drei Koeffizienten a_2, a_1 und a_0.
	 * 
	 * @param koeff2 beschreibt den Koeffizient der Variablen vom Grad 2
	 * @param koeff1 beschreibt den Koeffizient der Variablen vom Grad 1
	 * @param koeff0 beschreibt den y-Achsenabschnitt.
	 */
	public QuadratischeFunktion(double koeff2, double koeff1, double koeff0) {
		super(koeff2, koeff1, koeff0);
	}
	/**
	 * Konstruktion ueber die Angabe des Hauptkoeffizienten.
	 * 
	 * @param koeff2 ist Hauptkoeffizient.
	 */
	public QuadratischeFunktion(double koeff2) {
		super(koeff2, 0., 0.);
	}
	/**
	 * Standardkonstruktor fuer f(x) = x^2.
	 */
	public QuadratischeFunktion() {
		super(1., 0., 0.);		
	}

}
