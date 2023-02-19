package com.example.crud_backend.DTO;

import com.example.crud_backend.domain.Posts;
import lombok.*;
@NoArgsConstructor
@Getter
public class PostRequestDTO {
    private String title;
    private String category;
    private String content;
    @Builder
    public PostRequestDTO (String title, String category, String content) {
        this.title=title;
        this.category=category;
        this.content=content;
    }

    //Entity로 변환
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .category(category)
                .content(content)
                .build();
    }
}
