/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.lms.accountCRUD.form.other;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.accountCRUD.dal.AdminDao;
import com.lms.accountCRUD.repo.AdminRepo;
import com.lms.accountCRUD.service.AdminService;
import com.lms.accountCRUD.ui.ToggleRenderer;
import com.lms.auth.entities.Employee;

class UsersTableEditor extends AbstractCellEditor implements TableCellEditor {
    private JToggleButton button = new JToggleButton("UnBlock");
    AdminDao adminDao = new AdminRepo();
    AdminService adminService = new AdminService(adminDao);

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        String phone = table.getValueAt(row, 2).toString();
        boolean isBlocked = (boolean) table.getValueAt(row, 6);

        adminService.toggleBlockUser(phone, !isBlocked);

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

public class EmployeeList extends javax.swing.JInternalFrame {

    AdminService adminService;
    AdminDao adminDao;
    CardLayout cardLayout;
    List<Employee> users;
    JPanel panelParent;
    DefaultTableModel model;

    public EmployeeList(AdminService service) {
        adminService = service;
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        UIManager.put("Table.showVerticalLines", true);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        listEmployee.setDefaultEditor(Object.class, null);
        init();
    }

    private void init() {
        customTable(listEmployee);
        customeIcon(searchFieldE, refreshButtonE, filterButtonE, btnAddE, btnDeleteE, btnEditE, btnExportE, btnImportE);
        users = adminService.getEmployees();
        model = (DefaultTableModel) listEmployee.getModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Phone Number");
        model.addColumn("Password");
        model.addColumn("Date of birth");
        model.addColumn("Gender");
        model.addColumn("Block/Unblock");
        listEmployee.setModel(model);

        loadDataToTable(users);

        listEmployee.getColumnModel().getColumn(6).setCellRenderer(new ToggleRenderer());
        listEmployee.getColumnModel().getColumn(6).setCellEditor(new UsersTableEditor());

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(listEmployee.getModel());
        listEmployee.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);

        for (int i = 0; i < listEmployee.getColumnCount(); i++) {
            sortKeys.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
        }
        sorter.setSortKeys(sortKeys);
        searchOptionE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Name", "Number phone" }));
        int rowCount = Math.min(10, model.getRowCount());
        listEmployee.setPreferredScrollableViewportSize(
                new Dimension(listEmployee.getPreferredSize().width, rowCount * listEmployee.getRowHeight()));
    }

    public void loadDataToTable(List<Employee> employees) {
        try {
            model.setRowCount(0);
            for (Employee user : employees) {
                model.addRow(new Object[] {
                        user.getEmpId(),
                        user.getEmpName(),
                        user.getPhoneNumber(),
                        user.getPwd(),
                        user.getDob(),
                        user.getGender(),
                        user.getIsBlock(),// You can set the initial value for Hide/UnHide column here
                });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void customeIcon(JTextField searchField, JButton refreshButton, JButton filterButton, JButton btnAdd,
            JButton btnDelete, JButton btnEdit, JButton btnExport, JButton btnImport) {
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        refreshButton.setIcon(new FlatSVGIcon("svg/search.svg"));
        filterButton.setIcon(new FlatSVGIcon("svg/filter.svg"));
        btnAdd.setIcon(new FlatSVGIcon("svg/add.svg"));
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

    public Employee getSelectEmployee() {
        int row = listEmployee.getSelectedRow();
        Employee employee = adminService.getEmployeeById(listEmployee.getValueAt(row, 0).toString());
        if (row == -1) {
            return null;
        }
        return employee;
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel38 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        filterButtonE = new javax.swing.JButton();
        searchOptionE = new javax.swing.JComboBox<>();
        jPanel34 = new javax.swing.JPanel();
        searchFieldE = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        refreshButtonE = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnAddE = new javax.swing.JButton();
        btnDeleteE = new javax.swing.JButton();
        btnEditE = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnImportE = new javax.swing.JButton();
        btnExportE = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEmployee = new javax.swing.JTable();

        setBorder(null);

        jPanel38.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel38.setLayout(new javax.swing.BoxLayout(jPanel38, javax.swing.BoxLayout.Y_AXIS));

        jPanel37.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 1, 40));
        jPanel37.setMinimumSize(new java.awt.Dimension(392, 80));
        jPanel37.setPreferredSize(new java.awt.Dimension(800, 120));
        jPanel37.setLayout(new javax.swing.BoxLayout(jPanel37, javax.swing.BoxLayout.LINE_AXIS));

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jPanel36.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanel36.setLayout(new java.awt.BorderLayout());

        jPanel35.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel35.setLayout(new java.awt.BorderLayout());

        jPanel33.setPreferredSize(new java.awt.Dimension(150, 40));

        filterButtonE.setPreferredSize(new java.awt.Dimension(40, 40));
        filterButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonEfilterButtonActionPerformed(evt);
            }
        });
        jPanel33.add(filterButtonE);

