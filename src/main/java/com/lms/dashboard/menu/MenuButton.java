/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.dashboard.menu;

import javax.swing.UIManager;

import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author nttha
 */
public class MenuButton extends javax.swing.JPanel {

    private int index;
    private String name;
    private boolean selected = false;
    private boolean isLogoutButton = false;
    private static boolean enable = true;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        buttonIcon.setIndex(index);
        buttonName.setIndex(index);
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getEnable() {
        return enable;
    }

    public MenuButton() {
        initComponents();
    }

    public void setIcon(String icon) {
        buttonIcon.setIcon(new FlatSVGIcon(icon));
    }

    public void setName(String name) {
        buttonName.setText(name);
    }

    public String getName() {
        return buttonName.getText();
    }

    public void setAction(java.awt.event.ActionListener action) {
        buttonIcon.addActionListener(action);
        buttonName.addActionListener(action);
    }

    public void setIconAction(java.awt.event.ActionListener action) {
        buttonIcon.addActionListener(action);
    }

    public void setNameAction(java.awt.event.ActionListener action) {
        buttonName.addActionListener(action);
    }

    public void setIconSize(int size) {
        buttonIcon.setPreferredSize(new java.awt.Dimension(size, size));
    }

    public void setNameSize(int size) {
        buttonName.setPreferredSize(new java.awt.Dimension(size, size));
    }

    public void setIconBackground(java.awt.Color color) {
        buttonIcon.setBackground(color);
    }

    public void setNameBackground(java.awt.Color color) {
        buttonName.setBackground(color);
    }

    // public void setBackground(java.awt.Color color){
    // MenuButton.super.setBackground(color);
    // buttonIcon.setBackground(color);
    // nameButton.setBackground(color);
    // }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconPanel = new javax.swing.JPanel();
        buttonIcon = new com.lms.dashboard.menu.Button();
        namePanel = new javax.swing.JPanel();
        buttonName = new com.lms.dashboard.menu.Button();

        buttonIcon.setBackground(UIManager.getColor("Button.background"));
        buttonName.setBackground(UIManager.getColor("Button.background"));
        setBackground(UIManager.getColor("Button.background"));

        buttonIcon.setBorder(null);
        buttonIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout iconPanelLayout = new javax.swing.GroupLayout(iconPanel);
        iconPanel.setLayout(iconPanelLayout);
        iconPanelLayout.setHorizontalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        iconPanelLayout.setVerticalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        buttonName.setBorder(null);
        buttonName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout namePanelLayout = new javax.swing.GroupLayout(namePanel);
        namePanel.setLayout(namePanelLayout);
        namePanelLayout.setHorizontalGroup(
            namePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonName, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        namePanelLayout.setVerticalGroup(
            namePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(namePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(namePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void buttonIconActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonIconActionPerformed
        if (selected) {
            isSelected(selected);
        }
    }// GEN-LAST:event_buttonIconActionPerformed

    private void buttonNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nameButtonActionPerformed
        // if (enable || selected) {
        // if (!isLogoutButton) {
        // selected = !selected;
        // enable = !enable;
        // System.out.println(selected);
        // System.out.println(enable);
        // System.out.println(getName() + " " + index);
        // isSelected(selected, new java.awt.Color(60, 58, 72));
        // } else {
        // selected = !selected;
        // System.out.println(selected);
        // try {
        // Application.login();
        // Notifications.getInstance().show(Notifications.Type.SUCCESS,
        // Notifications.Location.TOP_CENTER,
        // "Logout Success\n");
        // } catch (Exception e) {
        // e.printStackTrace();
        // Notifications.getInstance().show(Notifications.Type.ERROR,
        // Notifications.Location.TOP_CENTER,
        // "Logout Failed\n");
        // }
        // }
        // }
        if (selected) {
            isSelected(selected);
        }
    }// GEN-LAST:event_nameButtonActionPerformed

    public void isSelected(boolean selected) {
        if (selected) {
            buttonIcon.setBackground(new java.awt.Color(156, 63, 243));
            buttonName.setBackground(new java.awt.Color(156, 63, 243));
            setBackground(new java.awt.Color(156, 63, 243));
        } else {
            buttonIcon.setBackground(UIManager.getColor("Button.background"));
            buttonName.setBackground(UIManager.getColor("Button.background"));
            setBackground(UIManager.getColor("Button.background"));
        }
    }

    public void setLogoutButton() {
        isLogoutButton = true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lms.dashboard.menu.Button buttonIcon;
    private com.lms.dashboard.menu.Button buttonName;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JPanel namePanel;
    // End of variables declaration//GEN-END:variables
}
