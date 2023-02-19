package com.example.crud_backend.Controller;

import com.example.crud_backend.DTO.CommentRequestDTO;
import com.example.crud_backend.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService=commentService;
    }

    @PostMapping("write")
    public Long write (CommentRequestDTO requestDTO) {
        return commentService.write(requestDTO);
    }
}
