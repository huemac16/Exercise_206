package BL;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;

public class TableCellRenderer implements javax.swing.table.TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        Article a = (Article) o;
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        if(a.getAmount() == 0)
        {
            label.setBackground(Color.RED);
        }
        
        label.setBackground(bln ? Color.DARK_GRAY : label.getBackground());

        switch (i1) {
            case 0:
                label.setText(a.getID());
                break;
            case 1:
                label.setText(a.getDescription());
                break;
            case 2:
                label.setText("" + a.getAmount());
                break;
            case 3:
                label.setText("" + a.getPlace());
                break;
        }
        
        return label;

    }

}
