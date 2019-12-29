package Kevin.Interface;

import Interface.Button;

import java.awt.Dimension;
import java.awt.*;
import java.awt.Graphics;
import java.io.File;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Controleur.ControleurAcceuil;
import Interface.AbsInterfaceContainer;
import Michel.Employer;
import Michel.Infirmier;

import java.awt.event.*;
import Kevin.Code.*;

import Kevin.Interface.AcceuilGUI;

public class AcceuilGUI extends AbsInterfaceContainer {
  private static int count = 0;
  ControleurAcceuil controleurAcceuil;

  private static final long serialVersionUID = 1L;
  private JTextField searchBarField = new JTextField();
  private JPasswordField passwordField = new JPasswordField();

  private JPanel recherchePanel = new JPanel();
  private JPanel logInPanel = new JPanel();
  private JPanel acceuilPanel = new JPanel();
  private JPanel navbarPanel = new JPanel();
  private JPanel loginBoxPanel = new JPanel();
  private JPanel loginVerticalBoxPanel = new JPanel();

  private String spaceString = "                    ";
  private JLabel inOutLabel = new JLabel(spaceString + "Punch In/Out" + spaceString);
  private JLabel logInLabel = new JLabel(spaceString + "Ouvrir Session" + spaceString);
  private JLabel logInErrorLabel = new JLabel("sadsad");
  private JLabel passwordLabel = new JLabel("Mot de Passe", SwingConstants.LEFT);

  private Border loweredLevelBorder = BorderFactory.createLoweredBevelBorder();
  private Border raisedLevelBorder = BorderFactory.createRaisedBevelBorder();
  private JList<Employer> employerJList = new JList<>();
  private JScrollPane scrollPane = new JScrollPane(employerJList);

  private Button okButton = new Button("OK");

  private Image img;

  public static void main(String[] args) {

    //Systeme.restaureCompany();
    Employer infirmier1 = new Infirmier("kevin");
    Employer infirmier2 = new Infirmier("eric");
    Employer infirmier3 = new Infirmier("kev lems");
    Employer infirmier4 = new Infirmier("kev mich");
    Employer infirmier5 = new Infirmier("Infirmiere Num5");
    Company.addWorker(infirmier1);
    Company.addWorker(infirmier2);
    Company.addWorker(infirmier3);
    Company.addWorker(infirmier4);
    Company.addWorker(infirmier5);

    JFrame fenetre = new JFrame();
    fenetre.setTitle("Acceuil");
    fenetre.setSize(1000, 1000);
    fenetre.setLocationRelativeTo(null);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    AcceuilGUI acceuilGUI = new AcceuilGUI();
    acceuilGUI.setInteractions(fenetre);
    fenetre.setVisible(true);

  }

  /*************************** Constructeur ****************************/
  public AcceuilGUI() {
    this.setBackground(Color.RED);
    controleurAcceuil = new ControleurAcceuil(this);
  }

