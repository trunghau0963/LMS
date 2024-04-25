/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.bookCRUD.form.other;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.bookCRUD.model.BookModel;
import com.lms.bookCRUD.service.BookService;
import com.lms.bookCRUD.ui.CenterTableCellRenderer;


public class AvailableBook extends javax.swing.JPanel {

    private BookService bookService;

    public AvailableBook(BookService bookService) {
        this.bookService = bookService;
        initComponents();
        init();
    }

    private void init() {
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        searchBookButton.setIcon(new FlatSVGIcon("svg/search.svg"));
        filterBookButton.setIcon(new FlatSVGIcon("svg/filter.svg"));

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
        tblModel.setColumnIdentifiers(new Object[]{"No.", "ID", "Title", "Edition", "Categories", "Authors", "Publisher", "Sale Price", "Quantity"});
    
        for (BookModel bookModel : bookModels) {
            tblModel.addRow(new Object[]{
                ++idx, bookModel.getId(), bookModel.getTitle(), bookModel.getEdition(),
                bookModel.getCategoriesString(), bookModel.getAuthorsString(),
                bookModel.getPublisher().toString(), bookModel.getSalePrice(),
                bookModel.getQuantity()
            });
        }
        bookList.getColumnModel().getColumn(0).setPreferredWidth(20); // No.
        // bookList.getColumnModel().getColumn(1).setPreferredWidth(bookList.getWidth()/20); // ID
        // bookList.getColumnModel().getColumn(2).setPreferredWidth(bookList.getWidth()/5); // Title
        // bookList.getColumnModel().getColumn(3).setPreferredWidth(80); // Edition
        // bookList.getColumnModel().getColumn(4).setPreferredWidth(bookList.getWidth()/5); // Categories
        // bookList.getColumnModel().getColumn(5).setPreferredWidth(bookList.getWidth()/5); // Authors
        // bookList.getColumnModel().getColumn(6).setPreferredWidth(bookList.getWidth()/5); // Publisher
        // bookList.getColumnModel().getColumn(7).setPreferredWidth(80); // Sale Price
        // bookList.getColumnModel().getColumn(8).setPreferredWidth(60); // Quantity
    
        // Apply center alignment to each column
        for (int columnIndex = 0; columnIndex < bookList.getColumnCount(); columnIndex++) {
            bookList.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
    
        bookList.setModel(tblModel);
    }

    private void customTable(javax.swing.JTable table){
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));
        table.setRowHeight(30);
        table.setShowGrid(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        filterBookButton = new javax.swing.JButton();
        filterSearch = new javax.swing.JComboBox<>();
        jPanel28 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        searchBookButton = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bookList = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 60, 10, 60));
        setLayout(new java.awt.BorderLayout());

        jPanel24.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel24.setLayout(new javax.swing.BoxLayout(jPanel24, javax.swing.BoxLayout.Y_AXIS));

        jPanel25.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Available Books");
        jPanel25.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel25);

        jPanel26.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel26.setLayout(new java.awt.BorderLayout());

        jPanel27.setPreferredSize(new java.awt.Dimension(150, 40));

        filterBookButton.setPreferredSize(new java.awt.Dimension(40, 40));
        filterBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBookButtonActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(filterBookButton);

        filterSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        filterSearch.setPreferredSize(new java.awt.Dimension(100, 40));
        filterSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterSearchActionPerformed(evt);
            }
        });
        jSplitPane1.setRightComponent(filterSearch);

        jPanel27.add(jSplitPane1);

        jPanel26.add(jPanel27, java.awt.BorderLayout.WEST);

        jPanel28.setPreferredSize(new java.awt.Dimension(700, 40));

        searchField.setPreferredSize(new java.awt.Dimension(71, 40));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel26.add(jPanel28, java.awt.BorderLayout.CENTER);

        jPanel29.setPreferredSize(new java.awt.Dimension(60, 40));
        jPanel29.setRequestFocusEnabled(false);

        searchBookButton.setPreferredSize(new java.awt.Dimension(60, 40));
        searchBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookButtonActionPerformed(evt);
            }
        });
        jPanel29.add(searchBookButton);

        jPanel26.add(jPanel29, java.awt.BorderLayout.EAST);

        jPanel24.add(jPanel26);

        add(jPanel24, java.awt.BorderLayout.NORTH);

        jPanel30.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 40, 1));
        jPanel30.setPreferredSize(new java.awt.Dimension(800, 400));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        bookList.setRowHeight(30);
        bookList.setShowGrid(true);
        jScrollPane6.setViewportView(bookList);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
        );

        add(jPanel30, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void filterBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBookButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterBookButtonActionPerformed

    private void filterSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterSearchActionPerformed

    private void searchBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBookButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBookButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookList;
    private javax.swing.JButton filterBookButton;
    private javax.swing.JComboBox<String> filterSearch;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton searchBookButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
