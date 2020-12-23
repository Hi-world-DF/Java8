package com.example.demo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * User传输对象
 *
 * @author wangdf
 * @version 1.0, 2020/12/23
 * @since 1.0.0
 */
@Data
public class UserDTO implements Serializable {

    /** 用户id */
    private Long id;

    /** 用户手机号 */
    @NotBlank(message = "用户手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String mobile;

    /** 用户邮箱 */
    @NotBlank(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不对")
    private String email;

    /** 用户名 */
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名不能超过20个字符")
    private String username;

    /** 用户昵称 */
    private String nickname;

    /** 用户密码 */
    @NotBlank(message = "用户密码不能为空")
    private String password;

    /** 创建时间 */
    private LocalDateTime created;

}
