package com.example.demo.repository;

import com.example.demo.entities.Student;
import com.example.demo.entities.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public interface SubjectManager extends JpaRepository<Subjects,Integer> {


    // get all the subjects of a particular student


}
