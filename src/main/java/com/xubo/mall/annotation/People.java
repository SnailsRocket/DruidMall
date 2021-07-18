package com.xubo.mall.annotation;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/22 下午 01:37
 * 自定义注解
 *
 */
public class People {

    @PeopleAnnotation(name="Druid",age=23,score = {98,92,90})
    public void study(int iteams) {
        for (int i = 0; i < iteams; i++) {
            System.out.println("stay hangury stay study ");
        }
    }
}
