import javazoom.jl.player.*; 
import java.io.*;

/**
 * Klasse SOUND kann MP3-Dateien abspielen
 * 
 * @author      mike ganshorn
 * @version     1.1 (2015-02-14)
 */
public class SOUND
{
    private InputStream is;
    private Player player;
    

    /**
     * Konstruktor der Klasse SOUND
     */
    public SOUND()
    {
        // Nichts
    }

    
    /**
     * Methode play
     *
     * @param   soundfile   Der Pfad zum Soundfile, ausgehend vom Projekt-Ordner
     */
    public void play(String soundfile)
    {
        try {
            is = new FileInputStream(soundfile);
        }
        catch (FileNotFoundException e) {
            System.out.println("Sounddatei " + soundfile + " nicht gefunden! Schreibweise pruefen!");
        }
        try {
            player = new Player(is);
            player.play();
        }
        catch (javazoom.jl.decoder.JavaLayerException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
