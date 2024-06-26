package com.lms.dashboard.form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lms.auth.entities.User;
import com.lms.authorCRUD.form.AuthorsView;
import com.lms.bookCRUD.form.BookView;
import com.lms.categoryCRUD.form.CategoryView;
import com.lms.dashboard.application.Application;
import com.lms.dashboard.menu.MenuEmp;
import com.lms.exportCRUD.form.ExportView;
import com.lms.importCRUD.form.ImportView;
import com.lms.informationCRUD.form.InfoPage;
import com.lms.publisherCRUD.form.PublishersView;
import com.lms.sheetCRUD.form.SheetView;

public class Emp extends javax.swing.JPanel {

    int widthMenu = 166;
    int height;
    int weight;
    boolean isMenuOpen = false;
    private MainForm mainForm;
    private MenuEmp menuEmp;
    private javax.swing.JScrollPane scrollMenu;
    private javax.swing.JScrollPane scrollBody;
    private javax.swing.JToolBar toolbar;
    private User empUser;
    private Application application;
    private ImportView importView;
    private ExportView exportView;
    private InfoPage infoPage;
    public ArrayList<JPanel> listFrame = new ArrayList<JPanel>();

    public Emp(Application app, User user) {
        this.application = app;
        this.empUser = user;
        application.setUserInformation(empUser);
        importView = new ImportView(empUser);
        exportView = new ExportView(empUser);
        try {
            infoPage = new InfoPage(empUser, "Employee");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Emp: " + empUser.toString());
        initComponents();
        init();
        // if (this.empUser != null && this.empUser.getId() != null) {
        // }
        this.addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {
                height = e.getComponent().getHeight();
                weight = e.getComponent().getWidth();
                System.out.println(weight + " " + height);
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
        bg.setLayout(new BorderLayout());
        // layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        // bg.setLayout(layout);
        // bg.setSize(new Dimension(960, 560));
        mainForm = new MainForm();
        menuEmp = new MenuEmp(this);
        toolbar = new javax.swing.JToolBar();
        scrollMenu = new javax.swing.JScrollPane();
        scrollMenu.setBackground(new java.awt.Color(39, 38, 44));
        scrollMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMenu.setViewportView(menuEmp);
        scrollMenu.setPreferredSize(new Dimension(widthMenu, bg.getHeight()));
        toolbar.add(scrollMenu);

        scrollBody = new javax.swing.JScrollPane();
        scrollBody.setPreferredSize(new Dimension(bg.getWidth() - scrollMenu.getWidth(), bg.getHeight()));
        scrollBody.setViewportView(mainForm);
        scrollBody.setBorder(null);

        bg.add(scrollMenu, BorderLayout.WEST);
        bg.add(scrollBody, BorderLayout.CENTER);

    }

    public void addListFrame() {
        listFrame.add(new BookView());
        listFrame.add(new CategoryView());
        listFrame.add(new PublishersView());
        listFrame.add(new AuthorsView());
        listFrame.add(importView);
        listFrame.add(exportView);
        listFrame.add(new SheetView());
        listFrame.add(infoPage);
    }

    public void logOut() {
        application.logOut();
    }

    public void changeFrame(int index) {
        System.out.println(index);
        mainForm.showForm(listFrame.get(index));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1074, Short.MAX_VALUE));
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 540, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bg)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING));
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
                for (int i = 40; i <= widthMenu; i += 9) {
                    menuEmp.setIsRunning(true);
                    try {
                        Thread.sleep(0, 1);
                        scrollMenu.setSize(new Dimension(i, bg.getHeight()));
                        menuEmp.setSize(new Dimension(i, bg.getHeight()));
                        scrollBody.setBounds(i, 0, weight - i, bg.getHeight());
                        mainForm.setSize(new Dimension(weight - i, bg.getHeight()));
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                menuEmp.setIsRunning(false);
            }
        }).start();
    }

    public void closeMenuBar() {
        new Thread(new Runnable() {
            public void run() {
                for (int i = widthMenu; i > 40; i -= 9) {
                    menuEmp.setIsRunning(true);
                    try {
                        Thread.sleep(0, 1);
                        scrollMenu.setSize(new Dimension(i, bg.getHeight()));
                        menuEmp.setSize(new Dimension(i, bg.getHeight()));
                        scrollBody.setBounds(i, 0, weight - i, bg.getHeight());
                        mainForm.setSize(new Dimension(weight - i, bg.getHeight()));

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                menuEmp.setIsRunning(false);
            }
        }).start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
