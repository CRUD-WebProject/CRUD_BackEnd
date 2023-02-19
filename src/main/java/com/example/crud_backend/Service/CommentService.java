package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.CommentRequestDTO;
import com.example.crud_backend.domain.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository=commentRepository;
    }

    @Transactional
    public Long write (CommentRequestDTO requestDTO) {
        return commentRepository.save(requestDTO.toEntity()).getPostID();
    }
}
