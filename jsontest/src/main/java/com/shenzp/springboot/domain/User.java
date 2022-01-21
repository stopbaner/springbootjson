package com.shenzp.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * localdate和localdatetime序列化之后，json字符串很长，此时进行反序列化是会出现错误
 * {
 * "month": "DECEMBER",
 * "year": 2021,
 * "dayOfMonth": 31,
 * "hour": 10,
 * "minute": 39,
 * "monthValue": 12,
 * "nano": 327000000,
 * "second": 4,
 * "dayOfWeek": "FRIDAY",
 * "dayOfYear": 365,
 * "chronology": {
 * "id": "ISO",
 * "calendarType": "iso8601"
 * }* 	}
 */
@Slf4j
@Data
public class User {
    private Integer id;

    @Length(min = 1, max = 10, message = "名字长度1-10")
    //@NotNull(message = "姓名不能为空")
    private String name="";

    @Min(value = 0, message = "不能小于0岁")
    @Max(value = 150, message = "不能超过150岁")
    private Integer age=-1;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime birthday;

    private Date studyDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate workDate;

    private Calendar firstWorkDate;

    private Double salary;

    public User() {

    }

    public User(Double salary) {
        this.salary = salary;
    }

    public static User buildOne() {
        User user = new User();

        LocalDateTime now = LocalDateTime.now();
        user.setWorkDate(now.plusYears(25).toLocalDate());
        user.setStudyDate(Date.from(now.plusYears(5).atZone(ZoneId.systemDefault()).toInstant()));
//        user.setName("姓名-" + new Random(200).toString());

        user.setName(null);
        user.setAge(new Random(100).nextInt());
        user.setBirthday(now);
        user.setFirstWorkDate(Calendar.getInstance());

        return user;
    }

    @PostConstruct
    public void prt() {
        log.info("create user bean ...");

    }
    //getter and setter...
}