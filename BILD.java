import ea.edu.*;
import ea.*;

/**
 * Klasse BILD zum Darstellen eines GIF, JPG, PNG in EDU-Engine
 * 
 * @author      mike ganshorn
 * 
 * @version     1.4-beginner (2017-04-11)
 * 
 * @changelog   1.4 WECHSELBILD erbt von Knoten und damit von Raum
 *                  verschiebenUm greift auf bewegen zurueck
 *                  Methoden in allen Klassen vereinheitlicht (bis auf indiv. Methoden)
 *  
 *              1.3 Methode beruehrt(WECHSELBILD) hinzugefuegt
 * 
 *              1.2 Jump'n'Run-Physik hinzu gefuegt
 * 
 *              1.1 Konstruktor setzt nun Bild-Mittelpunkt auf uebergebenen Mittelpunkt (nicht Ecke links oben)
 *              
 *              
 */
public class BILD
extends BildE
{
    
    
    /**
     * BILD Konstruktor
     *
     * @param   x       x-Koordinate im Fenster (Pixel)
     * @param   y       y-Koordinate im Fenster (Pixel)
     * @param   name    Name der Grafik-Datei (im Projekt-Ordner)
     */
    public BILD(int x, int y, String name)
    {
        super(x, y, name);
        this.setzeMittelpunkt(x, y);
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
    public boolean beruehrt(Raum r) {
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
        return (float)( -this.gibDrehung() );
    }
    
    
    /**
     * liefert den Sinus des Drehwinkels der Grafik
     *
     * @return  Sinus des aktuellen Drehwinkels
     */
    public float sin_Drehwinkel()
    {
        return (float)( Math.sin( this.gibDrehung() * Math.PI / 180 ) );
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
        return this.mittelPunkt().x() - grafikObjekt.mittelPunkt().x();
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Kreises vom Mittelpunkt 
     * eines anderen Grfik-Objekts in y-Richtung entfernt ist.
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * @return  Abstand (in Pixeln) dieses Kreises vom anderen Grafik-Objekt in y-Richtung (>0, wenn dieser Kreis unterhalb des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandY(Raum grafikObjekt)
    {
        return this.mittelPunkt().x() - grafikObjekt.mittelPunkt().y();
    }
    
    


}
