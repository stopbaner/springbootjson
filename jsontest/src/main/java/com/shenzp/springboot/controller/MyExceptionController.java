package com.shenzp.springboot.controller;

import com.shenzp.springboot.config.MyException;
import com.shenzp.springboot.domain.Resp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice //处理controller中的自定义异常
@RequestMapping("/")
public class MyExceptionController {

    @ExceptionHandler(MyException.class)
    public Resp handlerException(MyException myException) {

        return Resp.fail("自定义全局异常处理："+myException.getMessage());
    }

    @RequestMapping("/testMyException")
    public void testMyException(){

        throw new MyException("我异常了");
    }

}
