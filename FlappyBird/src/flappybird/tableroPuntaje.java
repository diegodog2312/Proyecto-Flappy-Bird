package flappybird;
import java.awt.*;
import javax.swing.*;

/**
 * Clase encargada de mostrar los puntajes máximos.
 * @author Proyecto POO
 */
public class tableroPuntaje extends javax.swing.JPanel {
    
    Scores scores;
            
    /**
     * Constructor de la clase, se especifica el tamaño que tendrá el panel y el objeto tipo Scores que se utilizará.
     * @param scores
     */
    public tableroPuntaje(Scores scores) {
        this.setSize(240, 180);
        this.scores = scores;
    }

    private void drawString(Graphics g,String text, int x, int y) { 
        for (String line : text.split("\n")) 
                g.drawString(line, x, y+= g.getFontMetrics().getHeight()); 

    } 

    public void paint(Graphics grafico) {
        Dimension height = getSize();
        
        ImageIcon img = new ImageIcon("fondo.png");
        grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);

        Color color = new Color(41,176,76);
        grafico.setColor(color);
        grafico.setFont(new Font("Serif", Font.BOLD, 20));
        grafico.setColor(java.awt.Color.black);
        drawString(grafico,scores.toString(),77,30);
        
        setOpaque(false);
        super.paintComponent(grafico);
    }
}
