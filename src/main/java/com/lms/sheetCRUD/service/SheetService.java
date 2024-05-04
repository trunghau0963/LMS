package com.lms.sheetCRUD.service;

import java.util.ArrayList;

import com.lms.sheetCRUD.dal.SheetDao;
import com.lms.sheetCRUD.entities.Sheet;

public class SheetService {
    SheetDao dao;

    public ArrayList<Sheet> getAll(){
        return dao.getAll();
    }

    public Sheet getById(String id){
        return dao.getById(id);
    }
    
    public SheetService(SheetDao dao) {
        this.dao = dao;
    }

    public String createSheet(String importdate, String responsible){
        return dao.createSheet(importdate, responsible);
    }

    public ArrayList<Sheet> getSheetsByDateRange(String startDate, String endDate){
        return dao.getSheetsByDateRange(startDate, endDate);
    }
}