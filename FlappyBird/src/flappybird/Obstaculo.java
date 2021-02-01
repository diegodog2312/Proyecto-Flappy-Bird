package flappybird;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author diegoignacionunezhernandez
 */
public class Obstaculo {
    private ImageIcon obs;
    private int x;
    private int y;
    private Rectangle rectangle;
    private final int HEIGHT;
    private final int WIDTH;

    /*public Arbol() {      
        tree = new ImageIcon("tree0.png");
    }    */
    
    public Obstaculo(int n) {  
        if(n == 0)
           obs = new ImageIcon("tree0.png"); 
        
        else
           obs = new ImageIcon("nube2.png");
        
        WIDTH = obs.getIconWidth();
        HEIGHT = obs.getIconHeight();
    }  
    
    public ImageIcon getObstaculo() {
        return obs;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle){
        this.rectangle = rectangle;                              
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getHeight() {
        return HEIGHT;
    }


    public int getWidth() {
        return WIDTH;
    }                             
}
