package com.lms.bookCRUD.form.other;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.lms.authorCRUD.dal.AuthorDao;
import com.lms.authorCRUD.entities.Author;
import com.lms.authorCRUD.repo.AuthorRepo;
import com.lms.bookCRUD.model.AuthorModel;
import com.lms.bookCRUD.model.BookModel;
import com.lms.bookCRUD.model.CategoryModel;
import com.lms.bookCRUD.model.PublisherModel;
import com.lms.bookCRUD.service.BookService;
import com.lms.bookCRUD.ui.CenterTableCellRenderer;
import com.lms.bookCRUD.ui.ToggleEditor;
import com.lms.bookCRUD.ui.ToggleRenderer;
import com.lms.categoryCRUD.dal.CategoryDao;
import com.lms.categoryCRUD.entities.Category;
import com.lms.categoryCRUD.repo.CategoryRepo;
import com.lms.publisherCRUD.dal.PublisherDao;
import com.lms.publisherCRUD.entities.Publisher;
import com.lms.publisherCRUD.repo.PublisherRepo;

public class AllBook extends javax.swing.JInternalFrame {

    private BookService bookService;
    private CategoryDao categoryDao;
    private AuthorDao authorDao;
    private PublisherDao publisherDao;

    public AllBook(BookService bookService) {
        this.bookService = bookService;
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        UIManager.put("Table.showVerticalLines", true);
        initComponents();
        init();
    }

    private void init() {
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        refreshButton.setIcon(new FlatSVGIcon("svg/search.svg"));
        filterButton.setIcon(new FlatSVGIcon("svg/filter.svg"));
        btnAdd.setIcon(new FlatSVGIcon("svg/add.svg"));
        btnDelete.setIcon(new FlatSVGIcon("svg/delete.svg"));
        btnEdit.setIcon(new FlatSVGIcon("svg/edit.svg"));
        btnExport.setIcon(new FlatSVGIcon("svg/export.svg"));
        btnImport.setIcon(new FlatSVGIcon("svg/import.svg"));
        refreshButton.setIcon(new FlatSVGIcon("svg/refresh.svg"));

        categoryDao = new CategoryRepo();
        authorDao = new AuthorRepo();
        publisherDao = new PublisherRepo();

        List<BookModel> bookModels = bookService.getAllBooks();
        DefaultTableModel tblModel = (DefaultTableModel) bookList.getModel();
        reloadTable(tblModel, bookModels);

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(bookList.getModel());
        bookList.setRowSorter(sorter);
        searchOption.setModel(
                new javax.swing.DefaultComboBoxModel<>(
                        new String[] { "Any", "Title", "Category", "Author", "Publisher" }));

    }

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
        tblModel.addColumn("Visibility");
        for (BookModel bookModel : bookModels) {
            tblModel.addRow(new Object[] { ++idx, bookModel.getId(), bookModel.getTitle(), bookModel.getEdition(),
                    bookModel.getCategoriesString(),
                    bookModel.getAuthorsString(), bookModel.getPublisher().toString(),
                    bookModel.getSalePrice(), bookModel.getQuantity(),
                    bookModel.getIsHide() });
        }

        for (int columnIndex = 0; columnIndex < bookList.getColumnCount(); columnIndex++) {
            bookList.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        bookList.setModel(tblModel);
        bookList.getColumnModel().getColumn(9).setCellRenderer(new ToggleRenderer());
        bookList.getColumnModel().getColumn(9).setCellEditor(new ToggleEditor(bookService, bookList));

        bookList.setColumnSelectionAllowed(true);
    }

    public void loadDataToTable(List<BookModel> bookModels) {
        try {
            DefaultTableModel tblModel = (DefaultTableModel) bookList.getModel();
            int idx = 0;
            tblModel.setRowCount(0);
            for (BookModel bookModel : bookModels) {
                tblModel.addRow(new Object[] { ++idx, bookModel.getId(), bookModel.getTitle(), bookModel.getEdition(),
                        bookModel.getCategoriesString(),
                        bookModel.getAuthorsString(), bookModel.getPublisher().toString(),
                        bookModel.getSalePrice(), bookModel.getQuantity(), bookModel.getIsHide() });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void customTable(javax.swing.JTable table) {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));
        table.setRowHeight(30);
        table.setShowGrid(true);
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        filterButton = new javax.swing.JButton();
        searchOption = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookList = new javax.swing.JTable();

        setBorder(null);

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 1, 40));
        jPanel11.setMinimumSize(new java.awt.Dimension(392, 80));
        jPanel11.setPreferredSize(new java.awt.Dimension(800, 120));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Book",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(150, 40));

