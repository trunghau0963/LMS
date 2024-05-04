package com.lms.sheetCRUD.dal;

import java.util.ArrayList;
import java.util.List;

import com.lms.sheetCRUD.entities.ImportBook;
import com.lms.sheetCRUD.entities.SheetDetail;

public interface SheetDetailDao {

    public void getAll();

    public SheetDetail getSheetDetail(String sheetId);

    public void insertIntoSheet(String sheetId, List<ImportBook> books);

    public void deleteSheet(String sheetId);

}

    

    