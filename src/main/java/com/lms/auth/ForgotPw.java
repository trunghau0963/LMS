package com.lms.auth;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import net.miginfocom.swing.MigLayout;

public class ForgotPw extends javax.swing.JFrame {

    private MigLayout layout;
    private Animator animatorLogin;
    private boolean signIn;

    private final double addSize = 30;
    private final double coverSize = 40;

    public ForgotPw() {
        initComponents();
        // init();
        getContentPane().setBackground(new java.awt.Color(39, 38, 44));

        TimingTarget targetLogin = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    background1.setAnimate(fraction);
                } else {
                    background1.setAnimate(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn) {
                    panelForgotPw.setVisible(false);
                    background1.setShowPaint(true);
                } else {
                    enableLogin(true);
                    txtUser.grabFocus();
                }
            }
        };


        animatorLogin = new Animator(1500, targetLogin);
        animatorLogin.setResolution(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.lms.auth.ui.Background();
        panelForgotPw = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchAccountButton = new javax.swing.JButton();
        signUptxt = new javax.swing.JLabel();
        signUpChangeButton = new javax.swing.JButton();
        txtUser = new com.lms.auth.ui.TextField();
        userRole = new com.lms.auth.ui.Selection();
        turnBackButton = new javax.swing.JButton();
        header1 = new com.lms.auth.component.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background1.setLayout(new java.awt.CardLayout());

        panelForgotPw.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(39, 38, 44));

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

        userRole.setBackground(new java.awt.Color(39, 38, 44));
        userRole.setForeground(new java.awt.Color(255, 255, 255));
        userRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Employee", "Customer", " " }));
        userRole.setSelectedIndex(-1);
        userRole.setLabeText("Role");

        turnBackButton.setBackground(new java.awt.Color(255, 112, 8));
        turnBackButton.setForeground(new java.awt.Color(255, 255, 255));
        turnBackButton.setText("Go back");
        turnBackButton.setBorder(null);
        turnBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 113, Short.MAX_VALUE))
                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(signUptxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signUpChangeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(turnBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(turnBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpChangeButton)
                    .addComponent(signUptxt))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelForgotPwLayout = new javax.swing.GroupLayout(panelForgotPw);
        panelForgotPw.setLayout(panelForgotPwLayout);
        panelForgotPwLayout.setHorizontalGroup(
            panelForgotPwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelForgotPwLayout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
            .addComponent(header1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelForgotPwLayout.setVerticalGroup(
            panelForgotPwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelForgotPwLayout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        background1.add(panelForgotPw, "card2");

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
        VerifyPw VerifyPwFrame = new VerifyPw();
        VerifyPwFrame.setVisible(true);
        VerifyPwFrame.pack();
        VerifyPwFrame.setLocationRelativeTo(null);
        this.dispose();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textField1ActionPerformed

    private void enableLogin(boolean action) {
        txtUser.setEditable(action);
        userRole.setEditable(action);
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
    private com.lms.auth.component.Header header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelForgotPw;
    private javax.swing.JButton searchAccountButton;
    private javax.swing.JButton signUpChangeButton;
    private javax.swing.JLabel signUptxt;
    private javax.swing.JButton turnBackButton;
    private com.lms.auth.ui.TextField txtUser;
    private com.lms.auth.ui.Selection userRole;
    // End of variables declaration//GEN-END:variables
}
