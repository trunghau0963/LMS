/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.lms.sheetCRUD.form.other;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.sheetCRUD.entities.Sheet;
import com.lms.sheetCRUD.service.BookService;
import com.lms.sheetCRUD.service.SheetDetailService;
import com.lms.sheetCRUD.service.SheetService;

/**
 *
 * @author nttha
 */
public class ImportSheet extends javax.swing.JInternalFrame {

    private BookService bookService;
    private SheetService sheetService;
    private SheetDetailService sheetDetailService;
    ArrayList<Sheet> sheets = new ArrayList<>();
    DefaultTableModel model;

    public ImportSheet(BookService bookService, SheetService sheetService, SheetDetailService sheetDetailService) {
        this.bookService = bookService;
        this.sheetService = sheetService;
        this.sheetDetailService = sheetDetailService;
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        UIManager.put("Table.showVerticalLines", true);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        listImport.setDefaultEditor(Object.class, null);
        initComponents();
        init();
    }

    private void init() {
        customTable(listImport);
        customeIcon(searchField, refreshButton, filterButton, btnView, btnDelete, btnEdit, btnExport, btnImport);
        sheets = sheetService.getAll();
        model = (DefaultTableModel) listImport.getModel();
        model.setRowCount(0);
        model.addColumn("ID");
        model.addColumn("Import Date");
        model.addColumn("Responsible");
        model.addColumn("Total");
    }

        public void loadDataToTable(ArrayList<Sheet> sheets) {
        try {
            model.setRowCount(0);
            for (Sheet sheet : sheets) {
                model.addRow(new Object[] {
                    sheet.getSheetId(),
                    sheet.getDate(),
                    sheet.getResponsible(),
                    sheet.getTotalCost()
                });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void customeIcon(JTextField searchField, JButton refreshButton, JButton filterButton, JButton btnView,
            JButton btnDelete, JButton btnEdit, JButton btnExport, JButton btnImport) {
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        refreshButton.setIcon(new FlatSVGIcon("svg/search.svg"));
        filterButton.setIcon(new FlatSVGIcon("svg/filter.svg"));
        btnView.setIcon(new FlatSVGIcon("svg/view.svg"));
        btnDelete.setIcon(new FlatSVGIcon("svg/delete.svg"));
        btnEdit.setIcon(new FlatSVGIcon("svg/edit.svg"));
        btnExport.setIcon(new FlatSVGIcon("svg/export.svg"));
        btnImport.setIcon(new FlatSVGIcon("svg/import.svg"));
        refreshButton.setIcon(new FlatSVGIcon("svg/refresh.svg"));
    }

    private void customTable(javax.swing.JTable table) {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));
        table.setRowHeight(30);
        table.setShowGrid(true);
    }

    public Sheet getSelectedSheet() {
        int index = listImport.getSelectedRow();
        Sheet sheet = sheetService.getById((String) model.getValueAt(index, 0));
        if (index != -1) {
            return sheets.get(index);
        }
        return null;
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

        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        filterButton = new javax.swing.JButton();
        searchOption = new javax.swing.JComboBox<>();
        jPanel44 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listImport = new javax.swing.JTable();

        setBorder(null);

        jPanel39.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel39.setLayout(new javax.swing.BoxLayout(jPanel39, javax.swing.BoxLayout.Y_AXIS));

        jPanel40.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 1, 40));
        jPanel40.setMinimumSize(new java.awt.Dimension(392, 80));
        jPanel40.setPreferredSize(new java.awt.Dimension(800, 120));
        jPanel40.setLayout(new javax.swing.BoxLayout(jPanel40, javax.swing.BoxLayout.LINE_AXIS));

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Import List",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jPanel41.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanel41.setLayout(new java.awt.BorderLayout());

        jPanel42.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel42.setLayout(new java.awt.BorderLayout());

        jPanel43.setPreferredSize(new java.awt.Dimension(150, 40));

        filterButton.setPreferredSize(new java.awt.Dimension(40, 40));
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonfilterButtonActionPerformed(evt);
            }
        });
        jPanel43.add(filterButton);

        searchOption.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        searchOption.setPreferredSize(new java.awt.Dimension(100, 40));
        searchOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOptionsearchOptionActionPerformed(evt);
            }
        });
        jPanel43.add(searchOption);

        jPanel42.add(jPanel43, java.awt.BorderLayout.WEST);

        jPanel44.setPreferredSize(new java.awt.Dimension(700, 40));

        searchField.setPreferredSize(new java.awt.Dimension(71, 40));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
                jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                .addGap(8, 8, 8)));
        jPanel44Layout.setVerticalGroup(
                jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE)));

        jPanel42.add(jPanel44, java.awt.BorderLayout.CENTER);

        jPanel45.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel45.setRequestFocusEnabled(false);

        refreshButton.setText("Refresh");
        refreshButton.setPreferredSize(new java.awt.Dimension(120, 40));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel45.add(refreshButton);

        jPanel42.add(jPanel45, java.awt.BorderLayout.EAST);

        jPanel41.add(jPanel42, java.awt.BorderLayout.CENTER);

        jPanel40.add(jPanel41);

        jToolBar3.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));
        jToolBar3.setRollover(true);

        btnView.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnView.setText("View");
        btnView.setFocusable(false);
        btnView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jToolBar3.add(btnView);

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
        jToolBar3.add(btnDelete);

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
        jToolBar3.add(btnEdit);
        jToolBar3.add(jSeparator2);

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
        jToolBar3.add(btnImport);

        btnExport.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnExport.setText("Export Excel");
        btnExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jToolBar3.add(btnExport);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
                jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 347, Short.MAX_VALUE)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel46Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))));
        jPanel46Layout.setVerticalGroup(
                jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 119, Short.MAX_VALUE)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel46Layout.createSequentialGroup()
                                                .addGap(0, 9, Short.MAX_VALUE)
                                                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))));

        jPanel40.add(jPanel46);

        jPanel39.add(jPanel40);

        getContentPane().add(jPanel39, java.awt.BorderLayout.NORTH);

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 40, 40));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jScrollPane2.setViewportView(listImport);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE));
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE));

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterButtonfilterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonfilterButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_filterButtonfilterButtonActionPerformed

    private void searchOptionsearchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionsearchOptionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_searchOptionsearchOptionActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_refreshButtonActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnEditActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnImportActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnExportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnView;
    private javax.swing.JButton filterButton;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JTable listImport;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchOption;
    // End of variables declaration//GEN-END:variables
}
