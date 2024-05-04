package com.lms.sheetCRUD.service;

import java.util.ArrayList;

import com.lms.sheetCRUD.dal.InvoiceDao;
import com.lms.sheetCRUD.entities.Invoice;

public class InvoiceService {

    InvoiceDao dao;

    public ArrayList<Invoice> getAll() {
        return dao.getAll();
    }

    public Invoice getById(String id) {
        return dao.getById(id);
    }

    public InvoiceService(InvoiceDao dao) {
        this.dao = dao;
    }

    public String createInvoice(String empId, String customerId, String date) {
        return dao.createInvoice(empId, customerId, date);
    }

}
