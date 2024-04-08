/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.admin;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lms.admin.main.UsersPage;

import com.lms.auth.entities.*;
import com.lms.admin.dal.AdminDao;
import com.lms.admin.repo.AdminRepo;
import com.lms.admin.service.AdminService;
import java.awt.CardLayout;

/**
 *
 * @author DungMinh
 */
public class AddUser extends javax.swing.JPanel {

        /**
         * Creates new form AddUser
         */

        AdminService adminService;
        AdminDao adminDao;

        public AddUser(CardLayout cardLayout, JPanel jParent) {
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
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel2 = new javax.swing.JLabel();
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
                roleChoose = new javax.swing.JComboBox<>();
                jLabel11 = new javax.swing.JLabel();
                imageAvatar1 = new com.lms.custom.ImageAvatar();
                jDateChooser2 = new com.toedter.calendar.JDateChooser();
                jButton1 = new javax.swing.JButton();

                jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                jLabel2.setText("Add New Account");

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

                roleChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Employee" }));
                roleChoose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                roleChoose.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                roleChooseActionPerformed(evt);
                        }
                });

                jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel11.setText("Role");

                imageAvatar1.setToolTipText("Upload");

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
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(127, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jButton1)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                false)
                                                                                                .addComponent(jLabel8,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(fullNametxt,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(pwd,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(saveButton,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(contacttxt,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                243,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jLabel10)
                                                                                                                                .addComponent(jDateChooser2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                243,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jLabel7))
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                42,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jLabel11)
                                                                                                                                .addComponent(jLabel6)
                                                                                                                                .addComponent(genderChoose,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                261,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(roleChoose,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                261,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jLabel2)
                                                                                                                                .addComponent(jLabel9))
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(imageAvatar1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                100,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGap(127, 127, 127)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(jButton1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                16, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel2)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addComponent(jLabel9))
                                                                                .addComponent(imageAvatar1,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                70,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(fullNametxt,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jLabel10)
                                                                                                                .addComponent(jLabel6))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(contacttxt,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                35,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(genderChoose,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                36,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jLabel7))
                                                                                .addComponent(jLabel11))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jDateChooser2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                34,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(roleChoose,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                34,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(pwd,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(saveButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(60, Short.MAX_VALUE)));
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:
                cardLayout.show(jParent, "viewListAccount");
        }// GEN-LAST:event_jButton1ActionPerformed

        private void usrNametxtActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_usrNametxtActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_usrNametxtActionPerformed

        private void genderChooseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genderChooseActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_genderChooseActionPerformed

        private void roleChooseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genderChooseActionPerformed
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

                String userPhoneNumber = contacttxt.getText().trim();
                String pass = String.valueOf(pwd.getPassword());
                String role = roleChoose.getSelectedItem().toString();
                String fullName = fullNametxt.getText().trim();
                String dob = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser2.getDate());
                String gender = genderChoose.getSelectedItem().toString().toLowerCase();

                if (userPhoneNumber.equals("") || pass.equals("") || fullName.equals("")
                                || dob.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                        User newUser = adminService.addUser(userPhoneNumber, pass, role, gender, dob, fullName);
                        if (newUser != null) {
                                JOptionPane.showMessageDialog(null, "User added successfully");
                                this.resetFields();
                                UsersPage.viewListAccount.reLoad();
                        } else {
                                JOptionPane.showMessageDialog(null, "User not added");
                                this.resetFields();
                        }
                }

        }// GEN-LAST:event_saveButtonActionPerformed

        private void resetFields() {
                contacttxt.setText("");
                fullNametxt.setText("");
                pwd.setText("");
                jDateChooser2.setDate(null);
                genderChoose.setSelectedIndex(0);
                roleChoose.setSelectedIndex(0);
        }

        private void genderChoose2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genderChoose2ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_genderChoose2ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTextField contacttxt;
        private javax.swing.JTextField fullNametxt;
        private javax.swing.JComboBox<String> genderChoose;
        private com.lms.custom.ImageAvatar imageAvatar1;
        private javax.swing.JButton jButton1;
        private com.toedter.calendar.JDateChooser jDateChooser2;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPasswordField pwd;
        private javax.swing.JComboBox<String> roleChoose;
        private javax.swing.JButton saveButton;
        CardLayout cardLayout;
        JPanel jParent;
        // End of variables declaration//GEN-END:variables
}