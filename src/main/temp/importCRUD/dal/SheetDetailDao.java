package com.lms.importCRUD.dal;

import java.util.List;

import com.lms.importCRUD.entities.ImportBook;

public interface SheetDetailDao {
    public void insertIntoSheet(String sheetId, List<ImportBook> books);
}
