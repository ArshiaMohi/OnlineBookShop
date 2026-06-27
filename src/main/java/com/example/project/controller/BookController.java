package com.example.project.controller;

import com.example.project.dto.BookSaveDto;
import com.example.project.model.Book;
import com.example.project.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Books", description = "Book Management APIs")
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get book with id")
    @GetMapping("/{id}")
    public Book findById(@PathVariable int id) {
        return bookService.findById(id);
    }

    @Operation(summary = "Get all books")
    @GetMapping()
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @Operation(summary = "Update a book")
    @PostMapping("/update")
    public Book update(@Valid @RequestBody BookSaveDto bookSaveDto) {
        Book book = bookSaveDto.convert();
        bookService.update(book);
        return book;
    }

    @Operation(summary = "Delete a book")
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
    }
}
