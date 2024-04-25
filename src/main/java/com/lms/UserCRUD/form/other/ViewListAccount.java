/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.userCRUD.form.other;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.userCRUD.dal.AdminDao;
import com.lms.userCRUD.repo.AdminRepo;
import com.lms.userCRUD.service.AdminService;
import com.lms.userCRUD.ui.ToggleRenderer;

/**
 * /**
 *
 * @author DungMinh
 */

class UsersTableEditor extends AbstractCellEditor implements TableCellEditor {
    private JToggleButton button = new JToggleButton("UnBlock");
    AdminDao adminDao = new AdminRepo();
    AdminService adminService = new AdminService(adminDao);

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        String phone = table.getValueAt(row, 1).toString();
        boolean isBlocked = (boolean) table.getValueAt(row, 4);

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

public class ViewListAccount extends javax.swing.JPanel {

    /**
     * Creates new form ViewListAccount
     */

    AdminService adminService;
    AdminDao adminDao;
    CardLayout cardLayout;
    JPanel panelParent;
    public ViewListAccount(CardLayout cardLayout, JPanel panelParent) {

        this.cardLayout = cardLayout;
        this.panelParent = panelParent;
        adminDao = new AdminRepo();
        adminService = new AdminService(adminDao);
        initComponents();
        init();
    }

    private void init() {
        customTable(listEmployee);
        customTable(listAdmin);
        searchEmployeeButton.setIcon(new FlatSVGIcon("svg/search.svg"));
        searchAdminButton.setIcon(new FlatSVGIcon("svg/search.svg"));
        List<Employee> users = adminService.getEmployees();
        DefaultTableModel model = (DefaultTableModel) listEmployee.getModel();
        model.addColumn("Name");
        model.addColumn("Phone Number");
        model.addColumn("Date of birth");
        model.addColumn("Password");
        model.addColumn("Block/Unblock");
        for (Employee user : users) {
            model.addRow(new Object[] {
                    user.getEmpName(),
                    user.getPhoneNumber(),
                    user.getDob(),
                    user.getPwd(),
                    user.getIsBlock() // You can set the initial value for Hide/UnHide column here
            });
        }
        listEmployee.setModel(model);
        listEmployee.getColumnModel().getColumn(4).setCellRenderer(new ToggleRenderer());
        listEmployee.getColumnModel().getColumn(4).setCellEditor(new UsersTableEditor());

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(listEmployee.getModel());
        listEmployee.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);

        for (int i = 0; i < listEmployee.getColumnCount(); i++) {
            sortKeys.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
        }
        sorter.setSortKeys(sortKeys);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By name", "By phone" }));
        int rowCount = Math.min(10, model.getRowCount());
        listEmployee.setPreferredScrollableViewportSize(new Dimension(listEmployee.getPreferredSize().width, rowCount * listEmployee.getRowHeight()));



        List<Admin> admins = adminService.getAdmins();
        DefaultTableModel model1 = (DefaultTableModel) listAdmin.getModel();
        model1.addColumn("Name");
        model1.addColumn("Phone Number");
        model1.addColumn("Password");
        model1.addColumn("Date of birth");

        for (Admin admin : admins) {
            model1.addRow(new Object[] {
                    admin.getAdminName(),
                    admin.getPhoneNumber(),
                    admin.getPwd(),
                    admin.getDob(),
            });
        }
        listAdmin.setModel(model1);

        TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(listAdmin.getModel());
        listAdmin.setRowSorter(sorter1);

        List<RowSorter.SortKey> sortKeys1 = new ArrayList<>(25);

        for (int i = 0; i < listAdmin.getColumnCount(); i++) {
            sortKeys1.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
        }
        sorter.setSortKeys(sortKeys1);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By name", "By phone" }));
    }

