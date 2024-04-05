package com.lms.book.service;

import java.util.ArrayList;
import java.util.List;

import com.lms.book.dal.*;
import com.lms.book.model.*;
import com.lms.book.entities.*;

public class BookService {
    private BookDao bookDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;
    private PublisherDao publisherDao;
    private BookAuthorDao bookAuthorDao;
    private BookCategoryDao bookCategoryDao;

    public BookService(BookDao bookDao, AuthorDao authorDao, CategoryDao categoryDao, PublisherDao publisherDao,
            BookAuthorDao bookAuthorDao, BookCategoryDao bookCategoryDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.publisherDao = publisherDao;
        this.bookAuthorDao = bookAuthorDao;
        this.bookCategoryDao = bookCategoryDao;
    }

    public List<BookModel> getAllBooks() {
        List<Book> books = bookDao.findAll();
        List<BookModel> bookModels = new ArrayList<>();

        for (Book book : books) {
            BookModel bookModel = new BookModel();
            bookModel.loadFromEntity(book);

            List<String> authorIds = getAuthorIds(book.getId());
            for (String authorId : authorIds) {
                Author author = getAuthor(authorId);
                AuthorModel authorModel = new AuthorModel();
                authorModel.loadFromEntity(author);

                bookModel.addAuthor(authorModel);
            }

            List<String> categoryIds = getCategoryIds(book.getId());
            for (String categoryId : categoryIds) {
                Category category = getCategory(categoryId);
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.loadFromEntity(category);

                bookModel.addCategory(categoryModel);
            }

            Publisher publisher = getPublisher(book.getPublisherId());
            PublisherModel publisherModel = new PublisherModel();
            publisherModel.loadFromEntity(publisher);

            bookModel.setPublisher(publisherModel);

            bookModels.add(bookModel);
        }

        return bookModels;
    }

    public BookModel getBookDetails(String bookId) {
        Book book = bookDao.findById(bookId);
        BookModel bookModel = new BookModel();
        bookModel.loadFromEntity(book);

        List<String> authorIds = getAuthorIds(bookId);
        for (String authorId : authorIds) {
            Author author = getAuthor(authorId);
            AuthorModel authorModel = new AuthorModel();
            authorModel.loadFromEntity(author);

            bookModel.addAuthor(authorModel);
        }

        List<String> categoryIds = getCategoryIds(bookId);
        for (String categoryId : categoryIds) {
            Category category = getCategory(categoryId);
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.loadFromEntity(category);

            bookModel.addCategory(categoryModel);
        }
        Publisher publisher = getPublisher(book.getPublisherId());
        PublisherModel publisherModel = new PublisherModel();
        publisherModel.loadFromEntity(publisher);

        bookModel.setPublisher(publisherModel);

        return bookModel;
    }

    public boolean addNewBook(BookModel bookModel) {
        Book newBook = new Book();
        newBook.loadFromModel(bookModel);
        boolean isBookAdded = bookDao.add(newBook);

        if (!isBookAdded) {
            return false;
        }

        String newBookId = bookDao.findByTitle(newBook.getTitle()).getId();

        for (AuthorModel authorModel : bookModel.getAuthors()) {
            BookAuthor newBookAuthor = new BookAuthor(newBookId, authorModel.getId());
            if (!addBookAuthor(newBookAuthor)) {
                return false;
            }
        }

        for (CategoryModel categoryModel : bookModel.getCategories()) {
            BookCategory newBookCategory = new BookCategory(newBookId, categoryModel.getId());
            if (!addBookCategory(newBookCategory)) {
                return false;
            }
        }
        return true;
    }

    public boolean editBook(BookModel bookModel) {
        Book updatedBook = new Book();
        updatedBook.loadFromModel(bookModel);
        boolean isBookUpdated = bookDao.update(updatedBook);

        if (!isBookUpdated) {
            return false;
        }

        List<String> idCurrAuths = getAuthorIds(bookModel.getId());
        List<String> idNewAuths = getNewAuthorIds(bookModel);
        for (String authorId : idCurrAuths) {
            if (!idNewAuths.contains(authorId)) {
                if (!deleteBookAuthor(bookModel.getId(), authorId)) {
                    return false;
                }
            }
        }

        for (String authorId : idNewAuths) {
            if (!idCurrAuths.contains(authorId)) {
                BookAuthor bookAuthor = new BookAuthor(bookModel.getId(), authorId);
                if (!addBookAuthor(bookAuthor)) {
                    return false;
                }
            }
        }

        List<String> idCurrCats = getCategoryIds(bookModel.getId());
        List<String> idNewCats = getNewCategoryIds(bookModel);
        for (String categoryId : idCurrCats) {
            if (!idNewCats.contains(categoryId)) {
                if (!deleteBookCategory(bookModel.getId(), categoryId)) {
                    return false;
                }
            }
        }

        for (String categoryId : idNewCats) {
            if (!idCurrCats.contains(categoryId)) {
                BookCategory bookCategory = new BookCategory(bookModel.getId(), categoryId);
                if (!addBookCategory(bookCategory)) {
                    return false;
                }
            }
        }

        return true;
    }

    public BookModel getBookByTitle(String title) {
        Book book = bookDao.findByTitle(title);
        BookModel bookModel = new BookModel();
        bookModel.loadFromEntity(book);

        List<String> authorIds = getAuthorIds(book.getId());
        for (String authorId : authorIds) {
            Author author = getAuthor(authorId);
            AuthorModel authorModel = new AuthorModel();
            authorModel.loadFromEntity(author);

            bookModel.addAuthor(authorModel);
        }

        List<String> categoryIds = getCategoryIds(book.getId());
        for (String categoryId : categoryIds) {
            Category category = getCategory(categoryId);
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.loadFromEntity(category);

            bookModel.addCategory(categoryModel);
        }

        Publisher publisher = getPublisher(book.getPublisherId());
        PublisherModel publisherModel = new PublisherModel();
        publisherModel.loadFromEntity(publisher);

        bookModel.setPublisher(publisherModel);

        return bookModel;
    }

    private List<String> getAuthorIds(String bookId) {
        List<String> authorIds = new ArrayList<>();
        bookAuthorDao.findByBookId(bookId).forEach(bookAuthor -> authorIds.add(bookAuthor.getAuthorId()));
        return authorIds;
    }

    private List<String> getNewAuthorIds(BookModel bookModel) {
        List<String> newAuthIds = bookModel.getAuthorIds();
        return newAuthIds;
    }

    private List<String> getCategoryIds(String bookId) {
        List<String> categoryIds = new ArrayList<>();
        bookCategoryDao.findByBookId(bookId).forEach(bookCategory -> categoryIds.add(bookCategory.getGenreId()));
        return categoryIds;
    }

    private List<String> getNewCategoryIds(BookModel bookModel) {
        List<String> newCatIds = bookModel.getCategoryIds();
        return newCatIds;
    }

    private boolean deleteBookAuthor(String bookId, String authorId) {
        return bookAuthorDao.delete(bookId, authorId);
    }

    private boolean deleteBookCategory(String bookId, String categoryId) {
        return bookCategoryDao.delete(bookId, categoryId);
    }

    private boolean addBookCategory(BookCategory bookCategory) {
        return bookCategoryDao.add(bookCategory);
    }

    private boolean addBookAuthor(BookAuthor bookAuthor) {
        return bookAuthorDao.add(bookAuthor);
    }

    private Author getAuthor(String id) {
        return authorDao.findById(id);
    }

    private Category getCategory(String id) {
        return categoryDao.findById(id);
    }

    private Publisher getPublisher(String id) {
        return publisherDao.findById(id);
    }

}
