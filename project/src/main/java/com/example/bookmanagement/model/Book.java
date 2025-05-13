package com.example.bookmanagement.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Table("BOOKS")
public class Book {

    @Id
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 200, message = "Title must be between 1 and 200 characters")
    private String title;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @NotNull(message = "Publication date is required")
    @PastOrPresent(message = "Publication date cannot be in the future")
    private LocalDate publicationDate;

    @NotBlank(message = "ISBN is required")
    @Size(min = 10, max = 17, message = "ISBN must be between 10 and 17 characters")
    private String isbn;

    @Min(value = 1, message = "Page count must be at least 1")
    private Integer pageCount;

    @Column("AUTHOR_ID")
    private Long authorId;
    
    // Transient fields (not stored in DB)
    private transient Author author;
    
    // Constructors
    public Book() {
    }
    
    public Book(String title, String description, LocalDate publicationDate, String isbn, 
                Integer pageCount, Long authorId) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Integer getPageCount() {
        return pageCount;
    }
    
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    
    public Long getAuthorId() {
        return authorId;
    }
    
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
        if (author != null) {
            this.authorId = author.getId();
        }
    }
    
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", publicationDate=" + 
               publicationDate + ", isbn=" + isbn + ", authorId=" + authorId + "]";
    }
}