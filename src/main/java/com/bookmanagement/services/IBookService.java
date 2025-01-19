package com.bookmanagement.services;

import com.bookmanagement.dtos.BookDto;
import com.bookmanagement.entities.Book;

import java.util.List;

public interface IBookService {

    Book getBookByISBN(Long isbn);

    List<Book> getBookByCategoryId(Long catId);

    List<Book> getBookByAuthorName(String name);

    List<Book> getBookByKeyword(String kw);

    List<Book> getAllBooks();

    void createBook(BookDto bookDto);

    boolean updateBook(BookDto bookDto);

    boolean deleteBook(BookDto bookDto);
}
