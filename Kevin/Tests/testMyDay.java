package Kevin.Tests;
import Kevin.Code.MyDay;

public class testMyDay {
    public static void main(String args[]){

        MyDay jour1 = new MyDay(); 
        MyDay jour2 = new MyDay();

        System.out.println("Test de jour 1");

        System.out.println("");
        System.out.println("la journee de travail: "+ jour1.getDay() + "le debut: " + jour1.getStart() + " la fin: " + jour1.getEnd());

        jour2.setDay();
        jour2.start();
        jour2.end();

        System.out.println("");
        System.out.println("Test de jour 2");

        System.out.println("la journee de travail: "+ jour2.getDay() + "le debut: " + jour2.getStart() + " la fin: " + jour2.getEnd());
        System.out.println("la duree travailler est de : "+ jour2.calculerHoraire() + " heures");

        
    }
}