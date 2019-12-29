package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class Button extends JButton {

   private  String name = "";
   public Button(String label) {
	   super(label);
	   name=label;
	   this.setSize(120,30);
	   //These statements enlarge the button so that it 
	   //becomes a circle rather than an oval.
	   Dimension size = getPreferredSize();
	   size.width = size.height = Math.max(size.width, 
	   size.height);
	   setPreferredSize(size);
	   //This call causes the JButton not to paint 
	   //the background.
	   //This allows us to paint a round background.
	   setContentAreaFilled(false);
	   
	   }
 
	   //Paint the round background and label.
	   protected void paintComponent(Graphics g) {
		Color couleur=new Color(66,58,214,128);
		this.setBackground(getBackground());
		
	   g.setFont(new Font("lucida bright",Font.BOLD|Font.ITALIC,14 ));
	   if (getModel().isArmed()) {
	   //You might want to make the highlight color 
	   //a property of the RoundButton class.
	   g.setColor(couleur);
	   } else {
	   g.setColor(getBackground());
	  
	   }
	   g.fillOval(0, 0, getSize().width-1,getSize().height-1);
	   //This call will paint the label and the 
	   //focus rectangle.
	   super.paintComponent(g);
	   }
	   //Paint the border of the button using a simple stroke.
	   protected void paintBorder(Graphics g) {
	   g.setColor(getForeground());
	  
	   g.drawOval(0, 0, getSize().width-1,getSize().height-1);
	   }
	   //Hit detection.
	   Shape shape;
	   public boolean contains(int x, int y) {
	   //If the button has changed size, 
	   //make a new shape object.
	   if (shape == null || 
	   !shape.getBounds().equals(getBounds())) {
	   shape = new Ellipse2D.Float(0, 0, 
	   getWidth(), getHeight());
	   }
	   return shape.contains(x, y);
	   }
    
    
}