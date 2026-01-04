package com.example.demo.controller;

import com.example.demo.dto.SubjectDTO;
import com.example.demo.entities.Student;
import com.example.demo.entities.Subjects;
import com.example.demo.repository.StudentManager;
import com.example.demo.repository.SubjectManager;
import com.example.demo.service.StudentService;
import com.example.demo.service.SubjectService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SubjectController {


    // to store a specific subject and marks for a particular student

    SubjectService subjectService;
    StudentService studentService;

    public SubjectController(SubjectService subjectService , StudentService studentService) {
        this.subjectService = subjectService;
        this.studentService = studentService;
    }

    @PostMapping("subjects/{stu_id}")
    public void addMarks(@PathVariable Integer stu_id , @RequestBody SubjectDTO subjectDTO)
    {
        Optional<Student> student = studentService.findStudentById(stu_id);

        if( student.isPresent() )
            subjectService.addSubject(subjectDTO  , student.get());


    }


}
