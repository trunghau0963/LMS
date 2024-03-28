/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lms.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.lms.auth.entities.Employee;
import com.lms.employee.dal.EmployeeDao;
import com.lms.employee.repo.EmployeeRepo;
import com.lms.employee.service.EmployeeService;

/**
 *
 * @author Van Vinh
 */
public class EditProfilePanel extends javax.swing.JPanel {

        public EditProfilePanel(String id) throws ParseException {
                this.empDao = new EmployeeRepo();
                this.empService = new EmployeeService(empDao);
                this.empInfo = empService.getInfoEmpById(id);
                initComponents();
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() throws ParseException {
                pageLabel = new javax.swing.JLabel();
                fullNameLabel = new javax.swing.JLabel();
                fullname = new javax.swing.JTextField();
                phoneNumber = new javax.swing.JTextField();
                phoneNumberLabel = new javax.swing.JLabel();
                dobLabel = new javax.swing.JLabel();
                gender = new javax.swing.JComboBox<>();
                genderLabel = new javax.swing.JLabel();
                usrname = new javax.swing.JTextField();
                usrnameLabel = new javax.swing.JLabel();
                pwdLabel = new javax.swing.JLabel();
                cancelBtn = new javax.swing.JButton();
                saveBtn = new javax.swing.JButton();
                pwd = new javax.swing.JPasswordField();
                dateChooser = new com.toedter.calendar.JDateChooser();
                imageAvatar1 = new com.lms.custom.ImageAvatar();

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format.parse(empInfo.getDob());
                dateChooser.setDate(date);

                setBackground(new java.awt.Color(255, 255, 255));

                pageLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                pageLabel.setText("Edit Profile");
                pageLabel.setPreferredSize(new java.awt.Dimension(58, 50));

                fullNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                fullNameLabel.setLabelFor(fullname);
                fullNameLabel.setText("FullName");

                fullname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                fullname.setForeground(new java.awt.Color(102, 102, 102));
                fullname.setText(empInfo == null ? "" : empInfo.getName());
                fullname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(181, 181, 181), 2, true));
                fullname.setPreferredSize(new java.awt.Dimension(73, 32));
                fullname.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                fullnameActionPerformed(evt);
                        }
                });

                phoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                phoneNumber.setForeground(new java.awt.Color(102, 102, 102));
                phoneNumber.setText(empInfo == null ? "" : empInfo.getPhoneNumber());
                phoneNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(181, 181, 181), 2, true));
                phoneNumber.setPreferredSize(new java.awt.Dimension(73, 32));
                phoneNumber.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                phoneNumberActionPerformed(evt);
                        }
                });
                phoneNumber.setEnabled(false);

                phoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                phoneNumberLabel.setLabelFor(phoneNumber);
                phoneNumberLabel.setText("Contact Number");

                dobLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                dobLabel.setText("Date of birth");

                gender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                gender.setForeground(new java.awt.Color(102, 102, 102));
                gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
                gender.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(181, 181, 181), 2, true));
                gender.setPreferredSize(new java.awt.Dimension(72, 32));
                gender.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                genderActionPerformed(evt);
                        }
                });

                genderLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                genderLabel.setLabelFor(gender);
                genderLabel.setText("Gender");

                usrname.setEditable(false);
                usrname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                usrname.setForeground(new java.awt.Color(102, 102, 102));
                usrname.setText(empInfo == null ? "" : empInfo.getPhoneNumber());
                usrname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(181, 181, 181), 2, true));
                usrname.setPreferredSize(new java.awt.Dimension(73, 32));

                usrnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                usrnameLabel.setLabelFor(usrname);
                usrnameLabel.setText("UserName");

                pwdLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                pwdLabel.setLabelFor(pwd);
                pwdLabel.setText("Password");

                cancelBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                cancelBtn.setForeground(new java.awt.Color(255, 125, 29));
                cancelBtn.setText("Cancel");
                cancelBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 125, 29), 2, true));
                cancelBtn.setPreferredSize(new java.awt.Dimension(72, 30));
                cancelBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancelBtnActionPerformed(evt);
                        }
                });

                saveBtn.setBackground(new java.awt.Color(255, 122, 7));
                saveBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                saveBtn.setForeground(new java.awt.Color(255, 255, 255));
                saveBtn.setText("Save");
                saveBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 125, 29), 3, true));
                saveBtn.setPreferredSize(new java.awt.Dimension(72, 30));
                saveBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                saveBtnActionPerformed(evt);
                        }
                });

                pwd.setForeground(new java.awt.Color(102, 102, 102));
                pwd.setText(empInfo == null ? "" : empInfo.getPwd());
                pwd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(181, 181, 181), 2, true));
                pwd.setPreferredSize(new java.awt.Dimension(73, 32));

                dateChooser.setBackground(new java.awt.Color(255, 255, 255));
                dateChooser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
                setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(119, 119, 119)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(pageLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                138,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(fullNameLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                94,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(207, 207, 207)
                                                                                                .addComponent(imageAvatar1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(8, 8, 8))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(phoneNumber,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(fullname,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(usrname,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(pwd,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(dateChooser,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(dobLabel,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                127,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(genderLabel,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                82,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(gender,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                277,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(cancelBtn,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                103,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(saveBtn,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                103,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addComponent(phoneNumberLabel)
                                                                                                .addComponent(usrnameLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                98,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(pwdLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                93,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(93, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(17, 17, 17)
                                                                                                .addComponent(pageLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(40, 40, 40)
                                                                                                .addComponent(fullNameLabel))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addContainerGap()
                                                                                                                .addComponent(imageAvatar1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                64,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(14, 14, 14)))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(fullname,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(phoneNumberLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(phoneNumber,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                36,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(dobLabel)
                                                                                .addComponent(genderLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(gender,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(dateChooser,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(28, 28, 28)
                                                                .addComponent(usrnameLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(usrname,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pwdLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(pwd,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(54, 54, 54)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(cancelBtn,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(saveBtn,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(18, Short.MAX_VALUE)));

                phoneNumberLabel.getAccessibleContext().setAccessibleParent(phoneNumber);
                genderLabel.getAccessibleContext().setAccessibleParent(gender);
                usrnameLabel.getAccessibleContext().setAccessibleParent(usrname);
                pwdLabel.getAccessibleContext().setAccessibleDescription("");
                cancelBtn.getAccessibleContext().setAccessibleDescription("");
        }// </editor-fold>//GEN-END:initComponents

        private void fullnameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_fullnameActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_fullnameActionPerformed

        private void phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_phoneNumberActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_phoneNumberActionPerformed

        private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_cancelBtnActionPerformed

        private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
                // TODO add your handling code here:
                String name = this.fullname.getText();
                String gender = (String) this.gender.getSelectedItem();
                String pwd = new String(this.pwd.getPassword());
        
                String dob = this.dateChooser.getDate().toString();
                SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");

                try {
                        Date date;
                        date = originalFormat.parse(dob);
                        dob = newFormat.format(date);
                } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

                if (name.equals("") || gender.equals("") || pwd.equals("") || dob.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                        empService.editInfo(empInfo.getEmpId(), name, dob, pwd, gender);
                }

        }// GEN-LAST:event_cancelBtnActionPerformed

        private void genderActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genderActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_genderActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JComboBox<String> gender;
        private com.lms.custom.ImageAvatar imageAvatar1;
        private javax.swing.JButton cancelBtn;
        private javax.swing.JButton saveBtn;
        private com.toedter.calendar.JDateChooser dateChooser;
        private javax.swing.JLabel pageLabel;
        private javax.swing.JLabel fullNameLabel;
        private javax.swing.JLabel phoneNumberLabel;
        private javax.swing.JLabel dobLabel;
        private javax.swing.JLabel genderLabel;
        private javax.swing.JLabel usrnameLabel;
        private javax.swing.JLabel pwdLabel;
        private javax.swing.JTextField fullname;
        private javax.swing.JTextField phoneNumber;
        private javax.swing.JTextField usrname;
        private javax.swing.JPasswordField pwd;
        private Employee empInfo;
        EmployeeService empService;
        EmployeeDao empDao;
        // End of variables declaration//GEN-END:variables
}
