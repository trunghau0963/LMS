package com.lms.sheetCRUD.service;

import java.util.List;

import com.lms.sheetCRUD.dal.SheetDetailDao;
import com.lms.sheetCRUD.entities.ImportBook;

public class SheetDetailService {
    SheetDetailDao dao;
    
    public SheetDetailService(SheetDetailDao dao) {
        this.dao = dao;
    }

    public void insertIntoSheet(String sheetId, List<ImportBook> books) {
        dao.insertIntoSheet(sheetId, books);
    }
}
