package com.example.crud_backend.Controller;

import com.example.crud_backend.DTO.LoginRequestDTO;
import com.example.crud_backend.DTO.TokenResponseDTO;
import com.example.crud_backend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login (@RequestBody LoginRequestDTO loginRequestDTO) {
        String token = userService.createToken(loginRequestDTO);
        return ResponseEntity.ok().body(new TokenResponseDTO(token, "bearer"));
    }
}
