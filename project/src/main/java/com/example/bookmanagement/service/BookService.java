package com.example.bookmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmanagement.model.Author;
import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.repository.AuthorRepository;
import com.example.bookmanagement.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findAllBooks() {
        List<Book> books = bookRepository.findAllOrderByTitle();
        enrichBooksWithAuthors(books);
        return books;
    }

    public Optional<Book> findBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        bookOptional.ifPresent(this::enrichBookWithAuthor);
        return bookOptional;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findBooksByAuthor(Long authorId) {
        List<Book> books = bookRepository.findByAuthorId(authorId);
        enrichBooksWithAuthors(books);
        return books;
    }

    public List<Book> searchBooks(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return findAllBooks();
        }
        
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(keyword);
        List<Book> authorBooks = bookRepository.findByAuthorNameContainingIgnoreCase(keyword);
        
        // Add books found by author name if not already in the list
        for (Book book : authorBooks) {
            if (books.stream().noneMatch(b -> b.getId().equals(book.getId()))) {
                books.add(book);
            }
        }
        
        enrichBooksWithAuthors(books);
        return books;
    }

    private void enrichBooksWithAuthors(List<Book> books) {
        for (Book book : books) {
            enrichBookWithAuthor(book);
        }
    }

    private void enrichBookWithAuthor(Book book) {
        if (book.getAuthorId() != null) {
            Optional<Author> authorOptional = authorRepository.findById(book.getAuthorId());
            authorOptional.ifPresent(book::setAuthor);
        }
    }
}