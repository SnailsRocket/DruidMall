package com.xubo.mall.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author Druid_Xu
 * @Date 2020.9.22
 *
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)  // 之前定义的是 class code无法编译
@Documented
@Inherited
public @interface PeopleAnnotation {

    String name();
    int age() default 18;
    int[] score();

}
