
package flappybird;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *Esta clase es la encargada de reproducir los sonidos para dar la ambientación musical al juego.
 * @author Proyecto POO
 */
public class Sonidos {
    private Clip clip;
    private Clip vuelo;

    /**
     * Mediante este método se reproducen sonidos como el haber obtenido un punto en el juego.
     * @param nombreSonido Nombre del archivo de sonido.
     */
    public void reproducirSonido(String nombreSonido){
         try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
         System.out.println("Error al reproducir el sonido.\n"+ex.getMessage());
       }
    }
    
    /**
     * Mediante este método se reproduce en un ciclo el sonido del vuelo del quetzal.
     */
    public void reproducirVuelo(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("volando.wav").getAbsoluteFile());
            vuelo = AudioSystem.getClip();
            vuelo.open(audioInputStream);
            vuelo.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.\n"+ex.getMessage());
        }
    }
    
    /**
     *Método para detener la reproducción del vuelo del quetzal.
     */
    public void stop(){
        System.out.println("stopp");
        vuelo.stop();
        vuelo.flush();
        vuelo.close();
    }
    
}
