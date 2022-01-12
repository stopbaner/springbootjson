package com.shenzp.springboot.controller;

import com.shenzp.springboot.domain.MyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/modelAttribute")
public class ModelAttrController {

    @ModelAttribute
    public void testModelAttribute(Model model) {
        log.info("执行modelAttribute注解标注的方法");
        model.addAttribute("name", "jack");
    }

    @RequestMapping("/testMsg")
    public @ResponseBody String testMsg() {
        return "msg";
    }

    @ModelAttribute("createMyUser")//初始化一个model对象，相当于init方法
    public MyUser createMyUser(){
        MyUser myUser=new MyUser();
        myUser.setName("bruce");
        myUser.setGender("1");
        return myUser;
    }

    //由@ModelAttribute注入，类似于springboot的initBinder
    @RequestMapping("/getMyUser")
    public @ResponseBody MyUser getMyUser(@ModelAttribute("createMyUser") MyUser myUser){
        return myUser;
    }



}
