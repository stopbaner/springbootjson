package com.shenzp.crontab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/schedule")
public class ScheduledController {

    @RequestMapping("/scheduleService")
    public void testScheduled(){
        ScheduledExecutorService scheduledExecutorService= Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(()->System.out.println("scheduledExecutorService...启动"),1,5, TimeUnit.SECONDS);
    }
}