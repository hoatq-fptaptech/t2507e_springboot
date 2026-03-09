package com.example.demo.controller;

import com.example.demo.dto.res.StudentRes;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping()
    public List<StudentRes> getAllStudents(){
        return studentService.getAllStudents();
    }
}
