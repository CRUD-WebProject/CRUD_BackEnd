package com.example.crud_backend.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long postID;
    private String id;
    private String title;
    private String content;
    private String category;
    private LocalDateTime up_time;
    private int likes;
    private int unlikes;
    @Builder
    public PostDTO(String id, String title, String content, String category) {
        this.id=id;
        this.title=title;
        this.content=content;
        this.category=category;
    }
}
