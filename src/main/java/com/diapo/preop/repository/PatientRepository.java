package com.diapo.preop.repository;

import com.diapo.preop.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
//    List<Patient> findAllByUnitNoNotEmpty();
    Patient findByUnitNo(Long unitNo);

}
