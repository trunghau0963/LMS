package com.lms.dataSaleCRUD.form.other;

import java.awt.Color;
import java.util.List;

import com.lms.dataSaleCRUD.service.UserService;
import com.lms.dataSaleCRUD.dal.UserDao;
import com.lms.dataSaleCRUD.component.chart.ModelChart;
import com.lms.dataSaleCRUD.entities.BookWithRevenue;
import com.lms.dataSaleCRUD.entities.CategoryWithRevenue;
import com.lms.dataSaleCRUD.entities.CustomerWithRevenue;
import com.lms.dataSaleCRUD.entities.EmployeeWithRevenue;
import com.lms.dataSaleCRUD.repo.UserRepo;

public class viewDataSalePanel extends javax.swing.JPanel {
        public viewDataSalePanel() {
                initComponents();
                setBackground(new Color(255, 255, 255));

                UserDao userDao = new UserRepo();
                UserService userService = new UserService(userDao);
                List<BookWithRevenue> books = userService.getAllBooks();
                List<CategoryWithRevenue> categories = userService.getAllCategories();
                List<EmployeeWithRevenue> employees = userService.getAllEmployees();
                List<CustomerWithRevenue> customers = userService.getAllCustomers();

                double[] revenueArray1 = new double[] { books.get(0).getTotal_revenue(),
                                books.get(1).getTotal_revenue(),
                                books.get(2).getTotal_revenue(), books.get(3).getTotal_revenue(),
                                books.get(4).getTotal_revenue(),
                                books.get(5).getTotal_revenue() };
                double[] revenueArray4 = new double[] { employees.get(0).getTotal_revenue(),
                                employees.get(1).getTotal_revenue(), employees.get(2).getTotal_revenue(),
                                employees.get(3).getTotal_revenue(), employees.get(4).getTotal_revenue(),
                                employees.get(5).getTotal_revenue() };
                double[] revenueArray2 = new double[] { categories.get(0).getTotal_revenue(),
                                categories.get(1).getTotal_revenue(), categories.get(2).getTotal_revenue(),
                                categories.get(3).getTotal_revenue(), categories.get(4).getTotal_revenue(),
                                categories.get(5).getTotal_revenue() };
                double[] revenueArray3 = new double[] { customers.get(0).getTotal_revenue(),
                                customers.get(1).getTotal_revenue(), customers.get(2).getTotal_revenue(),
                                customers.get(3).getTotal_revenue(), customers.get(4).getTotal_revenue(),
                                customers.get(5).getTotal_revenue() };

                chart1.addLegend("Revenue", new Color(0, 0, 139));
                chart1.addData(new ModelChart(getInitials(books.get(0).getTitle()), new double[] { revenueArray1[0] }));
                chart1.addData(new ModelChart(getInitials(books.get(1).getTitle()), new double[] { revenueArray1[1] }));
                chart1.addData(new ModelChart(getInitials(books.get(2).getTitle()), new double[] { revenueArray1[2] }));
                chart1.addData(new ModelChart(getInitials(books.get(3).getTitle()), new double[] { revenueArray1[3] }));
                chart1.addData(new ModelChart(getInitials(books.get(4).getTitle()), new double[] { revenueArray1[4] }));
                chart1.addData(new ModelChart(getInitials(books.get(5).getTitle()), new double[] { revenueArray1[5] }));

                chart2.addLegend("Revenue", new Color(0, 128, 0));
                chart2.addData(new ModelChart(getInitials(categories.get(0).getGenre()),
                                new double[] { revenueArray2[0] }));
                chart2.addData(new ModelChart(getInitials(categories.get(1).getGenre()),
                                new double[] { revenueArray2[1] }));
                chart2.addData(new ModelChart(getInitials(categories.get(2).getGenre()),
                                new double[] { revenueArray2[2] }));
                chart2.addData(new ModelChart(getInitials(categories.get(3).getGenre()),
                                new double[] { revenueArray2[3] }));
                chart2.addData(new ModelChart(getInitials(categories.get(4).getGenre()),
                                new double[] { revenueArray2[4] }));
                chart2.addData(new ModelChart(getInitials(categories.get(5).getGenre()),
                                new double[] { revenueArray2[5] }));

                chart3.addLegend("Revenue", new Color(255, 165, 0));
                chart3.addData(new ModelChart(getInitials(customers.get(0).getName()),
                                new double[] { revenueArray3[0] }));
                chart3.addData(new ModelChart(getInitials(customers.get(1).getName()),
                                new double[] { revenueArray3[1] }));
                chart3.addData(new ModelChart(getInitials(customers.get(2).getName()),
                                new double[] { revenueArray3[2] }));
                chart3.addData(new ModelChart(getInitials(customers.get(3).getName()),
                                new double[] { revenueArray3[3] }));
                chart3.addData(new ModelChart(getInitials(customers.get(4).getName()),
                                new double[] { revenueArray3[4] }));
                chart3.addData(new ModelChart(getInitials(customers.get(5).getName()),
                                new double[] { revenueArray3[5] }));

                chart4.addLegend("Revenue", new Color(128, 128, 128));
                chart4.addData(new ModelChart(getInitials(employees.get(0).getName()),
                                new double[] { revenueArray4[0] }));
                chart4.addData(new ModelChart(getInitials(employees.get(1).getName()),
                                new double[] { revenueArray4[1] }));
                chart4.addData(new ModelChart(getInitials(employees.get(2).getName()),
                                new double[] { revenueArray4[2] }));
                chart4.addData(new ModelChart(getInitials(employees.get(3).getName()),
                                new double[] { revenueArray4[3] }));
                chart4.addData(new ModelChart(getInitials(employees.get(4).getName()),
                                new double[] { revenueArray4[4] }));
                chart4.addData(new ModelChart(getInitials(employees.get(5).getName()),
                                new double[] { revenueArray4[5] }));
        }

