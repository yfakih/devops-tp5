package com.bookmanagement.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String key, String value) {
        super(String.format("the Book with the %s = %s not found", key, value));
    }
}
