package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.User;
import com.example.springbootjpa.domain.dao.UserAddRequest;
import com.example.springbootjpa.domain.dao.UserAddResponse;
import com.example.springbootjpa.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserServiceTest {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository); //수동 DI
    }

    @Test
    @DisplayName("회원 등록 성공 메세지가 나오는지")
    void addTest() {
        Mockito.when(userRepository.save(any()))
                .thenReturn(new User(1l, "chlalswns", "1q2w3e4r"));

        UserAddResponse userResponse = userService.addUser(new UserAddRequest("chlalswns", "1q2w3e4r"));
        assertEquals("chlalswns", userResponse.getUserName());
        assertEquals("회원 등록 성공", userResponse.getComment());

    }

}