        public static String getInitials(String str) {
                String[] words = str.split(" ");
                StringBuilder initials = new StringBuilder();

                for (String word : words) {
                        if (!word.isEmpty()) {
                                initials.append(word.charAt(0));
                        }
                }

                return initials.toString().toUpperCase();
        }

        

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btn1 = new com.lms.dataSaleCRUD.ui.Button();
                btn2 = new com.lms.dataSaleCRUD.ui.Button();
                btn3 = new com.lms.dataSaleCRUD.ui.Button();
                btn4 = new com.lms.dataSaleCRUD.ui.Button();
                chart2 = new com.lms.dataSaleCRUD.component.chart.Chart();
                chart4 = new com.lms.dataSaleCRUD.component.chart.Chart();
                chart1 = new com.lms.dataSaleCRUD.component.chart.Chart();
                chart3 = new com.lms.dataSaleCRUD.component.chart.Chart();

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

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(btn3,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(chart3,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                414,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGap(43, 43, 43)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(btn4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                439,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(chart4,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                0,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addContainerGap())))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(chart1,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                414,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(btn1,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGap(43, 43, 43)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(btn2,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(chart2,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                439,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGap(0, 0, Short.MAX_VALUE)))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btn1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btn2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(chart2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                327,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(chart1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                327,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(btn3,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btn4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(chart4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                327,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(chart3,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                327,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap()));
        }// </editor-fold>//GEN-END:initComponents

        private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn1ActionPerformed
                viewDataSaleBookPanel viewDataSaleBookPanel = new viewDataSaleBookPanel();
                viewDataSaleBookPanel.setVisible(true);
        }// GEN-LAST:event_btn1ActionPerformed

        private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn2ActionPerformed
                viewDataSaleCategoryPanel viewDataSaleCategoryPanel = new viewDataSaleCategoryPanel();
                viewDataSaleCategoryPanel.setVisible(true);
        }// GEN-LAST:event_btn2ActionPerformed

        private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn3ActionPerformed
                viewDataSaleCustomerPanel viewDataSaleCustomerPanel = new viewDataSaleCustomerPanel();
                viewDataSaleCustomerPanel.setVisible(true);
        }// GEN-LAST:event_btn3ActionPerformed

        private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn4ActionPerformed
                viewDataSaleEmployeePanel viewDataSaleEmployeePanel = new viewDataSaleEmployeePanel();
                viewDataSaleEmployeePanel.setVisible(true);
        }// GEN-LAST:event_btn4ActionPerformed

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