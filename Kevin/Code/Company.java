package Kevin.Code;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import Kevin.Code.Employer;

public class Company implements Serializable {

    public Company() {

    }

    private static LinkedList<Employer> workers = new LinkedList<Employer>();
    private static Employer manager = new Employer();
    private static final String companyName = "KevCorp";

    /**
     * @param workers the workers to set
     */
    public static void setWorkers(LinkedList<Employer> workers) {
        Company.workers = workers;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Employer man) {
        manager = man;
    }

    public static void addWorker(Employer worker){
        workers.add(worker);
    }

    public static boolean removeWorker(Employer woker){
        if(workers.isEmpty() || woker == null)
            return false;
        else{
            Iterator<Employer>it = workers.iterator();
            int index = 0;
            while(it.hasNext()){
                Employer emp = it.next();
                if(emp.equals(woker)){
                    workers.remove(index);
                    return true;
                }
                index ++;
            }
        }
        return false;
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
    public  LinkedList<Employer> getWorkers() {
        return workers;
    }
}