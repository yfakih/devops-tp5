package com.bookmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class BookCategory {
    @Id
    @SequenceGenerator(name = "catGen", initialValue = 3_000, allocationSize = 100)
    @GeneratedValue(generator = "catGen")
    private Long categoryId;
    private String title;
    private String description;
}
