package com.maihb.general.service.serviceimpl;

import com.maihb.general.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getName(String name) {
        stringRedisTemplate.opsForValue().set("name", name);
        return stringRedisTemplate.opsForValue().get("name");
    }
}
