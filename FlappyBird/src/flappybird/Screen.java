
package flappybird;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegoignacionunezhernandez
 */
public class Screen extends JFrame{
    public JPanel panel;
    private JLabel pajaro = new JLabel();  
    private JLabel arbol1 = new JLabel();   
    private JLabel arbol2 = new JLabel();
    private JLabel fondo = new JLabel();
    
    private final int HEIGHT=724;//((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight())/2;
    private final int WIDTH=518;//((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2;
    
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
            //ImageIcon background = new ImageIcon("background.jpg");
            fondo.setSize(WIDTH, HEIGHT);
            
            //ImageIcon bg = new ImageIcon("background.jpg");
            fondo = new JLabel(new ImageIcon("background.jpg"));
            fondo.setLayout(new GridLayout());
            add(fondo);
            //getContentPane().printComponents(bg);
    }
    
    
    private void colocarBotones(){
        
    }
    
    public void colocarPersonajes(Bird bird, Arbol tree1, Arbol tree2){                                    
        pajaro.setBounds(50, 50, 100, 100);
        pajaro.setIcon(new ImageIcon(bird.getBird().getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        fondo.add(pajaro);
        bird.setX(50);
        bird.setY(50);
        bird.setRectangle(pajaro.getBounds());
         
        arbol1.setBounds(50, 200, 50, 50);
        arbol1.setIcon(new ImageIcon(tree1.getTree().getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        fondo.add(arbol1);
        tree1.setX(50);
        tree1.setY(200);
        tree1.setRectangle(arbol1.getBounds());
                     
        arbol2.setBounds(100, 200, 50, 50);
        arbol2.setIcon(new ImageIcon(tree2.getTree().getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        fondo.add(arbol2);
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
//
//class ImagePanel extends JComponent {
//    private Image image;
//    public ImagePanel(Image image) {
//        this.image = image;
//    }
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(image, 0, 0, this);
//    }
//}
//
//
//class JPanelBackground extends JPanel {
// 
//	// Atributo que guardara la imagen de Background que le pasemos.
//	private Image background;
// 
//	// Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
//	public void paintComponent(Graphics g) {
// 
//		// Obtenemos el tamaño del panel para hacer que se ajuste a este
//		//cada vez que redimensionemos la ventana y se lo pasamos al drawImage 
//		int width = this.getSize().width;
//		int height = this.getSize().height;
// 
//		// Mandamos que pinte la imagen en el panel
//		if (this.background != null) {
//			g.drawImage(this.background, 0, 0, width, height, null);
//		}
// 
//		super.paintComponent(g);
//	}
// 
//	// Metodo donde le pasaremos la dirección de la imagen a cargar.
//	public void setBackground(String imagePath) {
//		
//		// Construimos la imagen y se la asignamos al atributo background.
//		this.setOpaque(false);
//		this.background = new ImageIcon(imagePath).getImage();
//		repaint();
//	}
// 
//}
