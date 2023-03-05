package com.example.crud_backend.Exception;

import lombok.Getter;

@Getter
public class APICustomErrorResponseDTO {
    private final String errorMessage;
    private final Integer errorCode;

    public APICustomErrorResponseDTO(ErrorCodes errorCodes) {
        errorMessage = errorCodes.getErrorMessage();
        errorCode = errorCodes.getErrorCode();
    }
}
