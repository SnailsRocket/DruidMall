package com.xubo.mall.annotation;

import java.lang.annotation.*;

/**
 * @Author Administrator
 * @Date 2021/7/12 17:38
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExportProperty {

    // 定义excel头部信息
    String[] value() default{""};

    // 定义cell的格式 1 金额  2 日期(yyyy/MM/dd) 3 百分比
    short type() default -1;

}
