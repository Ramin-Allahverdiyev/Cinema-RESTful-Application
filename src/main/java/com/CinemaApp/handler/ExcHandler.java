package com.CinemaApp.handler;

import com.CinemaApp.dto.ExceptionResponse;
import com.CinemaApp.exception.ExceedLimitException;
import com.CinemaApp.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> getEntity(NotFoundException ex){
        int status= HttpStatus.NOT_FOUND.value();
        return ResponseEntity.status(status)
                .body(ExceptionResponse.builder()
                        .status(status)
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler(ExceedLimitException.class)
    public ResponseEntity<ExceptionResponse> exceedLimit(ExceedLimitException el){
        int status=HttpStatus.FORBIDDEN.value();
        return ResponseEntity.status(status)
                .body(ExceptionResponse.builder()
                        .message(el.getMessage())
                        .status(status)
                        .build());
    }
}
