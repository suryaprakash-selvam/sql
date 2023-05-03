package com.backend.repo;

import com.backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface HospitalRepo extends JpaRepository<Patient, Long> {
    @Transactional
    @Modifying
    @Query("update Patient p set p.status = ?1, p.returnDate = ?2, p.doctorName = ?3, p.patientReason = ?4 " +
            "where p.patientEmail = ?5")
    int updateStatusAndReturnDateAndDoctorNameAndPatientReasonByPatientEmail(String status, String returnDate, String doctorName, String patientReason, String patientEmail);

    @Transactional
    @Modifying
    @Query("delete from Patient p where p.patientEmail = ?1")
    int deleteByPatientEmail(String patientEmail);

    @Query("select p from Patient p where p.patientEmail = ?1")
    Patient findByPatientEmail(String patientEmail);


}
