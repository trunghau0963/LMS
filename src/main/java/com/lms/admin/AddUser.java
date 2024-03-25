/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.admin;

import com.lms.auth.Login;
import com.lms.auth.dal.AuthDao;
import com.lms.auth.entities.User;
import com.lms.auth.service.UserService;
import com.lms.admin.dal.AdminDao;
import com.lms.admin.repo.AdminRepo;
import com.lms.admin.service.AdminService;

import raven.toast.Notifications;

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
    public AddUser() {
        initComponents();
        
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usrNametxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        genderChoose2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        imageAvatar1 = new com.lms.custom.ImageAvatar();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        usrNametxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        usrNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrNametxtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Add New Account");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("User Name:");

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

        genderChoose2
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Customer", "Employee" }));
        genderChoose2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        genderChoose2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderChoose2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Role");

        imageAvatar1.setToolTipText("Upload");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(fullNametxt)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel9)
                                                        .addComponent(pwd)
                                                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(contacttxt,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                243, Short.MAX_VALUE)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jDateChooser2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        95, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6)
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(genderChoose,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        261,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(genderChoose2,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        261,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel11,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING))))
                                                        .addComponent(usrNametxt)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(imageAvatar1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usrNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fullNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel6))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(genderChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(contacttxt)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(genderChoose2, javax.swing.GroupLayout.DEFAULT_SIZE, 34,
                                                Short.MAX_VALUE)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)));
    }// </editor-fold>//GEN-END:initComponents

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

        String userName = usrNametxt.getText().trim();
        String userPhoneNumber = contacttxt.getText().trim();
        String pass = String.valueOf(pwd.getPassword());
        String role = null;
        String fullName = fullNametxt.getText().trim();
        String dob = jDateChooser2.getDate().toString();
        String gender = genderChoose.getSelectedItem().toString();

        if (genderChoose2.getSelectedItem() != null) {
            role = genderChoose2.getSelectedItem().toString();
        }
        boolean action = true;
        if (userName.equals("")) {
            usrNametxt.grabFocus();
            action = false;
        }
        if (userPhoneNumber.equals("")) {

            if (action) {
                contacttxt.grabFocus();
            }
            action = false;
        }
        if (pass.equals("")) {

            if (action) {

            }
            action = false;
        }
        if (role.equals("")) {

            if (action) {

            }
            action = false;
        }
        if (action) {
            User newUser = adminService.addUser(userName, userPhoneNumber, pass, role, gender, dob, fullName);
            if (newUser != null) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "User Register Successfully");
                System.out.println("User Register: " + newUser.getPhoneNumber());
            }
        }
    }// GEN-LAST:event_saveButtonActionPerformed

    private void genderChoose2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genderChoose2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_genderChoose2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contacttxt;
    private javax.swing.JTextField fullNametxt;
    private javax.swing.JComboBox<String> genderChoose;
    private javax.swing.JComboBox<String> genderChoose2;
    private com.lms.custom.ImageAvatar imageAvatar1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField usrNametxt;
    // End of variables declaration//GEN-END:variables
}
