package com.shenzp.crontab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootTimer {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootTimer.class, args);
    }
}
