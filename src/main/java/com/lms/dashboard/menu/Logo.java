/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.dashboard.menu;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.dashboard.form.Admin;
import com.lms.dashboard.form.Emp;

/**
 *
 * @author nttha
 */
public class Logo extends javax.swing.JPanel {

    boolean isRunning = false;
    Admin admin = null;
    Emp emp = null;

    public Logo(Admin admin) {
        this.admin = admin;
        initComponents();
    }

    public Logo(Emp emp) {
        this.emp = emp;
        initComponents();
    }

    public Logo() {
        initComponents();
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setLogo(String logo) {
        logoLabel.setText(logo);
    }

    public void setLogoSize(int size) {
        logoLabel.setFont(new java.awt.Font("Segoe UI", 1, size));
    }

    public void setLogoColor(int r, int g, int b) {
        logoLabel.setForeground(new java.awt.Color(r, g, b));
    }

    public void setLogoBackground(int r, int g, int b) {
        logo.setBackground(new java.awt.Color(r, g, b));
    }

    public void setButtonBackground(int r, int g, int b) {
        button.setBackground(new java.awt.Color(r, g, b));
    }

    public void setIcon(String icon) {
        openAndCloseButton.setIcon(new FlatSVGIcon(icon));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button = new javax.swing.JPanel();
        openAndCloseButton = new javax.swing.JButton();
        logo = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();

        openAndCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAndCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonLayout = new javax.swing.GroupLayout(button);
        button.setLayout(buttonLayout);
        buttonLayout.setHorizontalGroup(
                buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(openAndCloseButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE));
        buttonLayout.setVerticalGroup(
                buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonLayout.createSequentialGroup()
                                .addComponent(openAndCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        logoLabel.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("LMS");

        javax.swing.GroupLayout logoLayout = new javax.swing.GroupLayout(logo);
        logo.setLayout(logoLayout);
        logoLayout.setHorizontalGroup(
                logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 118, Short.MAX_VALUE)
                        .addGroup(logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 112,
                                                Short.MAX_VALUE))));
        logoLayout.setVerticalGroup(
                logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addGroup(logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(logoLayout.createSequentialGroup()
                                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    private void openAndCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_openAndCloseButtonActionPerformed
        // admin.openAndCloseButton(evt);
        if (!isRunning) {
            if (admin != null) {
                System.out.print("admin ");
                admin.openAndCloseButton(evt);
            }
            if (emp != null) {
                System.out.print("emp ");
                emp.openAndCloseButton(evt);
            }
        }
    }// GEN-LAST:event_openAndCloseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel button;
    private javax.swing.JPanel logo;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton openAndCloseButton;
    // End of variables declaration//GEN-END:variables
}
