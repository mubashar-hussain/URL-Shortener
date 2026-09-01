package com.mubashar.urlshortner.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UrlNotFound.class)
    public ResponseEntity<String> handleExceptions(UrlNotFound ex ){

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

   return  ResponseEntity
   .status(httpStatus)
   .body(ex.getMessage());
}



}
