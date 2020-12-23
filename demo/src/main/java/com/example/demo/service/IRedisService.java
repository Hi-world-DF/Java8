package com.example.demo.service;

/**
 * Redis服务
 *
 * @author wangdf
 * @version 1.0, 2020/12/23
 * @since 1.0.0
 */
public interface IRedisService {

    /**
     * 存储数据
     *
     * @param key 键
     * @param value 值
     */
    void set(String key, String value);

    /**
     * 获取数据
     *
     * @param key 键
     * @return String 值
     */
    String get(String key);

    /**
     * 设置超时时间
     *
     * @param key 键
     * @param expire 时间
     * @return 返回true/false 是否超时
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     *
     * @param key 键
     */
    void remove(String key);

    /**
     * 自增操作
     *
     * @param key 键
     * @param delta 自增步长
     * @return Long 自增值
     */
    Long increment(String key, long delta);

}
