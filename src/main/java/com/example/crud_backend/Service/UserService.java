package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.UserRequestDTO;
import com.example.crud_backend.domain.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public String enroll(UserRequestDTO requestDTO) {
        return userRepository.save(requestDTO.toEntity()).getId();
    }
}
