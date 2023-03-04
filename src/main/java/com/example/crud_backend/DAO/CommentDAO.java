package com.example.crud_backend.DAO;

import com.example.crud_backend.DTO.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CommentDAO {
    List<CommentDTO> getComments(Long postID);
    void writeComment(@Param("commentDTO") CommentDTO commentDTO);
    void updateComment(@Param("commentDTO") CommentDTO commentDTO);
    void deleteComment(Long postID, Long comID);
}
