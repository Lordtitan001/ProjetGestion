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
        Superviseur infirmier1 = new Superviseur("KeVin");
        Employer infirmier2 = new Infirmier("eRic");
        Employer infirmier3 = new Infirmier("kev lems");
        Employer infirmier4 = new Infirmier("Kev mich");
        Employer infirmier5 = new Infirmier("Infirmiere Num5");
        Company.addWorker(infirmier1);
        Company.addWorker(infirmier2);
        Company.addWorker(infirmier3);
        Company.addWorker(infirmier4);
        Company.addWorker(infirmier5);
        contentPanel.setLayout(layout);
        this.add(contentPanel);
        this.setTitle("Logiciel Gestion");
        this.setSize(1200, 900);
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
        getContentPanel().add(acceuil, "acceuil");
        systemGUI.setVisible(true);
    }



}