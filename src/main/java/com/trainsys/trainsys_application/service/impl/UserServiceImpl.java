package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.repository.UserRepository;
import com.trainsys.trainsys_application.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
