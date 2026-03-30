package com.example.demo.controller;

import com.example.demo.common.ResponseHandler;
import com.example.demo.dto.common.ResponseDTO;
import com.example.demo.dto.req.RegisterUser;
import com.example.demo.enums.StatusCode;
import com.example.demo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    public final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<Boolean>> register(
            @RequestBody RegisterUser req){
        try{
            return ResponseHandler.success(authService.register(req),
                    "Register successfully");
        }catch (Exception e){
            return ResponseHandler.error(StatusCode.BAD_REQUEST,e.getMessage());
        }
    }
}
