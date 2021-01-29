import java.io.*;
import java.util.*;
import java.util.logging.*;


public class ScoresFile {

    private final File highScoreFile;

    public ScoresFile() {
        highScoreFile = new File("highscores.dat");//con .dat se guardan datos de tipo genérico que dan soporte al programa con el que fueron creados
                                                //es más fácil de manipular
    }
    //lo que hace cargarPuntaje es mostrar el tablero de puntuación, aquí no se crea el archivo (esto ocurre en guardarPuntos)
    //como bien sabemos, esto genera excepciones, para mostrarlas investigué un poco más y me encontré con Logger
    //Logger lo que hace es mandar mensajes de la ejecución de la aplicación, es un poco más formal para dar a conocer las excepciones xd
    
    public void cargarPuntaje(Scores scores) {
        FileInputStream ficheroTableroPuntos = null;
        try {
            ficheroTableroPuntos = new FileInputStream(highScoreFile);
            ObjectInputStream objTab = new ObjectInputStream(ficheroTableroPuntos);
            scores.setListaPuntajes((ArrayList<Score>)objTab.readObject());
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ScoresFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(ficheroTableroPuntos != null) {
                   ficheroTableroPuntos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ScoresFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //es muy parecido a cargarPuntaje
    public void guardarPuntos(Scores scores) {
        FileOutputStream ficheroGuardarPuntos = null;
        try {
            ficheroGuardarPuntos = new FileOutputStream(highScoreFile);
            ObjectOutputStream objPuntaje = new ObjectOutputStream(ficheroGuardarPuntos);
            objPuntaje.writeObject((ArrayList<Score>)scores.getListaPuntajes());
            objPuntaje.close();
        } catch (IOException ex) {
            Logger.getLogger(ScoresFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(ficheroGuardarPuntos != null) {
                   ficheroGuardarPuntos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ScoresFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}