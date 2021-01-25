/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Sofia
 */
public class Bird {    
    private Rectangle rectangle;
    private ImageIcon bird;
    private int x;
    private int y;
    private boolean muerto = false;
    private final int WIDTH=358;
    private final int HEIGHT=259;
     
    public Bird(){              
        bird = new ImageIcon("quetzal.png");     
    }
    
    public ImageIcon getBird() {
        return bird;
    }

    public void setBird(ImageIcon bird) {
        this.bird = bird;
    }
    
    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
        
    public boolean isMuerto() {
        return muerto;
    }

    public void Matar() {
        this.muerto = true;
    }
    
    public void Vivir(){
        this.muerto = false;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
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
    
    
}
