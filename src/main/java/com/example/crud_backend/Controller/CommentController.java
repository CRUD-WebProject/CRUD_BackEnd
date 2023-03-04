package com.example.crud_backend.Controller;

import com.example.crud_backend.DTO.CommentDTO;
import com.example.crud_backend.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/get")
    public List<CommentDTO> getComments(@RequestParam("postID") Long postID) {
        return commentService.getComments(postID);
    }

    @PostMapping("/write")
    public ResponseEntity<HttpStatus> writeComment(@RequestBody CommentDTO commentDTO) {
        commentDTO.setCom_time(LocalDateTime.now());
        commentService.writeComment(commentDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateComment(@RequestBody CommentDTO commentDTO) {
        commentService.updateComment(commentDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteComment(@RequestParam("postID") Long postID, @RequestParam("comID") Long comID) {
        commentService.deleteComment(postID, comID);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
