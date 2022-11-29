package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.dao.UserAddRequest;
import com.example.springbootjpa.domain.dao.UserAddResponse;
import com.example.springbootjpa.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(UserRestControllerTest.class)

class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    @DisplayName("입력한 id로 조회가 잘 되는지")
    void findById() throws Exception {

        given(userService.getUser(1l)).willReturn(new UserAddResponse(1l, "chlalswns", "유저입니다"));

        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.comment").value("유저입니다"))
                .andDo(print());
    }

    @Test
    @DisplayName("입력한 id로 조회 실패")
    void findByIdFail() throws Exception {

        given(userService.getUser(2l)).willReturn(new UserAddResponse(null, "", "해당 id의 유저가 없습니다"));

        mockMvc.perform(get("/api/v1/users/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isEmpty())
                .andExpect(jsonPath("$.comment").value("해당 id의 유저가 없습니다"))
                .andDo(print());
    }

    @Test
    @DisplayName("생성이 잘되는지")
    void addUser() throws Exception{

    }
}