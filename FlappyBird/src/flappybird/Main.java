package flappybird;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Clase principal, en esta clase se tendrá al método main para dar inicio al programa.
 * @author Proyecto POO
 */
public class Main {

    /**
     * Método principal, en él se instanciarán los personajes del juego y el controlador.Además, se iniciará el juego.
     * @param args the command line arguments
     * @throws java.lang.InterruptedException Excepción en caso de no poder iniciar el juego.
     */
    public static void main(String[] args) throws InterruptedException {        
        Bird bird = new Bird();
        Obstaculo arbol1 = new Obstaculo(0);
        Obstaculo arbol2 = new Obstaculo(0);
        Obstaculo nube1 = new Obstaculo(1);
        Obstaculo nube2 = new Obstaculo(1);
        Obstaculo pasto = new Obstaculo(2);
        Obstaculo techo = new Obstaculo(3);
        Screen screen = new Screen();
        Sonidos sonidos = new Sonidos();
        //screen.colocarBotones();
        
        Controller controller = new Controller(bird, arbol1, arbol2,nube1, nube2, screen,sonidos,pasto,techo,true);
        
        controller.jugar();
        
        
//        Cuadro frame = new Cuadro(controller);
//        frame.setSize(518,724);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        frame.setLayout(new CardLayout());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //NewJPanel p_inicio = new NewJPanel(controller);
//        //frame.add(p_inicio,BorderLayout.CENTER);
//        //frame.add(screen.layeredPane);
//        //p_inicio.setOpaque(true);
//        //frame.setUndecorated(true);
//        frame.setVisible(true);
//        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Cuadro.class.getResource("quetzal.png")));
//        frame.revalidate();
//        frame.repaint();
        
    }
    
}
