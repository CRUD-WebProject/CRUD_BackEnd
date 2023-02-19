package com.example.crud_backend.Controller;
import com.example.crud_backend.DTO.PostRequestDTO;
import com.example.crud_backend.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor //Bean 주입 -> @Autowired 대신 생성자로 사용
@RestController
@RequestMapping("post")
public class PostController {
    private final PostService postsService;

    @PostMapping("write") //요청이 들어오면
    public Long write(@RequestBody PostRequestDTO requestDTO) { //dto에 내용을 담아서 가져와
        return postsService.write(requestDTO); //Service의 write 메소드로 넘겨줌
    }
}
