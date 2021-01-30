
package flappybird;

import java.awt.*;
import java.util.Random;
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
    public JFrame frame = new JFrame();
    public JPanel panel;
    private JLabel pajaro = new JLabel();  
    private JLabel arbol1 = new JLabel();   
    private JLabel arbol2 = new JLabel();
    private JLabel nube1 = new JLabel();   
    private JLabel nube2 = new JLabel();
    private JLabel fondo = new JLabel();
    private JLabel fondo1 = new JLabel();
    private JLayeredPane layeredPane = new JLayeredPane();
    
    private final int HEIGHT=724;//((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight())/2;
    private final int WIDTH=518;//((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth())/2;
    
    public Screen() {
        layeredPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //layeredPane.setBorder(BorderFactory.createTitledBorder("THIS IS THE TITLE"));
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
        getContentPane().add(layeredPane);
    }
    
    
    private void colocarLabels(){
            ImageIcon bg = new ImageIcon("background.jpg");
            fondo = new JLabel();
            fondo.setIcon(bg);
            fondo.setSize(WIDTH, HEIGHT);
            fondo.setLayout(new GridLayout());
            layeredPane.add(fondo,new Integer(1));
    }
    
    
    private void colocarBotones(){
        
    }
    
    public void colocarPersonajes(Bird bird, Obstaculo tree1, Obstaculo tree2, Obstaculo cloud1, Obstaculo cloud2){                                    
        pajaro = new JLabel(new ImageIcon(bird.getBird().getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH))) ;
        pajaro.setBounds(0, 0, 85, 85);
        layeredPane.add(pajaro, new Integer(4));
        bird.setX(50);
        bird.setY(50);
        bird.setRectangle(pajaro.getBounds());
       
        
        arbol1 = new JLabel(new ImageIcon(tree1.getObstaculo().getImage().getScaledInstance(250, 420, Image.SCALE_SMOOTH))) ;       
        arbol1.setBounds(0, 0, 250, 420);   
        layeredPane.add(arbol1, new Integer(3));
        tree1.setX(WIDTH);
        tree1.setY(270);
        tree1.setRectangle(arbol1.getBounds());          
               
        arbol2 = new JLabel(new ImageIcon(tree2.getObstaculo().getImage().getScaledInstance(250, 420, Image.SCALE_SMOOTH)))   ;    
        arbol2.setBounds(0, 0, 250, 420);   
        layeredPane.add(arbol2, new Integer(3));
        tree2.setX(WIDTH*2);
        tree2.setY(560);
        tree2.setRectangle(arbol2.getBounds());
        
        nube1 = new JLabel(new ImageIcon(cloud1.getObstaculo().getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH))) ;       
        nube1.setBounds(0, 0, 90, 90);  
        layeredPane.add(nube1, new Integer(3));
        cloud1.setX(tree1.getX()+65);
        cloud1.setY(-100);
        cloud1.setRectangle(nube1.getBounds());      
                              
        nube2 = new JLabel(new ImageIcon(cloud2.getObstaculo().getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH)))   ;    
        nube2.setBounds(0, 0, 120, 90); 
        layeredPane.add(nube2, new Integer(3));
        cloud2.setX(tree2.getX()+65);
        cloud2.setY(-200);
        cloud2.setRectangle(nube2.getBounds());
        
    }
    
    public void volar(Bird bird){           
           bird.setY(bird.getY()-50);
           bird.setX(bird.getX());
           pajaro.setLocation(bird.getX(), bird.getY());   
           bird.setRectangle(pajaro.getBounds());
    }
    
    public void caer(Bird bird){
        bird.setY(bird.getY()+10);
        bird.setX(bird.getX());
        pajaro.setLocation(bird.getX(), bird.getY());       
        bird.setRectangle(pajaro.getBounds());
    }
    
    public void moverArboles(Obstaculo tree1, Obstaculo tree2){
        Random rand = new Random();
        int randomTree = rand.nextInt(220);
        randomTree += 270;
        
        if(tree1.getX()<=-arbol1.getWidth()){
            tree1.setX(WIDTH+arbol1.getWidth());
            tree1.setY(randomTree);
            arbol1.setLocation(tree1.getX(), tree1.getY());
        }
        
       if(tree2.getX()<=-arbol2.getWidth()){
            tree2.setX(WIDTH+arbol1.getWidth());
            tree2.setY(randomTree);
            arbol2.setLocation(tree2.getX(), tree2.getY());
        }
        
        tree1.setX(tree1.getX()-20);
        arbol1.setLocation(tree1.getX(), tree1.getY());
        
        tree2.setX(tree2.getX()-20);
        arbol2.setLocation(tree2.getX(), tree2.getY());                       
    }
    
    public void moverNubes(Obstaculo cloud1, Obstaculo cloud2){
        if(cloud1.getX()<=-arbol1.getWidth()){
            cloud1.setX(WIDTH+arbol1.getWidth());
            cloud1.setY(arbol1.getY()-200);
            nube2.setLocation(cloud1.getX(), cloud1.getY());
        }
        
        if(cloud2.getX()<=-arbol2.getWidth()){
            cloud2.setX(WIDTH+arbol2.getWidth());
            cloud2.setY(arbol2.getY()-200);
            nube1.setLocation(cloud2.getX(), cloud2.getY());
        }
        
        cloud1.setX(cloud1.getX()-20);
        nube1.setLocation(cloud1.getX(), cloud1.getY());
        
        cloud2.setX(cloud2.getX()-20);
        nube2.setLocation(cloud2.getX(), cloud2.getY());                       
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
