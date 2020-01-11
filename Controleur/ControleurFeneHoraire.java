package Controleur;
import Interface.*;
import Kevin.Code.*;
import GESTOT_Ressources.Employer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

public class ControleurFeneHoraire extends  AbsControleur {
	
	//-------LES ATTRIBUTS DU CONTROLEUR---------------------
	private Employer employer; // ceci represente l'employ� sur lequel la fenetre s'execute

	//---------------LE CONSTRUCTEUR------------------------------
	public ControleurFeneHoraire(FenetreHoraire fene, Employer employe) {
		super(fene);
		employer=employe;
		fene.ajoutActionFenetre(this);// Ici on ajoute le controleur a la fenetre
		fene.getEtiquetteNomEmployer().setText(employer.getName());
		fene.getEtiquetteIdEmployer().setText(employer.getId());
		setButton_Punch_In_or_Out();
		choixSession() ;
	}
	
	//-----------------LES METHODES DU CONTROLEUR--------------------------------------
	
	//-- Permet d'afficher le bon boutton punch In/out dans la fenetre
	public void setButton_Punch_In_or_Out() {
		if(employer.getIsWorking())feneHoraire.getBoutPunchOutHoraire().setTextBoutton("Punch_Out");
		else feneHoraire.getBoutPunchOutHoraire().setTextBoutton("Punch_In");
	}
	
	public void choixSession() {
		if(employer.getFonction()==Employer.FONCTION_SUPERVISOR) feneHoraire.sessionSuperviseur();
	}
	
	//-------------PERMET DE RECCUPERER L'INTERVALE DE DATE ENTREE PAR L'UTILISATEUR 
	public Map.Entry<Vector<Double>, Vector<Vector<LocalDateTime>>> getIntervaleDateHoraire() {
		
		/*Ici on controle si la selection faite par l'utilisateur et conforme*/
		if( feneHoraire.getMoisIn().getSelectedIndex()==0 || feneHoraire.getJourIn().getSelectedIndex()==0||
			 feneHoraire.getMoisOut().getSelectedIndex()==0 || feneHoraire.getJourOut().getSelectedIndex()==0	) {
			new FenetreErreur("Mauvais choix de  date/mois").afficher(FenetreErreur.ERREUR);
			return null;
		}
		
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
		
		/*Ici on verifie si l'intervalle de date est conforme*/
		if(datefin.compareTo(dateDebut)<=0) {
			new FenetreErreur("la Date de debut inferieur a la date de fin").afficher(FenetreErreur.ERREUR);
			return null;
		}
		
		Vector<LocalDateTime> listeDateDebut=new Vector<LocalDateTime>();
		Vector<LocalDateTime> listeDateFin=new Vector<LocalDateTime>();
		Vector<Double> listeHoraire= new Vector<Double>();
		HashMap<LocalDate,LinkedList<MyDay>> listeQuart=employer.getDayList();
	
		for(Map.Entry<LocalDate,LinkedList<MyDay>> entre:listeQuart.entrySet()) { 
			
			LocalDate date=entre.getKey();
			if(dateDebut.compareTo(date)<=0 && date.compareTo(datefin)<=0  ) {// on verifie que la date est dans l'intervalle selectionn�
				
				
				LinkedList<MyDay> listeMyDay=entre.getValue();
				
				for(MyDay quart:listeMyDay) {  // on parcourt toutes les quarts 
					if(quart.getStart()!=null) {
						/* ici on fait un ajout et  on trie la listeDatedebut par ordre croussant*/
						int pos=0;
						while(pos<listeDateDebut.size() && listeDateDebut.elementAt(pos).compareTo(quart.getStart())<=0) pos++;
						if(pos>=listeDateDebut.size()) listeDateDebut.add(quart.getStart());
						else listeDateDebut.insertElementAt(quart.getStart(),pos);
						
						pos=listeDateDebut.indexOf(quart.getStart());
						
						if(quart.getEnd()!=null) {
							if(pos>listeDateFin.size()) {
								listeDateFin.add(quart.getEnd()); 
								listeHoraire.add(quart.calculerHoraire());
							}
							else {
								listeDateFin.insertElementAt(quart.getEnd(), pos); 
								listeHoraire.insertElementAt(quart.calculerHoraire(),pos);
							}
							
							
						}
					}
					
				}
			}
		}
		if(listeDateDebut.isEmpty() || listeDateFin.isEmpty()||listeHoraire.isEmpty()) { // il faut savoir pourquoi je fais ce test ici
			new FenetreErreur("Erreur-33").afficher(FenetreErreur.ERREUR);
			return null;
		}
		else {
			Vector<Vector<LocalDateTime>> listeDate=new Vector<Vector<LocalDateTime>>();
			listeDate.add(listeDateDebut);
			listeDate.add(listeDateFin);
			return Map.entry(listeHoraire, listeDate);
		}
		
	
	}
	
	
	//----------------LES ACTIONS DU CONTROLEUR-------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//--------------ACTION DU BOUTTON VALIDER DE LA FENETRE HORAIRE ----------------
		if(e.getSource().equals(feneHoraire.getBoutValiderPeriode())) {
			System.out.println("------------------------ VOUS AVEZ CLIKER SUR LE BOUTTON VALIDER DE LA FENETRE HORAIRE");
			
			Map.Entry<Vector<Double>, Vector<Vector<LocalDateTime>>> entre=getIntervaleDateHoraire();
			if(entre!=null) {
				/*Ici on vide le conteneur qui affiche les heures*/
				if(feneHoraire.getContenuAffichagePeriode().getComponentCount()!=0) feneHoraire.viderContenuAffichagePeriode();
				
				Vector<Vector<LocalDateTime>> listeDate=entre.getValue();
				Vector<LocalDateTime> listeDateDebut=listeDate.elementAt(0);
				Vector<LocalDateTime> listeDateFin=listeDate.elementAt(1);
				Vector<Double> listeHoraire=entre.getKey();
				feneHoraire.affichageHoraire(listeDateDebut, listeDateFin, listeHoraire);
			}else System.out.println("----------------------ENTREE EST EGALE A NULLLLLLL");; // on ne fait rien si entre==null
		}
		
