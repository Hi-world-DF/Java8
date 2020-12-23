package com.example.demo.service.impl;

import com.example.demo.service.IMfaCodeService;
import com.example.demo.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Random;

/**
 * TODO
 *
 * @author wangdf
 * @version 1.0, 2020/12/23
 * @since 1.0.0
 */
@Service
public class MfaCodeServiceImpl implements IMfaCodeService {

    @Autowired
    private IRedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public boolean generateCode(Long userId) {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }

        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + userId, sb.toString());
        return redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + userId, AUTH_CODE_EXPIRE_SECONDS);
    }

    @Override
    public boolean valid(Long userId, String code) {
        if(StringUtils.isEmpty(code)) {
            return false;
        }
        String realCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + userId);
        return code.equals(realCode);
    }
}
