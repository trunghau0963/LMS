/*
 * Click nbfs://nbhost/SystemFileSystem/Tpublates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Tpublates/GUIForms/JFrame.java to edit this tpublate
 */
package com.lms.publisherCRUD.form.other;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lms.publisherCRUD.dal.PublisherDao;
import com.lms.publisherCRUD.entities.Publisher;
import com.lms.publisherCRUD.repo.PublisherRepo;
import com.lms.publisherCRUD.service.PublisherService;

/**
 *
 * @author Van Vinh
 */
public class EditInfoPublisherPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewPublisher
     */
    public EditInfoPublisherPanel(CardLayout cobj, JPanel panelParent, Publisher publisher) {
        this.dataPublisher = publisher;
        this.panelParent = panelParent;
        this.cardLayout = cobj;
        this.pubDao = new PublisherRepo();
        this.pubService = new PublisherService(pubDao);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        publisherId = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        publisherLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        publisherName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        imageAvatar1 = new com.lms.publisherCRUD.ui.ImageAvatar();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit info publishing company ");

        publisherId.setEditable(false);
        publisherId.setText(dataPublisher != null ? dataPublisher.getPublisherId() : "");

        addressField.setText(dataPublisher != null ? dataPublisher.getPublisherAddress() : "");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hide", "UnHide" }));
        status.setSelectedItem(dataPublisher.isHide() == true ? "Hide" : "UnHide");

        publisherLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        publisherLabel.setLabelFor(publisherId);
        publisherLabel.setText("Publisher Id");

        addressLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addressLabel.setLabelFor(addressField);
        addressLabel.setText("Address");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        statusLabel.setLabelFor(status);
        statusLabel.setText("Hide/UnHide");

        cancelBtn.setForeground(new java.awt.Color(255, 140, 56));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 122, 7), 2, true));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(255, 122, 7));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        publisherName.setText(dataPublisher != null ? dataPublisher.getPublisherName() : "");

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel.setLabelFor(publisherId);
        nameLabel.setText("Publisher Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
        setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(307, 307, 307)
                                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(146, 146, 146)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(publisherLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 122,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(117, 117, 117)
                                                                .addComponent(jLabel1))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(addressField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                319,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(addressLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                96,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(statusLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                109,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(status,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                223,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(publisherId,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 560,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(publisherName,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 560,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(365, 365, 365)
                                                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(94, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(publisherLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(publisherId, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31,
                                        Short.MAX_VALUE)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(publisherName, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addressLabel)
                                        .addComponent(statusLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(149, 149, 149)));

    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelParent, "publishersPage");
    }// GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        String id = this.publisherId.getText();
        String name = this.publisherName.getText();
        String address = (String) this.addressField.getText();
        String status = (String) this.status.getSelectedItem();

        if (name.equals("") || address.equals("") || status.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        } else {
            pubService.editInfo(id, name, address, status);
        }
    }// GEN-LAST:event_saveBtnActionPerformed

    CardLayout cardLayout;
    JPanel panelParent;
    PublisherService pubService;
    PublisherDao pubDao;

    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField addressField;
    private com.lms.publisherCRUD.ui.ImageAvatar imageAvatar1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField publisherId;
    private javax.swing.JTextField publisherName;
    private com.lms.publisherCRUD.entities.Publisher dataPublisher;
    // End of variables declaration//GEN-END:variables
}
