package mvc;
/**
 * 
 * @author Gruppe 4
 *
 */
public interface Observable {
	/**
	 * 
	 * @param b Der Parameter beschreibt einen neuen Beobachter,
	 * der hinzugefuegt wird.
	 */
	void registriereBeobachter(Beobachter b);
	/**
	 * 
	 * @param b Der Parameter beschreibt einen Beobachter, der geloescht wird.
	 * 
	 */
	void entferneBeobachter(Beobachter b);
	/**
	 * Benachrichtigt alle vorhandenen Beobachter ueber Aenderungen.
	 */
	void benachrichtigeBeobachter();

}
