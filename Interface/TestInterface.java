package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.*;

import Interface.PannelFormulaireInscription;

public class TestInterface {
	
	public TestInterface() {
		
		addFormulaire();
	}
	
public void addFormulaire() {
		
	 JFrame panel =  new JFrame("pannel Eric");
	 panel.setSize(400, 800);
	
	 panel.setResizable(false);
	 panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 panel.setVisible(true);
	
	 JPanel formulaire;
	 JLabel nom;
	 JLabel prenom;
	 JLabel identifiant;
	 JLabel motDePasse;
	 JLabel confirmMotDePasse;
	 JLabel dateDeNaissance;
	 JLabel dateDembauche;
	 JLabel type;
	 JLabel NAS;
	 JLabel numeroBanquaire;
	 JTextField texteNom;
	 JTextField textePrenom;
	 JTextField texteIdentifiant;
	 JPasswordField texteMotDePasse;
	 JPasswordField texteConfirmeMotDePasse;
	 JTextField texteType;
	 JTextField texteNAS;
	 JTextField texteNumeroBanquaire;
	
	/*Mes dates*/
	 JComboBox dateNaissanceJour;
	 JComboBox dateNaissanceMois;
	 JComboBox dateNaissanceAnnee;
	 JComboBox dateDembauchementJour;
	 JComboBox dateDembauchementMois;
	 JComboBox dateDembauchementAnnee;
	 
	 	int x = 400;
		int y = 800;
	 
		formulaire = new JPanel();
		formulaire.setLayout(null);
		formulaire.setSize(x,y);
		formulaire.setBackground(Color.YELLOW);
		
		
		/*Label*/
		Font font=new Font("calibri",Font.BOLD|Font.ITALIC,15 );
		
		nom=new JLabel("Nom"); 
	    nom.setFont(font);
	    nom.setForeground(Color.black);
	    nom.setBounds(x/10, y/10, 20, 5);
	    nom.setBounds(0,0,20,5);
	    //nom.add(nom);
	    
	    prenom=new JLabel("Prenom"); 
	    prenom.setFont(font);
	    prenom.setForeground(Color.black);
	    prenom.setBounds(x/10, 2*(y/10), 20, 5);
	    //prenom.add(prenom);
	    
	    identifiant=new JLabel("Identifiant"); 
	    identifiant.setFont(font);
	    identifiant.setForeground(Color.black);
	    identifiant.setBounds(x/10, 3*(y/10), 20, 5);
	    //identifiant.add(identifiant);
	    
	    motDePasse=new JLabel("Mot de passe"); 
	    motDePasse.setFont(font);
	    motDePasse.setForeground(Color.black);
	    motDePasse.setBounds(x/10, 4*(y/10), 20, 5);
	    //motDePasse.add(motDePasse);
	    
	    confirmMotDePasse=new JLabel("Confirmer Mot de passe"); 
	    confirmMotDePasse.setFont(font);
	    confirmMotDePasse.setForeground(Color.black);
	    confirmMotDePasse.setBounds(x/10, 5*(y/10), 20, 5);
	    //confirmMotDePasse.add(confirmMotDePasse);
	    
	    dateDeNaissance=new JLabel(" Date de Naissance"); 
	    dateDeNaissance.setFont(font);
	    dateDeNaissance.setForeground(Color.black);
	    dateDeNaissance.setBounds(x/10, 9*(y/10), 20, 5);
	    //dateDeNaissance.add(dateDeNaissance);
	    
	    
	    dateDembauche=new JLabel("Date d'embauche"); 
	    dateDembauche.setFont(font);
	    dateDembauche.setForeground(Color.black);
	    dateDembauche.setBounds(x/10, 10*(y/10), 20, 5);
	    //dateDembauche.add(dateDembauche);
	    
	    type=new JLabel("Type de personnel"); 
	    type.setFont(font);
	    type.setForeground(Color.black);
	    type.setBounds(x/10, 8*(y/10), 20, 5);
	    //type.add(type);
	    
	    NAS=new JLabel("NAS"); 
	    NAS.setFont(font);
	    NAS.setForeground(Color.black);
	    NAS.setBounds(x/10, 6*(y/10), 20, 5);
	    //NAS.add(NAS);
	    
	    numeroBanquaire=new JLabel("Numero de Compte"); 
	    numeroBanquaire.setFont(font);
	    numeroBanquaire.setForeground(Color.black);
	    numeroBanquaire.setBounds(x/10, 7*(y/10), 20, 5);
	    //numeroBanquaire.add(numeroBanquaire);
	    
	    /*Les TextFields*/
	    texteNom = new JTextField();
	    texteNom.setBounds((x/10)+25, y/10, 20, 5);
	    textePrenom = new JTextField();
	    textePrenom.setBounds((x/10)+25, 2*(y/10), 20, 5);
	    texteIdentifiant = new JTextField();
	    texteIdentifiant.setBounds((x/10)+25, 3*(y/10), 20, 5);
	    texteMotDePasse = new JPasswordField();
	    texteMotDePasse.setBounds((x/10)+25, 4*(y/10), 20, 5);
	    texteConfirmeMotDePasse = new JPasswordField();
	    texteConfirmeMotDePasse.setBounds((x/10)+25, 5*(y/10), 20, 5);
	    texteType = new JTextField();
	    texteType.setBounds((x/10)+25, 8*(y/10), 20, 5);
	    texteNAS = new JTextField();
	    texteNAS.setBounds((x/10)+25, 6*(y/10), 20, 5);
	    texteNumeroBanquaire = new JTextField();
	    texteNumeroBanquaire.setBounds((x/10)+25, 7*(y/10), 20, 5);
	    
	    /*Les ComboBox */
	    dateNaissanceJour=new JComboBox();
	    dateNaissanceJour.addItem("JJ");
		for(int i=1;i<31;i++) {
			String jour="";
			
			if(i<10) jour="0";
			jour=""+String.valueOf(i);
			dateNaissanceJour.addItem(jour);
		}
		dateNaissanceJour.setBounds(3*(x/10), 9*(y/10), 5, 5);
		
		dateDembauchementJour=new JComboBox();
		dateDembauchementJour.addItem("JJ");
		for(int i=1;i<31;i++) {
			String jour="";
			
			if(i<10) jour="0";
			jour=""+String.valueOf(i);
			dateDembauchementJour.addItem(jour);
		}
		dateDembauchementJour.setBounds(3*(x/10), 10*(y/10), 5, 5);
		
	    String [] items = {"MM", "Jan","Fev","Mar","Avr","Mai","Jun","Jui","Aou","Sep","Oct","Nov","Dec"};
		dateNaissanceMois=new JComboBox(items);
		dateNaissanceMois.setBounds(3*(x/10) + 5, 9*(y/10), 5, 5);
		
		dateDembauchementMois=new JComboBox(items);
		dateDembauchementMois.setBounds(3*(x/10) + 5, 10*(y/10), 5, 5);
		
		dateDembauchementAnnee=new JComboBox();
		int anneCourante= LocalDate.now().getYear();
		for(int i=2019;i<anneCourante+1;i++)  dateDembauchementAnnee.addItem(""+i);
		dateDembauchementAnnee.setBounds(3*(x/10) + 10, 9*(y/10), 5, 5);
		
		dateNaissanceAnnee=new JComboBox();
		for(int i=1940;i<anneCourante+1;i++)  dateNaissanceAnnee.addItem(""+i);
		dateDembauchementAnnee.setBounds(3*(x/10) + 10, 10*(y/10), 5, 5);
		
		formulaire.add(nom);
		formulaire.add(prenom);
		formulaire.add(identifiant);
		formulaire.add(motDePasse);
		formulaire.add(dateDeNaissance);
		formulaire.add(dateDembauche);
		formulaire.add(type);
		formulaire.add(NAS);
		formulaire.add(numeroBanquaire);
		formulaire.add(dateNaissanceJour);
		formulaire.add(dateDembauchementJour);
		formulaire.add(dateNaissanceMois);
		formulaire.add(dateDembauchementMois);
		formulaire.add(dateDembauchementAnnee);
		formulaire.add(dateNaissanceAnnee);
		formulaire.add(texteNom);
		formulaire.add(textePrenom);
		formulaire.add(texteIdentifiant);
		formulaire.add(texteMotDePasse);
		formulaire.add(texteConfirmeMotDePasse);
		formulaire.add(texteType);
		formulaire.add(texteNAS);
		formulaire.add(texteNumeroBanquaire);
		
		panel.add(formulaire);
		
	}
	
	void addButton() {
		JButton valider;
		valider = new JButton("Valider");
		valider.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showConfirmDialog(null, "Enregistrement reussi");
			}
		});
	
	}
	
public static void main(String[] args) {

	
	/*Button*/
	
	 
	new TestInterface();
	
	/*Variable pour dimensionner le pannel*/
	
	//int x = 400;
	//int y = 800;
		//JFrame panel =  new JFrame("pannel Eric");
		//panel.setSize(400, 800);
		
		//panel.setResizable(false);
		//panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//PannelFormulaireInscription acceuilGUI = new PannelFormulaireInscription(400,800);
		
		
		//panel.setLayout(new BorderLayout());
		//panel.add(acceuilGUI);
		
		//panel.setVisible(true);
	    //acceuilGUI.setInteractions(fenetre);
	    //fenetre.setVisible(true);

	  }

}
