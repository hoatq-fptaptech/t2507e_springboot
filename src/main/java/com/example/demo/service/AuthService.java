package com.example.demo.service;

import com.example.demo.dto.req.LoginUser;
import com.example.demo.dto.req.RegisterUser;
import com.example.demo.dto.res.LoginResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public boolean register(RegisterUser input){
        User user = new User();
        user.setEmail(input.getEmail());
        user.setFullName(input.getFullName());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        userRepository.save(user);
        return true;
    }

    public LoginResponse authenticate(LoginUser input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        User user = userRepository.findByEmail(input.getEmail());
        if(user == null)
            throw new UsernameNotFoundException("Email or password is not correct");
        String jwtToken = jwtService.generateToken(user);
        LoginResponse rs = new LoginResponse();
        rs.setToken(jwtToken);
        return rs;
    }
}
