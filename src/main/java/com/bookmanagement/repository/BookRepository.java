package com.bookmanagement.repository;


import com.bookmanagement.entities.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(Long isbn);
    Optional<List<Book>> findBookByCategory_CategoryId(Long catId);
    Optional<Book> findBookByAuthor_AuthorId(Long id);
    Optional<List<Book>> findByDescriptionContainsIgnoreCaseOrTitleContainsIgnoreCase(String description, String title);
    @Transactional
    void deleteBookByIsbn(Long isbn);
}
