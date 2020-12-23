package com.example.demo.service;

/**
 * TODO
 *
 * @author wangdf
 * @version 1.0, 2020/12/23
 * @since 1.0.0
 */
public interface IMfaCodeService {

    /**
     * 生成验证码
     *
     * @param userId 用户id
     * @return 成功 true 失败 false
     */
    boolean generateCode(Long userId);

    /**
     * 校验验证码
     *
     * @param userId 用户id
     * @param code 验证码
     * @return 成功 true 失败 false
     */
    boolean valid(Long userId, String code);
}
