package com.example.crud_backend.domain;

import com.example.crud_backend.domain.Users;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public abstract class MemoryUserRepository implements UserRepository {
    private static Map<String, Users> list = new HashMap<>();

    @Override
    public Users save(Users user) {
        list.put(user.getId(), user);
        return user;
    }
}
