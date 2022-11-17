package com.example.springbootjpa.repository;

import com.example.springbootjpa.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByName() {
        String str = "userC";
        User byUserName = userRepository.findByUserName(str);
        System.out.println("byUserName.getId() = " + byUserName.getId());
        System.out.println("byUserName.getUserName() = " + byUserName.getUserName());
        System.out.println("byUserName.getPassword() = " + byUserName.getPassword());

    }

}