package Kevin.Code;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import Michel.Employer;

public class Day {

    public Day(){}

    private static HashMap<String, LinkedList<MyDay>> workerList = new HashMap<String, LinkedList<MyDay>>();

    public void addShift(String Id) {
        Employer emp  = Company.getWorkers().get(Id);
        System.out.println(emp.getName() + " " + "ID : " +emp.getId() + " Shift: " + emp.getAdditionalShift()); 
        if(workerList.containsKey(Id))
            workerList.get(Id).add(emp.getMyDay());
        else{
            workerList.put(Id, new LinkedList<MyDay>());
            workerList.get(Id).add(emp.getMyDay());
        }
    }

    public boolean removeShift(String Id, int shiftNumber){
        return (workerList.get(Id).remove(shiftNumber - 1) != null);
    }

    public Collection<Employer> getList() {
        Collection<Employer> workers = new HashSet<Employer>();
        Company.getWorkers().forEach((id, emp) ->{
            if(workerList.containsKey(id)){
                workers.add(emp);
            }
        });
        return workers;
    }

    public MyDay getShift(String id, int shiftNumber){
        return workerList.get(id).get(shiftNumber - 1);
    }

    public void clearDay(){
        var com = Company.getWorkers();
        for(String key : workerList.keySet()){
            Employer emp  = com.get(key);
            emp.setAdditionalShift(0);
        } 
        workerList.clear();
    }

}