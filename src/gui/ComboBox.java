package gui;

import java.awt.Dimension;
/**
 * Die Klasse ComboBox erzeugt unsere DropDownListe 
 * zur Funktions-Auswahl mit einer festen Dimension.
 * Diese legt Breite und Hoehe der Box fest.
 *
 * @author Gruppe 4
 *
 */
@SuppressWarnings("serial")
public class ComboBox extends javax.swing.JComboBox<String> {
	
	@SuppressWarnings("unused")
	private javax.swing.JComboBox<String> combo;
	private final Dimension cbDim = new java.awt.Dimension(70, 25);


	/**
	 * Konstruktor erstellt eine ComboBox zur Auswahl
	 * der 4 Funktionen.
	 * Die Standard Auswahl ist bei 2 (Default w�re 0 also konstante 
	 * Funktion)
	 * cbDim legt die Dimension der ComboBox fest, diese soll immer 70 Pixel
	 * breit und 25 Pixel hoch sein.
	 */
	public ComboBox() {
		this.combo = new javax.swing.JComboBox<>();
		this.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "1", "x", "x^2", "x^3" }));
		this.setSelectedIndex(2);
		this.setSize(cbDim);
		this.setMaximumSize(cbDim);
		this.setMinimumSize(cbDim);
		this.setPreferredSize(cbDim);
	}

}
