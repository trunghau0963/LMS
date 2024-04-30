/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.UserCRUD.form.other.temp;

import java.awt.CardLayout;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lms.UserCRUD.dal.AdminDao;
import com.lms.UserCRUD.repo.AdminRepo;
import com.lms.UserCRUD.service.AdminService;

/**
 *
 * @author DungMinh
 */
public class EditAccount extends javax.swing.JPanel {

    /**
     * Creates new form EditAccount
     */

    AdminService adminService;
    AdminDao adminDao;

    public EditAccount(CardLayout cardLayout, JPanel jParent) {
        initComponents();
        this.cardLayout = cardLayout;
        this.jParent = jParent;
        adminDao = new AdminRepo();
        adminService = new AdminService(adminDao);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        genderChoose = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        fullNametxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        contacttxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        imageAvatar1 = new com.lms.UserCRUD.ui.ImageAvatar();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Gender:");

        genderChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderChoose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        genderChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderChooseActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Date of Birth");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Password");

        pwd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdActionPerformed(evt);
            }
        });

        fullNametxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        fullNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNametxtActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Full Name:");

        contacttxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contacttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contacttxtActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Contact number:");

        saveButton.setBackground(new java.awt.Color(255, 153, 0));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        imageAvatar1.setToolTipText("Upload");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Edit Account");

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(genderChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(contacttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(fullNametxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fullNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contacttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderChoose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jParent, "viewInformation");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void usrNametxtActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_usrNametxtActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_usrNametxtActionPerformed

    private void genderChooseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genderChooseActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_genderChooseActionPerformed

    private void pwdActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_pwdActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_pwdActionPerformed

    private void fullNametxtActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_fullNametxtActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_fullNametxtActionPerformed

    private void contacttxtActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_contacttxtActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_contacttxtActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:

        String userPhoneNumber = contacttxt.getText().trim();
        String pass = String.valueOf(pwd.getPassword());
        String fullName = fullNametxt.getText().trim();
        String dob = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
        String gender = genderChoose.getSelectedItem().toString().toLowerCase();

        boolean isSucess = adminService.editAccount(userPhoneNumber, pass, fullName, dob, gender, "Admin");
        if (isSucess) {
            JOptionPane.showMessageDialog(this, "Edit account successfully");
            this.resetTextFields();
            // UsersView.viewListAccount.reLoad();
            
        } else {
            JOptionPane.showMessageDialog(this, "Edit account failed");
            this.resetTextFields();
        }

    }// GEN-LAST:event_saveButtonActionPerformed

    private void resetTextFields() {
        contacttxt.setText("");
        fullNametxt.setText("");
        pwd.setText("");
        jDateChooser1.setDate(null);
        genderChoose.setSelectedIndex(0);
    }

        // public void reLoad() {
    //     List<Employee> users = adminService.getEmployees();
    //     DefaultTableModel model = (DefaultTableModel) listEmployee.getModel();
    //     model.setRowCount(0);
    //     for (Employee user : users) {
    //         model.addRow(new Object[] {
    //                 user.getEmpName(),
    //                 user.getPhoneNumber(),
    //                 user.getDob(),
    //                 user.getPwd(),
    //                 user.getIsBlock() // You can set the initial value for Hide/UnHide column here
    //         });
    //     }
    //     listEmployee.setModel(model);
    //     listEmployee.getColumnModel().getColumn(4).setCellRenderer(new ToggleRenderer());
    //     listEmployee.getColumnModel().getColumn(4).setCellEditor(new UsersTableEditor());

    //     List<Admin> admins = adminService.getAdmins();
    //     DefaultTableModel model1 = (DefaultTableModel) listAdmin.getModel();
    //     model1.setRowCount(0);
    //     for (Admin admin : admins) {
    //         model1.addRow(new Object[] {
    //                 admin.getAdminName(),
    //                 admin.getPhoneNumber(),
    //                 admin.getPwd(),
    //                 admin.getDob(),
    //         });
    //     }
    //     listAdmin.setModel(model1);

    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contacttxt;
    private javax.swing.JTextField fullNametxt;
    private javax.swing.JComboBox<String> genderChoose;
    private com.lms.UserCRUD.ui.ImageAvatar imageAvatar1;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JButton saveButton;
    CardLayout cardLayout;
    JPanel jParent;
    // End of variables declaration//GEN-END:variables
}
