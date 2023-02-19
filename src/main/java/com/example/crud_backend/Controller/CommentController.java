package com.example.crud_backend.Controller;

import com.example.crud_backend.DTO.CommentRequestDTO;
import com.example.crud_backend.DTO.CommentResponseDTO;
import com.example.crud_backend.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor //Bean 주입 -> @Autowired 대신 생성자로 사용
@RestController
@RequestMapping("comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("write")
    public Long write (CommentRequestDTO requestDTO) {
        return commentService.write(requestDTO);
    }
}
