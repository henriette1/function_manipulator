package mvc;
import transformationsDecorator.*;

import java.util.ArrayList;



/**
 * Das Modell enthaelt die darzustellenden Daten und
 * ist das zu beobachtende Subjekt.
 * 
 * @author Gruppe 4
 */
public class Model implements Observable {

	private ArrayList<Beobachter> beobachter;
	private Funktion mFunktion;
	
	/**
	 * Der Konstruktor, der ein neues Model mit einer 
	 * neuen ArrayList und der Grundfunktion ausstattet,
	 * die zu Beginn angezeigt wird.
	 * Die aktuelle Funktion wird unter der Variable mFunktion gespeichert.
	 * 
	 */
	public Model() {
		beobachter = new ArrayList<Beobachter>();
		mFunktion = new QuadratischeFunktion();	
	}
	/**
	 * @param b Der Parameter beschreibt einen Beobachter, der diese Klasse
	 * beobachten will und registriert ihn in der Beobachter-Liste.
	 * 
	 */
	public final void registriereBeobachter(Beobachter b) {
		beobachter.add(b);		
	}
	/**
	 * @param b Der Parameter beschreibt einen Beobachter dieser Klasse, der
	 * schon registriert ist und loescht ihn aus dieser Beobachter-Liste.
	 * 
	 */
	public final void entferneBeobachter(Beobachter b) {
		beobachter.remove(b);		
	}
	/**
	 * Die Methode benachrichtigt alle Beobachter der Liste. Dies wird
	 * gemacht damit die Beobachter die geanderten oder neuen Daten
	 * verarbeiten koennen.
	 * 
	 */
	public final void benachrichtigeBeobachter() {
		for (Beobachter b: beobachter) {
			b.aktualisiere();
		}		
	}
	/**
	 * 
	 * @return Gibt die aktuelle Funktion zurueck.
	 */
	public final Funktion getFunktion() {
		return mFunktion;
	}
	
	/**
	 * 
	 * @param aFunktion Der Parameter entspricht der aktuell anzuzeigenden 
	 * Funktion.
	 * 
	 * Die Methode aendert die Variable mFunktion und benachrichtigt
	 * anschliessend alle Beobachter.
	 */
	// Die eigentliche Model-Funktionalität
	public final void updateFunction(Funktion aFunktion) {
		mFunktion = aFunktion;
		benachrichtigeBeobachter();
	}

}
