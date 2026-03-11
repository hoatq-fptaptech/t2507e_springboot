package com.example.demo.controller;

import com.example.demo.dto.req.StudentReq;
import com.example.demo.dto.res.StudentRes;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public StudentRes findStudentById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @PostMapping()
    public StudentRes createStudent(@RequestBody StudentReq req){
        return studentService.create(req);
    }
}
