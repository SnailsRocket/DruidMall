package com.xubo.jdk8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xubo
 * @Date 2021/5/16 0:18
 * 大学组织一个活动
 * 一个团队有十三个学生
 * 根据高中的学校，年纪，专业做归并
 */
public class StreamDemo1 {

    public static void main(String[] args) {
        Man man01 = new Man(1, "school01", "gouyi", "18", "type01");
        Man man02 = new Man(2, "school01", "maoer", "18", "type02");
        Man man03 = new Man(3, "school01", "zhangsan", "19", "type01");
        Man man04 = new Man(4, "school02", "lisi", "19", "type01");
        Man man05 = new Man(5, "school02", "wangwu", "19", "type01");
        Man man06 = new Man(6, "school02", "zhaoliu", "18", "type01");
        Man man07 = new Man(7, "school02", "houqi", "18", "type01");
        Man man08 = new Man(8, "school03", "zhouba", "19", "type01");
        Man man09 = new Man(9, "school03", "liangjiu", "18", "type01");
        Man man10 = new Man(10, "school03", "jiashi", "18", "type01");
        Man man11 = new Man(11, "school03", "bishiyi", "18", "type01");
        Man man12 = new Man(12, "school03", "mashier", "18", "type01");
        Man man13 = new Man(13, "school04", "hanshisan", "18", "type01");

        List<Man> manList = Arrays.asList
                (man01, man02, man03, man04, man05, man06, man07, man08, man09, man10, man11, man12, man13);
        // 第一个String是 学校 ，第二个是 年级 第三个是专业
        Map<String, Map<String, List<Man>>> collect = null;
        collect = manList.stream().collect(Collectors.groupingBy(Man::getSchool, Collectors.groupingBy(Man::getClassYear)));
        System.out.println(collect);


    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Man {
    private int id;
    private String school;
    private String name;
    private String classYear;
    private String major;
}
