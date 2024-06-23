package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.dto.LoginUserDto;
import com.trainsys.trainsys_application.dto.RegisterUserDto;
import com.trainsys.trainsys_application.entity.RoleEntity;
import com.trainsys.trainsys_application.entity.RoleEnum;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.repository.PlanRepository;
import com.trainsys.trainsys_application.repository.RoleRepository;
import com.trainsys.trainsys_application.repository.UserRepository;
import com.trainsys.trainsys_application.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PlanRepository planRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository, PlanRepository planRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.planRepository = planRepository;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity signUp(RegisterUserDto input) {
        Optional<RoleEntity> optionalRole = roleRepository.findByName(RoleEnum.USER);

        if (optionalRole.isEmpty()) {
            return null;
        }

        var user = new UserEntity();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setDateBirth(input.getDateBirth());
        user.setCpf(input.getCpf());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setPlan(planRepository.findByName(input.getPlan()));
        user.setRole(optionalRole.get());

        return userRepository.save(user);
    }

    public UserEntity authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }

    public List<UserEntity> allUsers() {
        return userRepository.findAll();
    }
}
