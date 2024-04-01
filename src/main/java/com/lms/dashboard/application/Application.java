package com.lms.dashboard.application;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.util.FontUtils;
import com.lms.auth.entities.User;
import com.lms.auth.repo.AuthRepo;
import com.lms.auth.service.AuthService;
import com.lms.dashboard.form.Admin;
import com.lms.dashboard.form.Emp;

public class Application extends javax.swing.JFrame {

    User user;
    int index;
    private static Application app;
    private final com.lms.auth.form.AuthView AuthView;
    private Admin admin;
    private Emp emp;
    private static AuthService authService;

    public Application(AuthService authService) {

        this.authService = authService;
        user = new User();

        initComponents();

        AuthView = new com.lms.auth.form.AuthView(authService);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // setLocationRelativeTo(null);

        app = this;
        admin = new Admin(app);
        emp = new Emp(app);
        app.setContentPane(app.AuthView);
        app.pack();
        app.setLocationRelativeTo(null);

    }

    // public void readFromFile(String filename, AuthService authService) throws IOException {
    //     BufferedReader reader = new BufferedReader(new FileReader(filename));
    //     String line;
    //     while ((line = reader.readLine()) != null) {

    //         String[] parts = line.split("\\t+\s*");
    //         if (parts.length >= 3) {
    //             try {
    //                 String username = parts[0];
    //                 String password = parts[1];
    //                 String role = parts[2];

    //                 if (role.equals("Admin")) {
    //                     System.out.println("Admin");
    //                     LoginForm = new com.lms.auth.form.Login(authService, username, password, role);
    //                     app.setContentPane(app.admin);
    //                     app.pack();
    //                     app.setLocationRelativeTo(null);
    //                 }
    //             } catch (NumberFormatException e) {
    //                 System.out.println("One of the parts cannot be parsed to a float: " + e.getMessage());
    //             }
    //         }
    //     }
    //     reader.close();
    // }

    public static void login() {
        // app.pack();
        // app.setLocationRelativeTo(null);
        FlatLaf.updateUI();
    }

    public static void logOut(){
        // app.pack();
        // app.setLocationRelativeTo(null);
        FlatLaf.updateUI();
    }

    public static void resetPw() {
        // app.pack();
        // app.setLocationRelativeTo(null);
        FlatLaf.updateUI();
    }

    public static void signUp() {
        // app.pack();
        // app.setLocationRelativeTo(null);
        FlatLaf.updateUI();
    }

    public static void dashboardAdmin() {
        app.setContentPane(app.admin);
        // app.pack();
        // app.setLocationRelativeTo(null);
        FlatLaf.updateUI();
    }

    public static void dashboardUser() {
        app.setContentPane(app.emp);
        // app.pack();
        // app.setLocationRelativeTo(null);
        FlatLaf.updateUI();
    }

