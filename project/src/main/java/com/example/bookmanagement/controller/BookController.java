package com.example.bookmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bookmanagement.model.Author;
import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.service.AuthorService;
import com.example.bookmanagement.service.BookService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String listBooks(Model model, @RequestParam(required = false) String search) {
        List<Book> books;
        if (search != null && !search.isEmpty()) {
            books = bookService.searchBooks(search);
            model.addAttribute("search", search);
        } else {
            books = bookService.findAllBooks();
        }
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/{id}")
    public String viewBook(@PathVariable Long id, Model model) {
        Optional<Book> bookOptional = bookService.findBookById(id);
        
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
            return "books/view";
        } else {
            return "redirect:/books";
        }
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "books/form";
    }

    @PostMapping("/new")
    public String createBook(@Valid @ModelAttribute Book book,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("authors", authorService.findAllAuthors());
            return "books/form";
        }
        
        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("successMessage", "Book created successfully!");
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Book> bookOptional = bookService.findBookById(id);
        
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
            model.addAttribute("authors", authorService.findAllAuthors());
            return "books/form";
        } else {
            return "redirect:/books";
        }
    }

    @PostMapping("/{id}/edit")
    public String updateBook(@PathVariable Long id,
                             @Valid @ModelAttribute Book book,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("authors", authorService.findAllAuthors());
            return "books/form";
        }
        
        book.setId(id);
        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("successMessage", "Book updated successfully!");
        return "redirect:/books/" + id;
    }

    @GetMapping("/{id}/delete")
    public String confirmDelete(@PathVariable Long id, Model model) {
        Optional<Book> bookOptional = bookService.findBookById(id);
        
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
            return "books/delete";
        } else {
            return "redirect:/books";
        }
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        bookService.deleteBook(id);
        redirectAttributes.addFlashAttribute("successMessage", "Book deleted successfully!");
        return "redirect:/books";
    }
}