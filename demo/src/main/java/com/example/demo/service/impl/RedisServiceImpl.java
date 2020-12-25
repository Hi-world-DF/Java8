package com.example.demo.service.impl;

import com.example.demo.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis服务实现
 *
 * @author wangdf
 * @version 1.0, 2020/12/23
 * @since 1.0.0
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /** {@inheritDoc} */
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /** {@inheritDoc} */
    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /** {@inheritDoc} */
    @Override
    public boolean exit(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /** {@inheritDoc} */
    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /** {@inheritDoc} */
    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    /** {@inheritDoc} */
    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }
}
