package com.example.demo.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
@Getter
@Setter
public class StudentReq {
    private Long id;
    @NotBlank(message = "Input student's name pls!")
    @Min(value = 3, message = "Input string min 3 characters!")
    private String name;
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @NotNull(message = "Input student's mark!")
    @Min(0)
    @Max(10)
    private Integer mark;
    @NotNull
    private Long groupId;
}
