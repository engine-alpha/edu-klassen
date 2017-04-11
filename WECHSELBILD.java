import ea.Knoten;
import ea.edu.BildE;
import ea.edu.FensterE;
import ea.Raum;
import ea.Punkt;

/**
 * Klasse WECHSELBILD kann mehrere Bilder verwalten von denen immer nur eines angezeigt wird.
 * 
 * @author      mike ganshorn
 * @version     v1.1 (2017-04-11)
 * 
 * @changelog   1.1 verschiebenUm greift nun konsequent auf bewegen zurueck
 *                  sichtbar(int) hinzugefuegt
 *                  Methoden in allen Klassen vereinheitlicht (bis auf indiv. Methoden)
 * 
 *              1.0 Grundlegende Implementierung
 * 
 *              
 */
public class WECHSELBILD
extends Knoten
{
    private int anz_Bilder;
    private BildE[] bilder;
    private int akt_BildNr;

    
    /**
     * Konstruktor der Klasse WECHSELBILD.
     * 
     * @param   x           x-Koordinate des Mittelpunkts
     * @param   y           y-Koordinate des Mittelpunkts
     * @param   String...   Ein oder mehrere Dateinamen durch Kommata getrennt
     */
    public WECHSELBILD(int x, int y, String... dateien)
    {
        this.anz_Bilder = dateien.length;
        this.bilder = new BildE[this.anz_Bilder];

        for ( int i=0 ; i<this.anz_Bilder ; i++ )
        {
            this.bilder[i] = new BildE( x , y , dateien[i] );
            this.bilder[i].sichtbarSetzen(false);
            this.add(this.bilder[i]);
        }
        this.setzeMittelpunkt(x, y);
        

        this.bilder[0].sichtbarSetzen(true);
        this.akt_BildNr = 0;

        FensterE.getFenster().wurzel.add(this);
    }

    
    /**
     * Macht das aktuelle Bild unsichtbar und das naechste Bild sichtbar. 
     * Am Ende der Bilder wird wieder von Vorne bekonnen.
     *
     */
    public void wechseln()
    {
        this.bilder[this.akt_BildNr].sichtbarSetzen(false);
        this.akt_BildNr = (this.akt_BildNr + 1) % this.anz_Bilder;
        this.bilder[this.akt_BildNr].sichtbarSetzen(true);
    }
    

    /**
     * Macht das aktuelle Bild unsichtbar und das genannte Bild sichtbar. 
     * Sollte die gewahlte Bildnummer zu gross sein, wird ein anderes Bild sichtbar gemacht.
     *
     * @param   bildNr  Die Nummer des Bildes, das sichtbar gemacht werden soll
     */
    public void wechseln(int bildNr)
    {
        this.bilder[this.akt_BildNr].sichtbarSetzen(false);
        this.akt_BildNr = bildNr % this.anz_Bilder;
        this.bilder[this.akt_BildNr].sichtbarSetzen(true);
    }
    
    
//     /**
//      * Setzt das Bild mit dem Index i sichtbar, alle anderen unsichtbar.
//      *
//      * @param   i   Der Index des bildes, das sichtbar gesetzt werden soll
//      */
//     public void zeigeBild(int i)
//     {
//         for ( int z=0 ; z<this.bilder.length ; z++ )
//         {
//             if ( z == i )
//             {
//                 this.bilder[z].sichtbarSetzen(true);
//             }
//             else
//             {
//                 this.bilder[z].sichtbarSetzen(false);
//             }
//         }
//     }

    
    /**
     * Berechnet den Abstand von Mittelpunkt zu Mittelpunkt zu einem anderen Objekt in Pixeln. 
     *
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  x-Abstand der Mittelpunkte in Pixeln. 
     *          '>0' bedeutet, dass dieses Objekt rechts vom anderen liegt. 
     */
    public int berechneAbstandX(Raum grafikObjekt)
    {
        return this.bilder[this.akt_BildNr].mittelPunkt().x() - grafikObjekt.mittelPunkt().x();
    }

    
    /**
     * Berechnet den Abstand von Mittelpunkt zu Mittelpunkt zu einem anderen Objekt in Pixeln. 
     *
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  y-Abstand der Mittelpunkte in Pixeln. 
     *          '>0' bedeutet, dass dieses Objekt unter dem anderen liegt. 
     */
    public int berechneAbstandY(Raum grafikObjekt)
    {
        return this.bilder[this.akt_BildNr].mittelPunkt().y() - grafikObjekt.mittelPunkt().y();
    }

    
    /**
     * Prueft, ob dieses Grafik-Objekt ein anderes beruehrt. 
     *
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  Der Rückgabewert
     */
    public boolean beruehrt(Raum grafikObjekt)
    {
        return this.bilder[this.akt_BildNr].schneidet(grafikObjekt);
//         return grafikObjekt.schneidet(this);
    }
    
    
    /**
     * Methode beinhaltetPunkt
     *
     * @param   x   x-Koordinate des Punkts (Pixel)
     * @param   y   x-Koordinate des Punkts (Pixel)
     * 
     * @return      true, wenn Punkt innerhalb der Grafik
     */
    public boolean beinhaltetPunkt(int x, int y) 
    {
        return this.bilder[this.akt_BildNr].beinhaltet( new Punkt(x, y) );
//         return super.beinhaltet( new Punkt(x, y) );
    }

    
    /**
     * Nennt die x-Koordinate des Mittelpunkts dieses Grafik-Objekts. 
     *
     * @return  x-Koordinate des Mittelpunkts dieses Grafik-Objekts
     */
    public float nenneMx()
    {
        return this.bilder[this.akt_BildNr].mittelPunkt().x();
//         return this.mittelPunkt().x();
    }

    
    /**
     * Nennt die y-Koordinate des Mittelpunkts dieses Grafik-Objekts. 
     *
     * @return  y-Koordinate des Mittelpunkts dieses Grafik-Objekts
     */
    public float nenneMy()
    {
        return this.bilder[this.akt_BildNr].mittelPunkt().y();
//         return this.mittelPunkt().y();
    }

    
    /**
     * Gibt an, ob dieses Grafik-Objekt im Moment sichtbar ist. 
     *
     * @return  'true', wenn sichtbar; 'false', wenn unsichtbar
     */
    public boolean nenneSichtbar()
    {
        return this.bilder[this.akt_BildNr].sichtbar();
    }

    
    /**
     * Setzt den Mittelpunkt neu.
     *
     * @param   x   neue x-Koordinate
     * @param   y   neue y-Koordinate
     */
    public void setzeMittelpunkt(int x, int y)
    {
//         super.mittelpunktSetzen( x , y );
        for ( BildE bild: this.bilder )
        {
            bild.mittelpunktSetzen(x, y);
        }
    }

    
    /**
     * Setzt das Objekt sichtbar / unsichtbar.
     *
     * @param   b   'true' = sichtbar, 'false' = unsichtbar
     */
    public void setzeSichtbar(boolean b)
    {
        this.bilder[this.akt_BildNr].sichtbarSetzen(b);
    }

    
    /**
     * Verschiebt das Objekt auf dem Grafikfenster.
     *
     * @param   deltaX  Anzahl an Pixeln, die in x-Richtung verschoben wird ('+' = rechts)
     * @param   deltaY  Anzahl an Pixeln, die in y-Richtung verschoben wird ('+' = runter)
     */
    public void verschiebenUm(float deltaX, float deltaY)
    {
//         super.bewegen( deltaX , deltaY );
        for (BildE bild: this.bilder)
        {
            bild.bewegen(deltaX, deltaY);
        }
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
}
