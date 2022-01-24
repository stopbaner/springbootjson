package com.shenzp.crontab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@RestController
@RequestMapping("/timer")
public class TimerController {

    @RequestMapping("/testTimer")
    public void testTimer(){
        log.info("testTimer.....");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                log.info("TimerTask...启动");
            }
        };
        Timer timer=new Timer();
        timer.schedule(timerTask,0,5000);
    }
}
