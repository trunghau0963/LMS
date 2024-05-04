/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.lms.exportCRUD.form.other;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
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

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.lms.auth.entities.User;
import com.lms.exportCRUD.entities.ExportBook;
import com.lms.exportCRUD.entities.Member;
import com.lms.exportCRUD.model.BookModel;
import com.lms.exportCRUD.model.MemberModel;
import com.lms.exportCRUD.service.BookService;
import com.lms.exportCRUD.service.InvoiceDetailService;
import com.lms.exportCRUD.service.InvoiceService;
import com.lms.exportCRUD.service.MemberService;
import com.lms.exportCRUD.ui.CenterTableCellRenderer;

/**
 *
 * @author nttha
 */
public class ExportPanel extends javax.swing.JInternalFrame {

        private String exportFormat = "";
        public List<BookModel> bookAlready = new ArrayList<>();
        private BookService bookService;
        private InvoiceService invoiceService;
        private InvoiceDetailService invoiceDetailService;
        private MemberService memberService;
        private User user;

        public ExportPanel(BookService bookService, InvoiceService invoiceService,
                        InvoiceDetailService invoiceDetailService, MemberService memberService, User user) {
                this.user = user;
                this.invoiceDetailService = invoiceDetailService;
                this.invoiceService = invoiceService;
                this.bookService = bookService;
                this.memberService = memberService;
                initComponents();
                ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
                UIManager.put("Table.showVerticalLines", true);
                bookList.setDefaultEditor(Object.class, null);
                bookList1.setDefaultEditor(Object.class, null);
                init();

        }

