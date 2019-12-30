package Kevin.Code;

import java.io.Serializable;
import java.util.HashMap;
import GESTOT_Ressources.*;

public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    public Company() {
    }

    private static HashMap<String , Employer> workers = new HashMap<String, Employer>();
    private static Superviseur manager = new Superviseur("Manager");
    private static final String companyName = "KevCorp";
    private static Node nomEmployerNode = new Node(null, ' ');

    public static void setWorkers(HashMap<String, Employer> workers) {
        Company.workers = workers;
    }

    public void setManager(Superviseur man) {
        manager = man;
    }

    public static void addWorker(Employer worker) {
        workers.put(worker.getId(), worker);
        updateArbreNom();
        Systeme.saveCompany();
    }

    public static boolean removeWorker(String Id) {
        if (workers.isEmpty())
            return false;
        else {
            workers.remove(Id);
            updateArbreNom();
            Systeme.saveCompany();
            return true;
        }


    }

    public Node getNomEmployerNode() {
        return nomEmployerNode;
    }

    public Employer getManager() {
        return manager;
    }

    public String getCompanyname() {
        return companyName;
    }

    public static HashMap<String, Employer> getWorkers() {
        return workers;
    }

    public static void updateArbreNom() {
        for (var entrySet : workers.entrySet()) {
            Node currentNode = nomEmployerNode;
          for (char val : entrySet.getValue().getName().toCharArray()) {
            if (currentNode.nextChild(val) == null) {
              currentNode.getAdjaceNodes().add(new Node(currentNode, val));
            }
            currentNode.getListeEmployers().put(entrySet.getKey(), entrySet.getValue());
            currentNode.getAutoComplete().add(entrySet.getValue().getName());
            currentNode = currentNode.nextChild(val);
          }
        }
    }
}