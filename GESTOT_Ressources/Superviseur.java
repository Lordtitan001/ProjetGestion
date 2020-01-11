package GESTOT_Ressources;
import Kevin.Code.*;

import java.time.LocalDate;




public class Superviseur extends Employer{

	public Superviseur(String name) {  
		Employer.nbWorkers++;
	    this.name=name;
	    Id=setId();
	    fonction=Employer.FONCTION_SUPERVISOR;
	}
	
	/*// permet d'ajouter une periodes parmis la liste des periodes de l'employé
	 * Utilile pour les revendication d'horaire
	 * */
	public void addWorkersDayList(Employer worker,MyDay periode) { 
		 worker.addDayInList(periode);
	}
	
	/* permet de ne pas valider le jour de travail de l'employer
	 * 1- on le supprime de la liste des travailleur de la periode
	 * 2- on supprime cette periode de sa liste de periode
	 *  NB: sur nos fenetre de liste des employes il faut afficher la dete de debut du shift*/
	
	public boolean invalidWorkersDay(Employer worker,int shiftNumber, LocalDate dateShift ) { 
		return /*worker.getDayWorkersList().getShift(worker.getId(), shiftNumber) &&*/ worker.removeDayInList(shiftNumber,dateShift) ;
	}
	
	public void closeDay() { /// permet de boucler la journée(fermer la fenetre de liste employe ayant travaillé )
		Employer.dayWorkersList=new Day();
	}
	
	
}
