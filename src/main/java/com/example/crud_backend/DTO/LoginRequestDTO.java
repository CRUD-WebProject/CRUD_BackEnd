package com.example.crud_backend.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    private String id;
    private String pw;
}
