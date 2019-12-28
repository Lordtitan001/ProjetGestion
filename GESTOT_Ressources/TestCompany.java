package GESTOT_Ressources;
import Kevin.Code.*;
import Interface.*;
import Controleur.*;

import java.time.*;
import javax.swing.*;

import javax.swing.JFrame;



public class TestCompany {
	
	

	public static void main(String[] args) {
		
		/******************  ON CREE UNE COMPAGNIE ***********************/
		 Company maCompagnie= creationCompany();

		JFrame fenetre= new JFrame();
		FenetreHoraire fene=new FenetreHoraire();
		
		// dimension de notre fenetre
		fenetre.setSize(715, 640);
				 //position de notre fenetre
		fenetre.setLocationRelativeTo(null);
			    //femeture du procesus a la femeture de la fenetre
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    // pour positionner notre fenetre sur l'ecran
		fenetre.setLocation(100, 50);
			    //pour permetre ou nons a l,utilisateur de redimentinner notre fenetre
		fenetre.setResizable(false);
			    // pour garder la fenetre toujours au premier plan
		fenetre.setAlwaysOnTop(false);
		
		fenetre.add(fene);
		fenetre.setVisible(true);
		
		
		Employer employe= maCompagnie.getWorkers().get("Emp1");
	//	System.out.println("---***----*****-----****-----*****-----****-----*****----****-----****----");
		AbsControleur controleurHoraire=new ControleurFeneHoraire(fene, employe);
	      
	}
	
	public static Company creationCompany() {
		// TODO Auto-generated method stub
		 
		/******************  ON CREE UNE COMPAGNIE ***********************/
		 Company maCompagnie=new Company();
						 
				 /**********************  ON CREE DES EMPLOYÉS DE LA COMPAGNIE***********************/
				 
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
				 
				 Employer superviseur1=new Superviseur("Siperviseur Num1");
				 maCompagnie.addWorker(superviseur1);
				 
				 Employer manager=new Superviseur("Manager");
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
				 
				 /******************** ON CREE DES HEURES***************************/
				 
				 LocalTime temp1=LocalTime.of(7, 30);
				 LocalTime temp2=LocalTime.of(9, 30);
				 LocalTime temp3=LocalTime.of(11, 30);
				 LocalTime temp4=LocalTime.of(13, 30);
				 LocalTime temp5=LocalTime.of(15, 30);
				 LocalTime temp6=LocalTime.of(17, 30);
				 LocalTime temp7=LocalTime.of(19, 30);
				 LocalTime temp8=LocalTime.of(21, 30);
				 LocalTime temp9=LocalTime.of(23, 30);
				 LocalTime temp10=LocalTime.of(01, 30);
				 LocalTime temp11=LocalTime.of(03, 30);
				 LocalTime temp12=LocalTime.of(05, 30);
				 LocalTime temp13=LocalTime.of(07, 30);
				 
				 
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
				 infirmier1.punchOutForTest(LocalDateTime.of(jour4, temp13));
				 
				
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
