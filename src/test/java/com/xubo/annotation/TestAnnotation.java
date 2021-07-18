package com.xubo.mall.annotation;

import java.lang.reflect.Method;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/22 下午 01:50
 * 这个注解 不能定义在test目录下
 *
 */
public class TestAnnotation {
    
    public static void main(String[] args) {
//        isAnnotationMethod1();

        isAnnotationMethod2();

    }

    private static void isAnnotationMethod2() {
        try {
            Class<?> stuClass = Class.forName("com.xubo.mall.annotation.Student");

            Method funMethod = stuClass.getMethod("fun", int.class);

            if(funMethod.isAnnotationPresent(PeopleAnnotation.class)) {
                System.out.println("Student 类里面使用了 PeopleAnnotation注解");
                PeopleAnnotation stuAnnotations = funMethod.getAnnotation(PeopleAnnotation.class);
                System.out.println(stuAnnotations.name() + " " +
                        stuAnnotations.age() + " " + stuAnnotations.score());
            } else {
                System.out.println("该方法上没有使用注解！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("退出try catch");
        }
    }

    private static void isAnnotationMethod1() {
        try {
//        通过反射，获取People的class对象
            Class<?> peopleClass = Class.forName("com.xubo.mall.annotation.People");

//        思考为什么形参不能写成Integer.class
            Method studyMethod = peopleClass.getMethod("study", int.class);

            if(studyMethod.isAnnotationPresent(PeopleAnnotation.class)) {
                System.out.println("People类上配置了PeopleAnnotation注解");
    //        获取该元素上指定类型的注解
                PeopleAnnotation peopleAnnotation = studyMethod.getAnnotation(PeopleAnnotation.class);

                System.out.println(peopleAnnotation.name() + "  " +
                        peopleAnnotation.age() + "  " + peopleAnnotation.score());


            } else {
                System.out.println("该方法上没有注解");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("test完毕");
        }
    }

}
