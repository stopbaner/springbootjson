package com.shenzp.springboot.controller;


import com.shenzp.springboot.domain.MyUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {

    @RequestMapping("/createUser")
    public MyUser createUser(){
        MyUser myUser=new MyUser();
        myUser.setName("null");
        myUser.setAge(null);
        myUser.setGender("1");
        return myUser;
    }

    @RequestMapping("/createUserJson")
    public ResponseEntity<MyUser> createUserJson(){
        return ResponseEntity.ok(MyUser.initMyUser());
    }


}
