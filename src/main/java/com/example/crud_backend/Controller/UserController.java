package com.example.crud_backend.Controller;

import com.example.crud_backend.DTO.UserDTO;
import com.example.crud_backend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/info")
    public UserDTO getInfo(@RequestParam("id") String id) {
        return userService.getInfo(id);
    }

    @PostMapping("/enroll")
    public ResponseEntity<HttpStatus> enrollUser(@RequestBody UserDTO userDTO) {
        userService.enrollUser(userDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateUser(@RequestParam("id") String id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        userService.deleteUser(id, pw);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/exist")
    public Boolean checkExist(@RequestParam("id") String id) {
        if(userService.checkExist(id) == null) return false;
        else return true;
    }

    @GetMapping("/findID")
    public String findID(@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("email") String email) {
        String id = userService.findID(name, phone, email);
        if(id == null) return "";
        else return id;
    }

    @GetMapping("/findPW")
    public Boolean findPW(@RequestParam("id") String id, @RequestParam("name") String name) {
        if(userService.findPW(id, name) == null) return false;
        else return true;
    }
    @PutMapping("/changePW")
    public ResponseEntity<HttpStatus> changePW(@RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("check") String check) {
        if(!pw.equals(check)) return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        else {
            userService.changePW(id, pw);
            return ResponseEntity.ok().body(HttpStatus.OK);
        }
    }
    @PutMapping("/changePW_user")
    public ResponseEntity<HttpStatus> changePW_user(@RequestParam("id") String id, @RequestParam("cur_pw") String cur_pw, @RequestParam("pw") String pw, @RequestParam("check") String check) {
        if(cur_pw.equals(pw)) return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        else if(!pw.equals(check)) return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        else {
            userService.changePW_user(id, pw);
            return ResponseEntity.ok().body(HttpStatus.OK);
        }
    }


}
