package com.example.crud_backend.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {
    private String accessToken;
    private String grantType;
    private Long expireTime;
}
