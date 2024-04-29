/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lms.bookCRUD.form.other.temp;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.lms.bookCRUD.dal.*;
import com.lms.bookCRUD.entities.Author;
import com.lms.bookCRUD.entities.Category;
import com.lms.bookCRUD.entities.Publisher;
import com.lms.bookCRUD.form.BookView;
import com.lms.bookCRUD.model.*;
import com.lms.bookCRUD.repo.*;
import com.lms.bookCRUD.service.*;
import com.lms.bookCRUD.ui.ImageAvatar;

import java.awt.CardLayout;
import java.awt.Label;
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
        private BookModel book;
        private String bookId;

        public EditBook(CardLayout cardLayout, JPanel parentPanel) {
                this.cardLayout = cardLayout;
                this.parentPanel = parentPanel;
                initComponents();
                bookId = null;
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
                book = bookService.getBookDetails(bookId);
                jTextField3.setText(book.getTitle());
                jTextField4.setText(book.getEdition().toString());

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

        @SuppressWarnings("unchecked")

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                label1 = new java.awt.Label();
                imageAvatar1 = new com.lms.bookCRUD.ui.ImageAvatar();
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
                jLabel2 = new javax.swing.JLabel();
                jTextField4 = new javax.swing.JTextField();
                setSize(new java.awt.Dimension(800, 540));

                label1.setAlignment(java.awt.Label.CENTER);
                label1.setFont(new java.awt.Font("Dialog", 1, 24));
                label1.setText("Edit a Book");

                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new PublisherModel[] {}));
                jComboBox2.setPreferredSize(new java.awt.Dimension(323, 36));
                jComboBox2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox2ActionPerformed(evt);
                        }
                });

                jTextField3.setPreferredSize(new java.awt.Dimension(259, 36));
                jTextField3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField3ActionPerformed(evt);
                        }
                });

                jButton2.setBackground(new java.awt.Color(255, 112, 8));
                jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18));
                jButton2.setForeground(new java.awt.Color(255, 255, 255));
                jButton2.setLabel("Save");
                jButton2.setPreferredSize(new java.awt.Dimension(92, 28));
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18));
                jButton3.setForeground(new java.awt.Color(255, 112, 8));
                jButton3.setText("Cancel");
                jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 112, 8)));
                jButton3.setPreferredSize(new java.awt.Dimension(92, 28));
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });
                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13));
                jLabel1.setText("Title");

                jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Show", "Hide" }));
                jComboBox4.setPreferredSize(new java.awt.Dimension(116, 36));

                jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13));
                jLabel3.setText("Publishing Company");

                jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13));
                jLabel4.setText("Author");

                jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13));
                jLabel5.setText("Category");

                jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13));
                jLabel6.setText("Show/Hide");

                jScrollPane1.setViewportView(jList1);

                jScrollPane2.setViewportView(jList2);
                jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13));
                jLabel2.setText("Edition");

                jTextField4.setPreferredSize(new java.awt.Dimension(159, 36));
                jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                jTextField4KeyPressed(evt);
                        }
                });
                javax.swing.GroupLayout borderPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(borderPanel1Layout);
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
                                                                                                                                                                                .addGap(323)
                                                                                                                                                                                .addComponent(jLabel2)
                                                                                                                                                                                .addGap(110))

                                                                                                                                                                .addGroup(borderPanel1Layout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(jTextField3,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                314,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addGap(33, 33, 33)
                                                                                                                                                                                .addComponent(jTextField4))
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
                                                                                .addComponent(jLabel1)
                                                                                .addGap(12, 12, 12)
                                                                                .addComponent(jLabel2))
                                                                .addGap(7, 7, 7)
                                                                .addGroup(borderPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jTextField3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField4,
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
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        }

        private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {
                // check if the input is a number
                char c = evt.getKeyChar();
                if (Character.isLetter(c)) {
                        jTextField4.setEditable(false);
                } else {
                        jTextField4.setEditable(true);
                }

        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
                String title = jTextField3.getText();
                Integer edition = Integer.parseInt(jTextField4.getText());
                List<AuthorModel> authors = jList2.getSelectedValuesList();
                List<CategoryModel> categories = jList1.getSelectedValuesList();
                int selectedIndex2 = jComboBox2.getSelectedIndex();
                PublisherModel publisher = jComboBox2.getItemAt(selectedIndex2);
                Boolean isHide = jComboBox4.getSelectedItem().toString() == "Hide" ? true : false;
                if (authors.size() == 0 || categories.size() == 0 || title.isEmpty() || publisher == null) {
                        JOptionPane.showMessageDialog(this, "Please fill all the fields");
                        return;
                }

                book.setId(bookId);
                book.setTitle(title);
                book.setEdition(edition);
                book.setAuthors(authors);
                book.setCategories(categories);
                book.setIsHide(isHide);
                book.setPublisher(publisher);

                boolean isUpdated = bookService.editBook(book);
                if (!isUpdated) {
                        JOptionPane.showMessageDialog(this, "Failed to edit book");
                        return;
                }
                // BookView.reloadListBookTable();

                JOptionPane.showMessageDialog(this, "Book edited successfully");

                cardLayout.show(parentPanel, "listBook");

        }

        private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {

        }

        private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {

        }

        private void editButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        }

        private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {

        }

        private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {

        }

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(parentPanel, "listBook");
        }

        private JPanel jPanel1;
        private ImageAvatar imageAvatar1;
        private JButton jButton2;
        private JButton jButton3;
        private JComboBox<PublisherModel> jComboBox2;
        private JComboBox<String> jComboBox4;
        private JLabel jLabel1;
        private JLabel jLabel2;
        private JLabel jLabel3;
        private JLabel jLabel4;
        private JLabel jLabel5;
        private JLabel jLabel6;
        private JList<CategoryModel> jList1;
        private JList<AuthorModel> jList2;
        private JScrollPane jScrollPane1;
        private JScrollPane jScrollPane2;
        private JTextField jTextField3;
        private JTextField jTextField4;
        private Label label1;
        CardLayout cardLayout;
        JPanel parentPanel;
}
