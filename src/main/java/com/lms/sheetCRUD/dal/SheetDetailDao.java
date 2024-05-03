package com.lms.sheetCRUD.dal;

import java.util.List;

import com.lms.sheetCRUD.entities.ImportBook;

public interface SheetDetailDao {

    public void getAll();

    public void getSheetDetail(String sheetId);

    public void insertIntoSheet(String sheetId, List<ImportBook> books);

    public void deleteSheet(String sheetId);

}

    

    