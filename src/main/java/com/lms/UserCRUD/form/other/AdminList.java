/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.lms.UserCRUD.form.other;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
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

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import com.lms.auth.entities.Admin;
import com.lms.UserCRUD.dal.AdminDao;
import com.lms.UserCRUD.service.AdminService;

// class UsersTableEditor extends AbstractCellEditor implements TableCellEditor {
//     private JToggleButton button = new JToggleButton("UnBlock");
//     AdminDao adminDao = new AdminRepo();
//     AdminService adminService = new AdminService(adminDao);

//     @Override
//     public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
//             int column) {
//         String phone = table.getValueAt(row, 1).toString();
//         boolean isBlocked = (boolean) table.getValueAt(row, 4);

//         adminService.toggleBlockUser(phone, !isBlocked);

//         button.addActionListener(e -> {
//             stopCellEditing();
//             fireEditingStopped();
//         });

//         return button;
//     }

//     @Override
//     public Object getCellEditorValue() {
//         return button.isSelected();
//     }
// }

/**
 *
 * @author nttha
 */
public class AdminList extends javax.swing.JInternalFrame {

    AdminService adminService;
    AdminDao adminDao;
    CardLayout cardLayout;
    List<Admin> admins;
    JPanel panelParent;
    DefaultTableModel model1;

    public AdminList(AdminService service) {
        adminService = service;
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        UIManager.put("Table.showVerticalLines", true);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        listAdmin.setDefaultEditor(Object.class, null);
        init();
    }

    private void init() {
        customTable(listAdmin);
        customeIcon(searchFieldA, refreshButtonA, filterButtonA, btnAddA, btnDeleteA, btnEditA, btnExportA, btnImportA);
        admins = adminService.getAdmins();
        model1 = (DefaultTableModel) listAdmin.getModel();
        model1.addColumn("ID");
        model1.addColumn("Name");
        model1.addColumn("Phone Number");
        model1.addColumn("Password");
        model1.addColumn("Date of birth");
        model1.addColumn("Gender");
        listAdmin.setModel(model1);

        loadDataToTable(admins);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(listAdmin.getModel());
        listAdmin.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys1 = new ArrayList<>(25);

        for (int i = 0; i < listAdmin.getColumnCount(); i++) {
            sortKeys1.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
        }
        sorter.setSortKeys(sortKeys1);

        searchOptionA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Name", "Number phone" }));
    }

