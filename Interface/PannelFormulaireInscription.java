package Interface;

import Controleur.*;
import GESTOT_Ressources.Employer;
import GESTOT_Ressources.Infirmier;
import Kevin.Code.Company;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class PannelFormulaireInscription extends AbsInterfaceContainer {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	// ------------------MES INSTANCES DE CLASSE-------------------------
	private JPanel formulaire;
	private JLabel nom;
	private JLabel prenom;
	private JLabel identifiant;
	private JLabel motDePasse;
	private JLabel confirmMotDePasse;
	private JLabel dateDeNaissance;
	private JLabel dateDembauche;
	private JLabel type;
	private JLabel NAS;
	private JLabel numeroBanquaire;
	private JTextField texteNom;
	private JTextField textePrenom;
	private JTextField texteIdentifiant;
	private JPasswordField texteMotDePasse;
	private JPasswordField texteConfirmeMotDePasse;
	private JTextField texteType;
	private JTextField texteNAS;
	private JTextField texteNumeroBanquaire;

	/* Mes dates */
	private JComboBox dateNaissanceJour;
	private JComboBox dateNaissanceMois;
	private JComboBox dateNaissanceAnnee;
	private JComboBox dateDembauchementJour;
	private JComboBox dateDembauchementMois;
	private JComboBox dateDembauchementAnnee;

	/* Button */

	private JButton valider;

	/* Variable pour dimensionner le pannel */

	int x ;
	int y ;
	
	public JPanel getFormulaire() {
		return formulaire;
	}

	public void setFormulaire(JPanel formulaire) {
		this.formulaire = formulaire;
	}

	public JLabel getNom() {
		return nom;
	}

	public void setNom(JLabel nom) {
		this.nom = nom;
	}

	public JLabel getPrenom() {
		return prenom;
	}

	public void setPrenom(JLabel prenom) {
		this.prenom = prenom;
	}

	public JLabel getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(JLabel identifiant) {
		this.identifiant = identifiant;
	}

	public JLabel getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(JLabel motDePasse) {
		this.motDePasse = motDePasse;
	}

	public JLabel getAnneeDeNaissance() {
		return dateDeNaissance;
	}

	public void setAnneeDeNaissance(JLabel anneeDeNaissance) {
		this.dateDeNaissance = anneeDeNaissance;
	}

	public JLabel getDateDembauche() {
		return dateDembauche;
	}

	public void setDateDembauche(JLabel dateDembauche) {
		this.dateDembauche = dateDembauche;
	}

	public JLabel getType() {
		return type;
	}

	public void setType(JLabel type) {
		this.type = type;
	}

	public JLabel getNAS() {
		return NAS;
	}

	public void setNAS(JLabel nAS) {
		NAS = nAS;
	}

	public JLabel getNumeroBanquaire() {
		return numeroBanquaire;
	}

	public void setNumeroBanquaire(JLabel numeroBanquaire) {
		this.numeroBanquaire = numeroBanquaire;
	}

	public JTextField getTexteNom() {
		return texteNom;
	}

	public void setTexteNom(JTextField texteNom) {
		this.texteNom = texteNom;
	}

	public JTextField getTextePrenom() {
		return textePrenom;
	}

	public void setTextePrenom(JTextField textePrenom) {
		this.textePrenom = textePrenom;
	}

	public JTextField getTexteIdentifiant() {
		return texteIdentifiant;
	}

	public void setTexteIdentifiant(JTextField texteIdentifiant) {
		this.texteIdentifiant = texteIdentifiant;
	}

	public JTextField getTexteMotDePasse() {
		return texteMotDePasse;
	}

	public void setTexteMotDePasse(JPasswordField texteMotDePasse) {
		this.texteMotDePasse = texteMotDePasse;
	}

	public JPasswordField getTexteConfirmeMotDePasse() {
		return texteConfirmeMotDePasse;
	}

	public void setTexteConfirmeMotDePasse(JPasswordField texteConfirmeMotDePasse) {
		this.texteConfirmeMotDePasse = texteConfirmeMotDePasse;
	}

	public JTextField getTexteType() {
		return texteType;
	}

	public void setTexteType(JTextField texteType) {
		this.texteType = texteType;
	}

	public JTextField getTexteNAS() {
		return texteNAS;
	}

	public void setTexteNAS(JTextField texteNAS) {
		this.texteNAS = texteNAS;
	}

	public JTextField getTexteNumeroBanquaire() {
		return texteNumeroBanquaire;
	}

	public void setTexteNumeroBanquaire(JTextField texteNumeroBanquaire) {
		this.texteNumeroBanquaire = texteNumeroBanquaire;
	}

	public JComboBox getDateNaissanceJour() {
		return dateNaissanceJour;
	}

	public void setDateNaissanceJour(JComboBox dateNaissanceJour) {
		this.dateNaissanceJour = dateNaissanceJour;
	}

	public JComboBox getDateNaissanceMois() {
		return dateNaissanceMois;
	}

	public void setDateNaissanceMois(JComboBox dateNaissanceMois) {
		this.dateNaissanceMois = dateNaissanceMois;
	}

	public JComboBox getDateNaissanceAnnee() {
		return dateNaissanceAnnee;
	}

	public void setDateNaissanceAnnee(JComboBox dateNaissanceAnnee) {
		this.dateNaissanceAnnee = dateNaissanceAnnee;
	}

	public JComboBox getDateDembauchementJour() {
		return dateDembauchementJour;
	}

	public void setDateDembauchementJour(JComboBox dateDembauchementJour) {
		this.dateDembauchementJour = dateDembauchementJour;
	}

	public JComboBox getDateDembauchementMois() {
		return dateDembauchementMois;
	}

	public void setDateDembauchementMois(JComboBox dateDembauchementMois) {
		this.dateDembauchementMois = dateDembauchementMois;
	}

	public JComboBox getDateDembauchementAnnee() {
		return dateDembauchementAnnee;
	}

	public void setDateDembauchementAnnee(JComboBox dateDembauchementAnnee) {
		this.dateDembauchementAnnee = dateDembauchementAnnee;
	}

	public JLabel getConfirmMotDePasse() {
		return confirmMotDePasse;
	}

	public void setConfirmMotDePasse(JLabel confirmMotDePasse) {
		this.confirmMotDePasse = confirmMotDePasse;
	}

	/*
	 * public Button getValider() { return this.valider; }
	 */

	public void setValider(Button valider) {
		this.valider = valider;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/*-----------------Constructeur----------------------*/


	public PannelFormulaireInscription(Dimension dim) {
		this.setLayout(null);
		this.setPreferredSize(dim);
		
		this.setOpaque(false);
		addFormulaire(this);
		addButton(this, dim);
	}

	/*-----------------Methodes--------------------------*/

	public void addFormulaire(PannelFormulaireInscription panel) {

		/* Label */
		 Font font=new Font("calibri",Font.BOLD,15 );
		 Insets insets = panel.getInsets();

		nom = new JLabel("Nom");
		
		nom.setForeground(Color.black);
		
		nom.setBounds(this.getWidth(), this.getHeight()+ 10, 60, 15);
		panel.add(nom);

		prenom=new JLabel("Prenom");
		
		prenom.setForeground(Color.black);
		prenom.setBounds(this.getWidth(), this.getHeight() + 50, 60, 15);

		identifiant=new JLabel("Identifiant");
		
		identifiant.setForeground(Color.black);
		identifiant.setBounds(this.getWidth(), this.getHeight() + 90, 60, 15);

		motDePasse=new JLabel("Mot de passe");
		
		motDePasse.setForeground(Color.black);
		motDePasse.setBounds(this.getWidth(), this.getHeight() + 130, 80, 20);

		confirmMotDePasse=new JLabel("Confirmer Mot de passe");
		
		confirmMotDePasse.setForeground(Color.black);
		confirmMotDePasse.setBounds(this.getWidth(), this.getHeight() + 170, 160, 20);

		dateDeNaissance=new JLabel("Date de Naissance");
		
		dateDeNaissance.setForeground(Color.black);
		dateDeNaissance.setBounds(this.getWidth(), this.getHeight() + 330, 140, 20);

		dateDembauche=new JLabel("Date d'embauche");
		
		dateDembauche.setForeground(Color.black);
		dateDembauche.setBounds(this.getWidth(), this.getHeight() + 370, 140, 20);

		type=new JLabel("Type de personnel");
		
		type.setForeground(Color.black);
		type.setBounds(this.getWidth(), this.getHeight() + 290, 140, 15);

		NAS=new JLabel("NAS");
		
		NAS.setForeground(Color.black);
		NAS.setBounds(this.getWidth(),this.getHeight() + 210, 80, 15);

		numeroBanquaire=new JLabel("Numero de Compte");
		
		numeroBanquaire.setForeground(Color.black);
		numeroBanquaire.setBounds(this.getWidth(), this.getHeight() + 250, 140, 20);

		/*Les TextFields*/
		texteNom = new JTextField();
		texteNom.setBounds(this.getWidth() + 70, this.getHeight()+ 10, 100, 15);
		textePrenom = new JTextField();
		textePrenom.setBounds(this.getWidth() + 70, this.getHeight() + 50, 100, 15);
		texteIdentifiant = new JTextField();
		texteIdentifiant.setBounds(this.getWidth() + 70, this.getHeight() + 90, 100, 15);
		texteMotDePasse = new JPasswordField();
		texteMotDePasse.setBounds(this.getWidth() + 90, this.getHeight() + 130, 100, 15);
		texteConfirmeMotDePasse = new JPasswordField();
		texteConfirmeMotDePasse.setBounds(this.getWidth() + 170, this.getHeight() + 170, 100, 15);
		texteType = new JTextField();
		texteType.setBounds(this.getWidth() + 150, this.getHeight() + 290, 100, 15);
		texteNAS = new JTextField();
		texteNAS.setBounds(this.getWidth() + 90, this.getHeight() + 210, 100, 15);
		texteNumeroBanquaire = new JTextField();
		texteNumeroBanquaire.setBounds(this.getWidth() + 150, this.getHeight() + 250, 100, 15);

		/*Les ComboBox */
		dateNaissanceJour=new JComboBox();
		dateNaissanceJour.addItem("JJ");
		for(int i=1;i<=31;i++) {
		String jour="";

		if(i<10) jour="0";
		jour=""+String.valueOf(i);
		dateNaissanceJour.addItem(jour);
		}
		dateNaissanceJour.setBounds(this.getWidth() +150, this.getHeight() + 330, 40, 30);

		dateDembauchementJour=new JComboBox();
		dateDembauchementJour.addItem("JJ");
		for(int i=1;i<=31;i++) {
		String jour="";

		if(i<10) jour="0";
		jour=""+String.valueOf(i);
		dateDembauchementJour.addItem(jour);
		}
		dateDembauchementJour.setBounds(this.getWidth() +150, this.getHeight() + 370, 40, 30);

		String [] items = {"MM",
		"Jan","Fev","Mar","Avr","Mai","Jun","Jui","Aou","Sep","Oct","Nov","Dec"};
		dateNaissanceMois=new JComboBox(items);
		dateNaissanceMois.setBounds(this.getWidth() +190, this.getHeight() + 330, 45, 30);

		dateDembauchementMois=new JComboBox(items);
		dateDembauchementMois.setBounds(this.getWidth() +190, this.getHeight() + 370, 45, 30);

		dateDembauchementAnnee=new JComboBox();
		int anneCourante= LocalDate.now().getYear();
		for(int i=2019;i<anneCourante+1;i++) dateDembauchementAnnee.addItem(""+i);
		dateDembauchementAnnee.setBounds(this.getWidth() + 235, this.getHeight() + 370, 50, 30);

		dateNaissanceAnnee=new JComboBox();
		for(int i=1940;i<anneCourante+1;i++) dateNaissanceAnnee.addItem(""+i);
		dateNaissanceAnnee.setBounds(this.getWidth() +235, this.getHeight() + 330, 50, 30);

		panel.add(nom);
		panel.add(prenom);
		panel.add(identifiant);
		panel.add(motDePasse);
		panel.add(dateDeNaissance);
		panel.add(dateDembauche);
		panel.add(type);
		panel.add(NAS);
		panel.add(numeroBanquaire);
		panel.add(confirmMotDePasse);
		panel.add(dateNaissanceJour);
		panel.add(dateDembauchementJour);
		panel.add(dateNaissanceMois);
		panel.add(dateDembauchementMois);
		panel.add(dateDembauchementAnnee);
		panel.add(dateNaissanceAnnee);
		panel.add(texteNom);
		panel.add(textePrenom);
		panel.add(texteIdentifiant);
		panel.add(texteMotDePasse);
		panel.add(texteConfirmeMotDePasse);
		panel.add(texteType);
		panel.add(texteNAS);
		panel.add(texteNumeroBanquaire);

	}

	void addButton(PannelFormulaireInscription panel, Dimension dim) {

		valider = new JButton("Valider");
		valider.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showConfirmDialog(null, "Enregistrement reussi");
			}
		});
		valider.setBounds(dim.width/2, (dim.height/2) + 20, 80, 20);
		panel.add(valider);
	}

	public static void main(String[] args) {

		JFrame fenetre = new JFrame();
		fenetre.setTitle("pannel Eric");
		fenetre.setSize(400, 800);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PannelFormulaireInscription formulaire = new PannelFormulaireInscription(fenetre.getSize());
		fenetre.add(formulaire);
		fenetre.setVisible(true);
	}

}
