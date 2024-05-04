package com.lms.exportCRUD.form;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.lms.auth.entities.Member;
import com.lms.auth.entities.User;
import com.lms.exportCRUD.dal.AuthorDao;
import com.lms.exportCRUD.dal.BookAuthorDao;
import com.lms.exportCRUD.dal.BookCategoryDao;
import com.lms.exportCRUD.dal.BookDao;
import com.lms.exportCRUD.dal.CategoryDao;
import com.lms.exportCRUD.dal.InvoiceDao;
import com.lms.exportCRUD.dal.InvoiceDetailDao;
import com.lms.exportCRUD.dal.MemberDao;
import com.lms.exportCRUD.dal.PublisherDao;
import com.lms.exportCRUD.repo.AuthorRepo;
import com.lms.exportCRUD.repo.BookAuthorRepo;
import com.lms.exportCRUD.repo.BookCategoryRepo;
import com.lms.exportCRUD.repo.BookRepo;
import com.lms.exportCRUD.repo.CategoryRepo;
import com.lms.exportCRUD.repo.InvoiceDetailRepo;
import com.lms.exportCRUD.repo.InvoiceRepo;
import com.lms.exportCRUD.repo.MemberRepo;
import com.lms.exportCRUD.repo.PublisherRepo;
import com.lms.exportCRUD.service.BookService;
import com.lms.exportCRUD.form.other.ExportPanel;

import com.lms.exportCRUD.service.InvoiceService;
import com.lms.exportCRUD.service.MemberService;
import com.lms.exportCRUD.service.InvoiceDetailService;

public class ExportView extends JPanel {
    private ExportPanel exportPanel;
    private CardLayout cardLayout;
    private BookDao bookDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;
    private PublisherDao publisherDao;
    private BookAuthorDao bookAuthorDao;
    private BookCategoryDao bookCategoryDao;
    private BookService bookService;
    private InvoiceService invoiceService;
    private InvoiceDetailService invoiceDetailService;
    private InvoiceDao invoiceDao;
    private InvoiceDetailDao invoiceDetailDao;
    private MemberDao memberDao;
    private MemberService memberService;
    private User user;

    public ExportView(User userPUser) {
        super();
        bookDao = new BookRepo();
        authorDao = new AuthorRepo();
        categoryDao = new CategoryRepo();
        publisherDao = new PublisherRepo();
        bookAuthorDao = new BookAuthorRepo();
        bookCategoryDao = new BookCategoryRepo();
        bookService = new BookService(bookDao, authorDao, categoryDao, publisherDao, bookAuthorDao,
                bookCategoryDao);

        invoiceDao = new InvoiceRepo();
        invoiceDetailDao = new InvoiceDetailRepo();

        invoiceService = new InvoiceService(invoiceDao);
        invoiceDetailService = new InvoiceDetailService(invoiceDetailDao);

        memberDao = new MemberRepo();
        memberService = new MemberService(memberDao);

        this.user = userPUser;

        System.out.println("ExportView: " + user.toString());

        exportPanel = new ExportPanel(bookService, invoiceService, invoiceDetailService, memberService, user);
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        this.add(exportPanel, "exportPanel");

        cardLayout.show(this, "exportPanel");

    }

    public void setUserInformation(User user) {
        this.user = user;
        System.out.println("User: " + user.toString());
    }
}
