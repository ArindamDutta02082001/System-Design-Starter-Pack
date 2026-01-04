package com.example.demo.controller;


import com.example.demo.dto.StudentDTO;
import com.example.demo.entities.Subjects;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    // creating a  student
    @PostMapping("/students")
    public ResponseEntity<Integer> createStudent( @RequestBody StudentDTO studentDTO )
    {
        Integer sid =studentService.addStudent(studentDTO);
        if( sid == null )
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        return ResponseEntity.status(HttpStatus.CREATED).body(sid);
    }

    // update student details
    @PatchMapping("/students/{id}")
    public ResponseEntity.BodyBuilder updateStudent(
            @PathVariable Integer id,
            @RequestBody StudentDTO studentDTO) {

        studentService.updateStudent(id, studentDTO);

        return ResponseEntity.ok(); // 200 OK
    }


    // get all subjects of a student
    @GetMapping("students/{stu_id}")
    public List<Subjects> getAllSubjects(@PathVariable Integer stu_id)
    {
        return studentService.getAllSubjectifStudent(stu_id);
    }

}
