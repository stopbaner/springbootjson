package com.shenzp.crontab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/annotation")
public class AnnotationController {

    @Scheduled(cron = "0/5 * * * * *")
    @Async("taskExecutor")
    public void scheduleOne(){
        log.info("cron表达式开始使用{}",System.currentTimeMillis());
    }

    @Scheduled(fixedRate = 5000)
    public void scheduleTwo(){
        log.info("fixedRate设置{}",System.currentTimeMillis());
    }

    @Scheduled(fixedDelay =5000)
    public void scheduleThree(){
        log.info("fixedDelay设置{}",System.currentTimeMillis());
    }


}
