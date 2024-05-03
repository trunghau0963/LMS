package com.lms.exportCRUD.service;

import com.lms.exportCRUD.dal.InvoiceDao;



public class InvoiceService {

    InvoiceDao dao;
    
    public InvoiceService(InvoiceDao dao) {
        this.dao = dao;
    }

    public String createInvoice(String empId, String customerId, String date) {
        return dao.createInvoice(empId, customerId, date);
    }

}
