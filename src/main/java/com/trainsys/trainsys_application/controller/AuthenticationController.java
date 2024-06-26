package com.trainsys.trainsys_application.controller;

import com.trainsys.trainsys_application.dto.RegisterUserDto;
import com.trainsys.trainsys_application.dto.LoginUserDto;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.LoginResponse;
import com.trainsys.trainsys_application.response.SignUpResponse;
import com.trainsys.trainsys_application.service.AuthenticationService;
import com.trainsys.trainsys_application.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> register(@RequestBody RegisterUserDto registerUserDto) {
        SignUpResponse signUpResponse = authenticationService.signUp(registerUserDto);
        return new ResponseEntity<>(signUpResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse()
                .setToken(jwtToken)
                .setExpiresIn(jwtService.getExpirationTime())
                .setName(authenticatedUser.getName());

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
