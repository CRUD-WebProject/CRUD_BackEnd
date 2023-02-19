package com.example.crud_backend.domain;

import com.example.crud_backend.domain.Posts;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public abstract class MemoryPostRepository implements PostRepository {
    private static Map<Long, Posts> list = new HashMap<>();

    @Override
    public Posts save(Posts post) {
        list.put(post.getPostID(), post);
        return post;
    }
}
