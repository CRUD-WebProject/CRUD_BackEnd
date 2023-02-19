package com.example.crud_backend.DTO;

import com.example.crud_backend.domain.Users;
import lombok.Getter;

@Getter
public class UserResponseDTO {
    private String id;
    private String name;
    private String pw;
    private String sex;
    private int age;
    private String phone;
    private String email;

    public UserResponseDTO (Users entity) {
        this.id=entity.getId();
        this.name=entity.getName();
        this.pw=entity.getPw();
        this.sex=entity.getSex();
        this.age=entity.getAge();
        this.phone=entity.getPhone();
        this.email=entity.getEmail();
    }
}
