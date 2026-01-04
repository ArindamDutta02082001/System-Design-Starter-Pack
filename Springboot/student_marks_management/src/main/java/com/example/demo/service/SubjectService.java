package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.SubjectDTO;
import com.example.demo.entities.Student;
import com.example.demo.entities.Subjects;
import com.example.demo.repository.StudentManager;
import com.example.demo.repository.SubjectManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

    SubjectManager subjectManager ;

    public SubjectService(SubjectManager subjectManager)
    {
        this.subjectManager = subjectManager;
    }

    // utility method to stre students in reository layer
    public void addSubject(SubjectDTO subjectDTO , Student student)
    {

        if(subjectDTO == null);

        Subjects subjects = Subjects.builder()
                .name(subjectDTO.getName())
                .marks(subjectDTO.getMarks())
                .student(student)
                .build();

        subjectManager.save(subjects);
    }


    // remove

}
