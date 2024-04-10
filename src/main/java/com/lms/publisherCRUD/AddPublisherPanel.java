/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lms.publisherCRUD;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lms.publisherCRUD.dal.PublisherDao;
import com.lms.publisherCRUD.repo.PublisherRepo;
import com.lms.publisherCRUD.service.PublisherService;

/**
 *
 * @author Van Vinh
 */
public class AddPublisherPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewPublisher
     */
    public AddPublisherPanel(CardLayout cobj, JPanel mainPanel) {
        this.cobj = cobj;
        this.panelParent = mainPanel;
        this.pubDao = new PublisherRepo();
        this.pubService = new PublisherService(pubDao);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pageLabel = new javax.swing.JLabel();
        publisherName = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();

        pageLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageLabel.setText("Add a new publishing company");

        publisherName.setText("");

        address.setText("");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UnHide", "Hide"}));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel.setLabelFor(publisherName);
        nameLabel.setText("Publisher Name");

        addressLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addressLabel.setLabelFor(address);
        addressLabel.setText("Address");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        statusLabel.setLabelFor(status);
        statusLabel.setText("Hide/UnHide");

        cancelBtn.setForeground(new java.awt.Color(255, 140, 56));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 122, 7), 2, true));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt, cobj, panelParent);
            }
        });

        addBtn.setBackground(new java.awt.Color(255, 122, 7));
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnstatusPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(publisherName)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(pageLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(pageLabel)
                .addGap(57, 57, 57)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(publisherName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(statusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(183, 183, 183))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt, CardLayout cobj, JPanel mainPanel) {//GEN-FIRST:event_cancelBtnstatusPerformed
        // TODO add your handling code here:
        cobj.show(mainPanel, "publishersPage");
    }//GEN-LAST:event_cancelBtnstatusPerformed

    private void addBtnstatusPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnstatusPerformed
        // TODO add your handling code here:
        String name = publisherName.getText();
        String address = this.address.getText();
        String status = (String) this.status.getSelectedItem();

        if (name.equals("") || address.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        } else {
            pubService.addPublisher(name, address, status);
        }
        
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField address;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField publisherName;

    private CardLayout cobj;
    private JPanel panelParent;
    PublisherDao pubDao;
    PublisherService pubService;
    // End of variables declaration//GEN-END:variables
}
