package com.example.crud_backend.domain;

import com.example.crud_backend.domain.Comments;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public abstract class MemoryCommentRepository implements CommentRepository {
    private static Map<Long, Comments> list = new HashMap<>();

    @Override
    public Comments save(Comments comment) {
        list.put(comment.getPostID(), comment);
        return comment;
    }
}
