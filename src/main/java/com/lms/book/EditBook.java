/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lms.book;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.lms.book.dal.AuthorDao;
import com.lms.book.dal.BookAuthorDao;
import com.lms.book.dal.BookCategoryDao;
import com.lms.book.dal.BookDao;
import com.lms.book.dal.CategoryDao;
import com.lms.book.dal.PublisherDao;
import com.lms.book.entities.Author;
import com.lms.book.entities.Category;
import com.lms.book.entities.Publisher;
import com.lms.book.repo.AuthorRepo;
import com.lms.book.repo.BookAuthorRepo;
import com.lms.book.repo.BookCategoryRepo;
import com.lms.book.repo.BookRepo;
import com.lms.book.repo.CategoryRepo;
import com.lms.book.repo.PublisherRepo;
import com.lms.book.service.BookService;
import com.lms.book.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PCM
 */
public class EditBook extends javax.swing.JPanel {
        private BookDao bookDao;
        private AuthorDao authorDao;
        private CategoryDao categoryDao;
        private PublisherDao publisherDao;
        private BookAuthorDao bookAuthorDao;
        private BookCategoryDao bookCategoryDao;
        private BookService bookService;
        private String bookId;

        /**
         * Creates new form BookList
         */
        public EditBook() {
                initComponents();
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

        public void setBookId(String bookId) {
                this.bookId = bookId;
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
                jComboBox2.setModel(publisherComboBoxModel);
        }

        public void loadBook() {
                BookModel book = bookService.getBookDetails(bookId);
                jTextField3.setText(book.getTitle());

                DefaultListModel jList2Model = (DefaultListModel) jList2.getModel();
                List<Integer> selectedIndex2 = new ArrayList<>();
                for (AuthorModel author : book.getAuthors()) {
                        for (int i = 0; i < jList2Model.getSize(); i++) {
                                AuthorModel authorModel = (AuthorModel) jList2Model.getElementAt(i);
                                if (authorModel.getId().equals(author.getId())) {
                                        selectedIndex2.add(i);
                                }
                        }
                }

                int[] selectedIndices = selectedIndex2.stream().mapToInt(i -> i).toArray();
                jList2.setSelectedIndices(selectedIndices);

                DefaultListModel jList1Model = (DefaultListModel) jList1.getModel();
                List<Integer> selectedIndex1 = new ArrayList<>();
                for (CategoryModel category : book.getCategories()) {
                        for (int i = 0; i < jList1Model.getSize(); i++) {
                                CategoryModel categoryModel = (CategoryModel) jList1Model.getElementAt(i);
                                if (categoryModel.getId().equals(category.getId())) {
                                        selectedIndex1.add(i);
                                }
                        }
                }

                int[] selectedIndices1 = selectedIndex1.stream().mapToInt(i -> i).toArray();
                jList1.setSelectedIndices(selectedIndices1);

                DefaultComboBoxModel jComboBox2Model = (DefaultComboBoxModel) jComboBox2.getModel();
                for (int i = 0; i < jComboBox2Model.getSize(); i++) {
                        PublisherModel publisherModel = (PublisherModel) jComboBox2Model.getElementAt(i);
                        if (publisherModel.getId().equals(book.getPublisher().getId())) {
                                jComboBox2.setSelectedIndex(i);
                        }
                }
                jComboBox4.setSelectedIndex(book.getIsHide() ? 1 : 0);

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

                spinnerUI1 = new com.lms.custom.SpinnerUI();
                borderPanel1 = new com.lms.custom.BorderPanel();
                label1 = new java.awt.Label();
                imageAvatar1 = new com.lms.custom.ImageAvatar();
                jComboBox2 = new javax.swing.JComboBox<>();
                jTextField3 = new javax.swing.JTextField();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();
                jComboBox4 = new javax.swing.JComboBox<>();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jList1 = new javax.swing.JList<>();
                jScrollPane2 = new javax.swing.JScrollPane();
                jList2 = new javax.swing.JList<>();

                setSize(new java.awt.Dimension(900, 600));

                label1.setAlignment(java.awt.Label.CENTER);
                label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
                label1.setText("Edit a Book");

                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new PublisherModel[] {}));
                jComboBox2.setPreferredSize(new java.awt.Dimension(323, 36));
                jComboBox2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox2ActionPerformed(evt);
                        }
                });

                jTextField3.setToolTipText("");
                jTextField3.setName(""); // NOI18N
                jTextField3.setPreferredSize(new java.awt.Dimension(259, 36));
                jTextField3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField3ActionPerformed(evt);
                        }
                });

                jButton2.setBackground(new java.awt.Color(255, 112, 8));
                jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jButton2.setForeground(new java.awt.Color(255, 255, 255));
                jButton2.setLabel("Save");
                jButton2.setPreferredSize(new java.awt.Dimension(92, 28));
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jButton3.setForeground(new java.awt.Color(255, 112, 8));
                jButton3.setText("Cancel");
                jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 112, 8)));
                jButton3.setPreferredSize(new java.awt.Dimension(92, 28));
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });
                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
                jLabel1.setText("Title");

                jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Show", "Hide" }));
                jComboBox4.setPreferredSize(new java.awt.Dimension(116, 36));
                jComboBox4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox4ActionPerformed(evt);
                        }
                });

                jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
                jLabel3.setText("Publishing Company");

                jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
                jLabel4.setText("Author");

                jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
                jLabel5.setText("Category");

                jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
                jLabel6.setText("Show/Hide");

                jScrollPane1.setViewportView(jList1);

                jScrollPane2.setViewportView(jList2);

                javax.swing.GroupLayout borderPanel1Layout = new javax.swing.GroupLayout(borderPanel1);
                borderPanel1.setLayout(borderPanel1Layout);
                borderPanel1Layout.setHorizontalGroup(
                                borderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGroup(borderPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                borderPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(265, 265,
                                                                                                                                265)
                                                                                                                .addComponent(jButton3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(20, 20, 20)
                                                                                                                .addComponent(jButton2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                borderPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(127, 127,
                                                                                                                                127)
                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addComponent(jLabel4,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                57,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(jScrollPane2,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                170,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addGap(154, 154,
                                                                                                                                                                154)
                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(jLabel5,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                57,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                                                                                                .addComponent(jScrollPane1,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                0,
                                                                                                                                                                                Short.MAX_VALUE)))
                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(jLabel3)
                                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(jComboBox2,
                                                                                                                                                                                                0,
                                                                                                                                                                                                0,
                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                .addGap(95, 95, 95)))
                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                false)
                                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(jLabel6)
                                                                                                                                                                                .addGap(57, 57, 57))
                                                                                                                                                                .addComponent(jComboBox4,
                                                                                                                                                                                0,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)))
                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(jLabel1)
                                                                                                                                                                                .addGap(433, 433,
                                                                                                                                                                                                433))
                                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(jTextField3,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                314,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addGap(33, 33, 33))
                                                                                                                                                                .addComponent(label1,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                447,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                                .addGap(106, 106, 106))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(imageAvatar1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                118,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(276, 276, 276)));
                borderPanel1Layout.setVerticalGroup(
                                borderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(34, Short.MAX_VALUE)
                                                                .addComponent(label1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(imageAvatar1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                118,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(borderPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1))
                                                                .addGap(7, 7, 7)
                                                                .addGroup(borderPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jTextField3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(14, 14, 14)
                                                                .addGroup(borderPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel4,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel5))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(borderPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jScrollPane2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                75,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                75,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(borderPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(borderPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel3)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jComboBox2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(borderPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel6)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jComboBox4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(60, 60, 60)
                                                                .addGroup(borderPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jButton3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(68, 68, 68)));

                jButton3.getAccessibleContext().setAccessibleDescription("");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 204, Short.MAX_VALUE)
                                                                .addComponent(borderPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(borderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        }// </editor-fold>//GEN-END:initComponents

        private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox4ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jComboBox4ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox4ActionPerformed
                String title = jTextField3.getText();
                List<AuthorModel> authors = jList2.getSelectedValuesList();
                List<CategoryModel> categories = jList1.getSelectedValuesList();
                int selectedIndex2 = jComboBox2.getSelectedIndex();
                PublisherModel publisher = jComboBox2.getItemAt(selectedIndex2);
                Boolean isHide = jComboBox4.getSelectedItem().toString() == "Hide" ? true : false;
                if (authors.size() == 0 || categories.size() == 0 || title.isEmpty() || publisher == null) {
                        JOptionPane.showMessageDialog(this, "Please fill all the fields");
                        return;
                }
                
                BookModel book = new BookModel();
                book.setId(bookId);
                book.setTitle(title);
                book.setAuthors(authors);
                book.setCategories(categories);
                book.setIsHide(isHide);
                book.setPublisher(publisher);

                bookService.editBook(book);

                BookJFrame.listBook.updateBook(book);

                JOptionPane.showMessageDialog(this, "Book edited successfully");
                
                BookJFrame.showListBook();

        }

        private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField3ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jTextField3ActionPerformed

        private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox2ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jComboBox2ActionPerformed

        private void editButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editButton1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_editButton1ActionPerformed

        private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textField1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_textField1ActionPerformed

        private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jComboBox1ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
                // TODO add your handling code here:
                this.setVisible(false);
                BookJFrame.showListBook();
        }// GEN-LAST:event_jButton3ActionPerformed

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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(EditBook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(EditBook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(EditBook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(EditBook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>
                // </editor-fold>
                // </editor-fold>
                // </editor-fold>
                // </editor-fold>
                // </editor-fold>
                // </editor-fold>
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new EditBook().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables

        private com.lms.custom.BorderPanel borderPanel1;
        private com.lms.custom.ImageAvatar imageAvatar1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JComboBox<PublisherModel> jComboBox2;
        private javax.swing.JComboBox<String> jComboBox4;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JList<CategoryModel> jList1;
        private javax.swing.JList<AuthorModel> jList2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTextField jTextField3;
        private java.awt.Label label1;
        private com.lms.custom.SpinnerUI spinnerUI1;
        // End of variables declaration//GEN-END:variables

}
