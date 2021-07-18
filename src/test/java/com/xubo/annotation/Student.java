package com.xubo.mall.annotation;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/22 下午 03:21
 */
public class Student {

    @PeopleAnnotation(name = "Druid",age = 24,score = {99,91})
    public void fun(int iteam) {
        for (int i = 0; i < iteam; i++) {
            System.out.println("fighting...");
        }

    }

}
