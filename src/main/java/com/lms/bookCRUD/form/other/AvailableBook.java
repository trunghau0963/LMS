/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.bookCRUD.form.other;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.bookCRUD.model.BookModel;
import com.lms.bookCRUD.service.BookService;
import com.lms.bookCRUD.ui.CenterTableCellRenderer;

public class AvailableBook extends javax.swing.JInternalFrame {

    private BookService bookService;

    public AvailableBook(BookService bookService) {
        this.bookService = bookService;
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        init();
    }

    private void init() {
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        refreshButton.setIcon(new FlatSVGIcon("svg/search.svg"));
        filterButton.setIcon(new FlatSVGIcon("svg/filter.svg"));
        btnAdd.setIcon(new FlatSVGIcon("svg/add.svg"));
        btnDelete.setIcon(new FlatSVGIcon("svg/delete.svg"));
        btnEdit.setIcon(new FlatSVGIcon("svg/edit.svg"));
        btnExport.setIcon(new FlatSVGIcon("svg/export.svg"));
        btnImport.setIcon(new FlatSVGIcon("svg/import.svg"));
        refreshButton.setIcon(new FlatSVGIcon("svg/refresh.svg"));

        List<BookModel> bookModels = bookService.getAvailableBooks();
        DefaultTableModel tblModel = (DefaultTableModel) bookList.getModel();

        reloadTable(tblModel, bookModels);

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(bookList.getModel());
        bookList.setRowSorter(sorter);

    }

    public void reloadTable(DefaultTableModel tblModel, List<BookModel> bookModels) {
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        customTable(bookList);
        int idx = 0;
        tblModel.setColumnIdentifiers(new Object[] { "No.", "ID", "Title", "Edition", "Categories", "Authors",
                "Publisher", "Sale Price", "Quantity" });

        for (BookModel bookModel : bookModels) {
            tblModel.addRow(new Object[] {
                    ++idx, bookModel.getId(), bookModel.getTitle(), bookModel.getEdition(),
                    bookModel.getCategoriesString(), bookModel.getAuthorsString(),
                    bookModel.getPublisher().toString(), bookModel.getSalePrice(),
                    bookModel.getQuantity()
            });
        }
        bookList.getColumnModel().getColumn(0).setPreferredWidth(20); // No.
        // bookList.getColumnModel().getColumn(1).setPreferredWidth(bookList.getWidth()/20);
        // // ID
        // bookList.getColumnModel().getColumn(2).setPreferredWidth(bookList.getWidth()/5);
        // // Title
        // bookList.getColumnModel().getColumn(3).setPreferredWidth(80); // Edition
        // bookList.getColumnModel().getColumn(4).setPreferredWidth(bookList.getWidth()/5);
        // // Categories
        // bookList.getColumnModel().getColumn(5).setPreferredWidth(bookList.getWidth()/5);
        // // Authors
        // bookList.getColumnModel().getColumn(6).setPreferredWidth(bookList.getWidth()/5);
        // // Publisher
        // bookList.getColumnModel().getColumn(7).setPreferredWidth(80); // Sale Price
        // bookList.getColumnModel().getColumn(8).setPreferredWidth(60); // Quantity

        // Apply center alignment to each column
        for (int columnIndex = 0; columnIndex < bookList.getColumnCount(); columnIndex++) {
            bookList.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        bookList.setModel(tblModel);
    }

    private void customTable(javax.swing.JTable table) {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));
        table.setRowHeight(30);
        table.setShowGrid(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        filterButton = new javax.swing.JButton();
        searchOption = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bookList = new javax.swing.JTable();

        setBorder(null);

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 1, 40));
        jPanel11.setMinimumSize(new java.awt.Dimension(392, 80));
        jPanel11.setPreferredSize(new java.awt.Dimension(800, 120));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Available Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel1.setLayout(new java.awt.BorderLayout());

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

        jPanel1.add(jPanel14, java.awt.BorderLayout.WEST);

        jPanel15.setPreferredSize(new java.awt.Dimension(700, 40));

        searchField.setPreferredSize(new java.awt.Dimension(71, 40));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel15, java.awt.BorderLayout.CENTER);

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

        jPanel1.add(jPanel16, java.awt.BorderLayout.EAST);

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel3);

        jToolBar2.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));
        jToolBar2.setRollover(true);

        btnAdd.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAdd);

        btnDelete.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDelete);

        btnEdit.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEdit);
        jToolBar2.add(jSeparator1);

        btnImport.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnImport.setText("Import Excel");
        btnImport.setFocusable(false);
        btnImport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        jToolBar2.add(btnImport);

        btnExport.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnExport.setText("Export Excel");
        btnExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jToolBar2.add(btnExport);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel11.add(jPanel5);

        jPanel9.add(jPanel11);

        getContentPane().add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel30.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 40, 40));
        jPanel30.setPreferredSize(new java.awt.Dimension(800, 400));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        bookList.setRowHeight(30);
        bookList.setShowGrid(true);
        jScrollPane6.setViewportView(bookList);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel30, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_filterButtonActionPerformed

    private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_searchOptionActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_refreshButtonActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        AddBook a;
        a = new AddBook(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled,
                "Add Available Book");
        a.setVisible(true);
    }// GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed

    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed

    }// GEN-LAST:event_btnEditActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnImportActionPerformed

    }// GEN-LAST:event_btnImportActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExportActionPerformed

    }// GEN-LAST:event_btnExportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookList;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton filterButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchOption;
    // End of variables declaration//GEN-END:variables
}
