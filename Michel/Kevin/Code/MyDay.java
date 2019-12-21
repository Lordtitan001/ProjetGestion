package Kevin.Code;
import GESTOT_Ressources.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyDay{

    public MyDay(){
        this.day  = null;
        this.start=null;
        this.end=null;
    }

    public double calculerHoraire(){
        return (double)Duration.between(start, end).toMinutes()/60;
    }

    public void clearDay(){
        this.start = null;
        this.end = null;
        this.day  = null;
    }
    public void start(){
        this.start = LocalDateTime.now();
    }

    public void end(){
        this.end = LocalDateTime.now();
    }

    public LocalDateTime getEnd(){ return this.end;}
    public LocalDateTime getStart(){ return this.start;}
    public LocalDate getDay(){return this.day;}
    /**
     * @param end the end to set
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
     * @param start the start to set
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * @param day the day to set
     */
    public void setDay(LocalDate day) {
        this.day = day;
    }
    
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDate day;
   
}