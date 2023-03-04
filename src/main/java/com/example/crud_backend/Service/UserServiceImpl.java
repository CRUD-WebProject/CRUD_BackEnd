package com.example.crud_backend.Service;

import com.example.crud_backend.DAO.UserDAO;
import com.example.crud_backend.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;
    @Override
    public UserDTO getInfo(String id) {
        return userDAO.getInfo(id);
    }
    @Override
    public void enrollUser(UserDTO userDTO) {
        userDAO.enrollUser(userDTO);
    }
    @Override
    public void updateUser(String id, UserDTO userDTO) {
        userDAO.updateUser(id, userDTO);
    }
    @Override
    public void deleteUser(String id, String pw) {
        userDAO.deleteUser(id, pw);
    }
    @Override
    public String checkExist(String id) {
        return userDAO.checkExist(id);
    }
    @Override public String findID(String name, String phone, String email) {
        return userDAO.findID(name, phone, email);
    }
    @Override
    public String findPW(String id, String name) {
        return userDAO.findPW(id, name);
    }
    @Override
    public void changePW(String id, String pw) {
        userDAO.changePW(id, pw);
    }
    @Override
    public void changePW_user(String id, String pw) { userDAO.changePW_user(id, pw); }
}
