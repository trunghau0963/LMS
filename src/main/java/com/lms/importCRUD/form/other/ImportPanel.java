/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.lms.importCRUD.form.other;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.lms.importCRUD.models.AuthorModel;
import com.lms.importCRUD.models.BookModel;
import com.lms.importCRUD.dal.BookDao;
import com.lms.importCRUD.repo.AuthorRepo;
import com.lms.importCRUD.repo.BookAuthorRepo;
import com.lms.importCRUD.repo.BookCategoryRepo;
import com.lms.importCRUD.repo.BookRepo;
import com.lms.importCRUD.repo.CategoryRepo;
import com.lms.importCRUD.repo.PublisherRepo;
import com.lms.importCRUD.service.BookService;

/**
 *
 * @author nttha
 */

public class ImportPanel extends javax.swing.JInternalFrame {
        class DisabledRowRenderer extends DefaultTableCellRenderer {
                @Override
                public JComponent getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                boolean hasFocus, int row, int column) {
                        JComponent component = (JComponent) super.getTableCellRendererComponent(table, value,
                                        isSelected,
                                        hasFocus, row, column);
                        if (disabledRows.contains(row)) {
                                component.setEnabled(false);
                        } else {
                                component.setEnabled(true); // Kích hoạt trở lại các dòng không bị vô hiệu hóa
                        }
                        return component;
                }
        }

        public void setListBookModel() {
                listBookModel = new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Id", "Title", "Sale Price", "Quantity", "Edition", "Publisher",
                                                "Authors"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.Double.class,
                                        java.lang.Integer.class,
                                        java.lang.Integer.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                };

                bookList.setModel(listBookModel);
        }

        public void setImportListBookModel() {
                importListBookModel = new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Id", "Title", "Editon", "Sale Price", "Quantity"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                                        java.lang.Double.class,
                                        java.lang.Integer.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, true, true, true
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                };
                importBookList.setModel(importListBookModel);
        }

        public void setRowSorter(JTable tbName, List<BookModel> books) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbName.getModel());
                tbName.setRowSorter(sorter);

                List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);

                for (int i = 0; i < tbName.getColumnCount(); i++) {
                        sortKeys.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
                }
                sorter.setSortKeys(sortKeys);
        }

        public void loadBooksToTable(List<BookModel> books) {
                try {
                        listBookModel.setRowCount(0);
                        for (BookModel book : books) {
                                String authors = "";
                                for (AuthorModel e : book.getAuthors()) {
                                        authors += e.getName() + ", ";
                                }
                                Object[] rowData = {
                                                book.getId(),
                                                book.getTitle(),
                                                book.getSalePrice(),
                                                book.getQuantity(),
                                                book.getEdition(),
                                                book.getPublisher().getName(),
                                                authors
                                };

                                listBookModel.addRow(rowData);
                        }
                } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e);
                }
        }

        /**
         * Creates new form ImportPanel
         */
        public ImportPanel() {
                initComponents();

                bookDao = new BookRepo();
                bookService = new BookService(bookDao, new AuthorRepo(), new CategoryRepo(), new PublisherRepo(),
                                new BookAuthorRepo(), new BookCategoryRepo());

                // Setting book table
                books = bookService.getAllBooks();
                setListBookModel();
                setRowSorter(bookList, books);

                // Setting import book table
                setImportListBookModel();
                loadBooksToTable(books);

                ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
                UIManager.put("Table.showVerticalLines", true);
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
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel9 = new javax.swing.JPanel();
                jPanel11 = new javax.swing.JPanel();
                searchZone = new javax.swing.JPanel();
                jPanel4 = new javax.swing.JPanel();
                jPanel14 = new javax.swing.JPanel();
                filterButton = new javax.swing.JButton();
                searchOption = new javax.swing.JComboBox<>();
                jPanel15 = new javax.swing.JPanel();
                searchField = new javax.swing.JTextField();
                jPanel16 = new javax.swing.JPanel();
                refreshButton = new javax.swing.JButton();
                bookListZone = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                bookList = new javax.swing.JTable();
                jPanel19 = new javax.swing.JPanel();
                totalZone = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                totalNumber = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                jPanel7 = new javax.swing.JPanel();
                infoZone = new javax.swing.JPanel();
                jPanel17 = new javax.swing.JPanel();
                jPanel10 = new javax.swing.JPanel();
                jLabel9 = new javax.swing.JLabel();
                titleTxT = new javax.swing.JTextField();
                jPanel18 = new javax.swing.JPanel();
                jPanel12 = new javax.swing.JPanel();
                jLabel10 = new javax.swing.JLabel();
                titleTxT1 = new javax.swing.JTextField();
                jPanel5 = new javax.swing.JPanel();
                jScrollPane3 = new javax.swing.JScrollPane();
                importBookList = new javax.swing.JTable();
                jPanel13 = new javax.swing.JPanel();
                jPanel28 = new javax.swing.JPanel();
                removeBtnZone = new javax.swing.JPanel();
                jButton8 = new javax.swing.JButton();
                importBtnZone = new javax.swing.JPanel();
                jButton9 = new javax.swing.JButton();
                jPanel27 = new javax.swing.JPanel();
                typeFileChooseZone = new javax.swing.JPanel();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                jButton4 = new javax.swing.JButton();

                setBorder(null);
                getContentPane().setLayout(
                                new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

                jPanel1.setPreferredSize(new java.awt.Dimension(450, 516));
                jPanel1.setLayout(new java.awt.BorderLayout());

                jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
                jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

                jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 1, 20));
                jPanel11.setMinimumSize(new java.awt.Dimension(392, 80));
                jPanel11.setPreferredSize(new java.awt.Dimension(800, 120));
                jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

                searchZone.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Import Book",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
                searchZone.setPreferredSize(new java.awt.Dimension(400, 200));
                searchZone.setLayout(new java.awt.BorderLayout());

                jPanel4.setPreferredSize(new java.awt.Dimension(800, 40));
                jPanel4.setLayout(new java.awt.BorderLayout());

                jPanel14.setPreferredSize(new java.awt.Dimension(150, 40));

                filterButton.setPreferredSize(new java.awt.Dimension(40, 40));
                filterButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                filterButtonActionPerformed(evt);
                        }
                });
                jPanel14.add(filterButton);

                searchOption.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                searchOption.setPreferredSize(new java.awt.Dimension(100, 40));
                searchOption.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                searchOptionActionPerformed(evt);
                        }
                });
                jPanel14.add(searchOption);

                jPanel4.add(jPanel14, java.awt.BorderLayout.WEST);

                jPanel15.setPreferredSize(new java.awt.Dimension(700, 40));

                searchField.setPreferredSize(new java.awt.Dimension(71, 40));

                javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
                jPanel15.setLayout(jPanel15Layout);
                jPanel15Layout.setHorizontalGroup(
                                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel15Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(searchField,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                253, Short.MAX_VALUE)
                                                                .addGap(8, 8, 8)));
                jPanel15Layout.setVerticalGroup(
                                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel15Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(searchField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                40,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(34, Short.MAX_VALUE)));

                jPanel4.add(jPanel15, java.awt.BorderLayout.CENTER);

                jPanel16.setPreferredSize(new java.awt.Dimension(60, 40));
                jPanel16.setRequestFocusEnabled(false);

                refreshButton.setToolTipText("Refresh");
                refreshButton.setPreferredSize(new java.awt.Dimension(60, 40));
                refreshButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                refreshButtonActionPerformed(evt);
                        }
                });
                jPanel16.add(refreshButton);

                jPanel4.add(jPanel16, java.awt.BorderLayout.EAST);

                searchZone.add(jPanel4, java.awt.BorderLayout.CENTER);

                jPanel11.add(searchZone);

                jPanel9.add(jPanel11);

                jPanel1.add(jPanel9, java.awt.BorderLayout.NORTH);

                bookListZone.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
                bookListZone.setPreferredSize(new java.awt.Dimension(800, 400));
                bookListZone.setLayout(new java.awt.BorderLayout());

                jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

                bookList.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Id", "Title", "Sale Price", "Quantity", "Edition", "Publishers",
                                                "Authors"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.Double.class,
                                        java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class,
                                        java.lang.String.class
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }
                });
                bookList.setRowHeight(30);
                bookList.setShowGrid(true);
                bookList.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                bookListMouseClicked(evt);
                        }
                });
                jScrollPane2.setViewportView(bookList);

                bookListZone.add(jScrollPane2, java.awt.BorderLayout.CENTER);

                jPanel1.add(bookListZone, java.awt.BorderLayout.CENTER);

                jPanel19.setPreferredSize(new java.awt.Dimension(657, 80));
                jPanel19.setLayout(new javax.swing.BoxLayout(jPanel19, javax.swing.BoxLayout.LINE_AXIS));

                totalZone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
                totalZone.setPreferredSize(new java.awt.Dimension(300, 117));
                totalZone.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                jLabel1.setText("Total");
                totalZone.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, -1));

                totalNumber.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                totalNumber.setForeground(new java.awt.Color(255, 51, 51));
                totalNumber.setText("0đ");
                totalZone.add(totalNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 340, 30));

                jPanel19.add(totalZone);

                jPanel1.add(jPanel19, java.awt.BorderLayout.PAGE_END);

                getContentPane().add(jPanel1);

                jPanel2.setPreferredSize(new java.awt.Dimension(200, 517));
                jPanel2.setLayout(new java.awt.BorderLayout());

                jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
                jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

                infoZone.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
                infoZone.setLayout(new javax.swing.BoxLayout(infoZone, javax.swing.BoxLayout.Y_AXIS));

                jPanel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
                jPanel17.setPreferredSize(new java.awt.Dimension(700, 60));
                jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.Y_AXIS));

                jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel9.setText("Title");

                javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
                jPanel10.setLayout(jPanel10Layout);
                jPanel10Layout.setHorizontalGroup(
                                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 266, Short.MAX_VALUE)
                                                .addGroup(jPanel10Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel9,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                266, Short.MAX_VALUE)));
                jPanel10Layout.setVerticalGroup(
                                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(jPanel10Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel10Layout.createSequentialGroup()
                                                                                .addComponent(jLabel9)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));

                jPanel17.add(jPanel10);
                jPanel17.add(titleTxT);

                infoZone.add(jPanel17);

                jPanel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
                jPanel18.setPreferredSize(new java.awt.Dimension(700, 60));
                jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.Y_AXIS));

                jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel10.setText("Title");

                javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
                jPanel12.setLayout(jPanel12Layout);
                jPanel12Layout.setHorizontalGroup(
                                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 266, Short.MAX_VALUE)
                                                .addGroup(jPanel12Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel10,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                266, Short.MAX_VALUE)));
                jPanel12Layout.setVerticalGroup(
                                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(jPanel12Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel12Layout.createSequentialGroup()
                                                                                .addComponent(jLabel10)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));

                jPanel18.add(jPanel12);
                jPanel18.add(titleTxT1);

                infoZone.add(jPanel18);

                jPanel7.add(infoZone);

                jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_START);

                jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                jPanel5.setLayout(new java.awt.BorderLayout());

                jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));

                importBookList.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Id", "Title", "Sale Price", "Quantity"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.Double.class,
                                        java.lang.Integer.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, true, true
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                importBookList.setRowHeight(30);
                importBookList.setShowGrid(true);
                importBookList.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                importBookListMouseClicked(evt);
                        }
                });
                jScrollPane3.setViewportView(importBookList);

                jPanel5.add(jScrollPane3, java.awt.BorderLayout.CENTER);

                jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

                jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

                jPanel28.setPreferredSize(new java.awt.Dimension(365, 120));
                jPanel28.setLayout(new javax.swing.BoxLayout(jPanel28, javax.swing.BoxLayout.Y_AXIS));

                jButton8.setText("Remove all");
                jButton8.setPreferredSize(new java.awt.Dimension(80, 40));
                jButton8.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton8ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout removeBtnZoneLayout = new javax.swing.GroupLayout(removeBtnZone);
                removeBtnZone.setLayout(removeBtnZoneLayout);
                removeBtnZoneLayout.setHorizontalGroup(
                                removeBtnZoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 280, Short.MAX_VALUE)
                                                .addGroup(removeBtnZoneLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(removeBtnZoneLayout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(jButton8,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                268, Short.MAX_VALUE)
                                                                                .addContainerGap())));
                removeBtnZoneLayout.setVerticalGroup(
                                removeBtnZoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 52, Short.MAX_VALUE)
                                                .addGroup(removeBtnZoneLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                removeBtnZoneLayout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap(7,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButton8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                37,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(8,
                                                                                                                Short.MAX_VALUE))));

                jPanel28.add(removeBtnZone);

                jButton9.setText("Import List Book");
                jButton9.setPreferredSize(new java.awt.Dimension(80, 40));
                jButton9.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton9ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout importBtnZoneLayout = new javax.swing.GroupLayout(importBtnZone);
                importBtnZone.setLayout(importBtnZoneLayout);
                importBtnZoneLayout.setHorizontalGroup(
                                importBtnZoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 280, Short.MAX_VALUE)
                                                .addGroup(importBtnZoneLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(importBtnZoneLayout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(jButton9,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                268, Short.MAX_VALUE)
                                                                                .addContainerGap())));
                importBtnZoneLayout.setVerticalGroup(
                                importBtnZoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 67, Short.MAX_VALUE)
                                                .addGroup(importBtnZoneLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                importBtnZoneLayout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap(15,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButton9,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                37,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(15,
                                                                                                                Short.MAX_VALUE))));

                jPanel28.add(importBtnZone);

                jPanel13.add(jPanel28);

                jPanel2.add(jPanel13, java.awt.BorderLayout.PAGE_END);

                jPanel27.setLayout(new java.awt.BorderLayout());

                typeFileChooseZone.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jButton2.setText("Remove");
                jButton2.setPreferredSize(new java.awt.Dimension(80, 40));
                typeFileChooseZone.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

                jButton3.setText("Pdf");
                jButton3.setPreferredSize(new java.awt.Dimension(80, 40));
                typeFileChooseZone.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

                jButton4.setText("Excel");
                jButton4.setPreferredSize(new java.awt.Dimension(80, 40));
                typeFileChooseZone.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

                jPanel27.add(typeFileChooseZone, java.awt.BorderLayout.CENTER);

                jPanel2.add(jPanel27, java.awt.BorderLayout.LINE_END);

                getContentPane().add(jPanel2);

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void importBookListMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_importBookListMouseClicked
                // TODO add your handling code here:
                if (evt.getClickCount() == 2) { // Kiểm tra xem người dùng đã nhấp đúp
                        int row = importBookList.getSelectedRow();
        
                        disabledRows.remove(row);

                        importListBookModel.removeRow(row);
                        
                        bookList.repaint();

                }
        }// GEN-LAST:event_importBookListMouseClicked

        private void bookListMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_bookListMouseClicked
                // TODO add your handling code here:
                int row = bookList.getSelectedRow();
                if (evt.getClickCount() == 2 && !disabledRows.contains(row)) { // Kiểm tra xem người dùng đã nhấp đúp
                                                                               // chuột chưa
                        System.out.println(row);

                        disabledRows.add(row);

                        for (int col = 0; col < bookList.getColumnCount(); col++) {
                                bookList.getColumnModel().getColumn(col)
                                                .setCellRenderer(new DisabledRowRenderer());
                        }

                        BookModel book = new BookModel();
                        book.setId((String) bookList.getValueAt(row, 0));
                        book.setTitle((String) bookList.getValueAt(row, 1));
                        book.setSalePrice((Float) bookList.getValueAt(row, 2));
                        book.setQuantity((Integer) bookList.getValueAt(row, 3));
                        book.setEdition((Integer) bookList.getValueAt(row, 4));

                        Object[] rowData = {
                                        book.getId(),
                                        book.getTitle(),
                                        book.getSalePrice(),
                                        book.getQuantity(),
                                        book.getEdition()
                        };

                        importListBookModel.addRow(rowData);
                        bookList.repaint();

                }
        }// GEN-LAST:event_bookListMouseClicked

        private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_refreshButtonActionPerformed

        private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_searchOptionActionPerformed

        private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_filterButtonActionPerformed

        private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jButton8ActionPerformed

        private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jButton9ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTable bookList;
        private javax.swing.JPanel bookListZone;
        private javax.swing.JButton filterButton;
        private javax.swing.JTable importBookList;
        private javax.swing.JPanel importBtnZone;
        private javax.swing.JPanel infoZone;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JButton jButton8;
        private javax.swing.JButton jButton9;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel10;
        private javax.swing.JPanel jPanel11;
        private javax.swing.JPanel jPanel12;
        private javax.swing.JPanel jPanel13;
        private javax.swing.JPanel jPanel14;
        private javax.swing.JPanel jPanel15;
        private javax.swing.JPanel jPanel16;
        private javax.swing.JPanel jPanel17;
        private javax.swing.JPanel jPanel18;
        private javax.swing.JPanel jPanel19;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel27;
        private javax.swing.JPanel jPanel28;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JPanel jPanel9;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JButton refreshButton;
        private javax.swing.JPanel removeBtnZone;
        private javax.swing.JTextField searchField;
        private javax.swing.JComboBox<String> searchOption;
        private javax.swing.JPanel searchZone;
        private javax.swing.JTextField titleTxT;
        private javax.swing.JTextField titleTxT1;
        private javax.swing.JLabel totalNumber;
        private javax.swing.JPanel totalZone;
        private javax.swing.JPanel typeFileChooseZone;
        private DefaultTableModel listBookModel;
        private DefaultTableModel importListBookModel;
        private BookService bookService;
        private BookDao bookDao;
        private List<BookModel> books;
        private List<BookModel> importBooks;
        private Set<Integer> disabledRows = new HashSet<>();
        // End of variables declaration//GEN-END:variables
}
