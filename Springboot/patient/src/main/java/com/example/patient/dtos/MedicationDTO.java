package com.example.patient.dtos;

import com.example.patient.entities.Patient;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MedicationDTO {


    String name;

    String dosage;

}
