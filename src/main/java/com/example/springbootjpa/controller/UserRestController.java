package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.User;
import com.example.springbootjpa.domain.dao.UserAddRequest;
import com.example.springbootjpa.domain.dao.UserAddResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootjpa.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserAddResponse>findOne(@PathVariable Long id) {
        UserAddResponse user = userService.getUser(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/new")
    public ResponseEntity<UserAddResponse> add(@RequestBody UserAddRequest dto) {
        User user = userService.addUser(dto);
        if (user.getId() != null) {
            return ResponseEntity.ok().body(new UserAddResponse(user.getId(),user.getUserName(), "유저 등록 완료"));
        } else {
            return ResponseEntity.ok().body(new UserAddResponse(null,"이미 사용중인 userName입니다"));
        }
    }
}
