package com.example.crud_backend.DTO;

import com.example.crud_backend.domain.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDTO {
    private Long PostID;
    private String id;
    private String title;
    private String content;
    private String category;
    private LocalDateTime up_time;
    private int likes;
    private int unlikes;

    public PostResponseDTO (Posts entity) {
        this.PostID=entity.getPostID();
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.category=entity.getCategory();
        this.up_time=entity.getUp_time();
        this.likes=entity.getLikes();
        this.unlikes=entity.getUnlikes();
    }
}
