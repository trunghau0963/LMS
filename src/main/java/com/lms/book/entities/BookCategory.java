package com.lms.book.entities;

public class BookCategory {
    private String bookId;
    private String genreId;

    public BookCategory(String bookId, String genreId) {
        this.bookId = bookId;
        this.genreId = genreId;
    }

    public String getGenreId() {
        return genreId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

}