        filterButton.setPreferredSize(new java.awt.Dimension(40, 40));
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });
        jPanel14.add(filterButton);

        searchOption.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        searchOption.setPreferredSize(new java.awt.Dimension(100, 40));
        searchOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOptionActionPerformed(evt);
            }
        });
        jPanel14.add(searchOption);

        jPanel1.add(jPanel14, java.awt.BorderLayout.WEST);

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
                                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addGap(8, 8, 8)));
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel1.add(jPanel15, java.awt.BorderLayout.CENTER);

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

        jPanel1.add(jPanel16, java.awt.BorderLayout.EAST);

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel3);

        jToolBar2.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));
        jToolBar2.setRollover(true);

        btnAdd.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAdd);

        btnDelete.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDelete);

        btnEdit.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEdit);
        jToolBar2.add(jSeparator1);

        btnImport.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnImport.setText("Import Excel");
        btnImport.setFocusable(false);
        btnImport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        jToolBar2.add(btnImport);

        btnExport.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnExport.setText("Export Excel");
        btnExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jToolBar2.add(btnExport);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 350, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel5Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 119, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel5Layout.createSequentialGroup()
                                                .addGap(0, 9, Short.MAX_VALUE)
                                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))));

        jPanel11.add(jPanel5);

        jPanel9.add(jPanel11);

        getContentPane().add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 40, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        bookList.setRowHeight(30);
        bookList.setShowGrid(true);
        jScrollPane2.setViewportView(bookList);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    protected void searchFieldKeyReleased(KeyEvent evt) {
        String choose = (String) searchOption.getSelectedItem();
        String searchContent = searchField.getText();
        List<BookModel> result = new ArrayList<>();
        String tab = "All";
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

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterButtonActionPerformed
        FilterDialog a = new FilterDialog(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this),
                rootPaneCheckingEnabled);
        a.setVisible(true);
    }// GEN-LAST:event_filterButtonActionPerformed

    private void searchOptionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchOptionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_searchOptionActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonActionPerformed
        loadDataToTable(bookService.getAllBooks());
    }// GEN-LAST:event_refreshButtonActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        AddNewBook a;
        a = new AddNewBook(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled,
                bookService);
        a.setVisible(true);
    }// GEN-LAST:event_btnAddActionPerformed

    public String getSelectBookId() {
        int row = bookList.getSelectedRow();
        if (row == -1) {
            return null;
        }
        return bookList.getValueAt(row, 1).toString();
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        if (bookList.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "please select the book to delete !");
        } else {
            String bookId = getSelectBookId();
            System.out.println("deleted book id: " + bookId);
            int checkSure = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this book ?",
                    "Verify delete this book", JOptionPane.YES_NO_OPTION);
            if (checkSure == JOptionPane.YES_OPTION) {
                if (bookService.deleteBookById(bookId)) {
                    JOptionPane.showMessageDialog(this, "Delete Succesfull !");
                    loadDataToTable(bookService.getAllBooks());
                } else {
                    JOptionPane.showMessageDialog(this, "Delete failed !");
                }
            }
        }
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditEActionPerformed
        if (bookList.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select an book to edit");
            return;
        } else {
            EditBook a = new EditBook(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this),
                    rootPaneCheckingEnabled, "All Book", bookService);
            a.setVisible(true);
        }
    }// GEN-LAST:event_btnEditEActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnImportEActionPerformed
        importExcel();
    }// GEN-LAST:event_btnImportEActionPerformed

    private void importExcel() {
        File file;
        JFileChooser chooser = new JFileChooser();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        XSSFWorkbook workbook = null;
        ArrayList<BookModel> importList = new ArrayList<BookModel>();
        chooser.setDialogTitle("Import Excel File");
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                workbook = new XSSFWorkbook(bis);
                XSSFSheet sheet = workbook.getSheetAt(0);
                System.out.println("Row count: " + sheet.getLastRowNum());
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    XSSFRow row = sheet.getRow(i);
                    BookModel importBook = new BookModel();
                    importBook.setTitle(row.getCell(0).getStringCellValue());
                    importBook.setEdition((int) row.getCell(1).getNumericCellValue());

                    // Check if book already exists
                    List<BookModel> sameTitleBooks = bookService.getBookByTitle(title);
                    if (!sameTitleBooks.isEmpty()) {
                        for (BookModel book : sameTitleBooks) {
                            if (book.getEdition() == importBook.getEdition()) {
                                JOptionPane.showMessageDialog(this, "Import failed ! the book " + importBook.getTitle()
                                        + " already exists in the system");
                                return;
                            }
                        }
                    }

                    String[] categoriesArray = row.getCell(2).getStringCellValue().split(",");
                    List<String> categoriesList = Arrays.asList(categoriesArray);
                    for (String category : categoriesList) {
                        Category categoryE = categoryDao.findByName(category);
                        if (categoryE == null) {
                            categoryDao.add(category);
                            categoryE = categoryDao.findByName(category);
                        }
                        CategoryModel categoryModel = new CategoryModel();
                        categoryModel.setId(categoryE.getId());
                        categoryModel.setGenre(categoryE.getGenre());
                        importBook.addCategory(categoryModel);
                    }
                    String[] authorsArray = row.getCell(3).getStringCellValue().split(",");
                    List<String> authorsList = Arrays.asList(authorsArray);
                    for (String author : authorsList) {
                        Author authorE = authorDao.findByName(author);
                        if (authorE == null) {
                            authorDao.addAuthor(author, null, "false");
                            authorE = authorDao.findByName(author);
                        }
                        AuthorModel authorModel = new AuthorModel();
                        authorModel.setId(authorE.getAuthorId());
                        authorModel.setName(authorE.getAuthorName());
                        importBook.addAuthor(authorModel);
                    }

                    Publisher publisher = publisherDao.findByName(row.getCell(4).getStringCellValue());
                    if (publisher == null) {
                        publisherDao.addPublisher(row.getCell(4).getStringCellValue(), null, "false");
                        publisher = publisherDao.findByName(row.getCell(4).getStringCellValue());
                    }
                    PublisherModel publisherModel = new PublisherModel();
                    publisherModel.setId(publisher.getPublisherId());
                    publisherModel.setName(publisher.getPublisherName());
                    importBook.setPublisher(publisherModel);
                    importBook.setSalePrice((float) (row.getCell(5).getNumericCellValue() * 1.1));
                    importBook.setQuantity((int) row.getCell(6).getNumericCellValue());
                    importBook.setIsHide(false);
                    importList.add(importBook);
                }
                for (BookModel book : importList) {
                    Boolean isAdded = bookService.addNewBook(book);
                    if (!isAdded) {
                        JOptionPane.showMessageDialog(this, "Import failed !");
                        return;
                    }
                }
                loadDataToTable(bookService.getAllBooks());
                JOptionPane.showMessageDialog(this, "Import successful !");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Import failed !");
                Logger.getLogger(AllBook.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Import failed !");
                Logger.getLogger(AllBook.class.getName()).log(Level.SEVERE, null, ex);
            }

            finally {
                try {
                    if (workbook != null)
                        workbook.close();
                    if (bis != null)
                        bis.close();
                    if (fis != null)
                        fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExportEActionPerformed
        exportExcel();
    }// GEN-LAST:event_btnExportEActionPerformed

    private void exportExcel() {
        JFileChooser chooser = new JFileChooser();
        try {
            chooser.showSaveDialog(this);
            File file = chooser.getSelectedFile();
            if (file != null) {
                file = new File(file.toString() + ".xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Admins");
                XSSFRow row;
                row = sheet.createRow(0);

                for (int i = 0; i < bookList.getColumnCount(); i++) {
                    row.createCell(i).setCellValue(bookList.getColumnName(i));
                }
                for (int i = 0; i < bookList.getRowCount(); i++) {
                    row = sheet.createRow(i + 1);
                    for (int j = 0; j < bookList.getColumnCount(); j++) {
                        if (bookList.getValueAt(i, j) != null) {
                            row.createCell(j).setCellValue(bookList.getValueAt(i, j).toString());
                        }
                    }
                }
                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
                workbook.close();
                openFile(file.toString());
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
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

    private void filterBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterBookButtonActionPerformed
        int w = 250, h = 300;
        // if(filterArea.getPreferredSize().width < w){
        // System.out.println(filterArea.getPreferredSize().width);
        // openFilterMenu(w, h);
        // } else {
        // System.out.println(filterArea.getPreferredSize().width);
        // closeFilterMenu(w, h);
        // }
    }// GEN-LAST:event_filterBookButtonActionPerformed

    // private void openFilterMenu(int w, int h){
    // new Thread(new Runnable() {
    // @Override
    // public void run() {
    // for (int i = 0; i <= w; i += 10) {
    // filterArea.setPreferredSize(new java.awt.Dimension(w, h));
    // filterArea.revalidate();
    // filterArea.repaint();
    // try {
    // Thread.sleep(1);
    // } catch (InterruptedException ex) {
    // ex.printStackTrace();
    // }
    // }
    // }
    // }).start();
    // }

    // private void closeFilterMenu(int w, int h){
    // new Thread(new Runnable(){
    // @Override
    // public void run(){
    // for (int i = w; i >= 0; i -= 10){
    // filterArea.setPreferredSize(new java.awt.Dimension(0, h));
    // filterArea.revalidate();
    // filterArea.repaint();
    // try {
    // Thread.sleep(1);
    // } catch (InterruptedException ex) {
    // ex.printStackTrace();
    // }
    // }
    // }
    // }).start();
    // }

    private void filterSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_filterSearchActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_filterSearchActionPerformed

    private void searchBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchBookButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_searchBookButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookList;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton filterButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchOption;
    // End of variables declaration//GEN-END:variables
}
