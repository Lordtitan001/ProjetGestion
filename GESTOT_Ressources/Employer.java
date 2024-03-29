package GESTOT_Ressources;
import Kevin.Code.*;


import java.io.Serializable;
import java.util.*;
import java.time.*;

public abstract class Employer implements Serializable{
	protected boolean isWorking = false;
	protected MyDay myDay=new MyDay();// represente une periode de travail
	protected String Id;
	protected String name;
	protected String surname;
	protected String NAS;
	protected String accountNumber;
	protected Date  Birthday;
	protected Date hiredDay;
	protected String passWord="Employer000";
	protected HashMap<LocalDate,LinkedList<MyDay>> dayList=new HashMap<LocalDate,LinkedList<MyDay>>(); // represente la liste de toutes les periodes de travail de l'employ�
	protected static Day dayWorkersList=new Day(); // represente la liste <employe-listePeriodes> pour tous les employ� ayant travaill�  ce jours
	protected static int nbWorkers=0;
	private int additionalShift = 0;
	protected String fonction="";
	//---  Pour attribuer une fonction a un employer;
	public final static String FONCTION_SUPERVISOR="Supervisor_EMP";
	public final static String FONCTION_GENERAL="GENERAL_EMP";

	
	
	/* geter*/
	public boolean getIsWorking(){
		return isWorking;
	}
	public String getFonction() {
		return fonction;
	}

	public String getId() {return Id;}
	public String getName() {return name;}
	public String getPassWord() {return passWord;}
	
	public MyDay getMyDay() {return myDay;}
	public HashMap<LocalDate,LinkedList<MyDay>> getDayList() {return dayList;}
	public Day getDayWorkersList() {return dayWorkersList;}
	public int getNbEmployer() {return nbWorkers;}
	
	public String getSurname() {
		return surname;
	}
	
