package Kevin.Tests;
import Kevin.Code.Company;
import Kevin.Code.Day;
import Kevin.Code.Employer;
import Kevin.Code.MyDay;

public class testDay {

    public static void main(String args[]){
    
        System.out.println("************Test de la classe Day****************");
        Day jour = new Day();
        Employer emp1 = new Employer();
        Employer emp2 = new Employer("michel", "1");
        Employer emp3 = new Employer("lems", "3");
        Employer emp4 = new Employer("Black", "2");

        Company com = new Company();

        com.getWorkers().put(emp1.getId(), emp1);
        com.getWorkers().put(emp2.getId(), emp2);
        com.getWorkers().put(emp3.getId(), emp3);
        com.getWorkers().put(emp4.getId(), emp4);


        jour.addShift(emp1.getId());
        jour.addShift(emp2.getId());
        jour.addShift(emp3.getId());
        jour.addShift(emp4.getId());
        

        for(Employer emp : jour.getList()){
            System.out.println(emp.getNom());
        }
        System.out.println("");

        jour.removeShift(emp3.getId(), 1);

        System.out.println("workers List: ");
        for(Employer emp : jour.getList()){
            System.out.print( emp.getNom() + " ");
        }

        System.out.println("");
        System.out.println("************Test de la classe Day part 2 ****************");
        System.out.println("");

        emp1.newShift();
        emp2.newShift();
        emp3.newShift();
        emp4.newShift();

        System.out.println("");

        jour.addShift(emp1.getId());
        jour.addShift(emp2.getId());
        jour.addShift(emp3.getId());
        jour.addShift(emp4.getId());

        System.out.println("");

        emp1.newShift();
        emp2.newShift();
        
        System.out.println("");

        jour.addShift(emp1.getId());
        jour.addShift(emp2.getId());

        System.out.println("");

        System.out.println("");

        emp1.newShift();
        
        System.out.println("");

        jour.addShift(emp1.getId());

        System.out.println("");


        for(Employer emp : jour.getList()){
            System.out.println( emp.getNom() + " Liste des shifts : ");
            System.out.println("");
            for(int i = 1; i <= emp.getAdditionalShift(); i++){
                MyDay day = jour.getShift(emp.getId(), i);
                System.out.println("la journee de travail: "+ day.getDay() + "le debut: " + day.getStart() + " la fin: " + day.getEnd());
                System.out.println("");
            }
            
        }

        System.out.println("");

        jour.removeShift(emp1.getId(), 3);
        emp1.removeShift();
        jour.removeShift(emp2.getId(), 2);
        emp2.removeShift();
        jour.removeShift(emp1.getId(), 2);
        emp1.removeShift();

        System.out.println("***************************************************************************************************");

        for(Employer emp : jour.getList()){
            System.out.println( emp.getNom() + " Liste des shifts : ");
            System.out.println("");
            for(int i = 1; i <= emp.getAdditionalShift(); i++){
                MyDay day = jour.getShift(emp.getId(), i);
                System.out.println("la journee de travail: "+ day.getDay() + "le debut: " + day.getStart() + " la fin: " + day.getEnd());
                System.out.println("");
            }
            
        }

    }
}