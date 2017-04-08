package gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.GroupLayout;
import eingabepruefung.Eingabepruefer;
/**
 * Die Klasse Elemente ist zustaending fuer die Anordnung 
 * auf unserer Oberflaeche. Sie uebernimmt Objekte aus der GUI-Klasse
 * und ordnet diese Objekte nach Vorgabe in einem Panel an.
 * Ausserdem legt die Klasse Tooltips fuer bestimmte Textfelder an
 * und ueberprueft diese Eingaben bei verlorenem Fokus.
 *
 * @author Gruppe 4
 *
 */
public final class Elemente {
	
	private static final int GAPLARGE = 105;
	private static final int GAFTER = 18;

	private static GroupLayout.Alignment leading = 
			javax.swing.GroupLayout.Alignment.LEADING;


	/**
	 * Der Default-Konstruktor ist die reine Erzeugung
	 * eines Objekts der Klasse Elemente.
	 */
	private Elemente() {

	}

	/**
	 * Setzt 4 Buttons in vorgegebenem Layout in ein Panel, 
	 * zwischen 2 nebeneinander liegenden Buttons wird ein Textfeld platziert.
	 * 
	 * @param panel Entspricht dem Panel, welches mit den Buttons
	 * und den Textfeldern bestueckt werden soll.
	 * @param button11 Erzeugt den Button oben links.
	 * @param button12 Erzeugt den Button oben rechts.
	 * @param button21 Erzeugt den Button unten links.
	 * @param button22 Erzeugt den Button unten rechts.
	 * @param field1 Erzeugt das Textfeld zwischen button11 und button12. 
	 * @param field2 Erzeugt das Textfeld zwischen button21 und button22.
	 * 
	 * Anordnung:
	 * 
	 * button11 - field1 - button12
	 * button21 - field2 - button22
	 * 
	 */
	public static void placeQuadButtonwText(
			javax.swing.JPanel panel, 
			Buttons button11, 
			Buttons button12, 
			Buttons button21, 
			Buttons button22, 
			TextFields field1, 
			TextFields field2) {
		javax.swing.GroupLayout jPanelLayout = 
				new javax.swing.GroupLayout(panel);
		panel.setLayout(jPanelLayout);
		jPanelLayout.setHorizontalGroup(
				jPanelLayout.createParallelGroup(leading)
				.addGroup(jPanelLayout.createSequentialGroup()
						.addGroup(jPanelLayout.createParallelGroup(
								leading, 
								false)
								.addComponent(
										button11)
								.addComponent(
										button21))
						.addGap(GAFTER)
						.addGroup(jPanelLayout.createParallelGroup(leading)
								.addComponent(
										field1)
								.addComponent(
										field2))
						.addGap(GAFTER)
						.addGroup(jPanelLayout.createParallelGroup(
								leading, 
								false)
								.addComponent(
										button12)
								.addComponent(
										button22))
						.addContainerGap())
				);
		jPanelLayout.setVerticalGroup(
				jPanelLayout.createParallelGroup(
						leading)
				.addGroup(jPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanelLayout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(button11)
								.addComponent(
										field1)
								.addComponent(
										button12))
						.addGap(GAFTER)
						.addGroup(jPanelLayout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(
										button21)
								.addComponent(
										field2)
								.addComponent(
										button22))
						.addContainerGap())
				);
	}

	/**
	 * Setzt 2 Buttons in einem Panel nebeneinander. Mit vorgegebenen Abstand
	 * nach oben und unten sowie rechts und links.
	 * @param panel ist das zu bestueckende Panel
	 * @param button1 ist der linke (erste) Button
	 * @param button2 ist der rechte (zweite) Button
	 */
	public static void placeDoubleButton(
			javax.swing.JPanel panel, 
			Buttons button1, 
			Buttons button2) {
		javax.swing.GroupLayout jPanelLayout = 
				new javax.swing.GroupLayout(panel);
		panel.setLayout(jPanelLayout);
		jPanelLayout.setHorizontalGroup(
				jPanelLayout.createParallelGroup(leading)
				.addGroup(jPanelLayout.createSequentialGroup()
						.addComponent(button1)
						.addGap(GAPLARGE)
						.addComponent(button2)
						.addContainerGap())
				);
		jPanelLayout.setVerticalGroup(
				jPanelLayout.createParallelGroup(leading)
				.addGroup(jPanelLayout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(button1)
						.addComponent(button2))
				);
	}
	

	/**
	 * Methoden erzeugen entsprechenden ToolTipText, 
	 * der das zulaessige Intervall anzeigen laesst.
	 * @param field Feld fuer welches das Tooltip angezeigt werden soll
	 */
	public static void setToolTipTextMit1(TextFields field) {
		field.setToolTipText("Werte aus dem Intervall [1,9999.9] zugelassen");
	}
	/**
	 * Methoden erzeugen entsprechenden ToolTipText, 
	 * der das zulaessige Intervall anzeigen laesst.
	 * @param field Feld fur welches das Tooltip angezeigt werden soll
	 */
	public static void setToolTipTextMit0(
			TextFields field) {
		field.setToolTipText("Werte aus dem Intervall [0,9999.9] zugelassen");
	}

	/**
	 * Eingaben in einem Textfeld sollen bei verlorenem Fokus
	 * aus Zulaessigkeit ueberprueft werden.
	 * @param field Beschreibt das zu ueberpruefende Textfeld.
	 */
	public static void setFocusListener(TextFields field) {
		field.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			};
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					String s = field.getText();
					field.setText(String.valueOf(Eingabepruefer.checkText(s)));	
				}
			}
		});
	}

}
