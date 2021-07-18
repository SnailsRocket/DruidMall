package com.xubo.jdk8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xubo
 * @Date 2021/5/15 23:53
 * jdk8 新特性 之 Stream lambda
 *  题目要求:一分钟内完成此题，只能用一行代码实现!
 *      现在有5个用户!筛选:
 *       1、ID必须是偶数
 *       2、年龄必须大于60岁
 *       3、用户名转为大写字母
 *       4、用户名字母倒着排序
 *       5、只输出一个用户!
 */
public class StreamDemo {

    public static void main(String[] args) {
        User u1 = new User(1, "a", 13);
        User u2 = new User(2, "b", 33);
        User u3 = new User(3, "x", 23);
        User u4 = new User(4, "r", 63);
        User u5 = new User(5, "t", 18);
        User u6 = new User(6, "k", 69);
        User u7 = new User(7, "p", 20);
        User u8 = new User(8, "q", 25);
        List<User> users = Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8);
        users.stream().filter(u -> {return u.getId() % 2 == 0;})
                // return 的是大于60的 User对象
                .filter(u -> {return u.getAge() > 60;})
                // 这个时候stream流中 map方法 将 User 转换成 String return 的是一个字符串
                .map(u -> {return u.getName().toUpperCase();})
                // 字母顺序排列
                .sorted((uu1, uu2) -> {return uu1.compareTo(uu2);})
                .limit(1)
                .forEach(System.out::print);
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    private int id;
    private String name;
    private int age;
}
