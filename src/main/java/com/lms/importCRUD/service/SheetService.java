package com.lms.importCRUD.service;

import com.lms.importCRUD.dal.SheetDao;

public class SheetService {
    SheetDao dao;
    
    public SheetService(SheetDao dao) {
        this.dao = dao;
    }

    public String createSheet(String importdate, String responsible){
        return dao.createSheet(importdate, responsible);
    }
}
