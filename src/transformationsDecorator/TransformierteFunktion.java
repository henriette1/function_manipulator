package transformationsDecorator;

/**
 * Die abstrakte Klasse TransformierteFunktion ist eine Unterklasse
 * der Oberklasse Funktion. Diese Klasse gibt die zu bearbeitende Funktion 
 * an die Transformations-Klassen weiter.
 * 
 * @author Gruppe 4
 *
 */
public abstract class TransformierteFunktion extends Funktion {

//	Member-Variablen

	@SuppressWarnings("unused")
	private Funktion mFunktion;
	
    /**
     * Der Konstruktor erhaelt die zu verarbeitende Funktion. 
     * 
     * @param aFunktion ist die zu verarbeitende Funktion.
     */
    protected TransformierteFunktion(Funktion aFunktion) { 
        mFunktion = aFunktion;
    }
    
    /**
	 * Defaultkonstruktor. Dieser dient der Obejtkerzeugung ohne 
	 * vorgegebene Parameter.
     */
    protected TransformierteFunktion() { }
    

//	@Override
//	public String toString() {
//		return mFunktion.toString();
//	}
	
}
