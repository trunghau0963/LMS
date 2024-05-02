/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.lms.importCRUD.form.other;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lms.importCRUD.models.AuthorModel;
import com.lms.importCRUD.models.BookModel;
import com.lms.importCRUD.dal.BookDao;
import com.lms.importCRUD.dal.SheetDao;
import com.lms.importCRUD.dal.SheetDetailDao;
import com.lms.importCRUD.entities.ImportBook;
import com.lms.importCRUD.repo.AuthorRepo;
import com.lms.importCRUD.repo.BookAuthorRepo;
import com.lms.importCRUD.repo.BookCategoryRepo;
import com.lms.importCRUD.repo.BookRepo;
import com.lms.importCRUD.repo.CategoryRepo;
import com.lms.importCRUD.repo.PublisherRepo;
import com.lms.importCRUD.repo.SheetDetailRepo;
import com.lms.importCRUD.repo.SheetRepo;
import com.lms.importCRUD.service.BookService;
import com.lms.importCRUD.service.SheetDetailService;
import com.lms.importCRUD.service.SheetService;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Cell;

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
                        if (disabledRows.containsValue(row)) {
                                component.setEnabled(false);
                        } else {
                                component.setEnabled(true); // Kích hoạt trở lại các dòng không bị vô hiệu hóa
                        }
                        return component;
                }
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
                importBookListTable.setModel(importListBookModel);
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
                setRowSorter(bookListTable, books);

                // Setting import book table
                setImportListBookModel();
                loadBooksToTable(books);

                // sheet
                sheetDao = new SheetRepo();
                sheetService = new SheetService(sheetDao);

                // sheet detail
                sheetDetailDao = new SheetDetailRepo();
                sheetDetailService = new SheetDetailService(sheetDetailDao);

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
                bookListTableZone = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                bookListTable = new javax.swing.JTable();
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
                importBookListTable = new javax.swing.JTable();
                jPanel13 = new javax.swing.JPanel();
                jPanel28 = new javax.swing.JPanel();
                removeBtnZone = new javax.swing.JPanel();
                removeAllBtn = new javax.swing.JButton();
                importBtnZone = new javax.swing.JPanel();
                importBtn = new javax.swing.JButton();
                jPanel27 = new javax.swing.JPanel();
                typeFileChooseZone = new javax.swing.JPanel();
                removeBtn = new javax.swing.JButton();
                exportPdfBtn = new javax.swing.JButton();
                exportExcelBtn = new javax.swing.JButton();

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

                bookListTableZone.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
                bookListTableZone.setPreferredSize(new java.awt.Dimension(800, 400));
                bookListTableZone.setLayout(new java.awt.BorderLayout());

                jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

                bookListTable.setModel(new javax.swing.table.DefaultTableModel(
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
                bookListTable.setRowHeight(30);
                bookListTable.setShowGrid(true);
                bookListTable.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                bookListTableMouseClicked(evt);
                        }
                });
                jScrollPane2.setViewportView(bookListTable);

                bookListTableZone.add(jScrollPane2, java.awt.BorderLayout.CENTER);

                jPanel1.add(bookListTableZone, java.awt.BorderLayout.CENTER);

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

                importBookListTable.setModel(new javax.swing.table.DefaultTableModel(
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
                importBookListTable.setRowHeight(30);
                importBookListTable.setShowGrid(true);
                importBookListTable.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                importBookListTableMouseClicked(evt);
                        }
                });
                jScrollPane3.setViewportView(importBookListTable);

                jPanel5.add(jScrollPane3, java.awt.BorderLayout.CENTER);

                jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

                jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

                jPanel28.setPreferredSize(new java.awt.Dimension(365, 120));
                jPanel28.setLayout(new javax.swing.BoxLayout(jPanel28, javax.swing.BoxLayout.Y_AXIS));

                removeAllBtn.setText("Remove all");
                removeAllBtn.setPreferredSize(new java.awt.Dimension(80, 40));
                removeAllBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                removeAllBtnActionPerformed(evt);
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
                                                                                .addComponent(removeAllBtn,
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
                                                                                                .addComponent(removeAllBtn,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                37,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(8,
                                                                                                                Short.MAX_VALUE))));

                jPanel28.add(removeBtnZone);

                importBtn.setText("Import List Book");
                importBtn.setPreferredSize(new java.awt.Dimension(80, 40));
                importBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                importBtnActionPerformed(evt);
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
                                                                                .addComponent(importBtn,
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
                                                                                                .addComponent(importBtn,
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

                removeBtn.setText("Remove");
                removeBtn.setPreferredSize(new java.awt.Dimension(80, 40));
                typeFileChooseZone.add(removeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

                exportPdfBtn.setText("Pdf");
                exportPdfBtn.setPreferredSize(new java.awt.Dimension(80, 40));
                typeFileChooseZone.add(exportPdfBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

                exportExcelBtn.setText("Excel");
                exportExcelBtn.setPreferredSize(new java.awt.Dimension(80, 40));
                typeFileChooseZone.add(exportExcelBtn,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

                jPanel27.add(typeFileChooseZone, java.awt.BorderLayout.CENTER);

                jPanel2.add(jPanel27, java.awt.BorderLayout.LINE_END);

                getContentPane().add(jPanel2);

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void importBookListTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_importBookListTableMouseClicked
                // TODO add your handling code here:
                if (evt.getClickCount() == 2) { // Kiểm tra xem người dùng đã nhấp đúp
                        int row = importBookListTable.getSelectedRow();
                        String idObject = (String) importBookListTable.getValueAt(row, 0);

                        totalNumber.setText(String.valueOf(calTotalCost()) + "$");

                        for (int col = 0; col < bookListTable.getColumnCount(); col++) {
                                bookListTable.getColumnModel().getColumn(col)
                                                .setCellRenderer(new DisabledRowRenderer());
                        }

                        importListBookModel.removeRow(row);

                        System.out.println(idObject);

                        disabledRows.remove(idObject);

                        System.out.println(disabledRows);

                        bookListTable.repaint();
                }
        }// GEN-LAST:event_importBookListTableMouseClicked

        // Hàm kiểm tra dữ liệu số và hiển thị thông báo lỗi nếu có
        private static boolean validatePriceInput(JTextField textField, JLabel errorLabel) {
                try {
                        float number = Float.parseFloat(textField.getText());
                        if (number < 0) {
                                errorLabel.setText("  Value must be >= 0");
                                errorLabel.setForeground(Color.RED); // Thiết lập màu đỏ cho label
                                return false;
                        } else {
                                errorLabel.setText("  Valid input"); // Xóa thông báo lỗi nếu dữ liệu hợp lệ
                                errorLabel.setForeground(Color.GREEN);
                                return true;
                        }
                } catch (NumberFormatException e) {
                        errorLabel.setText("  Invalid input");
                        errorLabel.setForeground(Color.RED);
                        return false;
                }
        }

        private static boolean validateQuantityInput(JTextField textField, JLabel errorLabel) {
                try {
                        float number = Float.parseFloat(textField.getText());
                        if (number < 0) {
                                errorLabel.setText("  Value must be >= 0");
                                errorLabel.setForeground(Color.RED); // Thiết lập màu đỏ cho label
                                return false;
                        } else if (number != (int) number) {
                                errorLabel.setText("  Value must an integer type");
                                errorLabel.setForeground(Color.RED); // Thiết lập màu đỏ cho label
                                return false;
                        } else {
                                errorLabel.setText("  Valid input"); // Xóa thông báo lỗi nếu dữ liệu hợp lệ
                                errorLabel.setForeground(Color.GREEN);
                                return true;
                        }
                } catch (NumberFormatException e) {
                        errorLabel.setText("  Invalid input");
                        errorLabel.setForeground(Color.RED);
                        return false;
                }
        }

        public List<String> showMultiInputDialog(String title, int edition) {
                JPanel panel = new JPanel(new GridLayout(2, 3));
                JPanel inputConstPanel = new JPanel(new GridLayout(0, 3));
                JPanel inputPanel = new JPanel(new GridLayout(0, 3));

                JTextField titleField = new JTextField(title, 10);
                titleField.setEditable(false);
                JTextField editionField = new JTextField("Edition: " + String.valueOf(edition), 10);
                editionField.setEditable(false);
                JTextField quantityField = new JTextField(10);
                JTextField salePriceField = new JTextField(10);
                JLabel quantityErrorLabel = new JLabel();
                JLabel salePriceErrorLabel = new JLabel();
                JLabel titleLabel = new JLabel("  Valid input");
                titleLabel.setForeground(Color.GREEN);
                JLabel editionLabel = new JLabel("  Valid input");
                editionLabel.setForeground(Color.GREEN);

                inputConstPanel.add(new JLabel("Title"));
                inputConstPanel.add(titleField);
                inputConstPanel.add(titleLabel);
                inputConstPanel.add(new JLabel("Edition"));
                inputConstPanel.add(editionField);
                inputConstPanel.add(editionLabel);
                inputPanel.add(new JLabel("Please enter book's quantity"));
                inputPanel.add(quantityField);
                inputPanel.add(quantityErrorLabel);
                inputPanel.add(new JLabel("Please enter book's sale price"));
                inputPanel.add(salePriceField);
                inputPanel.add(salePriceErrorLabel);
                panel.add(inputConstPanel);
                panel.add(inputPanel);

                // Sử dụng FocusListener để kiểm tra dữ liệu khi component mất focus
                quantityField.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(FocusEvent e) {
                                validateQuantityInput(quantityField, quantityErrorLabel);
                        }
                });

                salePriceField.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(FocusEvent e) {
                                validatePriceInput(salePriceField, salePriceErrorLabel);
                        }
                });

                int result = JOptionPane.showConfirmDialog(null, panel, "Multi-Input Dialog",
                                JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                        if (validateQuantityInput(quantityField, quantityErrorLabel)
                                        && validatePriceInput(salePriceField, salePriceErrorLabel)) {
                                List<String> inputs = new ArrayList<>();
                                inputs.add(quantityField.getText());
                                inputs.add(salePriceField.getText());

                                JOptionPane.showMessageDialog(this, "Added to import book table");

                                return inputs;
                        } else {
                                JOptionPane.showMessageDialog(null, "Add fail. Please refill in all fields.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                                return null;
                        }

                }
                return null; // Trả về null nếu người dùng cancel hoặc đóng dialog
        }

        public float calTotalCost() {
                float total = 0;
                for (int i = 0; i < importListBookModel.getRowCount(); i++) {
                        total += Float.parseFloat(importListBookModel.getValueAt(i, 3).toString())
                                        * Integer.parseInt(importListBookModel.getValueAt(i, 4).toString());
                }
                return total;
        }

        private void bookListTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_bookListTableMouseClicked
                // TODO add your handling code here:
                int row = bookListTable.getSelectedRow();
                String id = (String) bookListTable.getValueAt(row, 0);

                if (evt.getClickCount() == 2 && !disabledRows.containsKey(id)) {
                        BookModel book = new BookModel();
                        book.setId((String) bookListTable.getValueAt(row, 0));
                        book.setTitle((String) bookListTable.getValueAt(row, 1));
                        book.setEdition((Integer) bookListTable.getValueAt(row, 4));

                        List<String> inputs = showMultiInputDialog(book.getTitle(), book.getEdition());

                        if (inputs != null) {
                                book.setQuantity(Integer.parseInt(inputs.get(0)));
                                book.setSalePrice(Float.parseFloat(inputs.get(1)));
                                System.out.println(inputs.get(1));
                                importBooks.add(book);

                                Object[] rowData = {
                                                book.getId(),
                                                book.getTitle(),
                                                book.getEdition(),
                                                book.getSalePrice(),
                                                book.getQuantity()
                                };

                                importListBookModel.addRow(rowData);

                                totalNumber.setText(String.valueOf(calTotalCost()) + "$");

                                for (int col = 0; col < bookListTable.getColumnCount(); col++) {
                                        bookListTable.getColumnModel().getColumn(col)
                                                        .setCellRenderer(new DisabledRowRenderer());
                                }

                                disabledRows.put(id, row);

                                bookListTable.repaint();
                        }

                }
        }// GEN-LAST:event_bookListTableMouseClicked

        private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_refreshButtonActionPerformed

        private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_searchOptionActionPerformed

        private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_filterButtonActionPerformed

        private void removeAllBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeAllBtnActionPerformed
                // TODO add your handling code here:
                importBooks.clear();
                importListBookModel.setRowCount(0);
                totalNumber.setText(String.valueOf(calTotalCost()) + "$");
                disabledRows.clear();
                bookListTable.repaint();
        }// GEN-LAST:event_removeAllBtnActionPerformed

        private void importBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_importBtnActionPerformed
                // TODO add your handling code here:
                if (importBooks.size() == 0) {
                        JOptionPane.showMessageDialog(this, "Please select books to import");
                        return;
                } else {
                        List<ImportBook> imBooks = new ArrayList<>();

                        for (BookModel e : importBooks) {
                                ImportBook book = new ImportBook(e.getId(), e.getQuantity(), e.getSalePrice());
                                imBooks.add(book);
                        }

                        String sheetId = sheetService.createSheet(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                                        "ef3d16db8e6aad88");
                        System.out.println(sheetId);
                        sheetDetailService.insertIntoSheet(sheetId, imBooks);

                        JOptionPane.showMessageDialog(this, "Import successfully");

                        importBooks.clear();
                        importListBookModel.setRowCount(0);
                        totalNumber.setText(String.valueOf(calTotalCost()) + "$");
                        disabledRows.clear();

                        bookListTable.repaint();
                }
        }// GEN-LAST:event_importBtnActionPerformed

        public void openFile(String file) {
                try {
                        File myFile = new File(file);
                        Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                        // no application registered for PDFs
                        JOptionPane.showMessageDialog(this, "No application registered for PDFs");
                }
        }

        private void exportPDF() {
                JFileChooser chooser = new JFileChooser();
                try {
                        chooser.showSaveDialog(this);
                        File file = chooser.getSelectedFile();
                        if (file != null) {
                                file = new File(file.toString() + ".pdf");

                                // Initialize PDF document
                                PdfWriter writer = new PdfWriter(new FileOutputStream(file));
                                PdfDocument pdf = new PdfDocument(writer);
                                Document document = new Document(pdf, PageSize.A4);

                                // Set title
                                PdfFont titleFont = PdfFontFactory.createFont();
                                Paragraph title = new Paragraph("IMPORT BOOK")
                                                .setFont(titleFont)
                                                .setFontSize(20)
                                                .setTextAlignment(TextAlignment.CENTER);
                                document.add(title);

                                // Set export date and time
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                                String formattedDateTime = LocalDateTime.now().format(formatter);
                                Paragraph dateTime = new Paragraph("Import Date and Time: " + formattedDateTime)
                                                .setTextAlignment(TextAlignment.CENTER);
                                document.add(dateTime);

                                // Add table
                                Table table = new Table(importBookListTable.getColumnCount());
                                for (int i = 0; i < importBookListTable.getColumnCount(); i++) {
                                        Cell cell = new Cell().add(new Paragraph(importBookListTable.getColumnName(i)));
                                        cell.setBackgroundColor(new DeviceRgb(125, 200, 204));

                                        table.addCell(cell);
                                }
                                for (int i = 0; i < importBookListTable.getRowCount(); i++) {
                                        for (int j = 0; j < importBookListTable.getColumnCount(); j++) {
                                                if (importBookListTable.getValueAt(i, j) != null) {
                                                        table.addCell(importBookListTable.getValueAt(i, j).toString());
                                                } else {
                                                        table.addCell("");
                                                }
                                        }
                                }

                                document.add(table);

                                // Add total price
                                Paragraph totalPrice = new Paragraph("Total Price: " + totalNumber.getText())
                                                .setTextAlignment(TextAlignment.RIGHT);
                                document.add(totalPrice);

                                document.close();

                                openFile(file.toString());
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        private void exportExcel() {
                JFileChooser chooser = new JFileChooser();
                try {
                        chooser.showSaveDialog(this);
                        File file = chooser.getSelectedFile();
                        if (file != null) {
                                file = new File(file.toString() + ".xlsx");
                                XSSFWorkbook workbook = new XSSFWorkbook();
                                XSSFSheet sheet = workbook.createSheet("Books");

                                // Create title row
                                XSSFRow titleRow = sheet.createRow(0);
                                XSSFCell titleCell = titleRow.createCell(0);
                                titleCell.setCellValue("IMPORT BOOK");
                                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,
                                                importBookListTable.getColumnCount() - 1));
                                titleCell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);
                                titleCell.getCellStyle().setFont(createHeaderFont(workbook));

                                // Create date and time row
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                                String formattedDateTime = LocalDateTime.now().format(formatter);
                                XSSFRow dateTimeRow = sheet.createRow(1);
                                XSSFCell dateTimeCell = dateTimeRow.createCell(0);
                                dateTimeCell.setCellValue("Import Date and Time: " + formattedDateTime);
                                sheet.addMergedRegion(new CellRangeAddress(1, 1, 0,
                                                importBookListTable.getColumnCount() - 1));
                                dateTimeCell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);

                                // Create header row
                                XSSFRow headerRow = sheet.createRow(2);
                                for (int i = 0; i < importBookListTable.getColumnCount(); i++) {
                                        XSSFCell headerCell = headerRow.createCell(i);
                                        headerCell.setCellValue(importBookListTable.getColumnName(i));
                                        headerCell.getCellStyle().setFont(createHeaderFont(workbook));
                                }

                                // Populate data rows
                                for (int i = 0; i < importBookListTable.getRowCount(); i++) {
                                        XSSFRow dataRow = sheet.createRow(i + 3);
                                        for (int j = 0; j < importBookListTable.getColumnCount(); j++) {
                                                XSSFCell dataCell = dataRow.createCell(j);
                                                if (importBookListTable.getValueAt(i, j) != null) {
                                                        dataCell.setCellValue(importBookListTable.getValueAt(i, j)
                                                                        .toString());
                                                }
                                        }
                                }

                                // Add total price row
                                XSSFRow totalPriceRow = sheet.createRow(sheet.getLastRowNum() + 2);
                                XSSFCell totalPriceCellLabel = totalPriceRow.createCell(0);
                                totalPriceCellLabel.setCellValue("Total Price");
                                XSSFCell totalPriceCell = totalPriceRow.createCell(1);
                                totalPriceCell.setCellValue(totalNumber.getText());

                                FileOutputStream fos = new FileOutputStream(file);
                                workbook.write(fos);
                                fos.close();
                                workbook.close();
                                openFile(file.toString());
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        private XSSFFont createHeaderFont(XSSFWorkbook workbook) {
                XSSFFont font = workbook.createFont();
                font.setFontHeightInPoints((short) 14);
                font.setBold(true);
                font.setColor(IndexedColors.BLACK.getIndex());
                return font;
        }

        public void setListBookModel() {
                // Add event supplementary
                setRemoveBtnEven();

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

                bookListTable.setModel(listBookModel);
                setExportBtnEvent();
        }

        void setExportBtnEvent() {
                exportPdfBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                if (importBooks.size() == 0) {
                                        JOptionPane.showMessageDialog(exportPdfBtn, "Import list is empty");
                                } else {
                                        exportPDF();
                                }
                        }
                });
                exportExcelBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                if (importBooks.size() == 0) {
                                        JOptionPane.showMessageDialog(exportExcelBtn, "Import list is empty");
                                        return;
                                } else {
                                        exportExcel();
                                }
                        }
                });
        }

        void setRemoveBtnEven() {
                removeBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                int[] rows = importBookListTable.getSelectedRows();

                                for (int row : rows) {
                                        String id = (String) importBookListTable.getValueAt(row, 0);

                                        importListBookModel.removeRow(row);

                                        for (BookModel book : importBooks) {
                                                if (book.getId().equals(id)) {
                                                        importBooks.remove(book);
                                                        break;
                                                }
                                        }

                                        disabledRows.remove(id);
                                }

                                importBookListTable.repaint();
                                bookListTable.repaint();
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTable bookListTable;
        private javax.swing.JPanel bookListTableZone;
        private javax.swing.JButton filterButton;
        private javax.swing.JTable importBookListTable;
        private javax.swing.JPanel importBtnZone;
        private javax.swing.JPanel infoZone;
        private javax.swing.JButton removeBtn;
        private javax.swing.JButton exportPdfBtn;
        private javax.swing.JButton exportExcelBtn;
        private javax.swing.JButton removeAllBtn;
        private javax.swing.JButton importBtn;
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
        private SheetDao sheetDao;
        private SheetService sheetService;
        private SheetDetailDao sheetDetailDao;
        private SheetDetailService sheetDetailService;
        private List<BookModel> books;
        private List<BookModel> importBooks = new ArrayList<BookModel>();
        private Map<String, Integer> disabledRows = new HashMap<>();

        // End of variables declaration//GEN-END:variables
}
