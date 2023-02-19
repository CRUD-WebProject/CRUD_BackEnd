package com.example.crud_backend.Controller;

import com.example.crud_backend.DTO.UserRequestDTO;
import com.example.crud_backend.Service.UserService;
import com.example.crud_backend.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //Bean 주입 -> @Autowired 대신 생성자로 사용
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping("enroll")
    public String enroll(@RequestBody UserRequestDTO requestDTO) {
        return userService.enroll(requestDTO);
    }
}
