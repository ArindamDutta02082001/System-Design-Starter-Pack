package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entities.Student;
import com.example.demo.entities.Subjects;
import com.example.demo.repository.StudentManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentManager studentManager ;

    public StudentService(StudentManager studentManager)
    {
        this.studentManager = studentManager;
    }

    // utility method to stre students in reository layer
    public Integer addStudent(StudentDTO studentDTO)
    {

        if(studentDTO == null) return null;

        Student s1 = Student.builder()
                .age(studentDTO.getAge())
                .name(studentDTO.getName())

                .build();

        studentManager.save(s1);

        return s1.getSid();
    }

    // find a student by id
    public Optional<Student> findStudentById(Integer id) {
        return studentManager.findById(id);
    }

    public void updateStudent(Integer id, StudentDTO studentDTO) {

        Optional<Student> s1 = studentManager.findById(id);
                s1 = Optional.ofNullable(Student.builder()
                        .age(studentDTO.getAge())
                        .name(studentDTO.getName())
                        .build());

        studentManager.save(s1.get());

    }

    // get all subjects of a student
    public List<Subjects> getAllSubjectifStudent(Integer id) {
        return studentManager.findById(id).get().getAllSubs();
    }


    // remove

}
