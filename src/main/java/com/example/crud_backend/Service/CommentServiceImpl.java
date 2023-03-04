package com.example.crud_backend.Service;

import com.example.crud_backend.DAO.CommentDAO;
import com.example.crud_backend.DTO.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;
    @Override
    public List<CommentDTO> getComments(Long postID) {
        return commentDAO.getComments(postID);
    }
    @Override
    public void writeComment(CommentDTO commentDTO) {
        commentDAO.writeComment(commentDTO);
    }
    @Override
    public void updateComment(CommentDTO commentDTO) {
        commentDAO.updateComment(commentDTO);
    }
    @Override
    public void deleteComment(Long postID, Long comID) {
        commentDAO.deleteComment(postID, comID);
    }
}
