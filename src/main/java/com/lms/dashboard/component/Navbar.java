/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.dashboard.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import com.lms.dashboard.event.EventMenu;
import com.lms.dashboard.event.EventMenuSelected;
import com.lms.dashboard.event.EventShowPopupMenu;
import com.lms.dashboard.model.ModelMenu;
import com.lms.dashboard.ui.MenuAnimation;
import com.lms.dashboard.ui.MenuItem;
import com.lms.dashboard.ui.scrollbar.ScrollBarCustom;

import net.miginfocom.swing.MigLayout;
public class Navbar extends javax.swing.JPanel {

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    public Navbar() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
    }

    public ImageIcon resizedImage(String path){
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        java.awt.Image img = icon.getImage();
        java.awt.Image resizedImage = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    
    public void initMenuItem() {
        addMenu(new ModelMenu(resizedImage("/com/lms/dashboard/ui/icon/dashboard.png"), "Dashboard", "Home", "Books", "Categories", "Customers", "Employees"));
        addMenu(new ModelMenu(resizedImage("/com/lms/dashboard/ui/icon/account.png"), "Account"));
        addMenu(new ModelMenu(resizedImage("/com/lms/dashboard/ui/icon/book.png"), "Books", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(resizedImage("/com/lms/dashboard/ui/icon/category.png"), "Category", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(resizedImage("/com/lms/dashboard/ui/icon/author.png"), "Author", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(resizedImage("/com/lms/dashboard/ui/icon/publisher.png"), "Publisher", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(resizedImage("/com/lms/dashboard/ui/icon/user-profile.png"), "Profile", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(resizedImage("/com/lms/dashboard/ui/icon/13.png"), "Our Centres"));
        addMenu(new ModelMenu(resizedImage("/com/lms/dashboard/ui/icon/14.png"), "Gallery"));
    }


    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        logo1 = new com.lms.dashboard.component.Logo();

        setBackground(null);

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setOpaque(false);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        logo1.setBackground(new java.awt.Color(39, 38, 44));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(39,38,56), getWidth(), 0, new Color(39,38,56));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lms.dashboard.component.Logo logo1;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