    public void loadDataToTable(List<Admin> admins) {
        try {
            model1.setRowCount(0);
            for (Admin admin : admins) {
                model1.addRow(new Object[] {
                        admin.getId(),
                        admin.getAdminName(),
                        admin.getPhoneNumber(),
                        admin.getPwd(),
                        admin.getDob(),
                        admin.getGender(),
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

    public Admin getSelectAdmin() {
        int row = listAdmin.getSelectedRow();
        Admin admin = adminService.getAdminById(listAdmin.getValueAt(row, 0).toString());
        if (row == -1) {
            return null;
        }
        return admin;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAdmin = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        filterButtonA = new javax.swing.JButton();
        searchOptionA = new javax.swing.JComboBox<>();
        jPanel44 = new javax.swing.JPanel();
        searchFieldA = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        refreshButtonA = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        btnAddA = new javax.swing.JButton();
        btnDeleteA = new javax.swing.JButton();
        btnEditA = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnImportA = new javax.swing.JButton();
        btnExportA = new javax.swing.JButton();

        setBorder(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 40, 40));
        jPanel6.setPreferredSize(new java.awt.Dimension(800, 400));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jScrollPane2.setViewportView(listAdmin);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE));
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE));

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel39.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel39.setLayout(new javax.swing.BoxLayout(jPanel39, javax.swing.BoxLayout.Y_AXIS));

        jPanel40.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 1, 40));
        jPanel40.setMinimumSize(new java.awt.Dimension(392, 80));
        jPanel40.setPreferredSize(new java.awt.Dimension(800, 120));
        jPanel40.setLayout(new javax.swing.BoxLayout(jPanel40, javax.swing.BoxLayout.LINE_AXIS));

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin List",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jPanel41.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanel41.setLayout(new java.awt.BorderLayout());

        jPanel42.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel42.setLayout(new java.awt.BorderLayout());

        jPanel43.setPreferredSize(new java.awt.Dimension(150, 40));

        filterButtonA.setPreferredSize(new java.awt.Dimension(40, 40));
        filterButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonAfilterButtonActionPerformed(evt);
            }
        });
        jPanel43.add(filterButtonA);

        searchOptionA.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Name", "Number phone" }));
        searchOptionA.setPreferredSize(new java.awt.Dimension(100, 40));
        searchOptionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOptionAsearchOptionActionPerformed(evt);
            }
        });
        jPanel43.add(searchOptionA);

        jPanel42.add(jPanel43, java.awt.BorderLayout.WEST);

        jPanel44.setPreferredSize(new java.awt.Dimension(700, 40));

        searchFieldA.setPreferredSize(new java.awt.Dimension(71, 40));
        searchFieldA.addKeyListener(new java.awt.event.KeyAdapter() {
            // public void keyPressed(java.awt.event.KeyEvent evt) {
            // searchFieldAKeyPressed(evt);
            // }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldAKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
                jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchFieldA, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                .addGap(8, 8, 8)));
        jPanel44Layout.setVerticalGroup(
                jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchFieldA, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE)));

        jPanel42.add(jPanel44, java.awt.BorderLayout.CENTER);

        jPanel45.setPreferredSize(new java.awt.Dimension(60, 40));
        jPanel45.setRequestFocusEnabled(false);

        refreshButtonA.setToolTipText("Refresh");
        refreshButtonA.setPreferredSize(new java.awt.Dimension(60, 40));
        refreshButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonAActionPerformed(evt);
            }
        });
        jPanel45.add(refreshButtonA);

        jPanel42.add(jPanel45, java.awt.BorderLayout.EAST);

        jPanel41.add(jPanel42, java.awt.BorderLayout.CENTER);

        jPanel40.add(jPanel41);

        jToolBar3.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));
        jToolBar3.setRollover(true);

        btnAddA.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnAddA.setText("Add");
        btnAddA.setFocusable(false);
        btnAddA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAActionPerformed(evt);
            }
        });
        jToolBar3.add(btnAddA);

        btnDeleteA.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnDeleteA.setText("Delete");
        btnDeleteA.setFocusable(false);
        btnDeleteA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAActionPerformed(evt);
            }
        });
        jToolBar3.add(btnDeleteA);

        btnEditA.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnEditA.setText("Edit");
        btnEditA.setFocusable(false);
        btnEditA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnEditAActionPerformed(evt);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        jToolBar3.add(btnEditA);
        jToolBar3.add(jSeparator2);

        btnImportA.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnImportA.setText("Import Excel");
        btnImportA.setFocusable(false);
        btnImportA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImportA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImportA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportAActionPerformed(evt);
            }
        });
        jToolBar3.add(btnImportA);

        btnExportA.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnExportA.setText("Export Excel");
        btnExportA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExportA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExportA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportAActionPerformed(evt);
            }
        });
        jToolBar3.add(btnExportA);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
                jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 350, Short.MAX_VALUE)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterButtonAfilterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonAfilterButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_filterButtonAfilterButtonActionPerformed

    private void searchOptionAsearchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionAsearchOptionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_searchOptionAsearchOptionActionPerformed

    private void refreshButtonAActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonAActionPerformed
        loadDataToTable(adminService.getAdmins());
    }// GEN-LAST:event_refreshButtonAActionPerformed

    private void btnAddAActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddAActionPerformed
        AddAccount a;
        a = new AddAccount(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled,
                "Add New Admin", adminService, "Admin");
        a.setVisible(true);
    }// GEN-LAST:event_btnAddAActionPerformed

    private void btnDeleteAActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteAActionPerformed
        if (listAdmin.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "please select the account to delete !");
        } else {
            Admin admin = getSelectAdmin();

            int checkSure = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this account ?",
                    "Verify delete this account", JOptionPane.YES_NO_OPTION);
            if (checkSure == JOptionPane.YES_OPTION) {
                try {
                    adminService.deleteAccount(admin.getPhoneNumber(), "Admin");
                    JOptionPane.showMessageDialog(this, "Delete Succesfull !");
                    loadDataToTable(adminService.getAdmins());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Delete failed !");
                }
            }
        }
    }// GEN-LAST:event_btnDeleteAActionPerformed

    private void btnEditAActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {// GEN-FIRST:event_btnEditAActionPerformed
        if (listAdmin.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select an admin to edit");
            return;
        } else {
            EditAccount a = new EditAccount(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this),
                    rootPaneCheckingEnabled, "Edit Admin", adminService, "Admin");
            a.setVisible(true);
        }

    }// GEN-LAST:event_btnEditAActionPerformed

    private void btnImportAActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnImportAActionPerformed
        importExcel();
    }// GEN-LAST:event_btnImportAActionPerformed

    private void importExcel() {
        File file;
        JFileChooser chooser = new JFileChooser();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        XSSFWorkbook workbook = null;
        ArrayList<Admin> admin = new ArrayList<Admin>();
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
                    Admin a = new Admin();
                    a.setAdminName(row.getCell(0).getStringCellValue());
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
                    Admin check = adminService.getAdminByPhoneNumber(a.getPhoneNumber());
                    System.out.println("check : " + check.toString());
                    if (check.getAdminId() != null) {
                        JOptionPane.showMessageDialog(this, "Import failed ! the phone number " + a.getPhoneNumber()
                                + " already exists in the system");
                        return;
                    }
                    admin.add(a);
                }
                for (Admin a : admin) {
                    System.out.println(a.toString());
                    adminService.addUser(a.getPhoneNumber(), a.getPwd(), "Admin", a.getGender(),
                            a.getDob(),
                            a.getAdminName());
                    if (adminService.getAdminByPhoneNumber(a.getPhoneNumber()).getAdminId() == null) {
                        JOptionPane.showMessageDialog(this, "Import failed !");
                        return;
                    }
                }
                loadDataToTable(adminService.getAdmins());
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

    private void btnExportAActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExportAActionPerformed
        exportExcel();
    }// GEN-LAST:event_btnExportAActionPerformed

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

                for (int i = 0; i < listAdmin.getColumnCount(); i++) {
                    row.createCell(i).setCellValue(listAdmin.getColumnName(i));
                }
                for (int i = 0; i < listAdmin.getRowCount(); i++) {
                    row = sheet.createRow(i + 1);
                    for (int j = 0; j < listAdmin.getColumnCount(); j++) {
                        if (listAdmin.getValueAt(i, j) != null) {
                            row.createCell(j).setCellValue(listAdmin.getValueAt(i, j).toString());
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

    private void searchFieldAKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String choose = (String) searchOptionA.getSelectedItem();
        String searchContent = searchFieldA.getText();
        List<Admin> result = new ArrayList<>();
        switch (choose) {
            case "All":
                result = adminService.SearchAllAdmin(searchContent);
                break;
            case "Name":
                result = adminService.SearchByNameAdmin(searchContent);
                break;
            case "Number phone":
                result = adminService.SearchByPhoneAdmin(searchContent);
                break;
        }
        loadDataToTable(result);
    }// GEN-LAST:event_txtSearchKeyReleased

    public void openFile(String file) {
        try {
            File myFile = new File(file);
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {
            // no application registered for PDFs
            JOptionPane.showMessageDialog(this, "No application registered for PDFs");
        }
    }

    // Variables declaration-do not modify// GEN-BEGIN:variables
    private javax.swing.JButton btnAddA;
    private javax.swing.JButton btnDeleteA;
    private javax.swing.JButton btnEditA;
    private javax.swing.JButton btnExportA;
    private javax.swing.JButton btnImportA;
    private javax.swing.JButton filterButtonA;
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
    private javax.swing.JTable listAdmin;
    private javax.swing.JButton refreshButtonA;
    private javax.swing.JTextField searchFieldA;
    private javax.swing.JComboBox<String> searchOptionA;
    // End of variables declaration
}
