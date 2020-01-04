package Interface;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import Controleur.ControleurAcceuil;
import Interface.AbsInterfaceContainer;
import GESTOT_Ressources.*;
import java.awt.event.*;
import Kevin.Code.*;
import Interface.AcceuilGUI;

public class AcceuilGUI extends AbsInterfaceContainer {
  private static int count = 0;
  ControleurAcceuil controleurAcceuil;

  private static final long serialVersionUID = 1L;
  private JTextField searchBarField = new JTextField();
  private JPasswordField passwordField = new JPasswordField();

  private JLabel logInErrorLabel = new JLabel();
  private JLabel contacter = new JLabel("Contacter le superviseur");
  private JLabel forgetPassLabel = new JLabel("Mot de passe oublier? ");

  private JList<Employer> employerJList = new JList<>();
  private JScrollPane scrollPane = new JScrollPane(employerJList);

  private JButton punchButton = new JButton("Punch");
  private JButton loginButton = new JButton("Session");

  private Image img;

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

    AcceuilGUI acceuilGUI = new AcceuilGUI();
    acceuilGUI.setInteractions(fenetre);
    fenetre.setVisible(true);

  }

  /*************************** Constructeur ****************************/
  public AcceuilGUI() {
    controleurAcceuil = new ControleurAcceuil(this);
  }

  public void creerFenetre(JFrame fen) {

    JPanel panel = new JPanel();
    panel.setLayout(null);
    Insets insets = panel.getInsets();

    Color leftColor = new Color(102, 255, 102);
    Color rightColor = new Color(51, 153, 255);
    Color whiteColor = new Color(255, 255, 255);

    TitledBorder nameBorder;
    nameBorder = BorderFactory.createTitledBorder("Entrer le nom");

    TitledBorder passBorder;
    passBorder = BorderFactory.createTitledBorder("Entrer mot de passe");

    testInterface leftPanel = new testInterface();
    leftPanel.setLayout(null);

    leftPanel.setPreferredSize(new Dimension(fen.getWidth(), fen.getHeight()));
    var sizeLeft = leftPanel.getPreferredSize();
    leftPanel.setBounds(insets.left, insets.top, (int) sizeLeft.getWidth(), (int) sizeLeft.getHeight());
    panel.add(leftPanel);
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

    // Set the TextFiel
    searchBarField.setBorder(nameBorder);
    searchBarField.setBackground(whiteColor);
    leftPanel.add(searchBarField);
    searchBarField.setPreferredSize(new Dimension(leftPanel.getWidth(), 50));
    var sizesearchBarField = searchBarField.getPreferredSize();
    searchBarField.setBounds(200 + leftInsets.left, 200 + leftInsets.top, (int) sizesearchBarField.getWidth() - 400,
        (int) sizesearchBarField.getHeight());

    // Set the scrollBar
    leftPanel.add(scrollPane);
    scrollPane.setPreferredSize(new Dimension(leftPanel.getWidth(), 300));
    scrollPane.getViewport().setBackground(new Color(255, 255, 255));
    var sizeScrollPane = scrollPane.getPreferredSize();
    scrollPane.setBounds(200 + leftInsets.left, 255 + leftInsets.top, (int) sizeScrollPane.getWidth() - 400,
        (int) sizeScrollPane.getHeight());

    passwordField = new JPasswordField("This is the Text Field");
    passwordField.setBackground(whiteColor);
    passwordField.setBorder(passBorder);
    leftPanel.add(passwordField);
    passwordField.setPreferredSize(new Dimension(leftPanel.getWidth(), 50));
    var sizepasswordField = passwordField.getPreferredSize();
    passwordField.setBounds(200 + leftInsets.left, 560 + leftInsets.top, (int) sizepasswordField.getWidth() - 400,
        (int) sizepasswordField.getHeight());

    punchButton.setBackground(leftColor);
    punchButton.setForeground(Color.white);
    leftPanel.add(punchButton);
    punchButton.setPreferredSize(new Dimension(100, 30));
    var sizePunch = punchButton.getPreferredSize();
    punchButton.setBounds(200 + leftInsets.left, 620 + leftInsets.top, (int) sizePunch.getWidth(),
        (int) sizePunch.getHeight());

    loginButton.setBackground(rightColor);
    loginButton.setForeground(Color.white);
    leftPanel.add(loginButton);
    loginButton.setPreferredSize(new Dimension(100, 30));
    var sizeLogin = loginButton.getPreferredSize();
    loginButton.setBounds(310 + leftInsets.left, 620 + leftInsets.top, (int) sizeLogin.getWidth(),
        (int) sizeLogin.getHeight());

    logInErrorLabel.setForeground(Color.RED);
    leftPanel.add(logInErrorLabel);
    logInErrorLabel.setPreferredSize(new Dimension(leftPanel.getWidth(), 10));
    var sizeErrorLabel = logInErrorLabel.getPreferredSize();
    logInErrorLabel.setBounds(200 + leftInsets.left, 660 + leftInsets.top, (int) sizeErrorLabel.getWidth(),
        (int) sizeErrorLabel.getHeight());

    forgetPassLabel.setForeground(Color.WHITE);
    leftPanel.add(forgetPassLabel);
    forgetPassLabel.setPreferredSize(new Dimension(leftPanel.getWidth(), 20));
    var sizeForgetPassLabel = forgetPassLabel.getPreferredSize();
    forgetPassLabel.setBounds(200 + leftInsets.left, 680 + leftInsets.top, (int) sizeForgetPassLabel.getWidth(), 100);

    leftPanel.add(contacter);
    contacter.setForeground(Color.BLUE);
    contacter.setBounds(335 + leftInsets.left, 680 + leftInsets.top, (int) sizeForgetPassLabel.getWidth(), 100);

    fen.add(panel);

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

    getPunchButton().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        if (!getEmployerJList().isSelectionEmpty()) {

          if (!controleurAcceuil.punchInout(getEmployerJList().getSelectedValue(), getPasswordField().getText())) {
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

  public JButton getPunchButton() {
    return punchButton;
  }

  public JButton getLoginButton() {
    return loginButton;
  }

  public JLabel getLogInErrorLabel() {
    return logInErrorLabel;
  }

  public void paintComponent(Graphics g) {
    // Draws the img to the BackgroundPanel.
    g.drawImage(img, 0, 0, null);
  }

  public JTextField getSearchBarField() {
    return searchBarField;
  }

  JPasswordField getPasswordField() {
    return passwordField;
  }

  public JList<Employer> getEmployerJList() {
    return employerJList;
  }

  public JScrollPane getScrollPane() {
    return scrollPane;
  }

}