package com.example.project.dto;

import com.example.project.model.Book;

public class BookSaveDto {
    private int id;
    private String title;
    private String author;
    private String description;
    private String imageAddress;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Book convert() {
        Book book = new Book();
        book.setId(this.id);
        book.setAuthor(this.author);
        book.setDescription(this.description);
        book.setImageAddress(this.imageAddress);
        book.setPrice(this.price);
        book.setTitle(this.title);
        return book;
    }
}
