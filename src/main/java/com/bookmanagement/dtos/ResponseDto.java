package com.bookmanagement.dtos;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ResponseDto {

    private HttpStatus status;

    private String body;

}
