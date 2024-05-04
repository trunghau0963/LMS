package com.lms.sheetCRUD.service;

import java.util.ArrayList;
import java.util.List;

import com.lms.sheetCRUD.dal.SheetDetailDao;
import com.lms.sheetCRUD.entities.ImportBook;
import com.lms.sheetCRUD.entities.SheetDetail;

public class SheetDetailService {
    SheetDetailDao dao;
    
    public SheetDetailService(SheetDetailDao dao) {
        this.dao = dao;
    }

    public void insertIntoSheet(String sheetId, List<ImportBook> books) {
        dao.insertIntoSheet(sheetId, books);
    }

    public void getAll() {
        dao.getAll();
    }   

    public SheetDetail getSheetDetail(String sheetId){
        return dao.getSheetDetail(sheetId);
    }
}
