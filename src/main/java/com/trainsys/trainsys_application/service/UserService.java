package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> allUsers();
}
