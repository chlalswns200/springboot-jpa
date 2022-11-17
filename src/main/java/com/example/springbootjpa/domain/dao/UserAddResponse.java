package com.example.springbootjpa.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAddResponse {

    private String userName;
    private String password;
}
