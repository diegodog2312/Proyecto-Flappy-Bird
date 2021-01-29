package flappybird;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {        
        Bird bird = new Bird();
        Arbol arbol1 = new Arbol();
        Arbol arbol2 = new Arbol();
        Screen screen = new Screen();
        
        JFrame frame = new JFrame("Flappy Quetzal");
        frame.setSize(518,724);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new CardLayout(0,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new NewJPanel(bird, arbol1, arbol2, screen),BorderLayout.CENTER);
        //frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Cuadro.class.getResource("quetzal.png")));
        
    }    
}
