package Interface;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controleur.ControleurAcceuil;
import Interface.AbsInterfaceContainer;
import GESTOT_Ressources.*;
import java.awt.event.*;
import Kevin.Code.*;
import Interface.AcceuilGUI;

public class AcceuilGUI extends AbsInterfaceContainer {
  private static final long serialVersionUID = 1L;

  ControleurAcceuil controleurAcceuil;
  private static int count = 0;

  private JPasswordField passwordField = new JPasswordField();
  
  private SearchName searchName = new SearchName();

  private JLabel logInErrorLabel = new JLabel();
  private JLabel contacter = new JLabel("Contacter le superviseur");
  private JLabel forgetPassLabel = new JLabel("Mot de passe oublier? ");

  private JButton punchButton = new JButton("Punch In");
  private JButton loginButton = new JButton("Session");

  public static void main(String[] args) {

    // Systeme.restaureCompany();
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
    AcceuilGUI acceuilGUI = new AcceuilGUI(fenetre.getSize());
    fenetre.add(acceuilGUI);
    fenetre.setVisible(true);

  }

  /*************************** Constructeur ****************************/
  public AcceuilGUI(Dimension dimension) {
    controleurAcceuil = new ControleurAcceuil(this);
    this.setInteractions(dimension);
  }

  public void creerFenetre(Dimension dimension) {

    this.setLayout(null);
    Insets insets = this.getInsets();

    Color leftColor = new Color(102, 255, 102);
    Color rightColor = new Color(51, 153, 255);
    Color whiteColor = new Color(255, 255, 255);

    TitledBorder passBorder;
    passBorder = BorderFactory.createTitledBorder("Entrer mot de passe");

    BackgroundPanel leftPanel = new BackgroundPanel();
    leftPanel.setLayout(null);

    leftPanel.setPreferredSize(dimension);
    var sizeLeft = leftPanel.getPreferredSize();
    leftPanel.setBounds(insets.left, insets.top, (int) sizeLeft.getWidth(), (int) sizeLeft.getHeight());
    this.add(leftPanel);
    Insets leftInsets = leftPanel.getInsets();

    // Set the WelcomeText area
    JLabel welcomLabel = new JLabel("Bienvenue");
    welcomLabel.setFont(new Font("Monaco", Font.PLAIN, 50));
    welcomLabel.setOpaque(false);
    welcomLabel.setForeground(Color.WHITE);
    leftPanel.add(welcomLabel);
    welcomLabel.setPreferredSize(new Dimension(leftPanel.getWidth(), 50));

    var sizeTextArea = welcomLabel.getPreferredSize();
    welcomLabel.setBounds(375 + leftInsets.left, 100 + leftInsets.top, (int) sizeTextArea.getWidth() - 350,
        (int) sizeTextArea.getHeight());

    // Set the SearchName
    searchName = new SearchName(new Dimension(leftPanel.getWidth() - 400, 350));
    var sizeSearchName = searchName.getPreferredSize();
    searchName.setBounds(200 + leftInsets.left, 200 + leftInsets.top, (int) sizeSearchName.getWidth(),
        (int) sizeSearchName.getHeight());
    leftPanel.add(searchName);

    //set The passWordField
    passwordField.setBackground(whiteColor);
    passwordField.setBorder(passBorder);
    leftPanel.add(passwordField);
    passwordField.setPreferredSize(new Dimension(leftPanel.getWidth(), 50));
    var sizepasswordField = passwordField.getPreferredSize();
    passwordField.setBounds(200 + leftInsets.left, 560 + leftInsets.top, (int) sizepasswordField.getWidth() - 400,
        (int) sizepasswordField.getHeight());

    //set The Punch button
    punchButton.setBackground(leftColor);
    punchButton.setForeground(Color.white);
    leftPanel.add(punchButton);
    punchButton.setPreferredSize(new Dimension(100, 30));
    var sizePunch = punchButton.getPreferredSize();
    punchButton.setBounds(200 + leftInsets.left, 620 + leftInsets.top, (int) sizePunch.getWidth(),
        (int) sizePunch.getHeight());

    //set The Login button
    loginButton.setBackground(rightColor);
    loginButton.setForeground(Color.white);
    leftPanel.add(loginButton);
    loginButton.setPreferredSize(new Dimension(100, 30));
    var sizeLogin = loginButton.getPreferredSize();
    loginButton.setBounds(310 + leftInsets.left, 620 + leftInsets.top, (int) sizeLogin.getWidth(),
        (int) sizeLogin.getHeight());

    //set The error label
    logInErrorLabel.setForeground(Color.RED);
    leftPanel.add(logInErrorLabel);
    logInErrorLabel.setPreferredSize(new Dimension(leftPanel.getWidth(), 20));
    var sizeErrorLabel = logInErrorLabel.getPreferredSize();
    logInErrorLabel.setBounds(200 + leftInsets.left, 660 + leftInsets.top, (int) sizeErrorLabel.getWidth(),
        (int) sizeErrorLabel.getHeight());

    //set The forgetPassLabel label
    forgetPassLabel.setForeground(Color.WHITE);
    leftPanel.add(forgetPassLabel);
    forgetPassLabel.setPreferredSize(new Dimension(leftPanel.getWidth(), 20));
    var sizeForgetPassLabel = forgetPassLabel.getPreferredSize();
    forgetPassLabel.setBounds(200 + leftInsets.left, 680 + leftInsets.top, (int) sizeForgetPassLabel.getWidth(), 100);

    //Add the panel
    leftPanel.add(contacter);
    contacter.setForeground(Color.BLUE);
    contacter.setBounds(335 + leftInsets.left, 680 + leftInsets.top, (int) sizeForgetPassLabel.getWidth(), 100);

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

  public void setInteractions(Dimension dimension) {

    creerFenetre(dimension);

    getPunchButton().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        if (!getEmployerJList().isSelectionEmpty()) {

          if (!controleurAcceuil.punchInout(getEmployerJList().getSelectedValue(), getPasswordField().getText())) {
            getLogInErrorLabel().setText("Le nom d'utilisateur ou le mot de passe est incorrect");
          }
          else{
            controleurAcceuil.changeButton();
          }
        }
        else{
          getLogInErrorLabel().setText("Veuillez selectionner un nom");
        }
      }
    });

    getSearchBarField().addKeyListener(prediction());

    getPasswordField().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
      }
    });

    getLoginButton().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!getEmployerJList().isSelectionEmpty()) {
          if(!controleurAcceuil.ouvrirSession(getEmployerJList().getSelectedValue(), getPasswordField().getText())){
            getLogInErrorLabel().setText("Le nom d'utilisateur ou le mot de passe est incorrect");
          }
        } else {
          getLogInErrorLabel().setText("Veuillez selectionner un nom");
        }
      }
    });

    getEmployerJList().addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        controleurAcceuil.changeButton();
      }
    });

    
  }

  public JButton getPunchButton() {
    return punchButton;
  }

  public JButton getLoginButton() {
    return loginButton;
  }

  public JLabel getLogInErrorLabel() {
    return logInErrorLabel;
  }

  public JTextField getSearchBarField() {
    return searchName.getSearchBarField();
  }

  public JPasswordField getPasswordField() {
    return passwordField;
  }

  public JList<Employer> getEmployerJList() {
    return searchName.getEmployerJList();
  }

  public JScrollPane getScrollPane() {
    return searchName.getScrollPane();
  }

}