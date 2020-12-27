package com.example.demo.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StringPractice {

    /**
     * 题目要求：对于输入的字符串s，忽略大小写，
     * 返回按照英文字母出现频率从高到低排序的小写字符串，对于出现次数相同的字母，按照字典序排序。
     * 如果输入的字符串不包含英文字母，返回空字符串。注意数字，标点，空格都不是英文字母。
     */

    public String mostFrequentLetters(String s) {

        /**
         * 1.先做切分，每个字符切分出来
         * 2.然后映射到map，统计每个字符的出现频率
         */
        Map<String, Long> map = Stream.of(s)
                .map(o -> o.split(""))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        //按照value排序
        map = map.entrySet().stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        //如果值相等，那么就按键值的字典序排
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        //否则按照值逆序，从大到小排
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (key, value) -> key,
                        LinkedHashMap::new));

        //遍历map中的key值，将字母按照要求输出，其他字符过滤掉
        StringBuilder sb = new StringBuilder();
        for (String s1 : map.keySet()) {
            char c = s1.charAt(0);
            if (c >= 97 && c <= 122) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
