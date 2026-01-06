package com.example.patient.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer _mid;

    String name;

    String dosage;

    @ManyToOne
    @JoinColumn(name = "id")
    Patient patient;
}
