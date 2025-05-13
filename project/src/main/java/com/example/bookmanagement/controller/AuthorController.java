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
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping
    public String listAuthors(Model model, @RequestParam(required = false) String search) {
        List<Author> authors;
        if (search != null && !search.isEmpty()) {
            authors = authorService.searchAuthors(search);
            model.addAttribute("search", search);
        } else {
            authors = authorService.findAllAuthors();
        }
        model.addAttribute("authors", authors);
        return "authors/list";
    }

    @GetMapping("/{id}")
    public String viewAuthor(@PathVariable Long id, Model model) {
        Optional<Author> authorOptional = authorService.findAuthorById(id);
        
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            List<Book> books = bookService.findBooksByAuthor(id);
            
            model.addAttribute("author", author);
            model.addAttribute("books", books);
            return "authors/view";
        } else {
            return "redirect:/authors";
        }
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/form";
    }

    @PostMapping("/new")
    public String createAuthor(@Valid @ModelAttribute Author author, 
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "authors/form";
        }
        
        authorService.saveAuthor(author);
        redirectAttributes.addFlashAttribute("successMessage", "Author created successfully!");
        return "redirect:/authors";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Author> authorOptional = authorService.findAuthorById(id);
        
        if (authorOptional.isPresent()) {
            model.addAttribute("author", authorOptional.get());
            return "authors/form";
        } else {
            return "redirect:/authors";
        }
    }

    @PostMapping("/{id}/edit")
    public String updateAuthor(@PathVariable Long id,
                               @Valid @ModelAttribute Author author,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "authors/form";
        }
        
        author.setId(id);
        authorService.saveAuthor(author);
        redirectAttributes.addFlashAttribute("successMessage", "Author updated successfully!");
        return "redirect:/authors/" + id;
    }

    @GetMapping("/{id}/delete")
    public String confirmDelete(@PathVariable Long id, Model model) {
        Optional<Author> authorOptional = authorService.findAuthorById(id);
        
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            int bookCount = authorService.getBookCountByAuthor(id);
            
            model.addAttribute("author", author);
            model.addAttribute("bookCount", bookCount);
            return "authors/delete";
        } else {
            return "redirect:/authors";
        }
    }

    @PostMapping("/{id}/delete")
    public String deleteAuthor(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        authorService.deleteAuthor(id);
        redirectAttributes.addFlashAttribute("successMessage", "Author deleted successfully!");
        return "redirect:/authors";
    }
}