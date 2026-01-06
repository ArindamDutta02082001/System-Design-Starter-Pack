package com.example.patient.service;

import com.example.patient.dtos.MedicationDTO;
import com.example.patient.dtos.PatientDTO;
import com.example.patient.entities.Medication;
import com.example.patient.entities.Patient;
import com.example.patient.repository.MedicationRepository;
import com.example.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    PatientRepository patientRepository;

    MedicationRepository medicationRepository;

    PatientService( PatientRepository patientRepository , MedicationRepository medicationRepository)
    {
        this.patientRepository = patientRepository;
        this.medicationRepository = medicationRepository;
    }

    // register
    public boolean register(PatientDTO patientDTO )
    {
        Patient patient = Patient.builder()
                .age(patientDTO.getAge())
                .email(patientDTO.getEmail())
                .name(patientDTO.getName())
                .build();

        patientRepository.save(patient);
        return true;
    }

    public Optional<List<Patient>> getAllPatient()
    {
        return Optional.of(patientRepository.findAll());
    }


    public Optional<List<Medication>> getAllMedication(Integer id )
    {
        return Optional.of(patientRepository.findById(id).get().getMedications());
    }

    public String assignMedicine(Integer id , MedicationDTO medicationDTO)
    {
        Patient p = patientRepository.findById(id).get();

        if( p == null )
            return "No Patient with this id";

        Medication medication = Medication.builder()
                .dosage(medicationDTO.getDosage())
                .patient(p)
                .name(medicationDTO.getName())
                .build();

        medicationRepository.save(medication);

        return "medication given";
    }

}
