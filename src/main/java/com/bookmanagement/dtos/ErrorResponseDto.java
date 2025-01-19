package com.bookmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
public class ErrorResponseDto {
    private String apiPath;

    private HttpStatus status;

    private String body;

    private LocalDateTime time;

    public ErrorResponseDto() {

    }
}
