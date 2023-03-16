package com.example.crud_backend.Service;

import com.example.crud_backend.DAO.RefreshTokenDAO;
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
    private final RefreshTokenDAO refreshTokenDAO;

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
        TokenDTO tokenDTO = tokenProvider.generateToken(authentication);
        RefreshTokenDTO refreshTokenDTO = RefreshTokenDTO.builder()
                .key(authentication.getName())
                .value(tokenDTO.getRefreshToken())
                .build();
        if(refreshTokenDAO.findByKey(authentication.getName()) == null)
            refreshTokenDAO.save(refreshTokenDTO);
        else
            refreshTokenDAO.update(refreshTokenDTO);
        return tokenDTO;
    }

    @Override
    public TokenDTO refresh(TokenDTO tokenDTO) {
        // 1. Refresh Token 검증
        if (!tokenProvider.validateToken(tokenDTO.getRefreshToken())) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }
        // 2. Access Token 에서 Member ID 가져오기
        Authentication authentication = tokenProvider.getAuthentication(tokenDTO.getAccessToken());
        // 3. 저장소에서 Member ID 를 기반으로 Refresh Token 값 가져옴
        String rt_value = refreshTokenDAO.findByKey(authentication.getName());
        if(rt_value == null) {
            throw new RuntimeException("로그아웃 된 사용자입니다.");
        }
        // 4. Refresh Token 일치하는지 검사
        if (!rt_value.equals(tokenDTO.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }
        RefreshTokenDTO refreshTokenDTO = RefreshTokenDTO.builder()
                .key(authentication.getName())
                .value(rt_value)
                .build();
        // 5. 새로운 토큰 생성
        TokenDTO newTokenDTO = tokenProvider.generateToken(authentication);
        // 6. 저장소 정보 업데이트
        RefreshTokenDTO newRefreshTokenDTO = refreshTokenDTO.refreshValue(newTokenDTO.getRefreshToken());
        if(refreshTokenDAO.findByKey(authentication.getName()) == null)
            refreshTokenDAO.save(newRefreshTokenDTO);
        else
            refreshTokenDAO.update(newRefreshTokenDTO);

        return newTokenDTO;
    }
}
