package com.lms.exportCRUD.form;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.lms.exportCRUD.dal.AuthorDao;
import com.lms.exportCRUD.dal.BookAuthorDao;
import com.lms.exportCRUD.dal.BookCategoryDao;
import com.lms.exportCRUD.dal.BookDao;
import com.lms.exportCRUD.dal.CategoryDao;
import com.lms.exportCRUD.dal.PublisherDao;
import com.lms.exportCRUD.repo.AuthorRepo;
import com.lms.exportCRUD.repo.BookAuthorRepo;
import com.lms.exportCRUD.repo.BookCategoryRepo;
import com.lms.exportCRUD.repo.BookRepo;
import com.lms.exportCRUD.repo.CategoryRepo;
import com.lms.exportCRUD.repo.PublisherRepo;
import com.lms.exportCRUD.service.BookService;
import com.lms.exportCRUD.form.other.exportPanel;

import com.lms.exportCRUD.service.InvoiceService;
import com.lms.exportCRUD.service.InvoiceDetailService;



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
