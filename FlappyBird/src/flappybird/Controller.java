package flappybird;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author diegoignacionunezhernandez
 */
public class Controller {
    private Bird bird;
    private Obstaculo tree1;
    private Obstaculo tree2;
    private Obstaculo nube1;
    private Obstaculo nube2;
    private Screen screen;

    public Controller(Bird bird, Obstaculo tree1, Obstaculo tree2, Obstaculo nube1, Obstaculo nube2, Screen screen,boolean mostrar) {
        this.bird = bird;
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.nube1 = nube1;
        this.nube2 = nube2;
        this.screen = screen;
        screen.colocarComponentes();
        screen.colocarPersonajes(bird, tree1, tree2,nube1, nube2);
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
        //screen.colocarComponentes();
        //screen.colocarPersonajes(bird, tree1, tree2);
        //screen.setVisible(true);
        while(this.bird.getY()!=screen.getWidth()){
            screen.setVisible(true);
            //caer(bird); 
            //screen.moverArboles(tree1, tree2);
            screen.moverNubes(nube1, nube2);
            System.out.println("INICIO");
            //while(!bird.isMuerto()){
            while(true){
                //System.out.println("MOVER");
                screen.caer(bird);           
                //screen.moverse(tree1, tree2);
               screen.moverArboles(tree1, tree2);
            screen.moverNubes(nube1, nube2);
                Thread.sleep(50);
                if(colision()){
                   // System.out.println("Choco");
                    //bird.Matar(); 
                    //Thread.sleep(1000);
                               
                }else{
                   // System.out.println("No choco");
                            
                }   
            }
            //System.out.println("Murió");
            //System.exit(0);
        }
    }
    
    public boolean colision(){
        return bird.getRectangle().intersects(tree1.getRectangle());
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