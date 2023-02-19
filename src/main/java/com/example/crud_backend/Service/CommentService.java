package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.CommentRequestDTO;
import com.example.crud_backend.domain.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Long write (CommentRequestDTO requestDTO) {
        return commentRepository.save(requestDTO.toEntity()).getPostID();
    }
}
