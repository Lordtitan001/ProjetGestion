package Kevin.Interface;

import  Interface.Button;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Interface.AbsInterfaceContainer;
import Michel.Employer;

public class AcceuilGUI extends AbsInterfaceContainer {

  private static final long serialVersionUID = 1L;

  private JTextField searchBarField = new JTextField("Nothing here for now");
  private JTextField passwordField = new JTextField("Insert password");

  private JPanel recherchePanel = new JPanel();
  private JPanel logInPanel = new JPanel();
  private JPanel acceuilPanel = new JPanel();
  private JPanel navbarPanel= new JPanel();
  private JPanel loginBoxPanel= new JPanel();
  private JPanel loginVerticalBoxPanel= new JPanel();

  private String spaceString = "               ";
  private JLabel inOutLabel = new JLabel(spaceString+ "Punch In/Out" + spaceString);
  private JLabel logInLabel = new JLabel(spaceString + "Ouvrir Session" + spaceString);
  private JLabel passwordLabel = new JLabel("Mot de Passe", SwingConstants.LEFT);

  private Border loweredLevelBorder = BorderFactory.createLoweredBevelBorder();
  private Border raisedLevelBorder = BorderFactory.createRaisedBevelBorder();
  private Border blackline = BorderFactory.createLineBorder(Color.black);
  private JList<Employer> employerJList = new JList<>();
  private JScrollPane scrollPane  = new JScrollPane(employerJList);

    public void fenetre(JFrame fen){
      //Definition des LayOuts
      recherchePanel.setLayout(new BoxLayout(recherchePanel, BoxLayout.PAGE_AXIS));
      logInPanel.setLayout(new BoxLayout(logInPanel, BoxLayout.PAGE_AXIS));
      acceuilPanel.setLayout(new BoxLayout(acceuilPanel, BoxLayout.LINE_AXIS));
      loginVerticalBoxPanel.setLayout(new BoxLayout(loginVerticalBoxPanel, BoxLayout.PAGE_AXIS));

      //Ajout de la barre de recherche 
      recherchePanel.setBorder(loweredLevelBorder);
      recherchePanel.add(searchBarField);
      //recherchePanel.add(Box.createRigidArea(new Dimension(0, 20)));

      //Ajout de la scrollBar
      scrollPane.setPreferredSize(new Dimension(fen.getWidth() - 100, fen.getHeight() - 80));
      recherchePanel.add(scrollPane);

      //label de punch et de login
      inOutLabel.setBorder(raisedLevelBorder);
      logInLabel.setBorder(raisedLevelBorder);
      navbarPanel.setLayout(new BoxLayout(navbarPanel, BoxLayout.LINE_AXIS));
      navbarPanel.add(inOutLabel);
      navbarPanel.add(logInLabel);
      loginVerticalBoxPanel.add(Box.createRigidArea(new Dimension(fen.getWidth()/2, 200)));
      loginVerticalBoxPanel.add(navbarPanel);
      loginVerticalBoxPanel.add(Box.createRigidArea(new Dimension(fen.getWidth()/2, 50)));

      //ajout de la box pour le login
      loginBoxPanel.setLayout(new BoxLayout(loginBoxPanel, BoxLayout.PAGE_AXIS));
      loginBoxPanel.setBorder(BorderFactory.createRaisedBevelBorder());
      loginBoxPanel.add(passwordLabel);
      loginBoxPanel.add(passwordField);
      loginBoxPanel.add(Box.createRigidArea(new Dimension(fen.getWidth()/2, fen.getHeight()/3)));
      loginVerticalBoxPanel.add(loginBoxPanel);
      loginVerticalBoxPanel.add(new Button("OK"));

      loginVerticalBoxPanel.add(Box.createRigidArea(new Dimension(fen.getWidth()/2, fen.getHeight()/3)));

      loginVerticalBoxPanel.setBackground(Color.lightGray);
      loginVerticalBoxPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 30));
      logInPanel.add(loginVerticalBoxPanel);
      logInPanel.setBackground(Color.LIGHT_GRAY);

      acceuilPanel.add(Box.createRigidArea(new Dimension(30, fen.getHeight())));
      acceuilPanel.add(recherchePanel);
      acceuilPanel.add(logInPanel);
      fen.add(acceuilPanel);

    }


    public static void main(String[] args){

        JFrame fenetre = new JFrame();
        fenetre.setTitle("Acceuil");
        fenetre.setSize(1000, 1000);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        new AcceuilGUI().fenetre(fenetre);
        
        fenetre.setVisible(true);
      }   
}