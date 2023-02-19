package com.example.crud_backend.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Entity
public class Users {
    @Id
    private String id;
    @Column(length=20, nullable=false)
    private String name;
    @Column(length=20, nullable=false)
    private String pw;
    @Column(length=1, nullable=false)
    private String sex;
    @Column(nullable=false)
    private int age;
    private String phone;
    private String email;

    @Builder
    public Users (String id, String name, String pw, String sex, int age, String phone, String email) {
        this.id=id;
        this.name=name;
        this.pw=pw;
        this.sex=sex;
        this.age=age;
        this.phone=phone;
        this.email=email;
    }
}
