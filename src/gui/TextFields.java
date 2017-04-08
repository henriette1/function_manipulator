package gui;

import java.awt.Dimension;

import javax.swing.JTextField;

/**
 * Die Klasse TextFields erweitert die von Javax Swing
 * gelieferte Klasse JTextField. Textfelder die mit dem Konstruktor dieser
 * Klasse erstellt werden, haben eine feste Groessendimension,
 * welche durch die Klassenkonstante "tDim" definiert wird.
 * Die Konstante "caretPos" legt später fest, dass unsere Texteingabe
 * Rechtsbuendig formatiert sein soll.
 * 
 * @author Gruppe 4
 *
 */
@SuppressWarnings("serial")
public class TextFields extends javax.swing.JTextField {

	@SuppressWarnings("unused")
	private javax.swing.JTextField text;
	private final int caretPos = 3;
	private final  Dimension tDim = 
			new java.awt.Dimension(70, 23);
	
	/**
	 * Der Konstruktor TextFields erzeugt Textfelder nach unserer Vorgabe.
	 * Es wird ein Standardtext vorgegeben der von Textfeld zu Textfeld unter-
	 * schiedlich sein kann.
	 * Die eingaben werden durch setCaretPosition Rechtsbuendig und die Groesse
	 * wird durch tDim festgelegt.
	 * 
	 * @param s uebergibt die Default Eingabe des erzeugten Textfeldes.
	 */
	public TextFields(String s) {
		super();
		this.text = new javax.swing.JTextField();
		this.setText(s);

		this.setCaretPosition(caretPos); 
		this.setHorizontalAlignment(JTextField.RIGHT);
		this.setSize(tDim);

		this.setMaximumSize(tDim);
		this.setMinimumSize(tDim);
		this.setPreferredSize(tDim);
	}

}
