package Interface;
import Controleur.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class FenetreHoraire extends AbsInterfaceContainer {
	//------------------MES INSTANCES DE CLASSE------------------------
		private JPanel barMenu;
		private JPanel panelIntervalePeriode;
		private JPanel panelAffichagePeriode;
		private JPanel contenuAffichagePeriode;
		private JPanel panelCentral;
		private JScrollPane scrollPane;
		private JLabel etiquetteTotalHeure;
		private JLabel etiquetteNomEmployer;
		private JLabel etiquettePrenomEmployer;
		private JLabel etiquetteIdEmployer;
		
		/* Mes boutons*/
		private Button boutPunchOutHoraire;
		private Button boutQuitterHoraire;
		private Button boutValiderPeriode;
		
		/*Mes dates*/
		private JComboBox jourIn;
		private JComboBox moisIn;
		private JComboBox anneeIn;
		private JComboBox jourOut;
		private JComboBox moisOut;
		private JComboBox anneeOut;
		
		/* liste Horaire*/
		private Vector<JPanel> listeHoraire=new Vector<JPanel>(); // representre la liste de tous les labels des horaire de l'employé
		
		private int lX;
		private int lY;
		
	//-------------MES SETTERS ET GETTERS---------------------------

		
		public JPanel getBarMenu() {
			return barMenu;
		}
		public void setBarMenu(JPanel barMenu) {
			this.barMenu = barMenu;
		}
		public JPanel getPanelIntervalePeriode() {
			return panelIntervalePeriode;
		}
		public void setPanelIntervalePeriode(JPanel panelIntervalePeriode) {
			this.panelIntervalePeriode = panelIntervalePeriode;
		}
		public JPanel getPanelAffichagePeriode() {
			return panelAffichagePeriode;
		}
		public void setPanelAffichagePeriode(JPanel panelAffichagePeriode) {
			this.panelAffichagePeriode = panelAffichagePeriode;
		}
		
		
		public JPanel getContenuAffichagePeriode() {
			return contenuAffichagePeriode;
		}
		public void setContenuAffichagePeriode(JPanel contenuAffichagePeriode) {
			this.contenuAffichagePeriode = contenuAffichagePeriode;
		}
		public JPanel getPanelCentral() {
			return panelCentral;
		}
		public void setPanelCentral(JPanel panelCentral) {
			this.panelCentral = panelCentral;
		}
		public JScrollPane getScrollPane() {
			return scrollPane;
		}
		public void setScrollPane(JScrollPane scrollPane) {
			this.scrollPane = scrollPane;
		}
		public JLabel getEtiquetteTotalHeure() {
			return etiquetteTotalHeure;
		}
		public void setEtiquetteTotalHeure(JLabel etiquetteTotalHeure) {
			this.etiquetteTotalHeure = etiquetteTotalHeure;
		}
		public JLabel getEtiquetteNomEmployer() {
			return etiquetteNomEmployer;
		}
		public void setEtiquetteNomEmployer(JLabel etiquetteNomEmployer) {
			this.etiquetteNomEmployer = etiquetteNomEmployer;
		}
		public JLabel getEtiquettePrenomEmployer() {
			return etiquettePrenomEmployer;
		}
		public void setEtiquettePrenomEmployer(JLabel etiquettePrenomEmployer) {
			this.etiquettePrenomEmployer = etiquettePrenomEmployer;
		}
		public JLabel getEtiquetteIdEmployer() {
			return etiquetteIdEmployer;
		}
		public void setEtiquetteIdEmployer(JLabel etiquetteIdEmployer) {
			this.etiquetteIdEmployer = etiquetteIdEmployer;
		}
		public Button getBoutPunchOutHoraire() {
			return boutPunchOutHoraire;
		}
		public void setBoutPunchOutHoraire(Button boutPunchOutHoraire) {
			this.boutPunchOutHoraire = boutPunchOutHoraire;
		}
		public Button getBoutQuitterHoraire() {
			return boutQuitterHoraire;
		}
		public void setBoutQuitterHoraire(Button boutQuitterHoraire) {
			this.boutQuitterHoraire = boutQuitterHoraire;
		}
		public Button getBoutValiderPeriode() {
			return boutValiderPeriode;
		}
		public void setBoutValiderPeriode(Button boutValiderPeriode) {
			this.boutValiderPeriode = boutValiderPeriode;
		}
		public JComboBox getJourIn() {
			return jourIn;
		}
		public void setJourIn(JComboBox jourIn) {
			this.jourIn = jourIn;
		}
		public JComboBox getMoisIn() {
			return moisIn;
		}
		public void setMoisIn(JComboBox moisIn) {
			this.moisIn = moisIn;
		}
		public JComboBox getAnneeIn() {
			return anneeIn;
		}
		public void setAnneeIn(JComboBox anneeIn) {
			this.anneeIn = anneeIn;
		}
		public JComboBox getJourOut() {
			return jourOut;
		}
		public void setJourOut(JComboBox jourOut) {
			this.jourOut = jourOut;
		}
		public JComboBox getMoisOut() {
			return moisOut;
		}
		public void setMoisOut(JComboBox moisOut) {
			this.moisOut = moisOut;
		}
		public JComboBox getAnneeOut() {
			return anneeOut;
		}
		public void setAnneeOut(JComboBox anneeOut) {
			this.anneeOut = anneeOut;
		}
		public Vector<JPanel> getListeHoraire() {
			return listeHoraire;
		}
		public void setListeHoraire(Vector<JPanel> listeHoraire) {
			this.listeHoraire = listeHoraire;
		}
		public int getlX() {
			return lX;
		}
		public void setlX(int x) {
			lX = x;
		}
		public int getlY() {
			return lY;
		}
		public void setlY(int y) {
			lY = y;
		}
		
	//---------------MON CONSTRUCTEUR-----------------------------------------------------------
		public FenetreHoraire(int x,int y) {
			lX=x;
			lY=y;
			this.setLayout(null);
			this.setSize(lX, lY);
			addBarMenu();
			addPanelCentral();
			
		}
		
	//------------- MES METHODES----------------------------------------------------------------
		
		public void addPanelCentral() {
			 panelCentral=new JPanel();
			// panelCentral.setLayout(new BoxLayout(panelCentral,  BoxLayout.LINE_AXIS));
			 panelCentral.setLayout(null);
			 panelCentral.setSize(this.getWidth(), this.getHeight()-40);
			 panelCentral.setOpaque(false);
			 
			 this.add(panelCentral);
			 panelCentral.setLocation(0, 40);
			 addPanelIntervalePeriode();
			 addPanelAffichagePeriode();
			 addEttiquette();
		}
		
		public void sessionInfirmier() {
			addPanelIntervalePeriode();
			 addPanelAffichagePeriode();
			 addEttiquette();
		}
		
		public void addEttiquette() {
			int x=panelIntervalePeriode.getWidth();
			int y=30;
			Font font=new Font("lucida bright",Font.BOLD|Font.ITALIC,14 );
			
			JLabel etiquetteNom=new JLabel("Nom: ");
			etiquetteNom.setFont(font);
			etiquetteNom.setForeground(Color.black);
			etiquetteNom.setBounds(5,5,x/5,y);
			panelCentral.add(etiquetteNom); 
			
			JLabel etiquetteId=new JLabel("Identifiant: ");
			etiquetteId.setFont(font);
			etiquetteId.setForeground(Color.black);
			etiquetteId.setBounds(5,y+5,x/3,y);
			panelCentral.add(etiquetteId); 
			
			font=new Font("lucida bright",Font.BOLD|Font.ITALIC,12 );
			etiquetteNomEmployer=new JLabel("--");
			etiquetteNomEmployer.setFont(font);
			etiquetteNomEmployer.setForeground(Color.blue);
			etiquetteNomEmployer.setBounds(5+x/5,5,x*4/5,y);
			panelCentral.add(etiquetteNomEmployer); 
			
			etiquetteIdEmployer=new JLabel("--");
			etiquetteIdEmployer.setFont(font);
			etiquetteIdEmployer.setForeground(Color.blue);
			etiquetteIdEmployer.setBounds(5+x/3,y+5,x*2/3,y);
			panelCentral.add(etiquetteIdEmployer); 
			
			/* etiquetteTotalHeure=new JLabel("--- Hrs"); 
			    etiquetteTotalHeure.setFont(font);
			    etiquetteTotalHeure.setForeground(Color.blue);
			    int xEtiq4=xEtiq2+50;
			    etiquetteTotalHeure.setBounds(xEtiq4,yLabel,x*3/5,hautLabel);
			    etiquetteTotalHeure.setBorder(BorderFactory.createEtchedBorder()); //BorderFactory.createRaisedSoftBevelBorder()
			    panelCentral.add(etiquetteTotalHeure); */
		}
		
		public void addBarMenu() {
			barMenu=new JPanel();
			barMenu.setSize(lX,40);
			barMenu.setBorder(BorderFactory.createEtchedBorder()); //BorderFactory.createRaisedSoftBevelBorder()
			this.add(barMenu);	
			barMenu.setLocation(0, 0);
			barMenu.setLayout(null);
			barMenu.setBackground(Color.lightGray);
			
			boutQuitterHoraire=new Button("Quitter");
			boutQuitterHoraire.setLocation(lX-155, 5);
			barMenu.add(boutQuitterHoraire);
			
			boutPunchOutHoraire=new Button("Punch Out");
			boutPunchOutHoraire.setLocation(lX-(2*155), 5);
			barMenu.add(boutPunchOutHoraire);
			
		}
		
		public void addPanelIntervalePeriode() {
			int x=-10+panelCentral.getWidth()*3/7;
			int y=(panelCentral.getHeight())/3;
			int posX=10;
			int posY=y;
			panelIntervalePeriode=new JPanel();
			panelIntervalePeriode.setSize(x,y);
			panelCentral.add(panelIntervalePeriode);
			panelIntervalePeriode.setLocation(posX, posY);
			panelIntervalePeriode.setOpaque(false);
			
			panelIntervalePeriode.setLayout(new GridLayout(3,1,5,5));
			
			Font font=new Font("lucida bright",Font.BOLD|Font.ITALIC,14 );
			
			JPanel panelDebutDate =new JPanel(); panelDebutDate.setOpaque(false);
			JPanel panelFinDate =new JPanel(); panelFinDate.setOpaque(false);
			
			JLabel debut=new JLabel("Début ");
			JLabel fin=new JLabel("Fin    ");
			debut.setFont(font);
			fin.setFont(font);
			
			jourIn=new JComboBox();
			jourIn.addItem("JJ");
			for(int i=1;i<31;i++) {
				String jour="";
				
				if(i<10) jour="0";
				jour=""+String.valueOf(i);
				jourIn.addItem(jour);
			}
			jourOut=new JComboBox();
			jourOut.addItem("JJ");
			for(int i=1;i<31;i++) {
				String jour="";
				
				if(i<10) jour="0";
				jour=""+String.valueOf(i);
				jourOut.addItem(jour);
			}
			
			moisIn=new JComboBox();
			moisIn.addItem("MM");
			moisIn.addItem("Jan"); moisIn.addItem("Fev"); moisIn.addItem("Mar"); moisIn.addItem("Avr");
			moisIn.addItem("Mai"); moisIn.addItem("Jun"); moisIn.addItem("Jui"); moisIn.addItem("Aou");
			moisIn.addItem("Sep"); moisIn.addItem("Oct"); moisIn.addItem("Nov"); moisIn.addItem("Dec");
			
			
			moisOut=new JComboBox();
			moisOut.addItem("MM");
			moisOut.addItem("Jan"); moisOut.addItem("Fev"); moisOut.addItem("Mar"); moisOut.addItem("Avr");
			moisOut.addItem("Mai"); moisOut.addItem("Jun"); moisOut.addItem("Jui"); moisOut.addItem("Aou");
			moisOut.addItem("Sep"); moisOut.addItem("Oct"); moisOut.addItem("Nov"); moisOut.addItem("Dec");
			
			JPanel panelBout=new JPanel();
			boutValiderPeriode=new Button("Valider");
			//boutValiderPeriode.setLocation(x-160, 2*y+10);
			boutValiderPeriode.setPreferredSize(boutValiderPeriode.getSize());
			panelBout.add(boutValiderPeriode);
			panelBout.setOpaque(false);
			
			
			
			anneeIn=new JComboBox();
			int anneCourante= LocalDate.now().getYear();
			for(int i=2019;i<anneCourante+1;i++)  anneeIn.addItem(""+i);
			anneeIn.setSelectedItem(""+anneCourante);
			
			anneeOut=new JComboBox();
			for(int i=2019;i<anneCourante+1;i++)  anneeOut.addItem(""+i);
			anneeOut.setSelectedItem(""+anneCourante);
			
			panelDebutDate.add(debut); panelDebutDate.add(jourIn); panelDebutDate.add(moisIn);  panelDebutDate.add(anneeIn); 
			panelFinDate.add(fin); panelFinDate.add(jourOut);  panelFinDate.add(moisOut);  panelFinDate.add(anneeOut); 
			
			panelIntervalePeriode.setBorder(BorderFactory.createTitledBorder("Intervalle date")); 
			 font=new Font("lucida bright",Font.BOLD|Font.ITALIC,18 );
			panelIntervalePeriode.setFont(font);
			panelIntervalePeriode.setForeground(Color.BLUE);
			
			//panelIntervalePeriode.add(label);
			panelIntervalePeriode.add(panelDebutDate);
			panelIntervalePeriode.add(panelFinDate);
			
			panelIntervalePeriode.add(panelBout);
			//boutValiderPeriode.setMaximumSize(new Dimension(20,20));
			
		}
		
		public void addPanelAffichagePeriode() {
			int hautLabel=30; 
			int x=(panelCentral.getWidth()*4/7)-15; 
			int y=panelCentral.getHeight()-10;  
			int posX=(panelCentral.getWidth()*3/7)+10;
			int posY=5;
			
			/*panel Affichage horaire*/
			panelAffichagePeriode=new JPanel();
			panelAffichagePeriode.setSize(x,y);
			panelAffichagePeriode.setBorder(BorderFactory.createRaisedSoftBevelBorder()); //BorderFactory.createRaisedSoftBevelBorder()
			panelAffichagePeriode.setLocation(posX,posY);
	        panelAffichagePeriode.setLayout(new BoxLayout(panelAffichagePeriode, BoxLayout.PAGE_AXIS));
	        panelAffichagePeriode.setLayout(null);
	        //panelAffichagePeriode.setOpaque(false);
	        panelAffichagePeriode.setBackground(Color.white);
	        
	        /* contenu affichage horaire*/
			contenuAffichagePeriode=new JPanel();
			//contenuAffichagePeriode.setSize(contenuAffichagePeriode.getPreferredSize()); 
			contenuAffichagePeriode.setBorder(BorderFactory.createRaisedSoftBevelBorder());
			contenuAffichagePeriode.setSize(x, y-2*hautLabel); 
			contenuAffichagePeriode.setLayout(null);
			//contenuAffichagePeriode.setOpaque(false);
			contenuAffichagePeriode.setBackground(Color.white);
			
			// ici on ajoute la barre de defilement
						scrollPane = new JScrollPane(contenuAffichagePeriode);
						scrollPane.setSize(x, y-2*hautLabel); 
					    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					    scrollPane.setViewportView(contenuAffichagePeriode);
					    scrollPane.setOpaque(false);
					    scrollPane.getViewport().setOpaque(false);
					    scrollPane.setLocation(0, hautLabel);
		    
		    // ici on ajoutes les etiquetes de l'affichage des heures et total heures
		    Font font=new Font("lucida bright",Font.BOLD|Font.ITALIC,15 );
		    
		    JLabel etiquette1=new JLabel("Quart de travail"); 
		    etiquette1.setFont(font);
		    etiquette1.setForeground(Color.black);
		    etiquette1.setBackground(Color.white);
		    //etiquette1.setBounds((panelCentral.getWidth()*3/7)+20,0,x*3/5,hautLabel);
		   // panelCentral.add(etiquette1);
		    etiquette1.setBounds(20,0,x/2,hautLabel);
		    panelAffichagePeriode.add(etiquette1);
		    
		    JLabel etiquette2=new JLabel("Nbre heure quart"); 
		    etiquette2.setFont(font);
		    etiquette2.setForeground(Color.black);
		    int xEtiq2=x/2+20;
		    etiquette2.setBounds(xEtiq2,0,x/2,hautLabel);
		    panelAffichagePeriode.add(etiquette2);
		    
		    JLabel etiquette3=new JLabel("Total des heures periode"); 
		    etiquette3.setFont(font);
		    etiquette3.setForeground(Color.black);
		    int yLabel=hautLabel+scrollPane.getHeight();
		    etiquette3.setBounds(0,yLabel,x*3/5,hautLabel);
		    panelAffichagePeriode.add(etiquette3);
		    
		    
		    etiquetteTotalHeure=new JLabel("--- Hrs"); 
		    etiquetteTotalHeure.setFont(font);
		    etiquetteTotalHeure.setForeground(Color.blue);
		    int xEtiq4=xEtiq2+50;
		    etiquetteTotalHeure.setBounds(xEtiq4,yLabel,x*3/5,hautLabel);
		    etiquetteTotalHeure.setBorder(BorderFactory.createEtchedBorder()); //BorderFactory.createRaisedSoftBevelBorder()
		    panelAffichagePeriode.add(etiquetteTotalHeure);
		    
		    
		    
		     panelAffichagePeriode.add(scrollPane);
			 panelCentral.add(panelAffichagePeriode);

		}
		
		public void placerPanelVariable(AbsInterfaceContainer panel) {
			int posX=(panelCentral.getWidth()*3/7)+10;
			int posY=5;
			panel.setBackground(Color.white);
			 panelCentral.add(panel);
			 panel.setLocation(posX, posY);
			
		}
		
		public void viderContenuAffichagePeriode() {
			/* contenu affichage horaire*/
			contenuAffichagePeriode.removeAll();
			contenuAffichagePeriode.setLayout(null);
			contenuAffichagePeriode.repaint();
		}
		
		public JPanel ajoutHoraire(LocalDateTime debutH, LocalDateTime finH, Double totalH) {
			
			Font font=new Font("lucida bright",Font.ITALIC,15 );
			
			JPanel panelH=new JPanel();
			panelH.setSize(panelAffichagePeriode.getWidth(), 50);
			panelH.setLayout(null);
			panelH.setOpaque(false);
			
			JLabel labelDebut=new JLabel("Debut: "+debutH.toString()); 
			panelH.add(labelDebut);
			labelDebut.setFont(font);
			labelDebut.setBounds(0,0, panelH.getWidth()*3/4, panelH.getHeight()/2);
			
			JLabel labelFin=new JLabel("Fin:   "+finH.toString()); 
			panelH.add(labelFin);
			labelFin.setFont(font);
			labelFin.setBounds(0,panelH.getHeight()/2, panelH.getWidth()*3/4, panelH.getHeight()/2);
			
			JLabel labelTotalH=new JLabel(" "+totalH.toString()+"");  
			panelH.add(labelTotalH);
			labelTotalH.setFont(font);
			labelTotalH.setForeground(Color.BLUE);
			labelTotalH.setBounds(panelH.getWidth()*3/4,0, (panelH.getWidth()*1/4), panelH.getHeight());
			
			panelH.setBorder(BorderFactory.createTitledBorder(""));
			return panelH;
			
		}
		
		
		
		public void ajoutLabelHoraire() { // permet d'ajouter les label au panel(a la fenetreHoraire )
			int x=5,y=5;
			int pos=0;
			for(JPanel pan:listeHoraire) {
				contenuAffichagePeriode.add(pan);
				pan.setLocation(x, y+(pos*pan.getHeight()));
				pos++;
			}
			contenuAffichagePeriode.setPreferredSize(new Dimension(contenuAffichagePeriode.getWidth(),contenuAffichagePeriode.getHeight()*(pos+1)));
			
		}
		
		//********** fonction pour tester affichage fenetre*** A SUPPRIMER**********/
		
		public void affichageHoraire(Vector<LocalDateTime> deb,Vector<LocalDateTime> fin,Vector<Double> heures) {
			if(!(deb.size()==fin.size() && fin.size()==heures.size())) new FenetreErreur("Un des noeuds de votre liste de quart de travail est erroné!!!").afficher(FenetreErreur.ERREUR);
			
			Double totalHeure=0.0;
			for(int i=0;i<deb.size();i++) {
				listeHoraire.addElement(ajoutHoraire(deb.elementAt(i),fin.elementAt(i),heures.elementAt(i)));// representre la liste de tous les labels des horaire de l'employé
			    totalHeure+=heures.elementAt(i);
			}
			String total=""+totalHeure;
			etiquetteTotalHeure.setText(total+" Hrs");  
			ajoutLabelHoraire();
			contenuAffichagePeriode.setSize(contenuAffichagePeriode.getPreferredSize()); 
			
			//--------on vide  la liste de label d'horaires------------
			listeHoraire=new Vector<JPanel>();
		}
		
		public void ajoutActionFenetre( AbsControleur controleur) {
			boutValiderPeriode.addActionListener(controleur);
			boutQuitterHoraire.addActionListener(controleur);
			boutPunchOutHoraire.addActionListener(controleur);
			
			boutValiderPeriode.addMouseListener(controleur);
			boutQuitterHoraire.addMouseListener(controleur);
			boutPunchOutHoraire.addMouseListener(controleur);
			
		}
		

	}