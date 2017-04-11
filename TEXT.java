import ea.edu.*;
import ea.*;

/**
 * Klasse TEXT zum Darstellen von Texten in EDU-Engine
 * 
 * @author      mike ganshorn
 * 
 * @version     1.3-beginner (2017-04-11)
 *                  Methode:    setzeGroesse(...)
 *                              setzeFarbe(...)
 * 
 * @changelog   1.3 WECHSELBILD erbt von Knoten und damit von Raum
 *                  verschiebenUm greift auf bewegen zurueck
 *                  Methoden in allen Klassen vereinheitlicht (bis auf indiv. Methoden)
 *                  setzeInhalt(int) hinzugefuegt (bisher nur String)
 *                  Konstruktor(int,int,int) hinzugefuegt (bisher nur int,int,String)
 * 
 *              1.2 Methode beruehrt(WECHSELBILD) hinzugefuegt
 * 
 *              1.1 Jump'n'Run-Physik hinzu gefuegt
 *              
 */
public class TEXT
extends TextE 
{
    
    
    /**
     * TEXT Konstruktor
     *
     * @param   x       x-Koordinate im Fenster (Pixel)
     * @param   y       y-Koordinate im Fenster (Pixel)
     * @param   text    anzuzeigender Text
     */
    public TEXT(int x, int y, String text) 
    {
        super(text);
        super.mittelpunktSetzen(x, y);
    }
    
    
    /**
     * TEXT Konstruktor
     *
     * @param   x       x-Koordinate im Fenster (Pixel)
     * @param   y       y-Koordinate im Fenster (Pixel)
     * @param   zahl    anzuzeigende Zahl
     */
    public TEXT(int x, int y, int zahl) 
    {
        super(""+zahl);
        super.mittelpunktSetzen(x, y);
    }
    
    
    /**
     * Setzt den angezeigten Text neu.
     *
     * @param   text    Der neue Text
     */
    public void setzeInhalt(String text)
    {
        super.setzeInhalt(text);
    }
    
    
    /**
     * Setzt den angezeigten Text neu.
     *
     * @param   text    Der neue Text
     */
    public void setzeInhalt(int zahl)
    {
        super.setzeInhalt(""+zahl);
    }
    
    
    /**
     * Methode verschiebenUm
     *
     * @param   deltaX  Pixel in x-Richtung (wird bei Bedarf auf ganze Pixel gerundet)
     * @param   deltaY  Pixel in y-Richtung (wird bei Bedarf auf ganze Pixel gerundet)
     */
    public void verschiebenUm(float deltaX, float deltaY) 
    {
        super.bewegen( deltaX , deltaY );
    }
    
    
    /**
     * Methode beinhaltetPunkt
     *
     * @param   x   x-Koordinate des Punkts (Pixel)
     * @param   y   x-Koordinate des Punkts (Pixel)
     * @return      true, wenn Punkt innerhalb der Grafik
     */
    public boolean beinhaltetPunkt(int x, int y) 
    {
        return super.beinhaltet( new Punkt(x, y) );
    }
    
    
    /**
     * Methode setzeMittelpunkt
     *
     * @param   x   x-Koordinate des Mittelpunkts (Pixel)
     * @param   y   y-Koordinate des Mittelpunkts (Pixel)
     */
    public void setzeMittelpunkt(int x, int y) 
    {
        super.mittelpunktSetzen(x, y);
    }
    
    
    /**
     * Methode nenneMx
     *
     * @return  x-Koordinate des Mittelpunkts (Pixel)
     */
    public int nenneMx() 
    {
        return super.zentrum().x();
    }
    
    
    /**
     * Methode nenneMy
     *
     * @return  y-Koordinate des Mittelpunkts (Pixel)
     */
    public int nenneMy() 
    {
        return super.zentrum().y();
    }
    
    
    /**
     * Methode setzeSichtbar
     *
     * @param   sichtbarNeu     true, wenn die Grafik sichtbar sein soll
     */
    public void setzeSichtbar(boolean sichtbarNeu) 
    {
        super.sichtbarSetzen(sichtbarNeu);
    }
    
    
    /**
     * Methode nenneSichtbar
     *
     * @return  true, wenn die Grafik gerade sichbar ist
     */
    public boolean nenneSichtbar()
    {
        return super.sichtbar();
    }
    
    
    /**
     * Methode beruehrt
     *
     * @param   r   Ein anderes BILD, RECHTECK, KREIS, DREIECK, ...
     * @return  true, wenn sich die beiden Objekte ueberschneiden
     */
    public boolean beruehrt(Raum r) 
    {
        return super.schneidet(r);
    }

    
    /**
     * Dreht die Grafik um einen Winkel
     *
     * @param   winkelAenderung     +: mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *                              -: mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public void drehenUm(float winkelAenderung)
    {
        this.drehenRelativ( -winkelAenderung );
    }
    
    
    /**
     * Setzt den Drehwinkel auf eine absoluten neuen Wert
     *
     * @param   neuerDrehwinkel     der neue Drehwinkel
     *                              +: mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *                              -: mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public void setzeDrehwinkel(float neuerDrehwinkel)
    {
        this.drehenAbsolut( -neuerDrehwinkel );
    }
    
    
    /**
     * Nennt den Winkel, um den die Grafik gedreht wurde
     *
     * @return      der Winkel, um den die Grafik gedreht wurde
     *              0: wenn nicht gedreht
     *              +: wenn mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *              -: wenn mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public float nenneWinkel()
    {
        return (float)( -super.gibDrehung() );
    }
    
    
    /**
     * liefert den Sinus des Drehwinkels der Grafik
     *
     * @return  Sinus des aktuellen Drehwinkels
     */
    public float sin_Drehwinkel()
    {
        return (float)( Math.sin( super.gibDrehung() * Math.PI / 180 ) );
    }
    
    
    /**
     * liefert den Cosinus des Drehwinkels der Grafik
     *
     * @return  Cosinus des aktuellen Drehwinkels
     */
    public float cos_Drehwinkel()
    {
        return (float)( Math.cos( this.gibDrehung() * Math.PI / 180 ) );
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
     * eines anderen Grfik-Objekts in x-Richtung entfernt ist.
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * @return  Abstand (in Pixeln) dieses Rechtecks vom anderen Grafik-Objekt in x-Richtung (>0, wenn dieses Rechteck rechts des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandX(Raum grafikObjekt)
    {
        return super.mittelPunkt().x() - grafikObjekt.mittelPunkt().x();
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Kreises vom Mittelpunkt 
     * eines anderen Grfik-Objekts in y-Richtung entfernt ist.
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * @return  Abstand (in Pixeln) dieses Kreises vom anderen Grafik-Objekt in y-Richtung (>0, wenn dieser Kreis unterhalb des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandY(Raum grafikObjekt)
    {
        return super.mittelPunkt().x() - grafikObjekt.mittelPunkt().y();
    }
    
    

    /**
     * Setzt die Schriftgroesse auf einen neuen Wert.
     *
     * @param   schriftgroesse  neue Schriftgroesse
     */
    public void setzeGroesse( int schriftgroesse )
    {
        super.groesseSetzen( schriftgroesse );
    }
    
    
    
    /**
     * Setzt die Schriftfarbe neu.
     *
     * @param   schriftfarbe    Die neue Schriftfarbe
     */
    public void setzeFarbe( String schriftfarbe )
    {
        super.farbeSetzen( schriftfarbe );
    }
}
