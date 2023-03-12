package com.example.crud_backend.Service;

import com.example.crud_backend.DAO.UserDAO;
import com.example.crud_backend.DTO.*;
import com.example.crud_backend.config.Jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;
    private final AuthenticationManagerBuilder managerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Override
    public Optional<UserDTO> getInfo(String id) {return userDAO.getInfo(id);
    }
    @Override
    public void enrollUser(UserDTO userDTO) {
        userDTO.setPw(passwordEncoder.encode(userDTO.getPw()));
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
    public String findPW(String id, String name) {
        return userDAO.findPW(id, name);
    }
    @Override
    public void changePW(ChangePwDTO changePwDTO) {
        changePwDTO.setPw(passwordEncoder.encode(changePwDTO.getPw()));
        userDAO.changePW(changePwDTO);
    }
    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = loginDTO.toAuthentication();

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateToken(authentication);
    }
}
