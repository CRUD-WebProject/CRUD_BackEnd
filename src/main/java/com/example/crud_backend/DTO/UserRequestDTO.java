package com.example.crud_backend.DTO;

import com.example.crud_backend.domain.Users;
import lombok.*;
@NoArgsConstructor
@Getter
public class UserRequestDTO {
    private String id;
    private String name;
    private String pw;
    private String sex;
    private int age;
    private String phone;
    private String email;

    @Builder
    public UserRequestDTO (String id, String name, String pw, String sex, int age, String phone, String email) {
        this.id=id;
        this.name=name;
        this.pw=pw;
        this.sex=sex;
        this.age=age;
        this.phone=phone;
        this.email=email;
    }

    public Users toEntity() {
        return Users.builder()
                .id(id)
                .name(name)
                .pw(pw)
                .sex(sex)
                .age(age)
                .phone(phone)
                .email(email)
                .build();
    }
}
