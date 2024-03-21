/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lms.employee;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import com.lms.employee.SwitchButton.ToggleRenderer;
import com.lms.employee.dal.EmployeeDao;
import com.lms.employee.entities.Author;
import com.lms.employee.repo.EmployeeRepo;
import com.lms.employee.service.EmployeeService;

/**
 *
 * @author Van Vinh
 */

class ToggleEditor extends AbstractCellEditor implements TableCellEditor {
    private JToggleButton button = new JToggleButton("Unhide");
    EmployeeDao empDao = new EmployeeRepo();
    EmployeeService empService = new EmployeeService(empDao);

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        String id = table.getValueAt(row, 0).toString();
        boolean isHide = (boolean) table.getValueAt(row, 3);

        empService.setVisible(id, isHide);

        button.addActionListener(e -> {
            stopCellEditing();
            fireEditingStopped();
        });

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.isSelected();
    }
}

public class ListAuthor extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form ListAuthorComponent
     */
    EmployeeService empService;
    EmployeeDao empDao;

    public ListAuthor() {
        initComponents();

        empDao = new EmployeeRepo();
        empService = new EmployeeService(empDao);

        ArrayList<Author> authors = empService.getListAuthors();
        DefaultTableModel model = (DefaultTableModel) listAuthor.getModel();

        for (Author author : authors) {
            Object[] rowData = {
                    author.getAuthorId(),
                    author.getAuthorName(),
                    author.getAuthorGender(),
                    author.isHide()
            };

            model.addRow(rowData);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAuthor = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 630));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jTextField1.setText("");
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jTextField1.setPreferredSize(new java.awt.Dimension(400, 28));
        jPanel3.add(jTextField1, java.awt.BorderLayout.CENTER);
        jTextField1.getAccessibleContext().setAccessibleParent(jPanel2);

        jButton1.setBackground(new java.awt.Color(217, 217, 217));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lms/employee/search.png"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton1.setPreferredSize(new java.awt.Dimension(50, 23));
        jPanel3.add(jButton1, java.awt.BorderLayout.EAST);
        jButton1.getAccessibleContext().setAccessibleParent(jPanel2);
        jButton1.addActionListener(this);

        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        sexBtnGroup = new ButtonGroup();
        sexBtnGroup.add(jRadioButton1);
        sexBtnGroup.add(jRadioButton2);

        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        statusBtnGroup = new ButtonGroup();
        statusBtnGroup.add(jRadioButton3);
        statusBtnGroup.add(jRadioButton4);

        jRadioButton1.setText("Male");

        jRadioButton2.setText("Female");

        jRadioButton3.setText("UnHide");

        jRadioButton4.setText("Hide");

        jComboBox1.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Id", "FullName", "Gender", "Hide" }));
        jComboBox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jComboBox1.setPreferredSize(new java.awt.Dimension(90, 22));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, java.awt.BorderLayout.WEST);
        jComboBox1.getAccessibleContext().setAccessibleParent(jPanel2);

        listAuthor.setBackground(new java.awt.Color(231, 226, 226));
        listAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listAuthor.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[] {
                        "Id", "FullName", "Gender", "Hide/UnHide"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        listAuthor.setGridColor(new java.awt.Color(0, 0, 0));
        listAuthor.setShowGrid(true);
        jScrollPane1.setViewportView(listAuthor);
        listAuthor.getAccessibleContext().setAccessibleName("");
        listAuthor.getAccessibleContext().setAccessibleDescription("");
        listAuthor.getAccessibleContext().setAccessibleParent(jPanel2);
        listAuthor.getColumnModel().getColumn(3).setCellRenderer(new ToggleRenderer());
        listAuthor.getColumnModel().getColumn(3).setCellEditor(new ToggleEditor());

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADD NEW AUTHOR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("List Author");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(57, 57, 57)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 652,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jButton2)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(308, 308, 308)
                                                .addComponent(jLabel1)))
                                .addContainerGap(91, Short.MAX_VALUE)));
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(57, 57, 57)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 652,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jRadioButton3)
                                                                        .addComponent(jButton2))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(309, 309, 309)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addComponent(jRadioButton1)
                                                                .addGap(34, 34, 34)
                                                                .addComponent(jRadioButton2)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jRadioButton4)
                                                                .addGap(133, 133, 133))
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(91, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton4))
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12,
                                        Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(94, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ListAuthor.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListAuthor.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListAuthor.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListAuthor.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListAuthor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    
    
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTable listAuthor;

    private javax.swing.JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private ButtonGroup sexBtnGroup;
    private ButtonGroup statusBtnGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getSource());
        String key = jTextField1.getText();
        String field = jComboBox1.getSelectedItem().toString();

        String sex = null;
        sex = jRadioButton1.isSelected() ? jRadioButton1.getText() : sex;
        sex = jRadioButton2.isSelected() ? jRadioButton2.getText() : sex;

        String status = null;
        status = jRadioButton3.isSelected() ? jRadioButton3.getText() : status;
        status = jRadioButton4.isSelected() ? jRadioButton4.getText() : status;

        // "ID", "FullName", "Gender", "Hide"
        if (field.equals("Id")) {
            ArrayList<Author> authors = empService.getAuthorById(key, sex, status);
            DefaultTableModel model = (DefaultTableModel) listAuthor.getModel();
            model.setRowCount(0);
            for (Author author : authors) {
                Object[] rowData = {
                        author.getAuthorId(),
                        author.getAuthorName(),
                        author.getAuthorGender(),
                        author.isHide()
                };

                model.addRow(rowData);
            }
        } else if (field.equals("FullName")) {
            ArrayList<Author> authors = empService.getAuthorByName(key, sex, status);
            DefaultTableModel model = (DefaultTableModel) listAuthor.getModel();

            model.setRowCount(0);

            for (Author author : authors) {
                Object[] rowData = {
                        author.getAuthorId(),
                        author.getAuthorName(),
                        author.getAuthorGender(),
                        author.isHide()
                };
                model.addRow(rowData);
            }
        } else {
            ArrayList<Author> authors = empService.getListAuthors();
            DefaultTableModel model = (DefaultTableModel) listAuthor.getModel();
            model.setRowCount(0);
            for (Author author : authors) {
                Object[] rowData = {
                        author.getAuthorId(),
                        author.getAuthorName(),
                        author.getAuthorGender(),
                        author.isHide()
                };
                model.addRow(rowData);
            }
        }

    }
}
