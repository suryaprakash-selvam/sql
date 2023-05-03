package com.backend.sql;

import com.backend.pojo.pojo;
import com.backend.repo.HospitalRepo;
import com.backend.service.HosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TcController {

    @Autowired
    HosServices hs;

    @GetMapping("sri")
    public pojo get(@RequestParam String hi, @RequestHeader String lang){
        pojo poj=new pojo();
        poj.setA(hs.sf(),lang);
        return poj;
    }

}
