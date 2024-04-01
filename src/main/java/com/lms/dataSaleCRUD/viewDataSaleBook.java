package com.lms.dataSaleCRUD;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.lms.dataSaleCRUD.dal.UserDao;
import com.lms.dataSaleCRUD.entities.BookWithRevenue;
import com.lms.dataSaleCRUD.repo.UserRepo;

public class viewDataSaleBook extends javax.swing.JFrame {

        public viewDataSaleBook() {
                initComponents();
                getContentPane().setBackground(Color.WHITE);

                table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
                // table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(60, 58, 72));
                table.getTableHeader().setForeground(new Color(0, 0, 0));

                UserRepo userRepo = new UserRepo();
                List<BookWithRevenue> books = userRepo.getAllBooks();

                String[] columnNames = { "bookID", "title", "TotalRevenue" };
                DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                                return false;
                        }
                };

                // lấy dữ liệu cho bảng
                table.setModel(model);

                updateTable(books, model);

                // update bảng theo từ khóa tìm kiếm
                jTextField1.getDocument().addDocumentListener(new DocumentListener() {
                        public void changedUpdate(DocumentEvent e) {
                                filterByTitle();
                        }

                        public void removeUpdate(DocumentEvent e) {
                                filterByTitle();
                        }

                        public void insertUpdate(DocumentEvent e) {
                                filterByTitle();
                        }
                });

                dateChooser1.getDateEditor().addPropertyChangeListener(
                                new PropertyChangeListener() {
                                        @Override
                                        public void propertyChange(PropertyChangeEvent e) {
                                                if ("date".equals(e.getPropertyName())) {
                                                        if (dateChooser1.getDate() != null
                                                                        && dateChooser2.getDate() != null) {
                                                                filterByDate();
                                                        }
                                                }
                                        }
                                });

                dateChooser2.getDateEditor().addPropertyChangeListener(
                                new PropertyChangeListener() {
                                        @Override
                                        public void propertyChange(PropertyChangeEvent e) {
                                                if ("date".equals(e.getPropertyName())) {
                                                        if (dateChooser1.getDate() != null
                                                                        && dateChooser2.getDate() != null) {
                                                                filterByDate();
                                                        }
                                                }
                                        }
                                });

                resetBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateTable(books, model);

                                dateChooser1.setDate(null);
                                dateChooser2.setDate(null);
                        }
                });
        }

        public void filterByDate() {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                java.util.Date startDate = dateChooser1.getDate();
                java.sql.Date tempDate1 = new java.sql.Date(startDate.getTime());
                String startDateString = formatter.format(tempDate1);

                java.util.Date endDate = dateChooser2.getDate();
                java.sql.Date tempDate2 = new java.sql.Date(endDate.getTime());
                String endDateString = formatter.format(tempDate2);

                UserRepo userRepo = new UserRepo();
                List<BookWithRevenue> books = userRepo.getTotalRevenueGroupByBookBetweenDate(startDateString, endDateString);

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                updateTable(books, model);
        }

        public void filterByTitle() {
                String filterText = jTextField1.getText();
                UserRepo userRepo = new UserRepo();
                List<BookWithRevenue> books = userRepo.getAllBooks();

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                for (BookWithRevenue book : books) {
                        if (book.getTitle().toLowerCase().contains(filterText.toLowerCase())) {
                                model.addRow(new Object[] {book.getBookId(),book.getTitle(),book.getTotal_revenue()});
                        }
                }

        }

        public void updateTable(List<BookWithRevenue> books, DefaultTableModel model) {
                model.setRowCount(0);

                for (BookWithRevenue book : books) {
                        model.addRow(new Object[] {book.getBookId(),book.getTitle(),book.getTotal_revenue()
                        });
                }
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        dateChooser1 = new com.toedter.calendar.JDateChooser();
        dateChooser2 = new com.toedter.calendar.JDateChooser();
        resetBtn = new com.lms.custom.Button();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "bookId", "title", "TotalRevenue"
            }
        ));
        table.setRowHeight(30);
        table.setShowGrid(true);
        jScrollPane2.setViewportView(table);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        dateChooser1.setBackground(new java.awt.Color(255, 255, 255));

        dateChooser2.setBackground(new java.awt.Color(255, 255, 255));

        resetBtn.setBackground(new java.awt.Color(60, 58, 72));
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset Table");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetBtnActionPerformed

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
    private com.toedter.calendar.JDateChooser dateChooser1;
    private com.toedter.calendar.JDateChooser dateChooser2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private com.lms.custom.Button resetBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
