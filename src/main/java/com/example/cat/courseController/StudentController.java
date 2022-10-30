package com.example.cat.courseController;


import com.example.cat.StundentService.StudentService;
import com.example.cat.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public List<Student> getStudents(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(name="id") int studentId){
        return studentService.getStudent(studentId);
    }

}
