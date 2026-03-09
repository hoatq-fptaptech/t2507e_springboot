package com.example.demo.service;

import com.example.demo.dto.res.StudentRes;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public List<StudentRes> getAllStudents(){
//        List<Student> rs = studentRepository.findAll();
//        List<StudentRes> data = new ArrayList<>();
//        for (Student s : rs){
//            StudentRes sr = StudentRes.toJson(s);
//            data.add(sr);
//        }
//        return data;

        return studentRepository.findAll()
                .stream()
                .map(StudentRes::toJson)
                .toList();
    }
}
