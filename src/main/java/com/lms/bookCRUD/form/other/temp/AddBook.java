/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lms.bookCRUD.form.other.temp;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Label;
import java.util.List;

import com.lms.bookCRUD.dal.*;
import com.lms.bookCRUD.entities.Author;
import com.lms.bookCRUD.entities.Category;
import com.lms.bookCRUD.entities.Publisher;
import com.lms.bookCRUD.form.BookView;
import com.lms.bookCRUD.model.*;
import com.lms.bookCRUD.repo.*;
import com.lms.bookCRUD.service.*;
import com.lms.bookCRUD.ui.ImageAvatar;

/**
 *
 * @author nttha
 */
public class AddBook extends javax.swing.JPanel {

    private BookDao bookDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;
    private PublisherDao publisherDao;
    private BookAuthorDao bookAuthorDao;
    private BookCategoryDao bookCategoryDao;
    private JList<CategoryModel> jList1;
    private JList<AuthorModel> jList2;
    private BookService bookService;
    private CardLayout cardLayout;
    private JPanel parentPanel;

    public AddBook(CardLayout cardLayout, JPanel parentPanel) {
        this.cardLayout = cardLayout;
        this.parentPanel = parentPanel;
        initComponents();
        jList1 = new JList<>();
        jList2 = new JList<>();
        bookDao = new BookRepo();
        authorDao = new AuthorRepo();
        categoryDao = new CategoryRepo();
        publisherDao = new PublisherRepo();
        bookAuthorDao = new BookAuthorRepo();
        bookCategoryDao = new BookCategoryRepo();
        bookService = new BookService(bookDao, authorDao, categoryDao, publisherDao, bookAuthorDao,
                bookCategoryDao);

        loadAuthorList();
        loadCategoryList();
        loadPublisherComboBox();
    }

    public void loadAuthorList() {
        List<Author> authors = authorDao.findAll();
        DefaultListModel<AuthorModel> authorListModel = new DefaultListModel<>();
        for (Author author : authors) {
            AuthorModel authorModel = new AuthorModel();
            authorModel.loadFromEntity(author);
            authorListModel.addElement(authorModel);
        }
        jList2.setModel(authorListModel);
    }

    public void loadCategoryList() {
        List<Category> categories = categoryDao.findAll();
        DefaultListModel<CategoryModel> categoryListModel = new DefaultListModel<>();
        for (Category category : categories) {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.loadFromEntity(category);
            categoryListModel.addElement(categoryModel);
        }
        jList1.setModel(categoryListModel);
    }

    public void loadPublisherComboBox() {
        List<Publisher> publishers = publisherDao.findAll();
        DefaultComboBoxModel<PublisherModel> publisherComboBoxModel = new DefaultComboBoxModel<>();
        for (Publisher publisher : publishers) {
            PublisherModel publisherModel = new PublisherModel();
            publisherModel.loadFromEntity(publisher);
            publisherComboBoxModel.addElement(publisherModel);
        }
        publishingChoose.setModel(publisherComboBoxModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        imageAvatar1 = new com.lms.UserCRUD.ui.ImageAvatar();
        jPanel13 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        titleTxT = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        editionTxT = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        publishingChoose = new javax.swing.JComboBox<>();
        jPanel21 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        categoryTxt = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        statusChoose = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        authorTxT = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        returnBtn = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 40));
        jPanel3.setPreferredSize(new java.awt.Dimension(678, 60));

        jPanel18.setPreferredSize(new java.awt.Dimension(313, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Add New Book");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 58, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel18);

        add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 40));
        jPanel12.setPreferredSize(new java.awt.Dimension(800, 400));

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        jPanel19.setPreferredSize(new java.awt.Dimension(700, 80));

