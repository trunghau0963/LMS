/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.publisherCRUD.form.other;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractCellEditor;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.auth.entities.Admin;
import com.lms.categoryCRUD.entities.Category;
import com.lms.publisherCRUD.SwitchButton.ToggleRenderer;
import com.lms.publisherCRUD.dal.PublisherDao;
import com.lms.publisherCRUD.entities.Publisher;
import com.lms.publisherCRUD.form.other.temp.EditInfoPublisherPanel;
import com.lms.publisherCRUD.repo.PublisherRepo;
import com.lms.publisherCRUD.service.PublisherService;
import com.lms.accountCRUD.form.other.AdminList;

class PublishersTableEditor extends AbstractCellEditor implements TableCellEditor {
    private JToggleButton button = new JToggleButton("Unhide");
    PublisherDao pubDao = new PublisherRepo();
    PublisherService pubService = new PublisherService(pubDao);

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        String id = table.getValueAt(row, 0).toString();
        boolean isHide = (boolean) table.getValueAt(row, 3);

        pubService.setVisible(id, isHide);

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

public class ListPublisherPanel extends javax.swing.JInternalFrame {

    private CardLayout cardLayout;
    private JPanel panelParent;
    private PublisherService pubService;
    private PublisherDao pubDao;
    ArrayList<Publisher> publishers;
    DefaultTableModel model;

    public ListPublisherPanel(PublisherService service) {
        this.pubService = service;
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        UIManager.put("Table.showVerticalLines", true);
        publisherList.setDefaultEditor(Object.class, null);
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
        publishers = pubService.getListPublishers();
        model = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Publisher Id", "Publisher Name", "Publisher Address", "Hide/UnHide" }) {
            boolean[] canEdit = new boolean[] { false, false, false, true };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        reloadTable();

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(publisherList.getModel());
        publisherList.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);

        for (int i = 0; i < publisherList.getColumnCount(); i++) {
            sortKeys.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
        }
        sorter.setSortKeys(sortKeys);
    }

