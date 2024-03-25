package com.lms.dataSaleCRUD;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.lms.dataSaleCRUD.dao.UserDao;
import com.lms.dataSaleCRUD.component.switchButton.ToggleEditor;
import com.lms.dataSaleCRUD.component.switchButton.ToggleRenderer;
import com.lms.dataSaleCRUD.entities.Book;

public class viewDataSaleBook extends javax.swing.JFrame {

        public viewDataSaleBook() {
                initComponents();
                getContentPane().setBackground(Color.WHITE);

                table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(60, 58, 72));
                table.getTableHeader().setForeground(new Color(0, 0, 0));

                table.getColumnModel().getColumn(4).setCellRenderer(new ToggleRenderer());
                table.getColumnModel().getColumn(4).setCellEditor(new ToggleEditor());

                UserDao userDao = new UserDao();
                List<Book> books = userDao.getListBooksByRevenue();

                String[] columnNames = { "bookID", "publisherID", "title", "salePrice", "isHide", "TotalRevenue" };

                // Create a new DefaultTableModel with the column names and zero rows
                DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                                // Only column 4 is editable
                                return column == 4;
                        }

                        @Override
                        public Class<?> getColumnClass(int columnIndex) {
                                if (columnIndex == 4) {
                                        return Boolean.class;
                                }
                                return super.getColumnClass(columnIndex);
                        }
                };

                table.setModel(model);

                for (Book book : books) {
                        model.addRow(new Object[] {
                                        book.getBookId(),
                                        book.getPublisherId(),
                                        book.getTitle(),
                                        book.getSalePrice(),
                                        book.getIsHide(),
                                        book.getTotal_revenue()
                        });
                }

                jTextField1.getDocument().addDocumentListener(new DocumentListener() {
                        public void changedUpdate(DocumentEvent e) {
                                filter();
                        }

                        public void removeUpdate(DocumentEvent e) {
                                filter();
                        }

                        public void insertUpdate(DocumentEvent e) {
                                filter();
                        }

                        public void filter() {
                                String filterText = jTextField1.getText();
                                UserDao userDao = new UserDao();
                                List<Book> books = userDao.getListBooksByRevenue();

                                DefaultTableModel model = (DefaultTableModel) table.getModel();
                                model.setRowCount(0); // Clear the table before adding new data

                                for (Book book : books) {
                                        if (book.getTitle().contains(filterText)) {
                                                model.addRow(new Object[] {
                                                                book.getBookId(),
                                                                book.getPublisherId(),
                                                                book.getTitle(),
                                                                book.getSalePrice(),
                                                                book.getIsHide(),
                                                                book.getTotal_revenue()
                                                });
                                        }
                                }

                        }
                });
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        label1 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setText("Data Sale - Book");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "bookID", "publisherID", "title", "salePrice", "isHide", "TotalRevenue"
            }
        ));
        table.setRowHeight(30);
        table.setShowGrid(true);
        jScrollPane2.setViewportView(table);

        jTextField1.setText("Searching something...");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "Week", "Day" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 208, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jTextField1ActionPerformed

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(viewDataSaleBook.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(viewDataSaleBook.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(viewDataSaleBook.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(viewDataSaleBook.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new viewDataSaleBook().setVisible(true);
                        }
                });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private java.awt.Label label1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
