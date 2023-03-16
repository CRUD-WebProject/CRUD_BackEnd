package com.example.crud_backend.Controller;
import com.example.crud_backend.DTO.LikesDTO;
import com.example.crud_backend.DTO.PostDTO;
import com.example.crud_backend.Service.LikesService;
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
    private final LikesService likesService;

    @GetMapping("/list")
    public List<PostDTO> getPostList(@RequestParam("category") String category) {
        if(category.equals("전체")) return postService.getPostList();
        else return postService.getPostListByType(category);
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
    public ResponseEntity<HttpStatus> like(@RequestBody LikesDTO likesDTO) {
        postService.like(likesDTO.getPostID());
        likesService.like(likesDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PostMapping("/like_cancel")
    public ResponseEntity<HttpStatus> like_cancel(@RequestBody LikesDTO likesDTO) {
        postService.like_cancel(likesDTO.getPostID());
        likesService.like_cancel(likesDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
