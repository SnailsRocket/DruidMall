package com.xubo.exception;

import java.util.Scanner;

/**
 * @Author Druid_Xu
 * @Date 2020/12/23 下午 03:26
 * @Description
 * try catch 模块
 * 当try里面的语句出现了Exception 时，如果被catch到，try catch 模块下面的语句还是会执行的
 * 但是try模块中，从出现异常的那个语句开始，try中下面的语句不会执行，所以在try中尽量只放易出问题的语句
 */
public class TryExceptions {
    public static void main(String[] args) {
        System.out.println("请输入一个数");
        Scanner sc = new Scanner(System.in);
        try {
            int i = sc.nextInt();
            System.out.println("try");
        } catch (Exception e) {
            System.out.println("catch exception");
        }

        System.out.println("执行完毕");

    }
}
