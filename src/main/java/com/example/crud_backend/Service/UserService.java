package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.ChangePwDTO;
import com.example.crud_backend.DTO.LoginRequestDTO;
import com.example.crud_backend.DTO.UserDTO;

public interface UserService {
    UserDTO getInfo(String id);
    void enrollUser(UserDTO userDTO);
    void updateUser(String id, UserDTO userDTO);
    void deleteUser(String id, String pw);
    String checkExist(String id);
    String findID(String name, String phone, String email);
    String findPW(String id, String name);
    void changePW(ChangePwDTO changePwDTO);
    String createToken(LoginRequestDTO loginRequestDTO);
}