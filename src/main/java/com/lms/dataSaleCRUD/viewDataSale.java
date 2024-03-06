package com.lms.dataSaleCRUD;

import java.awt.Color;

import com.lms.dataSaleCRUD.component.chart.ModelChart;

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

        btn1 = new com.lms.dataSaleCRUD.ui.Button();
        btn2 = new com.lms.dataSaleCRUD.ui.Button();
        btn3 = new com.lms.dataSaleCRUD.ui.Button();
        btn4 = new com.lms.dataSaleCRUD.ui.Button();
        chart2 = new com.lms.dataSaleCRUD.component.chart.Chart();
        chart4 = new com.lms.dataSaleCRUD.component.chart.Chart();
        chart1 = new com.lms.dataSaleCRUD.component.chart.Chart();
        chart3 = new com.lms.dataSaleCRUD.component.chart.Chart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 630));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(60, 58, 72));
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setLabel("View data sale - Book");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(60, 58, 72));
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setLabel("View data sale - Employee");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(60, 58, 72));
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setLabel("View data sale - Category");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(60, 58, 72));
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setLabel("View data sale - Customer");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chart3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(82, 82, 82)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        viewDataSaleCategory viewCategory = new viewDataSaleCategory();
        viewCategory.setVisible(true);
        viewCategory.pack();
        viewCategory.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        viewDataSaleBook viewBook = new viewDataSaleBook();
        viewBook.setVisible(true);
        viewBook.pack();
        viewBook.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        viewDataSaleEmployee viewEmployee = new viewDataSaleEmployee();
        viewEmployee.setVisible(true);
        viewEmployee.pack();
        viewEmployee.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        viewDataSaleCustomer viewCustomer = new viewDataSaleCustomer();
        viewCustomer.setVisible(true);
        viewCustomer.pack();
        viewCustomer.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn4ActionPerformed

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
    private com.lms.dataSaleCRUD.ui.Button btn1;
    private com.lms.dataSaleCRUD.ui.Button btn2;
    private com.lms.dataSaleCRUD.ui.Button btn3;
    private com.lms.dataSaleCRUD.ui.Button btn4;
    private com.lms.dataSaleCRUD.component.chart.Chart chart1;
    private com.lms.dataSaleCRUD.component.chart.Chart chart2;
    private com.lms.dataSaleCRUD.component.chart.Chart chart3;
    private com.lms.dataSaleCRUD.component.chart.Chart chart4;
    // End of variables declaration//GEN-END:variables
}
