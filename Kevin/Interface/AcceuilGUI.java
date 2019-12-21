package Kevin.Interface;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AcceuilGUI {

    JTextField searchBarField = new JTextField("Nothing here for now");
    public void fenetre(){
        
    }
    public static void main(String[] args){

        JFrame fenetre = new JFrame();
        fenetre.setTitle("Acceuil");
        fenetre.setSize(1000, 1000);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        fenetre.setVisible(true);
      }   
}