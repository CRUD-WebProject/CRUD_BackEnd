package com.example.crud_backend.DAO;

import com.example.crud_backend.DTO.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PostDAO {
    List<PostDTO> getPostList();
    List<PostDTO> getPostListByType(String category);
    PostDTO getPost(Long postID);
    void writePost(@Param("postDTO") PostDTO postDTO);
    void updatePost(Long postID, @Param("postDTO") PostDTO postDTO);
    void deletePost(Long postID);
    void like(Long postID);
    void like_cancel(Long postID);
    void unlike(Long postID);
    void unlike_cancel(Long postID);
}
