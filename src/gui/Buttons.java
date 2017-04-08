package gui;

import java.awt.Dimension;
/**
 * Die Klasse Buttons erweitert die von Javax Swing
 * gelieferte Klasse JButton. Buttons die mit dem Konstruktor dieser
 * Klasse erstellt werden, haben eine feste Groessendimension,
 * welche durch die Klassenkonstante "bDim" definiert wird.
 * Diese Klasse wird für alle Transformations-Buttons genutzt.
 * 
 * @author Gruppe 4
 *
 */
@SuppressWarnings("serial")
public class Buttons extends javax.swing.JButton {
	
	@SuppressWarnings("unused")
	private javax.swing.JButton button; 
	
	private final  Dimension bDim = 
			new java.awt.Dimension(179, 25);
	
	/**
	 * Konstruktor erzeugt Buttons nach unserer Vorgabe.
	 * alle Transformations-Buttons die mithilfe dieses 
	 * Konstruktors erzeugt werden haben bDim als Größe,
	 * d.h. 179 Pixel breit und 25 Pixel hoch.
	 */
	Buttons() {
		super();
		this.button = new javax.swing.JButton();
		this.setSize(bDim);
		this.setMaximumSize(bDim);
		this.setMinimumSize(bDim);
		this.setPreferredSize(bDim);
	}

}
