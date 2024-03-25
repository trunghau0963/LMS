package com.lms.dashboard.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import com.lms.dashboard.component.Header;
import com.lms.dashboard.component.Navbar;
import com.lms.dashboard.event.EventMenuSelected;
import com.lms.dashboard.event.EventShowPopupMenu;
import com.lms.dashboard.form.Form1;
import com.lms.dashboard.form.Form_Home;
import com.lms.dashboard.form.MainForm;
import com.lms.dashboard.ui.MenuItem;
import com.lms.dashboard.ui.PopupMenu;

import net.miginfocom.swing.MigLayout;

public class DashboardAdmin extends javax.swing.JFrame {

    private MigLayout layout;
    private Navbar navbar;
    private Header header;
    private MainForm mainForm;
    private Animator animator;

    public DashboardAdmin() {
        initComponents();
        init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%,fill]0", "0[fill,top]0");
        bg.setLayout(layout);

        navbar = new Navbar();
        header = new Header();
        mainForm = new MainForm();
        navbar.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        mainForm.showForm(new Form_Home());
                    } else if (subMenuIndex == 1) {
                        mainForm.showForm(new Form1());
                    }
                }
            }
        });
        navbar.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(DashboardAdmin.this, item.getIndex(), item.getEventSelected(),
                        item.getMenu().getSubMenu());
                int x = DashboardAdmin.this.getX() + 67;
                int y = DashboardAdmin.this.getY() + com.getY() + 110;
                popup.setLocation(x, y);
                popup.setVisible(true);
                System.out.println("Show Popup");
            }
        });

        navbar.initMenuItem();
        bg.add(navbar, "w 165!, spany 2");
        bg.add(header, "h 50!, wrap");
        bg.add(mainForm, "w 100%, h 100%");

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (navbar.isShowMenu()) {
                    width = 60 + (105 * (1f - fraction));
                } else {
                    width = 60 + (105 * fraction);
                }
                layout.setComponentConstraints(navbar, "w " + width + "!, spany2");
                navbar.revalidate();
            }

            @Override
            public void end() {
                navbar.setShowMenu(!navbar.isShowMenu());
                navbar.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                navbar.setEnableMenu(false);
                if (navbar.isShowMenu()) {
                    navbar.hideallMenu();
                }
            }
        });

        mainForm.showForm(new Form_Home());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
