package com.lms.bookCRUD.service;

import java.util.ArrayList;
import java.util.List;

import com.lms.bookCRUD.dal.*;
import com.lms.bookCRUD.entities.*;
import com.lms.bookCRUD.model.*;

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

    public List<BookModel> getAvailableBooks() {
        List<Book> books = bookDao.findAvailableBooks();
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

    public List<BookModel> getUnavailableBooks() {
        List<Book> books = bookDao.findUnavailableBooks();
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

        String newBookId = "";
        List<Book> books = bookDao.findByTitle(newBook.getTitle());
        for (Book book : books) {
            if (book.getEdition() == newBook.getEdition()) {
                newBookId = book.getId();
                break;
            }
        }

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

    public boolean setBookVisibility(String bookId, Boolean isHide) {
        Book book = bookDao.findById(bookId);
        book.setIsHide(isHide);
        return bookDao.update(book);
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

    public List<BookModel> searchByAny(String keyword, String tab) {
        List<BookModel> allBooks;
        if (tab.equals("All")) {
            allBooks = getAllBooks();
        } else if (tab.equals("Available")) {
            allBooks = getAvailableBooks();
        } else {
            allBooks = getUnavailableBooks();
        }
        List<BookModel> results = new ArrayList<>();
        for (BookModel book : allBooks) {
            Boolean isContainKw = false;

            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getPublisher().getName().toLowerCase().contains(keyword.toLowerCase()))
                isContainKw = true;

            List<String> genres = book.getGenres();
            for (String genre : genres) {
                if (genre.contains(keyword.toLowerCase())) {
                    isContainKw = true;
                    break;
                }
            }
            List<String> authorNames = book.getAuthorNames();
            for (String authorName : authorNames) {
                if (authorName.contains(keyword.toLowerCase())) {
                    isContainKw = true;
                    break;
                }
            }

            if (isContainKw) {
                results.add(book);
            }
        }
        return results;
    }

    public List<BookModel> searchByTitle(String keyword, String tab) {
        List<BookModel> allBooks;
        if (tab.equals("All")) {
            allBooks = getAllBooks();
        } else if (tab.equals("Available")) {
            allBooks = getAvailableBooks();
        } else {
            allBooks = getUnavailableBooks();
        }
        List<BookModel> results = new ArrayList<>();
        for (BookModel book : allBooks) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public List<BookModel> searchByCategory(String keyword, String tab) {
        List<BookModel> allBooks;
        if (tab.equals("All")) {
            allBooks = getAllBooks();
        } else if (tab.equals("Available")) {
            allBooks = getAvailableBooks();
        } else {
            allBooks = getUnavailableBooks();
        }
        List<BookModel> results = new ArrayList<>();
        for (BookModel book : allBooks) {
            Boolean isContainKw = false;
            List<String> genres = book.getGenres();
            for (String genre : genres) {
                if (genre.contains(keyword.toLowerCase())) {
                    isContainKw = true;
                    break;
                }
            }
            if (isContainKw) {
                results.add(book);
            }
        }
        return results;
    }

    public List<BookModel> searchByAuthor(String keyword, String tab) {
        List<BookModel> allBooks;
        if (tab.equals("All")) {
            allBooks = getAllBooks();
        } else if (tab.equals("Available")) {
            allBooks = getAvailableBooks();
        } else {
            allBooks = getUnavailableBooks();
        }
        List<BookModel> results = new ArrayList<>();
        for (BookModel book : allBooks) {
            Boolean isContainKw = false;
            List<String> authorNames = book.getAuthorNames();
            for (String authorName : authorNames) {
                if (authorName.contains(keyword.toLowerCase())) {
                    isContainKw = true;
                    break;
                }
            }
            if (isContainKw) {
                results.add(book);
            }
        }
        return results;
    }

    public List<BookModel> searchByPublisher(String keyword, String tab) {
        List<BookModel> allBooks;
        if (tab.equals("All")) {
            allBooks = getAllBooks();
        } else if (tab.equals("Available")) {
            allBooks = getAvailableBooks();
        } else {
            allBooks = getUnavailableBooks();
        }
        List<BookModel> results = new ArrayList<>();
        for (BookModel book : allBooks) {
            if (book.getPublisher().getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public List<BookModel> getBookByTitle(String title) {
        List<Book> books = bookDao.findByTitle(title);
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

    public List<BookModel> filterBooks(String tab, List<CategoryModel> categories, AuthorModel author,
            PublisherModel publisher, float price) {
        List<BookModel> allBooks;
        if (tab.contains("All")) {
            allBooks = getAllBooks();
        } else if (tab.contains("Available")) {
            allBooks = getAvailableBooks();
        } else {
            allBooks = getUnavailableBooks();
        }
        List<BookModel> results = new ArrayList<>();
        for (BookModel book : allBooks) {
            Boolean check = true;
            if (price != 0) {
                if (book.getSalePrice() > price) {
                    check = false;
                }
            }

            if (!categories.isEmpty()) {
                List<CategoryModel> genres = book.getCategories();
                Boolean checkCategory = false;
                for (int i = 0; i < categories.size(); i++) {
                    for (int j = 0; j < genres.size(); j++) {
                        if (genres.get(j).getGenre().equals(categories.get(i).getGenre())) {
                            checkCategory = true;
                            break;
                        }
                    }
                    if (checkCategory) {
                        break;
                    }
                }
                if (!checkCategory) {
                    check = false;
                }
            }

            if (author != null && !author.getName().equals("All")) {
                List<AuthorModel> authorNames = book.getAuthors();
                Boolean checkAuthor = false;
                for (int i = 0; i < authorNames.size(); i++) {
                    if (authorNames.get(i).getName().equals(author.getName())) {
                        checkAuthor = true;
                        break;
                    }
                }
                if (!checkAuthor) {
                    check = false;
                }
            }

            if (publisher != null && !publisher.getName().equals("All")) {
                if (!publisher.getName().equals(book.getPublisher().getName())) {
                    check = false;
                }
            }

            if (check) {
                results.add(book);
            }
        }
        return results;
    }

    public boolean deleteBookById(String id) {
        bookAuthorDao.deleteByBookId(id);
        bookCategoryDao.deleteByBookId(id);
        return bookDao.delete(id);
    }

    public boolean updateQuantity(String bookId, int quantity) {
        return bookDao.updateQuantity(bookId, quantity);
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
