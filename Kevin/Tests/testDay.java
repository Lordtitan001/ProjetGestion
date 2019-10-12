package Kevin.Tests;
import Kevin.Code.Day;
import Kevin.Code.Employer;

public class testDay {

    public static void main(String args[]){
    
        System.out.println("************Test de la classe Day****************");
        Day jour = new Day();
        Employer emp1 = new Employer();
        Employer emp2 = new Employer("michel");
        Employer emp3 = new Employer("lems");
        Employer emp4 = new Employer();

        System.out.println(emp1.getNom() + " " + emp3.getNom());

        jour.addWorker(emp1);
        jour.addWorker(emp2);
        jour.addWorker(emp3);
        jour.addWorker(emp4);
        

        for(Employer emp : jour.getList()){
            System.out.println(emp.getNom());
        }
        System.out.println("");

        jour.removeWorker(emp3);

        for(Employer emp : jour.getList()){
            System.out.println(emp.getNom());
        }

        System.out.println("");

        jour.removeWorker(emp2);

        for(Employer emp : jour.getList()){
            System.out.println(emp.getNom());
        }

    }
}