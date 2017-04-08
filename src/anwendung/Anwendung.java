package anwendung;

import java.util.logging.Logger;

import gui.GUI;
import mvc.Controller;
import mvc.Model;

/**
 * Die Klasse startet den Funktionsmanipulator 
 * und gibt den Buttons ein individuelles Aussehen.
 * Es wird für den Programmstart lediglich ein Model und
 * ein Controller mit dem Model als Parameter deklariert.
 * 
 * @author Gruppe 4
 *
 */
public final class Anwendung {
	
	/**
	 * DefaultKonstruktor.
	 * Construktor erfüllt keine Aufgaben,
	 * muss für Checkstyle aber "private" sein.
	 */
	 private Anwendung() {	
	}
	
	 /**
	 * Main-Methode die das Programm startet
	 * und den Buttons ein anderes Aussehen verpasst.
	 *
	 * @param args Kommandozeilenparameter
	 */
	public static void main(String []args) {

		giveLook();

		
		Model aModel = new Model();
		
		@SuppressWarnings("unused")
		Controller aController = new Controller(aModel);
	}
	
	/**
	 * Verleiht den Buttons ein anderes (silber mit abgerundeten Ecken 
	 * und leichtem Farbverlauf) aussehen.
	 */
	private static void giveLook() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info 
					: javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(GUI.class.getName())
			.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(GUI.class.getName())
			.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(GUI.class.getName())
			.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(GUI.class.getName())
			.log(java.util.logging.Level.SEVERE, null, ex);
		}
	}
}
