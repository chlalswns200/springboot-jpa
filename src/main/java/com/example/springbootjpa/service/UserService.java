package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.User;
import com.example.springbootjpa.domain.dao.UserAddRequest;
import com.example.springbootjpa.domain.dao.UserAddResponse;
import com.example.springbootjpa.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAddResponse getUser(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isEmpty()) {
            return new UserAddResponse(id, "", "해당 id의 유저가 없습니다");
        } else {
            User user = optUser.get();
            return new UserAddResponse(user.getId(), user.getUserName(), "유저입니다");
        }
    }

    public UserAddResponse addUser(UserAddRequest dto) {
        User byUserName = userRepository.findByUserName(dto.getUserName());
        if (byUserName == null) {
            User save = userRepository.save(dto.toEntity());
            return new UserAddResponse(save.getId(),save.getUserName(),"회원 등록 성공");
        } else {
            return new UserAddResponse(null,null,"이미 존재하는 회원입니다");
        }
    }
}
