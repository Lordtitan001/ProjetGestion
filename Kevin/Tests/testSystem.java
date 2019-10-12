package Kevin.Tests;

import Kevin.Code.Company;
import Kevin.Code.Employer;
import Kevin.Code.Systeme;;;

public class testSystem {

    public static void main(String args[]){

        Company comp = new Company();

        comp.getWorkers().add(new Employer("kev lems"));
        comp.getWorkers().add(new Employer("kev lems"));
        comp.getWorkers().add(new Employer("kev lems"));

        comp.getWorkers().add(new Employer("kev lems"));
        comp.getWorkers().add(new Employer("kev lems"));
        

        comp.setManager(new Employer("lems"));

        Systeme sys = new Systeme();
        sys.saveCompany();

        Company com = sys.restaureCompany();

        System.out.println("la compagnie restaure : " + com.getCompanyname());
        System.out.println("Manager : " + com.getManager().getNom());
        System.out.println("La liste des employers : ");

        for(Employer em : com.getWorkers()){
            System.out.println(em.getNom()); 
        }
    }

}