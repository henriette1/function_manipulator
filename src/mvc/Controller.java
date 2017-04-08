package mvc;
import transformationsDecorator.Funktion;

/**
 * Der Controller verwaltet eine oder mehrere Views, nimmt von ihnen
 * Benutzeraktionen entgegen, wertet diese aus und agiert entsprechend.
 * Zu jeder View existiert eine eigene Steuerung. Die Steuerung sorgt dafuer,
 * dass Benutzeraktionen wirksam werden, z. B. durch Aenderung des View
 * (z. B. Verschieben des Fensters) oder durch Weiterleiten an das Modell
 * (z. B. Uebernahme von Eingabedaten oder Ausloesen von Verarbeitungen).
 * 
 * @author Gruppe 4
 *
 */
public class Controller implements Beobachter, Strategy {
	
	private Model mModel;
	@SuppressWarnings("unused")
	private Beobachter mView;
	@SuppressWarnings("unused")
	private Beobachter mViewKonsole;
	
	/**
	 * Hier uebernimmt der Controller die Erzeugung der Views mit dem 
	 * uebergebenen Model.
	 * 
	 * @param aModel Uebergabe weil der Controller ein Beobachter von Model ist.
	 */
	public Controller(Model aModel) {
		// weil controller ein Beobachter von Model ist
		mModel = aModel;
		aModel.registriereBeobachter(this);
		
		// der Controller übernimmt  die Erzeugung der Views
		mView = new View(mModel, this);
		mViewKonsole = new ViewKonsole(mModel, this);
	}

	/**
	 * Die Methode macht hier nichts, muss aber implementiert sein.
	 */
	public final void aktualisiere() {
		// TODO Auto-generated method stub
		// tut nichts, da er mit der Info nichts anfangen kann
	}
	
	// Der Controller übernimmt die Steuerung des Modells

	/**
	 * Die Funktion wird erneuert und ausgegeben.
	 */
	public final void updateFunction(Funktion aFunktion) {
		mModel.updateFunction(aFunktion);
	}

}
