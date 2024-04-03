/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lms.employee;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.lms.employee.SwitchButton.ToggleRenderer;
import com.lms.employee.dal.PublisherDao;
import com.lms.employee.entities.Publisher;
import com.lms.employee.repo.PublisherRepo;
import com.lms.employee.service.PublisherService;

/**
 *
 * @Publisher Van Vinh
 * 
 * 
 */
class PublishersTableEditor extends AbstractCellEditor implements TableCellEditor {
        private JToggleButton button = new JToggleButton("Unhide");
        PublisherDao pubDao = new PublisherRepo();
        PublisherService pubService = new PublisherService(pubDao);

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                        int column) {
                String id = table.getValueAt(row, 0).toString();
                boolean isHide = (boolean) table.getValueAt(row, 3);

                pubService.setVisible(id, isHide);

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

public class ListPublisherPanel extends javax.swing.JPanel implements ActionListener {
        /**
         * Creates new form ListPublisher
         */
        public ListPublisherPanel(CardLayout cobj, JPanel panelParent) {
                initComponents();

                this.panelParent = panelParent;
                this.pubDao = new PublisherRepo();
                this.pubService = new PublisherService(pubDao);
                this.cardLayout = cobj;

                ArrayList<Publisher> publishers = pubService.getListPublishers();
                DefaultTableModel model = (DefaultTableModel) listPublisher.getModel();

                for (Publisher publisher : publishers) {
                        Object[] rowData = {
                                        publisher.getPublisherId(),
                                        publisher.getPublisherName(),
                                        publisher.getPublisherAddress(),
                                        publisher.isHide()
                        };

                        model.addRow(rowData);
                }
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                searchPanel = new javax.swing.JPanel();
                searchBtnPanel = new javax.swing.JPanel();
                searchField = new javax.swing.JTextField();
                searchBtn = new javax.swing.JButton();
                resetBtn = new javax.swing.JButton();
                searchOption = new javax.swing.JComboBox<>();
                jScrollPane1 = new javax.swing.JScrollPane();
                listPublisher = new javax.swing.JTable();
                addPublisherBtn = new javax.swing.JButton();
                pageTitle = new javax.swing.JLabel();
                statusBtn1 = new javax.swing.JRadioButton();
                statusBtn2 = new javax.swing.JRadioButton();

                setBackground(new java.awt.Color(255, 255, 255));
                setPreferredSize(new java.awt.Dimension(800, 630));

                searchPanel.setLayout(new java.awt.BorderLayout());
                searchBtnPanel.setLayout(new java.awt.BorderLayout());

                searchField.setText("");
                searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                searchField.setPreferredSize(new java.awt.Dimension(400, 28));
                searchField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                searchFieldActionPerformed(evt);
                        }
                });
                searchPanel.add(searchField, java.awt.BorderLayout.CENTER);
                searchField.getAccessibleContext().setAccessibleParent(this);

                searchBtn.setBackground(new java.awt.Color(217, 217, 217));
                searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lms/employee/search.png"))); // NOI18N
                searchBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                searchBtn.setPreferredSize(new java.awt.Dimension(75, 23));
                searchBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                searchBtnActionPerformed(evt);
                        }
                });
                searchBtnPanel.add(searchBtn, java.awt.BorderLayout.CENTER);

                resetBtn.setText("Refesh");
                resetBtn.setBackground(new java.awt.Color(217, 217, 217));
                resetBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                resetBtn.setPreferredSize(new java.awt.Dimension(75, 23));
                resetBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                resetActionPerformed(evt);
                        }
                });
                searchBtnPanel.add(resetBtn, java.awt.BorderLayout.EAST);
                searchPanel.add(searchBtnPanel, java.awt.BorderLayout.EAST);

                searchOption.setModel(
                                new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Id", "Name", "Address" }));
                searchOption.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                searchOption.setPreferredSize(new java.awt.Dimension(90, 22));
                searchOption.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                searchOptionActionPerformed(evt);
                        }
                });
                searchPanel.add(searchOption, java.awt.BorderLayout.LINE_START);
                searchOption.getAccessibleContext().setAccessibleParent(this);

                listPublisher.setBackground(new java.awt.Color(231, 226, 226));
                listPublisher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                listPublisher.setModel(new javax.swing.table.DefaultTableModel(
                                null,
                                new String[] {
                                                "Publisher Id", "Publisher Name", "Publisher Address", "Hide/UnHide"
                                }) {
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, true
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                listPublisher.setGridColor(new java.awt.Color(0, 0, 0));
                listPublisher.setShowGrid(true);
                jScrollPane1.setViewportView(listPublisher);
                listPublisher.getAccessibleContext().setAccessibleName("");
                listPublisher.getAccessibleContext().setAccessibleDescription("");
                listPublisher.getAccessibleContext().setAccessibleParent(this);
                listPublisher.getColumnModel().getColumn(3).setCellRenderer(new ToggleRenderer());
                listPublisher.getColumnModel().getColumn(3).setCellEditor(new PublishersTableEditor());
                listPublisher.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                rowSelectedAction(e);
                        }
                });

                // Sorted row
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(listPublisher.getModel());
                listPublisher.setRowSorter(sorter);

                List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);

                for (int i = 0; i < listPublisher.getColumnCount(); i++) {
                        sortKeys.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
                }
                sorter.setSortKeys(sortKeys);

                addPublisherBtn.setBackground(new java.awt.Color(51, 51, 51));
                addPublisherBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
                addPublisherBtn.setForeground(new java.awt.Color(255, 255, 255));
                addPublisherBtn.setText("ADD NEW Publisher");
                addPublisherBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                addPublisherBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addPublisherBtnActionPerformed(evt, cardLayout, panelParent);
                        }
                });

                pageTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
                pageTitle.setText("List Publisher");

                statusBtn1.setText("Hide");
                statusBtn1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                searchBtnActionPerformed(evt);
                        }
                });
                statusBtn2.setText("UnHide");
                statusBtn2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                searchBtnActionPerformed(evt);
                        }
                });

                statusBtnGroup = new ButtonGroup();
                statusBtnGroup.add(statusBtn1);
                statusBtnGroup.add(statusBtn2);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this);
                setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(57, 57, 57)
                                                                                                                .addComponent(jScrollPane1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                652,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                jPanel2Layout.createSequentialGroup()
                                                                                                                                .addContainerGap()
                                                                                                                                .addComponent(addPublisherBtn,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                150,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(92, 92, 92)
                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                .createSequentialGroup()

                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(statusBtn1,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                98,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(statusBtn2,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                98,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addComponent(searchPanel,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(320, 320, 320)
                                                                                                .addComponent(pageTitle)))
                                                                .addContainerGap(91, Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(searchPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)

                                                                                .addComponent(statusBtn1)
                                                                                .addComponent(statusBtn2))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(pageTitle)
                                                                .addGap(8, 8, 8)
                                                                .addComponent(addPublisherBtn)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(23, 23, 23)));

        }// </editor-fold>//GEN-END:initComponents

        private void addPublisherBtnActionPerformed(java.awt.event.ActionEvent evt, CardLayout cobj,
                        JPanel panelParent) {// GEN-FIRST:event_addPublisherBtnActionPerformed
                // TODO add your handling code here:
                cobj.show(panelParent, "addPublisher");
        }// GEN-LAST:event_addPublisherBtnActionPerformed

        private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_searchOptionActionPerformed

        private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchFieldActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_searchFieldActionPerformed

        private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchBtnActionPerformed
                String key = searchField.getText();
                String field = searchOption.getSelectedItem().toString();

                String status = null;
                status = statusBtn1.isSelected() ? statusBtn1.getText() : status;
                status = statusBtn2.isSelected() ? statusBtn2.getText() : status;

                // "ID", "FullName", "Gender", "Hide"
                if (field.equals("Id")) {
                        ArrayList<Publisher> publishers = pubService.getPublisherById(key, status);
                        DefaultTableModel model = (DefaultTableModel) listPublisher.getModel();
                        model.setRowCount(0);
                        for (Publisher publisher : publishers) {
                                Object[] rowData = {
                                                publisher.getPublisherId(),
                                                publisher.getPublisherName(),
                                                publisher.getPublisherAddress(),
                                                publisher.isHide()
                                };

                                model.addRow(rowData);
                        }
                } else if (field.equals("Name")) {
                        ArrayList<Publisher> publishers = pubService.getPublisherByName(key, status);
                        DefaultTableModel model = (DefaultTableModel) listPublisher.getModel();

                        model.setRowCount(0);

                        for (Publisher publisher : publishers) {
                                Object[] rowData = {
                                                publisher.getPublisherId(),
                                                publisher.getPublisherName(),
                                                publisher.getPublisherAddress(),
                                                publisher.isHide()
                                };
                                model.addRow(rowData);
                        }
                } else if (field.equals("Address")) {
                        ArrayList<Publisher> publishers = pubService.getPublisherByAddress(key, status);
                        DefaultTableModel model = (DefaultTableModel) listPublisher.getModel();

                        model.setRowCount(0);

                        for (Publisher publisher : publishers) {
                                Object[] rowData = {
                                                publisher.getPublisherId(),
                                                publisher.getPublisherName(),
                                                publisher.getPublisherAddress(),
                                                publisher.isHide()
                                };
                                model.addRow(rowData);
                        }
                } else {
                        ArrayList<Publisher> publishers = pubService.getListPublishers(status);
                        DefaultTableModel model = (DefaultTableModel) listPublisher.getModel();
                        model.setRowCount(0);
                        for (Publisher publisher : publishers) {
                                Object[] rowData = {
                                                publisher.getPublisherId(),
                                                publisher.getPublisherName(),
                                                publisher.getPublisherAddress(),
                                                publisher.isHide()
                                };
                                model.addRow(rowData);
                        }
                }
        }// GEN-LAST:event_searchBtnActionPerformed

        public void resetActionPerformed(ActionEvent e) {
                searchField.setText("");

                statusBtnGroup.clearSelection();
                searchOption.setSelectedIndex(0);

                String status = null;
                status = statusBtn1.isSelected() ? statusBtn1.getText() : status;
                status = statusBtn2.isSelected() ? statusBtn2.getText() : status;

                ArrayList<Publisher> publishers = pubService.getListPublishers();
                DefaultTableModel model = (DefaultTableModel) listPublisher.getModel();
                model.setRowCount(0);
                for (Publisher publisher : publishers) {
                        Object[] rowData = {
                                        publisher.getPublisherId(),
                                        publisher.getPublisherName(),
                                        publisher.getPublisherAddress(),
                                        publisher.isHide()
                        };
                        model.addRow(rowData);
                }

        }

        private void rowSelectedAction(MouseEvent e) {// GEN-FIRST:event_searchOptionActionPerformed
                if (e.getClickCount() == 2) { // Kiểm tra xem người dùng đã nhấp đúp chuột chưa
                        int row = listPublisher.getSelectedRow();

                        Publisher publisher = new Publisher();
                        publisher.setPublisherId((String) listPublisher.getValueAt(row, 0));
                        publisher.setPublisherName((String) listPublisher.getValueAt(row, 1));
                        publisher.setPublisherAddress((String) listPublisher.getValueAt(row, 2));
                        publisher.setVisible((Boolean) listPublisher.getValueAt(row, 3));

                        EditInfoPublisherPanel editInfoPublisherPanel = new EditInfoPublisherPanel(cardLayout,
                                        panelParent, publisher);
                        if (editInfoPublisherPanel != null) {
                                panelParent.add(editInfoPublisherPanel, "editPublisher");
                                cardLayout.show(panelParent, "editPublisher");
                        }
                }

        }// GEN-LAST:event_searchOptionActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        CardLayout cardLayout;
        JPanel panelParent;
        PublisherService pubService;
        PublisherDao pubDao;

        private javax.swing.ButtonGroup statusBtnGroup;
        private javax.swing.JButton searchBtn;
        private javax.swing.JButton resetBtn;
        private javax.swing.JButton addPublisherBtn;
        private javax.swing.JComboBox<String> searchOption;
        private javax.swing.JLabel pageTitle;
        private javax.swing.JPanel searchPanel;
        private javax.swing.JPanel searchBtnPanel;
        private javax.swing.JRadioButton statusBtn1;
        private javax.swing.JRadioButton statusBtn2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextField searchField;
        private javax.swing.JTable listPublisher;

        // End of variables declaration//GEN-END:variables
        @Override
        public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
}
