
package gui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.*;


import plotter.FunctionPlotter;
import eingabepruefung.*;
import mvc.Controller;
import mvc.Model;
import transformationsDecorator.*;

/**
 * Die Klasse GUI implementiert die Benutzeroberflaeche (Graphical User 
 * Interface) unserer Anwendung. Hier werden alle nötigen Objekte fuer 
 * saemtliche Element-Objekte unter Verwendung von Hilfsklassen, welche 
 * Formatierungsaufgaben uebernehmen, erzeugt. Neben dem Hauptframe werden
 * auch Panels erzeugt, welche die Anordnung von Buttons und Textfeldern
 * erleichtern. Verwendet wird für das komplette GUI das "GroupLayout".
 * 
 * @author Gruppe 4
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {

	private static final int THREE = 3;
	private Model mModel;
	private Controller mController;
	private Funktion mFunktion;

	
//	=== Member-Variablen ===.

	private ResetButton jButtonReset;
	private Buttons jButtonSpiegelX;
	private Buttons jButtonSpiegelY;
	private Buttons jButtonStauchX;
	private Buttons jButtonStauchY;
	private Buttons jButtonStreckX;
	private Buttons jButtonStreckY;
	private Buttons jButtonVerschLinks;
	private Buttons jButtonVerschOben;
	private Buttons jButtonVerschUnten;
	private Buttons jButtonVerschRechts;
	private ComboBox jComboBoxFunktionWahl;
	private JFrame jFrame1;
	private FunctionPlotter jInternalFramePlot;
//	private JLabel jLabel2;
	private JPanel jPanelSpiegelung;
	private JPanel jPanelStauchung;
	private JPanel jPanelVerschiebung;
	private TextFields jTextFieldStrStaX;
	private TextFields jTextFieldStrStaY;
	private TextFields jTextFieldVerschRL;
	private TextFields jTextFieldVerschUO;
	
	
//	Konstanten

	private final int xFrame = 400;
	private final int yFrame = 300;
	private final int xPlot = 601;
	private final int yPlot = 601;
	private final int jDEFAULT = GroupLayout.DEFAULT_SIZE;
	private final short jMAX = Short.MAX_VALUE;
	private final int jMIN = 0;
	private final int pGAP = 18;

	
	private GroupLayout.Alignment leading = 
			GroupLayout.Alignment.LEADING;
	private static final ComponentPlacement RELATED = LayoutStyle
			.ComponentPlacement.RELATED;

//	=== Member-Methoden ===

	/**
	 * Konstruktor zur Erzeugung eines Oberflächen-Objekts.
	 * Weiter teilt uns der Konstruktor unserer Oberfläche 
	 * das Model, unseren Controller und die aktuelle Funktion mit.
	 * weiter werden alle Komponenten der Benutzeroberfläche aufgerufen
	 * und zusammengesetzt.
	 * 
	 * @param aModel	Der Parameter weist dem GUI das Model, 
	 * also die Funktionalitaet zu.
	 * @param aController	Der Parameter weist dem GUI unseren Controller zu.
	 */
	public GUI(Model aModel, Controller aController) {
		mModel = aModel;
		mController = aController;
		mFunktion = mModel.getFunktion();
		initButtons();
		initTextField();
		initComponents();
	}

	/**
	 * Diese Methode wird vom Konstruktor aufgerufen um die Form, das heisst,
	 * die Anordnung des Plotters, die CombobBox zur Auswahl der Ausgangs-
	 * funktion und die Panels, welche unsere Buttons beinhalten zu
	 * initialisieren.
	 * Ausserdem wird der Titel unseres Fensters gesetzt.
	 * Unser Interface soll nicht manuell skalierbar sein und das Plotfenster
	 * soll "etchedBoarders" haben. Auch diese Einstellungen werden hier vor-
	 * genommen.
	 */
	private void initComponents() {
//		jLabel2 = new JLabel();
		jFrame1 = new JFrame();
		jInternalFramePlot = new FunctionPlotter(mModel);
		jComboBoxFunktionWahl = new ComboBox();
		jPanelStauchung = new JPanel();
		jPanelSpiegelung = new JPanel();
		jPanelVerschiebung = new JPanel();


		//		Erzeugen eines FrameLayouts für unser Frame 
		GroupLayout jFrame1Layout = 
				new GroupLayout(jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(
				jFrame1Layout.createParallelGroup(leading)
				.addGap(jMIN, xFrame, jMAX)
				);
		jFrame1Layout.setVerticalGroup(
				jFrame1Layout.createParallelGroup(leading)
				.addGap(jMIN, yFrame, jMAX)
				);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Funktionsmanipulator");
		setResizable(false);

		//		Funktionsanzeige
//		jLabel2.setText("Wählen Sie Ihre Ausgangsfunktion: ");

		//		InternenFrame anzeigen und ein Layout erzeugen
		jInternalFramePlot.setBorder(
				BorderFactory.createEtchedBorder());
		BasicInternalFrameUI bi = 
				(BasicInternalFrameUI) jInternalFramePlot.getUI();
		bi.setNorthPane(null);
		jInternalFramePlot.setVisible(true);
		GroupLayout jInternalFramPlotLayout = 
				new GroupLayout(
						jInternalFramePlot.getContentPane()
						);
		jInternalFramePlot.getContentPane().setLayout(jInternalFramPlotLayout);
		jInternalFramPlotLayout.setHorizontalGroup(
				jInternalFramPlotLayout.createParallelGroup(leading)
				.addGap(jMIN, xPlot, jMAX)
				);
		jInternalFramPlotLayout.setVerticalGroup(
				jInternalFramPlotLayout.createParallelGroup(leading)
				.addGap(jMIN, yPlot, jMAX)
				);

		setComboBox(); //		 Dropdown	
		placeElements(); //		Elemente platzieren

		//		Panel im Frame platzieren
		placePanel();
		pack();

	}

	/**
	 * Die Methode placePnael() definiert die Anordnung der freien Elemente
	 * (Reset Button, ComboBox, Plotfenster), sowie die der vorgefertigten
	 * Panels, welche die restlichen Elemente beinhalten 
	 * (Transforationsbuttons).  
	 */
	private void placePanel() {
		GroupLayout layout = new 
				GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(leading)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(jDEFAULT, jMAX)
						.addGroup(layout.createParallelGroup(leading)
								.addGroup(layout.createParallelGroup(
										leading)
										.addComponent(jButtonReset)
										.addComponent(
												jInternalFramePlot)))
//								.addComponent(
//										jLabel2))
//						.addPreferredGap(RELATED)
						.addGroup(layout.createParallelGroup(
								leading)
								.addComponent(
										jComboBoxFunktionWahl)
								.addComponent(
										jPanelSpiegelung)
								.addGroup(layout.createParallelGroup(
										leading, 
										false)
										.addComponent(
												jPanelVerschiebung)
										.addComponent(
												jPanelStauchung)))
						)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(leading)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(leading)
//								.addComponent(
//										jLabel2)
								.addComponent(
										jComboBoxFunktionWahl))
						.addGap(pGAP)
						.addGroup(layout.createParallelGroup(leading)
								.addComponent(
										jInternalFramePlot)
								.addGroup(layout.createSequentialGroup()
										.addComponent(
												jPanelVerschiebung)
										.addPreferredGap(RELATED)
										.addComponent(
												jPanelStauchung)
										.addGap(pGAP)
										.addComponent(
												jPanelSpiegelung)))
						.addComponent(jButtonReset)
						.addContainerGap(jDEFAULT, jMAX))
				);
	}


	/**
	 * An dieser Stelle wird unserer Combobox lediglich die Aktion zugewiesen,
	 * mySwitchCase() aufzurufen.
	 */
	private void setComboBox() {
		jComboBoxFunktionWahl.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						mySwitchCase();
					}
				});
	}


	/**
	 * GUI Elemente (Buttons und Textfelder) werden in unsere Layout-Vorgaben 
	 * erfuellende Panels plaziert (Durch Hilfsklasse Elemente). Informationen,
	 * wo welcher Parameter plaziert wird, enthält die Methode.
	 */
	private void placeElements() {
		Elemente.placeQuadButtonwText(
				jPanelVerschiebung, 
				jButtonVerschLinks, 
				jButtonVerschRechts, 
				jButtonVerschUnten, 
				jButtonVerschOben, 
				jTextFieldVerschRL, 
				jTextFieldVerschUO);

		Elemente.placeQuadButtonwText(
				jPanelStauchung,
				jButtonStreckY, 
				jButtonStauchY, 
				jButtonStreckX, 
				jButtonStauchX, 
				jTextFieldStrStaY, 
				jTextFieldStrStaX);

		Elemente.placeDoubleButton(
				jPanelSpiegelung, 
				jButtonSpiegelX, 
				jButtonSpiegelY);
	}


	/**
	 * Unsere Textfelder werden mit Hilfe der Klasse TextFields erzeugt und es 
	 * werden jedem Textfeld passende Anfangswerte (enstsprechend Definitions-
	 * bereich) uebergeben.
	 * Jedem Textfeld kann hier ein Tooltip zugewiesen werden, welcher in der
	 * Methode Elemente.setToolTip... vordefiniert ist.
	 * Wenn ein Textfeld bearbeitet wurde, soll die Eingabe durch 
	 * Eingabepruefer.checktext(String) ueberprueft werden um fehlerhafte
	 * Eingaben abzufangen. 
	 */
	private void initTextField() {

		jTextFieldVerschUO = new TextFields("0.0");
		jTextFieldVerschRL = new TextFields("0.0");
		jTextFieldStrStaY = new TextFields("1.0");
		jTextFieldStrStaX = new TextFields("1.0");

		Elemente.setToolTipTextMit0(jTextFieldVerschUO);
		jTextFieldVerschUO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jTextFieldVerschUO.getText();
				jTextFieldVerschUO.setText(
						String.valueOf(Eingabepruefer.checkText(s)));
			}
		});
		Elemente.setFocusListener(jTextFieldVerschUO);

		Elemente.setToolTipTextMit0(jTextFieldVerschRL);
		jTextFieldVerschRL.addActionListener(
				new ActionListener() {
					public void actionPerformed(
							ActionEvent evt) {
						String s = jTextFieldStrStaX.getText();
						jTextFieldStrStaX.setText(
								String.valueOf(Eingabepruefer.checkText(s)));
					}
				});
		Elemente.setFocusListener(jTextFieldVerschRL);


		Elemente.setToolTipTextMit1(jTextFieldStrStaX);        
		jTextFieldStrStaX.addActionListener(new 
				ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldStrStaX.getText();
				jTextFieldStrStaX.setText(
						String.valueOf(Eingabepruefer.checkText(s)));
			}
		});
		Elemente.setFocusListener(jTextFieldStrStaX);


		Elemente.setToolTipTextMit1(jTextFieldStrStaY);
		jTextFieldStrStaY.addActionListener(new 
				ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldStrStaY.getText();
				jTextFieldStrStaY.setText(
						String.valueOf(Eingabepruefer.checkText(s)));
			}
		});
		Elemente.setFocusListener(jTextFieldStrStaY);
	}


	/**
	 * Die Methode erzeugt Buttons fuer die Oberfläche, mit Hilfe der Klasse 
	 * Buttons. Es wird allen Buttons ein ActionListener zugewiesen.
	 * Jeder Button erzeugt eine Transformation, also muss der Controller das
	 * Updaten der Funktion veranlassen und das Funktion bekommt ihre 
	 * Transformation mitgeteilt.
	 */
	private void initButtons() {

		jButtonReset = new ResetButton();
		jButtonVerschLinks = new Buttons();
		jButtonVerschOben = new Buttons();
		jButtonVerschRechts = new Buttons();
		jButtonVerschUnten = new Buttons();
		jButtonStauchY = new Buttons();
		jButtonStreckY = new Buttons();
		jButtonStauchX = new Buttons();
		jButtonStreckX = new Buttons();
		jButtonSpiegelX = new Buttons();
		jButtonSpiegelY = new Buttons();

		jButtonReset.setText("Reset");
		jButtonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mySwitchCase();
			}
		});

		jButtonVerschLinks.setText("Verschieben nach links");
		jButtonVerschLinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldVerschRL.getText();
				double val = Eingabepruefer.checkText(s);
				if (val >= 0.) {
					mFunktion = new VerschiebungNachLinks(mFunktion, val);
					mController.updateFunction(mFunktion);
				} 
			}
		});

		jButtonVerschOben.setText("Verschieben nach oben");
		jButtonVerschOben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldVerschUO.getText();
				double val = Eingabepruefer.checkText(s);
				if (val >= 0.) {
					mFunktion = new VerschiebungNachOben(mFunktion, val);
					mController.updateFunction(mFunktion);
				}
			}
		});

		jButtonVerschRechts.setText("Verschieben nach rechts");
		jButtonVerschRechts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldVerschRL.getText();
				double val = Eingabepruefer.checkText(s);
				if (val >= 0.) {
					mFunktion = new VerschiebungNachRechts(mFunktion, val);
					mController.updateFunction(mFunktion);
				}
			}
		});

		jButtonVerschUnten.setText("Verschieben nach unten");
		jButtonVerschUnten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldVerschUO.getText();
				double val = Eingabepruefer.checkText(s);
				if (val >= 0.) {
					mFunktion = new VerschiebungNachUnten(mFunktion, val);
					mController.updateFunction(mFunktion);
				} 
			}
		});

		jButtonStauchX.setText("Stauchung in x-Richtung");
		jButtonStauchX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldStrStaX.getText();
				double val = Eingabepruefer.checkText(s);
				if (val >= 1.) {
					mFunktion = new StauchungInX(mFunktion, val);
					mController.updateFunction(mFunktion);
				} else {
					JOptionPane.showMessageDialog(null,	"Kein Stauchungsfaktor "
							+ "unter 1 zugelassen!");
				}
			}
		});

		jButtonStreckX.setText("Streckung in x-Richtung");
		jButtonStreckX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldStrStaX.getText();
				double val = Eingabepruefer.checkText(s);
				if (val >= 1.) {
					mFunktion = new StreckungInX(mFunktion, val);
					mController.updateFunction(mFunktion);
				} else {
					JOptionPane.showMessageDialog(null,	"Kein Streckungsfaktor "
							+ "unter 1 zugelassen!");
				}
			}
		});

		jButtonStauchY.setText("Stauchung in y-Richtung");
		jButtonStauchY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldStrStaY.getText();
				double val = Eingabepruefer.checkText(s);
				if (val >= 1.) {
					mFunktion = new StauchungInY(mFunktion, val);
					mController.updateFunction(mFunktion);
				} else {
					JOptionPane.showMessageDialog(null,	"Kein Stauchungsfaktor "
							+ "unter 1 zugelassen!");
				}
			}
		});

		jButtonStreckY.setText("Streckung in y-Richtung");
		jButtonStreckY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String s = jTextFieldStrStaY.getText();
				double val = Eingabepruefer.checkText(s);
				if (val >= 1.) {
					mFunktion = new StreckungInY(mFunktion, val);
					mController.updateFunction(mFunktion);
				} else {
					JOptionPane.showMessageDialog(null,	"Kein Streckungsfaktor "
							+ "unter 1 zugelassen!");
				}
			}
		});

		jButtonSpiegelX.setText("Spiegelung x-Achse");
		jButtonSpiegelX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mFunktion = new SpiegelungAnX(mFunktion);
				mController.updateFunction(mFunktion);
			}
		});

		jButtonSpiegelY.setText("Spiegelung y-Achse");
		jButtonSpiegelY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mFunktion = new SpiegelungAnY(mFunktion);
				mController.updateFunction(mFunktion);
			}
		});
	} 
	
	/**
	 * mySwitchCase() benachrichtigt den Controller, wenn das elementare
	 * Polynom geändert wurde und weist unserer Funktion Ihre neuen Werte zu.
	 * Werden weitere Auswahlmoeglichkeiten hinzugefuegt, muss ein neuer Case
	 * erstellt werden.
	 */
	private void mySwitchCase() {
		int itemID = jComboBoxFunktionWahl.getSelectedIndex();
		switch (itemID) {
		case 0: 
			mFunktion = new KonstanteFunktion();
			break; 
		case 1: 
			mFunktion = new LineareFunktion();
			break; 
		case 2: 
			mFunktion = new QuadratischeFunktion();
			break; 
		case THREE:
			mFunktion = new KubischeFunktion();
			break; 
		default: 
			mFunktion = mModel.getFunktion();
		}
		mController.updateFunction(mFunktion);
	}
	
	

}