    public static void setUserInformation(User user) {
        app.user = user;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        themeMenu = new javax.swing.JMenu();
        flatLightTheme = new javax.swing.JMenuItem();
        flatDarkTheme = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        darkFlatTheme = new javax.swing.JMenuItem();
        lightDarkTheme = new javax.swing.JMenuItem();
        cacbonTheme = new javax.swing.JMenuItem();
        colbaltTheme = new javax.swing.JMenuItem();
        darkPurpleTheme = new javax.swing.JMenuItem();
        draculaTheme = new javax.swing.JMenuItem();
        grayTheme = new javax.swing.JMenuItem();
        hiberbeeTheme = new javax.swing.JMenuItem();
        highConstrast = new javax.swing.JMenuItem();
        materialTheme = new javax.swing.JMenuItem();
        natureGreenTheme = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        darkFuchsiaTheme = new javax.swing.JMenuItem();
        deepOceanTheme = new javax.swing.JMenuItem();
        midnightBlueTheme = new javax.swing.JMenuItem();
        monocaiTheme = new javax.swing.JMenuItem();
        monokaiTheme = new javax.swing.JMenuItem();
        xcodeTheme = new javax.swing.JMenuItem();
        arcTheme = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        solariLight = new javax.swing.JMenuItem();
        solariDark = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        gruvboxHardTheme = new javax.swing.JMenuItem();
        gruvboxMediumTheme = new javax.swing.JMenuItem();
        gruvboxSoftTheme = new javax.swing.JMenuItem();
        nordTheme = new javax.swing.JMenuItem();
        onedarkTheme = new javax.swing.JMenuItem();
        vuesionTheme = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Account");
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Navigate");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("View");
        jMenuBar1.add(jMenu5);

        themeMenu.setText("Themes");

        flatLightTheme.setText("FlatLight");
        flatLightTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flatLightThemeActionPerformed(evt);
            }
        });
        themeMenu.add(flatLightTheme);

        flatDarkTheme.setText("FlatDark");
        flatDarkTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flatDarkThemeActionPerformed(evt);
            }
        });
        themeMenu.add(flatDarkTheme);
        themeMenu.add(jSeparator1);

        darkFlatTheme.setText("DarkFlat");
        darkFlatTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkFlatThemeActionPerformed(evt);
            }
        });
        themeMenu.add(darkFlatTheme);

        lightDarkTheme.setText("LightFlat");
        lightDarkTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightDarkThemeActionPerformed(evt);
            }
        });
        themeMenu.add(lightDarkTheme);

        cacbonTheme.setText("Cacbon");
        cacbonTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cacbonThemeActionPerformed(evt);
            }
        });
        themeMenu.add(cacbonTheme);

        colbaltTheme.setText("Colbalt");
        colbaltTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colbaltThemeActionPerformed(evt);
            }
        });
        themeMenu.add(colbaltTheme);

        darkPurpleTheme.setText("DarkPurple");
        darkPurpleTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkPurpleThemeActionPerformed(evt);
            }
        });
        themeMenu.add(darkPurpleTheme);

        draculaTheme.setText("Dracula");
        draculaTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draculaThemeActionPerformed(evt);
            }
        });
        themeMenu.add(draculaTheme);

        grayTheme.setText("Gray ");
        grayTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grayThemeActionPerformed(evt);
            }
        });
        themeMenu.add(grayTheme);

        hiberbeeTheme.setText("Hiberbee");
        hiberbeeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiberbeeThemeActionPerformed(evt);
            }
        });
        themeMenu.add(hiberbeeTheme);

        highConstrast.setText("HighConstrast");
        highConstrast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highConstrastActionPerformed(evt);
            }
        });
        themeMenu.add(highConstrast);

        materialTheme.setText("Material");
        materialTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialThemeActionPerformed(evt);
            }
        });
        themeMenu.add(materialTheme);

        natureGreenTheme.setText("Gradianto");

        jMenuItem14.setText("nature_green");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        natureGreenTheme.add(jMenuItem14);

        darkFuchsiaTheme.setText("dark_fuchsia");
        darkFuchsiaTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkFuchsiaThemeActionPerformed(evt);
            }
        });
        natureGreenTheme.add(darkFuchsiaTheme);

        deepOceanTheme.setText("deep_ocean");
        deepOceanTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deepOceanThemeActionPerformed(evt);
            }
        });
        natureGreenTheme.add(deepOceanTheme);

        midnightBlueTheme.setText("Midnight_blue");
        midnightBlueTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midnightBlueThemeActionPerformed(evt);
            }
        });
        natureGreenTheme.add(midnightBlueTheme);

        themeMenu.add(natureGreenTheme);

        monocaiTheme.setText("Monocai");
        monocaiTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monocaiThemeActionPerformed(evt);
            }
        });
        themeMenu.add(monocaiTheme);

        monokaiTheme.setText("Monokai");
        monokaiTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monokaiThemeActionPerformed(evt);
            }
        });
        themeMenu.add(monokaiTheme);

        xcodeTheme.setText("Xcode");
        xcodeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xcodeThemeActionPerformed(evt);
            }
        });
        themeMenu.add(xcodeTheme);

        arcTheme.setText("Arc");
        arcTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arcThemeActionPerformed(evt);
            }
        });
        themeMenu.add(arcTheme);

        jMenu7.setText("Solarizred");

        solariLight.setText("Light");
        solariLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solariLightActionPerformed(evt);
            }
        });
        jMenu7.add(solariLight);

        solariDark.setText("Dark");
        solariDark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solariDarkActionPerformed(evt);
            }
        });
        jMenu7.add(solariDark);

        themeMenu.add(jMenu7);

        jMenu8.setText("Gruvbox");

        gruvboxHardTheme.setText("hard");
        gruvboxHardTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gruvboxHardThemeActionPerformed(evt);
            }
        });
        jMenu8.add(gruvboxHardTheme);

        gruvboxMediumTheme.setText("medium");
        gruvboxMediumTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gruvboxMediumThemeActionPerformed(evt);
            }
        });
        jMenu8.add(gruvboxMediumTheme);

        gruvboxSoftTheme.setText("soft");
        gruvboxSoftTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gruvboxSoftThemeActionPerformed(evt);
            }
        });
        jMenu8.add(gruvboxSoftTheme);

        themeMenu.add(jMenu8);

        nordTheme.setText("Nord");
        nordTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nordThemeActionPerformed(evt);
            }
        });
        themeMenu.add(nordTheme);

        onedarkTheme.setText("One_dark");
        onedarkTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onedarkThemeActionPerformed(evt);
            }
        });
        themeMenu.add(onedarkTheme);

        vuesionTheme.setText("Vuesion");
        vuesionTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vuesionThemeActionPerformed(evt);
            }
        });
        themeMenu.add(vuesionTheme);

        jMenuBar1.add(themeMenu);

        jMenu9.setText("Font");

        jMenuItem32.setText("Default");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem32);

        jMenuItem30.setText("Algerian");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem30);

        jMenuItem31.setText("Arial");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem31);

        jMenuItem33.setText("Forte");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem33);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 960, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 517, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void flatLightThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_flatLightThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_flatLightThemeActionPerformed

    private void flatDarkThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_flatDarkThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_flatDarkThemeActionPerformed

    private void cacbonThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cacbonThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/Carbon.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_cacbonThemeActionPerformed

    private void colbaltThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_colbaltThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/Cobalt_2.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_colbaltThemeActionPerformed

    private void darkFlatThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_darkFlatThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/DarkFlatTheme.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_darkFlatThemeActionPerformed

    private void darkPurpleThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_darkPurpleThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/DarkPurple.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_darkPurpleThemeActionPerformed

    private void draculaThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_draculaThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/Dracula.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_draculaThemeActionPerformed

    private void grayThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_grayThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/Gray.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_grayThemeActionPerformed

    private void hiberbeeThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_hiberbeeThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/HiberbeeDark.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_hiberbeeThemeActionPerformed

    private void highConstrastActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_highConstrastActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/HighContrast.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_highConstrastActionPerformed

    private void lightDarkThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_lightDarkThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/LightFlatTheme.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_lightDarkThemeActionPerformed

    private void materialThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_materialThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/MaterialTheme.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_materialThemeActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem14ActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/Carbon.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_jMenuItem14ActionPerformed

    private void darkFuchsiaThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_darkFuchsiaThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream(
                                "/com/formdev/flatlaf/intellijthemes/themes/Gradianto_dark_fuchsia.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_darkFuchsiaThemeActionPerformed

    private void deepOceanThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deepOceanThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream(
                                "/com/formdev/flatlaf/intellijthemes/themes/Gradianto_deep_ocean.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_deepOceanThemeActionPerformed

    private void midnightBlueThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_midnightBlueThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream(
                                "/com/formdev/flatlaf/intellijthemes/themes/Gradianto_midnight_blue.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_midnightBlueThemeActionPerformed

    private void monocaiThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_monocaiThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/Monocai.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_monocaiThemeActionPerformed

    private void monokaiThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_monokaiThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream(
                                "/com/formdev/flatlaf/intellijthemes/themes/Monokai_Pro.default.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_monokaiThemeActionPerformed

    private void xcodeThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_xcodeThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/Xcode-Dark.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_xcodeThemeActionPerformed

    private void arcThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_arcThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/arc-theme.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_arcThemeActionPerformed

    private void solariLightActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_solariLightActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/SolarizedLight.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_solariLightActionPerformed

    private void solariDarkActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_solariDarkActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/SolarizedDark.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_solariDarkActionPerformed

    private void gruvboxHardThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_gruvboxHardThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream(
                                "/com/formdev/flatlaf/intellijthemes/themes/gruvbox_dark_hard.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_gruvboxHardThemeActionPerformed

    private void gruvboxMediumThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_gruvboxMediumThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream(
                                "/com/formdev/flatlaf/intellijthemes/themes/gruvbox_dark_medium.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_gruvboxMediumThemeActionPerformed

    private void gruvboxSoftThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_gruvboxSoftThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream(
                                "/com/formdev/flatlaf/intellijthemes/themes/gruvbox_dark_soft.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_gruvboxSoftThemeActionPerformed

    private void nordThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nordThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/nord.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_nordThemeActionPerformed

    private void onedarkThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_onedarkThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/one_dark.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_onedarkThemeActionPerformed

    private void vuesionThemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_vuesionThemeActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                IntelliJTheme.setup(Application.class
                        .getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/vuesion_theme.theme.json"));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE,
                        null, ex);
            }
        });
    }// GEN-LAST:event_vuesionThemeActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem32ActionPerformed
        String fontFamily = evt.getActionCommand();
        setFontFamily(fontFamily);
    }// GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem30ActionPerformed
        String fontFamily = evt.getActionCommand();
        setFontFamily(fontFamily);
    }// GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem31ActionPerformed
        String fontFamily = evt.getActionCommand();
        setFontFamily(fontFamily);
    }// GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem33ActionPerformed
        String fontFamily = evt.getActionCommand();
        setFontFamily(fontFamily);
    }// GEN-LAST:event_jMenuItem33ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    Application app = new Application(authService);
                    app.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // new Application().setVisible(true);
            }
        });
    }

    private void setFontFamily(String fontFamily) {
        Font font = UIManager.getFont("defaultFont");
        Font newFont = FontUtils.getCompositeFont(fontFamily, font.getStyle(), font.getSize());

        UIManager.put("defaultFont", newFont);
        FlatLaf.updateUI();
        FlatAnimatedLafChange.hideSnapshotWithAnimation();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem arcTheme;
    private javax.swing.JMenuItem cacbonTheme;
    private javax.swing.JMenuItem colbaltTheme;
    private javax.swing.JMenuItem darkFlatTheme;
    private javax.swing.JMenuItem darkFuchsiaTheme;
    private javax.swing.JMenuItem darkPurpleTheme;
    private javax.swing.JMenuItem deepOceanTheme;
    private javax.swing.JMenuItem draculaTheme;
    private javax.swing.JMenuItem flatDarkTheme;
    private javax.swing.JMenuItem flatLightTheme;
    private javax.swing.JMenuItem grayTheme;
    private javax.swing.JMenuItem gruvboxHardTheme;
    private javax.swing.JMenuItem gruvboxMediumTheme;
    private javax.swing.JMenuItem gruvboxSoftTheme;
    private javax.swing.JMenuItem hiberbeeTheme;
    private javax.swing.JMenuItem highConstrast;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem lightDarkTheme;
    private javax.swing.JMenuItem materialTheme;
    private javax.swing.JMenuItem midnightBlueTheme;
    private javax.swing.JMenuItem monocaiTheme;
    private javax.swing.JMenuItem monokaiTheme;
    private javax.swing.JMenu natureGreenTheme;
    private javax.swing.JMenuItem nordTheme;
    private javax.swing.JMenuItem onedarkTheme;
    private javax.swing.JMenuItem solariDark;
    private javax.swing.JMenuItem solariLight;
    private javax.swing.JMenu themeMenu;
    private javax.swing.JMenuItem vuesionTheme;
    private javax.swing.JMenuItem xcodeTheme;
    // End of variables declaration//GEN-END:variables
}
