package com.backend.controller;

import com.backend.entity.UserDetail;
import com.backend.pojo.Constant;
import com.backend.pojo.UserDetailsResponse;
import com.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class SqlController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("getAllUser")
    private List<UserDetail> getUser(){

        return userRepo.findAll();
    }

    @GetMapping("user/{id}")
    private UserDetail gtUser(@PathVariable String id){
        return userRepo.findByUserName(id);
    }

    @GetMapping("login/{userName}/{pwd}")
    public UserDetailsResponse login(@PathVariable String userName, @PathVariable String pwd) throws SQLDataException {

        UserDetailsResponse us=new UserDetailsResponse();
        UserDetail use= userRepo.findByUserNameAndPassword(Constant.var,pwd);
        if(use!= null){
            us.setStatus("true");
            us.setUserDetail(use);
            return us;
        }else{
            us.setStatus("false");
            us.setMsg("No User Find");
            return us;
        }
    }
    @PutMapping("reset/{id}/{pwd}")
    private int forpwdser(@PathVariable String id,@PathVariable String pwd){
        return userRepo.updatePasswordByUserName(pwd,id);
    }

    @PostMapping("user")
    private UserDetailsResponse saveUser(@RequestBody UserDetail user){
       try{
           UserDetailsResponse userd=new UserDetailsResponse();
           UserDetail use= userRepo.save(user);
           userd.setStatus("true");
           userd.setUserDetail(use);
           return userd;
       }catch(Exception e){
           UserDetailsResponse userd=new UserDetailsResponse();
           userd.setStatus("false");
           userd.setMsg(String.valueOf(e));
           System.out.println(e.hashCode());
           return userd;
       }
    }

    @DeleteMapping("deleteUser/{id}")
    private int detuser(@PathVariable long id){
        return userRepo.deleteByUserId(id);
    }
}
