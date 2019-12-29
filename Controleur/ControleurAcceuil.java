package Controleur;

import java.util.HashMap;

import javax.swing.DefaultListModel;

import Interface.AbsInterfaceContainer;
import Kevin.Code.Company;
import Kevin.Code.EmployerListCellRenderer;
import Kevin.Code.Systeme;
import Kevin.Interface.AcceuilGUI;
import Michel.Employer;

public class ControleurAcceuil extends AbsControleur {

    private Company company = new Company();
    public ControleurAcceuil(AcceuilGUI acceuilGUI) {
        super(acceuilGUI);
        // TODO Auto-generated constructor stub
    }

    public Company getCompany() {
        return company;
    }

    public boolean punchInout(Employer emp, String password){
        if (emp.getPassWord().compareTo(password) == 0) {
            if (!emp.getIsWorking())
              emp.punchIn();
            else {
              emp.punchOut();      
            }
            //Systeme.saveCompany();
            return true;
        }
        else  return false;
    }

    public void afficherListeEmployers(HashMap<String, Employer> employerMap) {
        DefaultListModel<Employer> model = new DefaultListModel<>();
        model.addAll(employerMap.values());
        acceuilGUI.getEmployerJList().setCellRenderer(new EmployerListCellRenderer());
        acceuilGUI.getEmployerJList().setModel(model);
    }
}