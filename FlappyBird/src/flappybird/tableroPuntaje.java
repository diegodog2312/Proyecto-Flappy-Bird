package flappybird;
import java.awt.*;
import javax.swing.*;

public class tableroPuntaje extends javax.swing.JPanel {
    
    Scores scores;
            
    public tableroPuntaje(Scores scores) {
        this.setSize(290, 220);
        this.scores = scores;
    }

    private void drawString(Graphics g,String text, int x, int y) { 
        for (String line : text.split("\n")) 
                g.drawString(line, x, y+= g.getFontMetrics().getHeight()); 

    } 

    public void paint(Graphics grafico) {
        Dimension height = getSize();
        
        //ImageIcon Img = new ImageIcon(getClass().getResource("fondo.png")); 
        //grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

        Color color = new Color(41,176,76);
        grafico.setColor(color);
        grafico.setFont(new Font("Serif", Font.BOLD, 23));
        grafico.drawString("HIGHSCORES",45,50);
        grafico.setFont(new Font("Serif", Font.BOLD, 20));
        grafico.setColor(java.awt.Color.black);
        drawString(grafico,scores.toString(),35,65);
        
        setOpaque(false);
        super.paintComponent(grafico);
    }
}