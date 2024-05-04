package com.lms.exportCRUD.service;

import com.lms.exportCRUD.dal.InvoiceDetailDao;
import java.util.List;
import com.lms.exportCRUD.entities.ExportBook;


public class InvoiceDetailService {


    InvoiceDetailDao dao;
    
    public InvoiceDetailService(InvoiceDetailDao dao) {
        this.dao = dao;
    }

    public void insertIntoInvoice(String invoiceId, List<ExportBook> books) {
        dao.insertIntoInvoice(invoiceId, books);
    }
  
}
