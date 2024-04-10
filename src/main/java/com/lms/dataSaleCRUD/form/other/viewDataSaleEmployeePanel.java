package com.lms.dataSaleCRUD.form.other;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.lms.dataSaleCRUD.dal.UserDao;
import com.lms.dataSaleCRUD.entities.EmployeeWithRevenue;
import com.lms.dataSaleCRUD.repo.UserRepo;
import com.lms.dataSaleCRUD.service.UserService;

public class viewDataSaleEmployeePanel extends javax.swing.JPanel {

    public viewDataSaleEmployeePanel() {
        initComponents();

        setBackground(Color.WHITE);

        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        // table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));

        UserDao userDao = new UserRepo();
        UserService userService = new UserService(userDao);
        List<EmployeeWithRevenue> employees = userService.getAllEmployees();
        String[] columnNames = { "employeeID", "employeeName", "TotalRevenue" };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setModel(model);

        updateTable(employees, model);

        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                filterByName();
            }

            public void removeUpdate(DocumentEvent e) {
                filterByName();
            }

            public void insertUpdate(DocumentEvent e) {
                filterByName();
            }
        });

        dateChooser1.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            if (dateChooser1.getDate() != null
                                    && dateChooser2.getDate() != null) {
                                filterByDate();
                            }
                        }
                    }
                });

        dateChooser2.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            if (dateChooser1.getDate() != null
                                    && dateChooser2.getDate() != null) {
                                filterByDate();
                            }
                        }
                    }
                });

        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTable(employees, model);

                dateChooser1.setDate(null);
                dateChooser2.setDate(null);
            }
        });
    }

    public void filterByDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date startDate = dateChooser1.getDate();
        java.sql.Date tempDate1 = new java.sql.Date(startDate.getTime());
        String startDateString = formatter.format(tempDate1);

        java.util.Date endDate = dateChooser2.getDate();
        java.sql.Date tempDate2 = new java.sql.Date(endDate.getTime());
        String endDateString = formatter.format(tempDate2);

        UserDao userDao = new UserRepo();
        UserService userService = new UserService(userDao);
        List<EmployeeWithRevenue> employees = userService.getTotalRevenueGroupByEmployeeBetweenDate(startDateString,
                endDateString);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        updateTable(employees, model);
    }

    public void filterByName() {
        String filterText = jTextField1.getText();
        UserDao userDao = new UserRepo();
        UserService userService = new UserService(userDao);
        List<EmployeeWithRevenue> employees = userService.getAllEmployees();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (EmployeeWithRevenue employee : employees) {
            if (employee.getName().toLowerCase().contains(filterText.toLowerCase())) {
                model.addRow(new Object[] { employee.getId(), employee.getName(), employee.getTotal_revenue() });
            }
        }
    }

    public void updateTable(List<EmployeeWithRevenue> employees, DefaultTableModel model) {
        model.setRowCount(0);

        for (EmployeeWithRevenue employee : employees) {
            model.addRow(new Object[] { employee.getEmpId(), employee.getEmpName(), employee.getTotal_revenue() });
        }
        table.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        dateChooser1 = new com.toedter.calendar.JDateChooser();
        dateChooser2 = new com.toedter.calendar.JDateChooser();
        resetBtn = new com.lms.custom.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        dateChooser1.setBackground(new java.awt.Color(255, 255, 255));

        dateChooser2.setBackground(new java.awt.Color(255, 255, 255));

        resetBtn.setBackground(new java.awt.Color(60, 58, 72));
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset Table");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null }
                },
                new String[] {
                        "bookId", "title", "TotalRevenue"
                }));
        table.setRowHeight(30);
        table.setShowGrid(true);
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 158,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77,
                                                        Short.MAX_VALUE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 691,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 158,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_resetBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooser1;
    private com.toedter.calendar.JDateChooser dateChooser2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private com.lms.custom.Button resetBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