    private void customTable(javax.swing.JTable table){
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jTextPane3 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        searchAdminButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAdmin = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jTextPane1 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        searchEmployeeButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEmployee = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 60, 1, 60));
        jPanel11.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Account List");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel1)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        jPanel11.add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel18.setPreferredSize(new java.awt.Dimension(100, 50));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add New");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton1);

        jPanel11.add(jPanel18, java.awt.BorderLayout.EAST);

        add(jPanel11, java.awt.BorderLayout.NORTH);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(920, 500));

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 60, 10, 60));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Admin");
        jPanel10.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel10);

        jPanel3.setPreferredSize(new java.awt.Dimension(800, 60));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(100, 60));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel7.add(jComboBox3);

        jPanel3.add(jPanel7, java.awt.BorderLayout.WEST);

        jPanel8.setPreferredSize(new java.awt.Dimension(700, 60));

        jTextPane3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPane3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setPreferredSize(new java.awt.Dimension(100, 60));

        searchAdminButton.setPreferredSize(new java.awt.Dimension(100, 40));
        searchAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAdminButtonActionPerformed(evt);
            }
        });
        jPanel9.add(searchAdminButton);

        jPanel3.add(jPanel9, java.awt.BorderLayout.EAST);

        jPanel5.add(jPanel3);

        jPanel4.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 40, 1));
        jPanel6.setPreferredSize(new java.awt.Dimension(800, 400));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jScrollPane2.setViewportView(listAdmin);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Admin", jPanel4);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 60, 10, 60));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 701));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel12.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.Y_AXIS));

        jPanel17.setPreferredSize(new java.awt.Dimension(1059, 35));
        jPanel17.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Employee");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(9, 9, 9)))
        );

        jPanel12.add(jPanel17);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(100, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(100, 40));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel14.add(jComboBox1);

        jPanel1.add(jPanel14, java.awt.BorderLayout.WEST);

        jPanel15.setPreferredSize(new java.awt.Dimension(700, 40));

        jTextPane1.setPreferredSize(new java.awt.Dimension(71, 40));
        jTextPane1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPane1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel16.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel16.setRequestFocusEnabled(false);

        searchEmployeeButton.setPreferredSize(new java.awt.Dimension(100, 40));
        searchEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmployeeButtonActionPerformed(evt);
            }
        });
        jPanel16.add(searchEmployeeButton);

        jPanel1.add(jPanel16, java.awt.BorderLayout.EAST);

        jPanel12.add(jPanel1);

        jPanel2.add(jPanel12, java.awt.BorderLayout.NORTH);

        jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 40, 1));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel13, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Employee", jPanel2);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextPane1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextPane1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextPane1ActionPerformed

    private void jTextPane3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextPane3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextPane3ActionPerformed

    private void searchAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (jComboBox3.getSelectedItem().equals("By name") && jTextPane3.getText().length() > 0) {
            Admin admin = adminService.getAdminByName(jTextPane3.getText());
            DefaultTableModel model = (DefaultTableModel) listAdmin.getModel();
            model.setRowCount(0);
            model.addRow(new Object[] {
                    admin.getAdminName(),
                    admin.getPhoneNumber(),
                    admin.getPwd(),
                    admin.getDob(),
            });
            listAdmin.setModel(model);
        } else if (jComboBox3.getSelectedItem().equals("By phone") && jTextPane3.getText().length() > 0) {
            Admin admin = adminService.getAdminByPhoneNumber(jTextPane3.getText());
            DefaultTableModel model = (DefaultTableModel) listAdmin.getModel();
            model.setRowCount(0);
            model.addRow(new Object[] {
                    admin.getAdminName(),
                    admin.getPhoneNumber(),
                    admin.getPwd(),
                    admin.getDob(),
            });
            listAdmin.setModel(model);
        } else if (jTextPane3.getText().length() == 0) {
            List<Admin> admins = adminService.getAdmins();
            DefaultTableModel model = (DefaultTableModel) listAdmin.getModel();
            model.setRowCount(0);
            for (Admin admin : admins) {
                model.addRow(new Object[] {
                        admin.getAdminName(),
                        admin.getPhoneNumber(),
                        admin.getPwd(),
                        admin.getDob(),
                });
            }
            listAdmin.setModel(model);
        }
    }// GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelParent, "addUser");
    }// GEN-LAST:event_jButton1ActionPerformed

    @SuppressWarnings("unlikely-arg-type")
    private void searchEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (jComboBox1.getSelectedItem().equals("By name") && jTextPane1.getText().length() > 0) {
            Employee user = adminService.getEmployeeByName(jTextPane1.getText());
            DefaultTableModel model = (DefaultTableModel) listEmployee.getModel();
            model.setRowCount(0);
            model.addRow(new Object[] {
                    user.getEmpName(),
                    user.getPhoneNumber(),
                    user.getDob(),
                    user.getPwd(),
                    user.getIsBlock() // You can set the initial value for Hide/UnHide column here
            });
            listEmployee.setModel(model);
            listEmployee.getColumnModel().getColumn(4).setCellRenderer(new ToggleRenderer());
            listEmployee.getColumnModel().getColumn(4).setCellEditor(new UsersTableEditor());
        } else if (jComboBox1.getSelectedItem().equals("By phone") && jTextPane1.getText().length() > 0) {
            Employee user = adminService.getEmployeeByPhoneNumber(jTextPane1.getText());
            DefaultTableModel model = (DefaultTableModel) listEmployee.getModel();
            model.setRowCount(0);
            model.addRow(new Object[] {
                    user.getEmpName(),
                    user.getPhoneNumber(),
                    user.getDob(),
                    user.getPwd(),
                    user.getIsBlock() // You can set the initial value for Hide/UnHide column here
            });
            listEmployee.setModel(model);
            listEmployee.getColumnModel().getColumn(4).setCellRenderer(new ToggleRenderer());
            listEmployee.getColumnModel().getColumn(4).setCellEditor(new UsersTableEditor());
        } else if (jTextPane1.getText().length() == 0) {

            List<Employee> users = adminService.getEmployees();
            DefaultTableModel model = (DefaultTableModel) listEmployee.getModel();
            model.setRowCount(0);
            for (Employee user : users) {
                model.addRow(new Object[] {
                        user.getEmpName(),
                        user.getPhoneNumber(),
                        user.getDob(),
                        user.getPwd(),
                        user.getIsBlock() // You can set the initial value for Hide/UnHide
                                          // column here
                });
            }
            listEmployee.setModel(model);
            listEmployee.getColumnModel().getColumn(4).setCellRenderer(new ToggleRenderer());
            listEmployee.getColumnModel().getColumn(4).setCellEditor(new UsersTableEditor());
        }

    }// GEN-LAST:event_jButton2ActionPerformed

    public void reLoad() {
        List<Employee> users = adminService.getEmployees();
        DefaultTableModel model = (DefaultTableModel) listEmployee.getModel();
        model.setRowCount(0);
        for (Employee user : users) {
            model.addRow(new Object[] {
                    user.getEmpName(),
                    user.getPhoneNumber(),
                    user.getDob(),
                    user.getPwd(),
                    user.getIsBlock() // You can set the initial value for Hide/UnHide column here
            });
        }
        listEmployee.setModel(model);
        listEmployee.getColumnModel().getColumn(4).setCellRenderer(new ToggleRenderer());
        listEmployee.getColumnModel().getColumn(4).setCellEditor(new UsersTableEditor());

        List<Admin> admins = adminService.getAdmins();
        DefaultTableModel model1 = (DefaultTableModel) listAdmin.getModel();
        model1.setRowCount(0);
        for (Admin admin : admins) {
            model1.addRow(new Object[] {
                    admin.getAdminName(),
                    admin.getPhoneNumber(),
                    admin.getPwd(),
                    admin.getDob(),
            });
        }
        listAdmin.setModel(model1);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextPane1;
    private javax.swing.JTextField jTextPane3;
    private javax.swing.JTable listAdmin;
    private javax.swing.JTable listEmployee;
    private javax.swing.JButton searchAdminButton;
    private javax.swing.JButton searchEmployeeButton;
    // End of variables declaration//GEN-END:variables
}
