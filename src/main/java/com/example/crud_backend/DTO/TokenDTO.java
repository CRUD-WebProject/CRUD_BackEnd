package com.example.crud_backend.DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {
    private String grantType;
    private String accessToken;
    private Date accessTokenExpireTime;
    private String refreshToken;
}