        imageAvatar1.setToolTipText("Upload");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel19);

        jPanel13.setPreferredSize(new java.awt.Dimension(700, 80));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jPanel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 20, 1));
        jPanel17.setPreferredSize(new java.awt.Dimension(350, 80));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setPreferredSize(new java.awt.Dimension(350, 22));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Title");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel9)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        jPanel17.add(jPanel2);
        jPanel17.add(titleTxT);

        jPanel13.add(jPanel17);

        jPanel26.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 20, 1));
        jPanel26.setPreferredSize(new java.awt.Dimension(350, 80));
        jPanel26.setLayout(new javax.swing.BoxLayout(jPanel26, javax.swing.BoxLayout.Y_AXIS));

        jPanel8.setPreferredSize(new java.awt.Dimension(350, 22));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Edition");
        jLabel8.setPreferredSize(new java.awt.Dimension(52, 12));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel26.add(jPanel8);
        jPanel26.add(editionTxT);

        jPanel13.add(jPanel26);

        jPanel1.add(jPanel13);

        jPanel22.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 20, 1));
        jPanel22.setPreferredSize(new java.awt.Dimension(700, 80));
        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.LINE_AXIS));

        jPanel20.setPreferredSize(new java.awt.Dimension(350, 60));
        jPanel20.setLayout(new javax.swing.BoxLayout(jPanel20, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setPreferredSize(new java.awt.Dimension(346, 16));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Publishing Company");
        jLabel6.setPreferredSize(new java.awt.Dimension(350, 16));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel4);

        publishingChoose.setPreferredSize(new java.awt.Dimension(72, 40));
        jPanel20.add(publishingChoose);

        jPanel22.add(jPanel20);

        jPanel21.setPreferredSize(new java.awt.Dimension(350, 60));
        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setPreferredSize(new java.awt.Dimension(397, 22));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Category");
        jLabel10.setPreferredSize(new java.awt.Dimension(350, 16));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
        );

        jPanel21.add(jPanel5);
        jPanel21.add(categoryTxt);

        jPanel22.add(jPanel21);

        jPanel1.add(jPanel22);

        jPanel23.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 20, 1));
        jPanel23.setPreferredSize(new java.awt.Dimension(700, 80));
        jPanel23.setLayout(new javax.swing.BoxLayout(jPanel23, javax.swing.BoxLayout.LINE_AXIS));

        jPanel25.setPreferredSize(new java.awt.Dimension(350, 60));
        jPanel25.setLayout(new javax.swing.BoxLayout(jPanel25, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setPreferredSize(new java.awt.Dimension(346, 16));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Is Hide");
        jLabel11.setPreferredSize(new java.awt.Dimension(350, 16));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.add(jPanel7);

        statusChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show", "Hide" }));
        statusChoose.setSelectedIndex(-1);
        statusChoose.setPreferredSize(new java.awt.Dimension(72, 40));
        jPanel25.add(statusChoose);

        jPanel23.add(jPanel25);

        jPanel24.setPreferredSize(new java.awt.Dimension(350, 60));
        jPanel24.setLayout(new javax.swing.BoxLayout(jPanel24, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setPreferredSize(new java.awt.Dimension(346, 22));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Author");
        jLabel7.setPreferredSize(new java.awt.Dimension(350, 16));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jPanel24.add(jPanel6);
        jPanel24.add(authorTxT);

        jPanel23.add(jPanel24);

        jPanel1.add(jPanel23);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        returnBtn.setForeground(new java.awt.Color(255, 153, 0));
        returnBtn.setText("Back");
        returnBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 4, true));
        returnBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });
        jPanel10.add(returnBtn);

        jPanel9.add(jPanel10);

        saveButton.setBackground(new java.awt.Color(255, 153, 0));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
        saveButton.setPreferredSize(new java.awt.Dimension(150, 40));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel11.add(saveButton);

        jPanel9.add(jPanel11);

        jPanel1.add(jPanel9);

        jPanel12.add(jPanel1);

        add(jPanel12, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void editionTxTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editionTxTActionPerformed
        // char c = evt.getKeyChar();
        // if (Character.isLetter(c)) {
        //     editionTxT.setEditable(false);
        // } else {
        //     editionTxT.setEditable(true);
        // }
    }// GEN-LAST:event_editionTxTActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_returnButtonActionPerformed
        cardLayout.show(parentPanel,"listBook");
    }// GEN-LAST:event_returnButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveButton1ActionPerformed
        String title = titleTxT.getText();
        Integer edition = Integer.parseInt(editionTxT.getText());
        List<AuthorModel> authors = jList2.getSelectedValuesList();
        List<CategoryModel> categories = jList1.getSelectedValuesList();
        int selectedIndex2 = publishingChoose.getSelectedIndex();
        PublisherModel publisher = publishingChoose.getItemAt(selectedIndex2);
        Boolean isHide = statusChoose.getSelectedItem().toString() == "Hide" ? true : false;
        if (authors.size() == 0 || categories.size() == 0 || title.isEmpty() || publisher == null) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
            return;
        }

        BookModel book = new BookModel();
        book.setTitle(title);
        book.setEdition(edition);
        book.setAuthors(authors);
        book.setCategories(categories);
        book.setIsHide(isHide);
        book.setPublisher(publisher);

        boolean isAdded = bookService.addNewBook(book);
        if (!isAdded) {
            JOptionPane.showMessageDialog(this, "Failed to add book");
            return;
        }
        // BookView.reloadListBookTable();
        JOptionPane.showMessageDialog(this, "Book added successfully");
        cardLayout.show(parentPanel, "listBook");
        refresh();

    }// GEN-LAST:event_saveButton1ActionPerformed

    private void refresh() {
        titleTxT.setText("");
        editionTxT.setText("");
        jList1.clearSelection();
        jList2.clearSelection();
        statusChoose.setSelectedIndex(0);
        publishingChoose.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorTxT;
    private javax.swing.JTextField categoryTxt;
    private javax.swing.JTextField editionTxT;
    private com.lms.UserCRUD.ui.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox<PublisherModel> publishingChoose;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> statusChoose;
    private javax.swing.JTextField titleTxT;
    // End of variables declaration//GEN-END:variables
}
