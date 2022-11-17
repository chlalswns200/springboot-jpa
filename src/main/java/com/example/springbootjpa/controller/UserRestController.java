package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.User;
import com.example.springbootjpa.repository.UserRepository;
import com.example.springbootjpa.domain.dao.UserAddRequest;
import com.example.springbootjpa.domain.dao.UserAddResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootjpa.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/articles")
public class UserRestController {

    private final UserService userService;

    private final UserRepository userRepository;

    public UserRestController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>findOne(@PathVariable Long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok().body(byId.get());
        } else {
            return ResponseEntity.ok().body(new User("해당 id의 유저는 없습니다","0"));
        }
    }

    @PostMapping("/new")
    public ResponseEntity<UserAddResponse> add(@RequestBody UserAddRequest dto) {
        User user = userService.addUser(dto);
        if (user.getId() != null) {
            return ResponseEntity.ok().body(new UserAddResponse(user.getUserName(), user.getPassword()));
        } else {
            return ResponseEntity.ok().body(new UserAddResponse("이미 사용중인 userName 입니다.","0"));
        }
    }
}
