package com.lms.exportCRUD.dal;

import java.util.List;
import com.lms.exportCRUD.entities.ExportBook;

public interface InvoiceDetailDao {

    public void insertIntoInvoice(String invoiceId, List<ExportBook> books);
  
} 
