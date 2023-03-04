package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.PostDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Transactional
@Component
public interface PostService{
    List<PostDTO> getPostList();
    PostDTO getPost(Long postID);
    void writePost(PostDTO postDTO);
    void updatePost(Long postID, PostDTO postDTO);
    void deletePost(Long postID);
    void like(Long postID);
    void like_cancel(Long postID);
    void unlike(Long postID);
    void unlike_cancel(Long postID);

}

