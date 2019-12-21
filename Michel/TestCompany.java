package Michel;

import Kevin.Code.*;

import java.time.*;

public class TestCompany {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/****************** ON CREE UNE COMPAGNIE ***********************/
		Company maCompagnie = new Company();

		/**********************
		 * ON CREE DES EMPLOY�S DE LA COMPAGNIE
		 ***********************/

		Employer infirmier1 = new Infirmier("Infirmiere Num1");
		maCompagnie.addWorker(infirmier1);

		Employer infirmier2 = new Infirmier("Infirmiere Num2");
		maCompagnie.addWorker(infirmier2);

		Employer infirmier3 = new Infirmier("Infirmiere Num3");
		maCompagnie.addWorker(infirmier3);

		Employer infirmier4 = new Infirmier("Infirmiere Num4");
		maCompagnie.addWorker(infirmier4);

		Employer infirmier5 = new Infirmier("Infirmiere Num5");
		maCompagnie.addWorker(infirmier5);

		Employer superviseur1 = new Superviseur("Siperviseur Num1");
		maCompagnie.addWorker(superviseur1);

		Superviseur manager = new Superviseur("Manager");

		/********************************************************/

		/******************** ON CREE DES DATES ***************************/
		LocalDate jour1 = LocalDate.of(2019, 11, 15);// 15 nov 2019
		LocalDate jour2 = LocalDate.of(2019, 11, 16);
		LocalDate jour3 = LocalDate.of(2019, 11, 17);
		LocalDate jour4 = LocalDate.of(2019, 11, 18);
		LocalDate jour5 = LocalDate.of(2019, 11, 19);
		LocalDate jour6 = LocalDate.of(2019, 11, 20);
		LocalDate jour7 = LocalDate.of(2019, 11, 21);

		/******************** ON FAIT DES PUNCH IN ***************************/

		MyDay myday = new MyDay();
		System.out.println(myday.getDay());

		myday.start();
		System.out.println(myday.getStart());

		myday.setDay(jour4);// setDayManual(2019, 3, 12);
		System.out.println(myday.getDay());

		LocalDateTime debut = LocalDateTime.now();
		System.out.println("Date et heure courante : " + debut);

		LocalDateTime fin = LocalDateTime.of(2019, 10, 15, 20, 30);

		Duration dure = Duration.between(debut, fin);

		System.out.println("debut: " + debut + "fin :" + fin + "Duree : " + dure.toMinutes());

	}

}
