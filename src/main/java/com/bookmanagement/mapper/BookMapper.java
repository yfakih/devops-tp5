package com.bookmanagement.mapper;

import com.bookmanagement.dtos.BookDto;
import com.bookmanagement.entities.Author;
import com.bookmanagement.entities.Book;
import com.bookmanagement.services.IBookService;

public class BookMapper {

    private IBookService bookService;

    public static Book mapToBook(BookDto bookDto, Book book){
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setAuthor(Author.builder().fullName(bookDto.getAuthorName()).build());
        book.setPublicationYear(bookDto.getPublicationYear());

        return book;
    }

    public static BookDto mapToBookDto(Book book, BookDto bookDto){
        bookDto.setIsbn(book.getIsbn());
        bookDto.setTitle(book.getTitle());
        bookDto.setDescription(book.getDescription());
        bookDto.setAuthorName("de");
        bookDto.setPublicationYear(book.getPublicationYear());

        return bookDto;
    }
}
