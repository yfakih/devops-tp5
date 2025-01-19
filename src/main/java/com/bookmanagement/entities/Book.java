package com.bookmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Book {
    @Id
    @SequenceGenerator(name = "bookGen", initialValue = 100_000_000)
    @GeneratedValue(generator = "bookGen")
    private Long bookId;

    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId")
    private Author author;

    private Long isbn;

    private LocalDate publicationYear;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookCategory.class)
    @JoinColumn(name = "categoryId")
    private BookCategory category;

    private String description;

    private int availableCopies;

    private int totalCopies;
}
