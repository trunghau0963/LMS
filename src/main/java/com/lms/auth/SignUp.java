package com.lms.auth;

import javax.management.Notification;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import com.lms.auth.dal.AuthDao;
import com.lms.auth.entities.User;
import com.lms.auth.repo.AuthRepo;
import com.lms.auth.service.UserService;

import raven.toast.Notifications;

public class SignUp extends javax.swing.JFrame {

    UserService userService;
    AuthDao authDao;
    private Animator animatorLogin;
    private Animator animatorBody;
    private boolean signIn;

    public SignUp() {
        initComponents();

        authDao = new AuthRepo();
        userService = new UserService(authDao);

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
                    panelLogin.setVisible(false);
                    background1.setShowPaint(true);
                    panelBody.setAlpha(0);
                    panelBody.setVisible(true);
                    animatorBody.start();
                } else {
                    enableLogin(true);
                    txtUserName.grabFocus();
                }
            }
        };

        TimingTarget targetBody = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    panelBody.setAlpha(fraction);
                } else {
                    panelBody.setAlpha(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn == false) {
                    panelBody.setVisible(false);
                    background1.setShowPaint(false);
                    background1.setAnimate(1);
                    panelLogin.setVisible(true);
                    animatorLogin.start();
                }
            }
        };

        animatorLogin = new Animator(1500, targetLogin);
        animatorBody = new Animator(500, targetBody);
        animatorLogin.setResolution(0);
        animatorBody.setResolution(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.lms.auth.ui.Background();
        panelLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPass = new com.lms.auth.ui.PasswordField();
        signUpButton = new javax.swing.JButton();
        txtUserName = new com.lms.auth.ui.TextField();
        signUptxt = new javax.swing.JLabel();
        signInChangeButton = new javax.swing.JButton();
        textPhoneNumber = new com.lms.auth.ui.TextField();
        selectionRole = new com.lms.auth.ui.Selection();
        header1 = new com.lms.auth.component.Header();
        panelBody = new com.lms.auth.ui.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        signOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background1.setLayout(new java.awt.CardLayout());

        panelLogin.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(39, 38, 44));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sign Up");

        txtPass.setBackground(new java.awt.Color(39, 38, 44));
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setLabelText("Password");
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        signUpButton.setBackground(new java.awt.Color(64, 68, 237));
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("Sign Up");
        signUpButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        txtUserName.setBackground(new java.awt.Color(39, 38, 44));
        txtUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUserName.setLabelText("Full Name");

        signUptxt.setForeground(new java.awt.Color(255, 255, 255));
        signUptxt.setText("Already have account ?");

        signInChangeButton.setText("Sign In");
        signInChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInChangeButtonActionPerformed(evt);
            }
        });

        textPhoneNumber.setBackground(new java.awt.Color(39, 38, 44));
        textPhoneNumber.setForeground(new java.awt.Color(255, 255, 255));
        textPhoneNumber.setToolTipText("");
        textPhoneNumber.setLabelText("Phone Number");

        selectionRole.setBackground(new java.awt.Color(39, 38, 44));
        selectionRole.setForeground(new java.awt.Color(255, 255, 255));
        selectionRole.setMaximumRowCount(20);
        selectionRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Employee" }));
        selectionRole.setSelectedIndex(-1);
        selectionRole.setLabeText("Role");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(textPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(selectionRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(signUptxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signInChangeButton)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectionRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInChangeButton)
                    .addComponent(signUptxt))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        background1.add(panelLogin, "card2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        signOutButton.setText("Sign Out");
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(signOutButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signOutButton)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        signOutButton.getAccessibleContext().setAccessibleName("SignOut");

        background1.add(panelBody, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtPassActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signOutButtonActionPerformed
        signIn = false;
        clearLogin();
        animatorBody.start(); // TODO add your handling code here:
    }// GEN-LAST:event_signOutButtonActionPerformed

    private void signInChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signInChangeButtonActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }// GEN-LAST:event_signInChangeButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        if (!animatorLogin.isRunning()) {
            signIn = true;
            String userName = txtUserName.getText().trim();
            String userPhoneNumber = textPhoneNumber.getText().trim();
            String pass = String.valueOf(txtPass.getPassword());
            String role = null;
            if (selectionRole.getSelectedItem() != null) {
                role = selectionRole.getSelectedItem().toString();
            }
            boolean action = true;
            if (userName.equals("")) {
                txtUserName.setHelperText("Please input user name");
                txtUserName.grabFocus();
                action = false;
            }
            if (userPhoneNumber.equals("")) {
                textPhoneNumber.setHelperText("Please input phone number");
                if (action) {
                    textPhoneNumber.grabFocus();
                }
                action = false;
            }
            if (pass.equals("")) {
                txtPass.setHelperText("Please input password");
                if (action) {
                    txtPass.grabFocus();
                }
                action = false;
            }
            if (role.equals("")) {
                txtPass.setHelperText("Please select role");
                if (action) {
                    txtPass.grabFocus();
                }
                action = false;
            }
            if (action) {
                User userRegister = userService.register(userName, userPhoneNumber, pass, role);
                if (userRegister != null) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "User Register Successfully");
                    System.out.println("User Register: " + userRegister.getPhoneNumber());
                    Login LoginFrame = new Login();
                    LoginFrame.setVisible(true);
                    LoginFrame.pack();
                    LoginFrame.setLocationRelativeTo(null);
                    this.dispose();
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR,
                            "User does not exist or password is incorrect");
                    clearLogin();
                    txtUserName.setHelperText("User does not exist or password is incorrect");
                    txtUserName.grabFocus();
                }
            }
        }
    }// GEN-LAST:event_jButton1ActionPerformed

    private void enableLogin(boolean action) {
        txtUserName.setEditable(action);
        txtPass.setEditable(action);
        signUpButton.setEnabled(action);
    }

    public void clearLogin() {
        txtUserName.setText("");
        textPhoneNumber.setText("");
        txtPass.setText("");
        textPhoneNumber.setHelperText("");
        txtUserName.setHelperText("");
        txtPass.setHelperText("");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lms.auth.ui.Background background1;
    private com.lms.auth.component.Header header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.lms.auth.ui.PanelTransparent panelBody;
    private javax.swing.JPanel panelLogin;
    private com.lms.auth.ui.Selection selectionRole;
    private javax.swing.JButton signInChangeButton;
    private javax.swing.JButton signOutButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel signUptxt;
    private com.lms.auth.ui.TextField textPhoneNumber;
    private com.lms.auth.ui.PasswordField txtPass;
    private com.lms.auth.ui.TextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
