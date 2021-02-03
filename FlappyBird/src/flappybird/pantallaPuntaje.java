package flappybird;
import javax.swing.*;
import java.awt.*;

class pantallaPuntaje{
    public static void main(String args[]){
        tableroPuntaje background = new tableroPuntaje();
        JFrame frame = new JFrame("Puntaje");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        JButton back = new JButton("Regresar");
        panel.add(back);
        JPanel panelImagen=new JPanel();
        panelImagen.add(background);
        panelImagen.repaint();
        frame.getContentPane().add(BorderLayout.SOUTH, panel);      
        frame.getContentPane().add(background);
        frame.setVisible(true);
    }
}