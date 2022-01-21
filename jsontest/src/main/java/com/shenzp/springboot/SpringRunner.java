package com.shenzp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @描述
 * @创建人 szp
 * @修改人和其它信息
 */
@SpringBootApplication
//注解实现对指定包下@WebServlet,@WebFilter,@WebListener组件的扫描
@ServletComponentScan("com.shenzp.springboot")
public class SpringRunner {
    public static void main(String[] args){
        SpringApplication.run(SpringRunner.class, args);
    }
}
