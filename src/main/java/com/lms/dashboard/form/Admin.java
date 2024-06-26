package com.lms.dashboard.form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lms.informationCRUD.form.InfoPage;
import com.lms.accountCRUD.form.UsersView;
import com.lms.auth.entities.User;
import com.lms.authorCRUD.form.AuthorsView;
import com.lms.bookCRUD.form.BookView;
import com.lms.categoryCRUD.form.CategoryView;
import com.lms.dashboard.application.Application;
import com.lms.dashboard.menu.MenuAdmin;
import com.lms.dataSaleCRUD.form.dataSaleView;
import com.lms.dataSaleCRUD.repo.UserRepo;
import com.lms.dataSaleCRUD.service.UserService;
import com.lms.publisherCRUD.form.PublishersView;

public class Admin extends javax.swing.JPanel {

    int height;
    int weight;
    int widthMenu = 166;
    boolean isMenuOpen = false;
    private MainForm mainForm;
    private MenuAdmin menuAdmin;
    private javax.swing.JScrollPane scrollMenu;
    private javax.swing.JScrollPane scrollBody;
    private javax.swing.JToolBar toolbar;
    public ArrayList<JPanel> listFrame = new ArrayList<JPanel>();
    private Application application;
    private User adminUser;

    public Admin(Application app, User user) {
        application = app;
        adminUser = user;
        System.out.println("Admin: " + adminUser.toString());
        initComponents();
        init();

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
        menuAdmin = new MenuAdmin(this);
        toolbar = new javax.swing.JToolBar();
        scrollMenu = new javax.swing.JScrollPane();
        scrollMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMenu.setViewportView(menuAdmin);
        scrollMenu.setPreferredSize(new Dimension(widthMenu, bg.getHeight()));
        scrollMenu.setBorder(null);
        toolbar.add(scrollMenu);
        
        scrollBody = new javax.swing.JScrollPane();
        scrollBody.setPreferredSize(new Dimension(bg.getWidth() - scrollMenu.getWidth(), bg.getHeight()));
        scrollBody.setViewportView(mainForm);
        scrollBody.setBorder(null);

        bg.add(toolbar, BorderLayout.WEST);
        bg.add(scrollBody, BorderLayout.CENTER);

    }

    public void addListFrame() {
        listFrame.add(new dataSaleView());
        listFrame.add(new UsersView());
        listFrame.add(new BookView());
        listFrame.add(new CategoryView());
        listFrame.add(new PublishersView());
        listFrame.add(new AuthorsView());
        try {
            listFrame.add(new InfoPage(adminUser, "Admin"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // try {
        // listFrame.add(new EditProfile("17470f3a4f13c023"));
        // } catch (ParseException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // listFrame.add(new bookForm());
        // listFrame.add(new bookForm());
    }

    public void logOut() {
        application.logOut();
        // app.logOut();
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(bg)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
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
                    try {
                        menuAdmin.setIsRunning(true);
                        Thread.sleep(0, 1);
                        scrollMenu.setSize(new Dimension(i, bg.getHeight()));
                        menuAdmin.setSize(new Dimension(i, bg.getHeight()));
                        scrollBody.setBounds(i, 0, weight - i, bg.getHeight());
                        mainForm.setSize(new Dimension(weight - i, bg.getHeight()));
                        // mainForm.revalidate();
                        // mainForm.repaint();
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
                for (int i = widthMenu; i >= 40; i -= 9) {
                    menuAdmin.setIsRunning(true);
                    try {
                        Thread.sleep(0, 1);
                        scrollMenu.setSize(new Dimension(i, bg.getHeight()));
                        menuAdmin.setSize(new Dimension(i, bg.getHeight()));
                        scrollBody.setBounds(i, 0, weight - i, bg.getHeight());
                        mainForm.setSize(new Dimension(weight - i, bg.getHeight()));
                        // mainForm.revalidate();
                        // mainForm.repaint();

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
    // End of variables declaration//GEN-END:variables
}
