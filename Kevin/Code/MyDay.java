package Kevin.Code;

import java.util.Calendar;
import java.util.Date;

public class MyDay{

    public MyDay(){
        this.start = 0;
        this.end = 0;
        this.day  = null;
    }

    public double calculerHoraire(){
        return this.end - this.start;
    }

    public void clearDay(){
        this.start = 0;
        this.end = 0;
        this.day  = null;
    }

    public void setDay(){
        this.day = new Date();
    }

    public void start(){
        this.start = Calendar.getInstance().get(Calendar.HOUR)+ (double)Calendar.getInstance().get(Calendar.MINUTE)/60;
    }

    public void end(){
        this.end = Calendar.getInstance().get(Calendar.HOUR) + (double)Calendar.getInstance().get(Calendar.MINUTE)/60;
    }

    public double getEnd(){ return this.end;}
    public double getStart(){ return this.start;}
    public Date getDay(){return this.day;}

    private double start;
    private double end;
    private Date day;


}