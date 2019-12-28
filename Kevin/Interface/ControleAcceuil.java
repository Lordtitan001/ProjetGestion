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

        Automate.employerMap = Company.getWorkers();
        Automate.creerArbreNom();

        JFrame fenetre = new JFrame();
        fenetre.setTitle("Acceuil");
        fenetre.setSize(1000, 1000);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setInteractions(fenetre);
        fenetre.setVisible(true);

        setInteractions(fenetre);

    }

    public static void setInteractions(JFrame fenetre) {
        AcceuilGUI acceuilGUI = new AcceuilGUI();

        acceuilGUI.getOkButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!acceuilGUI.getEmployerJList().isSelectionEmpty() ){
                    Employer emp = acceuilGUI.getEmployerJList().getSelectedValue();
                    if (emp.getPassWord().compareTo(acceuilGUI.getPasswordField().getText()) == 0) {
                        if (!emp.getIsWorking())
                            emp.punchIn();
                        else {
                            emp.punchOut();
                        }
                    } else {
                        acceuilGUI.getLogInErrorLabel().setText("User name or password is not correct");; 
                        System.err.println("wrong password or user name");
                        System.out.println(
                                "Here is what you worte " + acceuilGUI.getPasswordField().getText());
                        System.out.println("Here is the pass " + emp.getPassWord());
                    }
                } else {
                    acceuilGUI.getLogInErrorLabel().setText("User name or password is not correct");;
                }
            }
        });

        acceuilGUI.getSearchBarField().addKeyListener(Automate.prediction(Automate.rootNoms, acceuilGUI));

        acceuilGUI.getPasswordField().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });

        acceuilGUI.getInOutLabel().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        acceuilGUI.getLogInLabel().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        acceuilGUI.fenetre(fenetre);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
