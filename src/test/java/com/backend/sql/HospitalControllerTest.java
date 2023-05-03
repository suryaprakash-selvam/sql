package com.backend.sql;

import com.backend.controller.HospitalController;
import com.backend.entity.Patient;
import com.backend.pojo.UserDetailsResponse;
import com.backend.repo.HospitalRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=HospitalControllerTest.class)
public class HospitalControllerTest {

    @Mock
    HospitalRepo hospitalRepo;

    @InjectMocks
    @Spy
    HospitalController classUnderTest = new HospitalController();

    @BeforeMethod
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllpatient(){
        List<Patient> result=new ArrayList<>();
         when(hospitalRepo.findAll()).thenReturn(result);
        List<Patient> patients= classUnderTest.getpatient();
        assertEquals(patients, result);
    }

    @Test
    public void getOnepatient(){
        Patient t=new Patient();
        t.setPatientEmail("s");
        when(hospitalRepo.findByPatientEmail(Mockito.any())).thenReturn(t);
        UserDetailsResponse d=classUnderTest.getPatient2("s");
        assertEquals(d.getPatient().getPatientEmail(),t.getPatientEmail());
    }

    @Test
    public void postpatient(){
        Patient t=new Patient();
        t.setPatientEmail("s");
        when(hospitalRepo.save(Mockito.any())).thenReturn(t);
        Patient d=classUnderTest.postpatient(t);
        assertEquals(d.getPatientEmail(),t.getPatientEmail());
    }

    @Test
    public void update(){
        Patient t=new Patient();
        t.setPatientEmail("s");
        when(hospitalRepo.updateStatusAndReturnDateAndDoctorNameAndPatientReasonByPatientEmail(Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(1);
        int d=classUnderTest.update(t);
        assertEquals(d,1);
    }

    @Test
    public void detuser(){
        when(hospitalRepo.deleteByPatientEmail(Mockito.any())).thenReturn(1);
        int d=classUnderTest.detuser("an");
        assertEquals(d,1);
    }

}
