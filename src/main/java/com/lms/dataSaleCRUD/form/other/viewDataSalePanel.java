package com.lms.dataSaleCRUD.form.other;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import com.lms.dataSaleCRUD.service.UserService;
import com.lms.dataSaleCRUD.dal.UserDao;
import com.lms.dataSaleCRUD.ui.component.chart.*;
import com.lms.dataSaleCRUD.entities.BookWithRevenue;
import com.lms.dataSaleCRUD.entities.CategoryWithRevenue;
import com.lms.dataSaleCRUD.entities.CustomerWithRevenue;
import com.lms.dataSaleCRUD.entities.EmployeeWithRevenue;
import com.lms.dataSaleCRUD.repo.UserRepo;

public class viewDataSalePanel extends javax.swing.JPanel {

        private CardLayout cardLayout;
        private JPanel panelParent;

        public viewDataSalePanel(CardLayout cardLayout, JPanel panelParent) {
                this.cardLayout = cardLayout;
                this.panelParent = panelParent;
                UserDao userDao = new UserRepo();
                UserService userService = new UserService(userDao);
                initComponents();
                // setBackground(new Color(255, 255, 255));
                init(userService);
        }

        private void init(UserService userService) {
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
                chart1.start();

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
                chart2.start();

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
                chart3.start();

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
                chart4.start();
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
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                main = new javax.swing.JPanel();
                chartPanel1 = new javax.swing.JPanel();
                btn1 = new com.lms.dataSaleCRUD.ui.Button();
                chart1 = new com.lms.dataSaleCRUD.ui.component.chart.Chart();
                chartPanel2 = new javax.swing.JPanel();
                btn2 = new com.lms.dataSaleCRUD.ui.Button();
                chart2 = new com.lms.dataSaleCRUD.ui.component.chart.Chart();
                chartPanel3 = new javax.swing.JPanel();
                btn3 = new com.lms.dataSaleCRUD.ui.Button();
                chart3 = new com.lms.dataSaleCRUD.ui.component.chart.Chart();
                chartPanel4 = new javax.swing.JPanel();
                btn4 = new com.lms.dataSaleCRUD.ui.Button();
                chart4 = new com.lms.dataSaleCRUD.ui.component.chart.Chart();

                setLayout(new java.awt.BorderLayout());

                jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                jLabel1.setText("View Data Sale of highest...");
                jPanel1.add(jLabel1);

                add(jPanel1, java.awt.BorderLayout.NORTH);

                main.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 100, 40, 60));
                main.setPreferredSize(new java.awt.Dimension(700, 600));
                main.setLayout(new java.awt.GridLayout(2, 2, 40, 40));

                chartPanel1.setPreferredSize(new java.awt.Dimension(350, 275));
                chartPanel1.setLayout(new java.awt.BorderLayout());

                btn1.setBackground(new java.awt.Color(60, 58, 72));
                btn1.setForeground(new java.awt.Color(255, 255, 255));
                btn1.setLabel("View data sale - Book");
                btn1.setPreferredSize(new java.awt.Dimension(350, 35));
                btn1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn1ActionPerformed(evt);
                        }
                });
                chartPanel1.add(btn1, java.awt.BorderLayout.NORTH);

                chart1.setPreferredSize(new java.awt.Dimension(350, 235));
                chartPanel1.add(chart1, java.awt.BorderLayout.CENTER);

                main.add(chartPanel1);

                chartPanel2.setLayout(new java.awt.BorderLayout());

                btn2.setBackground(new java.awt.Color(60, 58, 72));
                btn2.setForeground(new java.awt.Color(255, 255, 255));
                btn2.setLabel("View data sale - Employee");
                btn2.setPreferredSize(new java.awt.Dimension(350, 35));
                btn2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn2ActionPerformed(evt);
                        }
                });
                chartPanel2.add(btn2, java.awt.BorderLayout.NORTH);

                chart2.setPreferredSize(new java.awt.Dimension(350, 225));
                chartPanel2.add(chart2, java.awt.BorderLayout.CENTER);

                main.add(chartPanel2);

                chartPanel3.setLayout(new java.awt.BorderLayout());

                btn3.setBackground(new java.awt.Color(60, 58, 72));
                btn3.setForeground(new java.awt.Color(255, 255, 255));
                btn3.setLabel("View data sale - Category");
                btn3.setPreferredSize(new java.awt.Dimension(350, 35));
                btn3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn3ActionPerformed(evt);
                        }
                });
                chartPanel3.add(btn3, java.awt.BorderLayout.NORTH);

                chart3.setPreferredSize(new java.awt.Dimension(350, 225));
                chartPanel3.add(chart3, java.awt.BorderLayout.CENTER);

                main.add(chartPanel3);

                chartPanel4.setLayout(new java.awt.BorderLayout());

                btn4.setBackground(new java.awt.Color(60, 58, 72));
                btn4.setForeground(new java.awt.Color(255, 255, 255));
                btn4.setLabel("View data sale - Customer");
                btn4.setPreferredSize(new java.awt.Dimension(350, 40));
                btn4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn4ActionPerformed(evt);
                        }
                });
                chartPanel4.add(btn4, java.awt.BorderLayout.NORTH);

                chart4.setPreferredSize(new java.awt.Dimension(350, 225));
                chartPanel4.add(chart4, java.awt.BorderLayout.CENTER);

                main.add(chartPanel4);

                add(main, java.awt.BorderLayout.CENTER);
        }// </editor-fold>//GEN-END:initComponents

        private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn1ActionPerformed
                cardLayout.show(panelParent, "viewDataSaleBookPanel");
        }// GEN-LAST:event_btn1ActionPerformed

        private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn2ActionPerformed
                cardLayout.show(panelParent, "viewDataSaleEmployeePanel");
        }// GEN-LAST:event_btn2ActionPerformed

        private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn3ActionPerformed
                cardLayout.show(panelParent, "viewDataSaleCategoryPanel");
        }// GEN-LAST:event_btn3ActionPerformed

        private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn4ActionPerformed
                cardLayout.show(panelParent, "viewDataSaleCustomerPanel");
        }// GEN-LAST:event_btn4ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private com.lms.dataSaleCRUD.ui.Button btn1;
        private com.lms.dataSaleCRUD.ui.Button btn2;
        private com.lms.dataSaleCRUD.ui.Button btn3;
        private com.lms.dataSaleCRUD.ui.Button btn4;
        private com.lms.dataSaleCRUD.ui.component.chart.Chart chart1;
        private com.lms.dataSaleCRUD.ui.component.chart.Chart chart2;
        private com.lms.dataSaleCRUD.ui.component.chart.Chart chart3;
        private com.lms.dataSaleCRUD.ui.component.chart.Chart chart4;
        private javax.swing.JPanel chartPanel1;
        private javax.swing.JPanel chartPanel2;
        private javax.swing.JPanel chartPanel3;
        private javax.swing.JPanel chartPanel4;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel main;
        // End of variables declaration//GEN-END:variables
}
