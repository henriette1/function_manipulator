package eingabepruefung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * Die Klasse Eingabepruefer kontrolliert die eingegebenen Zeichen,
 * ob diese der gewuenschten Form entsprechen.
 *
 * @author Gruppe 4
 *
 */
public final class Eingabepruefer {

	/**
	 * 
	 */
	private Eingabepruefer() {

	}
	/**
	 * Die Methode verarbeitet einen eingegeben Text und wertet diesen aus.
	 * Falls die eingegeben Zeichen nicht unserer Norm entsprechen sollen 
	 * Meldungen erscheinen, die sagen wo der Fehler liegt. So wollen wir
	 * z.B nicht mehr als ein Komma bzw Punkt oder auch keine Buchstaben.
	 * 
	 * @param s Der Parameter beschreibt den eingegebenen Text im Textfeld
	 * und wird weiterverarbeitet.
	 * @return Die Methode gibt uns den Double-Wert zurueck, 
	 * den der Parameter s beschreibt.
	 * 
	 * 
	 */
	public static double checkText(String s) {

		double result = 0.;
		final int maxLength = 5;
		final int multiplier = 10;
		final int zero = 48;
		final int dot = 46;
		final int decimal = 44;
		String myMessage = "";

		// Wenn die Eingabe leer ist
		if (s.length() == 0 || s == null) {

			return 0.;

		}

		// Wenn die Eingabe mit einer 0 beginnt
		if (s.charAt(0) == zero) {
			if (s.length() > 1 && s.charAt(1) != decimal 
					&& s.charAt(1) != dot) {
				myMessage =
						"Nach der Null darf nur ein Komma oder Punkt folgen.";
			}
		}

		// Wenn die Eingabe Symbole außer Ziffern und Punkt und Komma enthält
		boolean pointRecognized = false;
		int pointPosition = 0;
		int powCoeff1 = 1;
		int powCoeff2 = 0;
		if (s.length() > maxLength) powCoeff2 -= s.length() - maxLength;
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (c == decimal || c == dot) {

				powCoeff1--;

				if (pointRecognized) {

					myMessage = 
							"Die Eingabe darf nicht mehr, "
									+ "als ein Dezimaltrennzeichen enthalten.";

				} else {

					pointRecognized = true;
					pointPosition = s.length() - i;

				}

			} else {

				if (!Character.isDigit(c)) {
					myMessage = "Ihre Eigabe ist keine zugelassene "
							+ "(dezimale) Zahl.";
					break;
				} else {

					if (i <= maxLength - powCoeff1) {
						result += Character.getNumericValue(c) 
								* Math.pow(multiplier, s.length() - i 
										- powCoeff1 - powCoeff2);
					} else {
						myMessage = "Die Eingabe darf maximal " 
								+ maxLength + " Ziffern enthalten.";
						break;
					}

				}

			}
		}
		//ToDo: solve by adding, not by dividing
		result /= Math.pow(multiplier, pointPosition - powCoeff2);
		if (result >= Math.pow(multiplier, maxLength - 1)) result = 0;

		if (myMessage != "") {
			JLabel lblMessage = new JLabel(myMessage);
			//				    lblMessage.setFont( messageFont );
			JOptionPane.showMessageDialog(
					null, lblMessage, "Unzulässige Eingabe",
					JOptionPane.OK_OPTION);
		}

		return result;
	}
}
