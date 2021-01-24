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
    private boolean bool; 
    private Rectangle rectangle;
    private Image bird;
    private int x;
    private int y;
    private int fall;
    private int width;
    private int height;
     
    public Bird(String name, int x, int y, int width, int height){
        bird = new ImageIcon(this.getClass().getResource(name)).getImage();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bird =  this.bird.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    
    
    public void fly(){
        fall = 
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
    public int getFall() {
        return fall;
    }

    public void setFall(int fall) {
        this.fall = fall;
    }

    
    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public Rectangle getRectangle() {
        return (new Rectangle(x, y, width, height));
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Image getBird() {
        return bird;
    }

    public void setBird(Image bird) {
        this.bird = bird;
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
