package com.lms.exportCRUD.form;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.lms.bookCRUD.dal.AuthorDao;
import com.lms.bookCRUD.dal.BookAuthorDao;
import com.lms.bookCRUD.dal.BookCategoryDao;
import com.lms.bookCRUD.dal.BookDao;
import com.lms.bookCRUD.dal.CategoryDao;
import com.lms.bookCRUD.dal.PublisherDao;
import com.lms.bookCRUD.repo.AuthorRepo;
import com.lms.bookCRUD.repo.BookAuthorRepo;
import com.lms.bookCRUD.repo.BookCategoryRepo;
import com.lms.bookCRUD.repo.BookRepo;
import com.lms.bookCRUD.repo.CategoryRepo;
import com.lms.bookCRUD.repo.PublisherRepo;
import com.lms.bookCRUD.service.BookService;
import com.lms.exportCRUD.form.other.exportPanel;

public class ExportView extends JPanel {
    exportPanel exportPanel;
    private CardLayout cardLayout;
    private BookDao bookDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;
    private PublisherDao publisherDao;
    private BookAuthorDao bookAuthorDao;
    private BookCategoryDao bookCategoryDao;
    private BookService bookService;

    public ExportView() {
        super();
        bookDao = new BookRepo();
        authorDao = new AuthorRepo();
        categoryDao = new CategoryRepo();
        publisherDao = new PublisherRepo();
        bookAuthorDao = new BookAuthorRepo();
        bookCategoryDao = new BookCategoryRepo();
        bookService = new BookService(bookDao, authorDao, categoryDao, publisherDao, bookAuthorDao,
                bookCategoryDao);

        exportPanel = new exportPanel(bookService);
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(exportPanel, "exportPanel");

        cardLayout.show(this, "exportPanel");

    }
}
