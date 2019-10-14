package Kevin.Tests;

import Kevin.Code.Company;
import Kevin.Code.Employer;
import Kevin.Code.Systeme;;;

public class testSystem {

    public static void main(String args[]){

        Company comp = new Company();

        comp.getWorkers().put("1", new Employer("kev lems", "1"));
        comp.getWorkers().put("2", new Employer("kev lems", "2"));
        comp.getWorkers().put("3", new Employer("kev lems", "3"));

        comp.getWorkers().put("3" , new Employer("kev lems", "4"));
        comp.getWorkers().put("4", new Employer("kev lems", "5"));
        

        comp.setManager(new Employer("lems", "6"));

        Systeme sys = new Systeme();
        sys.saveCompany();

        Company com = sys.restaureCompany();

        System.out.println("la compagnie restaure : " + com.getCompanyname());
        System.out.println("Manager : " + com.getManager().getNom());
        System.out.println("La liste des employers : ");

        for(Employer em : com.getWorkers().values()){
            System.out.println("Nom : " + em.getNom() + " Id : " + em.getId()); 
        }
    }

}