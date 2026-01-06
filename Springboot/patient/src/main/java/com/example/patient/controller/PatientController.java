package com.example.patient.controller;

import com.example.patient.dtos.MedicationDTO;
import com.example.patient.dtos.PatientDTO;
import com.example.patient.entities.Medication;
import com.example.patient.entities.Patient;
import com.example.patient.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {


    // ideally return DTOs should be there

    PatientService patientService;

    PatientController(PatientService patientService)
    {
        this.patientService = patientService;
    }

    // create new PatientDTO
    @PostMapping("/patients")
    public boolean register(@RequestBody PatientDTO patientDTO)
    {
       return patientService.register(patientDTO);
    }

    // get all patients
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAll()
    {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(patientService.getAllPatient().get());

    }

    // get all medication of a patient
    @GetMapping("/patients/{id}")
    public List<Medication> getAll(@PathVariable Integer id)
    {
        return patientService.getAllMedication(id).get();
    }

    // assign a medication to the user
    @PostMapping("/patients/{id}/medications")
    public Optional<String> assignMedication(@PathVariable Integer id , @RequestBody MedicationDTO medicationDTO)
    {
        return Optional.of(patientService.assignMedicine(id , medicationDTO));
    }

}
