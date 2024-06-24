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
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

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
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto) {
        try {
            UserEntity registeredUser = authenticationService.signUp(registerUserDto);
            SignUpResponse signUpResponse  = new SignUpResponse();
            signUpResponse.setName(registeredUser.getName());
            signUpResponse.setEmail(registeredUser.getEmail());
            signUpResponse.setDateBirth(registeredUser.getDateBirth());
            signUpResponse.setCpf(registeredUser.getCpf());
            signUpResponse.setPlanName(registeredUser.getPlan().getName());
            signUpResponse.setRoleDescription(registeredUser.getRole().getDescription());
            return new ResponseEntity<>(signUpResponse, HttpStatus.CREATED);
        } catch (Exception  e) {
            return new ResponseEntity<>(STR."Invalid request: \{e.getMessage()}", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginUserDto loginUserDto) {
        try{
            UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

            String jwtToken = jwtService.generateToken(authenticatedUser);

            LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime()).setName(authenticatedUser.getName());

            return ResponseEntity.ok(loginResponse);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(STR."Invalid request: \{e.getMessage()}", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(STR."Invalid request: \{e.getMessage()}", HttpStatus.BAD_REQUEST);
        }
    }
}