    public void reloadTable() {
        customTable(publisherList);
        publisherList.setModel(model);

        loadDataToTable(publishers);

        publisherList.setColumnSelectionAllowed(true);
        publisherList.getAccessibleContext().setAccessibleName("");
        publisherList.getAccessibleContext().setAccessibleDescription("");
        publisherList.getAccessibleContext().setAccessibleParent(this);
        publisherList.getColumnModel().getColumn(3).setCellRenderer(new ToggleRenderer());
        publisherList.getColumnModel().getColumn(3).setCellEditor(new PublishersTableEditor());
        publisherList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowSelectedAction(e);
            }
        });
    }

    public void loadDataToTable(ArrayList<Publisher> publishers) {
        try {
            model.setRowCount(0);
            for (Publisher publisher : publishers) {
                Object[] rowData = {
                        publisher.getPublisherId(),
                        publisher.getPublisherName(),
                        publisher.getPublisherAddress(),
                        publisher.isHide()
                };

                model.addRow(rowData);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void customTable(javax.swing.JTable table) {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));
        table.setRowHeight(30);
        table.setShowGrid(true);
    }

    public Publisher getSelectedPublisher() {
        int row = publisherList.getSelectedRow();
        Publisher publisher = new Publisher();
        publisher.setPublisherId((String) publisherList.getValueAt(row, 0));
        publisher.setPublisherName((String) publisherList.getValueAt(row, 1));
        publisher.setPublisherAddress((String) publisherList.getValueAt(row, 2));
        publisher.setVisible((Boolean) publisherList.getValueAt(row, 3));
        if (row == -1) {
            return null;
        }
        return publisher;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        publisherList = new javax.swing.JTable();

        setBorder(null);

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 1, 40));
        jPanel11.setMinimumSize(new java.awt.Dimension(392, 80));
        jPanel11.setPreferredSize(new java.awt.Dimension(800, 120));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Publisher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 36))); // NOI18N
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

        searchOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Name", "Address" }));
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
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
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
                    .addGap(0, 16, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel11.add(jPanel5);

        jPanel9.add(jPanel11);

        getContentPane().add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 40, 40));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 400));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        publisherList.setRowHeight(30);
        publisherList.setShowGrid(true);
        jScrollPane2.setViewportView(publisherList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_searchFieldKeyReleased
        String choose = (String) searchOption.getSelectedItem();
        String searchContent = searchField.getText();
        ArrayList<Publisher> result = new ArrayList<>();
        switch (choose) {
            case "All":
                result = pubService.SearchAll(searchContent);
                break;
            case "Name":
                result = pubService.SearchByName(searchContent);
                break;
            case "Address":
                result = pubService.SearchByAddress(searchContent);
                break;
        }
        loadDataToTable(result);
    }// GEN-LAST:event_searchFieldKeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        if (publisherList.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "please select the publisher to delete !");
        } else {
            Publisher publisher = getSelectedPublisher();

            int checkSure = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this publisher ?",
                    "Verify delete this account", JOptionPane.YES_NO_OPTION);
            if (checkSure == JOptionPane.YES_OPTION) {
                try {
                    pubService.deletePublisher(publisher.getPublisherId());
                    JOptionPane.showMessageDialog(this, "Delete Succesfull !");
                    loadDataToTable(pubService.getListPublishers());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Delete failed !");
                }
            }
        }
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
        if (publisherList.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a publisher to edit");
            return;
        } else {
            EditPublisher a = new EditPublisher(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this),
                    rootPaneCheckingEnabled, pubService);
            a.setVisible(true);
        }
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
                XSSFSheet sheet = workbook.createSheet("Admins");
                XSSFRow row;
                row = sheet.createRow(0);

                for (int i = 0; i < publisherList.getColumnCount(); i++) {
                    row.createCell(i).setCellValue(publisherList.getColumnName(i));
                }
                for (int i = 0; i < publisherList.getRowCount(); i++) {
                    row = sheet.createRow(i + 1);
                    for (int j = 0; j < publisherList.getColumnCount(); j++) {
                        if (publisherList.getValueAt(i, j) != null) {
                            row.createCell(j).setCellValue(publisherList.getValueAt(i, j).toString());
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

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnImportActionPerformed
        importExcel();
    }// GEN-LAST:event_btnImportActionPerformed

    private void importExcel() {
        File file;
        JFileChooser chooser = new JFileChooser();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        XSSFWorkbook workbook = null;
        ArrayList<Publisher> publishers = new ArrayList<Publisher>();
        chooser.setDialogTitle("Import Excel File");
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                workbook = new XSSFWorkbook(bis);
                XSSFSheet sheet = workbook.getSheetAt(0);
                System.out.println("Row count: " + sheet.getLastRowNum());
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    XSSFRow row = sheet.getRow(i);
                    Publisher a = new Publisher();
                    a.setPublisherId(row.getCell(0).getStringCellValue());
                    a.setPublisherName(row.getCell(1).getStringCellValue());
                    a.setPublisherAddress(row.getCell(2).getStringCellValue());
                    a.setVisible(row.getCell(3).getBooleanCellValue());
                    // if (a.getAdminName().isEmpty() || a.getPhoneNumber().isEmpty() ||
                    // a.getPwd().isEmpty()
                    // || a.getDob().isEmpty()) {
                    // JOptionPane.showMessageDialog(this, "Import failed !");
                    // return;
                    // }
                    publishers.add(a);
                }
                for (Publisher a : publishers) {
                    System.out.println(a.toString());
                    publishers.add(a);
                    String hide = a.isHide() ? "Hide" : "Unhide";
                    if (pubService.getPublisherById(a.getPublisherId(), hide) == null) {
                        JOptionPane.showMessageDialog(this, "Import failed !");
                        return;
                    }
                }
                loadDataToTable(pubService.getListPublishers());
                JOptionPane.showMessageDialog(this, "Import successful !");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Import failed !");
                Logger.getLogger(AdminList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Import failed !");
                Logger.getLogger(AdminList.class.getName()).log(Level.SEVERE, null, ex);
            }

            finally {
                try {
                    if (workbook != null)
                        workbook.close();
                    if (bis != null)
                        bis.close();
                    if (fis != null)
                        fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        AddPublisher a;
        a = new AddPublisher(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this),
                rootPaneCheckingEnabled, pubService);
        a.setVisible(true);
    }// GEN-LAST:event_btnAddActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_filterButtonActionPerformed

    private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterSearchActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_filterSearchActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchButtonActionPerformed
        // String key = searchField.getText();
        // String field = searchOption.getSelectedItem().toString();

        // String status = null;
        // // status = statusBtn1.isSelected() ? statusBtn1.getText() : status;
        // // status = statusBtn2.isSelected() ? statusBtn2.getText() : status;

        // // "ID", "FullName", "Gender", "Hide"
        // if (field.equals("Id")) {
        // ArrayList<Publisher> publishers = pubService.getPublisherById(key, status);
        // DefaultTableModel model = (DefaultTableModel) publisherList.getModel();
        // model.setRowCount(0);
        // for (Publisher publisher : publishers) {
        // Object[] rowData = {
        // publisher.getPublisherId(),
        // publisher.getPublisherName(),
        // publisher.getPublisherAddress(),
        // publisher.isHide()
        // };

        // model.addRow(rowData);
        // }
        // } else if (field.equals("Name")) {
        // ArrayList<Publisher> publishers = pubService.getPublisherByName(key, status);
        // DefaultTableModel model = (DefaultTableModel) publisherList.getModel();

        // model.setRowCount(0);

        // for (Publisher publisher : publishers) {
        // Object[] rowData = {
        // publisher.getPublisherId(),
        // publisher.getPublisherName(),
        // publisher.getPublisherAddress(),
        // publisher.isHide()
        // };
        // model.addRow(rowData);
        // }
        // } else if (field.equals("Address")) {
        // ArrayList<Publisher> publishers = pubService.getPublisherByAddress(key,
        // status);
        // DefaultTableModel model = (DefaultTableModel) publisherList.getModel();

        // model.setRowCount(0);

        // for (Publisher publisher : publishers) {
        // Object[] rowData = {
        // publisher.getPublisherId(),
        // publisher.getPublisherName(),
        // publisher.getPublisherAddress(),
        // publisher.isHide()
        // };
        // model.addRow(rowData);
        // }
        // } else {
        // ArrayList<Publisher> publishers = pubService.getListPublishers(status);
        // DefaultTableModel model = (DefaultTableModel) publisherList.getModel();
        // model.setRowCount(0);
        // for (Publisher publisher : publishers) {
        // Object[] rowData = {
        // publisher.getPublisherId(),
        // publisher.getPublisherName(),
        // publisher.getPublisherAddress(),
        // publisher.isHide()
        // };
        // model.addRow(rowData);
        // }
        // }
        loadDataToTable(pubService.getListPublishers());
    }// GEN-LAST:event_searchButtonActionPerformed

    private void rowSelectedAction(MouseEvent e) {// GEN-FIRST:event_searchOptionActionPerformed
        if (e.getClickCount() == 2) { // Kiểm tra xem người dùng đã nhấp đúp chuột chưa
            int row = publisherList.getSelectedRow();

            Publisher publisher = new Publisher();
            publisher.setPublisherId((String) publisherList.getValueAt(row, 0));
            publisher.setPublisherName((String) publisherList.getValueAt(row, 1));
            publisher.setPublisherAddress((String) publisherList.getValueAt(row, 2));
            publisher.setVisible((Boolean) publisherList.getValueAt(row, 3));

            EditInfoPublisherPanel editInfoPublisherPanel = new EditInfoPublisherPanel(cardLayout,
                    panelParent, publisher);
            if (editInfoPublisherPanel != null) {
                panelParent.add(editInfoPublisherPanel, "editPublisher");
                cardLayout.show(panelParent, "editPublisher");
            }
        }

    }// GEN-LAST:event_searchOptionActionPerfor

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable publisherList;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchOption;
    // End of variables declaration//GEN-END:variables
}
