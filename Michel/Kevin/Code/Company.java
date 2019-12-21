package Kevin.Code;
import GESTOT_Ressources.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Company implements Serializable {

    public Company() {

    }

    private static HashMap< String , Employer> workers = new HashMap<String, Employer>(); // liste de tous les employés
    private static Employer manager =null;
    private static final String companyName = "KevCorp";

    /**
     * @param workers the workers to set
     */
    public static void setWorkers( HashMap< String , Employer> workers) { // ajout liste employé
        Company.workers = workers;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Employer man) {
        manager = man;
    }

    public  void addWorker(Employer infirmier1){
        workers.put(infirmier1.getId(), infirmier1);
    }

    public static boolean removeWorker(String Id){
        if(workers.isEmpty())
            return false;
        else{
            workers.remove(Id);
            return true;
        }
    }

    /**
     * @return the manager
     */
    public  Employer getManager() {
        return manager;
    }

    /**
     * @return the companyname
     */
    public  String getCompanyname() {
        return companyName;
    }

    /**
     * @return the workers
     */
    public  HashMap<String, Employer> getWorkers() {
        return workers;
    }
}