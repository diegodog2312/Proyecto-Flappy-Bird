package flappybird;

import java.awt.*;
import javax.swing.ImageIcon;

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
        this.rectangle = new Rectangle(0, 0, 0, 0);
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
        this.rectangle.height = rectangle.height-20;
        this.rectangle.width = rectangle.width-20;
        this.rectangle.x = rectangle.x;
        this.rectangle.y = rectangle.y;
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
