/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.lms.sheetCRUD.form.other;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.sheetCRUD.service.BookService;
import com.lms.sheetCRUD.service.InvoiceDetailService;
import com.lms.sheetCRUD.service.SheetDetailService;
import com.lms.sheetCRUD.service.SheetService;
import com.lms.sheetCRUD.service.InvoiceService;
import com.lms.sheetCRUD.entities.Invoice;
import com.lms.sheetCRUD.entities.Sheet;

/**
 *
 * @author nttha
 */
public class ExportSheet extends javax.swing.JInternalFrame {

    private BookService bookService;
    private InvoiceService invoiceService;
    private InvoiceDetailService invoiceDetailService;
    ArrayList<Invoice> invoices = new ArrayList<>();
    DefaultTableModel model;

    public ExportSheet(BookService bookService, InvoiceService invoiceService,
            InvoiceDetailService invoiceDetailService) {
        this.bookService = bookService;
        this.invoiceService = invoiceService;
        this.invoiceDetailService = invoiceDetailService;
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        UIManager.put("Table.showVerticalLines", true);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        // listExport.setDefaultEditor(Object.class, null);
        initComponents();
        init();
    }

    private void init() {
        customTable(listExport);
        customeIcon(searchField, refreshButton, filterButton, btnView, btnEdit, btnExport);
        invoices = invoiceService.getAll();
        model = (DefaultTableModel) listExport.getModel();
        // model.setRowCount(0);
        model.addColumn("ID");
        model.addColumn("empID");
        model.addColumn("memberID");
        model.addColumn("Import Date");
        model.addColumn("Total");

        loadDataToTable(invoices);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(listExport.getModel());
        listExport.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys1 = new ArrayList<>(25);

        for (int i = 0; i < listExport.getColumnCount(); i++) {
            sortKeys1.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
        }
        sorter.setSortKeys(sortKeys1);
    }

    public void loadDataToTable(ArrayList<Invoice> invoices) {
        try {
            model.setRowCount(0);
            for (Invoice invoice : invoices) {
                model.addRow(new Object[] {
                        invoice.getInvoiceId(),
                        invoice.getEmpId(),
                        invoice.getMemberId(),
                        invoice.getSaleDate(),
                        invoice.getTotal(),
                });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void customeIcon(JTextField searchField, JButton refreshButton, JButton filterButton, JButton btnView, JButton btnEdit, JButton btnExport) {
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        refreshButton.setIcon(new FlatSVGIcon("svg/search.svg"));
        filterButton.setIcon(new FlatSVGIcon("svg/filter.svg"));
        btnView.setIcon(new FlatSVGIcon("svg/view.svg"));
        btnEdit.setIcon(new FlatSVGIcon("svg/edit.svg"));
        btnExport.setIcon(new FlatSVGIcon("svg/export.svg"));
        refreshButton.setIcon(new FlatSVGIcon("svg/refresh.svg"));
    }

    private void customTable(javax.swing.JTable table) {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));
        table.setRowHeight(30);
        table.setShowGrid(true);
    }

    public Invoice getSelectedInvoice() {
        int index = listExport.getSelectedRow();
        Invoice invoice = new Invoice();
        invoice = invoiceService.getById((String) listExport.getValueAt(index, 0));
        if (index == -1) {
            return null;
        }
        return invoice;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listExport = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        filterButton = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        btnView = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnExport = new javax.swing.JButton();

        setBorder(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 40, 40));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jScrollPane2.setViewportView(listExport);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel39.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel39.setLayout(new javax.swing.BoxLayout(jPanel39, javax.swing.BoxLayout.Y_AXIS));

        jPanel40.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 1, 40));
        jPanel40.setMinimumSize(new java.awt.Dimension(392, 80));
        jPanel40.setPreferredSize(new java.awt.Dimension(800, 120));
        jPanel40.setLayout(new javax.swing.BoxLayout(jPanel40, javax.swing.BoxLayout.LINE_AXIS));

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Export List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jPanel41.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanel41.setLayout(new java.awt.BorderLayout());

        jPanel42.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel42.setLayout(new java.awt.BorderLayout());

        jPanel43.setPreferredSize(new java.awt.Dimension(40, 40));

        filterButton.setPreferredSize(new java.awt.Dimension(40, 40));
        // filterButton.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         filterButtonfilterButtonActionPerformed(evt);
        //     }
        // });
        jPanel43.add(filterButton);

        jPanel42.add(jPanel43, java.awt.BorderLayout.WEST);

        jPanel44.setPreferredSize(new java.awt.Dimension(700, 40));

        searchField.setPreferredSize(new java.awt.Dimension(71, 40));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel44, java.awt.BorderLayout.CENTER);

        jPanel45.setEnabled(false);
        jPanel45.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel45.setRequestFocusEnabled(false);

        refreshButton.setToolTipText("Refresh");
        refreshButton.setPreferredSize(new java.awt.Dimension(40, 40));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel45.add(refreshButton);

        jPanel42.add(jPanel45, java.awt.BorderLayout.EAST);

        jPanel41.add(jPanel42, java.awt.BorderLayout.CENTER);

        jPanel40.add(jPanel41);

        jPanel46.setPreferredSize(new java.awt.Dimension(200, 119));

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
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel40.add(jPanel46);

        jPanel39.add(jPanel40);

        getContentPane().add(jPanel39, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // private void filterButtonfilterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonfilterButtonActionPerformed
    //     Filter a = new Filter(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled, this);
    //     a.setVisible(true);
    // }// GEN-LAST:event_filterButtonfilterButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonActionPerformed
        loadDataToTable(invoiceService.getAll());
    }// GEN-LAST:event_refreshButtonActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        if (listExport.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select an sheet to view");
            return;
        } else {
            ViewInvoice a = new ViewInvoice(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this),
                    rootPaneCheckingEnabled, invoiceService, invoiceDetailService, bookService);
            a.setVisible(true);
        }
    }// GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
        // if (listExport.getSelectedRow() == -1) {
        // JOptionPane.showMessageDialog(this, "Please select an sheet to view");
        // return;
        // } else {
        // EditSheet a = new EditSheet(this, (JFrame)
        // javax.swing.SwingUtilities.getWindowAncestor(this),
        // rootPaneCheckingEnabled, invoiceService, invoiceDetailService, bookService);
        // a.setVisible(true);
        // }
    }// GEN-LAST:event_btnEditActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExportActionPerformed
        exportExcel();
    }// GEN-LAST:event_btnExportActionPerformed

    private void exportExcel() {
        JFileChooser chooser = new JFileChooser();
        try {
            chooser.showSaveDialog(this);
            File file = chooser.getSelectedFile();
            if (file != null) {
                file = new File(file.toString() + ".xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("List Invoice");
                XSSFRow row;
                row = sheet.createRow(0);

                for (int i = 0; i < listExport.getColumnCount(); i++) {
                    row.createCell(i).setCellValue(listExport.getColumnName(i));
                }
                for (int i = 0; i < listExport.getRowCount(); i++) {
                    row = sheet.createRow(i + 1);
                    for (int j = 0; j < listExport.getColumnCount(); j++) {
                        if (listExport.getValueAt(i, j) != null) {
                            row.createCell(j).setCellValue(listExport.getValueAt(i, j).toString());
                        }
                    }
                }
                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
                workbook.close();
                openFile(file.toString());
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void openFile(String file) {
        try {
            File myFile = new File(file);
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {
            // no application registered for PDFs
            JOptionPane.showMessageDialog(this, "No application registered for PDFs");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
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
    private javax.swing.JTable listExport;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