  public void creerFenetre(JFrame fen) {
    // Definition des LayOuts
    recherchePanel.setLayout(new BoxLayout(recherchePanel, BoxLayout.PAGE_AXIS));
    logInPanel.setLayout(new BoxLayout(logInPanel, BoxLayout.PAGE_AXIS));
    acceuilPanel.setLayout(new BoxLayout(acceuilPanel, BoxLayout.LINE_AXIS));
    loginVerticalBoxPanel.setLayout(new BoxLayout(loginVerticalBoxPanel, BoxLayout.PAGE_AXIS));

    // Font and color
    Font bigFont = new Font("Serif", Font.BOLD, 15);
    Font scrollBarFont = new Font("Serif", Font.BOLD, 17);
    Font errorFont = new Font(Font.MONOSPACED, Font.BOLD, 10);
    Color backGroundColor = new Color(81, 180, 255);
    Color selectedColor = new Color(70, 50, 255);

    // Ajout de la barre de recherche
    recherchePanel.add(Box.createRigidArea(new Dimension(0, fen.getHeight() / 4)));
    searchBarField.setBorder(loweredLevelBorder);
    scrollPane.setBorder(loweredLevelBorder);
    searchBarField.setPreferredSize(new Dimension(0, 50));
    searchBarField.setFont(scrollBarFont);
    recherchePanel.add(searchBarField);
    // Ajout de la scrollBar
    scrollPane.setPreferredSize(new Dimension(fen.getWidth() / 2, fen.getHeight() / 2));
    recherchePanel.add(scrollPane);
    recherchePanel.add(Box.createRigidArea(new Dimension(0, fen.getHeight() / 4)));

    // label de punch et de login
    inOutLabel.setFont(bigFont);
    logInLabel.setFont(bigFont);
    inOutLabel.setBorder(raisedLevelBorder);
    logInLabel.setBorder(raisedLevelBorder);
    navbarPanel.setLayout(new BoxLayout(navbarPanel, BoxLayout.LINE_AXIS));
    navbarPanel.add(inOutLabel);
    navbarPanel.add(logInLabel);
    loginVerticalBoxPanel.add(Box.createRigidArea(new Dimension(fen.getWidth() / 2, 200)));
    loginVerticalBoxPanel.add(navbarPanel);
    loginVerticalBoxPanel.add(Box.createRigidArea(new Dimension(fen.getWidth() / 2, 50)));

    // ajout de la box pour le login
    loginBoxPanel.setBackground(Color.WHITE);
    loginBoxPanel.setLayout(new BoxLayout(loginBoxPanel, BoxLayout.PAGE_AXIS));
    loginBoxPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    loginBoxPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    passwordLabel.setFont(bigFont);
    passwordLabel.setPreferredSize(new Dimension(10, 30));
    loginBoxPanel.add(passwordLabel);
    passwordField.setPreferredSize(new Dimension(10, 50));
    loginBoxPanel.add(passwordField);
    logInErrorLabel.setFont(errorFont);
    logInErrorLabel.setForeground(Color.RED);
    // logInErrorLabel.setVisible(false);
    loginBoxPanel.add(Box.createRigidArea(new Dimension(0, 200)));
    loginBoxPanel.add(logInErrorLabel);
    loginVerticalBoxPanel.add(loginBoxPanel);
    loginVerticalBoxPanel.add(okButton);

    loginVerticalBoxPanel.add(Box.createRigidArea(new Dimension(fen.getWidth() / 2, fen.getHeight() / 4)));
    loginVerticalBoxPanel.setBackground(backGroundColor);
    loginVerticalBoxPanel.setBorder(BorderFactory.createLineBorder(backGroundColor, 60));

    logInPanel.add(loginVerticalBoxPanel);
    try {
      img = ImageIO.read(new File("Kevin/Interface/background.jpg"));
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("image not Found");
    }

    // acceuilPanel.add(Box.createRigidArea(new Dimension(30, fen.getHeight())));
    // acceuilPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4));
    acceuilPanel.add(recherchePanel);
    acceuilPanel.add(logInPanel);
    fen.add(acceuilPanel);

  }

  public KeyListener prediction() {
    KeyListener listener = new KeyListener() {
      Node currentNode = controleurAcceuil.getCompany().getNomEmployerNode();
      Node lastNode = currentNode.clone();

      @Override
      public void keyPressed(KeyEvent event) {

        if (event.getKeyCode() != KeyEvent.VK_CAPS_LOCK && event.getKeyCode() != KeyEvent.VK_SHIFT) {
          if (event.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (currentNode == null) {
              count--;
              if (count < 1) {
                currentNode = lastNode.clone();
                count = 0;
              }
              if (currentNode != null) {
                controleurAcceuil.afficherListeEmployers(currentNode.getListeEmployers());
              }
            } else if (currentNode != null) {
              if (currentNode.getParent() != null) {
                currentNode = currentNode.getParent();
                lastNode = currentNode.clone();
                controleurAcceuil.afficherListeEmployers(currentNode.getListeEmployers());
              }
            }
          } else if (currentNode != null) {
            currentNode = currentNode.nextChild(event.getKeyChar());
            if (currentNode != null) {
              lastNode = currentNode.clone();
              controleurAcceuil.afficherListeEmployers(currentNode.getListeEmployers());
            } else {
              count++;
            }
          } else {
            count++;
          }
        }
      }
    
      @Override
      public void keyReleased(KeyEvent event) {
      }

      @Override
      public void keyTyped(KeyEvent event) {

      }
    };
    return listener;
  }

  

  public void setInteractions(JFrame fenetre) {

    getOkButton().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        if (!getEmployerJList().isSelectionEmpty()) {

          if(!controleurAcceuil.punchInout(getEmployerJList().getSelectedValue(), getPasswordField().getText())){
            getLogInErrorLabel().setText("User name or password is not correct");
          }
        }
      }
    });

    getSearchBarField().addKeyListener(prediction());

    getPasswordField().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
      }
    });

    creerFenetre(fenetre);
  }

  public JLabel getLogInErrorLabel() {
    return logInErrorLabel;
  }

  public void paintComponent(Graphics g) {
    // Draws the img to the BackgroundPanel.
    g.drawImage(img, 0, 0, null);
  }

  public Button getOkButton() {
    return okButton;
  }

  public JTextField getSearchBarField() {
    return searchBarField;
  }

  JPasswordField getPasswordField() {
    return passwordField;
  }

  public JLabel getInOutLabel() {
    return inOutLabel;
  }

  public JLabel getLogInLabel() {
    return logInLabel;
  }

  public JList<Employer> getEmployerJList() {
    return employerJList;
  }

  public JScrollPane getScrollPane() {
    return scrollPane;
  }

}