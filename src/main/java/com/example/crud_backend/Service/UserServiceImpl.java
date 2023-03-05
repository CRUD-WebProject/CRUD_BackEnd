package com.example.crud_backend.Service;

import com.example.crud_backend.DAO.UserDAO;
import com.example.crud_backend.DTO.ChangePwDTO;
import com.example.crud_backend.DTO.LoginRequestDTO;
import com.example.crud_backend.DTO.UserDTO;
import com.example.crud_backend.Exception.APICustomException;
import com.example.crud_backend.Exception.ErrorCodes;
import com.example.crud_backend.config.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;
    private final JwtTokenProvider jwtTokenProvider;
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
    public void changePW(ChangePwDTO changePwDTO) {
        userDAO.changePW(changePwDTO);
    }

    @Override
    public String createToken(LoginRequestDTO loginRequestDTO) {
        UserDTO userDTO;
        try {
            userDTO = userDAO.getInfo(loginRequestDTO.getId());
            if(!loginRequestDTO.getPw().equals(userDTO.getPw())) throw new APICustomException(ErrorCodes.FAIL_LOGIN);
        } catch (NullPointerException exception) {
            throw new APICustomException(ErrorCodes.FAIL_LOGIN);
        }
        return jwtTokenProvider.createToken(userDTO.getId());
    }
}
