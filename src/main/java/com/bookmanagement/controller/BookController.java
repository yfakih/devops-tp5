package com.bookmanagement.controller;

import com.bookmanagement.dtos.BookDto;
import com.bookmanagement.dtos.ResponseDto;
import com.bookmanagement.mapper.BookMapper;
import com.bookmanagement.services.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BookController {

    private IBookService bookService;


    @GetMapping("/fetchBooks")
    public ResponseEntity<List<BookDto>> getBooks(){
        List<BookDto> bookDtos = bookService.getAllBooks()
                .stream()
                .map(
                    b -> BookMapper.mapToBookDto(b, new BookDto())
        ).toList();

        return ResponseEntity.ok().body(bookDtos);
    }

    @PostMapping("/createBook")
    public ResponseEntity<ResponseDto> createBook(@RequestBody BookDto bookDto){
        bookService.createBook(bookDto);

        return ResponseEntity.ok()
                .body(new ResponseDto(HttpStatus.OK, " book Successfully created"));
    }

    @PutMapping("/updateBook")
    public ResponseEntity<ResponseDto> updateBook(@RequestBody BookDto bookDto){
        boolean updated = bookService.updateBook(bookDto);
        if(updated){
            return ResponseEntity.ok()
                    .body(new ResponseDto(HttpStatus.OK, "book Successfully created"));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(HttpStatus.EXPECTATION_FAILED, "Update operation failed. Please try again or contact Dev team"));
        }
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<ResponseDto> deleteBook(@RequestBody BookDto bookDto){
        boolean deleted = bookService.deleteBook(bookDto);
        if(deleted){
            return ResponseEntity.ok()
                    .body(new ResponseDto(HttpStatus.OK, "book successfully deleted"));
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(HttpStatus.EXPECTATION_FAILED, "Delete operation failed. Please try again or contact Dev team"));
        }
    }

}
