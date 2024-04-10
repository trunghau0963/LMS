/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lms.bookCRUD;

import java.awt.CardLayout;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.lms.bookCRUD.SwitchButton.*;
import com.lms.bookCRUD.dal.*;
import com.lms.bookCRUD.main.BookView;
import com.lms.bookCRUD.model.BookModel;
import com.lms.bookCRUD.repo.*;
import com.lms.bookCRUD.service.*;

import javax.swing.JTable;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;

/**
 *
 * @author PCM
 */

class EditToggleEditor extends AbstractCellEditor implements TableCellEditor {
        private JToggleButton button = new JToggleButton("");

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                        int column) {
                if (value instanceof Boolean) {
                        button.setSelected((Boolean) value);
                } else {
                        button.setSelected(false); // or handle this case differently
                }
                button.addActionListener(e -> stopCellEditing());
                DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
                BookView.loadEditBookPanel(tblModel.getValueAt(row, 0).toString());
                return button;
        }

        @Override
        public Object getCellEditorValue() {
                return button.isSelected();
        }
}

class EditToggleRenderer implements TableCellRenderer {
        private JToggleButton button = new JToggleButton("");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                        int row, int column) {
                if (value instanceof Boolean) {
                        button.setSelected((Boolean) value);
                } else {
                        button.setSelected(false); // or handle this case differently
                }
                button.setText("Edit");
                return button;
        }
}

public class ListBook extends javax.swing.JPanel {
        private BookDao bookDao;
        private AuthorDao authorDao;
        private CategoryDao categoryDao;
        private PublisherDao publisherDao;
        private BookAuthorDao bookAuthorDao;
        private BookCategoryDao bookCategoryDao;
        private BookService bookService;

        /**
         * Creates new form BookList
         */
        public ListBook(CardLayout cardLayout, JPanel parentPanel) {
                this.cardLayout = cardLayout;
                this.parentPanel = parentPanel;
                bookDao = new BookRepo();
                authorDao = new AuthorRepo();
                categoryDao = new CategoryRepo();
                publisherDao = new PublisherRepo();
                bookAuthorDao = new BookAuthorRepo();
                bookCategoryDao = new BookCategoryRepo();
                bookService = new BookService(bookDao, authorDao, categoryDao, publisherDao, bookAuthorDao,
                                bookCategoryDao);
                initComponents();
        }

        public void reloadTable() {
                DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
                tblModel.setRowCount(0);
                List<BookModel> bookModels = bookService.getAllBooks();
                for (BookModel bookModel : bookModels) {
                        tblModel.addRow(new Object[] { bookModel.getId(), bookModel.getTitle(), bookModel.getEdition(),
                                        bookModel.getCategoriesString(),
                                        bookModel.getAuthorsString(), bookModel.getPublisher().toString(),
                                        bookModel.getSalePrice(), bookModel.getQuantity(),
                                        bookModel.getIsHide(), "Edit" });
                }
                jTable2.setModel(tblModel);
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
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                jPanel1 = new JPanel();
                jTextField1 = new JTextField();
                jComboBox1 = new JComboBox<>();
                jButton1 = new JButton();
                jScrollPane2 = new JScrollPane();
                jTable2 = new JTable() {

                        public boolean isCellEditable(int row, int column) {
                                if (column < 8)
                                        return false;
                                return true;
                        }

                };
                jButton2 = new JButton();
                label1 = new JLabel();

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
                                new javax.swing.ImageIcon(getClass().getResource("/com/lms/book/search-icon.png"))); // NOI18N
                jButton1.setRolloverIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/com/lms/book/search-icon.png"))); // NOI18N
                jButton1.setRolloverSelectedIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/com/lms/book/search-icon.png"))); // NOI18N
                jButton1.setSelected(true);
                jButton1.setSelectedIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/com/lms/book/search-icon.png"))); // NOI18N

                jTable2.setBackground(new java.awt.Color(231, 226, 226));

                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {},
                                new String[] {
                                                "ID", "Title", "Edition", "Category", "Author", "Publisher", "Price",
                                                "In Stock", "Show/Hide",
                                                "Action"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                                        java.lang.String.class,
                                        java.lang.String.class,
                                        java.lang.String.class, java.lang.Float.class, java.lang.Integer.class,
                                        java.lang.Boolean.class,
                                        java.lang.Object.class
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }
                });
                jTable2.getColumnModel().getColumn(8).setCellRenderer(new ToggleRenderer());
                jTable2.getColumnModel().getColumn(8).setCellEditor(new ToggleEditor());
                jTable2.getColumnModel().getColumn(9).setCellRenderer(new EditToggleRenderer());
                jTable2.getColumnModel().getColumn(9).setCellEditor(new EditToggleEditor());

                jTable2.setColumnSelectionAllowed(true);
                jTable2.setGridColor(new java.awt.Color(0, 0, 0));
                jTable2.setRowHeight(26);
                jTable2.setShowGrid(true);
                jScrollPane2.setViewportView(jTable2);
                jTable2.getColumnModel().getSelectionModel()
                                .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTable2MouseClicked(evt);
                        }
                });
                List<BookModel> bookModels = bookService.getAllBooks();
                DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
                for (BookModel bookModel : bookModels) {
                        tblModel.addRow(new Object[] { bookModel.getId(), bookModel.getTitle(), bookModel.getEdition(),
                                        bookModel.getCategoriesString(),
                                        bookModel.getAuthorsString(), bookModel.getPublisher().toString(),
                                        bookModel.getSalePrice(), bookModel.getQuantity(),
                                        bookModel.getIsHide(), "Edit" });
                }

                jTable2.setModel(tblModel);

                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable2.getModel());
                jTable2.setRowSorter(sorter);
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
                label1.setText("List Books");

                javax.swing.GroupLayout borderPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(borderPanel1Layout);
                borderPanel1Layout.setHorizontalGroup(
                                borderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(borderPanel1Layout.createSequentialGroup()
                                                                .addGap(61, 61, 61)
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
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(60, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGroup(borderPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(borderPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(294, 294, 294)
                                                                                                .addComponent(label1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButton2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(borderPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(jScrollPane2)))
                                                                .addGap(15, 15, 15)));
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
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(label1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                28,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(16, 16, 16)
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                288,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(172, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        }// </editor-fold>//GEN-END:initComponents

        private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jComboBox1ActionPerformed

        private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {

        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                cardLayout.show(parentPanel, "addBook");
        }// GEN-LAST:event_jButton2ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private JPanel jPanel1;
        private JButton jButton1;
        private JButton jButton2;
        private JComboBox<String> jComboBox1;
        private JScrollPane jScrollPane2;
        private JTable jTable2;
        private JTextField jTextField1;
        private JLabel label1;
        CardLayout cardLayout;
        JPanel parentPanel;
        // End of variables declaration//GEN-END:variables
}
