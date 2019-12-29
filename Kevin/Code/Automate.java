package Kevin.Code;

import java.util.HashMap;
import javax.swing.DefaultListModel;
import Kevin.Interface.AcceuilGUI;
import Michel.Employer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Automate {
    public static HashMap<String, Employer> employerMap;
    public static Node rootNoms = new Node(null, ' ');

    private static int count = 0;

    public static KeyListener prediction(Node root, AcceuilGUI acceuilGUI) {
        KeyListener listener = new KeyListener() {
            Node currentNode = root;
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
                                afficherListeEmployers(currentNode.getListeEmployers(), acceuilGUI);
                            }
                        } else if (currentNode != null) {
                            if (currentNode.getParent() != null) {
                                currentNode = currentNode.getParent();
                                lastNode = currentNode.clone();
                                afficherListeEmployers(currentNode.getListeEmployers(), acceuilGUI);
                            }
                        }
                    } else if (currentNode != null) {
                        currentNode = currentNode.nextChild(event.getKeyChar());
                        if (currentNode != null) {
                            lastNode = currentNode.clone();
                            afficherListeEmployers(currentNode.getListeEmployers(), acceuilGUI);
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

    public static void creerArbreNom() {
        for (var entrySet : employerMap.entrySet()) {
            Node currentNode = rootNoms;
            for (char val : entrySet.getValue().getName().toCharArray()) {
                if (currentNode.nextChild(val) == null) {
                    currentNode.getAdjaceNodes().add(new Node(currentNode, val));
                }
                currentNode.getListeEmployers().put(entrySet.getKey(), entrySet.getValue());
                currentNode.getAutoComplete().add(entrySet.getValue().getName());
                currentNode = currentNode.nextChild(val);
            }
        }
    }

    public static void afficherListeEmployers(HashMap<String, Employer> employerMap, AcceuilGUI acceuilGUI) {
        DefaultListModel<Employer> model = new DefaultListModel<>();
        model.addAll(employerMap.values());
        acceuilGUI.getEmployerJList().setCellRenderer(new EmployerListCellRenderer());
        acceuilGUI.getEmployerJList().setModel(model);
    }

    public static void afficherArbre(Node root) {
        if (!root.getAdjaceNodes().isEmpty()) {
            root.getAdjaceNodes().forEach((node) -> {
                node.getListeEmployers().forEach((code, employer) -> {
                    System.out.println(node.getValue());
                    System.out.println(employer.getName());
                });
                afficherArbre(node);
            });
        }
    }

}