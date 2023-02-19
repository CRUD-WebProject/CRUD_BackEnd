package com.example.crud_backend.DTO;
import com.example.crud_backend.domain.Comments;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDTO {
    private Long PostID;
    private String id;
    private String content;
    private LocalDateTime com_time;

    public CommentResponseDTO (Comments entity) {
        this.PostID=entity.getPostID();
        this.id=entity.getId();
        this.content=entity.getContent();
        this.com_time=entity.getCom_time();
    }
}
