package Interface;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class AbsInterfaceContainer extends JPanel{
    private static final long serialVersionUID = 1L;

    private BufferedImage image;
    private String nomImage="images\\BackGround2.jpg";
    public AbsInterfaceContainer(){
    	try {
    image = ImageIO.read(new File(nomImage));
    	}
    	catch(IOException e) {}
    }
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null);
    }
    
}