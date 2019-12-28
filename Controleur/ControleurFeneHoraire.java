package Controleur;
import Interface.FenetreHoraire;
import Kevin.Code.*;
import GESTOT_Ressources.Employer;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;





public class ControleurFeneHoraire extends  AbsControleur {
	
	//-------LES ATTRIBUTS DU CONTROLEUR---------------------
	private Employer employer; // ceci represente l'employé sur lequel la fenetre s'execute

	//---------------LE CONSTRUCTEUR------------------------------
	public ControleurFeneHoraire(FenetreHoraire fene, Employer employe) {
		super(fene);
		employer=employe;
		fene.ajoutActionFenetre(this);// Ici on ajoute le controleur a la fenetre
	}
	
	
	//-----------------LES METHODES DU CONTROLEUR--------------------------------------
	
	public Map.Entry<Vector<Double>, Vector<Vector<LocalDateTime>>> getIntervaleDateHoraire() {
		Vector<Vector<LocalDateTime>> listeDtate=new Vector<Vector<LocalDateTime>>();
		
		Vector<LocalDateTime> listeDateDebut=new Vector<LocalDateTime>();
		Vector<LocalDateTime> listeDateFin=new Vector<LocalDateTime>();
		Vector<Double> listeHoraire= new Vector<Double>();
		
		LocalDate dateDebut;
		LocalDate datefin;
		
		int anneDeb=Integer.parseInt((String)feneHoraire.getAnneeIn().getSelectedItem());
		int moisDeb=feneHoraire.getMoisIn().getSelectedIndex();
		int joursDeb=Integer.parseInt((String)feneHoraire.getJourIn().getSelectedItem());
		 dateDebut=LocalDate.of(anneDeb, moisDeb, joursDeb);
		
		int annefin=Integer.parseInt((String)feneHoraire.getAnneeOut().getSelectedItem());
		int moisfin=feneHoraire.getMoisOut().getSelectedIndex();
		int joursfin=Integer.parseInt((String)feneHoraire.getJourOut().getSelectedItem());
		datefin=LocalDate.of(annefin, moisfin, joursfin);
		
		HashMap<LocalDate,LinkedList<MyDay>> listeQuart=employer.getDayList();
		/*if(dateDebut==null) {
			System.out.println("---***----*****-----*****--NULLLLLL---****-----*****----****-----****----");
			return null;
		}*/
		//*  IL FAUT PENSER A ALLER RANGER LA LISTE DES QUART(dayList) DE L'EMPLOYER PAR ORDRE 
		for(Map.Entry<LocalDate,LinkedList<MyDay>> entre:listeQuart.entrySet()) { 
			LocalDate date=entre.getKey();
			System.out.println("---***----*****---111111111111111111---****-----*****----****-----****----");
			if(date.isAfter(dateDebut) && date.isBefore(datefin)  ) {// on verifie que la date est dans l'intervalle selectionné
				System.out.println("---***----*****---222222222222---****-----*****----****-----****----");
				LinkedList<MyDay> listeMyDay=entre.getValue();
				
				for(MyDay quart:listeMyDay) {  // on parcourt toutes les quarts 
					if(quart.getStart()!=null) listeDateDebut.add(quart.getStart());
					else {
						if(quart.getEnd()!=null) {
							listeDateFin.add(quart.getEnd());
							listeHoraire.add(quart.calculerHoraire());
						}
						else System.out.println("ICI IL FAUT GERER UNE FENETRE D'ERREUR ET AUSSI CREER UNE CLASSE POUR GERER LES EXCEPTIONS");
					}
					
				}
			}
		}
		if(listeDateDebut.isEmpty() || listeDateFin.isEmpty()||listeHoraire.isEmpty()) return null;
		else {
			listeDtate.add(listeDateDebut);
			listeDtate.add(listeDateFin);
			return Map.entry(listeHoraire, listeDtate);
		}
		
		
	}
	
	
	//----------------LES ACTIONS DU CONTROLEUR-------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(feneHoraire.getBoutValiderPeriode())) {
			System.out.println("------------------------ VOUS AVEZ CLIKER SUR LE BOUTTON VALIDER DE LA FENETRE HORAIRE");
			Map.Entry<Vector<Double>, Vector<Vector<LocalDateTime>>> entre=getIntervaleDateHoraire();
			Vector<Vector<LocalDateTime>> listeDate=entre.getValue();
			Vector<LocalDateTime> listeDateDebut=listeDate.elementAt(0);
			Vector<LocalDateTime> listeDateFin=listeDate.elementAt(1);
			Vector<Double> listeHoraire=entre.getKey();
			feneHoraire.affichageHoraire(listeDateDebut, listeDateFin, listeHoraire);
		}
	}
	
}
