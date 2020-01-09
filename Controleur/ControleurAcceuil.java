package Controleur;

import java.util.HashMap;

import javax.swing.DefaultListModel;
import Kevin.Code.Company;
import Kevin.Code.EmployerListCellRenderer;
import Interface.AcceuilGUI;
import Interface.FenetreHoraire;
import Interface.SystemGUI;
import GESTOT_Ressources.*;

import java.awt.*;
import javax.swing.*;

public class ControleurAcceuil extends AbsControleur {

    private Company company = new Company();

    public ControleurAcceuil(AcceuilGUI acceuilGUI) {
        super(acceuilGUI);
        // TODO Auto-generated constructor stub
    }

    public Company getCompany() {
        return company;
    }

    public boolean punchInout(Employer emp, String password) {
        if (emp.getPassWord().compareTo(password) == 0) {
            if (!emp.getIsWorking())
                emp.punchIn();
            else {
                emp.punchOut();
            }
            // Systeme.saveCompany();
            acceuilGUI.getLogInErrorLabel().setText("");
            return true;
        } else
            return false;
    }

    public static boolean punchInout(Employer emp) {

        if (!emp.getIsWorking())
            emp.punchIn();
        else {
            emp.punchOut();
        }
        // Systeme.saveCompany();
        return true;
    }

    public void afficherListeEmployers(HashMap<String, Employer> employerMap) {
        DefaultListModel<Employer> model = new DefaultListModel<>();
        model.addAll(employerMap.values());
        acceuilGUI.getEmployerJList().setCellRenderer(new EmployerListCellRenderer());
        acceuilGUI.getEmployerJList().setModel(model);
    }

    public boolean ouvrirSession(Employer employer, String password) {

        if(employer.getPassWord().compareTo(password) == 0){
        FenetreHoraire fHoraire = new FenetreHoraire(acceuilGUI.getWidth(), acceuilGUI.getHeight());
        AbsControleur controleurHoraire = new ControleurFeneHoraire(fHoraire, employer);
        SystemGUI.getContentPanel().add(fHoraire, "horaire");
        SystemGUI.getCardLayout().show(SystemGUI.getContentPanel(), "horaire");
        acceuilGUI.getPasswordField().setText("");
        acceuilGUI.getLogInErrorLabel().setText("");
        return true;
        }
        else{
            return false;
        }
    }

    public void changeButton(){
        if (acceuilGUI.getEmployerJList().getSelectedValue().getIsWorking()) {
            acceuilGUI.getPunchButton().setText("Punch Out");
            acceuilGUI.getPunchButton().setBackground(Color.RED);
        } else {
            acceuilGUI.getPunchButton().setText("Punch in");
            acceuilGUI.getPunchButton().setBackground(Color.GREEN);
        }
      }

}