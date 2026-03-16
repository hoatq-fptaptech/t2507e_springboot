package com.example.demo.common;

import com.example.demo.dto.common.ResponseDTO;
import com.example.demo.enums.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static <T> ResponseEntity<ResponseDTO<T>> success(
            T data,String customMessage){
        ResponseDTO<T> dto = new ResponseDTO<>(
                StatusCode.SUCCESS.getCode(),
                customMessage != null? customMessage:
                            StatusCode.SUCCESS.getMessage(),
                data
        );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    public static <T> ResponseEntity<ResponseDTO<T>> error(
            StatusCode status, String customMessage){
        ResponseDTO<T> dto = new ResponseDTO<>(
                status.getCode(),
                customMessage != null? customMessage:
                        StatusCode.SUCCESS.getMessage(),
                null
        );
        return ResponseEntity.status(status.getHttpStatus()).body(dto);
    }
}
