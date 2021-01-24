
package flappybird;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 *
 * @author diegoignacionunezhernandez
 */
public class Screen extends JPanel{
    private JFrame frame;  
    private Arbol arbol;
    
    public Screen(String titulo) {
        this.frame = new JFrame(titulo);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        arbol = new Arbol("tree.png", 10, 10, 10, 100, 100);
        BufferedImage bi = new BufferedImage(arbol.getWidth(), arbol.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g =bi.getGraphics();
        arbol.dibuja(g);
    }        
}
