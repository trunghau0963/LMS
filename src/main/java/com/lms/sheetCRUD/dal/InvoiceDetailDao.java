package com.lms.sheetCRUD.dal;

import java.util.List;
import com.lms.sheetCRUD.entities.ExportBook;
import com.lms.sheetCRUD.entities.InvoiceDetail;

public interface InvoiceDetailDao {


     public void getAll();

    public InvoiceDetail getInvoiceDetail(String invoiceID);

    public void insertIntoInvoice(String invoiceId, List<ExportBook> books);
  
    public void deleteSheet(String invoiceID);
} 
