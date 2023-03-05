package com.example.crud_backend.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class APICustomException extends RuntimeException {
    private final ErrorCodes errorCodes;
}
