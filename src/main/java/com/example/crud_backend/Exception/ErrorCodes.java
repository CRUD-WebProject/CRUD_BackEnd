package com.example.crud_backend.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {
    FAIL_LOGIN("로그인에 실패했습니다", 1000);

    private final String errorMessage;
    private final Integer errorCode;
}