        searchOptionE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        searchOptionE.setPreferredSize(new java.awt.Dimension(100, 40));
        searchOptionE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOptionEsearchOptionActionPerformed(evt);
            }
        });
        jPanel33.add(searchOptionE);

        jPanel35.add(jPanel33, java.awt.BorderLayout.WEST);

        jPanel34.setPreferredSize(new java.awt.Dimension(700, 40));

        searchFieldE.setPreferredSize(new java.awt.Dimension(71, 40));
        searchFieldE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldEKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchFieldE, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchFieldE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel34, java.awt.BorderLayout.CENTER);

        jPanel16.setPreferredSize(new java.awt.Dimension(60, 40));
        jPanel16.setRequestFocusEnabled(false);

        refreshButtonE.setToolTipText("Refresh");
        refreshButtonE.setPreferredSize(new java.awt.Dimension(60, 40));
        refreshButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonEActionPerformed(evt);
            }
        });
        jPanel16.add(refreshButtonE);

        jPanel35.add(jPanel16, java.awt.BorderLayout.EAST);

        jPanel36.add(jPanel35, java.awt.BorderLayout.CENTER);

        jPanel37.add(jPanel36);

        jToolBar2.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));
        jToolBar2.setRollover(true);

        btnAddE.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnAddE.setText("Add");
        btnAddE.setFocusable(false);
        btnAddE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAddE);

        btnDeleteE.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnDeleteE.setText("Delete");
        btnDeleteE.setFocusable(false);
        btnDeleteE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDeleteE);

        btnEditE.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnEditE.setText("Edit");
        btnEditE.setFocusable(false);
        btnEditE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnEditEActionPerformed(evt);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        jToolBar2.add(btnEditE);
        jToolBar2.add(jSeparator1);

        btnImportE.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnImportE.setText("Import Excel");
        btnImportE.setFocusable(false);
        btnImportE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImportE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImportE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportEActionPerformed(evt);
            }
        });
        jToolBar2.add(btnImportE);

        btnExportE.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnExportE.setText("Export Excel");
        btnExportE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExportE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExportE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportEActionPerformed(evt);
            }
        });
        jToolBar2.add(btnExportE);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel37.add(jPanel22);

        jPanel38.add(jPanel37);

        getContentPane().add(jPanel38, java.awt.BorderLayout.NORTH);

        jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 40, 40));
        jPanel13.setPreferredSize(new java.awt.Dimension(800, 100));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        listEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        listEmployee.setRowHeight(30);
        listEmployee.setShowGrid(true);
        jScrollPane1.setViewportView(listEmployee);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel13, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldEKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_searchFieldEKeyReleased
        String choose = (String) searchOptionE.getSelectedItem();
        String searchContent = searchFieldE.getText();
        List<Employee> result = new ArrayList<>();
        switch (choose) {
            case "All":
                result = adminService.SearchAllEmployee(searchContent);
                break;
            case "Name":
                result = adminService.SearchByNameEmployee(searchContent);
                break;
            case "Number phone":
                result = adminService.SearchByPhoneEmployee(searchContent);
                break;
        }
        loadDataToTable(result);
    }// GEN-LAST:event_searchFieldEKeyReleased

    private void filterButtonEfilterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonEfilterButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_filterButtonEfilterButtonActionPerformed

    private void searchOptionEsearchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionEsearchOptionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_searchOptionEsearchOptionActionPerformed

    private void refreshButtonEActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonEActionPerformed
        loadDataToTable(adminService.getEmployees());
    }// GEN-LAST:event_refreshButtonEActionPerformed

    private void btnAddEActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddEActionPerformed
        AddAccount a;
        a = new AddAccount(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled,
                "Add new Employee", adminService, "Employee");
        a.setVisible(true);
    }// GEN-LAST:event_btnAddEActionPerformed

    private void btnDeleteEActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteEActionPerformed
        if (listEmployee.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "please select the account to delete !");
        } else {
            Employee employee = getSelectEmployee();

            int checkSure = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this account ?",
                    "Verify delete this account", JOptionPane.YES_NO_OPTION);
            if (checkSure == JOptionPane.YES_OPTION) {
                try {
                    adminService.deleteAccount(employee.getPhoneNumber(), "Employee");
                    JOptionPane.showMessageDialog(this, "Delete Succesfull !");
                    loadDataToTable(adminService.getEmployees());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Delete failed !");
                }
            }
        }
    }// GEN-LAST:event_btnDeleteEActionPerformed

    private void btnEditEActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {// GEN-FIRST:event_btnEditEActionPerformed
        if (listEmployee.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select an admin to edit");
            return;
        } else {
            EditAccount a = new EditAccount(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this),
                    rootPaneCheckingEnabled, "Edit Employee", adminService, "Employee");
            a.setVisible(true);
        }
    }// GEN-LAST:event_btnEditEActionPerformed

    private void btnImportEActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnImportEActionPerformed
        importExcel();
    }// GEN-LAST:event_btnImportEActionPerformed

    private void importExcel() {
        File file;
        JFileChooser chooser = new JFileChooser();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        XSSFWorkbook workbook = null;
        ArrayList<Employee> employees = new ArrayList<Employee>();
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
                    Employee a = new Employee();
                    a.setEmpName(row.getCell(0).getStringCellValue());
                    a.setPhoneNumber(row.getCell(1).getStringCellValue());
                    a.setPwd(row.getCell(2).getStringCellValue());
                    a.setDob(row.getCell(3).getStringCellValue());
                    a.setGender(row.getCell(4).getStringCellValue());
                    // if (a.getAdminName().isEmpty() || a.getPhoneNumber().isEmpty() ||
                    // a.getPwd().isEmpty()
                    // || a.getDob().isEmpty()) {
                    // JOptionPane.showMessageDialog(this, "Import failed !");
                    // return;
                    // }
                    Employee check = adminService.getEmployeeByPhoneNumber(a.getPhoneNumber());
                    System.out.println("check : " + check.toString());
                    if (check.getEmpId() != null) {
                        JOptionPane.showMessageDialog(this, "Import failed ! the phone number " + a.getPhoneNumber()
                                + " already exists in the system");
                        return;
                    }
                    employees.add(a);
                }
                for (Employee a : employees) {
                    System.out.println(a.toString());
                    adminService.addUser(a.getPhoneNumber(), a.getPwd(), "Admin", a.getGender(),
                            a.getDob(),
                            a.getEmpName());
                    if (adminService.getAdminByPhoneNumber(a.getPhoneNumber()).getAdminId() == null) {
                        JOptionPane.showMessageDialog(this, "Import failed !");
                        return;
                    }
                }
                loadDataToTable(adminService.getEmployees());
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

    private void btnExportEActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExportEActionPerformed
        exportExcel();
    }// GEN-LAST:event_btnExportEActionPerformed

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

                for (int i = 0; i < listEmployee.getColumnCount(); i++) {
                    row.createCell(i).setCellValue(listEmployee.getColumnName(i));
                }
                for (int i = 0; i < listEmployee.getRowCount(); i++) {
                    row = sheet.createRow(i + 1);
                    for (int j = 0; j < listEmployee.getColumnCount(); j++) {
                        if (listEmployee.getValueAt(i, j) != null) {
                            row.createCell(j).setCellValue(listEmployee.getValueAt(i, j).toString());
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
    private javax.swing.JButton btnAddE;
    private javax.swing.JButton btnDeleteE;
    private javax.swing.JButton btnEditE;
    private javax.swing.JButton btnExportE;
    private javax.swing.JButton btnImportE;
    private javax.swing.JButton filterButtonE;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable listEmployee;
    private javax.swing.JButton refreshButtonE;
    private javax.swing.JTextField searchFieldE;
    private javax.swing.JComboBox<String> searchOptionE;
    // End of variables declaration//GEN-END:variables
}
