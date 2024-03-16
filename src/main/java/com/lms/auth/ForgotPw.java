package com.lms.auth;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import com.lms.auth.dal.AuthDao;
import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.repo.AuthRepo;
import com.lms.auth.service.UserService;

import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;

public class ForgotPw extends javax.swing.JFrame {

    private MigLayout layout;
    private Animator animatorForgotPassword;
    private Animator animatorVerifyPassword;
    private boolean searchAccount;
    private String role;
    UserService userService;
    AuthDao authDao;
    private User user;

    private final double addSize = 30;
    private final double coverSize = 40;

    public ForgotPw() {
        initComponents();
        authDao = new AuthRepo();
        userService = new UserService(authDao);
        // init();
        getContentPane().setBackground(new java.awt.Color(39, 38, 44));

        TimingTarget targetForgotPassword = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (searchAccount) {
                    background1.setAnimate(fraction);
                } else {
                    background1.setAnimate(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (searchAccount) {
                    panelForgotPw.setVisible(false);
                    background1.setShowPaint(true);
                    panelVerify.setAlpha(0);
                    panelVerify.setVisible(true);
                    animatorVerifyPassword.start();
                } else {
                    enableLogin(true);
                    txtUser.grabFocus();
                }
            }
        };

        TimingTarget targetVerify = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (searchAccount) {
                    panelVerify.setAlpha(fraction);
                } else {
                    panelVerify.setAlpha(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (searchAccount == false) {
                    panelVerify.setVisible(false);
                    background1.setShowPaint(false);
                    background1.setAnimate(1);
                    panelForgotPw.setVisible(true);
                    animatorForgotPassword.start();
                }
            }
        };

        animatorForgotPassword = new Animator(1500, targetForgotPassword);
        animatorVerifyPassword = new Animator(500, targetVerify);
        animatorForgotPassword.setResolution(0);
        animatorVerifyPassword.setResolution(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.lms.auth.ui.Background();
        panelForgotPw = new javax.swing.JPanel();
        forgotPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchAccountButton = new javax.swing.JButton();
        signUptxt = new javax.swing.JLabel();
        signUpChangeButton = new javax.swing.JButton();
        txtUser = new com.lms.auth.ui.TextField();
        selectionRole = new com.lms.auth.ui.Selection();
        turnBackButton = new javax.swing.JButton();
        header1 = new com.lms.auth.component.Header();
        panelVerify = new com.lms.auth.ui.PanelTransparent();
        verifyPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        verifyButton1 = new javax.swing.JButton();
        txtNewPw1 = new com.lms.auth.ui.TextField();
        txtVerifyNewPw1 = new com.lms.auth.ui.TextField();
        header3 = new com.lms.auth.component.Header();
        bgPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background1.setLayout(new java.awt.CardLayout());

        panelForgotPw.setOpaque(false);

        forgotPanel.setBackground(new java.awt.Color(39, 38, 44));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Forgot Password  ");

        searchAccountButton.setBackground(new java.awt.Color(64, 68, 237));
        searchAccountButton.setForeground(new java.awt.Color(255, 255, 255));
        searchAccountButton.setText("Continue");
        searchAccountButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAccountButtonActionPerformed(evt);
            }
        });

        signUptxt.setForeground(new java.awt.Color(255, 255, 255));
        signUptxt.setText("Don’t have accout ?");

        signUpChangeButton.setText("Sign Up");
        signUpChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpChangeButtonActionPerformed(evt);
            }
        });

        txtUser.setBackground(new java.awt.Color(39, 38, 44));
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setToolTipText("");
        txtUser.setLabelText("Phone Number");

        selectionRole.setBackground(new java.awt.Color(39, 38, 44));
        selectionRole.setForeground(new java.awt.Color(255, 255, 255));
        selectionRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Employee" }));
        selectionRole.setSelectedIndex(-1);
        selectionRole.setLabeText("Role");

        turnBackButton.setBackground(new java.awt.Color(255, 112, 8));
        turnBackButton.setForeground(new java.awt.Color(255, 255, 255));
        turnBackButton.setText("Go back");
        turnBackButton.setBorder(null);
        turnBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout forgotPanelLayout = new javax.swing.GroupLayout(forgotPanel);
        forgotPanel.setLayout(forgotPanelLayout);
        forgotPanelLayout.setHorizontalGroup(
            forgotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forgotPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(forgotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(forgotPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 113, Short.MAX_VALUE))
                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectionRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(forgotPanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(signUptxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signUpChangeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgotPanelLayout.createSequentialGroup()
                .addComponent(turnBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        forgotPanelLayout.setVerticalGroup(
            forgotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forgotPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectionRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(forgotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(turnBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(forgotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpChangeButton)
                    .addComponent(signUptxt))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelForgotPwLayout = new javax.swing.GroupLayout(panelForgotPw);
        panelForgotPw.setLayout(panelForgotPwLayout);
        panelForgotPwLayout.setHorizontalGroup(
            panelForgotPwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelForgotPwLayout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addComponent(forgotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelForgotPwLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        panelForgotPwLayout.setVerticalGroup(
            panelForgotPwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelForgotPwLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(forgotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );

        background1.add(panelForgotPw, "card2");

        panelVerify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verifyPanel.setBackground(new java.awt.Color(39, 38, 44));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Forgot Password  ");

        verifyButton1.setBackground(new java.awt.Color(64, 68, 237));
        verifyButton1.setForeground(new java.awt.Color(255, 255, 255));
        verifyButton1.setText("Submit");
        verifyButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        verifyButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButton1ActionPerformed(evt);
            }
        });

        txtNewPw1.setBackground(new java.awt.Color(39, 38, 44));
        txtNewPw1.setForeground(new java.awt.Color(255, 255, 255));
        txtNewPw1.setToolTipText("");
        txtNewPw1.setLabelText("New Password");

        txtVerifyNewPw1.setBackground(new java.awt.Color(39, 38, 44));
        txtVerifyNewPw1.setForeground(new java.awt.Color(255, 255, 255));
        txtVerifyNewPw1.setLabelText("Verify New Password");

        javax.swing.GroupLayout verifyPanelLayout = new javax.swing.GroupLayout(verifyPanel);
        verifyPanel.setLayout(verifyPanelLayout);
        verifyPanelLayout.setHorizontalGroup(
            verifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verifyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(verifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(verifyPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 113, Short.MAX_VALUE))
                    .addComponent(txtNewPw1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVerifyNewPw1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(verifyButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        verifyPanelLayout.setVerticalGroup(
            verifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verifyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVerifyNewPw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(verifyButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        panelVerify.add(verifyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 106, -1, -1));
        panelVerify.add(header3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        bgPanel.setBackground(new java.awt.Color(39, 38, 44));

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        panelVerify.add(bgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1010, 700));

        background1.add(panelVerify, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void verifyButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_verifyButton1ActionPerformed
        String newPw = txtNewPw1.getText().trim();
        String verifyPw = txtVerifyNewPw1.getText().trim();
        boolean action = true;
        if (newPw.equals("")) {
            txtNewPw1.setHelperText("Please input new password");
            txtNewPw1.grabFocus();
            action = false;
        }
        if (verifyPw.equals("")) {
            txtVerifyNewPw1.setHelperText("Please input verify password");
            if (action) {
                txtVerifyNewPw1.grabFocus();
            }
            action = false;
        }
        if (role == "Admin") {
            Admin admin = new Admin();
            if (action) {
                if (newPw.equals(verifyPw)) {
                    admin = (Admin) userService.updatePassword(user, newPw);
                    System.out.println("Admin pw" + admin.getPwd());
                    if (newPw.equals(admin.getPwd())) {
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER,
                                "Password updated");
                        System.out.println("Password updated");
                        Login LoginFrame = new Login();
                        LoginFrame.setVisible(true);
                        LoginFrame.pack();
                        LoginFrame.setLocationRelativeTo(null);
                        this.dispose();
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER,
                                "Password not updated");
                        System.out.println("Password not updated");
                    }
                } else {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                            "Password not match");
                    txtVerifyNewPw1.setHelperText("Password not match");
                    txtVerifyNewPw1.grabFocus();
                }
            }
        }
        if (role == "Employee") {
            Employee employee = new Employee();
            if (action) {
                if (newPw.equals(verifyPw)) {
                    employee = (Employee) userService.updatePassword(user, newPw);
                    System.out.println("Employee: " + employee.getPwd());
                    if (newPw.equals(employee.getPwd())) {
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER,
                                "Password updated");
                        System.out.println("Password updated");
                        Login LoginFrame = new Login();
                        LoginFrame.setVisible(true);
                        LoginFrame.pack();
                        LoginFrame.setLocationRelativeTo(null);
                        this.dispose();
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER,
                                "update failed");
                        System.out.println("Password not updated");
                    }
                } else {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                            "Password not match");
                    txtVerifyNewPw1.setHelperText("Update failed");
                    txtVerifyNewPw1.grabFocus();
                }
            }

        }
    }// GEN-LAST:event_verifyButton1ActionPerformed

    private void turnBackButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_turnBackButtonActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }// GEN-LAST:event_turnBackButtonActionPerformed

    private void signUpChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signUpChangeButtonActionPerformed
        SignUp SignUpFrame = new SignUp();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null);
        this.dispose();
    }// GEN-LAST:event_signUpChangeButtonActionPerformed

    private void searchAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // VerifyPw VerifyPwFrame = new VerifyPw();
        // VerifyPwFrame.setVisible(true);
        // VerifyPwFrame.pack();
        // VerifyPwFrame.setLocationRelativeTo(null);
        // this.dispose();
        if (!animatorForgotPassword.isRunning()) {
            searchAccount = true;
            String userSearch = txtUser.getText().trim();
            if (selectionRole.getSelectedItem() != null) {
                role = selectionRole.getSelectedItem().toString();
            }
            boolean action = true;
            if (userSearch.equals("")) {
                txtUser.setHelperText("Please input user phone number");
                txtUser.grabFocus();
                action = false;
            }
            if (role.equals("")) {
                txtUser.setHelperText("Please select role");
                if (action) {
                    txtUser.grabFocus();
                }
                action = false;
            }

            if (action) {
                user = userService.forgotPassword(userSearch, role);

                if (user.getId() != null) {
                    System.out.println("User found" + user.getId() + " " + user.getPhoneNumber());
                    txtUser.setHelperText("");
                    animatorForgotPassword.start();
                    enableLogin(false);
                } else {
                    txtUser.setHelperText("User not found");
                    txtUser.grabFocus();
                }
            }
        }
    }// GEN-LAST:event_jButton1ActionPerformed

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textField1ActionPerformed

    private void enableLogin(boolean action) {
        txtUser.setEditable(action);
        selectionRole.setEditable(action);
        searchAccountButton.setEnabled(action);
    }

    public void clearLogin() {
        txtUser.setText("");
        txtUser.setHelperText("");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgotPw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lms.auth.ui.Background background1;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel forgotPanel;
    private com.lms.auth.component.Header header1;
    private com.lms.auth.component.Header header3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelForgotPw;
    private com.lms.auth.ui.PanelTransparent panelVerify;
    private javax.swing.JButton searchAccountButton;
    private com.lms.auth.ui.Selection selectionRole;
    private javax.swing.JButton signUpChangeButton;
    private javax.swing.JLabel signUptxt;
    private javax.swing.JButton turnBackButton;
    private com.lms.auth.ui.TextField txtNewPw1;
    private com.lms.auth.ui.TextField txtUser;
    private com.lms.auth.ui.TextField txtVerifyNewPw1;
    private javax.swing.JButton verifyButton1;
    private javax.swing.JPanel verifyPanel;
    // End of variables declaration//GEN-END:variables
}
