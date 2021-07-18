package com.xubo.learn.kuangshen.juc;

/**
 * @Author Xubo
 * @Date 2021/6/2 22:21
 * 获取cpu的核数
 * 180
 */
public class GetCPUs {

    public static void main(String[] args) {
        // 获取cpu的核数
        // cpu密集型、IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


}
