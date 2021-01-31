package flappybird;
import java.io.*;

public class Score implements Comparable<Score>, Serializable {
    //aquí de manera general se podría decir que es dónde haremos la comparación de los puntos generados anteriormente con los actuales

   
    private int puntos;

    public Score(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public int compareTo(Score nuevoPuntaje) {
        if (this.puntos < nuevoPuntaje.puntos) {
            return 1;
        } else if (this.puntos > nuevoPuntaje.puntos) {
            return -1;
        } else {
            return 0;
        }
    }
        
}