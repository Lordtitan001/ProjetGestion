package Kevin.Code;

import java.util.Iterator;
import java.util.LinkedList;

public class Day {

    public Day(){
    
    }

    private LinkedList<Employer> workerList = new LinkedList<Employer>();

    public void addWorker(Employer woker) {
       workerList.add(woker);
    }

    public boolean removeWorker(Employer woker){
        if(workerList.isEmpty() || woker == null)
            return false;
        else{
            Iterator<Employer>it = workerList.iterator();
            int index = 0;
            while(it.hasNext()){
                Employer emp = it.next();
                if(emp.equals(woker)){
                    workerList.remove(index);
                    return true;
                }
                index ++;
            }
        }
        return false;
    }

    public LinkedList<Employer> getList(){
        return this.workerList;
    }

    public void clearDay(){
        for(int i = 0; i < workerList.size(); i++){
            workerList.remove(i);
        }
    }

}