package Kevin.Tests;

import Kevin.Code.Company;
import GESTOT_Ressources.*;
import Kevin.Code.Systeme;

public class testSystem {

    public static void main(String args[]){
        Company comp = new Company();

        comp.getWorkers().put("1", new Infirmier("kev lems"));
        comp.getWorkers().put("2", new Infirmier("kev lems"));
        comp.getWorkers().put("3", new Infirmier("kev lems"));
        comp.getWorkers().put("4", new Infirmier("kev lems"));
        comp.getWorkers().put("5", new Infirmier("kev lems"));

        comp.setManager(new Superviseur("lems"));
        Company.removeWorker("3");

        Systeme sys = new Systeme();
        sys.saveCompany();

        Company com = sys.restaureCompany();

        System.out.println("la compagnie restaure : " + com.getCompanyname());
        System.out.println("Manager : " + com.getManager().getName());
        System.out.println("La liste des employers : ");

        for(Employer em : com.getWorkers().values()){
            System.out.println("Nom : " + em.getName() + " Id : " + em.getId()); 
        }
    }

}