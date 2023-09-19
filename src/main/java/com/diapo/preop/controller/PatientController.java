package com.diapo.preop.controller;

import com.diapo.preop.model.Patient;
import com.diapo.preop.repository.PatientRepository;
import com.diapo.preop.util.MyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    PatientRepository patientRepository;
    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/all")
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public String getPatient(@PathVariable Long id) throws JsonProcessingException {
        return MyUtil.patientToJson(patientRepository.findById(id).get());
    }

    @GetMapping("/unino/{unitNo}")
    public Patient getPatientByUnitNo(@PathVariable Long unitNo) {
        return patientRepository.findByUnitNo(unitNo);
    }

    @GetMapping("/answerbyid/{id}")
    public String getPatientAnswersById(@PathVariable Long id) throws JsonProcessingException {
        return MyUtil.patientAnswerToJson(patientRepository.findById(id).get().getAnswerList());
    }

    @GetMapping("/answerbyunitno/{id}")
    public String getPatientAnswersByUnitNo(@PathVariable Long id) throws JsonProcessingException {
        return MyUtil.patientAnswerToJson(patientRepository.findByUnitNo(id).getAnswerList());
    }

    @PostMapping
    public String savePatient(@RequestBody Patient patient) {
        patientRepository.save(patient);
        return "patient saved successfully";
    }

    @PutMapping
    public String updatePatient(@RequestBody Patient patient) {
        patientRepository.save(patient);
        return "patient saved successfully";
    }
}
