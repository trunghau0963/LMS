/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.authorCRUD.form.other;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.authorCRUD.SwitchButton.ToggleRenderer;
import com.lms.authorCRUD.dal.AuthorDao;
import com.lms.authorCRUD.entities.Author;
import com.lms.authorCRUD.repo.AuthorRepo;
import com.lms.authorCRUD.service.AuthorService;

class AuthorsTableEditor extends AbstractCellEditor implements TableCellEditor {
    private JToggleButton button = new JToggleButton("Unhide");
    AuthorDao empDao = new AuthorRepo();
    AuthorService empService = new AuthorService(empDao);

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        String id = table.getValueAt(row, 0).toString();
        boolean isHide = (boolean) table.getValueAt(row, 3);

        empService.setVisible(id, isHide);

        button.addActionListener(e -> {
            stopCellEditing();
            fireEditingStopped();
        });

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.isSelected();
    }
}

public class ListAuthorPanel extends javax.swing.JPanel {
    private CardLayout cardLayout;
    private JPanel panelParent;
    private AuthorService empService;
    private AuthorDao empDao;

    public ListAuthorPanel(CardLayout cobj, JPanel panelParent) {
        initComponents();
        this.panelParent = panelParent;
        this.empDao = new AuthorRepo();
        this.empService = new AuthorService(empDao);
        this.cardLayout = cobj;
        init();
    }

    private void init() {
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        searchButton.setIcon(new FlatSVGIcon("svg/search.svg"));
        filterButton.setIcon(new FlatSVGIcon("svg/filter.svg"));
        ArrayList<Author> authors = empService.getListAuthors();
        DefaultTableModel model = new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Id", "FullName", "Gender", "Hide/UnHide"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        reloadTable(model, authors);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(authorList.getModel());
        authorList.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);

