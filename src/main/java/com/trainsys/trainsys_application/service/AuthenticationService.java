package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.dto.LoginUserDto;
import com.trainsys.trainsys_application.dto.RegisterUserDto;
import com.trainsys.trainsys_application.entity.UserEntity;

public interface AuthenticationService {
    UserEntity signUp(RegisterUserDto input);
    UserEntity authenticate(LoginUserDto input);
}
