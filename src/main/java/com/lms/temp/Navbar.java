package com.lms.temp;

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

    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/1.png")), "Dashboard", "Home", "Buttons", "Cards", "Tabs", "Accordions", "Modals"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/2.png")), "Charts", "Morris", "Flot", "Line"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/3.png")), "Report", "Income", "Expense", "Profit"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/4.png")), "Message", "Sender", "Inbox", "User"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/5.png")), "Staff", "Sender", "Inbox", "User"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/6.png")), "Student", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/7.png")), "Library", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/8.png")), "Holiday", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/9.png")), "Calendar", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/10.png")), "Chat App", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/11.png")), "Contace", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/12.png")), "File Manager", "Menu 001", "Menu 002", "Menu 003"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/13.png")), "Our Centres"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/lms/dashboard/ui/icon/14.png")), "Gallery"));
    }


    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                // if (enableMenu) {
                //     if (isShowMenu()) {
                //         if (open) {
                //             new MenuAnimation(layout, com).openMenu();
                //         } else {
                //             new MenuAnimation(layout, com).closeMenu();
                //         }
                //         return true;
                //     } else {
                //         eventShowPopup.showPopup(com);
                //     }
                // }
                // return false;
                System.out.println("Menu pressed");
                return true;
            }
        };
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(39, 38, 44), getWidth(), 0, new Color(60, 58, 72));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}