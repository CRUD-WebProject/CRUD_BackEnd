package com.example.crud_backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Comments {
    @Id @Column(length=50, nullable=false)
    private Long PostID;
    @Column(length=20, nullable=false)
    private String id;
    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;
    private LocalDateTime com_time;

    @Builder
    public Comments(Long PostID, String id, String content) {
        this.PostID= PostID;
        this.id=id;
        this.content=content;
        this.com_time=LocalDateTime.now();
    }
}
