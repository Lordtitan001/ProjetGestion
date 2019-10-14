package Kevin.Tests;
import Kevin.Code.Day;
import Kevin.Code.Employer;

public class testDay {

    public static void main(String args[]){
    
        System.out.println("************Test de la classe Day****************");
        Day jour = new Day();
        Employer emp1 = new Employer();
        Employer emp2 = new Employer("michel", "1");
        Employer emp3 = new Employer("lems", "2");
        Employer emp4 = new Employer("Black", "4");

        System.out.println(emp1.getNom() + " " + emp3.getNom());
        System.out.println("");

        jour.addWorker(emp1);
        jour.addWorker(emp2);
        jour.addWorker(emp3);
        jour.addWorker(emp4);
        

        for(Employer emp : jour.getList()){
            System.out.println(emp.getNom());
        }
        System.out.println("");

        jour.removeWorker(emp3.getId());

        for(Employer emp : jour.getList()){
            System.out.println(emp.getNom());
        }

        System.out.println("");

        jour.removeWorker(emp2.getId());

        for(Employer emp : jour.getList()){
            System.out.println(emp.getNom());
        }

    }
}