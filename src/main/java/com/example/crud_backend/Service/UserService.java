package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.*;

import java.util.Optional;

public interface UserService {
    Optional<UserDTO> getInfo(String id);
    void enrollUser(UserDTO userDTO);
    void updateUser(String id, UserDTO userDTO);
    void deleteUser(String id, String pw);
    String checkExist(String id);
    String findID(String name, String phone, String email);
    String findPW(String id, String name);
    void changePW(ChangePwDTO changePwDTO);
    TokenDTO login(LoginDTO loginDTO);
    TokenDTO refresh(TokenDTO tokenDTO);
}