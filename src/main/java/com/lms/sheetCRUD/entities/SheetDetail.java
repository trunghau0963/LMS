package com.lms.sheetCRUD.entities;

import java.util.List;

public class SheetDetail {
    private String sheetId;
    private List<Book> books;
    private List<ImportBook> importBooks;

    // public SheetDetail(String sheetId, List<Book> books) {
    //     this.sheetId = sheetId;
    //     this.books = books;
    // }

    public SheetDetail(String sheetId, List<ImportBook> importBooks) {
        this.sheetId = sheetId;
        this.importBooks = importBooks;
    }

    public String getSheetId() {
        return sheetId;
    }

    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    public List<ImportBook> getBooks() {
        return importBooks;
    }

    public void setBooks(List<ImportBook> books) {
        this.importBooks = books;
    }
}
