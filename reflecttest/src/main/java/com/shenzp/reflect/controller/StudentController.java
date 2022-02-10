package com.shenzp.reflect.controller;

import com.shenzp.reflect.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: shenzp
 * @Date: 2022/2/10
 */
@RestController
public class StudentController {

    @RequestMapping("/reflectTest")
    public void reflectTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student=new Student();
        student.setAge(10);
        student.setName("helen");
        student.setGender(1);
        Class<? extends Student> studentClass = student.getClass();
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String fieldName = declaredField.getName();
            Method getMethod = studentClass.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            if(declaredField.getGenericType().toString().equals("class java.lang.Integer")){
                Integer integerField = (Integer) getMethod.invoke(student);
                System.out.println(integerField);
            }

        }

    }
}
