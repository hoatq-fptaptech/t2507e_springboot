package com.example.demo.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginUser {
    @NotBlank(message = "Please enter email...")
    private String email;
    @NotBlank(message = "Please enter password")
    private String password;
}
