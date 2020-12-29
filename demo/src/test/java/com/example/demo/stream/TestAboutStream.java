package com.example.demo.stream;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.UserTest;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class TestAboutStream {

    List<UserTest> users = Arrays.asList(
            new UserTest(1, "fish", "fish111"),
            new UserTest(2, "dog", "dog456"),
            new UserTest(3, "cat", "cat123")
    );

    /**
     * Stream操作的三个步骤：
     * 1.创建Stream
     * 2.中间操作
     * 3.终止操作
     *
     * */

    /**
     * 创建Stream的方式
     */
    @Test
    public void testStreamAPI1() {

        /** 方式1：通过Collection系列的集合的stream() */
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        /** 方式2：通过Arrays中的静态方法stream()创建数组流 */
        User[] users = new User[10];
        Stream<User> stream2 = Arrays.stream(users);

        /** 方式3：通过stream类中的静态方法 of() */
        Stream<String> stream3 = Stream.of("abc", "def", "ghi");

        /** 方式4：创建无限流 */
        /** 迭代 */
        Stream<Integer> stream4 = Stream.iterate(100, x -> x + 2).limit(5);
        stream4.forEach(System.out::println);

        /** 生成 */
        Stream<Double> stream5 = Stream.generate(() -> Math.random()).limit(5);
        stream5.forEach(System.out::println);
    }

    /**
     * 中间操作:筛选和切片
     * 1.filter--接受Lambda，从流中排除某些元素
     * 2.limit--截断流，限制流元素的数量
     * 3.skip--跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，返回空流；与limit互补
     * 4.distinct--去重，通过生成元素的hashCode()和equals()判断
     */
    @Test
    public void testStreamAPI2() {

        Stream<UserTest> stream = users.stream()
                .filter(u -> u.getName() != "dog");

        stream.forEach(System.out::println);
    }

}
