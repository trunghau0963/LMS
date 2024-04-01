package com.lms.dataSaleCRUD.dal;
import java.util.List;


import com.lms.dataSaleCRUD.entities.BookWithRevenue;

import com.lms.dataSaleCRUD.entities.CategoryWithRevenue;

public interface UserDao {
    public List<BookWithRevenue> getAllBooks();
    public List<BookWithRevenue> getTotalRevenueGroupByBookBetweenDate(String startDate, String endDate);
    public List<CategoryWithRevenue> getAllCategories();
    public List<CategoryWithRevenue> getTotalRevenueGroupByCategoryBetweenDate(String startDate, String endDate);
}
