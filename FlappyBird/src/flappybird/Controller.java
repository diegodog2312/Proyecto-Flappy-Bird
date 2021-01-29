package flappybird;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author diegoignacionunezhernandez
 */
public class Controller {
    private Bird bird;
    private Arbol tree1;
    private Arbol tree2;
    private Screen screen;

    public Controller(Bird bird, Arbol tree1, Arbol tree2, Screen screen,boolean mostrar) {
        this.bird = bird;
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.screen = screen;
        screen.colocarComponentes();
        screen.colocarPersonajes(bird, tree1, tree2);
        screen.setVisible(mostrar);
        initController();
    }
    
    public void mostrar(){
        screen.setVisible(true);
    }
    
    
    public void initController(){
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { 
                screen.volar(bird);  
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
        while(bird.getY()!=screen.getWidth()){
            bird.Vivir();
            while(!bird.isMuerto()){
                screen.caer(bird);
                screen.moverse(tree1, tree2);
                Thread.sleep(50);
                if(colision()){
                    System.out.println("Choco");
                    bird.Matar();
                }else{
                    System.out.println("No choco");
                    bird.Vivir();
                }   
            }
            System.out.println("Murió");
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

    public Arbol getTree1() {
        return tree1;
    }

    public void setTree1(Arbol tree1) {
        this.tree1 = tree1;
    }

    public Arbol getTree2() {
        return tree2;
    }

    public void setTree2(Arbol tree2) {
        this.tree2 = tree2;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }            
}