		//--------------ACTION DU BOUTTON QUITTER DE LA FENETRE HORAIRE ----------------
		if(e.getSource().equals(feneHoraire.getBoutQuitterHoraire())) {
		
			SystemGUI.getCardLayout().show(SystemGUI.getContentPanel(), "acceuil");
		}
		
		//--------------ACTION DU BOUTTON PUNCH_IN_OUT DE LA FENETRE HORAIRE ----------------
		if(e.getSource().equals(feneHoraire.getBoutPunchOutHoraire())) {
			ControleurAcceuil.punchInout(employer);
			setButton_Punch_In_or_Out();
		}
	}
	
	 //Methode appelee lors du survol de la souris
	  public void mouseEntered(MouseEvent e) { 
		  Button bout=(Button)e.getSource();
		  if(bout.getText().contains("Quitter"))  bout.setCouleur(Color.red);
		  else {
			  if(bout.getText().contains("Punch")) {
				  if(employer.getIsWorking()) bout.setCouleur(Color.red);
				  else bout.setCouleur(Color.green);
			  }
			  else bout.setCouleur(Color.green);
		  }
		   bout.repaint();
		  System.out.println("************ EVENEMENT DU BOUTON CLIKER ****************"+bout.getText());
	  }

	  //Methode appellee lorsque la souris sort de la zone du bouton
	  public void mouseExited(MouseEvent e) {
		  Button bout=(Button)e.getSource();
		  bout.setCouleur(Color.white);
		  bout.repaint();
		   System.out.println("************ EVENEMENT DU BOUTON CLIKER ****************");
		  }
	
}