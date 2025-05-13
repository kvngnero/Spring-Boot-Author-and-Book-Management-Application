package com.example.bookmanagement.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookmanagement.model.Book;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    
    List<Book> findByTitleContainingIgnoreCase(String title);
    
    List<Book> findByAuthorId(Long authorId);
    
    @Query("SELECT b.* FROM BOOKS b JOIN AUTHORS a ON b.AUTHOR_ID = a.ID " +
           "WHERE LOWER(a.NAME) LIKE LOWER(CONCAT('%', :authorName, '%'))")
    List<Book> findByAuthorNameContainingIgnoreCase(@Param("authorName") String authorName);
    
    @Query("SELECT b.* FROM BOOKS b ORDER BY b.TITLE")
    List<Book> findAllOrderByTitle();
}