package com.bookmanagement.services;

import com.bookmanagement.dtos.BookDto;
import com.bookmanagement.entities.Book;
import com.bookmanagement.exceptions.BookNotFoundException;
import com.bookmanagement.mapper.BookMapper;
import com.bookmanagement.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IBookServiceImpl implements IBookService {

    private BookRepository bookRepository;

    @Override
    public Book getBookByISBN(Long isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(
                        ()-> {return new BookNotFoundException("isbn", isbn.toString());}
                );
    }

    @Override
    public List<Book> getBookByCategoryId(Long catId) {
        return bookRepository.findBookByCategory_CategoryId(catId)
                .orElseThrow(
                        ()-> new BookNotFoundException("Category Id", catId.toString())
                );
    }

    @Override
    public List<Book> getBookByAuthorName(String name) {
        return null;
    }

    @Override
    public List<Book> getBookByKeyword(String kw) {
        List<Book> books;
        books = this.bookRepository.findByDescriptionContainsIgnoreCaseOrTitleContainsIgnoreCase(kw, kw)
                .get();
        return books;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    @Override
    public void createBook(BookDto bookDto) {
        Book book = BookMapper.mapToBook(bookDto, new Book());
        bookRepository.save(book);
    }

    @Override
    public boolean updateBook(BookDto bookDto) {
        boolean updated =false;
        if(bookDto != null)
        {
            Book book = bookRepository.findByIsbn(bookDto.getIsbn()).orElseThrow(
                    ()-> new BookNotFoundException("book id", bookDto.getIsbn().toString())
            );
            bookRepository.save(book);
            updated = true;
        }
        return updated;
    }

    @Override
    public boolean deleteBook(BookDto bookDto) {
        boolean deleted = false;
        if(bookDto != null){
            Book book = bookRepository.findByIsbn(bookDto.getIsbn()).orElseThrow(
                    ()-> new BookNotFoundException("book id", bookDto.getIsbn().toString())
            );
            bookRepository.deleteBookByIsbn(book.getIsbn());
            deleted = true;
        }
        return deleted;
    }


}
