package com.example.demo.dto.res;

import com.example.demo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
public class StudentRes {
    private Long id;
    private String name;
    private Date dob;

    public static StudentRes toJson(Student student){
        return new StudentRes(student.getId(),
                student.getName(),
                student.getDob()
        );
    }
}
