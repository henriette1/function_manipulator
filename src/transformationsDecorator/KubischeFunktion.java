package transformationsDecorator;

/**
 * KubischeFunktion ist eine Unterklasse der Klasse Polynomfunktion und
 * definiert eine Funktion dritten Grades.
 * 
 * @author Gruppe 4
 *
 */
public class KubischeFunktion extends Polynomfunktion {

	/**
	 * Konstruktion ueber die Angabe
	 * der vier Koeffizienten a_3, a_2, a_1 und a_0.
	 * 
	 * @param koeff3 beschreibt den Koeffizient der Variablen vom Grad 3.
	 * @param koeff2 beschreibt den Koeffizient der Variablen vom Grad 2
	 * @param koeff1 beschreibt den Koeffizient der Variablen vom Grad 1
	 * @param koeff0 beschreibt den y-Achsenabschnitt.
	 */
	public KubischeFunktion(double koeff3, double koeff2,
							double koeff1, double koeff0) {
		super(koeff3, koeff2, koeff1, koeff0);
	}
	/**
	 * Konstruktion ueber die Angabe des Hauptkoeffizienten.
	 * 
	 * @param koeff3 beschreibt den Koeffizient der Variablen von Grad 3.
	 */
	public KubischeFunktion(double koeff3) {
		super(koeff3, 0., 0., 0.);
	}
	/**
	 * Standardkonstruktor fuer f(x) = x^3.
	 */
	public KubischeFunktion() {
		super(1., 0., 0., 0.);
	}

}
