package com.lms.sheetCRUD.entities;

import java.util.List;

public class SheetDetail {
    private String sheetId;
    private List<Book> books;

    public SheetDetail(String sheetId, List<Book> books) {
        this.sheetId = sheetId;
        this.books = books;
    }

    public String getSheetId() {
        return sheetId;
    }

    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
