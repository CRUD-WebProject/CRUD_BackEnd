package com.example.crud_backend.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangePwDTO {
    String id;
    String pw;
}
