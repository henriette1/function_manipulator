package mvc;
import transformationsDecorator.*;


/**
 * Die Klasse ViewKonsole implementiert den Beobachter. 
 * Sie zeigt in der Konsole eine Wertetabelle der aktuellen Funktion an.
 * In der Wertetabelle sind die aktuellen Funktionswerte aufgelistet. 
 * 
 * @author Gruppe 4
 * 
 */

public class ViewKonsole implements Beobachter {

	private final int xMin = -10;
	private final int xMax = 10;
	private Model mModel;
	@SuppressWarnings("unused")
	private Controller mController;
	private Funktion mFunktion;


	/**
	 * Ist der Konstruktor der Klasse ViewKonsole. 
	 * Der Konstruktor ruft die Methode WerteTabelle() auf 
	 * und macht sie sichtbar.
	 * 
	 * @param aModel wird als Beobachter hinzugefuegt.
	 * @param aController ist der Controller.
	 */
	public ViewKonsole(Model aModel, Controller aController) {
		super();
		mModel = aModel;
		mController = aController;
		mFunktion = mModel.getFunktion();
		mModel.registriereBeobachter(this);
		werteTabelle();
	}

	/**
	 * Die Methode WerteTabelle() erzeugt eine Wertetabelle.
	 * Hierbei werden die x-Werte im Intervall [-10,10] ausgegeben, 
	 * sowie deren zugehoerige Funktionswerte y.
	 */
	private void werteTabelle() {
		mFunktion = mModel.getFunktion();
		System.out.println("\n" + "Aktuelle Wertetabelle:" + "\n");

		System.out.print("x |");
		for (double i = xMin; i <= xMax; i++) {
			System.out.print("\t" + i + "\t" + "|");

		}
		System.out.println();
		System.out.println("-------------------------------------------------"
				+ "----------------------------------------------------------"
				+ "-----------------------------------------------------------"
				+ "---------------------------------------------------------"
				+ "----------------------------------------------------------"
				+ "--------------------------------------------------------");
		System.out.print("y |  ");
		for (int i = xMin; i <= xMax; i++) {
			System.out.print("\t" + mFunktion.getValue(i) +  "\t" + "|");
		}		
		System.out.println();
	}
	
	/**
	 * Die Methode aktualisiere(), aktualiesiert die Wertetabelle und 
	 * benachrichtigt das Model über die aktuellste Wertetabelle. 
	 */
	@Override
	public void aktualisiere() {
		werteTabelle();

	}
}
