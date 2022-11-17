package com.example.springbootjpa.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAddResponse {

    private Long id;
    private String userName;
    private String comment;

    public UserAddResponse(String userName, String comment) {
        this.userName = userName;
        this.comment = comment;
    }
}
