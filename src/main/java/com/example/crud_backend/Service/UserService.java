package com.example.crud_backend.Service;
import com.example.crud_backend.DTO.UserRequestDTO;
import com.example.crud_backend.domain.UserRepository;
import com.example.crud_backend.domain.MemoryUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    @Transactional
    public String enroll(UserRequestDTO requestDTO) {
        return userRepository.save(requestDTO.toEntity()).getId();
    }
}
