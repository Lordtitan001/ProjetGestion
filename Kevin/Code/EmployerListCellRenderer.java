package Kevin.Code;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import GESTOT_Ressources.*;
import java.awt.*;

public class EmployerListCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;

    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Employer) {
            Employer Employer = (Employer) value;
            setText(Employer.getName());
            setFont(new Font("Serif", Font.BOLD, 17));
        }
        return this;
    }
}