package com.lms.dataSaleCRUD.entities;

public class Category {
    private String genre;
    private String genreId;

    public Category() {
        super();
    }

    public Category(String genre, String genreId) {
        this.genre = genre;
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return genre;
    }
}
