package com.bookmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long isbn;

    private String title;

    private String description;

    private String authorName;

    private LocalDate publicationYear;
}
