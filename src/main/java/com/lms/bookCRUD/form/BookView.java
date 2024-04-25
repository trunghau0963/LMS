package com.lms.bookCRUD.form;

import javax.swing.*;

import com.lms.bookCRUD.form.other.AddBook;
import com.lms.bookCRUD.form.other.EditBook;
import com.lms.bookCRUD.form.other.ListBooks;
import com.lms.bookCRUD.service.BookService;
import com.lms.bookCRUD.dal.AuthorDao;
import com.lms.bookCRUD.dal.BookAuthorDao;
import com.lms.bookCRUD.dal.BookCategoryDao;
import com.lms.bookCRUD.dal.BookDao;
import com.lms.bookCRUD.dal.CategoryDao;
import com.lms.bookCRUD.dal.PublisherDao;
import com.lms.bookCRUD.form.BookView;
import com.lms.bookCRUD.repo.AuthorRepo;
import com.lms.bookCRUD.repo.BookAuthorRepo;
import com.lms.bookCRUD.repo.BookCategoryRepo;
import com.lms.bookCRUD.repo.BookRepo;
import com.lms.bookCRUD.repo.CategoryRepo;
import com.lms.bookCRUD.repo.PublisherRepo;
import java.awt.*;

public class BookView extends JPanel {
  private static CardLayout cardLayout;
  AddBook addBook;
  static EditBook editBook;
  static ListBooks listBook;
  private BookDao bookDao;
  private AuthorDao authorDao;
  private CategoryDao categoryDao;
  private PublisherDao publisherDao;
  private BookAuthorDao bookAuthorDao;
  private BookCategoryDao bookCategoryDao;
  private BookService bookService;

  public BookView() {
    super();

    cardLayout = new CardLayout();
    setLayout(cardLayout);

    bookDao = new BookRepo();
    authorDao = new AuthorRepo();
    categoryDao = new CategoryRepo();
    publisherDao = new PublisherRepo();
    bookAuthorDao = new BookAuthorRepo();
    bookCategoryDao = new BookCategoryRepo();
    bookService = new BookService(bookDao, authorDao, categoryDao, publisherDao, bookAuthorDao,
            bookCategoryDao);

    addBook = new AddBook(cardLayout, this);
    editBook = new EditBook(cardLayout, this);
    listBook = new ListBooks(cardLayout, this, bookService);

    add(addBook, "addBook");
    add(editBook, "editBook");
    add(listBook, "listBook");

    cardLayout.show(this, "listBook");

  }

  public static void loadEditBookPanel(String bookId) {
    editBook.setBookId(bookId);
    editBook.loadBook();
    cardLayout.show(editBook.getParent(), "editBook");
  }

  // public static void reloadListBookTable() {
  //   listBook.reloadTable();
  // }

}