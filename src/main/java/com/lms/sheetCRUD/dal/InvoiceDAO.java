package com.lms.sheetCRUD.dal;

import java.util.ArrayList;

import com.lms.sheetCRUD.entities.Invoice;

public interface InvoiceDao {

    
    public ArrayList<Invoice> getAll();
    public Invoice getById(String id);
    public String createInvoice(String empId, String customerId, String date);
    
} 
