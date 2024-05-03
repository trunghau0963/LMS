package com.lms.sheetCRUD.form;

import java.awt.CardLayout;
import java.util.List;

import com.lms.sheetCRUD.dal.BookDao;
import com.lms.sheetCRUD.dal.SheetDao;
import com.lms.sheetCRUD.dal.SheetDetailDao;
import com.lms.sheetCRUD.repo.AuthorRepo;
import com.lms.sheetCRUD.repo.BookAuthorRepo;
import com.lms.sheetCRUD.repo.BookCategoryRepo;
import com.lms.sheetCRUD.repo.BookRepo;
import com.lms.sheetCRUD.repo.CategoryRepo;
import com.lms.sheetCRUD.repo.PublisherRepo;
import com.lms.sheetCRUD.repo.SheetDetailRepo;
import com.lms.sheetCRUD.repo.SheetRepo;
import com.lms.sheetCRUD.service.BookService;
import com.lms.sheetCRUD.service.SheetDetailService;
import com.lms.sheetCRUD.service.SheetService;
import com.lms.sheetCRUD.form.other.sheetList;

public class sheetView extends javax.swing.JPanel {
    private CardLayout cardLayout;
    public static sheetList sheetList;

    private BookService bookService;
    private BookDao bookDao;
    private SheetDao sheetDao;
    private SheetService sheetService;
    private SheetDetailDao sheetDetailDao;
    private SheetDetailService sheetDetailService;

    public sheetView() {

        super();

        bookDao = new BookRepo();
        bookService = new BookService(bookDao, new AuthorRepo(), new CategoryRepo(), new PublisherRepo(),
                new BookAuthorRepo(), new BookCategoryRepo());

        // sheet
        sheetDao = new SheetRepo();
        sheetService = new SheetService(sheetDao);

        // sheet detail
        sheetDetailDao = new SheetDetailRepo();
        sheetDetailService = new SheetDetailService(sheetDetailDao);

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        sheetList = new sheetList(bookService, sheetService, sheetDetailService);
        add(sheetList, "sheetList");
        cardLayout.show(this, "sheetList");
    }
}
