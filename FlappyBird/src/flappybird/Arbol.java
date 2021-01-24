package flappybird;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author diegoignacionunezhernandez
 */
public class Arbol {
    private Image tree;
    private int x;
    private int y;
    private int vx;
    private int xt;
    private int vy;
    private int height;
    private int width;

    public Arbol(String imagen, int vx, int xt, int vy, int height, int width) {
        this.tree = tree;
        this.vx = vx;
        this.xt = xt;       
        this.vy = vy;
        this.height = height;
        this.width = width;
        this.tree = new ImageIcon(this.getClass().getResource(imagen)).getImage();
        this.tree = this.tree.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    
    public void moverse(){
        setX(getX()+getVx());      
    }
    
    public void dibuja(Graphics g){      
        g.drawImage(tree,getX(),getY(),getXt(),getXt(),null);
    }
    
    
    public Image getTree() {
        return tree;
    }

    public Rectangle getRectangulo() {
        return (new Rectangle(x,y,width,height));
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
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
                            
    
}
