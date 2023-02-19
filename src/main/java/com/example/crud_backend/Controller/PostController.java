package com.example.crud_backend.Controller;
import com.example.crud_backend.DTO.PostRequestDTO;
import com.example.crud_backend.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("post")
public class PostController {
    private final PostService postsService;

    @Autowired
    public PostController(PostService postsService) {
        this.postsService=postsService;
    }

    @PostMapping("write") //요청이 들어오면
    public Long write(@RequestBody PostRequestDTO requestDTO) { //dto에 내용을 담아서 가져와
        return postsService.write(requestDTO); //Service의 write 메소드로 넘겨줌
    }
}
