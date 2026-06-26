package com.example.project.controller;

import com.example.project.dto.BookSaveDto;
import com.example.project.model.Book;
import com.example.project.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable int id) {
        return bookService.findById(id);
    }

    @GetMapping()
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping("/update")
    public Book update(@Valid @RequestBody BookSaveDto bookSaveDto) {
        Book book = bookSaveDto.convert();
        bookService.update(book);
        return book;
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
    }
}
