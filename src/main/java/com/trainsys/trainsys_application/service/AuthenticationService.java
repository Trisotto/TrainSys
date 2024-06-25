package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.dto.LoginUserDto;
import com.trainsys.trainsys_application.dto.RegisterUserDto;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.SignUpResponse;

public interface AuthenticationService {
    SignUpResponse signUp(RegisterUserDto input);
    UserEntity authenticate(LoginUserDto input);
}
