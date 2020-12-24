package com.example.demo.controller;

import com.example.demo.service.IMfaCodeService;
import com.example.demo.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证码使用
 *
 * @author wangdf
 * @version 1.0, 2020/12/24
 * @since 1.0.0
 */
@RestController
@RequestMapping("/code")
public class MfaCodeController {

    @Autowired
    private IMfaCodeService mfaCodeService;

    @Autowired
    private IRedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String VERIFICATION_CODE;

    @GetMapping(path = "/getcode/{id}")
    @ResponseBody
    public String getCode(@PathVariable("id") Long userId) {
        Boolean result = mfaCodeService.generateCode(userId);
        String code = redisService.get(VERIFICATION_CODE + userId);
        return "userId: " + userId + ", code: " + code + ", result: " + result;
    }

    @GetMapping(path = "/checkcode/{id}/{code}")
    @ResponseBody
    public boolean checkCode(@PathVariable("id") Long userId, @PathVariable("code") String code) {
        return mfaCodeService.valid(userId, code);
    }
}
