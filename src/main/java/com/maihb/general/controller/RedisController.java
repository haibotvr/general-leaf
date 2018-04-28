package com.maihb.general.controller;

import com.maihb.general.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @GetMapping("name/{name}")
    public String getName(@PathVariable("name") String name){
        return redisService.getName(name);
    }

}
