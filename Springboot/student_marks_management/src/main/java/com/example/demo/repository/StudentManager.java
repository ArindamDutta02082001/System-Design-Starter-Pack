package com.example.demo.repository;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;



@Repository
public interface StudentManager extends JpaRepository<Student,Integer> {


}
