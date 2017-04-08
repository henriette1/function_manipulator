package plotter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JInternalFrame;
import mvc.Model;
import transformationsDecorator.Funktion;


/**
 * Die Klasse erstellt den Plotter auf dem die aktuelle Funktion
 * angezeigt wird.
 * 
 * @author Gruppe 4
 *
 */
@SuppressWarnings("serial")
public class FunctionPlotter extends JInternalFrame {

	//private GeneralPath path; // GenerelPath ist der geometrische Pfad (

	private static final int THREE = 3;
	private final int mWidth = 600; // Breite des Fensters
	private final int mHight = 600; // Hoehe des Fensters

	private final double mMinX = -10.5;
	private final double mMaxX = 10.5;
	private final double mMinY = -10.5;
	private final double mMaxY = 10.5;

	//private int[] mOrigin = {mWidth / 2, mHight / 2};

	private Model mModel;

	/**
	 *  Der Konstruktor erzeugt ein sichtbares Fenster und setzt Eigenschaften,
	 * dazu gehoeren:
	 * Das Fenster wird geschlossen mit einem Klick auf das X oben 
	 * rechts am Fenster.
	 * Die Groesse des Fensters kann nicht manuell veraendert werden.
	 * Die Groesse und der Hintergrund wird gesetzt.
	 * 
	 * @param aModel Der Parameter wird als Model für die Klasse festgelegt.
	 *
	 */
	public FunctionPlotter(Model aModel) {
		// Erstellt ein neues anfangs unsichtbares Fenster.
		super("FunctionPlotter"); 
		// Reaktion, wenn das Fenster geschlossen wird.
		mModel = aModel;
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		// legt fest ob die Groesse des Fensters manuell veraendert werden kann.
		setResizable(false); 
		// legt die Groessee des Fensters fest.
		setSize(mWidth, mHight); 
		getContentPane().setBackground(Color.WHITE);
		// Zeigt (true) oder verbirgt (false) das Fenster
		setVisible(true); 
	}

	/**
	 * Die Methode paint zeichnet in das Frame.
	 */
	@Override 
	public void paint(Graphics g) {
		super.paint(g);
//
//		mMinX = -10.;
//		mMaxX = 10.;
//		mMinY = -10.;
//		mMaxY = 10.;

		drawCross(g);
		drawFunction(g);

	}

	/**
	 * Methode drawCross definiert das zu zeichnende Koordinatensystem, 
	 * bzw die x- und y-Achse, dazu gehoert auch das zeichnen
	 * der Koordinaten-Achsen.
	 */
	private void drawCross(Graphics g) {

		// Bestimme die Schriftarten
		final int signFontSize = 25;
		Font signFont = new Font(Font.SERIF, Font.ITALIC, signFontSize);
		final int ticksFontSize = 15;
		Font ticksFont = new Font(Font.SERIF, Font.PLAIN, ticksFontSize);
		
		// Berechne die Bildkoordinaten des Ursprungs
		int originX = mWidth / 2;
		int originY = mHight / 2;
		
		// 
		
		// Berechne ganzzahlige Werte fuer xmin, xmax, ymin, ymax
		final int intMinX = (int) mMinX;
		final int intMaxX = (int) mMaxX;
		final int intMinY = (int) mMinY;
		final int intMaxY = (int) mMaxY;
		
		// Beschriftung der Achsen
		g.setFont(signFont);
		final int xSignPosX = (int) (mWidth * 9.75 / 10);
		final int xSignPosY = (int) (mHight / 2 + 20);  
		final int ySignPosX = (int) (mWidth / 2 - 20);
		final int ySignPosY = (int) (mHight * 0.25 / 10);
		g.drawString("x", xSignPosX, xSignPosY);
		g.drawString("y", ySignPosX, ySignPosY);

		// Zeichne die x-Achse
		g.setFont(ticksFont);
		g.drawLine(0, originY, mWidth, originY);
		final double rangeX = mMaxX - mMinX;
		final double offsetX = Math.abs(mMaxX - intMaxX) / rangeX * mWidth;
		final double resX = mWidth / rangeX;
		final int shiftX = -4;
		for (int i = intMinX; i <= intMaxX; i++) {
			// Einteilung der x-Achse
			int tickPosX = (int) (offsetX + (i - intMinX) * resX);
			g.drawLine(tickPosX, originY + 1, tickPosX, originY - 1);
			//if (i != intMinX && i != 0 && i != intMaxX)
			if (i != 0 && (tickPosX < xSignPosX && tickPosX > shiftX * THREE)) {
				String s = String.valueOf(i);
				g.drawString(s, tickPosX + shiftX * s.length(), xSignPosY);
			}
		}

		// Zeichne die y-Achse
		g.drawLine(originX, 0, originX, mHight);
		final double rangeY = mMaxY - mMinY;
		final double offsetY = Math.abs(mMaxY - intMaxY) / rangeY * mHight;
		final double resY = mHight / rangeY;
		final int shiftY = 6;
		for (int i = intMinY; i <= intMaxY; i++) {
			// Einteilung der y-Achse
			int tickPosY = mHight - (int) (offsetY + (i - intMinY) * resY);
			g.drawLine(originX + 1, tickPosY, originX - 1, tickPosY);
			if (i != 0 && (tickPosY < mHight - shiftY 
					&& tickPosY > ySignPosY)) {
				String s = String.valueOf(i);
				g.drawString(s, ySignPosX + shiftX 
						* (s.length() - 2), tickPosY + shiftY);
			}
		}
		
		// Bezeichne den Ursprung
		g.drawString(String.valueOf(0), 
				originX + shiftX * THREE, originY + shiftY * THREE);

	}

	/**
	 * Erstellt die Grafik zu einer Funktion.
	 */
	private void drawFunction(Graphics g) {

		Funktion actFunktion = mModel.getFunktion();
		
		// Bestimme die Farbe für die Graphik
		g.setColor(Color.red);

		// Lege das Array für die Wertepaare an
		//double[][] points = new double[m_Width][2];
		//int[][] pointsInt = new int[m_Width][2];

		int intXprev = 0;
		int intYprev = 0;

		final int resolution = 600;

		for (int i = 0; i <= resolution; i++) {

			// Bestimme die Wertepaare
			double x = mMinX + i * (mMaxX - mMinX) / resolution;
			double y = actFunktion.getValue(x);

			//if(y < m_minY) m_minY = y;
			//if(y > m_maxY) m_maxY = y;

			//points[i] = new double[] {x, y};

			// Rechne die Koordinaten um
			int intX = (int) ((x - mMinX) * (double) mWidth / (mMaxX - mMinX));
			int intY = mWidth - (int) ((y - mMinY) 
					* (double) mHight / (mMaxY - mMinY));

			// Zeiche den Linienzug
			if (i != 0) {
				g.drawLine(intXprev, intYprev, intX, intY);
			}

			intXprev = intX;
			intYprev = intY;

		}

	}

}