package Kevin.Tests;
import java.time.LocalDate;
import java.time.LocalDateTime;

import Kevin.Code.MyDay;

public class testMyDay {
    public static void main(String args[]){

        MyDay jour1 = new MyDay(); 
        MyDay jour2 = new MyDay();
        MyDay jour3 = new MyDay();

        System.out.println("Test de jour 1");

        System.out.println("");
        System.out.println("la journee de travail: "+ jour1.getDay() + " le debut: " + jour1.getStart() + " la fin: " + jour1.getEnd());

        jour2.setDay(LocalDate.now());
        jour2.start();
        jour2.end();

        System.out.println("");
        System.out.println("Test de jour 2");

        System.out.println("la journee de travail: "+ jour2.getDay() + " le debut: " + jour2.getStart() + " la fin: " + jour2.getEnd());
        System.out.println("la duree travailler est de : "+ jour2.calculerHoraire() + " heures");

        jour3.setDay(LocalDate.now());
        jour3.setStart(LocalDateTime.now());
        jour3.setEnd(LocalDateTime.of(2019, 10, 16, 18, 15));


        System.out.println("");
        System.out.println("Test de jour 3");

        System.out.println("la journee de travail: "+ jour3.getDay() + " le debut: " + jour3.getStart() + " la fin: " + jour3.getEnd());
        System.out.println("la duree travailler est de : "+ jour3.calculerHoraire() + " heures");

    }
}