package mvc;

import transformationsDecorator.Funktion;
/**
 * 
 * @author Gruppe 4
 *
 */
public interface Strategy {
	/**
	 * 
	 * @param aFunktion Die Funktion wird erneuert.
	 */
	void updateFunction(Funktion aFunktion);

}
