package com.chunjae.teacherservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teacher")
public class Teacher {

    @GetMapping("/teacherReg")
    public String TeacherReg(){
        return "등록";
    }
    
}
