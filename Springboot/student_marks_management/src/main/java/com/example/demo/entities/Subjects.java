package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subjects {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer subId ;

    String name;
    Double marks;

    @ManyToOne
    @JoinColumn(name = "sid") // ✅ FK column
    @JsonIgnore   // ✅ THIS LINE FIXES IT
    Student student;
}
