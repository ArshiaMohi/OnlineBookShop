package com.example.project.service;

import com.example.project.exception.BookNotFoundException;
import com.example.project.model.Book;
import com.example.project.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
