package com.lms.sheetCRUD.service;

import com.lms.sheetCRUD.dal.InvoiceDetailDao;
import java.util.List;
import com.lms.sheetCRUD.entities.ExportBook;
import com.lms.sheetCRUD.entities.InvoiceDetail;


public class InvoiceDetailService {


    InvoiceDetailDao dao;
    
    public InvoiceDetailService(InvoiceDetailDao dao) {
        this.dao = dao;
    }

    public void insertIntoInvoice(String invoiceId, List<ExportBook> books) {
        dao.insertIntoInvoice(invoiceId, books);
    }

    public void getAll() {
        dao.getAll();
    }

    public InvoiceDetail getInvoiceDetail(String invoiceId){
        return dao.getInvoiceDetail(invoiceId);
    }
  
}
