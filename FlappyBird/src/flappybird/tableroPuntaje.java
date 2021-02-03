import java.awt.*;
import javax.swing.*;


public class tableroPuntaje extends javax.swing.JPanel {
 
public tableroPuntaje() {
this.setSize(400, 400); 
}
 
private void drawString(Graphics g,String text, int x, int y) { 
	for (String line : text.split("\n")) 
		g.drawString(line, x, y+= g.getFontMetrics().getHeight()); 

} 

 
public void paint(Graphics grafico) {
Dimension height = getSize();
 

 
ImageIcon Img = new ImageIcon(getClass().getResource("fondo.png")); 
 

 
grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);





/*Scores scores = new Scores();
ScoresFile scoresFile = new ScoresFile();
int value=100;
int value2=34;
int value3=88;
int value4=56;
int value5=90;
Score score = new Score(value);
scores.anadirPuntaje(score);
Score score2 = new Score(value2);
scores.anadirPuntaje(score2);
Score score3 = new Score(value3);
scores.anadirPuntaje(score3);
Score score4 = new Score(value4);
scores.anadirPuntaje(score4);
Score score5 = new Score(value5);
scores.anadirPuntaje(score5);
scoresFile.guardarPuntos(scores);
scoresFile.cargarPuntaje(scores);
grafico.setFont(new Font("Ravie", Font.PLAIN, 30));
//grafico.drawString("!!!HIGSORE!!!",110,50);
drawString(grafico,scores.toString(),180,80);*/
setOpaque(false);
super.paintComponent(grafico);
}
}