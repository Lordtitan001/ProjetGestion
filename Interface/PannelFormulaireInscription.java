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


	public PannelFormulaireInscription(int x, int y) {
		this.setLayout(null);
		//this.x = x;
		//this.y = y;
		//this.setSize(this.x, this.y);
		// this.setOpaque(false);
		// this.setBackground(Color.YELLOW);
		addFormulaire(this);
		// addButton();
	}

	/*-----------------Methodes--------------------------*/

	public void addFormulaire(PannelFormulaireInscription panel) {

		/* Label */
		 Font font=new Font("calibri",Font.BOLD,15 );
		 Insets insets = panel.getInsets();

		nom = new JLabel("Nom");
		//nom.setFont(font);
		nom.setForeground(Color.black);
		
		nom.setBounds(insets.left, insets.top, 60, 10);
		panel.add(nom);

		prenom=new JLabel("Prenom");
		prenom.setFont(font);
		prenom.setForeground(Color.black);
		prenom.setBounds(insets.left, insets.top + 20, 20, 5);

		identifiant=new JLabel("Identifiant");
		identifiant.setFont(font);
		identifiant.setForeground(Color.black);
		identifiant.setBounds(x/10, 3*(y/10), 20, 5);

		motDePasse=new JLabel("Mot de passe");
		motDePasse.setFont(font);
		motDePasse.setForeground(Color.black);
		motDePasse.setBounds(x/10, 4*(y/10), 20, 5);

		confirmMotDePasse=new JLabel("Confirmer Mot de passe");
		confirmMotDePasse.setFont(font);
		confirmMotDePasse.setForeground(Color.black);
		confirmMotDePasse.setBounds(x/10, 5*(y/10), 20, 5);

		dateDeNaissance=new JLabel(" Date de Naissance");
		dateDeNaissance.setFont(font);
		dateDeNaissance.setForeground(Color.black);
		dateDeNaissance.setBounds(x/10, 9*(y/10), 20, 5);

		dateDembauche=new JLabel("Date d'embauche");
		dateDembauche.setFont(font);
		dateDembauche.setForeground(Color.black);
		dateDembauche.setBounds(x/10, 10*(y/10), 20, 5);

		type=new JLabel("Type de personnel");
		type.setFont(font);
		type.setForeground(Color.black);
		type.setBounds(x/10, 8*(y/10), 20, 5);

		NAS=new JLabel("NAS");
		NAS.setFont(font);
		NAS.setForeground(Color.black);
		NAS.setBounds(x/10, 6*(y/10), 20, 5);

		numeroBanquaire=new JLabel("Numero de Compte");
		numeroBanquaire.setFont(font);
		numeroBanquaire.setForeground(Color.black);
		numeroBanquaire.setBounds(x/10, 7*(y/10), 20, 5);

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

		String [] items = {"MM",
		"Jan","Fev","Mar","Avr","Mai","Jun","Jui","Aou","Sep","Oct","Nov","Dec"};
		dateNaissanceMois=new JComboBox(items);
		dateNaissanceMois.setBounds(3*(x/10) + 5, 9*(y/10), 5, 5);

		dateDembauchementMois=new JComboBox(items);
		dateDembauchementMois.setBounds(3*(x/10) + 5, 10*(y/10), 5, 5);

		dateDembauchementAnnee=new JComboBox();
		int anneCourante= LocalDate.now().getYear();
		for(int i=2019;i<anneCourante+1;i++) dateDembauchementAnnee.addItem(""+i);
		dateDembauchementAnnee.setBounds(3*(x/10) + 10, 9*(y/10), 5, 5);

		dateNaissanceAnnee=new JComboBox();
		for(int i=1940;i<anneCourante+1;i++) dateNaissanceAnnee.addItem(""+i);
		dateDembauchementAnnee.setBounds(3*(x/10) + 10, 10*(y/10), 5, 5);

		panel.add(nom);
		panel.add(prenom);
		// panel.add(identifiant);
		// panel.add(motDePasse);
		// panel.add(dateDeNaissance);
		// panel.add(dateDembauche);
		// panel.add(type);
		// panel.add(NAS);
		// panel.add(numeroBanquaire);
		// panel.add(dateNaissanceJour);
		// panel.add(dateDembauchementJour);
		// panel.add(dateNaissanceMois);
		// panel.add(dateDembauchementMois);
		// panel.add(dateDembauchementAnnee);
		// panel.add(dateNaissanceAnnee);
		// panel.add(texteNom);
		// panel.add(textePrenom);
		// panel.add(texteIdentifiant);
		// panel.add(texteMotDePasse);
		// panel.add(texteConfirmeMotDePasse);
		// panel.add(texteType);
		// panel.add(texteNAS);
		// panel.add(texteNumeroBanquaire);

	}

	void addButton() {

		valider = new JButton("Valider");
		valider.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showConfirmDialog(null, "Enregistrement reussi");
			}
		});

	}

	public static void main(String[] args) {

		JFrame fenetre = new JFrame();
		fenetre.setTitle("pannel Eric");
		fenetre.setSize(400, 800);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PannelFormulaireInscription formulaire = new PannelFormulaireInscription(fenetre.getWidth(),
				fenetre.getHeight());
		fenetre.add(formulaire);
		fenetre.setVisible(true);
	}

}
