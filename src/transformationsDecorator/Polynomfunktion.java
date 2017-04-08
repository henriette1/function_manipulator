package transformationsDecorator;

import java.util.ArrayList;

/**
 * Die Klasse Polynomfunktion ist Unterklasse der 
 * abstrakten Oberklasse Funktion und ist dafuer zustaendig
 * eine Funktion mit bestimmten Grad zu erstellen.
 * Sie beinhaltet die klassische Form einer Polynomfunktion mit:
 * f(x) = a_n * x^n + ... + a_1 * x + a_0.
 * 
 * @author Gruppe 4
 *
 */
public class Polynomfunktion extends Funktion {

	private ArrayList<Double> mKoeffizienten;
	
	/**
	 * Konstruktion ueber die Uebergabe 
	 * einer Koeffizientenliste (von a_n bis a_0).
	 *  
	 * @param koeffList beinhaltet die Werte der Koeffizienten
	 * der Polynomfunktion
	 */
	public Polynomfunktion(ArrayList<Double> koeffList) {
		mKoeffizienten = koeffList;
	}
	
	/**
	 * Konstruktion ueber die explizite Angabe
	 * der Koeffizienten (von a_0 bis a_n)!
	 * 
	 * @param koeffArray ist die Auflistung der Werte der Koeffizienten.
	 */
	public Polynomfunktion(double... koeffArray) {
		mKoeffizienten = new ArrayList<Double>();
		for (int i = koeffArray.length - 1; i >= 0; i--) {
			mKoeffizienten.add(koeffArray[i]);
		}
	}
	

	@Override
	public double getValue(double x) {
		double value = 0.;
		for (int i = 0; i < mKoeffizienten.size(); i++) {
		    value += mKoeffizienten.get(i) * Math.pow(x, i);
		}
		return value;
	}
	
	/**
	 * Die Methode toString() wird momentan nicht verwendet.
	 * Sie dient lediglich der Erweiterbarkeit.
	 * 
	 * @return Am Ende der Umwandlung steht ein verwertbarer String der
	 * die Funktion beschreibt.
	 */
	@Override
	public String toString() {
		
		int grad = mKoeffizienten.size() - 1;
		String ausgabe = "Polynom, Grad " + grad + ": ";
		if (grad >= 2) ausgabe += mKoeffizienten.get(grad) + "*x^" + grad;
		for (int i = grad - 1; i > 2; i--) {
			if (mKoeffizienten.get(i) != 0)	ausgabe 
				+= " + " + mKoeffizienten.get(i) + "*x^" + i;
		}
		if (grad > 1) {
			if (mKoeffizienten.get(1) != 0) ausgabe += " + ";
		}
		if (grad >= 1) {
			if (mKoeffizienten.get(1) != 0) ausgabe 
				+= mKoeffizienten.get(1) + "*x";			
		}
		if (grad > 0) {
			if (mKoeffizienten.get(0) != 0) ausgabe += " + ";
		}
		if (grad >= 0) {
			if (mKoeffizienten.get(0) != 0) ausgabe += mKoeffizienten.get(0);
		}
		
		return ausgabe;
		
	}

	
	
}
