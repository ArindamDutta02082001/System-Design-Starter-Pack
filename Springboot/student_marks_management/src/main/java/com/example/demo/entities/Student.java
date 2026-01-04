package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer sid;

    String name;

    String age ;

    // List of Subjects
    @OneToMany(mappedBy = "student" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties( "student" )
    List<Subjects> allSubs = new ArrayList<>();


}
