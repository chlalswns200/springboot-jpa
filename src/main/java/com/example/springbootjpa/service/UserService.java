package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.User;
import com.example.springbootjpa.domain.dao.UserAddRequest;
import com.example.springbootjpa.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserAddRequest dto) {
        User byUserName = userRepository.findByUserName(dto.getUserName());
        if (byUserName == null) {
            User save = userRepository.save(dto.toEntity());
            return save;
        } else {
            return new User();
        }
    }
}
