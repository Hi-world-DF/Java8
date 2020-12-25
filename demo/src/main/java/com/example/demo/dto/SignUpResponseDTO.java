package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *  注册邮箱返回响应
 *
 * @author wangdf
 * @version 1.0, 2020/12/25
 * @since 1.0.0
 */
@Data
public class SignUpResponseDTO implements Serializable {

    /** 是否注册成功 */
    Boolean success;

    /** 成功返回userId */
    String userId;

    /** 错误信息 */
    String message;

}
