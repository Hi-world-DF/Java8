package com.example.demo.entity;

import lombok.Data;

/**
 * 用户测试实体类
 *
 * @author Ernest
 * @version 1.0, 10/1/2021
 * @since 1.0.0
 */
@Data
public class UserTest {

    /** 用户id */
    private int id;
    /** 用户姓名 */
    private String name;
    /** 用户密码 */
    private String password;
}
