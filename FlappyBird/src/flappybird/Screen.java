
package flappybird;

import java.awt.*;
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
    
    private final int HEIGHT;
    private final int WIDTH;
    private Dimension screenSize;
    
    public Screen() {        
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        HEIGHT = screenSize.height*2/3;
        WIDTH = screenSize.width/3;
        setSize(WIDTH-WIDTH/7, HEIGHT);
        System.out.println("Height = "+HEIGHT+ " widht = "+WIDTH);
        setTitle("Flappy Quetzal");
        setLocationRelativeTo(null);
        setResizable(false);                  
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        setBackground(Color.RED);
    }
    
    public void colocarComponentes(){
        colocarPaneles();
        colocarLabels();
        colocarBotones();
    }
    
    private void colocarPaneles(){
        Color color = new Color(0,70,0,0);
        //setBackground(color);
        panel = new JPanel(); //Creacion de un panel    
        //panel.setLayout(null);
        //panel.setBackground(color);
       
        getContentPane().add(panel); //Agregamos el panel a la ventana         
    }
    

    private void colocarLabels(){
        ImageIcon background = new ImageIcon("background.jpg");
        JLabel fondo = new JLabel();
        fondo.setSize(WIDTH, HEIGHT);       
        fondo.setIcon(background);       
        //panel.add(fondo);
               
    }
    
    private void colocarBotones(){
        
    }
    
    public void colocarPersonajes(Bird bird, Arbol tree1, Arbol tree2){                                    
        pajaro.setBounds(50, 50, 100, 100);                
        pajaro.setIcon(new ImageIcon(bird.getBird().getImage().getScaledInstance(WIDTH/7, WIDTH/7, Image.SCALE_SMOOTH)));        
        panel.add(pajaro);  
        bird.setX(50);
        bird.setY(50);
        bird.setRectangle(pajaro.getBounds());
         
        arbol1.setBounds(50, WIDTH/2, WIDTH/2, WIDTH/2);                
        arbol1.setIcon(new ImageIcon(tree1.getTree().getImage().getScaledInstance(WIDTH/2, WIDTH/2, Image.SCALE_SMOOTH)));        
        panel.add(arbol1);  
        tree1.setX(50);
        tree1.setY(arbol1.getWidth());
        tree1.setRectangle(arbol1.getBounds());      
                     
        arbol2.setBounds(50, WIDTH/2, WIDTH/2, WIDTH/2);            
        arbol2.setIcon(new ImageIcon(tree2.getTree().getImage().getScaledInstance(WIDTH/2, WIDTH/2, Image.SCALE_SMOOTH)));        
        //panel.add(arbol2);  
        tree2.setX(50);
        tree2.setY(arbol1.getWidth());
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
        if(tree1.getX()==-arbol1.getWidth()){
            tree1.setX(WIDTH);
            arbol1.setLocation(tree1.getX(), tree1.getY());
        }
        
        
        if(tree1.getX()== WIDTH/2){
            panel.add(arbol2);
            tree2.setX(WIDTH);
            arbol1.setLocation(tree2.getX(), tree2.getY());
            System.out.println("holaaaaaaaaaaaaa");
        }
        
        if(tree2.getX()==-arbol1.getWidth()){
            tree2.setX(WIDTH);
            arbol2.setLocation(tree2.getX(), tree2.getY());
        }
        
        tree1.setX(tree1.getX()-10);
        arbol1.setLocation(tree1.getX(), tree1.getY());
        
        tree2.setX(tree2.getX()-10);
        arbol2.setLocation(tree2.getX(), tree2.getY());                        
    }        
}

