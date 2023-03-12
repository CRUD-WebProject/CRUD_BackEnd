package com.example.crud_backend.Service;

import com.example.crud_backend.DAO.UserDAO;
import com.example.crud_backend.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return userDAO.getInfo(id)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(id + " 을 DB에서 찾을 수 없습니다"));
    }

    private UserDetails createUserDetails(UserDTO userDTO) {
        return new User(
                String.valueOf(userDTO.getId()),
                userDTO.getPw(),
                Collections.singleton(new SimpleGrantedAuthority("user"))
        );
    }
}
