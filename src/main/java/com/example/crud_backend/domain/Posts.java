package com.example.crud_backend.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Posts {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PostID; //PK -> auto increment
    @Column(length=20, nullable=false)
    private String id;
    @Column(length=100, nullable=false)
    private String title;
    @Column(columnDefinition="TEXT", nullable=false)
    private String content;
    @Column(length=50, nullable=false)
    private String category;
    private LocalDateTime up_time;
    private int likes;
    private int unlikes;

    @Builder
    public Posts(String id, String title, String content, String category) {
        this.id=id;
        this.title=title;
        this.content=content;
        this.category=category;
        this.up_time=LocalDateTime.now();
        this.likes=0;
        this.unlikes=0;
    }

}
