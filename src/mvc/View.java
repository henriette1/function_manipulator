
package mvc;
import gui.GUI;

/**
 * Die View (Praesentation) ist fuer die Darstellung der benoetigten Daten
 * aus dem Modell und die Entgegennahme von Benutzerinteraktionen zustaendig.
 *
 * Sie kennt sowohl ihren Controller als auch das Model,
 * dessen Daten sie praesentiert,
 * ist aber nicht für die Weiterverarbeitung der vom Benutzer uebergebenen
 * Daten zustaendig.
 * 
 * @author Gruppe 4
 * 
 */
public class View implements Beobachter {

	private Model mModel;
	private Controller mController;
	private GUI mFenster;

	/**
	 * Ist der Konstruktor der Klasse View, erzeugt das Fenster
	 * und macht es sichtbar.
	 * 
	 * @param aModel Der Parameter beschreibt ein Model, dass als Beobachter 
	 * hinzugefuegt wird.
	 * @param aController Der Parameter beschreibt den Controller.
	 */
	public View(Model aModel, Controller aController) {
		// was jeder Beobachter tun muss
		mModel = aModel;
		mModel.registriereBeobachter(this);
		// der Controller ist eine Strategy
		mController = aController;
		// ein Fenster aufbauen
		mFenster = new GUI(mModel, mController);
		mFenster.setVisible(true);
	}

	/**
	 * Die Methode aktualisiert das Fenster und zeichnet es neu,
	 * d.h. die aktualisierte Funktion wird im Plot dargestellt.
	 */
	public final void aktualisiere() {
		mFenster.repaint();
	}

}
