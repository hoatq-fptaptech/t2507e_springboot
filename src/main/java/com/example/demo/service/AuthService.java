package com.example.demo.service;

import com.example.demo.dto.req.RegisterUser;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean register(RegisterUser input){
        User user = new User();
        user.setEmail(input.getEmail());
        user.setFullName(input.getFullName());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        userRepository.save(user);
        return true;
    }
}
