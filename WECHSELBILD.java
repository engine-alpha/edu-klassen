
/**
 * Klasse WECHSELBILD ermoeglicht einen Bildwechsel zwischen beliebig vielen Einzel-Bildern.
 * 
 * @author      mike ganshorn
 * @version     1.1 (2015-02-14)
 */
public class WECHSELBILD
{
    private BILD[] bilder;
    private int nummerSichtbar;
    
    
    /**
     * Konstruktor der Klasse WECHSELBILD
     * 
     * @param   bilddateien     Array mit den einzelnen Bild-Dateinamen
     */
    public WECHSELBILD(String[] bilddateien)
    {
        this(-500,300,bilddateien);
    }
    
    
    /**
     * Konstruktor der Klasse WECHSELBILD
     * 
     * @param   x               x-Koordinate des Mittelpunkts des Wechselbilds
     * @param   y               y-Koordinate des Mittelpunkts des Wechselbilds
     * @param   bilddateien     Array mit den einzelnen Bild-Dateinamen
     */
    public WECHSELBILD(int x, int y, String[] bilddateien)
    {
        this.bilder = new BILD[bilddateien.length];
        for (int i=0 ; i<bilddateien.length ; i++) {
            this.bilder[i] = new BILD(x,y,bilddateien[i]);
        }
        this.sichtbar(0);
    }
    
    
    /**
     * Setzt alle Teil-Bilder unsichtbar
     *
     */
    public void unsichtbar()
    {
        for (int i=0 ; i<this.bilder.length ; i++) {
            this.bilder[i].setzeSichtbar(false);
        }
    }
    
    
    /**
     * Setzt das aktuelle Bild sichtbar, die anderen unsichtbar. 
     *
     */
    public void sichtbar()
    {
        if ( this.nummerSichtbar<this.bilder.length  &&  this.nummerSichtbar>=0 ) {
            this.bilder[this.nummerSichtbar].setzeSichtbar(true);
        }
    }
    
    
    /**
     * Setzt ein Bild sichtbar, die anderen unsichtbar. 
     * Wenn es diesen Bild-Index nicht gibt, dann werden alle Bilder unsichtbar.
     *
     * @param   i   Der Index des Bildes, das sichtbar werden soll.
     */
    public void sichtbar(int i)
    {
        this.unsichtbar();
        if ( i<this.bilder.length  &&  i>=0 ) {
            this.bilder[i].setzeSichtbar(true);
        }
        this.nummerSichtbar = i;
    }
    
    
    /**
     * Verschiebt das Wechselbild.
     *
     * @param   deltaX  x-Komponente der Verschiebung in px
     * @param   deltaY  y-Komponente der Verschiebung in px
     */
    public void verschiebenUm(double deltaX, double deltaY)
    {
        for (int i=0 ; i<this.bilder.length ; i++) 
        {
            this.bilder[i].verschiebenUm(deltaX, deltaY);
        }
    }
    
    
    /**
     * Setzt den Mittelpunkt des Wechselbildes
     *
     * @param   x   Die neue x-Koordinate (in px) des Mittelpunkts
     * @param   y   Die neue y-Koordinate (in px) des Mittelpunkts
     */
    public void setzeMittelpunkt(int x, int y)
    {
        for (int i=0 ; i<this.bilder.length ; i++) 
        {
            this.bilder[i].setzeMittelpunkt(x, y);
        }
    }
    
    
    /**
     * Wechselt zum naechsten Bild und merkt es als aktives Bild vor. 
     * Wenn das Wechselbild gerade unsichtbar ist, so ist dieser Effekt erst sichtbar, 
     * wenn wieder auf sichtbar geschaltet wird.
     *
     */
    public void wechseln()
    {
        if ( this.nummerSichtbar<this.bilder.length  &&  this.nummerSichtbar>=0 ) 
        {
            int naechstesBild = (this.nummerSichtbar + 1) % this.bilder.length;
            this.sichtbar(naechstesBild);
            this.nummerSichtbar = naechstesBild;
        }
    }
    
    
    /**
     * Wartet einige Millisekunden, bis der naechste Befehl ausgefuehrt wird.
     *
     * @param   ms  Dauer des Wartens in Millisekunden
     */
    public void warte(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
