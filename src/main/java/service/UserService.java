package service;

import domain.User;
import domain.dao.UserAddRequest;
import domain.dao.UserAddResponse;
import repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserAddRequest dto) {
        userRepository.findByUserName(dto.getUserName());
        User save = userRepository.save(dto.toEntity());
        return save;
    }
}
