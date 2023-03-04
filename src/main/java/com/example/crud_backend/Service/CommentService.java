package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.CommentDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentService {
    List<CommentDTO> getComments(Long postID);
    void writeComment(CommentDTO commentDTO);
    void updateComment(CommentDTO commentDTO);
    void deleteComment(Long postID, Long comID);
}

