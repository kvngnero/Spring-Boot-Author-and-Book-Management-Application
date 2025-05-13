package com.example.bookmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookmanagement.model.Author;
import com.example.bookmanagement.repository.AuthorRepository;
import com.example.bookmanagement.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAllOrderByName();
    }

    public Optional<Author> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public void deleteAuthor(Long id) {
        // First, delete all books associated with this author
        bookRepository.findByAuthorId(id).forEach(book -> 
            bookRepository.deleteById(book.getId()));
        
        // Then delete the author
        authorRepository.deleteById(id);
    }

    public List<Author> searchAuthors(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return findAllAuthors();
        }
        return authorRepository.findByNameContainingIgnoreCase(keyword);
    }

    public int getBookCountByAuthor(Long authorId) {
        return authorRepository.countBooksByAuthorId(authorId);
    }
}