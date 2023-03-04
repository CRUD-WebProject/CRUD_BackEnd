package com.example.crud_backend.DTO;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long comID;
    private Long postID;
    private String id;
    private String content;
    private LocalDateTime com_time;

    @Builder
    public CommentDTO(Long postID, String id, String content) {
        this.postID=postID;
        this.id=id;
        this.content=content;
    }
}
