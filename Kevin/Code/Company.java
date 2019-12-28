package Kevin.Code;

import java.io.Serializable;
import java.util.HashMap;
import Michel.Employer;
import Michel.Superviseur;;

public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    public Company() {
    }

    private static HashMap<String , Employer> workers = new HashMap<String, Employer>();
    private static Superviseur manager = new Superviseur("Manager");
    private static final String companyName = "KevCorp";

    public static void setWorkers( HashMap< String , Employer> workers) {
        Company.workers = workers;
    }

    public void setManager(Superviseur man) {
        manager = man;
    }

    public static void addWorker(Employer worker){
        workers.put(worker.getId(), worker);
    }

    public static boolean removeWorker(String Id){
        if(workers.isEmpty())
            return false;
        else{
            workers.remove(Id);
            return true;
        }
    }

     public  Employer getManager() {
        return manager;
    }

    public  String getCompanyname() {
        return companyName;
    }

    public static HashMap<String, Employer> getWorkers() {
        return workers;
    }
}