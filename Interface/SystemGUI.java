package Interface;

import java.awt.*;
import javax.swing.*;

import GESTOT_Ressources.*;
import Kevin.Code.Company;

public class SystemGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private static CardLayout layout = new CardLayout();
    private static JPanel contentPanel = new JPanel();

    public SystemGUI() {
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
        contentPanel.setLayout(layout);
        this.add(contentPanel);
        this.setTitle("Logiciel Gestion");
        this.setSize(1000, 1000);
        contentPanel.setSize(this.getWidth(), this.getHeight());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public void addPannel(AbsInterfaceContainer panel, String nomPanel) {
        contentPanel.add(panel, nomPanel);
    }

    public static CardLayout getCardLayout(){
        return layout;
    }

    public static JPanel getContentPanel(){
        return contentPanel;
    }

    public static void main(String[] args) {
        SystemGUI systemGUI = new SystemGUI();

        AcceuilGUI acceuil = new AcceuilGUI(systemGUI.getSize());
        // FenetreHoraire fHoraire = new FenetreHoraire((int)systemGUI.getSize().getWidth(), 
        // (int)systemGUI.getSize().getHeight());
        getContentPanel().add(acceuil, "acceuil");
        //getContentPanel().add(fHoraire, "horaire");
        systemGUI.setVisible(true);

    }



}