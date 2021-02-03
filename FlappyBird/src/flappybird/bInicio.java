package flappybird;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *@deprecated 
 * @author CHRISTIAN
 * @version 1.0
 */
public class bInicio extends JPanel{
         private Controller controller;
         private CardLayout carta;
         private JPanel panel;
    /**
     * Creates new form bInicio
     */
    public bInicio() {
        initComponents();
    }
    
    /**
     *
     * @param carta
     * @param panel
     */
    public void setCardL(CardLayout carta, JPanel panel){
        this.carta = carta;
        this.panel = panel;
    }
    
    /**
     *
     * @param controller
     */
    public void setController(Controller controller){
        this.controller = controller;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        botonNuevoJuego = new javax.swing.JToggleButton();

        setToolTipText("Flappy Quetzal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(680, 460));
        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(null);

        botonNuevoJuego.setBackground(new java.awt.Color(102, 102, 255));
        botonNuevoJuego.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        botonNuevoJuego.setForeground(javax.swing.UIManager.getDefaults().getColor("textHighlight"));
        botonNuevoJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flappybird/nuevojuego.png"))); // NOI18N
        botonNuevoJuego.setAlignmentY(0.0F);
        botonNuevoJuego.setBorder(null);
        botonNuevoJuego.setBorderPainted(false);
        botonNuevoJuego.setContentAreaFilled(false);
        botonNuevoJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonNuevoJuego.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        botonNuevoJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNuevoJuegoMouseClicked(evt);
            }
        });
        botonNuevoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botonNuevoJuegoActionPerformed(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        add(botonNuevoJuego);
        botonNuevoJuego.setBounds(140, 420, 221, 69);
        botonNuevoJuego.getAccessibleContext().setAccessibleName("nuevoJuego");
        botonNuevoJuego.getAccessibleContext().setAccessibleParent(botonNuevoJuego);

        getAccessibleContext().setAccessibleName("nuevojuego");
    }// </editor-fold>                        

    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        
    }                                 

    private void botonNuevoJuegoMouseClicked(java.awt.event.MouseEvent evt) {                                             
        
    }                                            

    private void botonNuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {                                                
        
        //controller.mostrar();
        System.out.println("wee");
        carta.next(panel);
        Thread.sleep(20);
        try{
            
            controller.jugar();
        }
        catch(Exception e){
            System.out.println("Hubo un pedo");
        }
        //this.revalidate();
    }                                               


    // Variables declaration - do not modify                     
    private javax.swing.JToggleButton botonNuevoJuego;
    // End of variables declaration                   
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("fondomenur.jpg");
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
    }
}