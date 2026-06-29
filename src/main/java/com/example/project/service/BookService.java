package com.example.project.service;

import com.example.project.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    void save(Book book);

    void delete(Book book);

    void update(Book book);

    Book findById(int id);

    List<Book> findAll();

    Page<Book> getBooks(int page, int size);

    public List<Book> searchByTitle(String title);
}
