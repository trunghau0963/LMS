package com.lms.exportCRUD.entities;

public class BookAuthor {
    private String authorId;
    private String bookId;

    public BookAuthor(String bookId, String authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
