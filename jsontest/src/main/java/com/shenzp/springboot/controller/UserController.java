package com.shenzp.springboot.controller;


import com.shenzp.springboot.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class UserController {

    @RequestMapping("/getUser")
    public void getUser(@Valid User user){

    }

}
