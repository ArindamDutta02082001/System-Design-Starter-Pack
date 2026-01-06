package com.example.patient.dtos;


import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class PatientDTO {



    String name;

    Integer age;

    String email;


}
