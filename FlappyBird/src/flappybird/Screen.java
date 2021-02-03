package flappybird;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

/**
 * Clase que maneja lo relacionado con la pantalla de juego: los personajes, obstáculos y sus interacciones.
 * @author Proyecto POO
 */
public class Screen extends JFrame{
    private JLabel pajaro;
    private JLabel arbol1;
    private JLabel arbol2;
    private JLabel nube1;
    private JLabel nube2;
    private JLabel fondo;
    private JLabel menu;
    private JLabel pasto;
    private JLabel techo;    
    private JLabel puntaje;
    private JLabel puntajeFinal;
    private JButton Bplay;
    private JButton Brestart;
    private JButton BleaderBoard;
    private JLayeredPane layeredPane = new JLayeredPane();
    
    private final int HEIGHT=724;
    private final int WIDTH=518;
    
    /**
     * Constructor de la clase, en él se definen las propiedades del marco y del panel por capas.
     */
    public Screen() {
        layeredPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));        
        setSize(WIDTH, HEIGHT);
        setTitle("Flappy Quetzal");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    
        getContentPane().add(layeredPane);    
        menuInicio();
    }
    
    public void menuInicio(){          
        ImageIcon imgP = new ImageIcon("BPlay.png");   
        Bplay = new JButton(new ImageIcon(imgP.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        Bplay.setBorder(BorderFactory.createEmptyBorder());
        Bplay.setContentAreaFilled(false);
        Bplay.setBounds(215, 350,70, 70);
        Bplay.setEnabled(true);
        Bplay.setVisible(true);
        layeredPane.add(Bplay, new Integer(100));
        
        ImageIcon bg = new ImageIcon("fondomenur.jpg");
        menu = new JLabel();
        menu.setIcon(bg);
        menu.setSize(WIDTH, HEIGHT);            
        layeredPane.add(menu,new Integer(99));
    }   

    
    /**
     *Método para colocar los personajes en nuestro panel por capas. En este método se definirán sus tamaños y posiciones.
     * @param bird Objeto tipo bird que representará el quetzal.
     * @param tree1 Objeto tipo Obstaculo que representará el árbol 1.
     * @param tree2 Objeto tipo Obstaculo que representará el árbol 2.
     * @param cloud1 Objeto tipo Obstaculo que representará la nube 1.
     * @param cloud2 Objeto tipo Obstaculo que representará la nube 2.
     * @param score Entero que mostrará en pantalla el puntaje del jugador.
     */
    public void juego(Bird bird, Obstaculo tree1, Obstaculo tree2, Obstaculo cloud1, Obstaculo cloud2, Obstaculo grass,Obstaculo roof,int score){                   
        ImageIcon bg = new ImageIcon("back10.jpg");
        fondo = new JLabel();
        fondo.setIcon(bg);
        fondo.setSize(WIDTH, HEIGHT);            
        layeredPane.add(fondo,new Integer(1));
        
        pajaro = new JLabel(new ImageIcon(bird.getBird().getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH))) ;
        pajaro.setBounds(0, 0, 85, 85);
        layeredPane.add(pajaro, new Integer(4));
        bird.setX(50);
        bird.setY(50);
        bird.setRectangle(pajaro.getBounds());
        
        pasto = new JLabel(new ImageIcon(grass.getObstaculo().getImage().getScaledInstance(WIDTH, 50, Image.SCALE_SMOOTH)));
        pasto.setBounds(0,645, WIDTH,40);
        layeredPane.add(pasto,new Integer(2));
        grass.setRectangle(pasto.getBounds());
        
        techo = new JLabel(new ImageIcon(roof.getObstaculo().getImage().getScaledInstance(WIDTH, 50, Image.SCALE_SMOOTH)));
        techo.setBounds(0,0, WIDTH,40);
        layeredPane.add(techo,new Integer(2));
        roof.setRectangle(techo.getBounds());
        
        arbol1 = new JLabel(new ImageIcon(tree1.getObstaculo().getImage().getScaledInstance(250, 420, Image.SCALE_SMOOTH)));       
        arbol1.setBounds(WIDTH, 270, 250, 420); 
        layeredPane.add(arbol1, new Integer(3));
        tree1.setX(WIDTH);
        tree1.setY(270);
        tree1.setRectangle(arbol1.getBounds());          
               
        arbol2 = new JLabel(new ImageIcon(tree2.getObstaculo().getImage().getScaledInstance(250, 420, Image.SCALE_SMOOTH)));    
        arbol2.setBounds(0, 0, 250, 420);   
        layeredPane.add(arbol2, new Integer(3));
        tree2.setX(WIDTH*2);
        tree2.setY(560);
        tree2.setRectangle(arbol2.getBounds());
        
        
        nube1 = new JLabel(new ImageIcon(cloud1.getObstaculo().getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH)));       
        nube1.setBounds(0, 0, 120, 90);  
        layeredPane.add(nube1, new Integer(3));
        cloud1.setX(tree1.getX()+65);
        cloud1.setY(-100);
        cloud1.setRectangle(nube1.getBounds());     
                              
        nube2 = new JLabel(new ImageIcon(cloud2.getObstaculo().getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH)));    
        nube2.setBounds(0, 0, 120, 90); 
        layeredPane.add(nube2, new Integer(3));
        cloud2.setX(tree2.getX()+65);
        cloud2.setY(-200);
        cloud2.setRectangle(nube2.getBounds());
        
        puntaje = new JLabel(String.valueOf(score));
        Color color = new Color(229,255,205);
        puntaje.setBounds(WIDTH/2,65,30,30);
        puntaje.setFont(new Font("Serif", Font.BOLD, 25));
        puntaje.setForeground(color);
        layeredPane.add(puntaje, new Integer(6));
                
        /*
        pajaro.setBorder(BorderFactory.createLineBorder(Color.RED));
        arbol1.setBorder(BorderFactory.createLineBorder(Color.RED));
        arbol2.setBorder(BorderFactory.createLineBorder(Color.RED));
        nube1.setBorder(BorderFactory.createLineBorder(Color.RED));
        nube2.setBorder(BorderFactory.createLineBorder(Color.RED));
        pasto.setBorder(BorderFactory.createLineBorder(Color.RED));
        techo.setBorder(BorderFactory.createLineBorder(Color.RED));
        */
    }
    
    /**
     * Método para mostrar puntaje en pantalla.
     * @param score Valor a mostrar en pantalla
     */
    public void sumarPunto(int score){
        puntaje.setText(String.valueOf(score));
    }
    
    public void mostrarPuntaje(int score){
        ImageIcon imgS = new ImageIcon("WResult.png");
        
        puntajeFinal = new JLabel(new ImageIcon(imgS.getImage().getScaledInstance(220, 270, Image.SCALE_SMOOTH)));
        puntajeFinal.setBounds(137, 100, 220, 270);
        layeredPane.add(puntajeFinal, new Integer(5));
        
        puntaje.setBounds(240,186,30,30);
        Color color = new Color(92,60,6);
        puntaje.setForeground(color);
               
        ImageIcon imgR = new ImageIcon("BRestart.png");
        ImageIcon imgL = new ImageIcon("BLeaderboard.png");                
        
        Brestart = new JButton(new ImageIcon(imgR.getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH)));
        Brestart.setBorder(BorderFactory.createEmptyBorder());
        Brestart.setContentAreaFilled(false);
        Brestart.setBounds(100, 400,120, 70);        
        Brestart.setVisible(true);
        
        BleaderBoard = new JButton(new ImageIcon(imgL.getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH)));
        BleaderBoard.setBorder(BorderFactory.createEmptyBorder());
        BleaderBoard.setContentAreaFilled(false);
        BleaderBoard.setBounds(270, 400,120, 70);        
        BleaderBoard.setVisible(true);
                
        layeredPane.add(Brestart, new Integer(5));
        layeredPane.add(BleaderBoard, new Integer(5));          
    }
    /**
     * Método encargado del vuelo del quetzal, se define su imagen así como cuánto se eleva en la coordenada Y.
     * @param bird Objeto tipo Bird (que representa el quetzal).
     */
    public void volar(Bird bird){
        ImageIcon imagen = new ImageIcon("quetzal2.png");                         
        bird.setBird(imagen);
        imagen = new ImageIcon(bird.getBird().getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));
        pajaro.setIcon(imagen);
        
        bird.setY(bird.getY()-60);
        bird.setX(bird.getX());
        pajaro.setLocation(bird.getX(), bird.getY());   
        bird.setRectangle(pajaro.getBounds());
    }
    
    /**
     * Método encargado de la caída del quetzal, se define su imagen así como cuánto disminuye en la coordenada Y.
     * @param bird Objeto tipo Bird (que representa el quetzal).
     */
    public void caer(Bird bird){
        ImageIcon imagen = new ImageIcon("quetzal.png");         
        bird.setBird(imagen);        
        imagen = new ImageIcon(bird.getBird().getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));        
        pajaro.setIcon(imagen);
        
        
        bird.setY(bird.getY()+10);
        bird.setX(bird.getX());
        pajaro.setLocation(bird.getX(), bird.getY());       
        bird.setRectangle(pajaro.getBounds());
    }          
    
    /**
     * Método encargado de mover los árboles por la pantalla decrementando su valor en X.
     * @param tree1 Objeto tipo Obstaculo que representa el árbol 1.
     * @param tree2 Objeto tipo Obstaculo que representa el árbol 2.
     */
    public void moverArboles(Obstaculo tree1, Obstaculo tree2){
        Random rand = new Random();
        int randomTree = rand.nextInt(220);
        randomTree += 270;
        
        if(tree1.getX()<=-arbol1.getWidth()){
            tree1.setX(WIDTH+arbol1.getWidth());
            tree1.setY(randomTree);
            arbol1.setLocation(tree1.getX(), tree1.getY());
            tree1.setRectangle(arbol1.getBounds());
        }
        
       if(tree2.getX()<=-arbol2.getWidth()){
            tree2.setX(WIDTH+arbol1.getWidth());
            tree2.setY(randomTree);
            arbol2.setLocation(tree2.getX(), tree2.getY());
            tree2.setRectangle(arbol2.getBounds());
        }
        
        tree1.setX(tree1.getX()-20);
        arbol1.setLocation(tree1.getX(), tree1.getY());
        tree1.setRectangle(arbol1.getBounds());
        
        tree2.setX(tree2.getX()-20);
        arbol2.setLocation(tree2.getX(), tree2.getY());
        tree2.setRectangle(arbol2.getBounds());
    }
    
    /**
     * Método encargado de mover las nubes por la pantalla decrementando su valor en X y calculando su altura en Y.
     * @param cloud1 Objeto tipo Obstaculo que representa la nube 1.
     * @param cloud2 Objeto tipo Obstaculo que representa la nube 2.
     */
    public void moverNubes(Obstaculo cloud1, Obstaculo cloud2){
        if(cloud1.getX()<=-arbol1.getWidth()){
            cloud1.setX(WIDTH+arbol1.getWidth());
            cloud1.setY(arbol1.getY()-300);
            nube1.setLocation(cloud1.getX(), cloud1.getY());
            cloud1.setRectangle(nube1.getBounds());
        }
        
        if(cloud2.getX()<=-arbol2.getWidth()){
            cloud2.setX(WIDTH+arbol2.getWidth());
            cloud2.setY(arbol2.getY()-300);
            nube2.setLocation(cloud2.getX(), cloud2.getY());
            cloud2.setRectangle(nube2.getBounds());
        }
        
        cloud1.setX(cloud1.getX()-20);
        nube1.setLocation(cloud1.getX(), cloud1.getY());
        cloud1.setRectangle(nube1.getBounds());
        
        cloud2.setX(cloud2.getX()-20);
        nube2.setLocation(cloud2.getX(), cloud2.getY());   
        cloud2.setRectangle(nube2.getBounds());
    }
            
          
    public JLabel getPajaro() {
        return pajaro;
    }

    public void setPajaro(JLabel pajaro) {
        this.pajaro = pajaro;
    }

    public JLabel getArbol1() {
        return arbol1;
    }

    public void setArbol1(JLabel arbol1) {
        this.arbol1 = arbol1;
    }

    public JLabel getArbol2() {
        return arbol2;
    }

    public void setArbol2(JLabel arbol2) {
        this.arbol2 = arbol2;
    }

    public JLabel getNube1() {
        return nube1;
    }

    public void setNube1(JLabel nube1) {
        this.nube1 = nube1;
    }

    public JLabel getNube2() {
        return nube2;
    }

    public void setNube2(JLabel nube2) {
        this.nube2 = nube2;
    }

    public JLabel getFondo() {
        return fondo;
    }

    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    public JLabel getPasto() {
        return pasto;
    }

    public void setPasto(JLabel pasto) {
        this.pasto = pasto;
    }

    public JLabel getTecho() {
        return techo;
    }

    public void setTecho(JLabel techo) {
        this.techo = techo;
    }

    public JLabel getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(JLabel puntaje) {
        this.puntaje = puntaje;
    }

    public JLabel getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(JLabel puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }

    public JButton getBplay() {
        return Bplay;
    }

    public void setBplay(JButton Bplay) {
        this.Bplay = Bplay;
    }

    public JButton getBrestart() {
        return Brestart;
    }

    public void setBrestart(JButton Brestart) {
        this.Brestart = Brestart;
    }

    public JButton getBleaderBoard() {
        return BleaderBoard;
    }

    public void setBleaderBoard(JButton BleaderBoard) {
        this.BleaderBoard = BleaderBoard;
    }

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public void setLayeredPane(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
    }
    
    public JLabel getMenu() {
        return menu;
    }

    public void setMenu(JLabel menu) {
        this.menu = menu;
    }
    
     // coloca personajes en punto original 
    public void setOriginalPositions(Bird bird, Obstaculo tree1, Obstaculo tree2, Obstaculo cloud1, Obstaculo cloud2, int score){
        //pajaro.setBounds(0, 0, 85, 85);
        bird.setX(50);
        bird.setY(50);
        pajaro.setLocation(bird.getX(), bird.getY());
        bird.setRectangle(pajaro.getBounds());
        
        
        //arbol1.setBounds(WIDTH, 270, 250, 420); 
        tree1.setX(WIDTH);
        tree1.setY(270); 
        arbol1.setLocation(tree1.getX(), tree1.getY());
        tree1.setRectangle(arbol1.getBounds());
               
        //arbol2.setBounds(0, 0, 250, 420);   
        tree2.setX(WIDTH*2);
        tree2.setY(560);        
        arbol2.setLocation(tree2.getX(), tree2.getY());
        tree2.setRectangle(arbol2.getBounds());
        
        //nube1.setBounds(0, 0, 120, 90);  
        cloud1.setX(tree1.getX()+65);
        cloud1.setY(-100);
        nube1.setLocation(cloud1.getX(), cloud1.getY());   
        cloud1.setRectangle(nube1.getBounds());
        
            
        //nube2.setBounds(0, 0, 120, 90);
        cloud2.setX(tree2.getX()+65);
        cloud2.setY(-200);
        nube2.setLocation(cloud2.getX(), cloud2.getY());
        cloud2.setRectangle(nube2.getBounds());       
        
        
        //puntaje.setBounds(WIDTH/2,65,30,30);
        puntaje.setText(String.valueOf(score));
    } 
    
   
    // quita solo personajes y reinicia a puntaje
 /*   public void clearScreen(){
        layeredPane.remove(pajaro);
        layeredPane.remove(arbol1);
        layeredPane.remove(nube1);
        layeredPane.remove(nube2);
        layeredPane.remove(arbol2);
        layeredPane.remove(puntajeFinal);
        Color color = new Color(229,255,205);
        puntaje.setBounds(WIDTH/2,65,30,30);
        puntaje.setForeground(color);
        puntaje.setText("0");
        repaint();
    }*/
    
}