        for (int i = 0; i < authorList.getColumnCount(); i++) {
            sortKeys.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
        }
        sorter.setSortKeys(sortKeys);
    }

    public void reloadTable(DefaultTableModel tblModel, ArrayList<Author> authorModels) {
        customTable(authorList);

        tblModel.setRowCount(0);
        for (Author author : authorModels) {
            Object[] rowData = {
                    author.getAuthorId(),
                    author.getAuthorName(),
                    author.getAuthorGender(),
                    author.isHide()
            };

            tblModel.addRow(rowData);
        }

        authorList.setModel(tblModel);

        authorList.setColumnSelectionAllowed(true);
        authorList.getAccessibleContext().setAccessibleName("");
        authorList.getAccessibleContext().setAccessibleDescription("");
        authorList.getAccessibleContext().setAccessibleParent(this);
        authorList.getColumnModel().getColumn(3).setCellRenderer(new ToggleRenderer());
        authorList.getColumnModel().getColumn(3).setCellEditor(new AuthorsTableEditor());
        authorList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowSelectedActionPerformed(e);
            }
        });
    }

    private void customTable(javax.swing.JTable table) {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));
        table.setRowHeight(30);
        table.setShowGrid(true);
    }

    private void rowSelectedActionPerformed(MouseEvent e) {// GEN-FIRST:event_searchOptionActionPerformed
        // TODO add your handling code here:
        if (e.getClickCount() == 2) { // Kiểm tra xem người dùng đã nhấp đúp chuột chưa
            int row = authorList.getSelectedRow();

            Author author = new Author();
            author.setAuthorId((String) authorList.getValueAt(row, 0));
            author.setAuthorName((String) authorList.getValueAt(row, 1));
            author.setAuthorGender((String) authorList.getValueAt(row, 2));
            author.setVisible((Boolean) authorList.getValueAt(row, 3));

            System.out.println(author.getAuthorId() + " " + author.getAuthorName() + " " + author.getAuthorGender()
                    + " " + author.isHide());

            EditInfoAuthorPanel editAuthorPanel = new EditInfoAuthorPanel(cardLayout, panelParent, author);
            if (editAuthorPanel != null) {
                panelParent.add(editAuthorPanel, "editAuthor");
                cardLayout.show(panelParent, "editAuthor");
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        addAuthorButton = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        filterButton = new javax.swing.JButton();
        searchOption = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        authorList = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 1, 40));
        jPanel11.setPreferredSize(new java.awt.Dimension(800, 60));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Author List");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 618, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel19Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
        jPanel19Layout.setVerticalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 68, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel1)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

        jPanel11.add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel20.setPreferredSize(new java.awt.Dimension(100, 50));

        addAuthorButton.setBackground(new java.awt.Color(153, 153, 153));
        addAuthorButton.setForeground(new java.awt.Color(255, 255, 255));
        addAuthorButton.setText("Add New");
        addAuthorButton.setPreferredSize(new java.awt.Dimension(100, 40));
        addAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAuthorButtonActionPerformed(evt);
            }
        });
        jPanel20.add(addAuthorButton);

        jPanel11.add(jPanel20, java.awt.BorderLayout.EAST);

        jPanel9.add(jPanel11);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 1, 40));
        jPanel12.setPreferredSize(new java.awt.Dimension(800, 70));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.Y_AXIS));

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

        searchOption.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
                                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                                .addGap(8, 8, 8)));
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel1.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel16.setPreferredSize(new java.awt.Dimension(60, 40));
        jPanel16.setRequestFocusEnabled(false);

        searchButton.setPreferredSize(new java.awt.Dimension(60, 40));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel16.add(searchButton);

        jPanel1.add(jPanel16, java.awt.BorderLayout.EAST);

        jPanel12.add(jPanel1);

        jPanel9.add(jPanel12);

        add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 40, 40));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 400));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        authorList.setRowHeight(30);
        authorList.setShowGrid(true);
        jScrollPane2.setViewportView(authorList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 720, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 720,
                                        Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 348, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348,
                                        Short.MAX_VALUE)));

        jPanel4.add(jPanel2);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addAuthorButtonActionPerformed
        cardLayout.show(panelParent, "addAuthor");
    }// GEN-LAST:event_addAuthorButtonActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_filterButtonActionPerformed

    private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_searchOptionActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchButtonActionPerformed
        // String key = searchField.getText();
        // String field = searchOption.getSelectedItem().toString();

        // String sex = null;
        // sex = sexBtn1.isSelected() ? sexBtn1.getText() : sex;
        // sex = sexBtn2.isSelected() ? sexBtn2.getText() : sex;

        // String status = null;
        // status = statusBtn1.isSelected() ? statusBtn1.getText() : status;
        // status = statusBtn2.isSelected() ? statusBtn2.getText() : status;

        // // "ID", "FullName", "Gender", "Hide"
        // if (field.equals("Id")) {
        // ArrayList<Author> authors = empService.getAuthorById(key, sex, status);
        // DefaultTableModel model = (DefaultTableModel) listAuthor.getModel();
        // model.setRowCount(0);
        // for (Author author : authors) {
        // Object[] rowData = {
        // author.getAuthorId(),
        // author.getAuthorName(),
        // author.getAuthorGender(),
        // author.isHide()
        // };

        // model.addRow(rowData);
        // }
        // } else if (field.equals("FullName")) {
        // ArrayList<Author> authors = empService.getAuthorByName(key, sex, status);
        // DefaultTableModel model = (DefaultTableModel) listAuthor.getModel();

        // model.setRowCount(0);

        // for (Author author : authors) {
        // Object[] rowData = {
        // author.getAuthorId(),
        // author.getAuthorName(),
        // author.getAuthorGender(),
        // author.isHide()
        // };
        // model.addRow(rowData);
        // }
        // } else {
        // ArrayList<Author> authors = empService.getListAuthors(sex, status);
        // DefaultTableModel model = (DefaultTableModel) listAuthor.getModel();
        // model.setRowCount(0);
        // for (Author author : authors) {
        // Object[] rowData = {
        // author.getAuthorId(),
        // author.getAuthorName(),
        // author.getAuthorGender(),
        // author.isHide()
        // };
        // model.addRow(rowData);
        // }
        // }
    }// GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAuthorButton;
    private javax.swing.JTable authorList;
    private javax.swing.JButton filterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchOption;
    // End of variables declaration//GEN-END:variables
}
