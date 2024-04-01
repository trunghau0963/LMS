package com.lms.auth;

import java.awt.Dimension;

import com.lms.auth.repo.AuthRepo;
import com.lms.auth.service.AuthService;

public class Application extends javax.swing.JFrame {

    private static Application app;
    private final com.lms.auth.form.AuthView AuthView;

    public Application() {

        AuthRepo authRepo = new AuthRepo();
        AuthService authService = new AuthService(authRepo);

        initComponents();
        setSize(new Dimension(960, 540));
        // setLocationRelativeTo(null);
        // setContentPane(LoginForm);
        AuthView = new com.lms.auth.form.AuthView(authService);
        app = this;
        // app.setLayout(new java.awt.BorderLayout());
        // app.add(app.LoginForm, java.awt.BorderLayout.CENTER);
        app.setContentPane(app.AuthView);
        app.pack();
        app.setLocationRelativeTo(null);
    }

    // public static void showForm(Component component) {
    // component.applyComponentOrientation(app.getComponentOrientation());
    // app.mainForm.showForm(component);
    // }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 960, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 540, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
                new Application().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
