package flappybird;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Holi");
        Bird bird = new Bird();
        Arbol arbol1 = new Arbol();
        Arbol arbol2 = new Arbol();
        Screen screen = new Screen();
        Controller controller = new Controller(bird, arbol1, arbol2, screen);   
        controller.jugar();
    }
    
}
