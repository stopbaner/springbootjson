package com.shenzp.springboot.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {

    private String name;

    /**
     * Include.ALWAYS 属性都序列化
     * Include.NON_DEFAULT 属性为默认值不序列化
     * Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化
     * Include.NON_NULL 属性为NULL 不序列化
     */
    //属性为空时不显示字段,可配置类进行全局拦截
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer age;

    //更改key的名称
    @JsonProperty("key")
    private String gender;

    //日期的格式化
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate birthday;

    //忽略设置
    @JsonIgnore
    private LocalDate schoolDay;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime showTime;

    private Calendar workDate;

    public static MyUser initMyUser() {
        MyUser myUser = new MyUser();
        myUser.setName(null);
        myUser.setAge(new Random().nextInt(20));
        myUser.setBirthday(LocalDate.now());
        myUser.setShowTime(LocalDateTime.now());
        myUser.setWorkDate(Calendar.getInstance());
        myUser.setSchoolDay(LocalDate.now().plusYears(20).plusMonths(12).plusDays(31));
        return myUser;
    }
}
