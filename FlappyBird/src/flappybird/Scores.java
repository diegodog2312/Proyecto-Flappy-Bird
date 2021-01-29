import java.util.*;
import java.text.*;

public class Scores  {

    public static final int MAX_NUM_PUNTAJES = 3;
    private ArrayList<Score> listaPuntajes = new ArrayList();

    public ArrayList<Score> getListaPuntajes() {
        return listaPuntajes;
    }

    public void setListaPuntajes(ArrayList<Score> listaPuntajes) {
        this.listaPuntajes = listaPuntajes;
    }
    //esta parte añadirá los puntos pero cuidando que no sean mayores a 3 puntuaciones
    public void anadirPuntaje(Score puntuacion) {
        listaPuntajes.add(puntuacion);
        Collections.sort(listaPuntajes);
        if(listaPuntajes.size() > MAX_NUM_PUNTAJES) {
            listaPuntajes.remove(listaPuntajes.size() - 1);
        }
    }

    public int getPosicion(Score puntuacion) {
        return listaPuntajes.indexOf(puntuacion);
    }
    //mostrar la evolución de los resultados, es decir, lo que se ha ido obteniendo de acuerdo a cada jugada
    @Override
    public String toString() {
        String resultado = "";
        String strDateFormat="dd-MMM-aa";
        Date fechaCompleta = new Date();
        SimpleDateFormat fechaCorta=new SimpleDateFormat(strDateFormat);
        for(int i=listaPuntajes.size()-1; i<=listaPuntajes.size()-1; i++) {
            Score puntuacion = listaPuntajes.get(i);
            resultado += i + (fechaCorta.format(fechaCompleta)) +"Puntaje obtenido"+ ": " + puntuacion.getPuntos() + "\n";
        }
        return resultado;
    }
       
}