package com.shenzp.crontab.config;

import com.shenzp.crontab.quartz.QuartzTaskOne;
import com.shenzp.crontab.quartz.QuartzTaskTwo;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail testQuartzTaskOne() {

        return JobBuilder.newJob(QuartzTaskOne.class)
                .withIdentity("QuartzTaskOne")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger testQuartzTaskOneTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();
        return TriggerBuilder.newTrigger()
                .forJob(testQuartzTaskOne())
                .withIdentity("QuartzTaskOne")
                .withSchedule(simpleScheduleBuilder)
                .build();

    }

    @Bean
    public JobDetail testQuartzTaskTwo() {

        return JobBuilder.newJob(QuartzTaskTwo.class)
                .withIdentity("QuartzTaskTwo")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger testQuartzTaskTwoTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(testQuartzTaskTwo())
                .withIdentity("QuartzTaskTwo")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .build();
    }
}
