package com.example.demo.controller;

import com.example.demo.dto.SignUpResponseDTO;
import com.example.demo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 邮箱注册控制
 *
 * @author wangdf
 * @version 1.0, 2020/12/25
 * @since 1.0.0
 */

@RestController
@RequestMapping("/signup")
public class RedissonLockController {

    @Autowired
    private IUserService userService;

    @GetMapping(path = "/lock/{email}")
    @ResponseBody
    public String signUpByEmail(@PathVariable("email") String email) {
        SignUpResponseDTO resultDto = userService.signUp(email);
        return "{" + resultDto.getSuccess() + " : " + resultDto.getUserId() + " : " + resultDto.getMessage() + "}";
    }
}
