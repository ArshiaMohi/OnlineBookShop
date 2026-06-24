package com.example.project.controller;

import com.example.project.dto.ApplicationUserSaveDto;
import com.example.project.dto.BookSaveDto;
import com.example.project.model.ApplicationUser;
import com.example.project.model.Book;
import com.example.project.model.Role;
import com.example.project.service.ApplicationUserService;
import com.example.project.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    private final ApplicationUserService applicationUserService;

    private final BookService bookService;

    public PageController(ApplicationUserService applicationUserService, BookService bookService) {
        this.applicationUserService = applicationUserService;
        this.bookService = bookService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/book")
    public String book() {
        return "bookDetail";
    }

    @GetMapping("/bookList")
    public String bookList(){
        return "books";
    }

    @GetMapping("/admin/books")
    public String bookAdmin(){
        return "adminBook";
    }

    @GetMapping("/admin/book/save")
    public String saveBook(){
        return "saveBook";
    }

    @GetMapping("/admin/book/update")
    public String updateBook(){
        return "updateBook";
    }

    @PostMapping("/book/save")
    public String save(BookSaveDto bookSaveDto) {
        Book book = bookSaveDto.convert();
        bookService.save(book);
        return "adminBook";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/save/user")
    public String save(ApplicationUserSaveDto applicationUserSaveDto) {
        ApplicationUser applicationUser = applicationUserSaveDto.convert();
        applicationUser.setRole(Role.USER);
        applicationUserService.save(applicationUser);
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        ApplicationUser applicationUser = applicationUserService.findByUsernameAndPassword(username, password);

        if (applicationUser == null){
            return "login";
        }else{
            return "home";
        }
    }

    @GetMapping("/admin/users")
    public String usersList(){
        return "usersList";
    }

}
