package Kevin.Interface;

import java.awt.event.*;
import javax.swing.JFrame;
import Kevin.Code.*;
import Kevin.Interface.AcceuilGUI;
import Michel.Employer;
import Michel.Infirmier;

public class ControleAcceuil implements ActionListener {

    public static void main(String[] args) {

        Employer infirmier1 = new Infirmier("kevin");
        Employer infirmier2 = new Infirmier("eric");
        Employer infirmier3 = new Infirmier("kev lems");
        Employer infirmier4 = new Infirmier("kev mich");
        Employer infirmier5 = new Infirmier("Infirmiere Num5");
        Company.addWorker(infirmier1);
        Company.addWorker(infirmier2);
        Company.addWorker(infirmier3);
        Company.addWorker(infirmier4);
        Company.addWorker(infirmier5);

        //Automate.creerArbreNom();

        JFrame fenetre = new JFrame();
        fenetre.setTitle("Acceuil");
        fenetre.setSize(1000, 1000);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setInteractions(fenetre);
        fenetre.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    

}
