package gui;

import javax.swing.plaf.basic.BasicInternalFrameUI;
/**
 * Die Klasse InternalFrame erzeugt ein inneres Fenster in welchem unser 
 * Plotter zu sehen ist. Die Groesse dieses Plot-Fensters wird in der 
 * Klasse Function Plotter festgelegt.
 * neben dem Frame gibt es noch ein Feld "bi", welches das unser Frame 
 * rendernde Objekt enthält. Das wird benötigt um den oberen Rahmen
 * welchen jedes Frame besitzt (mit Minimieren, Schliessen und Maximieren)
 * zu deaktivieren. 
 * 
 * @author Gruppe 4
 *
 */
@SuppressWarnings("serial")
public class InternalFrame extends javax.swing.JInternalFrame {
	
	@SuppressWarnings("unused")
	private javax.swing.JInternalFrame iFrame;
	private BasicInternalFrameUI bi = 
				(BasicInternalFrameUI) this.getUI();

	/**
	 * Der Konstruktor unserer InternalFrame Klasse erzeugt ein internal Frame,
	 * setzt den Rand auf ein von uns gewuenschtes Layout, deaktiviert den 
	 * oberen Rahmen (wie in der Klassenbeschreibung erwähnt) und macht 
	 * den Internal Frame sichtbar.
	 */
	public InternalFrame() {
		this.iFrame = new javax.swing.JInternalFrame();
		this.setBorder(
				javax.swing.BorderFactory.createEtchedBorder());
		
		bi.setNorthPane(null);
		this.setVisible(true);
		
	}

}
