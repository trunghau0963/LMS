package com.lms.dashboard.form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lms.book.main.BookView;
import com.lms.category.main.CategoryView;
import com.lms.dashboard.application.Application;
import com.lms.dashboard.menu.MenuAdmin;
import com.lms.dashboard.form.other.*;

public class Admin extends javax.swing.JPanel {

    int height;
    int weight;
    int widthMenu = 165;
    boolean isMenuOpen = false;
    private MainForm mainForm;
    private MenuAdmin menuAdmin;
    private javax.swing.JScrollPane scrollMenu;
    private javax.swing.JScrollPane scrollBody;
    private static Application app;
    public ArrayList<JPanel> listFrame = new ArrayList<JPanel>();

    public Admin(Application app) {
        this.app = app;
        initComponents();
        init();
        // setSize(new Dimension(w, h));
        this.addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {
                height = e.getComponent().getHeight();
                weight = e.getComponent().getWidth();
                // System.out.println(weight + " " + height);
            }

            public void componentHidden(ComponentEvent e) {
            }

            public void componentMoved(ComponentEvent e) {
            }

            public void componentShown(ComponentEvent e) {
            }
        });
    }

    public void init() {
        addListFrame();
        setBorder(new EmptyBorder(0, 5, 10, 10));
        // layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        // bg.setLayout(layout);
        bg.setLayout(new BorderLayout());
        // bg.setSize(new Dimension(960, 560));
        mainForm = new MainForm();
        menuAdmin = new MenuAdmin(this);
        scrollMenu = new javax.swing.JScrollPane();
        scrollMenu.setBackground(new java.awt.Color(39, 38, 44));
        scrollMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMenu.setViewportView(menuAdmin);
        scrollMenu.setPreferredSize(new Dimension(widthMenu, bg.getHeight()));

        scrollBody = new javax.swing.JScrollPane();
        scrollBody.setPreferredSize(new Dimension(bg.getWidth() - scrollMenu.getWidth(), bg.getHeight()));
        scrollBody.setViewportView(mainForm);

        bg.add(scrollMenu, BorderLayout.WEST);
        bg.add(scrollBody, BorderLayout.CENTER);

    }

    public void addListFrame() {
        listFrame.add(new dashboardForm());
        listFrame.add(new accountForm());
        listFrame.add(new BookView());
        listFrame.add(new CategoryView());
    }

    public void logOut() {
        app.logOut();
    }

    public void changeFrame(int index) {
        System.out.println(index);
        mainForm.showForm(listFrame.get(index));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        scrollMenu1 = new javax.swing.JScrollPane();
        menuAdmin1 = new com.lms.dashboard.menu.MenuAdmin();
        bg = new javax.swing.JLayeredPane();

        scrollMenu1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMenu1.setViewportView(menuAdmin1);

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
                bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bgPanelLayout.createSequentialGroup()
                                .addComponent(scrollMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(916, Short.MAX_VALUE)));
        bgPanelLayout.setVerticalGroup(
                bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 960, Short.MAX_VALUE));
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 540, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bg));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bg));
    }// </editor-fold>//GEN-END:initComponents

    public void openAndCloseButton(java.awt.event.ActionEvent evt) {
        if (scrollMenu.getWidth() < widthMenu) {
            openMenuBar();
            // System.out.println(scrollMenu.getWidth());
            // System.out.println(height);
            isMenuOpen = true;
        } else if (scrollMenu.getWidth() == widthMenu) {
            closeMenuBar();
            // System.out.println(scrollMenu.getWidth());
            isMenuOpen = false;
        }
    }

    public void openMenuBar() {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 42; i <= widthMenu; i++) {
                    try {
                        menuAdmin.setIsRunning(true);
                        Thread.sleep(0, 1);
                        scrollMenu.setSize(new Dimension(i, bg.getHeight()));
                        menuAdmin.setSize(new Dimension(i, bg.getHeight()));
                        scrollBody.setBounds(i, 0, weight - i, bg.getHeight());
                        mainForm.setSize(new Dimension(weight - i, bg.getHeight()));
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                menuAdmin.setIsRunning(false);
            }
        }).start();
    }

    public void closeMenuBar() {
        new Thread(new Runnable() {
            public void run() {
                for (int i = widthMenu; i > 42; i--) {
                    menuAdmin.setIsRunning(true);
                    try {
                        Thread.sleep(0, 1);
                        scrollMenu.setSize(new Dimension(i, bg.getHeight()));
                        menuAdmin.setSize(new Dimension(i, bg.getHeight()));
                        scrollBody.setBounds(i, 0, weight - i, bg.getHeight());
                        mainForm.setSize(new Dimension(weight - i, bg.getHeight()));

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                menuAdmin.setIsRunning(false);
            }
        }).start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JPanel bgPanel;
    private com.lms.dashboard.menu.MenuAdmin menuAdmin1;
    private javax.swing.JScrollPane scrollMenu1;
    // End of variables declaration//GEN-END:variables
}
