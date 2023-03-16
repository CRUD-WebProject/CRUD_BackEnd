package com.example.crud_backend.DAO;

import com.example.crud_backend.DTO.LikesDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LikesDAO {
    String find(Long postID, String id);
    void like(@Param("likesDTO") LikesDTO likesDTO);
    void like_cancel(@Param("likesDTO") LikesDTO likesDTO);
}
