package flappybird;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Controller {
    private Bird bird;
    private Obstaculo tree1;
    private Obstaculo tree2;
    private Obstaculo nube1;
    private Obstaculo nube2;
    private Screen screen;
    private int puntaje = 0;
    boolean contado = true;

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
    
    public void mostrar(){
        //screen.setVisible(true);
        screen.setVisible(true);
        
    }
    
    
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
    
    public void jugar() throws InterruptedException{
        screen.colocarComponentes();
        screen.colocarPersonajes(bird, tree1, tree2, nube1, nube2, puntaje);
        screen.setVisible(true);
        //while(this.bird.getY()!=screen.getWidth()){
            
            // valor prueba 
            while(!bird.isMuerto()){
                screen.caer(bird);           
                screen.moverArboles(tree1, tree2);
                screen.moverNubes(nube1, nube2);
                Thread.sleep(80);
                if(colision()){
                  System.out.println("Choco");
                    bird.Matar(); 
                    //Thread.sleep(1000);
                               
                }else{
                   System.out.println("No choco");
                    // si todavia no se cuenta el arbol 1, suma un punto por haberlo pasado
                    if(tree1.getX() +40<= bird.getX() & contado){
                       puntaje++;
                       screen.sumarPunto(puntaje);
                       contado = false;
                    }
                    
                    // si todavia no se cuenta el arbol 2, suma un punto por haberlo pasado
                    if(tree2.getX()+40<= bird.getX() & !contado){
                       puntaje++;
                       screen.sumarPunto(puntaje);
                       contado = true;
                    }
                            
                }   
            }
        //}
        puntaje(puntaje);
    }
    
    public boolean colision(){
       
       // si choca con alguno regresa verdadero
       if(collisionA() || collisionB()){
           //JOptionPane.showMessageDialog(screen, "Choco");
           return true;
       }
       //JOptionPane.showMessageDialog(screen, "No choco");
       return false;
    }
    
    public boolean collisionA(){
        if(bird.getRectangle().intersects(tree1.getRectangle()) || bird.getRectangle().intersects(tree2.getRectangle()))
            return true;
        return false;
    }
    
    public boolean collisionB(){
        if(bird.getRectangle().intersects(nube1.getRectangle()) || bird.getRectangle().intersects(nube2.getRectangle()))
            return true;
        return false;
    }
    
    
    public void puntaje(int nuevoPuntaje){
       Scores scores = new Scores();
       ScoresFile scoresFile = new ScoresFile();
       scoresFile.cargarPuntaje(scores);
       Score score = new Score(nuevoPuntaje);
       scores.anadirPuntaje(score);
       System.out.println(scores.toString());
       scoresFile.guardarPuntos(scores);
    }
    
    
    
    
    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Obstaculo getTree1() {
        return tree1;
    }

    public void setTree1(Obstaculo tree1) {
        this.tree1 = tree1;
    }

    public Obstaculo getTree2() {
        return tree2;
    }

    public void setTree2(Obstaculo tree2) {
        this.tree2 = tree2;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }            
}