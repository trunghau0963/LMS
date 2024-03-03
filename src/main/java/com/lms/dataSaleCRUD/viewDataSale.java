package com.lms.dataSaleCRUD;

import java.awt.Color;

import com.raven.chart.ModelChart;

public class viewDataSale extends javax.swing.JFrame {
    public viewDataSale() {
        initComponents();
        getContentPane().setBackground(new Color(250, 250, 250));
        chart1.addLegend("Income", new Color(255, 0, 77));
        chart1.addData(new ModelChart("Jan", new double[]{500}));
        chart1.addData(new ModelChart("Feb", new double[]{500}));
        chart1.addData(new ModelChart("Mar", new double[]{500}));
        chart1.addData(new ModelChart("Apr", new double[]{580}));
        chart1.addData(new ModelChart("May", new double[]{550}));
        chart1.addData(new ModelChart("June", new double[]{590}));

        chart2.addLegend("Income", new Color(245, 189, 135));
        chart2.addData(new ModelChart("Jan", new double[]{500}));
        chart2.addData(new ModelChart("Feb", new double[]{600}));
        chart2.addData(new ModelChart("Mar", new double[]{200}));
        chart2.addData(new ModelChart("Apr", new double[]{480}));
        chart2.addData(new ModelChart("May", new double[]{350}));
        chart2.addData(new ModelChart("June", new double[]{190}));

        chart3.addLegend("Income", new Color(245, 189, 135));
        chart3.addData(new ModelChart("Jan", new double[]{500}));
        chart3.addData(new ModelChart("Feb", new double[]{600}));
        chart3.addData(new ModelChart("Mar", new double[]{200}));
        chart3.addData(new ModelChart("Apr", new double[]{480}));
        chart3.addData(new ModelChart("May", new double[]{350}));
        chart3.addData(new ModelChart("June", new double[]{190}));

        chart4.addLegend("Income", new Color(245, 189, 135));
        chart4.addData(new ModelChart("Jan", new double[]{500}));
        chart4.addData(new ModelChart("Feb", new double[]{600}));
        chart4.addData(new ModelChart("Mar", new double[]{200}));
        chart4.addData(new ModelChart("Apr", new double[]{480}));
        chart4.addData(new ModelChart("May", new double[]{300}));
        chart4.addData(new ModelChart("June", new double[]{190}));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new com.lms.custom.Button();
        button2 = new com.lms.custom.Button();
        button3 = new com.lms.custom.Button();
        button4 = new com.lms.custom.Button();
        chart2 = new com.raven.chart.Chart();
        chart4 = new com.raven.chart.Chart();
        chart1 = new com.raven.chart.Chart();
        chart3 = new com.raven.chart.Chart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 630));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        button1.setBackground(new java.awt.Color(60, 58, 72));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("View data sale - Book");

        button2.setBackground(new java.awt.Color(60, 58, 72));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("View data sale - Employee");

        button3.setBackground(new java.awt.Color(60, 58, 72));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("View data sale - Category");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(60, 58, 72));
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setLabel("View data sale - Customer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chart3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(82, 82, 82)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chart3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        chart1.start();
        chart2.start();
        chart3.start();
        chart4.start();
    }//GEN-LAST:event_formWindowOpened

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewDataSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewDataSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewDataSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewDataSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewDataSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lms.custom.Button button1;
    private com.lms.custom.Button button2;
    private com.lms.custom.Button button3;
    private com.lms.custom.Button button4;
    private com.raven.chart.Chart chart1;
    private com.raven.chart.Chart chart2;
    private com.raven.chart.Chart chart3;
    private com.raven.chart.Chart chart4;
    // End of variables declaration//GEN-END:variables
}
