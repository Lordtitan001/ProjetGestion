package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Button extends JButton {

    String name = "";
    Button(String name){
        super(name);
        this.name = name;
        this.setSize(100, 200);
    }
    public void paintComponent(Graphics g){
         Graphics2D g2 = (Graphics2D)g;
         GradientPaint gradientPaint = new GradientPaint(0, 0, Color.cyan, 50, 50, Color.blue);
         g2.setPaint(gradientPaint);
         g2.fillRect(0, 0, this.getWidth(), this.getHeight());
         g2.setColor(Color.white);
         g2.drawString(this.name, 0, 10);
    }
}