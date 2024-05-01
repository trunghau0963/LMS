package com.lms.importCRUD.service;

import java.util.List;

import com.lms.importCRUD.dal.SheetDetailDao;
import com.lms.importCRUD.entities.ImportBook;

public class SheetDetailService {
    SheetDetailDao dao;
    
    public SheetDetailService(SheetDetailDao dao) {
        this.dao = dao;
    }

    public void insertIntoSheet(String sheetId, List<ImportBook> books) {
        dao.insertIntoSheet(sheetId, books);
    }
}
