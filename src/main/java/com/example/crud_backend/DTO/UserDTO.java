package com.example.crud_backend.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String pw;
    private String sex;
    private int age;
    private String phone;
    private String email;

}
