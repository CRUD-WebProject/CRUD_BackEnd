package com.example.crud_backend.Controller;

import com.example.crud_backend.Service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;

    @GetMapping("/check")
    public boolean check(@RequestParam("postID") Long postID, @RequestParam("id") String id) {
        if(likesService.find(postID, id) == null) return false;
        else return true;
    }
}
