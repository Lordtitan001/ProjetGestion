package Kevin.Code;

import java.util.Collection;
import java.util.HashMap;

public class Day {

    public Day(){
    
    }

    private HashMap<String, Employer> workerList = new HashMap<String, Employer>();

    public void addWorker(Employer woker) {
       workerList.putIfAbsent(woker.getId(), woker);
    }

    public boolean removeWorker(String Id){
        if(workerList.isEmpty())
            return false;
        else{
            workerList.remove(Id);
            return true;
        }
    }

    public Collection<Employer> getList(){
        System.out.println(workerList.size());
        return workerList.values();
    }

    public void clearDay(){

        workerList.clear();

    }

}