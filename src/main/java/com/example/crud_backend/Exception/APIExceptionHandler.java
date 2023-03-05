package com.example.crud_backend.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleNullPointerException(APICustomException e) {
        return ResponseEntity.internalServerError().body(new APICustomErrorResponseDTO(e.getErrorCodes()));
    }

}
