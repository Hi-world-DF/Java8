package com.example.demo.service;

import com.example.demo.dto.SignUpResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * 用户服务
 *
 * @author wangdf
 * @version 1.0, 2020/12/22
 * @since 1.0.0
 */
public interface IUserService {

    /**
     * 获取User列表
     *
     * @return User List
     */
    List<User> getUserList();

    /**
     * 通过id获取User
     *
     * @param id User id
     * @return User Optional
     */
    Optional<User> getUserById(Long id);

    /**
     * 保存useDTO数据
     *
     * @param userDTO 用户DTO
     * @return
     */
    int save(UserDTO userDTO);

    /**
     * 邮箱登陆：分布式锁练习
     *
     * @param email 邮箱
     * @return SignUpResponseDTO 返回登陆响应对象
     */
    SignUpResponseDTO signUp(String email);

}
