package com.example.crud_backend.Controller;

import com.example.crud_backend.DTO.UserRequestDTO;
import com.example.crud_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("enroll")
    public String enroll(@RequestBody UserRequestDTO requestDTO) {
        return userService.enroll(requestDTO);
    }
}
