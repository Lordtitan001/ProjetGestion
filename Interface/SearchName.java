package Interface;

import javax.swing.*;
import javax.swing.border.*;

import GESTOT_Ressources.Employer;

import java.awt.*;

public class SearchName extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField searchBarField = new JTextField();
    private JList<Employer> employerJList = new JList<>();
    private JScrollPane scrollPane = new JScrollPane(employerJList);
    private TitledBorder nameBorder;
    private Color whiteColor = new Color(255, 255, 255);

    public SearchName(Dimension dimension) {

        this.setSize(dimension);
        this.setPreferredSize(new Dimension(dimension));
        this.setOpaque(false);
        nameBorder = BorderFactory.createTitledBorder("Entrer le nom");
        searchBarField.setBorder(nameBorder);
        searchBarField.setBackground(whiteColor);
        this.add(searchBarField);
        searchBarField.setPreferredSize(new Dimension(this.getWidth(), (int) (0.1*dimension.getWidth())));
        var sizesearchBarField = searchBarField.getPreferredSize();
        searchBarField.setBounds(0, 0, (int) sizesearchBarField.getWidth(),
                (int) sizesearchBarField.getHeight());

        // Set the scrollBar
        this.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension((int)dimension.getWidth(), (int) (0.9*dimension.getWidth())));
        scrollPane.getViewport().setBackground(new Color(255, 255, 255));
        var sizeScrollPane = scrollPane.getPreferredSize();
        scrollPane.setBounds(0, (int) (0.2*dimension.getWidth()), (int) sizeScrollPane.getWidth(),
                (int) sizeScrollPane.getHeight());
    }
    public SearchName() {}


    public JList<Employer> getEmployerJList() {
        return employerJList;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JTextField getSearchBarField() {
        return searchBarField;
    }

}