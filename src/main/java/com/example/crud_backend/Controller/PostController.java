package com.example.crud_backend.Controller;
import com.example.crud_backend.DTO.PostDTO;
import com.example.crud_backend.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public List<PostDTO> getPostList() {
        return postService.getPostList();
    }

    @GetMapping("/get")
    public PostDTO getPost(@RequestParam("postID") Long postID) {
        return postService.getPost(postID);
    }

    @PostMapping("/write") //요청이 들어오면
    public ResponseEntity<HttpStatus> writePost(@RequestBody PostDTO postDTO) {
        postDTO.setUp_time(LocalDateTime.now());
        postService.writePost(postDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updatePost(@RequestParam("postID") Long postID, @RequestBody PostDTO postDTO) {
        postService.updatePost(postID, postDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deletePost(@RequestParam("postID") Long postID) {
        postService.deletePost(postID);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PostMapping("/like")
    public ResponseEntity<HttpStatus> like(@RequestParam("postID") Long postID) {
        postService.like(postID);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PostMapping("/like_cancel")
    public ResponseEntity<HttpStatus> like_cancel(@RequestParam("postID") Long postID) {
        postService.like_cancel(postID);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PostMapping("/unlike")
    public ResponseEntity<HttpStatus> unlike(@RequestParam("postID") Long postID) {
        postService.unlike(postID);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PostMapping("/unlike_cancel")
    public ResponseEntity<HttpStatus> unlike_cancel(@RequestParam("postID") Long postID) {
        postService.unlike_cancel(postID);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
