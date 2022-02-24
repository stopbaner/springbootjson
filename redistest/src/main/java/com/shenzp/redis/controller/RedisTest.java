package com.shenzp.redis.controller;

import com.shenzp.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: shenzp
 * @Date: 2022/2/23
 */
@RequestMapping("/")
@RestController
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/testRedis")
    public void testRedis() {
        redisUtil.set("name","jack");
        System.out.println(redisUtil.get("name"));
    }
}
