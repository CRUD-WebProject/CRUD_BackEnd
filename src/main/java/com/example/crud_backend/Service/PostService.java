package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.PostDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PostService{
    List<PostDTO> getPostList();
    List<PostDTO> getPostListByType(String category);
    PostDTO getPost(Long postID);
    void writePost(PostDTO postDTO);
    void updatePost(Long postID, PostDTO postDTO);
    void deletePost(Long postID);
    void like(Long postID);
    void like_cancel(Long postID);

}

