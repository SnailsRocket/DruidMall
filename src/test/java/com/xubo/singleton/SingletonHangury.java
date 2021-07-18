package com.xubo.singleton;

/**
 * @Author Druid_Xu
 * @Date 2020/12/3 上午 09:24
 * @Description
 * 单例模式 饿汉模式
 */
public class SingletonHangury {

    private SingletonHangury singletonHangury = new SingletonHangury();

    private SingletonHangury() {
    }

    public SingletonHangury getInstance() {
        return this.singletonHangury;
    }
}
