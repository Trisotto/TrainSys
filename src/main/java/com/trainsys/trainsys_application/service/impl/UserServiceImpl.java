package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.repository.UserRepository;
import com.trainsys.trainsys_application.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> allUsers() {

        return new ArrayList<>(userRepository.findAll());
    }
}
