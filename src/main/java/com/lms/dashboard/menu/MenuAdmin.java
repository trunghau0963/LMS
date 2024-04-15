/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.dashboard.menu;

import java.util.ArrayList;

import com.lms.dashboard.form.Admin;

// import raven.toast.Notifications;

/**
 *
 * @author nttha
 */
public class MenuAdmin extends javax.swing.JPanel {

    Admin admin;
    ArrayList<MenuButton> buttonList = new ArrayList<>();

    public MenuAdmin(Admin admin) {
        this.admin = admin;
        initComponents();
        init();
    }

    public MenuAdmin() {
        initComponents();
        init();
    }

    public ArrayList<MenuButton> getListButton() {
        return buttonList;
    }

    private void init() {
        logo.setLogo("LMS");
        logo.setIcon("svg/expand.svg");
        dashboardButton.setIcon("svg/dashboard.svg");
        dashboardButton.setName("Dashboard");
        accountButton.setIcon("svg/account.svg");
        accountButton.setName("Account");
        bookButton.setIcon("svg/book.svg");
        bookButton.setName("Book");
        bookCategoryButton.setIcon("svg/book-category.svg");
        bookCategoryButton.setName("Book Category");
        publisherButton.setIcon("svg/publisher.svg");
        publisherButton.setName("Publisher");
        authorButton.setIcon("svg/author.svg");
        authorButton.setName("Author");
        profileButton.setIcon("svg/profile.svg");
        profileButton.setName("Profile");
        logoutButton.setIcon("svg/logout.svg");
        logoutButton.setName("Logout");
        logoutButton.setBackground(new java.awt.Color(255, 112, 8));
        logoutButton.setNameBackground(new java.awt.Color(255, 112, 8));
        logoutButton.setIconBackground(new java.awt.Color(255, 112, 8));
        logoutButton.setLogoutButton();
        buttonList.add(dashboardButton);
        buttonList.add(accountButton);
        buttonList.add(bookButton);
        buttonList.add(bookCategoryButton);
        buttonList.add(publisherButton);
        buttonList.add(authorButton);
        buttonList.add(profileButton);
        buttonList.add(logoutButton);
        setIndex();
        this.setAction(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button button = (Button) evt.getSource();
                MenuButton buttonSelected = null;
                for (int i = 0; i < buttonList.size(); i++) {
                    if (buttonList.get(i).getSelected()) {
                        buttonSelected = buttonList.get(i);
                    }
                }
                for (int i = 0; i < buttonList.size(); i++) {
                    if ((buttonList.get(i).getName().equals(button.getName())
                            || buttonList.get(i).getIndex() == button.getIndex())
                            && (buttonList.get(i).getSelected() || buttonList.get(i).getEnable())
                            && !buttonList.get(i).getSelected()) {
                        if (buttonSelected != null) {
                            buttonSelected.setSelected(false);
                            buttonSelected.isSelected(false);
                        }
                        buttonList.get(i).setSelected(true);
                        // Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                        //         "Clicked " + button.getName());
                        admin.changeFrame(i);
                    }
                    // if (buttonList.get(i).getName().equals(button.getName()) &&
                    // buttonList.get(i).getSelected()) {
                    // Notifications.getInstance().show(Notifications.Type.ERROR,
                    // Notifications.Location.TOP_CENTER,
                    // "Unclicked " + button.getName());
                    // // buttonList.get(i).setSelected(false);
                    // }
                }
                if (button.getIndex() == 7 || button.getName().equals("Logout")) {
                    admin.logOut();
                }
            }
        });
    }

    public void setIsRunning(boolean isRunning){
        logo.setIsRunning(isRunning);
    }

    public void setIndex() {
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).setIndex(i);
        }
    }

    public void addListButton(MenuButton button) {
        buttonList.add(button);
    }

    public void setAction(java.awt.event.ActionListener action) {
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).setAction(action);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashboardButton = new com.lms.dashboard.menu.MenuButton();
        accountButton = new com.lms.dashboard.menu.MenuButton();
        bookButton = new com.lms.dashboard.menu.MenuButton();
        bookCategoryButton = new com.lms.dashboard.menu.MenuButton();
        publisherButton = new com.lms.dashboard.menu.MenuButton();
        authorButton = new com.lms.dashboard.menu.MenuButton();
        profileButton = new com.lms.dashboard.menu.MenuButton();
        logo = new com.lms.dashboard.menu.Logo(admin);
        logoutButton = new com.lms.dashboard.menu.MenuButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(accountButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(bookButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(bookCategoryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(publisherButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(authorButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(profileButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(dashboardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(publisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(authorButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lms.dashboard.menu.MenuButton accountButton;
    private com.lms.dashboard.menu.MenuButton authorButton;
    private com.lms.dashboard.menu.MenuButton bookButton;
    private com.lms.dashboard.menu.MenuButton bookCategoryButton;
    private com.lms.dashboard.menu.MenuButton dashboardButton;
    private com.lms.dashboard.menu.Logo logo;
    private com.lms.dashboard.menu.MenuButton logoutButton;
    private com.lms.dashboard.menu.MenuButton profileButton;
    private com.lms.dashboard.menu.MenuButton publisherButton;
    // End of variables declaration//GEN-END:variables
}
