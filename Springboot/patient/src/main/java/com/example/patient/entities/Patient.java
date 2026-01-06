package com.example.patient.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;

    Integer age;

    String email;

    @OneToMany(mappedBy = "patient" , cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    @JsonIgnoreProperties("patient")
    @JsonIgnore
    List<Medication> medications;
}
