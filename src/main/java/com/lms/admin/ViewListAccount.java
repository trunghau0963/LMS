/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.admin;

import com.lms.admin.dal.AdminDao;
import com.lms.admin.repo.AdminRepo;
import com.lms.admin.service.AdminService;

import java.awt.CardLayout;
import java.awt.Component;
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

import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.book.dal.AuthorDao;
import com.lms.book.repo.AuthorRepo;
import com.lms.admin.SwitchButton.ToggleRenderer;

/**
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

        public ViewListAccount(CardLayout cardLayout, JPanel panelParent) {

                this.cardLayout = cardLayout;
                this.panelParent = panelParent;
                adminDao = new AdminRepo();
                adminService = new AdminService(adminDao);
                initComponents();

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

                jScrollPane1 = new javax.swing.JScrollPane();
                listAuthor = new javax.swing.JTable();
                jLabel1 = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                jPanel1 = new javax.swing.JPanel();
                jComboBox1 = new javax.swing.JComboBox<>();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTextPane1 = new javax.swing.JTextPane();
                jButton2 = new javax.swing.JButton();
                jScrollPane3 = new javax.swing.JScrollPane();
                listAuthor1 = new javax.swing.JTable();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jPanel3 = new javax.swing.JPanel();
                jComboBox3 = new javax.swing.JComboBox<>();
                jScrollPane5 = new javax.swing.JScrollPane();
                jTextPane3 = new javax.swing.JTextPane();
                jButton5 = new javax.swing.JButton();
                setSize(800, 540);

                listAuthor.setBackground(new java.awt.Color(231, 226, 226));
                listAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                List<Employee> users = adminService.getEmployees();

                // Create a new DefaultTableModel with dynamic data
                DefaultTableModel model = new DefaultTableModel();

                // Add column names to the model
                model.addColumn("Name");
                model.addColumn("Phone Number");
                model.addColumn("Date of birth");
                model.addColumn("Password");
                model.addColumn("Block/Unblock");
                
                // Add user data to the model
                for (Employee user : users) {
                        model.addRow(new Object[] {
                                        user.getEmpName(),
                                        user.getPhoneNumber(),
                                        user.getDob(),
                                        user.getPwd(),
                                        user.getIsBlock() // You can set the initial value for Hide/UnHide column here
                        });
                }

                listAuthor.setModel(model);
                listAuthor.setGridColor(new java.awt.Color(0, 0, 0));
                listAuthor.setShowGrid(true);
                listAuthor.getColumnModel().getColumn(4).setCellRenderer(new ToggleRenderer());
                listAuthor.getColumnModel().getColumn(4).setCellEditor(new UsersTableEditor());
                jScrollPane1.setViewportView(listAuthor);

                TableRowSorter<TableModel> sorter = new TableRowSorter<>(listAuthor.getModel());
                listAuthor.setRowSorter(sorter);

                List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);

                for (int i = 0; i < listAuthor.getColumnCount(); i++) {
                        sortKeys.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
                }
                sorter.setSortKeys(sortKeys);

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                jLabel1.setText("Account List");

                jButton1.setBackground(new java.awt.Color(0, 0, 0));
                jButton1.setForeground(new java.awt.Color(153, 153, 153));
                jButton1.setText("Add New");
                jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By name", "By phone" }));

                jScrollPane2.setViewportView(jTextPane1);

                jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lms/admin/search.png"))); // NOI18N
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jComboBox1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                45,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jComboBox1)
                                                .addComponent(jScrollPane2)
                                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 38,
                                                                Short.MAX_VALUE));

                listAuthor1.setBackground(new java.awt.Color(231, 226, 226));
                listAuthor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                List<Admin> admins = adminService.getAdmins();

                // Create a new DefaultTableModel with dynamic data
                DefaultTableModel model1 = new DefaultTableModel();

                // Add column names to the model
                model1.addColumn("Name");
                model1.addColumn("Phone Number");
                model1.addColumn("Password");
                model1.addColumn("Date of birth");

                // Add user data to the model
                for (Admin admin : admins) {
                        model1.addRow(new Object[] {
                                        admin.getAdminName(),
                                        admin.getPhoneNumber(),
                                        admin.getPwd(),
                                        admin.getDob(),
                        });
                }

                listAuthor1.setModel(model1);
                listAuthor1.setGridColor(new java.awt.Color(0, 0, 0));
                listAuthor1.setShowGrid(true);
                jScrollPane3.setViewportView(listAuthor1);

                TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(listAuthor1.getModel());
                listAuthor1.setRowSorter(sorter1);

                List<RowSorter.SortKey> sortKeys1 = new ArrayList<>(25);

                for (int i = 0; i < listAuthor1.getColumnCount(); i++) {
                        sortKeys1.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
                }
                sorter.setSortKeys(sortKeys1);

                jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel2.setText("Admin");

                jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel3.setText("Employee");

                jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By name", "By phone" }));

                jScrollPane5.setViewportView(jTextPane3);

                jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lms/admin/search.png"))); // NOI18N
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton5ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jComboBox3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane5)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                45,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jComboBox3)
                                                .addComponent(jScrollPane5)
                                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanel1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jScrollPane3)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGap(581, 581, 581))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGap(292, 292, 292)
                                                                                                .addComponent(jButton1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                129,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel3,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGap(363, 363, 363))
                                                                                .addComponent(jPanel3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGap(22, 22, 22))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(23, 23, 23)
                                                                                                .addComponent(jButton1,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174, Short.MAX_VALUE)
                                                                .addGap(16, 16, 16)
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(8, 8, 8)
                                                                .addComponent(jScrollPane3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                198, Short.MAX_VALUE)
                                                                .addGap(30, 30, 30)));
        }// </editor-fold>//GEN-END:initComponents

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
                // TODO add your handling code here:
                if (jComboBox3.getSelectedItem().equals("By name") && jTextPane3.getText().length() > 0) {
                        Admin admin = adminService.getAdminByName(jTextPane3.getText());
                        DefaultTableModel model = (DefaultTableModel) listAuthor1.getModel();
                        model.setRowCount(0);
                        model.addRow(new Object[] {
                                        admin.getAdminName(),
                                        admin.getPhoneNumber(),
                                        admin.getPwd(),
                                        admin.getDob(),
                        });
                        listAuthor1.setModel(model);
                } else if (jComboBox3.getSelectedItem().equals("By phone") && jTextPane3.getText().length() > 0) {
                        Admin admin = adminService.getAdminByPhoneNumber(jTextPane3.getText());
                        DefaultTableModel model = (DefaultTableModel) listAuthor1.getModel();
                        model.setRowCount(0);
                        model.addRow(new Object[] {
                                        admin.getAdminName(),
                                        admin.getPhoneNumber(),
                                        admin.getPwd(),
                                        admin.getDob(),
                        });
                        listAuthor1.setModel(model);
                }
        }// GEN-LAST:event_jButton5ActionPerformed

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:
                cardLayout.show(panelParent, "addUser");
        }// GEN-LAST:event_jButton1ActionPerformed

        @SuppressWarnings("unlikely-arg-type")
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                // TODO add your handling code here:

                System.out.println(jComboBox1.getSelectedItem());

                if (jComboBox1.getSelectedItem().equals("By name") && jTextPane1.getText().length() > 0) {
                        Employee user = adminService.getEmployeeByName(jTextPane1.getText());
                        DefaultTableModel model = (DefaultTableModel) listAuthor.getModel();
                        model.setRowCount(0);
                        model.addRow(new Object[] {
                                        user.getEmpName(),
                                        user.getPhoneNumber(),
                                        user.getDob(),
                                        user.getPwd(),
                                        null // You can set the initial value for Hide/UnHide column here
                        });
                        listAuthor.setModel(model);
                } else if (jComboBox1.getSelectedItem().equals("By phone") && jTextPane1.getText().length() > 0) {
                        Employee user = adminService.getEmployeeByPhoneNumber(jTextPane1.getText());
                        DefaultTableModel model = (DefaultTableModel) listAuthor.getModel();
                        model.setRowCount(0);
                        model.addRow(new Object[] {
                                        user.getEmpName(),
                                        user.getPhoneNumber(),
                                        user.getDob(),
                                        user.getPwd(),
                                        null // You can set the initial value for Hide/UnHide column here
                        });
                        listAuthor.setModel(model);
                }

        }// GEN-LAST:event_jButton2ActionPerformed

        

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton5;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox3;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JTextPane jTextPane1;
        private javax.swing.JTextPane jTextPane3;
        private javax.swing.JTable listAuthor;
        private javax.swing.JTable listAuthor1;
        CardLayout cardLayout;
        JPanel panelParent;
        // End of variables declaration//GEN-END:variables
}
