/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.lms.sheetCRUD.form.other;

import javax.swing.table.DefaultTableModel;

import com.lms.bookCRUD.ui.CenterTableCellRenderer;
import com.lms.sheetCRUD.entities.ExportBook;
import com.lms.sheetCRUD.entities.ImportBook;
import com.lms.sheetCRUD.entities.Invoice;
import com.lms.sheetCRUD.entities.InvoiceDetail;
import com.lms.sheetCRUD.entities.Sheet;
import com.lms.sheetCRUD.entities.SheetDetail;
import com.lms.sheetCRUD.service.BookService;
import com.lms.sheetCRUD.service.InvoiceDetailService;
import com.lms.sheetCRUD.service.InvoiceService;

/**
 *
 * @author nttha
 */
public class ViewInvoice extends javax.swing.JDialog {

    private ExportSheet exportSheet;
    private InvoiceService invoiceService;
    private InvoiceDetailService invoiceDetailService;
    private BookService bookService;
    private Invoice invoice;
    InvoiceDetail invoiceDetail;
    DefaultTableModel model;

    public ViewInvoice(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ViewInvoice(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal,
            com.lms.sheetCRUD.service.InvoiceService invoiceService,
            com.lms.sheetCRUD.service.InvoiceDetailService invoiceDetailService, BookService bookService) {
        super(owner, modal);
        initComponents();
        this.invoiceService = invoiceService;
        this.invoiceDetailService = invoiceDetailService;
        this.bookService = bookService;
        exportSheet = (ExportSheet) parent;
        invoice = exportSheet.getSelectedInvoice();
        invoiceDetail = invoiceDetailService.getInvoiceDetail(invoice.getInvoiceId());
        for (int i = 0; i < invoiceDetail.getBooks().size(); i++) {
            System.out.println("Sheet ID: " + invoiceDetail.getInvoiceId());
            System.out.println(invoiceDetail.getBooks().get(i).getId());
        }
        model = (DefaultTableModel) InvoiceList.getModel();
        reloadTable(model, invoiceDetail);
        labelIDSheet.setText(invoice.getInvoiceId());
        labelEmp.setText(invoice.getEmpId());
        labelMember.setText(invoice.getMemberId());
        labelTime.setText(invoice.getSaleDate());
        labelTongTien.setText(invoice.getTotal() + "đ");
    }

    public void reloadTable(DefaultTableModel tblModel, InvoiceDetail invoiceDetail) {
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        int idx = 0;
        customTable(InvoiceList);
        tblModel.setRowCount(0);
        tblModel.addColumn("No.");
        tblModel.addColumn("Book ID");
        tblModel.addColumn("Name Book");
        tblModel.addColumn("Quantity");
        tblModel.addColumn("Import Price");

        loadDataToTable(invoiceDetail);

        for (int columnIndex = 0; columnIndex < InvoiceList.getColumnCount(); columnIndex++) {
            InvoiceList.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
        InvoiceList.setModel(tblModel);
        InvoiceList.setColumnSelectionAllowed(true);
    }

    public void loadDataToTable(InvoiceDetail invoiceDetail) {
        try {
            DefaultTableModel tblModel = (DefaultTableModel) InvoiceList.getModel();
            int idx = 0;
            tblModel.setRowCount(0);
            for (ExportBook books : invoiceDetail.getBooks()) {
                tblModel.addRow(new Object[] { ++idx, books.getId(), bookService.getNameOfBook(books.getId()),
                        books.getQuantity(), books.getExportPrice() });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void customTable(javax.swing.JTable table) {
        table.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        table.getTableHeader().setBackground(new java.awt.Color(125, 200, 204));
        table.getTableHeader().setForeground(new java.awt.Color(0, 0, 0));
        table.setRowHeight(30);
        table.setShowGrid(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        labelEmp = new javax.swing.JLabel();
        labelIDSheet = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelMember = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceList = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        labelTongTien = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        returnButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        saveButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(37, 185, 154));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Invoice Information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 1, 1));
        jPanel12.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 40));
        jPanel5.setPreferredSize(new java.awt.Dimension(598, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Import Date:");

        labelTime.setText("jLabel7");

        labelEmp.setText("jLabel7");

        labelIDSheet.setText("jLabel7");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Emp Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Invoice ID:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Member name:");

        labelMember.setText("jLabel7");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap(377, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 242,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelMember, javax.swing.GroupLayout.PREFERRED_SIZE, 242,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 234,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelIDSheet, javax.swing.GroupLayout.PREFERRED_SIZE, 242,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(392, Short.MAX_VALUE))));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(labelMember))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(labelTime))
                                .addContainerGap())
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(labelIDSheet))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel4)
                                                .addComponent(labelEmp))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

        jPanel12.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 40, 40));
        jPanel4.setPreferredSize(new java.awt.Dimension(700, 600));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setPreferredSize(new java.awt.Dimension(800, 400));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        InvoiceList.setRowHeight(30);
        InvoiceList.setShowGrid(true);
        jScrollPane2.setViewportView(InvoiceList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 750, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 750,
                                        Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 244, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));

        jPanel4.add(jPanel3);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("TỔNG TIỀN:");

        labelTongTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTongTien.setText("...đ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(435, Short.MAX_VALUE)));
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(labelTongTien))
                                .addContainerGap()));

        jPanel4.add(jPanel6);

        jPanel12.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        returnButton.setText("Back");
        returnButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        returnButton.setPreferredSize(new java.awt.Dimension(150, 40));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        jPanel11.add(returnButton);

        jPanel10.add(jPanel11);

        saveButton1.setBackground(new java.awt.Color(37, 185, 154));
        saveButton1.setForeground(new java.awt.Color(255, 255, 255));
        saveButton1.setText("Save");
        saveButton1.setPreferredSize(new java.awt.Dimension(150, 40));
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });
        jPanel13.add(saveButton1);

        jPanel10.add(jPanel13);

        jPanel12.add(jPanel10, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel12, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_returnButtonActionPerformed

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveButton1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_saveButton1ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewInvoice dialog = new ViewInvoice(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable InvoiceList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelEmp;
    private javax.swing.JLabel labelIDSheet;
    private javax.swing.JLabel labelMember;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel labelTongTien;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton saveButton1;
    // End of variables declaration//GEN-END:variables
}