/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lms.employee;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
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
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                        int column) {
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

public class ListAuthorPanel extends javax.swing.JPanel implements ActionListener {

        public ListAuthorPanel(CardLayout cobj, JPanel panelParent) {
                initComponents();

                this.panelParent = panelParent;
                this.empDao = new EmployeeRepo();
                this.empService = new EmployeeService(empDao);
                this.cardLayout = cobj;

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
                searchZone = new javax.swing.JPanel();
                searchField = new javax.swing.JTextField();
                searchBtn = new javax.swing.JButton();
                resetBtn = new javax.swing.JButton();
                searchOption = new javax.swing.JComboBox<>();
                jScrollPane1 = new javax.swing.JScrollPane();
                listAuthor = new javax.swing.JTable();
                addAuthorBtn = new javax.swing.JButton();
                pageTitle = new javax.swing.JLabel();

                setBackground(new java.awt.Color(255, 255, 255));
                setPreferredSize(new java.awt.Dimension(800, 630));

                searchZone.setLayout(new java.awt.BorderLayout());

                searchField.setText("");
                searchField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
                searchField.setPreferredSize(new java.awt.Dimension(400, 28));
                searchZone.add(searchField, java.awt.BorderLayout.CENTER);
                searchField.getAccessibleContext().setAccessibleParent(this);

                searchBtn.setBackground(new java.awt.Color(217, 217, 217));
                searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lms/employee/search.png"))); // NOI18N
                searchBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
                searchBtn.setPreferredSize(new java.awt.Dimension(50, 23));
                searchZone.add(searchBtn, java.awt.BorderLayout.EAST);
                searchBtn.getAccessibleContext().setAccessibleParent(this);
                searchBtn.addActionListener(this);

                resetBtn.setBackground(new java.awt.Color(217, 217, 217));
                resetBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
                resetBtn.setPreferredSize(new java.awt.Dimension(50, 23));
                searchZone.add(resetBtn, java.awt.BorderLayout.WEST);
                resetBtn.getAccessibleContext().setAccessibleParent(this);
                resetBtn.addActionListener(this);

                sexBtn1 = new javax.swing.JRadioButton();
                sexBtn2 = new javax.swing.JRadioButton();

                sexBtnGroup = new ButtonGroup();
                sexBtnGroup.add(sexBtn1);
                sexBtnGroup.add(sexBtn2);

                statusBtn1 = new javax.swing.JRadioButton();
                statusBtn2 = new javax.swing.JRadioButton();

                statusBtnGroup = new ButtonGroup();
                statusBtnGroup.add(statusBtn1);
                statusBtnGroup.add(statusBtn2);

                sexBtn1.setText("Male");

                sexBtn2.setText("Female");

                statusBtn1.setText("UnHide");

                statusBtn2.setText("Hide");

                searchOption.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "", "Id", "FullName"}));
                searchOption.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
                searchOption.setPreferredSize(new java.awt.Dimension(90, 22));
                searchOption.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                searchOptionActionPerformed(evt);
                        }
                });
                searchZone.add(searchOption, java.awt.BorderLayout.WEST);
                searchOption.getAccessibleContext().setAccessibleParent(this);

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
                listAuthor.getAccessibleContext().setAccessibleParent(this);
                listAuthor.getColumnModel().getColumn(3).setCellRenderer(new ToggleRenderer());
                listAuthor.getColumnModel().getColumn(3).setCellEditor(new ToggleEditor());

                addAuthorBtn.setBackground(new java.awt.Color(51, 51, 51));
                addAuthorBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
                addAuthorBtn.setForeground(new java.awt.Color(255, 255, 255));
                addAuthorBtn.setText("ADD NEW AUTHOR");
                addAuthorBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addAuthorBtnActionPerformed(evt, cardLayout, panelParent);
                        }
                });

                pageTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
                pageTitle.setText("List Author");

                javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(this);
                setLayout(jPanelLayout);
                jPanelLayout.setHorizontalGroup(
                                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addGroup(jPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(57, 57, 57)
                                                                                                                .addComponent(jScrollPane1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                652,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                jPanelLayout.createSequentialGroup()
                                                                                                                                .addContainerGap()
                                                                                                                                .addComponent(addAuthorBtn)))
                                                                                .addGroup(jPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(92, 92, 92)
                                                                                                .addComponent(searchZone,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(308, 308, 308)
                                                                                                .addComponent(pageTitle)))
                                                                .addContainerGap(91, Short.MAX_VALUE)));
                jPanelLayout.setHorizontalGroup(
                                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addGroup(jPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(57, 57, 57)
                                                                                                                .addComponent(jScrollPane1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                652,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                jPanelLayout.createSequentialGroup()
                                                                                                                                .addContainerGap()
                                                                                                                                .addGroup(jPanelLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(statusBtn1)
                                                                                                                                                .addComponent(addAuthorBtn))))
                                                                                .addGroup(jPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(309, 309, 309)
                                                                                                .addComponent(pageTitle))
                                                                                .addGroup(jPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(92, 92, 92)
                                                                                                .addGroup(jPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addGroup(jPanelLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(38, 38, 38)
                                                                                                                                .addComponent(sexBtn1)
                                                                                                                                .addGap(34, 34, 34)
                                                                                                                                .addComponent(sexBtn2)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(statusBtn2)
                                                                                                                                .addGap(133, 133,
                                                                                                                                                133))
                                                                                                                .addComponent(searchZone,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addComponent(searchBtn,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                61,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(91, Short.MAX_VALUE)));
                jPanelLayout.setVerticalGroup(
                                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addGroup(jPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(searchZone,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(searchBtn,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                28,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(sexBtn1)
                                                                                .addComponent(sexBtn2)
                                                                                .addComponent(statusBtn1)
                                                                                .addComponent(statusBtn2))
                                                                .addGap(13, 13, 13)
                                                                .addComponent(pageTitle)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                12,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(addAuthorBtn)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(19, 19, 19)));

        }// </editor-fold>//GEN-END:initComponents

        private void addAuthorBtnActionPerformed(java.awt.event.ActionEvent evt, CardLayout cobj, JPanel panelParent) {// GEN-FIRST:event_addAuthorBtnActionPerformed
                // TODO add your handling code here:
                cobj.next(panelParent);

        }// GEN-LAST:event_addAuthorBtnActionPerformed

        private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_searchOptionActionPerformed

        @Override
        public void actionPerformed(ActionEvent e) {
                String key = searchField.getText();
                String field = searchOption.getSelectedItem().toString();

                String sex = null;
                sex = sexBtn1.isSelected() ? sexBtn1.getText() : sex;
                sex = sexBtn2.isSelected() ? sexBtn2.getText() : sex;

                String status = null;
                status = statusBtn1.isSelected() ? statusBtn1.getText() : status;
                status = statusBtn2.isSelected() ? statusBtn2.getText() : status;

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

        // Variables declaration - do not modify//GEN-BEGIN:variables
        CardLayout cardLayout;
        JPanel panelParent;
        EmployeeService empService;
        EmployeeDao empDao;

        private javax.swing.JPanel searchZone;
        private javax.swing.JScrollPane jScrollPane1;

        private javax.swing.JButton searchBtn;
        private javax.swing.JButton resetBtn;
        private javax.swing.JTextField searchField;
        private javax.swing.JComboBox<String> searchOption;
        private javax.swing.JLabel pageTitle;
        private javax.swing.JButton addAuthorBtn;
        private javax.swing.JTable listAuthor;

        private javax.swing.JRadioButton sexBtn1;
        private JRadioButton sexBtn2;
        private JRadioButton statusBtn1;
        private JRadioButton statusBtn2;
        private ButtonGroup sexBtnGroup;
        private ButtonGroup statusBtnGroup;
        // End of variables declaration//GEN-END:variables

}
