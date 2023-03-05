package com.example.crud_backend.DAO;

import com.example.crud_backend.DTO.ChangePwDTO;
import com.example.crud_backend.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
    UserDTO getInfo(String id);
    void enrollUser(@Param("userDTO") UserDTO userDTO);
    void updateUser(String id, @Param("userDTO") UserDTO userDTO);
    void deleteUser(String id, String pw);
    String checkExist(String id);
    String findID(String name, String phone, String email);
    String findPW(String id, String name);
    void changePW(@Param("changePwDTO") ChangePwDTO changePwDTO);
}
