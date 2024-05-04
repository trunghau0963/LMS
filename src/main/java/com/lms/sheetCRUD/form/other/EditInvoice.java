/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.lms.sheetCRUD.form.other;

/**
 *
 * @author nttha
 */
public class EditInvoice extends javax.swing.JDialog {

    /**
     * Creates new form EditInvoice
     */
    public EditInvoice(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        searchZone = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        filterButton = new javax.swing.JButton();
        searchOption = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        bookListZone = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        infoZone = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        titleTxT = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        titleTxT1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        importBookList = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        totalZone = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalNumber = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        typeFileChooseZone = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(330, 516));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 1, 20));
        jPanel11.setMinimumSize(new java.awt.Dimension(392, 80));
        jPanel11.setPreferredSize(new java.awt.Dimension(800, 120));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        searchZone.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Export Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        searchZone.setPreferredSize(new java.awt.Dimension(400, 200));
        searchZone.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(150, 40));

        filterButton.setPreferredSize(new java.awt.Dimension(40, 40));
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });
        jPanel14.add(filterButton);

        searchOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        searchOption.setPreferredSize(new java.awt.Dimension(100, 40));
        searchOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOptionActionPerformed(evt);
            }
        });
        jPanel14.add(searchOption);

        jPanel4.add(jPanel14, java.awt.BorderLayout.WEST);

        jPanel15.setPreferredSize(new java.awt.Dimension(700, 40));

        searchField.setPreferredSize(new java.awt.Dimension(71, 40));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel16.setPreferredSize(new java.awt.Dimension(60, 40));
        jPanel16.setRequestFocusEnabled(false);

        refreshButton.setToolTipText("Refresh");
        refreshButton.setPreferredSize(new java.awt.Dimension(60, 40));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel16.add(refreshButton);

        jPanel4.add(jPanel16, java.awt.BorderLayout.EAST);

        searchZone.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel11.add(searchZone);

        jPanel9.add(jPanel11);

        jPanel1.add(jPanel9, java.awt.BorderLayout.NORTH);

        bookListZone.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        bookListZone.setPreferredSize(new java.awt.Dimension(800, 400));
        bookListZone.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        bookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Title", "Sale Price", "Quantity", "Edition", "Publishers", "Authors"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        bookList.setRowHeight(30);
        bookList.setShowGrid(true);
        bookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bookList);

        bookListZone.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(bookListZone, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(200, 517));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        infoZone.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        infoZone.setLayout(new javax.swing.BoxLayout(infoZone, javax.swing.BoxLayout.Y_AXIS));

        jPanel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        jPanel17.setPreferredSize(new java.awt.Dimension(700, 60));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.Y_AXIS));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("ID");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addComponent(jLabel9)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel17.add(jPanel10);
        jPanel17.add(titleTxT);

        infoZone.add(jPanel17);

        jPanel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        jPanel18.setPreferredSize(new java.awt.Dimension(700, 60));
        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.Y_AXIS));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Emp name");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addComponent(jLabel10)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel18.add(jPanel12);
        jPanel18.add(titleTxT1);

        infoZone.add(jPanel18);

        jPanel7.add(infoZone);

        jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));

        importBookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Title", "Sale Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        importBookList.setRowHeight(30);
        importBookList.setShowGrid(true);
        importBookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importBookListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(importBookList);

        jPanel5.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        totalZone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        totalZone.setPreferredSize(new java.awt.Dimension(300, 80));
        totalZone.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Total");
        totalZone.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, -1));

        totalNumber.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalNumber.setForeground(new java.awt.Color(255, 51, 51));
        totalNumber.setText("0đ");
        totalZone.add(totalNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 340, 30));

        jPanel13.add(totalZone);

        jPanel2.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        jPanel27.setLayout(new java.awt.BorderLayout());

        typeFileChooseZone.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Remove");
        jButton2.setPreferredSize(new java.awt.Dimension(80, 40));
        typeFileChooseZone.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 90, -1));

        jButton3.setText("Remove All");
        jButton3.setPreferredSize(new java.awt.Dimension(80, 40));
        typeFileChooseZone.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, -1));

        jButton4.setText("Save");
        jButton4.setPreferredSize(new java.awt.Dimension(80, 40));
        typeFileChooseZone.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 90, -1));

        jPanel27.add(typeFileChooseZone, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel27, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterButtonActionPerformed

    private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchOptionActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void bookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bookListMouseClicked

    private void importBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importBookListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_importBookListMouseClicked

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
            java.util.logging.Logger.getLogger(EditInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditInvoice dialog = new EditInvoice(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookList;
    private javax.swing.JPanel bookListZone;
    private javax.swing.JButton filterButton;
    private javax.swing.JTable importBookList;
    private javax.swing.JPanel infoZone;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchOption;
    private javax.swing.JPanel searchZone;
    private javax.swing.JTextField titleTxT;
    private javax.swing.JTextField titleTxT1;
    private javax.swing.JLabel totalNumber;
    private javax.swing.JPanel totalZone;
    private javax.swing.JPanel typeFileChooseZone;
    // End of variables declaration//GEN-END:variables
}
