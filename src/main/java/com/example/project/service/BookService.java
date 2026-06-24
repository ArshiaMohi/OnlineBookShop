package com.example.project.service;

import com.example.project.model.Book;

import java.util.List;

public interface BookService {
    void save(Book book);

    void delete(Book book);

    void update(Book book);

    Book findById(int id);

    List<Book> findAll();
}
