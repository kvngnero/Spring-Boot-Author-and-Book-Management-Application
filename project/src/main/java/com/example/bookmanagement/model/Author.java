package com.example.bookmanagement.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Table("AUTHORS")
public class Author {

    @Id
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Size(max = 500, message = "Biography cannot exceed 500 characters")
    private String biography;

    private String nationality;
    
    // Constructors
    public Author() {
    }
    
    public Author(String name, LocalDate birthDate, String biography, String nationality) {
        this.name = name;
        this.birthDate = birthDate;
        this.biography = biography;
        this.nationality = nationality;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getBiography() {
        return biography;
    }
    
    public void setBiography(String biography) {
        this.biography = biography;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + ", birthDate=" + birthDate + 
               ", nationality=" + nationality + "]";
    }
}