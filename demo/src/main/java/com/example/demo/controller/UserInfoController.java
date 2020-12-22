package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * TODO
 *
 * @author wangdf
 * @version 1.0, 2020/12/22
 * @since 1.0.0
 */

@Controller
public class UserInfoController {

    @Autowired
    private IUserService iUserService;

    List<User> getAllUser() {
        return iUserService.getUserList();
    }
}
