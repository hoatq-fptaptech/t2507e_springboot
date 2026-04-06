package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum Role {
    USER(0),
    ADMIN(1);
    private final int value;

    public static Role fromValue(int value){
        for(Role r: values()){
            if(r.getValue() == value) return r;
        }
        throw new RuntimeException("Invalid role");
    }
}
