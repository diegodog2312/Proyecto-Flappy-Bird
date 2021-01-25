
package flappybird;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 *
 * @author diegoignacionunezhernandez
 */
public class Screen extends JFrame{   
    public JPanel panel;
    private JLabel pajaro = new JLabel();  
    private JLabel arbol1 = new JLabel();   
    private JLabel arbol2 = new JLabel();  
    
    private final int HEIGHT=768;
    private final int WIDTH=768;
    
    public Screen() {        
        setSize(WIDTH, HEIGHT);
        setTitle("Flappy Quetzal");
        setLocationRelativeTo(null);
        setResizable(false);                  
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        
    }
    
    public void colocarComponentes(){
        colocarPaneles();
        colocarLabels();
        colocarBotones();
    }
    
    private void colocarPaneles(){
        panel = new JPanel(); //Creacion de un panel    
        panel.setLayout(null);
        getContentPane().add(panel); //Agregamos el panel a la ventana         
    }
    
    private void colocarLabels(){
        ImageIcon background = new ImageIcon("background.jpg");
        JLabel fondo = new JLabel();
        fondo.setSize(WIDTH, HEIGHT);       
        //fondo.setIcon(background);       
        panel.add(fondo);
               
    }
    
    private void colocarBotones(){
        
    }
    
    public void colocarPersonajes(Bird bird, Arbol tree1, Arbol tree2){                                    
        pajaro.setBounds(50, 50, 100, 100);                
        pajaro.setIcon(new ImageIcon(bird.getBird().getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));        
        panel.add(pajaro);  
        bird.setX(50);
        bird.setY(50);
        bird.setRectangle(pajaro.getBounds());
         
        arbol1.setBounds(50, 200, 50, 50);                
        arbol1.setIcon(new ImageIcon(tree1.getTree().getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));        
        panel.add(arbol1);  
        tree1.setX(50);
        tree1.setY(200);
        tree1.setRectangle(arbol1.getBounds());        
                     
        arbol2.setBounds(100, 200, 50, 50);                
        arbol2.setIcon(new ImageIcon(tree2.getTree().getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));        
        panel.add(arbol2);  
        tree2.setX(100);
        tree2.setY(200);
        tree2.setRectangle(arbol1.getBounds()); 
    }
    
    public void volar(Bird bird){           
           bird.setY(bird.getY()-10);
           pajaro.setLocation(bird.getX(), bird.getY());   
           bird.setRectangle(pajaro.getBounds());
    }
    
    public void caer(Bird bird){
        bird.setY(bird.getY()+1);
        pajaro.setLocation(bird.getX(), bird.getY());       
        bird.setRectangle(pajaro.getBounds());
    }
    
    public void moverse(Arbol tree1, Arbol tree2){
        if(tree1.getX()==0){
            tree1.setX(600);
            arbol1.setLocation(tree1.getX(), tree1.getY());
        }
        
        if(tree2.getX()==0){
            tree2.setX(700);
            arbol2.setLocation(tree2.getX(), tree2.getY());
        }
        
        tree1.setX(tree1.getX()-10);
        arbol1.setLocation(tree1.getX(), tree1.getY());
        
        tree2.setX(tree2.getX()-10);
        arbol2.setLocation(tree2.getX(), tree2.getY());                        
    }        
}
