
package BL;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TableModel extends AbstractTableModel{
    
    private ArrayList<Article> articles = new ArrayList<>();
    
    private static String[] colNames = {"ID", "Description", "Amount", "Place"};
    
    public void add(Article a)
    {
        articles.add(a);
        
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return articles.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Article a = articles.get(i);
        return a;
    }
    
}
