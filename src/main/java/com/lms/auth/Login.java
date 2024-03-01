package com.lms.auth;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import com.lms.auth.ui.Background;
import com.lms.auth.ui.PanelTransparent;
import com.lms.auth.ui.PasswordField;
import com.lms.auth.ui.Selection;
import com.lms.auth.ui.TextField;

import net.miginfocom.swing.MigLayout;

public class Login extends javax.swing.JFrame {

    UserService userService;

    private MigLayout layout;
    private Animator animatorLogin;
    private Animator animatorBody;
    private boolean signIn;

    private final double addSize = 30;
    private final double coverSize = 40;

    public Login() {
        initComponents();

        userService = new UserService();
        // init();
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));

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
                    txtUser.grabFocus();
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

        DefaultTableModel defaultTableModel = new DefaultTableModel();

        userTable.setModel(defaultTableModel);

        defaultTableModel.addColumn("Emp ID");
        defaultTableModel.addColumn("Emp Name");
        defaultTableModel.addColumn("DOB");
        defaultTableModel.addColumn("Phone Number");
        defaultTableModel.addColumn("Password");
        defaultTableModel.addColumn("gender");
        defaultTableModel.addColumn("isBlock");

        List<com.lms.auth.User> users = userService.getAllEmployees();

        for (com.lms.auth.User user : users) {
            defaultTableModel.addRow(new Object[] { user.getId(), user.getName(), user.getDob(), user.getPhoneNumber(),
                    user.getPwd(), user.getGender(), user.isIsBlock() });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.lms.ui.Background();
        panelLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPass = new com.lms.ui.PasswordField();
        signInButton = new javax.swing.JButton();
        txtUser = new com.lms.ui.TextField();
        signUptxt = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        selectionRole = new com.lms.ui.Selection();
        panelBody = new com.lms.ui.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        signOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background1.setLayout(new java.awt.CardLayout());

        panelLogin.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Sign In");

        txtPass.setLabelText("Password");
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        signInButton.setBackground(new java.awt.Color(0, 153, 153));
        signInButton.setForeground(new java.awt.Color(255, 255, 255));
        signInButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        signInButton.setLabel("Sign In");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        txtUser.setLabelText("Phone Number");

        signUptxt.setText("Don't have a account ?");

        signUpButton.setText("Sign Up");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        selectionRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Employee", "Customer", " " }));
        selectionRole.setSelectedIndex(-1);
        selectionRole.setLabeText("Role");
        selectionRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
            .addComponent(signInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signUptxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(selectionRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectionRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpButton)
                    .addComponent(signUptxt))
                .addGap(18, 18, 18)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        background1.add(panelLogin, "card2");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(userTable);

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
                .addContainerGap(78, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signOutButton)
                .addContainerGap(255, Short.MAX_VALUE))
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
            .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selectionRoleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_selectionRoleActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_selectionRoleActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtPassActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signOutButtonActionPerformed
        signIn = false;
        clearLogin();
        animatorBody.start(); // TODO add your handling code here:
    }// GEN-LAST:event_signOutButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signUpButtonActionPerformed
        SignUp SignUpFrame = new SignUp();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null);
        this.dispose();
    }// GEN-LAST:event_signUpButtonActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        if (!animatorLogin.isRunning()) {
            signIn = true;
            String user = txtUser.getText().trim();
            String pass = String.valueOf(txtPass.getPassword());
            String role = null;
            if (selectionRole.getSelectedItem() != null) {
                role = selectionRole.getSelectedItem().toString();
            }
            boolean action = true;
            if (user.equals("")) {
                txtUser.setHelperText("Please input user name");
                txtUser.grabFocus();
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
                txtPass.setHelperText("Please input password");
                if (action) {
                    txtPass.grabFocus();
                }
                action = false;
            }

            if (action) {
                System.out.println(user + " " + pass + " " + role);
                User userLogin = userService.logIn(user, pass, role);
                if (userLogin.getName() != null) {
                    // System.out.print(userLogin.getName());
                    animatorLogin.start();
                    enableLogin(false);
                } else {
                    txtUser.setHelperText("User does not exist or password is incorrect");
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
        txtPass.setEditable(action);
        signInButton.setEnabled(action);
    }

    public void clearLogin() {
        txtUser.setText("");
        txtPass.setText("");
        txtUser.setHelperText("");
        txtPass.setHelperText("");
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lms.ui.Background background1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.lms.ui.PanelTransparent panelBody;
    private javax.swing.JPanel panelLogin;
    private com.lms.ui.Selection selectionRole;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signOutButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel signUptxt;
    private com.lms.ui.PasswordField txtPass;
    private com.lms.ui.TextField txtUser;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
