package com.shenzp.springboot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jacle
 * @version 1.0
 * @description: Muser
 * @date 2021/12/30 16:13
 */
public class Muser {
    @JsonProperty("JsonName")
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", age=" + age + "]";
    }
}
