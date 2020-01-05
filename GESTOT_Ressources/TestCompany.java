package GESTOT_Ressources;
import Kevin.Code.*;
import Interface.*;
import Controleur.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.*;
import java.util.Map;

import javax.swing.*;

import javax.swing.JFrame;



public class TestCompany {
	
	

	public static void main(String[] args) {
		
		/******************  ON CREE UNE COMPAGNIE ***********************/
		 Company maCompagnie= creationCompany();

		JFrame fenetre= new JFrame("FENETRE HORAIRE");
		
		int xFene=800;
		int yFene=700;
		
		// dimension de notre fenetre
		fenetre.setSize(new Dimension(xFene, yFene));
		//fenetre.setSize(new Dimension(xFene, yFene));
		
				 //position de notre fenetre
		fenetre.setLayout(new BorderLayout());
			    //femeture du procesus a la femeture de la fenetre
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    // pour positionner notre fenetre sur l'ecran
		fenetre.setLocation(100, 50);
			    //pour permetre ou nons a l,utilisateur de redimentinner notre fenetre
		fenetre.setResizable(false);
			    // pour garder la fenetre toujours au premier plan
		fenetre.setAlwaysOnTop(false);
		
		
		//dimension du panel. ici 15 et 40 repesentent les diemnsion des bordures de la fenetre	
		int xFeneHor=xFene-15;
		int yFeneHor=yFene-40;
		
		
		FenetreHoraire fene=new FenetreHoraire(xFeneHor,yFeneHor);
		fenetre.add(fene);
		fenetre.setVisible(true);
		
		
		Employer employe= maCompagnie.getWorkers().get("Emp2");
		AbsControleur controleurHoraire=new ControleurFeneHoraire(fene, employe);
	      
	}
	
