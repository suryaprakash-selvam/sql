package com.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false,unique = true)
    private Long id;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_email",nullable = false)
    private String patientEmail;

    @Column(name = "patient_reason")
    private String patientReason;

    @Column(name = "status")
    private String status;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "admitted_date")
    private String admittedDate;

    @Column(name = "return_date")
    private String returnDate;


    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getAdmittedDate() {
        return admittedDate;
    }

    public void setAdmittedDate(String admittedDate) {
        this.admittedDate = admittedDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPatientReason() {
        return patientReason;
    }

    public void setPatientReason(String patientReason) {
        this.patientReason = patientReason;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
