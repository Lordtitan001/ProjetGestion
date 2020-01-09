package Kevin.Tests;

import Kevin.Code.Company;
import GESTOT_Ressources.*;
import Kevin.Code.Systeme;

public class testSystem {

    public static void main(String args[]){
        Company comp = new Company();

        Company.getWorkers().put("1", new Infirmier("kev lems"));
        Company.getWorkers().put("2", new Infirmier("kev lems"));
        Company.getWorkers().put("3", new Infirmier("kev lems"));
        Company.getWorkers().put("4", new Infirmier("kev lems"));
        Company.getWorkers().put("5", new Infirmier("kev lems"));

        comp.setManager(new Superviseur("lems"));
        // Company.removeWorker("3");
        
        Systeme.saveCompany();
        
        Company.getWorkers().clear();

        Company com = Systeme.restaureCompany();

        System.out.println("la compagnie restaure : " + com.getCompanyname());
        System.out.println("Manager : " + com.getManager().getName());
        System.out.println("La liste des employers : ");

        for(Employer em : Company.getWorkers().values()){
            System.out.println("Nom : " + em.getName() + " Id : " + em.getId()); 
        }
    }

}