	public static Company creationCompany() {
		// TODO Auto-generated method stub
		 
		/******************  ON CREE UNE COMPAGNIE ***********************/
		 Company maCompagnie=new Company();
						 
				 /**********************  ON CREE DES EMPLOY�S DE LA COMPAGNIE***********************/
				 
				 Employer infirmier1=new Infirmier("Infirmiere Num1");
				 maCompagnie.addWorker(infirmier1);
				 
				 Employer infirmier2=new Infirmier("Infirmiere Num2");
				 maCompagnie.addWorker(infirmier2);
				 
				 Employer infirmier3=new Infirmier("Infirmiere Num3");
				 maCompagnie.addWorker(infirmier3);
				 
				 Employer infirmier4=new Infirmier("Infirmiere Num4");
				 maCompagnie.addWorker(infirmier4);
				 
				 Employer infirmier5=new Infirmier("Infirmiere Num5");
				 maCompagnie.addWorker(infirmier5);
				 
				 Superviseur superviseur1=new Superviseur("Superviseur Num1");
				 maCompagnie.addWorker(superviseur1);
				 
				 Superviseur manager=new Superviseur("Manager");
				 maCompagnie.addWorker(manager);
				 maCompagnie.setManager(manager);
				 /********************************************************/
				 
				 /******************** ON CREE DES DATES***************************/
				 LocalDate jour1=LocalDate.of(2019, 11, 15);// 15 nov 2019
				 LocalDate jour2=LocalDate.of(2019, 11, 16);
				 LocalDate jour3=LocalDate.of(2019, 11, 17);
				 LocalDate jour4=LocalDate.of(2019, 11, 18);
				 LocalDate jour5=LocalDate.of(2019, 11, 19);
				 LocalDate jour6=LocalDate.of(2019, 11, 20);
				 LocalDate jour7=LocalDate.of(2019, 11, 21);
				 LocalDate jour8=LocalDate.of(2019, 11, 22);
				 LocalDate jour9=LocalDate.of(2019, 11, 23);
				 LocalDate jour10=LocalDate.of(2019, 11, 24);
				 
				 /******************** ON CREE DES HEURES***************************/
				 
				 LocalTime temp1=LocalTime.of(00, 00);
				 LocalTime temp2=LocalTime.of(2, 30);
				 LocalTime temp3=LocalTime.of(4, 30);
				 LocalTime temp4=LocalTime.of(6, 30);
				 LocalTime temp5=LocalTime.of(8, 30);
				 LocalTime temp6=LocalTime.of(10, 30);
				 LocalTime temp7=LocalTime.of(12, 30);
				 LocalTime temp8=LocalTime.of(14, 30);
				 LocalTime temp9=LocalTime.of(16, 30);
				 LocalTime temp10=LocalTime.of(18, 30);
				 LocalTime temp11=LocalTime.of(20, 30);
				 LocalTime temp12=LocalTime.of(22, 30);
				 LocalTime temp13=LocalTime.of(23, 59);
				 
				 
				 /******************** ON FAIT DES PUNCH IN***************************/
				// ---------------jour1---------------
				 infirmier1.punchInForTest(LocalDateTime.of(jour1, temp1));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour1, temp5));
				 infirmier2.punchInForTest(LocalDateTime.of(jour1, temp1));
				 infirmier2.punchOutForTest(LocalDateTime.of(jour1, temp5));
				 
				// ---------------jour2---------------
				 infirmier1.punchInForTest(LocalDateTime.of(jour2, temp2));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour2, temp5));
				 infirmier2.punchInForTest(LocalDateTime.of(jour2, temp1));
				 infirmier2.punchOutForTest(LocalDateTime.of(jour2, temp5));
				// ---------------jour3---------------
				 infirmier1.punchInForTest(LocalDateTime.of(jour3, temp1));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour3, temp5));
				 infirmier1.punchInForTest(LocalDateTime.of(jour3, temp8));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour4, temp5));
				// ---------------jour4---------------
				 infirmier1.punchInForTest(LocalDateTime.of(jour4, temp1));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour4, temp5));
				 infirmier1.punchInForTest(LocalDateTime.of(jour4, temp8));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour5, temp11));
				// ---------------jour6---------------
				 infirmier1.punchInForTest(LocalDateTime.of(jour6, temp1));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour6, temp5));
				 infirmier1.punchInForTest(LocalDateTime.of(jour6, temp8));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour7, temp2));
				// ---------------jour7---------------
				 infirmier1.punchInForTest(LocalDateTime.of(jour7, temp3));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour7, temp9));
				 infirmier1.punchInForTest(LocalDateTime.of(jour7, temp10));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour8, temp5));
				// ---------------jour9---------------
				 infirmier1.punchInForTest(LocalDateTime.of(jour9, temp1));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour9, temp4));
				 infirmier1.punchInForTest(LocalDateTime.of(jour9, temp5));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour9, temp8));
				 infirmier1.punchInForTest(LocalDateTime.of(jour9, temp12));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour10, temp2));
				// ---------------jour10---------------
				 infirmier1.punchInForTest(LocalDateTime.of(jour10, temp2));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour10, temp5));
				 infirmier1.punchInForTest(LocalDateTime.of(jour10, temp6));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour10, temp9));
				 infirmier1.punchInForTest(LocalDateTime.of(jour10, temp10));
				 infirmier1.punchOutForTest(LocalDateTime.of(jour10, temp13));
				 
				/*MyDay myday=new MyDay();
				System.out.println(myday.getDay());
				
				myday.start();
				System.out.println(myday.getStart());
				
				myday.setDay(jour4);//setDayManual(2019, 3, 12);
				System.out.println(myday.getDay());
				
				LocalDateTime debut = LocalDateTime.now();
			      System.out.println("Date et heure courante : " + debut);
			      
			      LocalDateTime fin = LocalDateTime.of
			      
			      Duration dure=Duration.between(debut, fin);
			      
			      System.out.println("debut: "+ debut+ "fin :"+fin+"Duree : " + dure.toMinutes());*/
			      
			      
			      return maCompagnie;
	}
	

}
