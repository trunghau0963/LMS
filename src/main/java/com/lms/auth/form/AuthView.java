package com.lms.auth.form;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import com.formdev.flatlaf.FlatClientProperties;
import com.lms.auth.controller.BCrypt;
import com.lms.auth.entities.Admin;
import com.lms.auth.entities.Employee;
import com.lms.auth.entities.User;
import com.lms.auth.service.AuthService;
import com.lms.dashboard.application.Application;

public class AuthView extends javax.swing.JPanel {

    private AuthService authService;
    private Application application;
    private User userLogin;

    public AuthView(AuthService authService, Application application, User user) {
        initComponents();
        this.userLogin = user;
        this.authService = authService;
        this.application = application;
        init();
    }

    public AuthView() {
        initComponents();
    }

    private void init() {

        txtPhoneNumberLogin.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your phone number");
        txtPassLogin.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your password");

        txtPassLogin.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtPassLogin.putClientProperty(FlatClientProperties.STYLE, "showRevealButton: true; showClearButton: true;");

        textPhoneNumber.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your phone number");
        txtUserName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your username");
        txtPassSignup.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your password");

        txtPassSignup.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtPassSignup.putClientProperty(FlatClientProperties.STYLE, "showRevealButton: true; showClearButton: true;");

        txtPhoneNumberLogin.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your phone number");
        txtNewPw.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your new password");
        txtVerifyNewPw.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Verify your new password");
        txtNewPw.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtNewPw.putClientProperty(FlatClientProperties.STYLE, "showRevealButton: true; showClearButton: true;");
        txtVerifyNewPw.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtVerifyNewPw.putClientProperty(FlatClientProperties.STYLE, "showRevealButton: true; showClearButton: true;");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        formLogin = new javax.swing.JPanel();
        signInLabel = new javax.swing.JLabel();
        signUpLabel = new javax.swing.JLabel();
        signUpChangeButton = new javax.swing.JButton();
        forgotPwButton = new javax.swing.JButton();
        rememberCheckbok = new javax.swing.JCheckBox();
        txtPhoneNumberLogin = new javax.swing.JTextField();
        txtPassLogin = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        phoneLable = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        signInButton = new javax.swing.JButton();
        errorPhone = new javax.swing.JLabel();
        errorPass = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        roleButton = new com.lms.auth.ui.ToggleButton();
        manualLabel = new javax.swing.JLabel();
        panelSignup = new javax.swing.JPanel();
        formSignUp = new javax.swing.JPanel();
        textPhoneNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        signUptxt = new javax.swing.JLabel();
        signInChangeButton = new javax.swing.JButton();
        txtUserName = new javax.swing.JTextField();
        txtPassSignup = new javax.swing.JPasswordField();
        usernameLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        signUpButton = new javax.swing.JButton();
        panelForgotPw = new javax.swing.JPanel();
        forgotPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        signUptxt1 = new javax.swing.JLabel();
        signUpChangeButton1 = new javax.swing.JButton();
        txtPhoneNumberSearch = new javax.swing.JTextField();
        searchAccountButton = new javax.swing.JButton();
        turnBackButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        errorFindAccount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelVerify = new com.lms.auth.ui.PanelTransparent();
        verifyPanel = new javax.swing.JPanel();
        resetPwTitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        changePwButton = new javax.swing.JButton();
        errorNewPw = new javax.swing.JLabel();
        errorVerify = new javax.swing.JLabel();
        userNameSearched = new javax.swing.JLabel();
        txtVerifyNewPw = new javax.swing.JPasswordField();
        txtNewPw = new javax.swing.JPasswordField();

        setLayout(new java.awt.CardLayout());

        signInLabel.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        signInLabel.setText("Sign in to Account");

        signUpLabel.setText("Don't have a account ?");

        signUpChangeButton.setText("Sign Up");
        signUpChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpChangeButtonActionPerformed(evt);
            }
        });

        forgotPwButton.setText("Forgot Password");
        forgotPwButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPwButtonActionPerformed(evt);
            }
        });

        rememberCheckbok.setText("Remember me");
        rememberCheckbok.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rememberCheckbok.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rememberCheckbok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberCheckbokActionPerformed(evt);
            }
        });

        phoneLable.setText("Phone Number");

        passLabel.setText("Password");

        signInButton.setBackground(new java.awt.Color(156, 63, 243));
        signInButton.setForeground(new java.awt.Color(255, 255, 255));
        signInButton.setText("Sign In");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        errorPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        errorPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jSeparator3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 20));

        manualLabel.setText("switch button to admin login");

        javax.swing.GroupLayout formLoginLayout = new javax.swing.GroupLayout(formLogin);
        formLogin.setLayout(formLoginLayout);
        formLoginLayout.setHorizontalGroup(
                formLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(formLoginLayout.createSequentialGroup()
                                .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorPass, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(signInButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(formLoginLayout.createSequentialGroup()
                                .addGroup(formLoginLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(signInLabel, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPhoneNumberLogin, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                        .addComponent(txtPassLogin, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                                .addGap(0, 1, Short.MAX_VALUE))
                        .addGroup(formLoginLayout.createSequentialGroup()
                                .addGroup(formLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(formLoginLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(formLoginLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(formLoginLayout.createSequentialGroup()
                                                                .addComponent(rememberCheckbok)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(forgotPwButton))
                                                        .addGroup(formLoginLayout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addComponent(signUpLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(signUpChangeButton)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(formLoginLayout.createSequentialGroup()
                                                .addComponent(phoneLable, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errorPhone, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(formLoginLayout.createSequentialGroup()
                                                .addGap(124, 124, 124)
                                                .addGroup(formLoginLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(roleButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLoginLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(manualLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)));
        formLoginLayout.setVerticalGroup(
                formLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formLoginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(signInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roleButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(manualLabel)
                                .addGap(29, 29, 29)
                                .addGroup(
                                        formLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(phoneLable, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(errorPhone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPhoneNumberLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        formLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(passLabel)
                                                .addComponent(errorPass))
                                .addGap(7, 7, 7)
                                .addComponent(txtPassLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(
                                        formLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(forgotPwButton)
                                                .addComponent(rememberCheckbok))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26,
                                        Short.MAX_VALUE)
                                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        formLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(signUpLabel)
                                                .addComponent(signUpChangeButton))
                                .addGap(22, 22, 22)));

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
                panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(0, 328, Short.MAX_VALUE)
                                .addComponent(formLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 327, Short.MAX_VALUE)));
        panelLoginLayout.setVerticalGroup(
                panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addComponent(formLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 25, Short.MAX_VALUE)));

        add(panelLogin, "login");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setText("Sign Up For Admin");

        signUptxt.setText("Already have account ?");

        signInChangeButton.setText("Sign In");
        signInChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInChangeButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("UserName");

        phoneLabel.setText("Phone Number");

        jLabel2.setText("Password");

        signUpButton.setBackground(new java.awt.Color(64, 68, 237));
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("Sign Up");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formSignUpLayout = new javax.swing.GroupLayout(formSignUp);
        formSignUp.setLayout(formSignUpLayout);
        formSignUpLayout.setHorizontalGroup(
                formSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formSignUpLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(signUptxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(signInChangeButton)
                                .addGap(49, 49, 49))
                        .addComponent(txtPassSignup)
                        .addComponent(signUpButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(formSignUpLayout.createSequentialGroup()
                                .addGroup(
                                        formSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formSignUpLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(jSeparator2)
                        .addComponent(txtUserName)
                        .addComponent(textPhoneNumber));
        formSignUpLayout.setVerticalGroup(
                formSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formSignUpLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(phoneLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPassSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(
                                        formSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(signUptxt)
                                                .addComponent(signInChangeButton))
                                .addContainerGap(27, Short.MAX_VALUE)));

        javax.swing.GroupLayout panelSignupLayout = new javax.swing.GroupLayout(panelSignup);
        panelSignup.setLayout(panelSignupLayout);
        panelSignupLayout.setHorizontalGroup(
                panelSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 960, Short.MAX_VALUE)
                        .addGroup(panelSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelSignupLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(formSignUp, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));
        panelSignupLayout.setVerticalGroup(
                panelSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 540, Short.MAX_VALUE)
                        .addGroup(panelSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelSignupLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(formSignUp, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));

        add(panelSignup, "signup");

        panelForgotPw.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Forgot Password");

        signUptxt1.setText("Don’t have accout ?");

        signUpChangeButton1.setText("Sign Up");
        signUpChangeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpChangeButton1ActionPerformed(evt);
            }
        });

        searchAccountButton.setBackground(new java.awt.Color(64, 68, 237));
        searchAccountButton.setForeground(new java.awt.Color(255, 255, 255));
        searchAccountButton.setText("Search");
        searchAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAccountButtonActionPerformed(evt);
            }
        });

        turnBackButton.setBackground(new java.awt.Color(255, 112, 8));
        turnBackButton.setText("Go back");
        turnBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnBackButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Phone Number");

        errorFindAccount.setForeground(new java.awt.Color(255, 0, 51));
        errorFindAccount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Admin Only");

        javax.swing.GroupLayout forgotPanel1Layout = new javax.swing.GroupLayout(forgotPanel1);
        forgotPanel1.setLayout(forgotPanel1Layout);
        forgotPanel1Layout.setHorizontalGroup(
                forgotPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPhoneNumberSearch)
                        .addComponent(searchAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(turnBackButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(forgotPanel1Layout.createSequentialGroup()
                                .addGroup(forgotPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(forgotPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errorFindAccount, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(forgotPanel1Layout.createSequentialGroup()
                                                .addGroup(forgotPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(forgotPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel6,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 298,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(forgotPanel1Layout.createSequentialGroup()
                                                                .addGap(41, 41, 41)
                                                                .addComponent(signUptxt1)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(signUpChangeButton1))
                                                        .addGroup(forgotPanel1Layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jSeparator4,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(forgotPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap()));
        forgotPanel1Layout.setVerticalGroup(
                forgotPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forgotPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(30, 30, 30)
                                .addGroup(forgotPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(errorFindAccount))
                                .addGap(7, 7, 7)
                                .addComponent(txtPhoneNumberSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(searchAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(turnBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23,
                                        Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(forgotPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUptxt1)
                                        .addComponent(signUpChangeButton1))
                                .addGap(28, 28, 28)));

        javax.swing.GroupLayout panelForgotPwLayout = new javax.swing.GroupLayout(panelForgotPw);
        panelForgotPw.setLayout(panelForgotPwLayout);
        panelForgotPwLayout.setHorizontalGroup(
                panelForgotPwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelForgotPwLayout.createSequentialGroup()
                                .addGap(0, 325, Short.MAX_VALUE)
                                .addComponent(forgotPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 325, Short.MAX_VALUE)));
        panelForgotPwLayout.setVerticalGroup(
                panelForgotPwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelForgotPwLayout.createSequentialGroup()
                                .addGap(0, 71, Short.MAX_VALUE)
                                .addComponent(forgotPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 72, Short.MAX_VALUE)));

        add(panelForgotPw, "search");

        resetPwTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        resetPwTitle.setForeground(new java.awt.Color(255, 255, 255));
        resetPwTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resetPwTitle.setText("Reset Password  ");

        jLabel4.setText("New Password");

        jLabel5.setText("Verify new password");

        changePwButton.setBackground(new java.awt.Color(64, 68, 237));
        changePwButton.setForeground(new java.awt.Color(255, 255, 255));
        changePwButton.setText("Continue");
        changePwButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePwButtonActionPerformed(evt);
            }
        });

        errorNewPw.setForeground(new java.awt.Color(255, 0, 0));
        errorNewPw.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        errorVerify.setForeground(new java.awt.Color(255, 0, 0));
        errorVerify.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        userNameSearched.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userNameSearched.setForeground(new java.awt.Color(255, 255, 255));
        userNameSearched.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userNameSearched.setText("jLabel3");

        javax.swing.GroupLayout verifyPanelLayout = new javax.swing.GroupLayout(verifyPanel);
        verifyPanel.setLayout(verifyPanelLayout);
        verifyPanelLayout.setHorizontalGroup(
                verifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(changePwButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(verifyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorVerify, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                        .addGroup(verifyPanelLayout.createSequentialGroup()
                                .addGroup(verifyPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(verifyPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errorNewPw, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(verifyPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(verifyPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(resetPwTitle,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(userNameSearched,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                .addContainerGap())
                        .addComponent(txtVerifyNewPw)
                        .addComponent(txtNewPw));
        verifyPanelLayout.setVerticalGroup(
                verifyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(verifyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(resetPwTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userNameSearched)
                                .addGap(30, 30, 30)
                                .addGroup(verifyPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(errorNewPw))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNewPw, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(verifyPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(errorVerify))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVerifyNewPw, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(changePwButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(56, Short.MAX_VALUE)));

        javax.swing.GroupLayout panelVerifyLayout = new javax.swing.GroupLayout(panelVerify);
        panelVerify.setLayout(panelVerifyLayout);
        panelVerifyLayout.setHorizontalGroup(
                panelVerifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelVerifyLayout.createSequentialGroup()
                                .addGap(326, 326, 326)
                                .addComponent(verifyPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(323, Short.MAX_VALUE)));
        panelVerifyLayout.setVerticalGroup(
                panelVerifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerifyLayout.createSequentialGroup()
                                .addContainerGap(80, Short.MAX_VALUE)
                                .addComponent(verifyPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)));

        add(panelVerify, "verify");
    }// </editor-fold>//GEN-END:initComponents

    private void rememberCheckbokActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rememberCheckbokActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_rememberCheckbokActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signUpButtonActionPerformed
        String user = txtUserName.getText().trim();
        String phone = textPhoneNumber.getText().trim();
        String pass = String.valueOf(txtPassSignup.getPassword());
        String role = "Admin";
        boolean action = true;

        if (user.equals("")) {
            errorPhone.setText("Please input user name");
            errorPhone.setForeground(new java.awt.Color(255, 0, 0));
            txtPhoneNumberLogin.grabFocus();
            action = false;
        }
        if (phone.equals("")) {
            errorPhone.setText("Please input phone number");
            errorPhone.setForeground(new java.awt.Color(255, 0, 0));
            txtPhoneNumberLogin.grabFocus();
            action = false;
        }
        if (pass.equals("")) {
            errorPass.setText("Please input password");
            errorPass.setForeground(new java.awt.Color(255, 0, 0));
            if (action) {
                txtPassLogin.grabFocus();
            }
            action = false;
        }
        if (!user.equals("")) {
            errorPhone.setText("");
        }
        if (!phone.equals("")) {
            errorPhone.setText("");
        }
        if (!pass.equals("")) {
            errorPass.setText("");
        }

        // System.out.println(user + " " + pass + " " + role);

        if (action) {
            signUp(authService, user, phone, pass);
        }
    }// GEN-LAST:event_signUpButtonActionPerformed

    private void signUp(AuthService authService, String user, String phone, String pass) {
        Admin admin = new Admin();
        admin = (Admin) authService.register(user, phone, pass, "Admin");
        if (admin.getName() != null) {
            JOptionPane.showMessageDialog(null, "Sign Up Success\n" + " Welcome " + admin.getName());
            CardLayout cardLayout = (CardLayout) this.getLayout();
            cardLayout.show(this, "login");
        } else {
            JOptionPane.showMessageDialog(null, "Sign Up Failed\n" + "User already exist");
            errorPhone.setText("User already exist or sthg went wrong");
            errorPhone.setForeground(new java.awt.Color(255, 0, 0));
            txtPhoneNumberLogin.grabFocus();
        }
        application.setUserInformation(admin);
    }

    private void signInChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signInChangeButtonActionPerformed
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, "login");

    }// GEN-LAST:event_signInChangeButtonActionPerformed

    private void signUpChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signUpChangeButtonActionPerformed
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, "signup");
    }// GEN-LAST:event_signUpChangeButtonActionPerformed

    private void forgotPwButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_forgotPwButtonActionPerformed
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, "search");
    }// GEN-LAST:event_forgotPwButtonActionPerformed

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signInButtonActionPerformed
        String user = txtPhoneNumberLogin.getText().trim();
        String pass = String.valueOf(txtPassLogin.getPassword());
        String role = "";
        if (roleButton.isSelected()) {
            role = "Admin";
        } else {
            role = "Employee";
        }
        // if (selectionRoleLogin.getSelectedItem() != null) {
        // role = selectionRoleLogin.getSelectedItem().toString();
        // }
        boolean action = true;

        if (user.equals("")) {
            errorPhone.setText("Please input user phone number");
            errorPhone.setForeground(new java.awt.Color(255, 0, 0));
            txtPhoneNumberLogin.grabFocus();
            action = false;
        }
        if (pass.equals("")) {
            errorPass.setText("Please input password");
            errorPass.setForeground(new java.awt.Color(255, 0, 0));
            if (action) {
                txtPassLogin.grabFocus();
            }
            action = false;
        }
        if (!user.equals("")) {
            errorPhone.setText("");
        }
        if (!pass.equals("")) {
            errorPass.setText("");
        }

        System.out.println(user + " " + pass + " " + role);

        if (action) {
            signInHash(authService, user, pass, role);
        }
    }// GEN-LAST:event_signInButtonActionPerformed

    private void signIn(AuthService authService, String user, String pass, String role) {

        userLogin = authService.logIn(user, pass, role);
        System.out.println("User login " + userLogin.toString());
        if (userLogin.getName() != null) {
            JOptionPane.showMessageDialog(null, "Login Success\n" + " Welcome " + userLogin.getName());
            final String finalRole = role;
            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((Timer) e.getSource()).stop(); // Stop the timer
                    if (finalRole.equals("Admin")) {
                        application.dashboardAdmin();
                        application.setUserInformation(userLogin);
                        txtPhoneNumberLogin.setText("");
                        txtPassLogin.setText("");
                    } else if (finalRole.equals("Employee")) {
                        application.dashboardUser();
                        application.setUserInformation(userLogin);
                        txtPhoneNumberLogin.setText("");
                        txtPassLogin.setText("");
                    }
                }
            });
            timer.setRepeats(false); // Ensure the timer only runs once
            timer.start();

        } else {
            JOptionPane.showMessageDialog(null, "Login Failed\n" + "User does not exist or password is incorrect");
            errorPhone.setText("User does not exist");
            errorPhone.setForeground(new java.awt.Color(255, 0, 0));
            txtPhoneNumberLogin.grabFocus();
        }
        application.setUserInformation(userLogin);
    }// GEN-LAST:event_signInButtonActionPerformed

    private void signInHash(AuthService authService, String user, String pass, String role) {
        if (role.equals("Admin")) { // Use equals for string comparison
            Admin admin = new Admin();
            admin = (Admin) authService.forgotPasswordAdmin(user);
            System.out.println("Admin" + admin.toString());
            // Check if admin or admin.getPwd() is null
            if (admin == null || admin.getPwd() == null || pass == null) {
                JOptionPane.showMessageDialog(null, "Login Failed\nUser does not exist or password is incorrect");
                errorPhone.setText("User does not exist");
                errorPhone.setForeground(new java.awt.Color(255, 0, 0));
                txtPhoneNumberLogin.grabFocus();
                return; // Exit the method
            }
            if (BCrypt.checkpw(pass, admin.getPwd())) {
                JOptionPane.showMessageDialog(null, "Login Success\nWelcome " + admin.getName());
                application.dashboardAdmin();
                application.setUserInformation(admin);
                txtPhoneNumberLogin.setText("");
                txtPassLogin.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed\nUser does not exist or password is incorrect");
                errorPhone.setText("User does not exist");
                errorPhone.setForeground(new java.awt.Color(255, 0, 0));
                txtPhoneNumberLogin.grabFocus();
            }
        } else {
            Employee employee = (Employee) authService.forgotPassworEmp(user);
            System.out.println("Employee" + employee.toString());
            // Check if employee or employee.getPwd() is null
            if (employee == null || employee.getPwd() == null || pass == null) {
                JOptionPane.showMessageDialog(null, "Login Failed\nUser does not exist or password is incorrect");
                errorPhone.setText("User does not exist");
                errorPhone.setForeground(new java.awt.Color(255, 0, 0));
                txtPhoneNumberLogin.grabFocus();
                return; // Exit the method
            }
            if (BCrypt.checkpw(pass, employee.getPwd())) {
                JOptionPane.showMessageDialog(null, "Login Success\nWelcome " + employee.getName());
                application.dashboardUser();
                application.setUserInformation(employee);
                txtPhoneNumberLogin.setText("");
                txtPassLogin.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed\nUser does not exist or password is incorrect");
                errorPhone.setText("User does not exist");
                errorPhone.setForeground(new java.awt.Color(255, 0, 0));
                txtPhoneNumberLogin.grabFocus();
            }
        }
    }

    private void changePwButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_changePwButtonActionPerformed
        String newPw = txtNewPw.getText().trim();
        String verifyPw = txtVerifyNewPw.getText().trim();
        boolean action = true;

        if (newPw.equals("")) {
            errorNewPw.setText("Please input new password");
            errorNewPw.setForeground(new java.awt.Color(255, 0, 0));
            txtNewPw.grabFocus();
            action = false;
        }
        if (!newPw.equals("")) {
            errorNewPw.setText("");
        }

        if (verifyPw.equals("")) {
            errorVerify.setText("Please input verify password");
            errorVerify.setForeground(new java.awt.Color(255, 0, 0));
            txtVerifyNewPw.grabFocus();
            action = false;
        }
        if (!verifyPw.equals("")) {
            errorVerify.setText("");
        }

        if (!newPw.equals(verifyPw)) {
            errorNewPw.setText("Verify password not match");
            errorNewPw.setForeground(new java.awt.Color(255, 0, 0));
            txtVerifyNewPw.grabFocus();
            action = false;
            // Notifications.getInstance().show(Notifications.Type.ERROR,
            // Notifications.Location.TOP_CENTER,
            // "Verify password not match");
            JOptionPane.showMessageDialog(null, "Verify password not match");
        }
        if (newPw.equals(verifyPw)) {
            errorNewPw.setText("");
        }
        Admin admin = new Admin();
        if (action) {
            System.out.println("User id" + userLogin.getId());
            admin = (Admin) authService.updatePassword(userLogin, newPw);
            System.out.println("Admin pw" + admin.getPwd());
            if (BCrypt.checkpw(newPw, admin.getPwd())) {
                // Notifications.getInstance().show(Notifications.Type.SUCCESS,
                // Notifications.Location.TOP_CENTER,
                // "Password updated");
                JOptionPane.showMessageDialog(null, "Password updated");
                System.out.println("Password updated");
                CardLayout cardLayout = (CardLayout) this.getLayout();
                cardLayout.show(this, "login");
            } else {
                // Notifications.getInstance().show(Notifications.Type.ERROR,
                // Notifications.Location.TOP_CENTER,
                // "Password not updated");
                JOptionPane.showMessageDialog(null, "Password not updated");
            }
        }
    }// GEN-LAST:event_changePwButtonActionPerformed

    private void signUpChangeButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_signUpChangeButton1ActionPerformed
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, "signup");
    }// GEN-LAST:event_signUpChangeButton1ActionPerformed

    private void searchAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchAccountButtonActionPerformed
        String userSearch = txtPhoneNumberSearch.getText().trim();
        boolean action = true;

        if (userSearch.equals("")) {
            errorFindAccount.setText("Please input user phone number");
            errorFindAccount.setForeground(new java.awt.Color(255, 0, 0));
            txtPhoneNumberSearch.grabFocus();
            action = false;
        }
        if (!userSearch.equals("")) {
            errorFindAccount.setText("");
        }

        if (action) {
            userLogin = authService.forgotPasswordAdmin(userSearch);
            if (userLogin.getId() != null) {
                System.out.println("User found" + userLogin.getId() + " " + userLogin.getPhoneNumber());
                CardLayout cardLayout = (CardLayout) this.getLayout();
                cardLayout.show(this, "verify");
                userNameSearched.setText("For " + userLogin.getName());
                // Notifications.getInstance().show(Notifications.Type.SUCCESS,
                // Notifications.Location.TOP_CENTER,
                // "Welcome " + user.getName());
                JOptionPane.showMessageDialog(null, "User found\n" + " Welcome " + userLogin.getName());
            } else {
                errorFindAccount.setText("User not found");
                errorFindAccount.setForeground(new java.awt.Color(255, 0, 0));
                errorFindAccount.grabFocus();
                // Notifications.getInstance().show(Notifications.Type.ERROR,
                // Notifications.Location.TOP_CENTER,
                // "User not found");
                JOptionPane.showMessageDialog(null, "User not found");
            }
        }
    }// GEN-LAST:event_searchAccountButtonActionPerformed

    private void turnBackButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_turnBackButtonActionPerformed
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, "login");
    }// GEN-LAST:event_turnBackButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePwButton;
    private javax.swing.JLabel errorFindAccount;
    private javax.swing.JLabel errorNewPw;
    private javax.swing.JLabel errorPass;
    private javax.swing.JLabel errorPhone;
    private javax.swing.JLabel errorVerify;
    private javax.swing.JPanel forgotPanel1;
    private javax.swing.JButton forgotPwButton;
    private javax.swing.JPanel formLogin;
    private javax.swing.JPanel formSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel manualLabel;
    private javax.swing.JPanel panelForgotPw;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelSignup;
    private com.lms.auth.ui.PanelTransparent panelVerify;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel phoneLable;
    private javax.swing.JCheckBox rememberCheckbok;
    private javax.swing.JLabel resetPwTitle;
    private com.lms.auth.ui.ToggleButton roleButton;
    private javax.swing.JButton searchAccountButton;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signInChangeButton;
    private javax.swing.JLabel signInLabel;
    private javax.swing.JButton signUpButton;
    private javax.swing.JButton signUpChangeButton;
    private javax.swing.JButton signUpChangeButton1;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JLabel signUptxt;
    private javax.swing.JLabel signUptxt1;
    private javax.swing.JTextField textPhoneNumber;
    private javax.swing.JButton turnBackButton;
    private javax.swing.JPasswordField txtNewPw;
    private javax.swing.JPasswordField txtPassLogin;
    private javax.swing.JPasswordField txtPassSignup;
    private javax.swing.JTextField txtPhoneNumberLogin;
    private javax.swing.JTextField txtPhoneNumberSearch;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JPasswordField txtVerifyNewPw;
    private javax.swing.JLabel userNameSearched;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JPanel verifyPanel;
    // End of variables declaration//GEN-END:variables
}
