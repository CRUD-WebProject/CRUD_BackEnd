package com.example.crud_backend.Service;

import com.example.crud_backend.DAO.PostDAO;
import com.example.crud_backend.DTO.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
    @Override
    public List<PostDTO> getPostList() {return postDAO.getPostList();}
    @Override
    public List<PostDTO> getPostListByType(String category) {
        return postDAO.getPostListByType(category);
    }
    @Override
    public PostDTO getPost(Long postID) {
        return postDAO.getPost(postID);
    }
    @Override
    public void writePost(PostDTO postDTO) {
        postDAO.writePost(postDTO);
    }
    @Override
    public void updatePost(Long postID, PostDTO postDTO) {
        postDAO.updatePost(postID, postDTO);
    }
    @Override
    public void deletePost(Long postID) {
        postDAO.deletePost(postID);
    }
    @Override
    public void like(Long postID) {
        postDAO.like(postID);
    }
    @Override
    public void like_cancel(Long postID) {
        postDAO.like_cancel(postID);
    }
    @Override
    public void unlike(Long postID) {
        postDAO.unlike(postID);
    }
    @Override
    public void unlike_cancel(Long postID) {
        postDAO.unlike_cancel(postID);
    }
}
