package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务
 *
 * @author wangdf
 * @version 1.0, 2020/12/22
 * @since 1.0.0
 */
@Service
public interface IUserService {

    /**
     * 获取User列表
     *
     * @return User List
     */
    List<User> getUserList();
}
