package com.backend.controller;

import com.backend.entity.Patient;
import com.backend.pojo.UserDetailsResponse;
import com.backend.repo.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class HospitalController {

    @Autowired
    private HospitalRepo hospitalRepo;

    @PostMapping("patientpost")
    public Patient postpatient(@RequestBody Patient patient){
        return hospitalRepo.save(patient);
    }


    public String newmethod() throws SQLDataException {
        SqlController se=new SqlController();

        return "sm";
    }
    @GetMapping("getPatient")
    public List<Patient> getpatient(){
        List<Patient> fi=hospitalRepo.findAll();
        fi.forEach(a->{
            if(a.getStatus() == "success"){

            }
            System.out.println(a.getPatientEmail());
        });
        return hospitalRepo.findAll();
    }

    @GetMapping("getonepatient/{id}")
    public UserDetailsResponse getPatient2(@PathVariable String id){

        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        Patient patient = hospitalRepo.findByPatientEmail(id);

        if(patient!=null){
            userDetailsResponse.setStatus("true");
            userDetailsResponse.setPatient(patient);
            return userDetailsResponse;
        }else{
            userDetailsResponse.setStatus("false");
            userDetailsResponse.setMsg("No available");
            return userDetailsResponse;
        }

    }

    @PatchMapping("updateTreatment")
    public int update(@RequestBody Patient patient){
        return hospitalRepo.updateStatusAndReturnDateAndDoctorNameAndPatientReasonByPatientEmail(patient.getStatus(),patient.getReturnDate(),patient.getDoctorName(),patient.getPatientReason(),patient.getPatientEmail());
    }

    @DeleteMapping("deletepatient/{id}")
    public int detuser(@PathVariable String id){
        return hospitalRepo.deleteByPatientEmail(id);
    }
}
