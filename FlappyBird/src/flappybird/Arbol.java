package flappybird;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author diegoignacionunezhernandez
 */
public class Arbol {
    private ImageIcon tree;
    private int x;
    private int y;
    private int vx;
    private int xt;
    private int vy;
    private Rectangle rectangle;
    private final int HEIGHT=632;
    private final int WIDTH=632;

    public Arbol() {      
        tree = new ImageIcon("tree.png");
    }
    
    
    public ImageIcon getTree() {
        return tree;
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

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getXt() {
        return xt;
    }

    public void setXt(int xt) {
        this.xt = xt;
    }

    public int getHeight() {
        return HEIGHT;
    }


    public int getWidth() {
        return WIDTH;
    }                             
}
