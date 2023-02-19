package com.example.crud_backend.DTO;

import com.example.crud_backend.domain.Comments;
import lombok.*;

@NoArgsConstructor
@Getter
public class CommentRequestDTO {
    private Long PostID;
    private String id;
    private String content;

    @Builder
    public CommentRequestDTO (Long PostID, String id, String content) {
        this.PostID=PostID;
        this.id=id;
        this.content=content;
    }

    public Comments toEntity() {
        return Comments.builder()
                .PostID(PostID)
                .id(id)
                .content(content)
                .build();
    }
}
