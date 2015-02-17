/** @author     mike ganshorn
 * 
 *  @Version    2.1 (2015-02-14)
 *  
 *  keine Abhaengigkeit mehr zwischen den alpha-Formen
 *  
 *  Der Mittelpunkt des Dreiecks ist hier der Mittelpunkt des umhuellenden Rechtecks !!!
*/

import ea.edu.DreieckE;
import ea.Raum;

/**
 * Diese Klasse stellt ein einfaches Dreieck dar.
 */
public class DREIECK 
        extends DreieckE 
{
    
    /**
     * Die Farbe dieses Dreiecks
     */
    private String farbe;
    
    /**
     * Gibt an, ob dieses Dreieck sichtbar ist.
     */
    private boolean sichtbar;
    
    /**
     * x-Koordinate des Eckpunkts A
     */
    private int A_x;
    
    /**
     * y-Koordinate des Eckpunkts A
     */
    private int A_y;
    
    /**
     * x-Koordinate des Eckpunkts B
     */
    private int B_x;
    
    /**
     * y-Koordinate des Eckpunkts B
     */
    private int B_y;
    
    /**
     * x-Koordinate des Eckpunkts C
     */
    private int C_x;
    
    /**
     * y-Koordinate des Eckpunkts C
     */
    private int C_y;
    
     /**
     * x-Koordinate des Mittelpunkts des umschliessenden Rechtecks
     */
    private int M_x;
    
    /**
     * y-Koordinate des Mittelpunkts des umschliessenden Rechtecks
     */
    private int M_y;
    
    
    /**
     * Konstruktor der Klasse <code>DREIECK</code>. Erstellt ein neues Standard-Dreieck.
     */
    public DREIECK() 
    {
        this( 80 , 190 , 150 , 70 , 220 , 190 );
    }
    
    
    /**
     * Konstruktor der Klasse <code>DREIECK</code>. Erstellt ein neues Dreieck mit gegebenen Eck-Koordinaten. 
     * Die Reihenfolge der Ecken ist egal. 
     *
     * @param   x1  Die x-Koordinate der ersten Ecke
     * @param   y1  Die y-Koordinate der ersten Ecke
     * @param   x2  Die x-Koordinate der zweiten Ecke
     * @param   y2  Die y-Koordinate der zeiten Ecke
     * @param   x3  Die x-Koordinate der dritten Ecke
     * @param   y3  Die y-Koordinate der dritten Ecke
     */
    public DREIECK(int x1, int y1, int x2, int y2, int x3, int y3) 
    {
        this.A_x = x1;
        this.A_y = y1;
        this.B_x = x2;
        this.B_y = y2;
        this.C_x = x3;
        this.C_y = 50;
        this.M_x = ( Math.min(Math.min(x1,x2),x3) + Math.max(Math.max(x1,x2),x3) ) / 2 ;
        this.M_y = ( Math.min(Math.min(y1,y2),y3) + Math.max(Math.max(y1,y2),y3) ) / 2 ;
        super.punkteSetzen(x1, y1, x2, y2, x3, y3);
        this.sichtbar = true;
        super.sichtbarSetzen(true);
        this.farbe = "Gruen";
        super.farbeSetzen(this.farbe);
    }
    
    
    /**
     * Setzt die Ecken dieses Dreiecks (A, B, C) neu.
     * @param   a_x Die X-Koordinate des Punktes A
     * @param   a_y Die Y-Koordinate des Punktes A
     * @param   b_x Die X-Koordinate des Punktes B
     * @param   b_y Die Y-Koordinate des Punktes B
     * @param   c_x Die X-Koordinate des Punktes C
     * @param   c_y Die Y-Koordinate des Punktes C
     */
    public void setzeEcken(int a_x, int a_y, int b_x, int b_y, int c_x, int c_y) 
    {
        this.A_x = a_x;
        this.A_y = a_y;
        this.B_x = b_x;
        this.B_y = b_y;
        this.C_x = c_x;
        this.C_y = c_y;
        this.M_x = ( Math.min(Math.min(a_x,b_x),c_x) + Math.max(Math.max(a_x,b_x),c_x) ) / 2 ;
        this.M_y = ( Math.min(Math.min(a_y,b_y),c_y) + Math.max(Math.max(a_y,b_y),c_y) ) / 2 ;
        super.punkteSetzen(a_x, a_y, b_x, b_y, c_x, c_y);
    }
    
    
    /**
     * Setzt die Farbe dieses Dreiecks neu.
     * @param   farbeNeu    Diese Farbe erhaelt das Dreieck (z.B. "Rot")
     */
    public void setzeFarbe(String farbeNeu) 
    {
        this.farbe = farbeNeu;
        super.farbeSetzen(farbe);
    }
    
    
    /**
     * Setzt den Mittelpunkt dieses Dreieck neu.<br />
     * <b>ACHTUNG!</b><br />
     * Dies ist <i>nicht</i> der geometrische Mittelpunkt. Denkt man sich ein Rechteck, 
     * das man "genau ueber das Dreieck" spannt, sodass es dieses gerade von allen Seiten umschliesst, 
     * so ist der Mittelpunkt <b>dieses Rechtecks</b> der, der hier neu gesetzt wird.
     * @param   m_x Die X-Koordinate des neuen Mittelpunktes
     * @param   m_y Die Y-Koordinate des neuen Mittelpunktes
     */
    public void setzeMittelpunkt(int m_x, int m_y) 
    {
        int deltaX = m_x - this.M_x;
        int deltaY = m_y - this.M_y;
        this.A_x = this.A_x + deltaX;
        this.A_y = this.A_y + deltaY;
        this.B_x = this.B_x + deltaX;
        this.B_y = this.B_y + deltaY;
        this.C_x = this.C_x + deltaX;
        this.C_y = this.C_y + deltaY;
        this.M_x = m_x;
        this.M_y = m_y;
        super.mittelpunktSetzen(m_x, m_y);
    }
    
    
    /**
     * Setzt, ob dieses Dreieck sichtbar sein soll.
     * @param   sichtbarNeu Ist dieser Wert <code>true</code>, ist nach dem Aufruf dieser Methode dieses Dreieck 
     * sichtbar. Ist dieser Wert <code>false</code>, so ist nach dem Aufruf dieser Methode dieses Dreieck unsichtbar.
     */
    public void setzeSichtbar(boolean sichtbarNeu) 
    {
        this.sichtbar = sichtbarNeu;
        super.sichtbarSetzen(sichtbarNeu);
    }
    
    
    /**
     * Verschiebt dieses Dreieck um eine Verschiebung - angegeben durch ein "Delta X" und "Delta Y".
     * @param   deltaX  Der X Anteil dieser Verschiebung. Positive Werte verschieben nach rechts, negative nach links.
     * @param   deltaY  Der Y Anteil dieser Verschiebung. Positive Werte verschieben nach unten, negative nach oben.
     */
    public void verschiebenUm(int deltaX, int deltaY) 
    {
        this.A_x = this.A_x + deltaX;
        this.A_y = this.A_y + deltaY;
        this.B_x = this.B_x + deltaX;
        this.B_y = this.B_y + deltaY;
        this.C_x = this.C_x + deltaX;
        this.C_y = this.C_y + deltaY;
        this.M_x = this.M_x + deltaX;
        this.M_y = this.M_y + deltaY;
        super.verschieben(deltaX, deltaY);
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
     * Diese Methode gibt die x-Koordinate des Mittelpunkts dieses Dreiecks zurueck
     * @return  Die aktuelle x-Koordinate des Mittelpunktes dieses Dreiecks
     */
    public int nenneM_x()
    {
        return this.M_x;
    }
    
    
    /**
     * Diese Methode gibt die y-Koordinate des Mittelpunkts dieses Kreises zurueck
     * @return  Die aktuelle y-Koordinate des Mittelpunktes dieses Kreises
     */
    public int nenneM_y()
    {
        return this.M_y;
    }
    
    
    /**
     * Diese Methode gibt die Farbe dieses Dreiecks zurueck
     * @return  Die aktuelle Farbe dieses Dreiecks
     */
    public String nenneFarbe()
    {
        return this.farbe;
    }
    
    
    /**
     * Diese Methode gibt die Sichtbarkeit dieses Dreiecks zurueck
     * @return  Die aktuelle Sichtbarkeit dieses Dreiecks
     */
    public boolean nenneSichtbar()
    {
        return this.sichtbar;
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Rechtecks vom Mittelpunkt 
     * eines anderen Grfik-Objekts in x-Richtung entfernt ist.
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * @return  Abstand (in Pixeln) dieses Rechtecks vom anderen Grafik-Objekt in x-Richtung (>0, wenn dieses Rechteck rechts des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandX(Raum grafikObjekt)
    {
        return this.M_x - grafikObjekt.mittelPunkt().x();
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Dreiecks vom Mittelpunkt 
     * eines anderen Grfik-Objekts in y-Richtung entfernt ist.
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * @return  Abstand (in Pixeln) dieses Dreiecks vom anderen Grafik-Objekt in y-Richtung (>0, wenn dieses Dreieck unterhalb des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandY(Raum grafikObjekt)
    {
        return this.M_y - grafikObjekt.mittelPunkt().y();
    }
    
}