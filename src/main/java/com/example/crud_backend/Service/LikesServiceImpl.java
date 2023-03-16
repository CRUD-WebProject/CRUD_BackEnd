package com.example.crud_backend.Service;

import com.example.crud_backend.DAO.LikesDAO;
import com.example.crud_backend.DTO.LikesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesServiceImpl implements LikesService {
    private final LikesDAO likesDAO;
    public String find(Long postID, String id) {
        return likesDAO.find(postID, id);
    }
    public void like(LikesDTO likesDTO) {
        likesDAO.like(likesDTO);
    }

    public void like_cancel(LikesDTO likesDTO) {
        likesDAO.like_cancel(likesDTO);
    }
}
