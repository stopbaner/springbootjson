package com.shenzp.redis.controller;

import com.shenzp.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        Map map=new HashMap<String,Object>();
        map.put("one","1");
        map.put("two",2);
        map.put("three","3");
        redisUtil.set("map",map);
        HashMap map1 = (HashMap) redisUtil.get("map");
        map1.forEach((k,v)-> System.out.println("key:"+k+" value:"+v));

        redisUtil.set("name","jack");
        System.out.println(redisUtil.get("name"));
    }
}
