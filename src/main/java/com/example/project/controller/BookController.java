package com.example.project.controller;

import com.example.project.dto.BookSaveDto;
import com.example.project.model.Book;
import com.example.project.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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
    public Page<Book> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return bookService.getBooks(page, size);
    }

    @Operation(summary = "Update a book")
    @PutMapping("/update")
    public Book update(@Valid @RequestBody BookSaveDto bookSaveDto) {
        Book book = bookSaveDto.convert();
        bookService.update(book);
        return book;
    }

    @Operation(summary = "Delete a book")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam String title){
        return bookService.searchByTitle(title);
    }

    @GetMapping("/sorted")
    public List<Book> sortBooks(){
        return bookService.findAll(Sort.by("price"));
    }
}
