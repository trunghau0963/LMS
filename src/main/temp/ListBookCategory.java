/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lms.categoryCRUD;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.lms.categoryCRUD.SwitchButton.*;
import com.lms.categoryCRUD.dal.CategoryDao;
import com.lms.categoryCRUD.model.CategoryModel;
import com.lms.categoryCRUD.repo.CategoryRepo;
import com.lms.categoryCRUD.service.CategoryService;

/**
 *
 * @author PCM
 */
public class ListBookCategory extends javax.swing.JPanel {
        private CategoryDao categoryDao;
        private CategoryService categoryService;

        /**
         * Creates new form BookList
         */
        public ListBookCategory() {
                initComponents();
                categoryDao = new CategoryRepo();
                categoryService = new CategoryService(categoryDao);
                loadCategoryTable();
        }

        public void loadCategoryTable() {
                List<CategoryModel> categoryModels = categoryService.getAllCategories();
                DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
                for (CategoryModel categoryModel : categoryModels) {
                        tblModel.addRow(new Object[] { categoryModel.getId(), categoryModel.getGenre(), false });
                }

                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable2.getModel());
                jTable2.setRowSorter(sorter);
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                JPanel1 = new JPanel();
                jTextField1 = new JTextField();
                jComboBox1 = new JComboBox<>();
                jButton1 = new JButton();
                jScrollPane2 = new JScrollPane();
                jTable2 = new JTable() {

                        public boolean isCellEditable(int row, int column) {
                                if (column == 0)
                                        return false;
                                return true;
                        }

                };
                jButton2 = new javax.swing.JButton();
                label1 = new java.awt.Label();
                jTextField2 = new javax.swing.JTextField();

                setSize(new java.awt.Dimension(800, 540));

                jTextField1.setText("Search...");
                jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                jTextField1.setPreferredSize(new java.awt.Dimension(387, 27));

                jComboBox1.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Alphabet", "Item 2", "Item 3", "Item 4" }));
                jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                jComboBox1.setPreferredSize(new java.awt.Dimension(94, 27));
                jComboBox1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox1ActionPerformed(evt);
                        }
                });

                jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                jButton1.setPreferredSize(new java.awt.Dimension(36, 27));
                jButton1.setPressedIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/com/lms/categoryCRUD/search-icon.png"))); // NOI18N
                jButton1.setRolloverIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/com/lms/categoryCRUD/search-icon.png"))); // NOI18N
                jButton1.setRolloverSelectedIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/com/lms/categoryCRUD/search-icon.png"))); // NOI18N
                jButton1.setSelected(true);
                jButton1.setSelectedIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/com/lms/categoryCRUD/search-icon.png"))); // NOI18N

                jTable2.setBackground(new java.awt.Color(231, 226, 226));
                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                                "ID", "Genre", "Show/Hide"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }
                });
                jTable2.getColumnModel().getColumn(2).setCellRenderer(new ToggleRenderer());
                jTable2.getColumnModel().getColumn(2).setCellEditor(new ToggleEditor());
                jTable2.setColumnSelectionAllowed(true);
                jTable2.setGridColor(new java.awt.Color(0, 0, 0));
                jTable2.setRowHeight(26);
                jTable2.setShowGrid(true);
                jScrollPane2.setViewportView(jTable2);
                jTable2.getColumnModel().getSelectionModel()
                                .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                // jTable2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                // public void propertyChange(java.beans.PropertyChangeEvent evt) {
                // jTable2PropertyChange(evt);
                // }
                // });
                jButton2.setBackground(new java.awt.Color(60, 58, 72));
                jButton2.setForeground(new java.awt.Color(255, 255, 255));
                jButton2.setText("ADD NEW");
                jButton2.setPreferredSize(new java.awt.Dimension(85, 26));
                jButton2.setRequestFocusEnabled(false);
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }

                });

                label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                label1.setName(""); // NOI18N
                label1.setText("List Book Category");

                jTextField2.setBackground(new java.awt.Color(231, 226, 226));
                jTextField2.setText("Type a new category");
                jTextField2.setPreferredSize(new java.awt.Dimension(180, 26));
                jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                jTextField2FocusGained(evt);
                        }
                });
                javax.swing.GroupLayout borderPanel1Layout = new javax.swing.GroupLayout(JPanel1);
                JPanel1.setLayout(borderPanel1Layout);
                borderPanel1Layout.setHorizontalGroup(
                                borderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(borderPanel1Layout.createSequentialGroup()
                                                                .addGap(47, 47, 47)
                                                                .addGroup(borderPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jScrollPane2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                604,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(borderPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(14, 14, 14)
                                                                                                .addGroup(borderPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(label1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(jTextField2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(0, 0, 0)
                                                                                                                                .addComponent(jButton2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(1, 1, 1))
                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jComboBox1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                94,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(0, 0, 0)
                                                                                                                                .addComponent(jTextField1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                449,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(0, 0, 0)
                                                                                                                                .addComponent(jButton1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                36,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addContainerGap(48, Short.MAX_VALUE)));
                borderPanel1Layout.setVerticalGroup(
                                borderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addGroup(borderPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jButton1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jComboBox1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(borderPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(label1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(borderPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jButton2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jTextField2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(16, 16, 16)
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                288,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(169, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(JPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        }// </editor-fold>//GEN-END:initComponents

        private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jComboBox1ActionPerformed

        private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {
                // TODO add your handling code here:
                jTextField2.setText("");
        }
        // check jTable2 which row is edited
        // get the model of that row
        // update the model
        // call the service to update the model

        // private void jTable2PropertyChange(java.beans.PropertyChangeEvent evt) {
        // int row = jTable2.getSelectedRow();
        // // CategoryModel categoryModel = new CategoryModel();
        // // if (row >= 0 && !jTable2.isEditing()) {
        // // categoryModel.setId((String) jTable2.getValueAt(row, 0));
        // // categoryModel.setGenre((String) jTable2.getValueAt(row, 1));
        // // Boolean isUpdated = categoryService.editCategory(categoryModel);

        // // if (isUpdated) {
        // // JOptionPane.showMessageDialog(this, "Category updated successfully");
        // // } else {
        // // JOptionPane.showMessageDialog(this, "Failed to update category");
        // // }
        // // }
        // while (jTable2.isEditing()) {
        // System.out.println((String) jTable2.getValueAt(row, 1));
        // }
        // System.out.println("Property changed");
        // }

        private void jButton2ActionPerformed(ActionEvent evt) {
                if (jTextField2.getText().equals("Type a new category") || jTextField2.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a category");
                        return;
                }
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setGenre(jTextField2.getText());
                Boolean isAdded = categoryService.addNewCategory(categoryModel);
                categoryModel = categoryService.getCategoryByName(categoryModel.getGenre());
                if (isAdded) {
                        DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
                        tblModel.addRow(new Object[] { categoryModel.getId(), categoryModel.getGenre(), false });

                        jTextField2.setText("");
                        JOptionPane.showMessageDialog(this, "Category added successfully");
                } else {
                        jTextField2.setText("");
                        JOptionPane.showMessageDialog(this, "Failed to add category");
                }

        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private JPanel JPanel1;
        private JButton jButton1;
        private JButton jButton2;
        private JComboBox<String> jComboBox1;
        private JScrollPane jScrollPane2;
        private JTable jTable2;
        private JTextField jTextField1;
        private JTextField jTextField2;
        private java.awt.Label label1;
        // End of variables declaration//GEN-END:variables
}
