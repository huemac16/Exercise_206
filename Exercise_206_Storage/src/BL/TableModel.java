package BL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private ArrayList<Article> articles = new ArrayList<>();

    private static String[] colNames = {"ID", "Description", "Amount", "Place"};

    public void add(Article a) {

        articles.add(a);

        fireTableDataChanged();
    }

    public void remove(int idx) {
        articles.remove(idx);

        fireTableDataChanged();
    }

    public void buy(int idx) throws Exception {
        articles.get(idx).buy();

        fireTableDataChanged();
    }

    public void sell(int idx) throws Exception {
        articles.get(idx).sell();

        fireTableDataChanged();
    }

    public void set(Article a, int idx) {
        articles.set(idx, a);
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

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    public Article getByIdx(int idx) {
        return articles.get(idx);
    }
    
    public void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Article s : articles) {
            oos.writeObject(s);

        }

        oos.flush();
        oos.close();
    }

    public void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object o;
        try {
            while ((o = ois.readObject()) != null) {
                articles.add((Article) o);
            }

        } catch (Exception e) {
        }

        ois.close();

    }
    
    

}
