package com.example.bookmanagement.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookmanagement.model.Author;
import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    
    List<Author> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT COUNT(*) FROM BOOKS WHERE AUTHOR_ID = :authorId")
    int countBooksByAuthorId(@Param("authorId") Long authorId);
    
    @Query("SELECT * FROM AUTHORS ORDER BY NAME")
    List<Author> findAllOrderByName();
}