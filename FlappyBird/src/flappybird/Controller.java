package flappybird;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 * Clase Controller, encargada de controlar el estado del juego, a través de ella se iniciará el juego y se verificarán las colisiones en todo momento.
 * @author Proyecto POO
 */
public class Controller {
    private Bird bird;
    private Obstaculo tree1;
    private Obstaculo tree2;
    private Obstaculo nube1;
    private Obstaculo nube2;
    private Screen screen;
    private int puntaje = 0;
    private Sonidos sonido = new Sonidos();
    boolean contado = true;

    /**
     * Constructor de la clase.
     * @param bird  Objeto tipo bird (Quetzal).
     * @param tree1 Objeto tipo Obstaculo que representará el árbol 1.
     * @param tree2 Objeto tipo Obstaculo que representará el árbol 2.
     * @param nube1 Objeto tipo Obstaculo que representará la nube 1.
     * @param nube2 Objeto tipo Obstaculo que representará la nube 2.
     * @param screen Objeto tipo Screen para mostrarla en pantalla.
     * @param mostrar Booleano para decidir si se muestra la pantalla.
     */
    public Controller(Bird bird, Obstaculo tree1, Obstaculo tree2, Obstaculo nube1, Obstaculo nube2, Screen screen, boolean mostrar) {
        this.bird = bird;
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.nube1 = nube1;
        this.nube2 = nube2;
        this.screen = screen;
        //screen.colocarComponentes();
        //screen.colocarPersonajes(bird, tree1, tree2,nube1, nube2);
        screen.setVisible(mostrar);
        initController();
    }
    
    /**
     * @deprecated
     * Método para mostrar la pantalla de juego
     */
    public void mostrar(){
        //screen.setVisible(true);
        screen.setVisible(true);
        
    }
    
    /**
     * Método para verificar la entrada por ratón.
     */
    public void initController(){
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { 
                screen.volar(bird);  
                //jugar();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }                                
        };
        
        screen.addMouseListener(ml);
                
    }
   
    /**
     * Mediante este método se inicia el juego: se colocan los componentes y personajes, se valida, mientras el quetzal esté vivo, si ocurrió una colisión o si se aumenta el puntaje.
     * @throws InterruptedException En caso de no poder dormir al hilo se lanzará esta excepción.
     */
    public void jugar() throws InterruptedException{
        screen.colocarComponentes();
        screen.colocarPersonajes(bird, tree1, tree2, nube1, nube2, puntaje);
        //screen.setVisible(true);
        screen.revalidate();
        //while(this.bird.getY()!=screen.getWidth()){
            sonido.reproducirVuelo();
            // valor prueba 
            while(!bird.isMuerto()){
                screen.caer(bird);           
                screen.moverArboles(tree1, tree2);
                screen.moverNubes(nube1, nube2);
                Thread.sleep(80);
                if(colision()){
                  System.out.println("Choco");
                    sonido.stop();
                    bird.Matar();
                    sonido.reproducirSonido("muerte.wav");
                    //Thread.sleep(1000);
                               
                }else{
                   System.out.println("No choco");
                    // si todavia no se cuenta el arbol 1, suma un punto por haberlo pasado
                    if(tree1.getX() +40<= bird.getX() & contado){
                       puntaje++;
                       screen.sumarPunto(puntaje);
                       contado = false;
                       sonido.reproducirSonido("puntito.wav");
                    }
                    
                    // si todavia no se cuenta el arbol 2, suma un punto por haberlo pasado
                    if(tree2.getX()+40<= bird.getX() & !contado){
                       puntaje++;
                       screen.sumarPunto(puntaje);
                       contado = true;
                       sonido.reproducirSonido("puntito.wav");
                    }
                            
                }   
            }
        //}
        puntaje(puntaje);
    }
        
    /**
     * Método para revisar las colisiones
     * @return Si ocurrió una colisión regresará true; caso contrario, false.
     */
    public boolean colision(){
       
       // si choca con alguno regresa verdadero
       if(collisionA() || collisionB()){
           //JOptionPane.showMessageDialog(screen, "Choco");
           return true;
       }
       //JOptionPane.showMessageDialog(screen, "No choco");
       return false;
    }
    
    /**
     * Método para revisar las colisiones entre el quetzal y los árboles
     * @return True si ocurrió una colisión, false si no ocurrió ninguna colisión.
     */
    public boolean collisionA(){
        if(bird.getRectangle().intersects(tree1.getRectangle()) || bird.getRectangle().intersects(tree2.getRectangle()))
            return true;
        return false;
    }
    
    /**
     * Método para revisar las colisiones entre el quetzal y las nubes
     * @return True si ocurrió una colisión, false si no ocurrió ninguna colisión.
     */
    public boolean collisionB(){
        if(bird.getRectangle().intersects(nube1.getRectangle()) || bird.getRectangle().intersects(nube2.getRectangle()))
            return true;
        return false;
    }
    
    /**
     * Mediante este método se verificará y escribirá el puntaje.
     * @param nuevoPuntaje Puntaje obtenido durante la partida.
     */
    public void puntaje(int nuevoPuntaje){
       Scores scores = new Scores();
       ScoresFile scoresFile = new ScoresFile();
       scoresFile.cargarPuntaje(scores);
       Score score = new Score(nuevoPuntaje);
       scores.anadirPuntaje(score);
       System.out.println(scores.toString());
       scoresFile.guardarPuntos(scores);
    }
    
    /**
     * Getter del quetzal.
     * @return Objeto tipo Bird (Quetzal).
     */
    public Bird getBird() {
        return bird;
    }

    /**
     * Setter del quetzal.
     * @param bird Objeto tipo Bird (Quetzal) para asignarse.
     */
    public void setBird(Bird bird) {
        this.bird = bird;
    }

    /**
     * Getter del árbol 1.
     * @return Objeto tipo Obstaculo (tree1).
     */
    public Obstaculo getTree1() {
        return tree1;
    }

    /**
     * Setter del árbol 1.
     * @param tree1 Objeto tipo Obstaculo.
     */
    public void setTree1(Obstaculo tree1) {
        this.tree1 = tree1;
    }

    /**
     * Getter del árbol 2.
     * @return Objeto tipo Obstaculo (tree2).
     */
    public Obstaculo getTree2() {
        return tree2;
    }

    /**
     * Setter del árbol 2.
     * @param tree2 Objeto tipo Obstaculo.
     */
    public void setTree2(Obstaculo tree2) {
        this.tree2 = tree2;
    }

    /**
     * Getter de la pantalla (objeto tipo Screen).
     * @return Pantalla (screen).
     */
    public Screen getScreen() {
        return screen;
    }

    /**
     * Setter de la pantalla.
     * @param screen Pantalla a asignarse a screen.
     */
    public void setScreen(Screen screen) {
        this.screen = screen;
    }            
}