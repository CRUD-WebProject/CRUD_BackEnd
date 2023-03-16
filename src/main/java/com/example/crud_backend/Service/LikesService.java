package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.LikesDTO;

public interface LikesService {
    String find(Long postID, String id);
    void like(LikesDTO likesDTO);
    void like_cancel(LikesDTO likesDTO);
}
