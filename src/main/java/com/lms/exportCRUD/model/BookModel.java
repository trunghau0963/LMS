package com.lms.exportCRUD.model;

import java.util.List;

import com.lms.bookCRUD.entities.Book;

import java.util.ArrayList;

public class BookModel {
    private String id;
    private Integer edition;
    private String title;
    private List<AuthorModel> authors;
    private List<CategoryModel> categories;
    private PublisherModel publisher;
    private Float salePrice;
    private Integer quantity;
    private Boolean isHide;

    public BookModel() {
        id = null;
        edition = 0;
        title = null;
        authors = new ArrayList<>();
        categories = new ArrayList<>();
        publisher = new PublisherModel();
        salePrice = 0.0f;
        quantity = 0;
        isHide = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public List<String> getAuthorIds() {
        List<String> authorIds = new ArrayList<>();
        authors.forEach(author -> authorIds.add(author.getId()));
        return authorIds;
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public List<String> getCategoryIds() {
        List<String> categoryIds = new ArrayList<>();
        categories.forEach(category -> categoryIds.add(category.getId()));
        return categoryIds;
    }

    public List<String> getGenres() {
        List<String> genres = new ArrayList<>();
        categories.forEach(category -> genres.add(category.getGenre().toLowerCase()));
        return genres;
    }

    public List<String> getAuthorNames() {
        List<String> authorNames = new ArrayList<>();
        authors.forEach(author -> authorNames.add(author.getName().toLowerCase()));
        return authorNames;
    }

    public PublisherModel getPublisher() {
        return publisher;
    }

    public Integer getEdition() {
        return edition;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public Boolean getIsHide() {
        return isHide;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }

    public void setCategories(List<CategoryModel> categories) {
        this.categories = categories;
    }

    public void setIsHide(Boolean isHide) {
        this.isHide = isHide;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public void addAuthor(AuthorModel author) {
        authors.add(author);
    }

    public void addCategory(CategoryModel category) {
        categories.add(category);
    }

    public void loadFromEntity(com.lms.exportCRUD.entities.Book book) {
        id = book.getId();
        title = book.getTitle();
        edition = book.getEdition();
        quantity = book.getQuantity();
        salePrice = book.getSalePrice();
        isHide = book.getIsHide();
    }

    public String getAuthorsString() {
        String str = "";
        for (AuthorModel authorModel : authors) {
            str += authorModel.toString();
            if (authors.indexOf(authorModel) != authors.size() - 1)
                str += ", ";
        }
        return str;
    }

    public String getCategoriesString() {
        String str = "";
        for (CategoryModel categoryModel : categories) {
            str += categoryModel.toString();
            if (categories.indexOf(categoryModel) != categories.size() - 1)
                str += ", ";
        }
        return str;
    }
}
