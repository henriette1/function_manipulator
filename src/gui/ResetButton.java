package gui;

import java.awt.Dimension;
/**
 * Die Klasse Buttons erweitert die von Javax Swing
 * gelieferte Klasse JButton. Buttons die mit dem Konstruktor dieser
 * Klasse erstellt werden, haben eine feste Groessendimension,
 * welche durch die Klassenkonstante "bDim" definiert wird.
 * 
 * @author Gruppe 4
 *
 */
@SuppressWarnings("serial")
public class ResetButton extends javax.swing.JButton {

	@SuppressWarnings("unused")
	private javax.swing.JButton button; 
	
	private final  Dimension bDim = 
			new java.awt.Dimension(80, 40);
	/**
	 * Der Konstruktor erzeugt Buttons nach unserer Vorgabe.
	 * Alle Buttons die mithilfe dieses 
	 * Konstruktors erzeugt werden haben bDim als Größe,
	 * d.h. 80 Pixel breit und 40 Pixel hoch.
	 * Wir erzeugen mit diesem Konstruktor nur den Reset-Button.
	 */
	public ResetButton() {
		super();
		this.button = new javax.swing.JButton();
		this.setSize(bDim);
		this.setMaximumSize(bDim);
		this.setMinimumSize(bDim);
		this.setPreferredSize(bDim);
	}

}