	public String getNAS() {
		return NAS;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public Date getBirthday() {
		return Birthday;
	}
	
	public Date getHiredDay() {
		return hiredDay;
	}
	

	
	/*seter*/
	public void setFonction(final String poste) {
		if(poste==FONCTION_SUPERVISOR) fonction=FONCTION_SUPERVISOR;
		if(poste==FONCTION_GENERAL) fonction=FONCTION_GENERAL;
	}
	public void setName(String name) {this.name=name;}
	public void setPassWord(String pass) {this.passWord=pass;}
	
	
	protected String setId() {
		return( "Emp"+Integer.valueOf(nbWorkers).toString());
	}
	
	public boolean equals(Object obj) {
    	return (obj.getClass()==this.getClass()) && 
    		  ((Employer)obj).getId().equals(Id);
    }
	
	public boolean addDayInList() { // permet d'ajouter la PERIODE EN COURS parmis la liste des periodes de l'employ�
		LinkedList<MyDay> listPeriod = null;
    	if(!dayList.containsKey(myDay.getDay())) {
    		listPeriod =  new LinkedList<MyDay>();
    		listPeriod.add(myDay);
    		dayList.put(myDay.getDay(), listPeriod);
    	}
    	else {
    		listPeriod=dayList.get(myDay.getDay());
    		if(!listPeriod.contains(myDay)) {
    			listPeriod.add(myDay);
    		}
    	}
    	return (listPeriod == null);
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setNAS(String nAS) {
		NAS = nAS;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	
	public void setHiredDay(Date hiredDay) {
		this.hiredDay = hiredDay;
	}
	/*Permet d'ajouter une PERIODE DONN�E parmis les periodes de l'employ�: Utile pour des revendications  */
	public boolean addDayInList(MyDay periode) {
		LinkedList<MyDay> listPeriod = null;
    	if(!dayList.containsKey(periode.getDay())) {
    		listPeriod =  new LinkedList<MyDay>();
    		listPeriod.add(periode);
    		dayList.put(periode.getDay(), listPeriod);
    	}
    	else {
    		listPeriod=dayList.get(periode.getDay());
    		if(!listPeriod.contains(periode)) {
    			listPeriod.add(periode);
    		}
    	}
    	return (listPeriod == null);
	}
	
	/* retire une periode dans la liste des periode de l'employer a une date donn�e*/
	public boolean removeDayInList(int shiftNumber, LocalDate date) {
    	if(dayList.containsKey(date)) {
    		LinkedList<MyDay> listPeriod=dayList.get(date);
    		return (listPeriod.remove(shiftNumber) != null);
    	}
    	else
    		return false;
	}
	
	
	/* retire une periode dans la liste des periode de l'employer */
	public boolean removeDayInList(int shiftNumber) { ////////////// faille: si une periode commence a une date x et fini a une date x+1: probleme avec LocalDate.now()
    	if(dayList.containsKey(LocalDate.now())) {
    		LinkedList<MyDay> listPeriod=dayList.get(LocalDate.now());
    		return (listPeriod.remove(shiftNumber) != null);
    	}
    	else
    		return false;
	}
	
	public void punchIn() {  // pour rappel: il faut penser a faire un systeme de sauvegarde de tout le systeme apres chaque punchIn
		if(myDay.getStart()==null) {
			//myDay.setDay();
			isWorking = true;
			myDay.start();
			dayWorkersList.addShift(this.getId());
		}
		else
			System.out.println("Mr/Mme "+this.getName()+", Vous devez finir votre  quart de travail ");
	}
	
	public void punchOut() { // penser a faire une sauvegarde apres le punchOut
		myDay.end();
		isWorking = false;
		 addDayInList(); // on ajoute la quart de travail a la liste des quarts de l�'employ�
		 myDay=new MyDay(); // on instancie un nouveau objet myday
	}
	
	
	/******** FONCTIONS TESTES P*******/
	
	public void punchInForTest( LocalDateTime start) {  // punchIn Pour les testes
		if(myDay.getStart()==null) {
			//myDay.setDay();
			myDay.setStart(start);
			dayWorkersList.addShift(this.getId());
		}
		else
			System.out.println("Mr/Mme "+this.getName()+", Vous devez finir votre  quart de travail ");
	}
	
	
	public void punchOutForTest(LocalDateTime end) { // penser a faire une sauvegarde apres le punchOut
		myDay.setEnd(end);
		addDayInList(myDay); // on ajoute la quart de travail a la liste des quarts de l�'employ�
		 myDay=new MyDay(); // on instancie un nouveau objet myday
	}
	
	//***************FIN FONCTION TESTE*************/
	
	public void newShift(){//???
        additionalShift ++;
    }

    public void removeShift(){ //???
        additionalShift --;
    }

    /**
     * @return the additionalShift
     */
    public int getAdditionalShift() {
        return additionalShift;
    }

    /**
     * @param additionalShift the additionalShift to set
     */
    public void setAdditionalShift(int additionalShift) {
        this.additionalShift = additionalShift;
    }
    
    /********permet d'afficher toules informations sur un employe**********/
    public String toString() {
		String info="";
		info+="* Nom=> "+name+"  ID=> "+Id+"  PASS=> "+passWord+"\n";
		info+="* Shift en court=> ";
		
		if(myDay.getStart()==null) info+=" AUCUN ";
		else {
			info+=" Jours=> "+myDay.getDay().toString()+" Debut=> "+myDay.getStart().toString()+" Fin=> ";
			if(myDay.getEnd()==null)info+=" �.�.� ";
			else info+=myDay.getEnd().toString();
		}
		info+="\n";
		
		info+="****** LISTE DE TOUS LES SHIFT EFFECTU�S**********"+"\n";
		for(HashMap.Entry<LocalDate,LinkedList<MyDay>> entree: dayList.entrySet()) {
			LocalDate cle=entree.getKey();
			LinkedList<MyDay> listeShift=entree.getValue();
			
			info+="* La Cl�e=> "+ cle.toString()+"\n";
			for(MyDay day:listeShift)
				info+="    - Jours=> "+day.getDay().toString()+" Debut=> "+day.getStart().toString()+" Fin=> "+day.getEnd().toString()+"\n";
		}
		return info;
	}
	
 
	
	
}
