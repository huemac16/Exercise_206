package GUI;

import BL.Article;
import BL.TableCellRenderer;
import BL.TableModel;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StorageGUI extends javax.swing.JFrame {

    private TableModel bl = new TableModel();

    private File f = new File("./save.ser");

    public StorageGUI() throws Exception {
        initComponents();
        if (!(f.exists())) {
            f.createNewFile();
        }

        bl.load(f);
        table.setModel(bl);
        table.setDefaultRenderer(Object.class, new TableCellRenderer());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        menue = new javax.swing.JMenuBar();
        barManagement = new javax.swing.JMenu();
        AddArticle = new javax.swing.JMenuItem();
        remove = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        barBuySell = new javax.swing.JMenu();
        buy = new javax.swing.JMenuItem();
        sell = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        barManagement.setText("Management");

        AddArticle.setText("Add New Article");
        AddArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddArticleActionPerformed(evt);
            }
        });
        barManagement.add(AddArticle);

        remove.setText("Remove Selected Article");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        barManagement.add(remove);

        edit.setText("Edit Selected Article");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        barManagement.add(edit);

        menue.add(barManagement);

        barBuySell.setText("Buy/Sell");

        buy.setText("Buy Selected Article");
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });
        barBuySell.add(buy);

        sell.setText("Sell Selected Article");
        sell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellActionPerformed(evt);
            }
        });
        barBuySell.add(sell);

        menue.add(barBuySell);

        setJMenuBar(menue);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddArticleActionPerformed
        StorageDLG dialog = new StorageDLG(this, true);
        dialog.setVisible(true);

        if (dialog.isOk()) {
            bl.add(dialog.getA());

        }

    }//GEN-LAST:event_AddArticleActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        try {
            bl.remove(table.getSelectedRow());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bitte wählen Sie einen Eintrag aus!");
        }

    }//GEN-LAST:event_removeActionPerformed

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed
        try {
            bl.buy(table.getSelectedRow());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_buyActionPerformed

    private void sellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellActionPerformed
        try {
            bl.sell(table.getSelectedRow());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_sellActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        StorageDLG dialog = new StorageDLG(this, true);
        dialog.edit(bl.getByIdx(table.getSelectedRow()));
        dialog.setVisible(true);

        if (dialog.isOk()) {
            bl.set(dialog.getA(), table.getSelectedRow());
        }
    }//GEN-LAST:event_editActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            bl.save(f);
        } catch (Exception ex) {
            Logger.getLogger(StorageGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StorageGUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(StorageGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddArticle;
    private javax.swing.JMenu barBuySell;
    private javax.swing.JMenu barManagement;
    private javax.swing.JMenuItem buy;
    private javax.swing.JMenuItem edit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menue;
    private javax.swing.JMenuItem remove;
    private javax.swing.JMenuItem sell;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
