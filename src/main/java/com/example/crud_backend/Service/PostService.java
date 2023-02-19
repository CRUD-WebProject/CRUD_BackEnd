package com.example.crud_backend.Service;

import com.example.crud_backend.DTO.PostRequestDTO;
import com.example.crud_backend.domain.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository=postRepository;
    }

    @Transactional  //메소드 실행 시 트랜잭션 시작 -> 성공 시 커밋 / 실패 시 롤백
    public Long write(PostRequestDTO requestDTO) {
        return postRepository.save(requestDTO.toEntity()).getPostID(); //dto를 받아와 entity화 시킨 뒤 저장하고, 그의 PostID를 받아옴
    }
}
