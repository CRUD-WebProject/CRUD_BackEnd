package com.example.crud_backend.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikesDTO {
    private Long postID;
    private String id;
}
