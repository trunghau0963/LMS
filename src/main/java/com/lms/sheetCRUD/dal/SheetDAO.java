package com.lms.sheetCRUD.dal;

import java.util.ArrayList;

import com.lms.sheetCRUD.entities.Sheet;

public interface SheetDao {

    public ArrayList<Sheet> getAll();
    public Sheet getById(String id);
    public String createSheet(String importdate, String responsible);
}
