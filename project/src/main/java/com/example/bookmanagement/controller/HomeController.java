package com.example.bookmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bookmanagement.service.AuthorService;
import com.example.bookmanagement.service.BookService;

@Controller
public class HomeController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public HomeController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "home";
    }
}