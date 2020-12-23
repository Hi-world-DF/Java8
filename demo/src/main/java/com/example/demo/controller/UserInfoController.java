package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * User 信息控制层
 *
 * @version 1.0, 2020/12/22
 * @authr wangdf
 * @since 1.0.0
 */
@RestController
@RequestMapping
public class UserInfoController {

    @Autowired(required = true)
    private IUserService userService;

    @GetMapping(value = "/getall")
    public List<User> getAllUser() {
        return userService.getUserList();
    }

    @GetMapping(path = "/getone/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id).get();
    }

    @GetMapping(value = "/save")
    public void save(@RequestBody @Validated UserDTO userDTO) {
        if (0 != userService.save(userDTO)) {
            System.out.println("保存成功！！！");
        }
    }

    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "hello world！！";
    }


}
