package com.example.crud_backend.DAO;

import com.example.crud_backend.DTO.RefreshTokenDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface RefreshTokenDAO {
    String findByKey(String key);
    void save(@Param("refreshTokenDTO") RefreshTokenDTO refreshTokenDTO);
    void update(@Param("refreshTokenDTO") RefreshTokenDTO refreshTokenDTO);
}