        private void init() {
                idEmployee.setText(user.getId());
                nameEmployee.setText(user.getName());
                ArrayList<Member> members = memberService.getAllMembers();
                DefaultComboBoxModel<MemberModel> model = new DefaultComboBoxModel<MemberModel>();
                for (Member member : members) {
                        MemberModel memberModel = new MemberModel();
                        memberModel.loadFromEntity(member);
                        model.addElement(memberModel);
                }
                MemberModel nullModel = new MemberModel();
                nullModel.setId("");
                nullModel.setname("Null");
                model.addElement(nullModel);

                listMember.setModel(model);

                List<BookModel> bookModels = bookService.getAvailableBooks();
                DefaultTableModel tblModel = (DefaultTableModel) bookList.getModel();
                reloadTable(tblModel, bookModels);

                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(bookList.getModel());
                bookList.setRowSorter(sorter);

                DefaultTableModel tblModel1 = new DefaultTableModel();

                customTable(bookList1);
                // Set column names for the table model
                tblModel1.setColumnIdentifiers(new Object[] { "Title",
                                "Edition", "Sale Price", "Quantity" });

                bookList1.setModel(tblModel1);

                searchOption.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Any", "Title", "Category", "Author", "Publisher" }));

                bookList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() == 2) {
                                        int selectedRow = bookList.getSelectedRow();
                                        if (selectedRow != -1) {
                                                String inputValue = JOptionPane
                                                                .showInputDialog("Enter the number of books:");
                                                int numberOfBooks = Integer.parseInt(inputValue);
                                                int quantity = (int) bookList.getValueAt(selectedRow, 8);
                                                if (numberOfBooks > quantity) {
                                                        JOptionPane.showMessageDialog(null,
                                                                        "The number of books is greater than the quantity of books in stock",
                                                                        "Error", JOptionPane.ERROR_MESSAGE);
                                                } else {
                                                        JOptionPane.showMessageDialog(null, "Add to list successfully",
                                                                        "Success", JOptionPane.INFORMATION_MESSAGE);
                                                        BookModel bookModel = new BookModel();
                                                        bookModel.setId((String) bookList.getValueAt(selectedRow, 1));
                                                        bookModel.setTitle(
                                                                        (String) bookList.getValueAt(selectedRow, 2));
                                                        bookModel.setEdition((int) bookList.getValueAt(selectedRow, 3));
                                                        bookModel.setSalePrice(
                                                                        (float) bookList.getValueAt(selectedRow, 7));
                                                        bookModel.setQuantity((int) numberOfBooks);

                                                        bookAlready.add(bookModel);

                                                        // Create a new DefaultTableModel
                                                        DefaultTableModel tblModel = new DefaultTableModel();

                                                        customTable(bookList1);
                                                        // Set column names for the table model
                                                        tblModel.setColumnIdentifiers(new Object[] { "Title",
                                                                        "Edition", "Sale Price", "Quantity" });

                                                        // Populate the table model with data from bookAlready
                                                        float totalPrice = 0;
                                                        for (BookModel book : bookAlready) {
                                                                tblModel.addRow(new Object[] {
                                                                                book.getTitle(),
                                                                                book.getEdition(),
                                                                                book.getSalePrice(),
                                                                                book.getQuantity()
                                                                });
                                                                totalPrice += book.getSalePrice() * book.getQuantity();
                                                        }

                                                        bookList1.setModel(tblModel);
                                                        totalNumber.setText(String.valueOf(totalPrice) + "đ");
                                                }

                                        }
                                }
                        }
                });
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
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel9 = new javax.swing.JPanel();
                jPanel11 = new javax.swing.JPanel();
                jPanel3 = new javax.swing.JPanel();
                jPanel4 = new javax.swing.JPanel();
                jPanel14 = new javax.swing.JPanel();
                filterButton = new javax.swing.JButton();
                searchOption = new javax.swing.JComboBox<>();
                jPanel15 = new javax.swing.JPanel();
                searchField = new javax.swing.JTextField();
                jPanel16 = new javax.swing.JPanel();
                refreshButton = new javax.swing.JButton();
                jPanel6 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                bookList = new javax.swing.JTable();
                jPanel19 = new javax.swing.JPanel();
                jPanel24 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                totalNumber = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                jPanel22 = new javax.swing.JPanel();
                infoZone1 = new javax.swing.JPanel();
                jPanel30 = new javax.swing.JPanel();
                jPanel31 = new javax.swing.JPanel();
                jLabel12 = new javax.swing.JLabel();
                nameEmployee = new javax.swing.JTextField();
                jPanel25 = new javax.swing.JPanel();
                jPanel26 = new javax.swing.JPanel();
                jLabel11 = new javax.swing.JLabel();
                idEmployee = new javax.swing.JTextField();
                jPanel32 = new javax.swing.JPanel();
                jPanel33 = new javax.swing.JPanel();
                jLabel13 = new javax.swing.JLabel();
                listMember = new javax.swing.JComboBox<>();
                jPanel5 = new javax.swing.JPanel();
                jScrollPane3 = new javax.swing.JScrollPane();
                bookList1 = new javax.swing.JTable();
                jPanel13 = new javax.swing.JPanel();
                jPanel28 = new javax.swing.JPanel();
                jPanel21 = new javax.swing.JPanel();
                jButton8 = new javax.swing.JButton();
                jPanel20 = new javax.swing.JPanel();
                jButton9 = new javax.swing.JButton();
                jPanel27 = new javax.swing.JPanel();
                jPanel29 = new javax.swing.JPanel();
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

                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Export Book",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
                jPanel3.setPreferredSize(new java.awt.Dimension(400, 200));
                jPanel3.setLayout(new java.awt.BorderLayout());

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
                searchField.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                searchFieldKeyReleased(evt);
                        }
                });

                javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
                jPanel15.setLayout(jPanel15Layout);
                jPanel15Layout.setHorizontalGroup(
                                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel15Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(searchField,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                227, Short.MAX_VALUE)
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

                jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

                jPanel11.add(jPanel3);

                jPanel9.add(jPanel11);

                jPanel1.add(jPanel9, java.awt.BorderLayout.NORTH);

                jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
                jPanel6.setPreferredSize(new java.awt.Dimension(800, 400));
                jPanel6.setLayout(new java.awt.BorderLayout());

                jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

                bookList.setRowHeight(30);
                bookList.setShowGrid(true);
                jScrollPane2.setViewportView(bookList);

                jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

                jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

                jPanel19.setPreferredSize(new java.awt.Dimension(657, 80));
                jPanel19.setLayout(new javax.swing.BoxLayout(jPanel19, javax.swing.BoxLayout.LINE_AXIS));

                jPanel24.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
                jPanel24.setPreferredSize(new java.awt.Dimension(300, 117));
                jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                jLabel1.setText("Total");
                jPanel24.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, -1));

                totalNumber.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                totalNumber.setForeground(new java.awt.Color(255, 51, 51));
                totalNumber.setText("0đ");
                jPanel24.add(totalNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 340, 30));

                jPanel19.add(jPanel24);

                jPanel1.add(jPanel19, java.awt.BorderLayout.PAGE_END);

                getContentPane().add(jPanel1);

                jPanel2.setPreferredSize(new java.awt.Dimension(200, 517));
                jPanel2.setLayout(new java.awt.BorderLayout());

                jPanel22.setPreferredSize(new java.awt.Dimension(150, 180));
                jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.LINE_AXIS));

                infoZone1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
                infoZone1.setPreferredSize(new java.awt.Dimension(700, 200));
                infoZone1.setLayout(new javax.swing.BoxLayout(infoZone1, javax.swing.BoxLayout.Y_AXIS));

                jPanel30.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
                jPanel30.setPreferredSize(new java.awt.Dimension(700, 60));
                jPanel30.setLayout(new javax.swing.BoxLayout(jPanel30, javax.swing.BoxLayout.Y_AXIS));

                jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel12.setText("Name Employee");

                javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
                jPanel31.setLayout(jPanel31Layout);
                jPanel31Layout.setHorizontalGroup(
                                jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 241, Short.MAX_VALUE)
                                                .addGroup(jPanel31Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel12,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                241, Short.MAX_VALUE)));
                jPanel31Layout.setVerticalGroup(
                                jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(jPanel31Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel31Layout.createSequentialGroup()
                                                                                .addComponent(jLabel12)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));

                jPanel30.add(jPanel31);

                nameEmployee.setPreferredSize(new java.awt.Dimension(60, 22));
                jPanel30.add(nameEmployee);

                infoZone1.add(jPanel30);

                jPanel25.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
                jPanel25.setPreferredSize(new java.awt.Dimension(700, 60));
                jPanel25.setLayout(new javax.swing.BoxLayout(jPanel25, javax.swing.BoxLayout.Y_AXIS));

                jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel11.setText("ID Employee");

                javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
                jPanel26.setLayout(jPanel26Layout);
                jPanel26Layout.setHorizontalGroup(
                                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 241, Short.MAX_VALUE)
                                                .addGroup(jPanel26Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel11,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                241, Short.MAX_VALUE)));
                jPanel26Layout.setVerticalGroup(
                                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(jPanel26Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel26Layout.createSequentialGroup()
                                                                                .addComponent(jLabel11)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));

                jPanel25.add(jPanel26);

                idEmployee.setPreferredSize(new java.awt.Dimension(60, 22));
                jPanel25.add(idEmployee);

                infoZone1.add(jPanel25);

                jPanel32.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
                jPanel32.setPreferredSize(new java.awt.Dimension(700, 60));
                jPanel32.setLayout(new javax.swing.BoxLayout(jPanel32, javax.swing.BoxLayout.Y_AXIS));

                jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel13.setText("Member");

                javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
                jPanel33.setLayout(jPanel33Layout);
                jPanel33Layout.setHorizontalGroup(
                                jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 241, Short.MAX_VALUE)
                                                .addGroup(jPanel33Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel13,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                241, Short.MAX_VALUE)));
                jPanel33Layout.setVerticalGroup(
                                jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(jPanel33Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel33Layout.createSequentialGroup()
                                                                                .addComponent(jLabel13)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));

                jPanel32.add(jPanel33);

                listMember.setPreferredSize(new java.awt.Dimension(72, 40));
                listMember.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                listMemberActionPerformed(evt);
                        }
                });
                jPanel32.add(listMember);

                infoZone1.add(jPanel32);

                jPanel22.add(infoZone1);

                jPanel2.add(jPanel22, java.awt.BorderLayout.PAGE_START);

                jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                jPanel5.setLayout(new java.awt.BorderLayout());

                jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));

                bookList1.setRowHeight(30);
                bookList1.setShowGrid(true);
                jScrollPane3.setViewportView(bookList1);

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

                javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
                jPanel21.setLayout(jPanel21Layout);
                jPanel21Layout.setHorizontalGroup(
                                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 253, Short.MAX_VALUE)
                                                .addGroup(jPanel21Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel21Layout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(jButton8,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                241, Short.MAX_VALUE)
                                                                                .addContainerGap())));
                jPanel21Layout.setVerticalGroup(
                                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 52, Short.MAX_VALUE)
                                                .addGroup(jPanel21Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                jPanel21Layout.createSequentialGroup()
                                                                                                .addContainerGap(7,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButton8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                37,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(8,
                                                                                                                Short.MAX_VALUE))));

                jPanel28.add(jPanel21);

                jButton9.setText("Export List Book");
                jButton9.setPreferredSize(new java.awt.Dimension(80, 40));
                jButton9.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton9ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
                jPanel20.setLayout(jPanel20Layout);
                jPanel20Layout.setHorizontalGroup(
                                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 253, Short.MAX_VALUE)
                                                .addGroup(jPanel20Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel20Layout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(jButton9,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                241, Short.MAX_VALUE)
                                                                                .addContainerGap())));
                jPanel20Layout.setVerticalGroup(
                                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 67, Short.MAX_VALUE)
                                                .addGroup(jPanel20Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                jPanel20Layout.createSequentialGroup()
                                                                                                .addContainerGap(15,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButton9,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                37,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(15,
                                                                                                                Short.MAX_VALUE))));

                jPanel28.add(jPanel20);

                jPanel13.add(jPanel28);

                jPanel2.add(jPanel13, java.awt.BorderLayout.PAGE_END);

                jPanel27.setLayout(new java.awt.BorderLayout());

                jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jButton2.setText("Remove");
                jButton2.setPreferredSize(new java.awt.Dimension(80, 40));
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });
                jPanel29.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

                jButton3.setText("Pdf");
                jButton3.setPreferredSize(new java.awt.Dimension(80, 40));
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });
                jPanel29.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

                jButton4.setText("Excel");
                jButton4.setPreferredSize(new java.awt.Dimension(80, 40));
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton4ActionPerformed(evt);
                        }
                });
                jPanel29.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

                jPanel27.add(jPanel29, java.awt.BorderLayout.CENTER);

                jPanel2.add(jPanel27, java.awt.BorderLayout.LINE_END);

                getContentPane().add(jPanel2);

                pack();
        }// </editor-fold>//GEN-END:initComponents

        public void reloadTable(DefaultTableModel tblModel, List<BookModel> bookModels) {
                CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
                int idx = 0;
                customTable(bookList);

                tblModel.setRowCount(0);
                tblModel.addColumn("No.");
                tblModel.addColumn("ID");
                tblModel.addColumn("Title");
                tblModel.addColumn("Edition");
                tblModel.addColumn("Categories");
                tblModel.addColumn("Authors");
                tblModel.addColumn("Publisher");
                tblModel.addColumn("Sale Price");
                tblModel.addColumn("Quantity");

                for (BookModel bookModel : bookModels) {
                        tblModel.addRow(new Object[] { ++idx, bookModel.getId(), bookModel.getTitle(),
                                        bookModel.getEdition(),
                                        bookModel.getCategoriesString(),
                                        bookModel.getAuthorsString(), bookModel.getPublisher().toString(),
                                        bookModel.getSalePrice(), bookModel.getQuantity()
                        });
                }

                for (int columnIndex = 0; columnIndex < bookList.getColumnCount(); columnIndex++) {
                        bookList.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
                }

                bookList.setModel(tblModel);
        }

        private void customTable(javax.swing.JTable table) {
                table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
                table.getTableHeader().setBackground(new Color(125, 200, 204));
                table.getTableHeader().setForeground(new Color(0, 0, 0));
                table.setRowHeight(30);
                table.setShowGrid(true);

        }

        public void loadDataToTable(List<BookModel> bookModels) {
                try {
                        DefaultTableModel tblModel = (DefaultTableModel) bookList.getModel();
                        int idx = 0;
                        tblModel.setRowCount(0);
                        for (BookModel bookModel : bookModels) {
                                tblModel.addRow(new Object[] { ++idx, bookModel.getId(), bookModel.getTitle(),
                                                bookModel.getEdition(),
                                                bookModel.getCategoriesString(),
                                                bookModel.getAuthorsString(), bookModel.getPublisher().toString(),
                                                bookModel.getSalePrice(), bookModel.getQuantity()
                                });
                        }
                } catch (Exception e) {
                        // TODO: handle exception
                }
        }

        public void getSelectBookAlready() {
                int row = bookList1.getSelectedRow();
                if (row != -1) {
                        bookAlready.remove(row);
                        JOptionPane.showMessageDialog(null, "Remove successfully", "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                        DefaultTableModel tblModel = new DefaultTableModel();
                        tblModel.setColumnIdentifiers(new Object[] { "Title", "Edition", "Sale Price",
                                        "Quantity" });
                        float totalPrice = 0;
                        // for (BookModel book : bookAlready) {
                        // tblModel.addRow(new Object[] { book.getId(), book.getTitle(),
                        // book.getEdition(),
                        // book.getSalePrice(), book.getQuantity() });
                        // totalPrice += book.getSalePrice() * book.getQuantity();
                        // }
                        String selectedMember = listMember.getSelectedItem().toString();
                        if (selectedMember.equals("Null")) {
                                for (BookModel book : bookAlready) {
                                        totalPrice += book.getSalePrice() * book.getQuantity();
                                }
                                totalNumber.setText(String.valueOf(totalPrice) + "đ");
                        } else {
                                for (BookModel book : bookAlready) {
                                        totalPrice += book.getSalePrice() * book.getQuantity();
                                }
                                totalNumber.setText(String.valueOf(totalPrice * 0.95) + "đ");
                        }
                        bookList1.setModel(tblModel);
                        // totalNumber.setText(String.valueOf(totalPrice) + "đ");
                }
        }

        protected void searchFieldKeyReleased(KeyEvent evt) {
                String choose = (String) searchOption.getSelectedItem();
                String searchContent = searchField.getText();
                List<BookModel> result = new ArrayList<>();
                String tab = "Available";
                switch (choose) {
                        case "Any":
                                result = bookService.searchByAny(searchContent, tab);
                                break;
                        case "Title":
                                result = bookService.searchByTitle(searchContent, tab);
                                break;
                        case "Category":
                                result = bookService.searchByCategory(searchContent, tab);
                                break;
                        case "Publisher":
                                result = bookService.searchByPublisher(searchContent, tab);
                                break;
                        case "Author":
                                result = bookService.searchByAuthor(searchContent, tab);
                                break;
                }
                loadDataToTable(result);
        }

        private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_refreshButtonActionPerformed

        private void listMemberActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_listMemberActionPerformed
                String selectedMember = listMember.getSelectedItem().toString();
                if (selectedMember.equals("Null")) {
                        float totalPrice = 0;
                        for (BookModel book : bookAlready) {
                                totalPrice += book.getSalePrice() * book.getQuantity();
                        }
                        totalNumber.setText(String.valueOf(totalPrice) + "đ");
                } else {
                        float totalPrice = 0;
                        for (BookModel book : bookAlready) {
                                totalPrice += book.getSalePrice() * book.getQuantity();
                        }
                        totalNumber.setText(String.valueOf(totalPrice * 0.95) + "đ");
                }
        }// GEN-LAST:event_listMemberActionPerformed

        private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_searchOptionActionPerformed

        private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_filterButtonActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                getSelectBookAlready();

        }// GEN-LAST:event_jButton2ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
                exportFormat = "PDF";
        }

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
                exportFormat = "Excel";
        }

        private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
                bookAlready.clear();
                JOptionPane.showMessageDialog(null, "Remove all successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                DefaultTableModel tblModel = new DefaultTableModel();
                tblModel.setColumnIdentifiers(new Object[] { "Title", "Edition", "Sale Price", "Quantity" });
                bookList1.setModel(tblModel);
                totalNumber.setText("0đ");

        }// GEN-LAST:event_jButton8ActionPerformed

        private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
                for (BookModel book : bookAlready) {
                        bookService.updateQuantity(book.getId(), book.getQuantity());
                        
                }
                boolean result = false;
                if (exportFormat.equals("Excel")) {
                        result = exportExcel();
                } else if (exportFormat.equals("PDF")) {
                        result = exportPDF();
                } else {
                        JOptionPane.showMessageDialog(null, "Please select the export format", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                }
                if (!result) {
                        return;
                }

                List<ExportBook> exportBooks = new ArrayList<>();
                for (BookModel book : bookAlready) {
                        ExportBook exportBook = new ExportBook();
                        exportBook.setId(book.getId());
                        exportBook.setQuantity(book.getQuantity());
                        exportBook.setExportPrice(book.getSalePrice() * book.getQuantity());
                        exportBooks.add(exportBook);
                }

                String invoiceId = invoiceService.createInvoice("0997fa53eef44c07", "0f253955123c5568",
                                new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                invoiceDetailService.insertIntoInvoice(invoiceId, exportBooks);

                JOptionPane.showMessageDialog(null, "Export successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                bookAlready.clear();
                DefaultTableModel tblModel = new DefaultTableModel();
                tblModel.setColumnIdentifiers(new Object[] { "Title", "Edition", "Sale Price", "Quantity" });
                bookList1.setModel(tblModel);
                totalNumber.setText("0đ");

                
                loadDataToTable(bookService.getAvailableBooks());
                

                exportFormat = "";

        }// GEN-LAST:event_jButton9ActionPerformed

        private boolean exportExcel() {
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
                                titleCell.setCellValue("EXPORT BOOK");
                                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, bookList1.getColumnCount() - 1));
                                titleCell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);
                                titleCell.getCellStyle().setFont(createHeaderFont(workbook));

                                // Create name of member row
                                XSSFRow memberRow = sheet.createRow(1);
                                XSSFCell memberCell = memberRow.createCell(0);
                                memberCell.setCellValue("Member: " + listMember.getSelectedItem().toString());
                                sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, bookList1.getColumnCount() - 1));
                                memberCell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);

                                // Create date and time row
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                                String formattedDateTime = LocalDateTime.now().format(formatter);
                                XSSFRow dateTimeRow = sheet.createRow(2);
                                XSSFCell dateTimeCell = dateTimeRow.createCell(0);
                                dateTimeCell.setCellValue("Export Date and Time: " + formattedDateTime);
                                // Corrected merged region for the "Export Date and Time" row
                                sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, bookList1.getColumnCount() - 1));
                                dateTimeCell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);

                                // Create header row
                                XSSFRow headerRow = sheet.createRow(3);
                                for (int i = 0; i < bookList1.getColumnCount(); i++) {
                                        XSSFCell headerCell = headerRow.createCell(i);
                                        headerCell.setCellValue(bookList1.getColumnName(i));
                                        headerCell.getCellStyle().setFont(createHeaderFont(workbook));
                                }

                                // Populate data rows
                                for (int i = 0; i < bookList1.getRowCount(); i++) {
                                        XSSFRow dataRow = sheet.createRow(i + 3);
                                        for (int j = 0; j < bookList1.getColumnCount(); j++) {
                                                XSSFCell dataCell = dataRow.createCell(j);
                                                if (bookList1.getValueAt(i, j) != null) {
                                                        dataCell.setCellValue(bookList1.getValueAt(i, j).toString());
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
                                return true;
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return false;
        }

        private XSSFFont createHeaderFont(XSSFWorkbook workbook) {
                XSSFFont font = workbook.createFont();
                font.setFontHeightInPoints((short) 14);
                font.setBold(true);
                font.setColor(IndexedColors.BLACK.getIndex());
                return font;
        }

        public void openFile(String file) {
                try {
                        File myFile = new File(file);
                        Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                        // no application registered for PDFs
                        JOptionPane.showMessageDialog(this, "No application registered for PDFs");
                }
        }

        private boolean exportPDF() {
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
                                Paragraph title = new Paragraph("EXPORT BOOK")
                                                .setFont(titleFont)
                                                .setFontSize(20)
                                                .setTextAlignment(TextAlignment.CENTER);
                                document.add(title);

                                // Set member name
                                Paragraph member = new Paragraph("Member: " + listMember.getSelectedItem().toString())
                                                .setTextAlignment(TextAlignment.CENTER);
                                document.add(member);

                                // Set export date and time
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                                String formattedDateTime = LocalDateTime.now().format(formatter);
                                Paragraph dateTime = new Paragraph("Export Date and Time: " + formattedDateTime)
                                                .setTextAlignment(TextAlignment.CENTER);
                                document.add(dateTime);

                                // Add table
                                Table table = new Table(bookList1.getColumnCount());
                                for (int i = 0; i < bookList1.getColumnCount(); i++) {
                                        Cell cell = new Cell().add(new Paragraph(bookList1.getColumnName(i)));
                                        cell.setBackgroundColor(new DeviceRgb(125, 200, 204));

                                        table.addCell(cell);
                                }
                                for (int i = 0; i < bookList1.getRowCount(); i++) {
                                        for (int j = 0; j < bookList1.getColumnCount(); j++) {
                                                if (bookList1.getValueAt(i, j) != null) {
                                                        table.addCell(bookList1.getValueAt(i, j).toString());
                                                } else {
                                                        table.addCell("");
                                                }
                                        }
                                }

                                document.add(table);

                                // Add total price
                                Paragraph totalPrice = new Paragraph("Total Price: " + totalNumber.getText() + "d")
                                                .setTextAlignment(TextAlignment.RIGHT);
                                document.add(totalPrice);

                                document.close();

                                openFile(file.toString());
                                return true;

                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return false;
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTable bookList;
        private javax.swing.JTable bookList1;
        private javax.swing.JButton filterButton;
        private javax.swing.JTextField idEmployee;
        private javax.swing.JPanel infoZone1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JButton jButton8;
        private javax.swing.JButton jButton9;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel11;
        private javax.swing.JPanel jPanel13;
        private javax.swing.JPanel jPanel14;
        private javax.swing.JPanel jPanel15;
        private javax.swing.JPanel jPanel16;
        private javax.swing.JPanel jPanel19;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel20;
        private javax.swing.JPanel jPanel21;
        private javax.swing.JPanel jPanel22;
        private javax.swing.JPanel jPanel24;
        private javax.swing.JPanel jPanel25;
        private javax.swing.JPanel jPanel26;
        private javax.swing.JPanel jPanel27;
        private javax.swing.JPanel jPanel28;
        private javax.swing.JPanel jPanel29;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel30;
        private javax.swing.JPanel jPanel31;
        private javax.swing.JPanel jPanel32;
        private javax.swing.JPanel jPanel33;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel9;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JComboBox<MemberModel> listMember;
        private javax.swing.JTextField nameEmployee;
        private javax.swing.JButton refreshButton;
        private javax.swing.JTextField searchField;
        private javax.swing.JComboBox<String> searchOption;
        private javax.swing.JLabel totalNumber;
        // End of variables declaration//GEN-END:variables
}
