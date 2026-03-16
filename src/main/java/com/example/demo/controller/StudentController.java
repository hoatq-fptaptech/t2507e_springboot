package com.example.demo.controller;

import com.example.demo.common.ResponseHandler;
import com.example.demo.dto.common.ResponseDTO;
import com.example.demo.dto.req.StudentReq;
import com.example.demo.dto.res.StudentRes;
import com.example.demo.enums.StatusCode;
import com.example.demo.service.StudentService;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@CrossOrigin(origins = "*")
public class StudentController {
    private StudentService studentService;

    @GetMapping()
//    public List<StudentRes> getAllStudents(){
//        return studentService.getAllStudents();
//    }
    public ResponseEntity<ResponseDTO<List<StudentRes>>> getAllStudents(){
        try {
            return ResponseHandler.success(studentService.getAllStudents(),"Thành công!");
        }catch (Exception e){
            return ResponseHandler.error(StatusCode.BAD_REQUEST,e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<StudentRes>> findStudentById(
            @PathVariable Long id){
        try {
            return ResponseHandler.success(studentService.findById(id),"Thành công!");
        }catch (Exception e){
            return ResponseHandler.error(StatusCode.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO<StudentRes>> createStudent(@RequestBody StudentReq req){
        try {
            return ResponseHandler.success(studentService.create(req), "Thành công!");
        }catch (ValidationException v){
            return ResponseHandler.error(StatusCode.VALIDATION_ERROR,v.getMessage());
        }catch (Exception e){
            return ResponseHandler.error(StatusCode.BAD_REQUEST,e.getMessage());
        }
    }
}
